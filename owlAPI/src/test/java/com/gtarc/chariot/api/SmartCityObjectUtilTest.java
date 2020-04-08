package com.gtarc.chariot.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.ActivationStatus;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Owner;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.domainmodel.impl.ActuatorImpl;
import com.gtarc.chariot.api.model.domainmodel.impl.SensorImpl;
import com.gtarc.chariot.api.model.domainmodel.impl.ServiceImpl;
import com.gtarc.chariot.api.model.spatialdata.Circle;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataFactory;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;

import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

/**
 * Tests for the smart city objects utility class.
 * @see SmartCityObjectUtil
 * 
 * @author ckuster
 *
 */
public class SmartCityObjectUtilTest {
	
	private static final MeasuringMode MEASURING_MODE_INTERVAL = MeasuringMode.INTERVAL;
	private static final String PROPERTY = "exampleProperty";
	private static final String TYPE = "ExampleClass";
	private static final String OUTPUT_LABEL = "output";
	private static final Parameter OUTPUT = createExampleParameter();
	private static final String DEFAULT_UUID = "00000000-0000-0000-0000-000000000000";
	private static final String ONTOLOGY_IRI = "http://example-ontology.de/#";
	private static final Accessibility UNDEFINED_ACCESSIBILITY = Accessibility.UNDEFINED;
	private static final List<Domain> DOMAINS = Arrays.asList(Domain.LIVING);
	private static final IRI _IRI = IRI.create("http://example-URI.de/");
	private static final String NULL = "null";
	private static final Owner UNDEFINED_OWNER = Owner.UNDEFINED;
	private static final ActivationStatus UNDEFINED_ACTIVATION_STATUS = ActivationStatus.UNDEFINED;
	private SWRLRuleImpl effect = createExampleEffect();
	private List<Parameter> outputs = createExampleOutputs();
	private Endpoint endpoint = DomainmodelFactory.eINSTANCE.createEndpoint();
	
	private SWRLRuleImpl createExampleEffect() {
		Set<SWRLAtom> head = new HashSet<>();
		Set<SWRLAtom> body = new HashSet<>();
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();
		OWLClass clsA = factory.getOWLClass(IRI.create(ONTOLOGY_IRI  + TYPE));
		SWRLVariable var = factory.getSWRLVariable(IRI.create(ONTOLOGY_IRI + PROPERTY));
		SWRLAtom b1 = factory.getSWRLClassAtom(clsA, var);
		body.add(b1);
		return new SWRLRuleImpl(body, head);
	}

	private List<Parameter> createExampleOutputs() {
		List<Parameter> outputs = new ArrayList<>();
		Parameter parameter = createExampleParameter();
		outputs.add(parameter);
		return outputs;
	}

	private static Parameter createExampleParameter() {
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setLabel(OUTPUT_LABEL);
		parameter.setType(IRI.create(ONTOLOGY_IRI + TYPE));
		return parameter;
	}

	/**
	 * Test if a measuring device is created as expected.
	 */
	@Test
	public void testCreateSensor() {
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		location.setLongitude(1d);
		location.setLatitude(2d);
		Circle circle = SpatialdataFactory.eINSTANCE.createCircle();
		circle.setLocation(location);
		circle.setRadius(5);
		Device device = SmartCityObjectUtil.createSensor(location, circle, UNDEFINED_OWNER,
				OUTPUT, MEASURING_MODE_INTERVAL, DOMAINS, UNDEFINED_ACCESSIBILITY, _IRI, endpoint);
		assertTrue(device.toString().contains("(label: " + NULL + ", domains: " + DOMAINS + ", id: "));
		assertTrue(device.toString().contains("description: " + NULL + ", accessibility: " + UNDEFINED_ACCESSIBILITY
				+ ", " + "precondition: " + NULL + ", quality: " + NULL + ", iri: " + NULL + ", classification: " + NULL
				+ ") (activationStatus: " + UNDEFINED_ACTIVATION_STATUS + ", group: " + NULL + ", " + "owner: "
				+ UNDEFINED_OWNER + ", type: " + _IRI.toString() + ") " + "(mode: INTERVAL)"));
	}
	
	/**
	 * Test if an actuating device is created as expected.
	 */
	@Test
	public void testCreateActuator() {
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		location.setLongitude(1d);
		location.setLatitude(2d);
		Circle circle = SpatialdataFactory.eINSTANCE.createCircle();
		circle.setLocation(location);
		circle.setRadius(5);
		Device device = SmartCityObjectUtil.createActuator(location, circle, UNDEFINED_OWNER, effect,
				DOMAINS, UNDEFINED_ACCESSIBILITY, _IRI, endpoint);
		assertTrue(device.toString().contains("(label: " + NULL + ", domains: " + DOMAINS + ", id: "));
		assertTrue(device.toString().contains("description: " + NULL + ", accessibility: " + UNDEFINED_ACCESSIBILITY 
				+ ", " + "precondition: " + NULL + ", quality: " + NULL + ", iri: " + NULL + ", classification: " + NULL
				+ ") (activationStatus: " + UNDEFINED_ACTIVATION_STATUS + ", group: " + NULL + ", " + "owner: "
				+ UNDEFINED_OWNER + ", type: " + _IRI.toString() + ") " + "(effect: " + effect + ")"));
	}

	/**
	 * Test if a service is created as expected.
	 */
	@Test
	public void testCreateService() {
		Service service = createTestServiceNoOutputs();
		assertTrue(service.toString().contains("(label: " + NULL + ", domains: " + DOMAINS + ", id: "));
		assertTrue(service.toString().contains("description: " + NULL + ", accessibility: " + UNDEFINED_ACCESSIBILITY
				+ ", " + "precondition: " + NULL + ", quality: " + NULL + ", iri: " + NULL + ", classification: " + NULL
				+ ") (effect: " + effect + ", priority: " + NULL + ", " + "bundle: )"));
		service = createTestServiceNoEffect();
		assertTrue(service.toString().contains("(label: " + NULL + ", domains: " + DOMAINS + ", id: "));
		assertTrue(service.toString().contains("description: " + NULL + ", accessibility: " + UNDEFINED_ACCESSIBILITY
				+ ", " + "precondition: " + NULL + ", quality: " + NULL + ", iri: " + NULL + ", classification: " + NULL
				+ ") (effect: " + NULL + ", priority: " + NULL + ", " + "bundle: )"));
		assertTrue(service.getOutputs().toString()
				.contains("(label: " + OUTPUT_LABEL + ", type: " + ONTOLOGY_IRI + TYPE + ")"));
	}
	
	private Service createTestServiceNoOutputs() {
		Service service = SmartCityObjectUtil.createService(null, effect, DOMAINS, UNDEFINED_ACCESSIBILITY, endpoint);
		return service;
	}
	
	private Service createTestServiceNoEffect() {
		Service service = SmartCityObjectUtil.createService(outputs, null, DOMAINS, UNDEFINED_ACCESSIBILITY, endpoint);
		return service;
	}
	
	/**
	 * Test if SCOs always have a unique UUID.
	 */
	@Test
	public void testCreateServiceHasUniqueUUID() {
		Service service = createTestServiceNoOutputs();
		assertFalse(service.getId().equals(UUID.fromString(DEFAULT_UUID)));
	}
	
	@Test
	public void testTemplateCreator() {
		assertEquals(ServiceImpl.class, SmartCityObjectUtil.createTemplate(Service.class).getClass());
		assertEquals(ActuatorImpl.class, SmartCityObjectUtil.createTemplate(Actuator.class).getClass());
		assertEquals(SensorImpl.class, SmartCityObjectUtil.createTemplate(Sensor.class).getClass());
		assertNull(SmartCityObjectUtil.createTemplate(SmartCityObject.class));
		assertNull(SmartCityObjectUtil.createTemplate(null));
	}

}
