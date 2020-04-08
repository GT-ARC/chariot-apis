package com.gtarc.chariot.api.jiacbinding.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLVariable;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;

import de.dailab.jiactng.owlsGenerator.OWLSFactory;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.jiactng.owlsdescription.process.AtomicProcess;
import de.dailab.jiactng.owlsdescription.process.Param;
import de.dailab.jiactng.owlsdescription.profile.Profile;
import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

public class SmartCityObjectConverterUtilTest {
	
	private static final String PROPERTY = "exampleProperty";
	private static final String TYPE = "ExampleClass";
	private static final String OUTPUT_LABEL = "output";
	private static final String INPUT_LABEL = "input";
	private static final String ONTOLOGY_IRI = "http://example-ontology.de/test.owl#";
	private static final Accessibility UNDEFINED_ACCESSIBILITY = Accessibility.UNDEFINED;
	private static final List<Domain> DOMAINS = Arrays.asList(Domain.LIVING);
	private static final String DESCRIPTION = "description";
	private static final String LABEL = "label";
	final File OWLS_MULTIPLE_EFFECTS = getOWLSFile("");
	private SWRLRuleImpl effect = createExampleEffect();
	private List<Parameter> outputsSCO = Collections.singletonList(createExampleParameter());
	private List<Param> inputsSD = Collections.singletonList(new Param(INPUT_LABEL, URI.create(ONTOLOGY_IRI + TYPE)));
	private List<Param> outputsSD = Collections.singletonList(new Param(OUTPUT_LABEL, URI.create(ONTOLOGY_IRI + TYPE)));
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
	
	private File getOWLSFile(String string) {
		try {
			return new File(ClassLoader.getSystemResource("RequestFlight2.owl").toURI());
		} catch (URISyntaxException e) {
			fail();
		}
		return null;
	}

	private static Parameter createExampleParameter() {
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setLabel(OUTPUT_LABEL);
		parameter.setType(IRI.create(ONTOLOGY_IRI + TYPE));
		return parameter;
	}

	/**
	 * Converts a Smart City Object into a Service Description and tests if the object is valid.
	 */
	@Test
	public void testSCOtoSD() {
		SmartCityObject testSCO = createTestService();
		ServiceDescription serviceDescription = SmartCityObjectConverterUtil.convert(testSCO);
		isValid(testSCO, serviceDescription);
		testSCO = DomainmodelFactory.eINSTANCE.createSensor();
		serviceDescription = SmartCityObjectConverterUtil.convert(testSCO);
		isValid(testSCO, serviceDescription);
	}
	
	/**
	 * Converts a Smart City Object into a Service Description and tests if the object is valid.
	 */
	@Test
	public void testSDtoService() {
		ServiceDescription testSD = createExampleServiceDescription();
		SmartCityObject testSCO = SmartCityObjectConverterUtil.convert(testSD);
		assertTrue(testSCO instanceof Service);
		isValid(testSCO, testSD);
		assertEquals(Accessibility.UNDEFINED, testSCO.getAccessibility());
		assertNull(testSCO.getEndpoint());
	}
	
	/**
	 * Converts a Smart City Object into a Service Description and tests if the object is valid.
	 */
	@Test
	public void testSDWithMultipleEffectsToService() {
		ServiceDescription testSD = OWLSFactory.loadOntology(OWLS_MULTIPLE_EFFECTS);
		SmartCityObject testSCO = SmartCityObjectConverterUtil.convert(testSD);
		assertTrue(testSCO instanceof Service);
		isValid(testSCO, testSD);
		assertEquals(Accessibility.UNDEFINED, testSCO.getAccessibility());
		assertNull(testSCO.getEndpoint());
	}
	
	private ServiceDescription createExampleServiceDescription() {
		ServiceDescription serviceDescription = new ServiceDescription(ONTOLOGY_IRI, LABEL);
		
		Profile profile = new Profile(LABEL.concat("profile"), ONTOLOGY_IRI.concat("_profile"));
		profile.setDescription(DESCRIPTION);
		serviceDescription.setProfile(profile);
		
		de.dailab.jiactng.owlsdescription.process.Process process =
				new AtomicProcess(ONTOLOGY_IRI.concat("_process"), LABEL.concat("process"), inputsSD, outputsSD);
		
		process.addEffect("_EFFRULE", effect);
		
		serviceDescription.setProcess(process);
		
		return serviceDescription;
	}
	
	private void isValid(SmartCityObject testSCO, ServiceDescription serviceDescription) {
		assertEquals(testSCO.getLabel() == null || testSCO.getLabel().isEmpty() ? "service" 
				: testSCO.getLabel(), serviceDescription.getServiceName());
		assertEquals(testSCO.getDescription(), serviceDescription.getProfile().getDescription());
		assertEquals(!(testSCO instanceof Service) || (((Service) testSCO).getEffect() == null) ?
				0 : ((Service) testSCO).getEffect().body().count(),
				serviceDescription.getProcess().getEffects().size());
		assertEquals(!(testSCO instanceof Service) || (((Service) testSCO).getInputs().isEmpty()) ?
				0 : ((Service) testSCO).getInputs().size(), serviceDescription.getProcess().getInput().size());
		assertEquals(!(testSCO instanceof Service) || (((Service) testSCO).getOutputs().isEmpty()) ?
				0 : ((Service) testSCO).getOutputs().size(), serviceDescription.getProcess().getOutput().size());
		if (testSCO instanceof Service && serviceDescription.getProcess().getEffects().size() == 1) {
			assertEquals(((Service) testSCO).getEffect(),
					serviceDescription.getProcess().getEffects().values().iterator().next());
		}
		assertTrue(isValidURI(serviceDescription.getIRI()));
	}
	
	private static boolean isValidURI(String pUrl) {
        try {
			IRI.create(new URI(pUrl));
		} catch (URISyntaxException e) {
			return false;
		}
        return true;
    }

	
	private Service createTestService() {
		Service service =
				SmartCityObjectUtil.createService(outputsSCO, effect, DOMAINS, UNDEFINED_ACCESSIBILITY, endpoint);
		service.setDescription(DESCRIPTION);
		service.setLabel(LABEL);
		service.setIri(IRI.create(ONTOLOGY_IRI + TYPE));
		return service;
	}

}
