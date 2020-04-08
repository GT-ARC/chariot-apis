package com.gtarc.chariot.api.jiacbinding.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLRule;

import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;

import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.jiactng.owlsdescription.process.AtomicProcess;
import de.dailab.jiactng.owlsdescription.process.Param;
import de.dailab.jiactng.owlsdescription.profile.Profile;
import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

public final class SmartCityObjectConverterUtil {

	private SmartCityObjectConverterUtil() {
	}

	/**
	 * Convert a {@link SmartCityObject} into a {@link ServiceDescription}. 
	 * 
	 * @param smartCityObject The instance to convert.
	 * @return An instance of {@linkplain ServiceDescription}
	 */
	public static ServiceDescription convert(SmartCityObject smartCityObject) {
		String iri = smartCityObject.getIri() != null ? smartCityObject.getIri().getIRIString() : "";
		String label = smartCityObject.getLabel() != null ? smartCityObject.getLabel() : "";
		ServiceDescription serviceDescription =
				new ServiceDescription(iri, label.isEmpty() ? "service" : label);
		
		Profile profile = new Profile(label.concat("profile"), iri.concat("_profile"));
		profile.setDescription(smartCityObject.getDescription());
		serviceDescription.setProfile(profile);
		
		// Add process
		List<Param> inputs = new ArrayList<>();
		if (smartCityObject instanceof Service) {
			inputs.addAll(((Service) smartCityObject).getInputs().stream()
					.map(input -> new Param(input.getLabel(), URI.create(input.getType().getIRIString())))
					.collect(Collectors.toList()));
		}
		
		List<Param> outputs = new ArrayList<>();
		if (smartCityObject instanceof Service) {
			outputs.addAll(((Service) smartCityObject).getOutputs().stream()
					.map(input -> new Param(input.getLabel(), URI.create(input.getType().getIRIString())))
					.collect(Collectors.toList()));
		}
		
		de.dailab.jiactng.owlsdescription.process.Process process =
				new AtomicProcess(iri.concat("_process"), label.concat("process"), inputs, outputs);
		SWRLRule precondition = smartCityObject.getPrecondition();
		if (precondition != null) {
			process.addPreCondition("_PRERULE", precondition);
		}
		
		if (smartCityObject instanceof Service && ((Service) smartCityObject).getEffect() != null) {
			process.addEffect("_EFFRULE", ((Service) smartCityObject).getEffect());
		} else if (smartCityObject instanceof Actuator && ((Actuator) smartCityObject).getEffect() != null) {
			process.addEffect("_EFFRULE", ((Actuator) smartCityObject).getEffect());
		}
		
		serviceDescription.setProcess(process);
		
		return serviceDescription;
	}
	
	/**
	 * Convert a {@link ServiceDescription} into a {@link Service}.
	 * 
	 * @param serviceDescription
	 * @return
	 */
	public static Service convert(ServiceDescription serviceDescription) {
		DomainmodelFactory factory = DomainmodelFactory.eINSTANCE;
		List<Parameter> inputs = serviceDescription.getProcess().getInput().stream().map(input -> {
			Parameter p = factory.createParameter();
			p.setLabel(input.getName());
			p.setType(IRI.create(input.getType()));
			return p;
		}).collect(Collectors.toList());
		List<Parameter> outputs = serviceDescription.getProcess().getOutput().stream().map(output -> {
			Parameter p = factory.createParameter();
			p.setLabel(output.getName());
			p.setType(IRI.create(output.getType()));
			return p;
		}).collect(Collectors.toList());
		Map<String, SWRLRule> effectsMap = serviceDescription.getProcess().getEffects();
		SWRLRule effect = null;
		if (!effectsMap.isEmpty()) {
			Set<SWRLAtom> flatMap =
					effectsMap.values().stream().flatMap(SWRLRule::body).collect(Collectors.toSet());
			effect = new SWRLRuleImpl(flatMap, Collections.emptySet());
			// TODO multiple effects
			// TODO set annotations
		}
		Service service = SmartCityObjectUtil.createService(outputs, effect);
		Map<String, SWRLRule> preconditionMap = serviceDescription.getProcess().getPreConditions();
		SWRLRule precondition = null;
		if (!effectsMap.isEmpty()) {
			Set<SWRLAtom> flatMap =
					preconditionMap.values().stream().flatMap(SWRLRule::body).collect(Collectors.toSet());
			precondition = new SWRLRuleImpl(flatMap, Collections.emptySet());
			// TODO multiple preconditions
			// TODO set annotations
		}
		service.setPrecondition(precondition);
		service.setLabel(serviceDescription.getServiceName());
		service.setDescription(serviceDescription.getProfile().getDescription());
		service.getInputs().addAll(inputs);
		return service;
	}
	
}
