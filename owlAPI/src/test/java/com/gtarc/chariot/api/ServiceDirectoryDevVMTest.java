package com.gtarc.chariot.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLArgument;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLDArgument;
import org.semanticweb.owlapi.model.SWRLIArgument;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.RestEndpoint;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.exception.ISCOException;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.Point;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataFactory;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;
import com.gtarc.chariot.api.model.util.sparql.SparqlQueryBuilder;

import uk.ac.manchester.cs.owl.owlapi.SWRLIndividualArgumentImpl;
import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

public class ServiceDirectoryDevVMTest {

	private static ChariotDevServiceDirectoryConnector connector;
	
	private static final String INDIVIDUAL = "exampleIndividual";
	private static final String TYPE = "ExampleClass";
	private static final String ONTOLOGY_IRI = "http://example-ontology.de/#";
	private static final String PARAM_LABEL = "paramLabel";
	private static final String PARAM_TYPE = "http://param-iri.de/#ParamClass";
	private static final String LABEL = "label";
	private static final int NUMBER_OF_SERVICES = 750;
	
	private Random dice = new Random(1234567891313L);

	@Before
	public void setUp() throws Exception {
		try {
			connector = new ChariotDevServiceDirectoryConnector("api-junit-integration-test");
			connector.update("CLEAR SILENT GRAPH <" + connector.getGraphModel() + ">");
		} catch (MalformedURLException e) {
			fail("Malformed URL!");
		} catch (Exception e){
			fail("Exception occured:" + e.getMessage());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		connector.update("DROP SILENT GRAPH <" + connector.getGraphModel() + ">");
	}

	@Ignore
	@Test
	public void testConnection() {
		String query = SparqlQueryBuilder.buildQuery(null, "?graph", "SELECT *", "?subject ?predicate ?object", 1);
		Set<String> result = connector.query(query);
		assertEquals(1, result.size());
	}
	
//	@Test
	public void testRegisterAndRequestService() {		
		Service exampleService = getExampleService();
		connector.register(exampleService, null, null);
		Optional<SmartCityObject> smartCityObject = connector.requestSmartCityObject(exampleService.getId());
		assertTrue(smartCityObject.isPresent());
		Optional<SmartCityObject> smartCityObject2 = connector.requestSmartCityObject(exampleService.getId());
		assertEquals(smartCityObject, smartCityObject2);
		SmartCityObject sco = smartCityObject.get();
		assertTrue(sco instanceof Service);
		Optional<SWRLAtom> findAny = ((Service) sco).getEffect().body().findAny();
		assertTrue(findAny.isPresent());
		Optional<SWRLArgument> findAny2 = findAny.get().allArguments().findAny();
		assertTrue(findAny2.isPresent());
		SWRLArgument swrlArgument = findAny2.get();
		String iri = null;
		if (swrlArgument instanceof SWRLIArgument) {
			iri = getIRI((SWRLIArgument) swrlArgument);
		} else {
			iri = getIRI((SWRLDArgument) swrlArgument);
		}
		assertTrue(iri.contains(sco.getIri().getIRIString().substring(0, sco.getIri().getIRIString().indexOf("#"))));
		checkEffectThenMakeEqual(exampleService, sco);
		assertTrue(EcoreUtil.equals(exampleService, sco));
	}
	
	private static String getIRI(SWRLDArgument argument) {
		if (argument instanceof SWRLVariable) {
			return ((SWRLVariable) argument).getIRI().getIRIString();
		} else if (argument instanceof SWRLLiteralArgument) {
			return ((SWRLLiteralArgument) argument).toString();
		}
		return null;
	}
	
	private static String getIRI(SWRLIArgument argument) {
		if (argument instanceof SWRLVariable) {
			return ((SWRLVariable) argument).getIRI().getIRIString();
		} else if (argument instanceof SWRLIndividualArgument) {
			return ((SWRLIndividualArgument) argument).getIndividual().asOWLNamedIndividual().getIRI().getIRIString();
		}
		return null;
	}

	private Service getExampleService(Domain[] domain) {
		List<Parameter> outputs = new ArrayList<>();
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setLabel("output_temperature");
		parameter.setType(IRI.create(
				"https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl#Temperature_Celsius1"
				));
		outputs.add(parameter);
		RestEndpoint endpoint = DomainmodelFactory.eINSTANCE.createRestEndpoint();
		endpoint.setUri(URI.create("http://endpoint.de/endpoint"));
		Service service = SmartCityObjectUtil.createService(
				outputs, null, Arrays.asList(domain), Accessibility.OPEN, endpoint
				);
		service.setLabel("Temperature Sensor");
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		location.setLatitude(51.505730d);
		location.setLongitude(7.451550d);
		Point region = SpatialdataFactory.eINSTANCE.createPoint();
		region.setLocation(location);
		service.setRegion(region);
		service.setEffect(createExampleEffect());
		return service;
	}
	
	private Service getRandomService(Domain[] domain) {
		List<Parameter> outputs = new ArrayList<>();
		SWRLRule effect = null;
		if (dice.nextInt(10) == 1) {
			Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
			parameter.setLabel("output");
			parameter.setType(IRI.create(
					"https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl"
					+ "#Temperature_Fahrenheit"
					));
			outputs.add(parameter);
		} else if (outputs.isEmpty() || dice.nextInt(10) == 1) {
			effect = createExampleEffect();
		}
		RestEndpoint endpoint = DomainmodelFactory.eINSTANCE.createRestEndpoint();
		endpoint.setUri(URI.create("http://endpoint.de/endpoint"));
		Service service = SmartCityObjectUtil.createService(
				outputs, effect, Arrays.asList(domain), Accessibility.OPEN, endpoint
				);
		if (dice.nextInt(10) == 1) {
			Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
			parameter.setLabel("intput");
			parameter.setType(IRI.create(
					"https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl#WeatherState"
					));
			service.getInputs().add(parameter);
		}
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		location.setLatitude(51.505730d);
		location.setLongitude(7.451550d);
		Point region = SpatialdataFactory.eINSTANCE.createPoint();
		region.setLocation(location);
		if (dice.nextInt(10) == 1) {
			service.setRegion(region);
		}
		if (dice.nextInt(10) == 1) {
			service.setEffect(createExampleEffect());
		}
		return service;
	}
	
	private SWRLRuleImpl createExampleEffect() {
		Set<SWRLAtom> head = new HashSet<>();
		Set<SWRLAtom> body = new HashSet<>();
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = manager.getOWLDataFactory();
		OWLClass clsA = factory.getOWLClass(IRI.create(ONTOLOGY_IRI  + TYPE));
		SWRLIndividualArgument var = new SWRLIndividualArgumentImpl(
				factory.getOWLNamedIndividual(IRI.create(ONTOLOGY_IRI + INDIVIDUAL))
				);
		SWRLAtom b1 = factory.getSWRLClassAtom(clsA, var);
		body.add(b1);
		return new SWRLRuleImpl(body, head);
	}
	
	private Service getExampleService() {
		return getExampleService(new Domain[] {Domain.LIVING});
	}

	@Ignore
	@Test
	public void testRequestAllServicesFromDomain() {
		connector.register(getExampleService(new Domain[] {Domain.LIVING}), null, null);
		connector.register(getExampleService(new Domain[] {Domain.LIVING}), null, null);
		connector.register(getExampleService(new Domain[] {Domain.BUILDINGS}), null, null);
		assertEquals(2, connector.requestAllSmartCityObjectsFromDomains(Domain.LIVING).size());
		assertEquals(3, connector.requestAllSmartCityObjectsFromDomains(Domain.LIVING, Domain.BUILDINGS).size());
		assertEquals(0, connector.requestAllSmartCityObjectsFromDomains(Domain.ECONOMY_AND_PEOPLE).size());
	}

	@Ignore
	@Test
	public void testRequestWithTemplate() {
		Service exampleService = getExampleService(new Domain[] {Domain.LIVING});
		connector.register(exampleService, null, null);
		exampleService.setId(UUID.randomUUID());
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setLabel(PARAM_LABEL);
		parameter.setType(IRI.create(PARAM_TYPE));
		exampleService.getInputs().add(parameter);
		exampleService.setLabel(LABEL);
		connector.register(exampleService, null, null);
		Sensor templateSensor = SmartCityObjectUtil.createTemplate(Sensor.class);
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateSensor);
			assertEquals(0, smartCityObjects.size());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		Service templateService = SmartCityObjectUtil.createTemplate(Service.class);
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateService);
			assertEquals(2, smartCityObjects.size());
			assertTrue(smartCityObjects.stream().anyMatch(
					sco->{
						exampleService.setIri(sco.getIri()); 
						checkEffectThenMakeEqual(exampleService, sco);
						return EcoreUtil.equals(exampleService, sco);
						}
					));
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		templateService.setLabel(exampleService.getLabel());
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateService);
			assertEquals(1, smartCityObjects.size());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		templateService.setLabel(null);
		templateService.setEffect(exampleService.getEffect());
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateService);
			assertEquals(2, smartCityObjects.size());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		templateService.setEffect(null);
		templateService.getInputs().add(parameter);
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateService);
			assertEquals(1, smartCityObjects.size());
			assertEquals(LABEL, smartCityObjects.iterator().next().getLabel());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		templateService.setPriority("test-priority");
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(templateService);
			assertEquals(0, smartCityObjects.size());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
	}

	private void checkEffectThenMakeEqual(Service exampleService, SmartCityObject sco) {
		Set<String> set = exampleService.getEffect().individualsInSignature()
				.map(i->XMLUtils.getNCNameSuffix(i.getIRI())).collect(Collectors.toSet());
		if (sco instanceof Service) {
			((Service) sco).getEffect().individualsInSignature()
					.forEach(i->set.contains(XMLUtils.getNCNameSuffix(i.getIRI())));
			exampleService.setEffect(((Service) sco).getEffect());
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Ignore
	@Test(timeout = 180_000) // Timeout: 3 min
	public void testHugeRequests() {
		Service exampleService = getExampleService(new Domain[] {Domain.LIVING});
		connector.register(exampleService, null, null);
		
		ExecutorService service = Executors.newCachedThreadPool();
	    List<Future> futures = new java.util.ArrayList<>();
		for (int i = 0; i < NUMBER_OF_SERVICES; i++) {
			Future f = service.submit(new Runnable() {
				@Override
				public void run() {
					connector.register(getRandomService(new Domain[]{Domain.LIVING}), null, null);
				}
			});
			futures.add(f);
		}
		for (int i = 0; i < NUMBER_OF_SERVICES; i++) {
			Future f = service.submit(new Runnable() {
				@Override
				public void run() {
					connector.register(getRandomService(new Domain[]{Domain.NATURAL_RESOURCES_AND_ENERGY}), null, null);
				}
			});
			futures.add(f);
		}
		// wait for all tasks to complete before continuing
		for (Future f : futures) {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException e) {
				fail(e.getLocalizedMessage());
			}
		}
		service.shutdown();
		
		Service template = SmartCityObjectUtil.createTemplate(Service.class);
		template.getOutputs().addAll(exampleService.getOutputs());
		try {
			Set<SmartCityObject> smartCityObjects = connector.requestSmartCityObject(template);
			assertEquals(1, smartCityObjects.size());
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
		Optional<SmartCityObject> smartCityObject = connector.requestSmartCityObject(exampleService.getId());
		assertTrue(smartCityObject.isPresent());
		Set<SmartCityObject> smartCityObjects =
				connector.requestAllSmartCityObjectsFromDomains(Domain.NATURAL_RESOURCES_AND_ENERGY);
		assertEquals(NUMBER_OF_SERVICES, smartCityObjects.size());
		try {
			smartCityObjects = connector.requestSmartCityObject(SmartCityObjectUtil.createTemplate(Service.class));
			assertTrue(smartCityObjects.size() > 1_500);
		} catch (ISCOException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	public String randomString(String chars, int length) {
		Random rand = new Random();
		StringBuilder buf = new StringBuilder();
		for (int i=0; i<length; i++) {
			buf.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return buf.toString();
	}



}
