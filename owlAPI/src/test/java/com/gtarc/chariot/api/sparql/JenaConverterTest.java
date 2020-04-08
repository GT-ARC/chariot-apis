package com.gtarc.chariot.api.sparql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Owner;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.RestEndpoint;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.exception.ISCOException;
import com.gtarc.chariot.api.model.spatialdata.FreeForm;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.Point;
import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataFactory;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;
import com.gtarc.chariot.api.model.util.sparql.JenaConverter;
import com.gtarc.chariot.api.model.util.sparql.SmartCityObjectVocabulary;

import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

public class JenaConverterTest {
	
	private static final String OWL_NAMESPACE = "http://isco-dev.aot.tu-berlin.de/ontologies/mobility/electricCar.goTo.owl#";
	private static final String ONTOLOGY_IRI1 = "http://example-ontology.de/ont.owl#";
	private static final String ONTOLOGY_IRI2 = "http://secondexample-ontology.de/Onto.owl#";
	private static final String VARIABLE2 = "x";
	private static final String VARIABLE1 = "y";
//	private static final String VARIABLE3 = "z";
	private static final String PROPERTY1 = "property1";
	private static final String PROPERTY2 = "property2";
	private static final String PROPERTY3 = "property3";
//	private static final String PROPERTY4 = "property4";
	private static final String TYPE = "ExampleClass";
	private static final Owner OWNER = Owner.PRIVATE;
	private static final IRI TYPE_IRI = IRI.create(ONTOLOGY_IRI1 + TYPE);
	private static final String ENDPOINT_URL_STRING = "http://endpoint.de/rest-intrface";
	private static final URI ENDPOINT_URI = createExampleEndpointUri();
	private static final Accessibility ACCESSIBILITY = Accessibility.OPEN;
	private static final String DEVICE_OWL_FILENAME = "temperatureSensor.owl";
	private static final String INVALID_OWL_MODEL_FILENAME = "smart_city.owl";
	private static final String SERVICE_OWL_FILENAME = "electricCar.goTo.owl";
	private static final String SERVICE_OWL_FILENAME2 = "getNearestWeatherReportService.owl";
	private static final String SERVICE_OWL_FILENAME3 = "Charging_station_service_3.owl";
	private static final List<Domain> DOMAINS = Arrays.asList(Domain.LIVING);
	private static final SWRLRule EFFECT = createExampleEffect(ONTOLOGY_IRI2);
	private static final List<Parameter> OUTPUTS1 = Arrays.asList(createExampleParameter());
	private static final Endpoint ENDPOINT = createExampleEndpoint();
	private static final Location LOCATION_MEASURING_DEVICE = SpatialdataFactory.eINSTANCE.createLocation();
	private static final Location LOCATION_ACTUATING_DEVICE = SpatialdataFactory.eINSTANCE.createLocation();
	private static final SpatialObject OPERATIONAL_AREA = createExampleOperationalArea();
	private static final Service SERVICE_NO_EFFECT =
			SmartCityObjectUtil.createService(OUTPUTS1, null, DOMAINS, ACCESSIBILITY, ENDPOINT);
	private static final Service SERVICE_NO_OUTPUTS =
			SmartCityObjectUtil.createService(null, EFFECT, DOMAINS, ACCESSIBILITY, ENDPOINT);
	private static final Parameter OUTPUT = createExampleParameter();
	private static final MeasuringMode MEASURING_MODE = MeasuringMode.BY_REQUEST;
	private static final Sensor SENSOR =
			SmartCityObjectUtil.createSensor(LOCATION_MEASURING_DEVICE, OPERATIONAL_AREA, OWNER, OUTPUT,
					MEASURING_MODE, DOMAINS, ACCESSIBILITY, TYPE_IRI, ENDPOINT);
	private static final Actuator ACTUATOR =
			SmartCityObjectUtil.createActuator(LOCATION_ACTUATING_DEVICE, OPERATIONAL_AREA, OWNER, EFFECT,
					DOMAINS, ACCESSIBILITY, TYPE_IRI, ENDPOINT);
	private static final int INT_VALUE = 5;
	private static final String STRING_VALUE = "string";
	
	private static Endpoint createExampleEndpoint() {
		RestEndpoint endpoint = DomainmodelFactory.eINSTANCE.createRestEndpoint();
		endpoint.setUri(ENDPOINT_URI);
		return endpoint;
	}
	
	private static Parameter createExampleParameter() {
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setType(TYPE_IRI);
		parameter.setLabel("output_1");
		return parameter;
	}

	private static URI createExampleEndpointUri() {
		return URI.create(ENDPOINT_URL_STRING);
	}

	private static Point createExampleOperationalArea() {
		Point point = SpatialdataFactory.eINSTANCE.createPoint();
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		point.setLocation(location);
		return point;
	}

	@Test
	public void testGetServiceObjectFromStatements() {
		Model model = RDFDataMgr.loadModel(SERVICE_OWL_FILENAME);
		SmartCityObject smartCityObject = null;
		try {
			smartCityObject = JenaConverter.convertToSmartCityObjects(model).iterator().next();
		} catch (ISCOException e) {
			fail(e.getClass() + " was thrown: " + e.getLocalizedMessage());
		}
		checkService(model, smartCityObject);
		Service service = (Service) smartCityObject;
		assertEquals(2, service.getInputs().size());
		SpatialObject region = service.getRegion();
		assertNotNull("Region of service is null!", region);
		assertTrue(region instanceof FreeForm);
		((FreeForm) region).getLocations().forEach(s->assertTrue("Region coordinates are empty!",
				s.getLatitude() > 0.0d));
		Model derived = JenaConverter.convertToJenaModel(smartCityObject, OWL_NAMESPACE);
		SmartCityObject smartCityObject2 = null;
		try {
			smartCityObject2 =
					JenaConverter.convertToSmartCityObjects(derived).iterator().next();
		} catch (ISCOException e) {
			fail(e.getClass() + " was thrown: " + e.getLocalizedMessage());
		}
//		derived.write(System.out, "RDF/XML");
		assertTrue(((Service) smartCityObject).getEffect().body().flatMap(atom->atom.allArguments())
				.anyMatch(arg->arg instanceof SWRLVariable));
		assertTrue(((Service) smartCityObject2).getEffect().body().flatMap(atom->atom.allArguments())
				.anyMatch(arg->arg instanceof SWRLVariable));
	}
	
	@Test
	public void testGetServiceObjectFromUri() {
		Model model = RDFDataMgr.loadModel(SERVICE_OWL_FILENAME2);
		SmartCityObject smartCityObject = null;
		try {
			smartCityObject = JenaConverter.convertToSmartCityObjects(SERVICE_OWL_FILENAME2).iterator().next();
		} catch (ISCOException e) {
			fail(e.getClass() + " was thrown: " + e.getLocalizedMessage());
		}
		checkService(model, smartCityObject);
		Service service = (Service) smartCityObject;
		assertEquals(1, service.getInputs().size());
		assertEquals(model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_CLASSIFICATION).next().toString(),
				smartCityObject.getClassification().toString());
		assertNull("Region of service is not null!", service.getRegion());
	}
	
	@Test
	public void testGetComplicatedServiceObjectFromUri() {
		Model model = RDFDataMgr.loadModel(SERVICE_OWL_FILENAME3);
		SmartCityObject smartCityObject = null;
		try {
			smartCityObject = JenaConverter.convertToSmartCityObjects(SERVICE_OWL_FILENAME3).iterator().next();
		} catch (ISCOException e) {
			fail(e.getClass() + " was thrown: " + e.getLocalizedMessage());
		}
		checkService(model, smartCityObject);
		Service service = (Service) smartCityObject;
		assertEquals(3, service.getInputs().size());
		assertNull("Region of service is not null!", service.getRegion());
	}

	private void checkService(Model model, SmartCityObject smartCityObject) {
		assertNotNull("Retrieved object is no smart city object: " + getType(model), smartCityObject);
		assertTrue("Retrieved object of type " + smartCityObject.getClass(), smartCityObject instanceof Service);
		assertEquals(model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_ID).next().toString(),
				smartCityObject.getId().toString());
		assertEquals(model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_LABEL).next().toString(),
				smartCityObject.getLabel());
		JenaConverter.convertToJenaModel(smartCityObject, ONTOLOGY_IRI1);
	}

	@Test
	public void testGetInvalidObject() {
		Model model = RDFDataMgr.loadModel(INVALID_OWL_MODEL_FILENAME);
		try {
			JenaConverter.convertToSmartCityObjects(model);
		} catch (ISCOException e) {
			return;
		}
		fail("An ISCOException was expected!");
	}
	
	@Test
	public void testGetDeviceObject() {
		Model model = RDFDataMgr.loadModel(DEVICE_OWL_FILENAME);
		SmartCityObject smartCityObject = null;
		try {
			Set<SmartCityObject> set = JenaConverter.convertToSmartCityObjects(model);
			assertTrue(set.size() == 1);
			smartCityObject = set.iterator().next();
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		assertNotNull("Retrieved object is no smart city object: " + getType(model), smartCityObject);
		assertTrue("Retrieved object of type " + smartCityObject.getClass(),
				smartCityObject instanceof Sensor);
		Sensor sensor = (Sensor) smartCityObject;
		assertNotNull("Group of measuring device is null!", sensor.getGroup());
		assertNotNull("Location of measuring device is null!", sensor.getLocation());
		assertNotNull("Endpoint of measuring device is null!", sensor.getEndpoint());
		Resource modelEndpoint =
				model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_ENDPOINT).next().asResource();
		String expectedUrl = model.listObjectsOfProperty(modelEndpoint,
				SmartCityObjectVocabulary.HAS_URL).next().asLiteral().getString();
		assertTrue(sensor.getEndpoint() instanceof RestEndpoint);
		assertEquals(expectedUrl, ((RestEndpoint) sensor.getEndpoint()).getUri().toString());
		JenaConverter.convertToJenaModel(smartCityObject, ONTOLOGY_IRI1);
	}

	private RDFNode getType(Model model) {
		return model.listStatements().filterKeep(s->s.getPredicate().equals(RDF.type)).next().getObject();
	}
	
	@Test
	public void testMinimalService() {
		Model jenaModel = JenaConverter.convertToJenaModel(SERVICE_NO_EFFECT, ONTOLOGY_IRI1);
//		jenaModel.write(System.out, "RDF/XML");
		checkJenaModelWithOriginalSmartCityObject(jenaModel, SERVICE_NO_EFFECT);
		jenaModel = JenaConverter.convertToJenaModel(SERVICE_NO_OUTPUTS, ONTOLOGY_IRI1);
		checkJenaModelWithOriginalSmartCityObject(jenaModel, SERVICE_NO_OUTPUTS);
	}

	private void checkJenaModelWithOriginalSmartCityObject(Model jenaModel, SmartCityObject original) {
		try {
			Set<SmartCityObject> set = JenaConverter.convertToSmartCityObjects(jenaModel);
			assertTrue(set.size() == 1);
			SmartCityObject derived = set.iterator().next();
			original.setIri(derived.getIri());
			if (original instanceof Service && ((Service) original).getEffect() != null) {
				((Service) original).setEffect(createExampleEffect(XMLUtils.getNCNamePrefix(derived.getIri())));
			} else if (original instanceof Actuator && ((Actuator) original).getEffect() != null) {
				((Actuator) original).setEffect(createExampleEffect(XMLUtils.getNCNamePrefix(derived.getIri())));
			}
			assertTrue(EcoreUtil.equals(original, derived));
		} catch (ISCOException e) {
			fail();
		}
	}
	
	@Test
	public void testMinimalActuator() {
		Model jenaModel = JenaConverter.convertToJenaModel(ACTUATOR, ONTOLOGY_IRI1);
		checkJenaModelWithOriginalSmartCityObject(jenaModel, ACTUATOR);
	}
	
	private static SWRLRuleImpl createExampleEffect(String namespace) {
		Set<SWRLAtom> head = new HashSet<>();
		Set<SWRLAtom> body = new HashSet<>();
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();
		OWLClass clsA = factory.getOWLClass(IRI.create(ONTOLOGY_IRI1 + TYPE));
		SWRLIndividualArgument varA = factory.getSWRLIndividualArgument(
				factory.getOWLNamedIndividual(IRI.create(namespace + VARIABLE1))
				);
		SWRLAtom a1 = factory.getSWRLClassAtom(clsA, varA);
		body.add(a1);
		
		// Class Atom
		OWLClass clsB = factory.getOWLClass(IRI.create(ONTOLOGY_IRI1 + TYPE));
		SWRLIndividualArgument varB = factory.getSWRLIndividualArgument(
				factory.getOWLNamedIndividual(IRI.create(namespace + VARIABLE2))
				);
		SWRLAtom b1 = factory.getSWRLClassAtom(clsB, varB);
		body.add(b1);
		
		// Object Property Atom
		OWLObjectPropertyExpression propertyC = factory.getOWLObjectProperty(IRI.create(ONTOLOGY_IRI2 + PROPERTY1));
		SWRLAtom c1 = factory.getSWRLObjectPropertyAtom(propertyC.asObjectPropertyExpression(), varA, varB);
		body.add(c1);
		
		// Datavalued Property Atom with Integer Literal as Second Argument
		OWLDataPropertyExpression propertyD1 = factory.getOWLDataProperty(IRI.create(ONTOLOGY_IRI2 + PROPERTY2));
		SWRLLiteralArgument l1 = factory.getSWRLLiteralArgument(factory.getOWLLiteral(INT_VALUE));
		SWRLAtom d1 = factory.getSWRLDataPropertyAtom(propertyD1, varA, l1);
		body.add(d1);
		
		// Datavalued Property Atom with String Literal as Second Argument
		OWLDataPropertyExpression propertyD2 = factory.getOWLDataProperty(IRI.create(ONTOLOGY_IRI2 + PROPERTY3));
		SWRLLiteralArgument l2 = factory.getSWRLLiteralArgument(factory.getOWLLiteral(STRING_VALUE));
		SWRLAtom d2 = factory.getSWRLDataPropertyAtom(propertyD2, varA, l2);
		body.add(d2);
		
		// TODO Datavalued Property Atom with SWRL Variable as Second Argument
		/* OWLDataPropertyExpression propertyD3 = factory.getOWLDataProperty(IRI.create(ONTOLOGY_IRI2 + PROPERTY4));
		SWRLVariable v1 = factory.getSWRLVariable(IRI.create(namespace + VARIABLE3));
		SWRLAtom d3 = factory.getSWRLDataPropertyAtom(propertyD3, varA, v1);
		body.add(d3); */
		
		return new SWRLRuleImpl(body, head);
	}

	@Test
	public void testMinimalSensor() {
		Model jenaModel = JenaConverter.convertToJenaModel(SENSOR, ONTOLOGY_IRI1);
		checkJenaModelWithOriginalSmartCityObject(jenaModel, SENSOR);
	}
	
	@Test
	public void testMultipleServicesinStatements() {
		Model model = RDFDataMgr.loadModel(SERVICE_OWL_FILENAME);
		model.add(RDFDataMgr.loadModel(DEVICE_OWL_FILENAME));
		try {
			Set<SmartCityObject> set = JenaConverter.convertToSmartCityObjects(model);
			assertTrue(set.size() == 2);
		} catch (ISCOException e) {
			fail("Could not generate Smart City Object!");
		}
	}

}
