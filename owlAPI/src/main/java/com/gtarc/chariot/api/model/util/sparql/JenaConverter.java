package com.gtarc.chariot.api.model.util.sparql;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.HasNoModelException;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.OWL2;
import org.apache.jena.vocabulary.RDF;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLBuiltInAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDArgument;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLIArgument;
import org.semanticweb.owlapi.model.SWRLIndividualArgument;
import org.semanticweb.owlapi.model.SWRLLiteralArgument;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.ActivationStatus;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Owner;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.RestEndpoint;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.exception.ISCOException;
import com.gtarc.chariot.api.model.spatialdata.Circle;
import com.gtarc.chariot.api.model.spatialdata.FreeForm;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.Point;
import com.gtarc.chariot.api.model.spatialdata.Rectangle;
import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataFactory;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;
import com.gtarc.chariot.api.model.util.StringUtil;
import com.gtarc.quality.qualitymodel.metric.Metric;

import gnu.trove.set.hash.THashSet;
import uk.ac.manchester.cs.owl.owlapi.SWRLRuleImpl;

/**
 * This converter class takes JENA statements and converts them to smart city objects.
 * 
 * @author ckuster
 *
 */
public final class JenaConverter {
	
	static final Logger LOG = LoggerFactory.getLogger(JenaConverter.class);
	
	private static final Property CONDITION_ANNOTATION =
			ResourceFactory.createProperty(RDF.getURI(), "conditionAnnotation");
	
	private JenaConverter() {}
	
	/**
	 * Return Smart City Objects according to the statements.
	 * 
	 * @param model The model that contains the Smart City Object(s).
	 * @param existingSCOs All already in a previous session converted SCOs, which should be used if found in {@code model}
	 * @return A set of one or more Smart City Objects
	 * @throws ISCOException If no valid objects are found.
	 */
	public static Set<SmartCityObject> convertToSmartCityObjects(Model model, Map<UUID, SmartCityObject> existingSCOs)
			throws ISCOException {
		Set<SmartCityObject> smartCityObjects = new THashSet<>();
		Set<RDFNode> processed = new THashSet<>();
		StmtIterator iterator = model.listStatements(
				new SimpleSelector(null, RDF.type, (RDFNode) null) {
					@Override
					public boolean selects(Statement s) {
						return s.getObject().equals(SmartCityObjectVocabulary.SERVICE)
								|| s.getObject().equals(SmartCityObjectVocabulary.SENSOR)
								|| s.getObject().equals(SmartCityObjectVocabulary.ACTUATOR);
					}
				});
		
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<SmartCityObject>> futures = new java.util.ArrayList<>();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			Resource processedSCO = statement.getSubject();
			if (processed.contains(processedSCO)) {
				continue;
			}
			// try to get ID and check if in map "existingSCOs"
			try {
				UUID id = UUID.fromString(
						processedSCO.getProperty(SmartCityObjectVocabulary.HAS_ID).getObject().toString()
						);
				if (existingSCOs.containsKey(id)) {
					smartCityObjects.add(existingSCOs.get(id));
					continue;
				}
			} catch (NullPointerException e) {
				LOG.debug("SCO {} has no ID.", processedSCO);
			}
			// add all equal individuals to 'processed' set.
			// This way we prevent from adding the same individuals multiple times.
			StmtIterator sameAsIterator = model
					.listStatements(new SimpleSelector(null, OWL2.sameAs, (RDFNode) null) {
						@Override
						public boolean selects(Statement s) {
							return s.getSubject().equals(processedSCO) || s.getObject().equals(processedSCO);
						}
					});
			while (sameAsIterator.hasNext()) {
				Statement sameAsStatement = sameAsIterator.next();
				processed.add(sameAsStatement.getSubject());
				processed.add(sameAsStatement.getObject());
			}
			Callable<SmartCityObject> callable = new Callable<SmartCityObject>() {
				@Override
				public SmartCityObject call() throws Exception {
					Resource ontSCO = model.getResource(processedSCO.getURI());
					RDFNode object = statement.getObject();
					if (object.equals(SmartCityObjectVocabulary.SERVICE)) {
						return getService(ontSCO);
					} else if (object.equals(SmartCityObjectVocabulary.SENSOR)) {
						return getSensor(ontSCO);
					} else if (object.equals(SmartCityObjectVocabulary.ACTUATOR)) {
						return getActuator(ontSCO);
					}
					return null;
				}
			};
			futures.add(service.submit(callable));
		}
		iterator.close();
		
		for (Future<SmartCityObject> future : futures) {
			try {
				smartCityObjects.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				LOG.error("Could not extract SCO!", e.getCause());
			}
		}
		service.shutdown();
		
		if (smartCityObjects.isEmpty()) {
			throw new ISCOException("No Smart City Object found!");
		}
		return smartCityObjects;
	}
	
	/**
	 * Return Smart City Objects according to the statements.
	 * 
	 * @param model The model that contains the Smart City Object(s).
	 * @return A set of one or more Smart City Objects
	 * @throws ISCOException If no valid objects are found.
	 */
	public static Set<SmartCityObject> convertToSmartCityObjects(Model model) throws ISCOException {
		return convertToSmartCityObjects(model, Collections.emptyMap());
	}

	/**
	 * Return Smart City Objects, loading it from an ontology file.
	 * 
	 * @param uri URI to the ontology file.
	 * @return A set of one or more Smart City Objects
	 * @throws ISCOException If no valid objects are found.
	 */
	public static Set<SmartCityObject> convertToSmartCityObjects(String uri) throws ISCOException {
		return convertToSmartCityObjects(ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF)
				.add(RDFDataMgr.loadModel(uri)));
	}
	
	/**
	 * Return a SCO as a Jena model.
	 * 
	 * @param smartCityObject The SCO to convert.
	 * @param modelNamespace The namespace for the Jena model.
	 * @return The Jena model
	 */
	public static Model convertToJenaModel(SmartCityObject smartCityObject, String modelNamespace) {
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		String namespace = modelNamespace;
		
		// Add common prefixes
		model.setNsPrefix("smartcityobject", "http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#");
		model.setNsPrefix("spatialdata", "http://isco-dev.aot.tu-berlin.de/ontologies/spatialdata.owl#");
		model.setNsPrefix("process", "http://www.daml.org/services/owl-s/1.2/Process.owl#");
		model.setNsPrefix("swrl", "http://www.w3.org/2003/11/swrl#");
		model.setNsPrefix("expression", "http://www.daml.org/services/owl-s/1.2/generic/Expression.owl#");
		
		// Create corresponding named individual
		Individual scoIndividual = null;
		String scoUri = SmartCityObjectUtil.getLabelUri(smartCityObject, namespace);
		
		if (smartCityObject instanceof Service) {
			scoIndividual = model.createIndividual(scoUri, SmartCityObjectVocabulary.SERVICE);
			configureServiceModel((Service) smartCityObject, scoIndividual, model, namespace);
		} else if (smartCityObject instanceof Sensor) {
			scoIndividual = model.createIndividual(scoUri, SmartCityObjectVocabulary.SENSOR);
			configureSensorModel((Sensor) smartCityObject, scoIndividual, model, namespace);
		} else { // can only be an actuating device
			scoIndividual = model.createIndividual(scoUri, SmartCityObjectVocabulary.ACTUATOR);
			configureActuatorModel((Actuator) smartCityObject, scoIndividual, model, namespace);
		}
		configureSCOModel(smartCityObject, scoIndividual, model, namespace);
		
		return model;
	}

	private static void configureSCOModel(SmartCityObject smartCityObject, Individual scoIndividual, OntModel model,
			String namespace) {
		scoIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		
		// ID; Accessibility
		scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_ID,
				ResourceFactory.createStringLiteral(smartCityObject.getId().toString()));
		String label = smartCityObject.getLabel();
		if (label != null && !label.isEmpty()) {
			scoIndividual.addLiteral(SmartCityObjectVocabulary.HAS_LABEL, ResourceFactory.createStringLiteral(label));
		}
		scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_ACCESSIBILITY,
				ResourceFactory.createResource(
						SmartCityObjectVocabulary.getURI()
						+ StringUtil.getStringWithoutSpaces(smartCityObject.getAccessibility().getLiteral())
						)
				);
		
		// Domains
		for (Domain domain: smartCityObject.getDomains()) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_DOMAIN,
					ResourceFactory.createResource(
							SmartCityObjectVocabulary.getURI() + StringUtil.getStringWithoutSpaces(domain.getLiteral())
							)
					);
		}
		
		// Description
		String description = smartCityObject.getDescription();
		if (description != null && !description.isEmpty()) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_DESCRIPTION,
					ResourceFactory.createStringLiteral(description));
		}
		
		// Precondition
		SWRLRule precondition = smartCityObject.getPrecondition();
		if (precondition != null && precondition.body().count()+precondition.head().count() > 0) {
			Individual preconditionIndividual =
					model.createIndividual(namespace + "_PRERULE", OWL2.NamedIndividual);
			scoIndividual.addProperty(OwlsProcessVocabulary.HAS_PRECONDITION, preconditionIndividual);
			configureSWRLRule(model, precondition, preconditionIndividual, namespace);
		}
		
		// Endpoint
		Endpoint endpoint = smartCityObject.getEndpoint();
		if (endpoint != null) {
			
			Individual endpointIndividual = null;
			
			if (endpoint instanceof RestEndpoint) {
				RestEndpoint restEndpoint = (RestEndpoint) endpoint;
				endpointIndividual =
						model.createIndividual(namespace + "endpoint", SmartCityObjectVocabulary.REST_ENDPOINT);
				endpointIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
				endpointIndividual.addProperty(SmartCityObjectVocabulary.HAS_URL, restEndpoint.getUri().toString());
			} else if (endpoint instanceof JiacAgentEndpoint) {
				JiacAgentEndpoint jiacAgentEndpoint = (JiacAgentEndpoint) endpoint;
				endpointIndividual =
						model.createIndividual(namespace + "endpoint", SmartCityObjectVocabulary.JIAC_AGENT_ENDPOINT);
				endpointIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
				endpointIndividual.addProperty(
						SmartCityObjectVocabulary.HAS_AGENT_NODE_ID, jiacAgentEndpoint.getAgentNodeId());
				endpointIndividual.addProperty(
						SmartCityObjectVocabulary.HAS_AGENT_ID, jiacAgentEndpoint.getAgentId());
				endpointIndividual.addProperty(
						SmartCityObjectVocabulary.HAS_AGENT_ACTION_NAME, jiacAgentEndpoint.getActionName());
			}
			
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_ENDPOINT, endpointIndividual);
		}
		
		// Quality
		Object quality = smartCityObject.getQuality();
		if (quality != null) {
			configureQuality(quality);
		}
		
		// Type
		IRI category = smartCityObject.getClassification();
		if (category != null) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_CLASSIFICATION, category.getIRIString());
		}
		
		// Collect imports
		Set<String> imports = new THashSet<>(Arrays.asList(
				"http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl",
				"http://isco-dev.aot.tu-berlin.de/ontologies/spatialdata.owl",
				"http://www.daml.org/services/owl-s/1.2/Service.owl",
				"http://www.daml.org/services/owl-s/1.2/Profile.owl",
				"http://www.daml.org/services/owl-s/1.2/Process.owl",
				"http://www.daml.org/services/owl-s/1.2/Grounding.owl",
				"http://www.daml.org/services/owl-s/1.2/generic/Expression.owl"
				));
		Consumer<? super RDFNode> action = obj->{
			if (obj instanceof Literal) {
				imports.add(URI.create(obj.asLiteral().getString()).toString().split("#")[0]);
				}
			};
		model.listObjectsOfProperty(OwlsProcessVocabulary.PARAMETER_TYPE).forEachRemaining(action);
		model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_TYPE).forEachRemaining(action);
		model.listObjectsOfProperty(SmartCityObjectVocabulary.HAS_UNIT).forEachRemaining(action);
		Individual ontology = model.createIndividual(namespace.substring(0, namespace.length()-1), OWL2.Ontology);
		imports.forEach(i->ontology.addProperty(OWL2.imports, ResourceFactory.createResource(i)));
	}

	private static void configureActuatorModel(Actuator actuator, Individual scoIndividual,
			OntModel model, String namespace) {
		configureDeviceModel(actuator, scoIndividual, model, namespace);
		// Effect
		SWRLRule effect = actuator.getEffect();
		if (effect != null && effect.body().count()+effect.head().count() > 0) {
			Individual effectIndividual =
					model.createIndividual(namespace + "_EFFRULE", OWL2.NamedIndividual);
			scoIndividual.addProperty(OwlsProcessVocabulary.HAS_EFFECT, effectIndividual);
			configureSWRLRule(model, effect, effectIndividual, namespace);
		}
	}

	private static void configureSensorModel(Sensor sensor, Individual scoIndividual,
			OntModel model, String namespace) {
		configureDeviceModel(sensor, scoIndividual, model, namespace);
		// Output
		Parameter output = sensor.getOutput();
		if (output != null) {
			String label = output.getLabel();
			if (label == null || label.trim().isEmpty()) {
				label = "sensor";
			}
			configureParameter(output, label, scoIndividual, model, namespace, OwlsProcessVocabulary.OUTPUT);
		}
				
		// Mode
		scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_MEASURING_MODE,
				ResourceFactory.createResource(
						SmartCityObjectVocabulary.getURI()
						+ StringUtil.getStringWithoutSpaces(sensor.getMode().getLiteral())
						)
				);
	}

	private static void configureDeviceModel(Device device, Individual scoIndividual,
			OntModel model, String namespace) {
		// Location
		confgureLocation(scoIndividual, SmartCityObjectVocabulary.HAS_LOCATION, device.getLocation(), "location", model,
				namespace);
		
		// Operational Area
		SpatialObject operationalArea = device.getOperationalArea();
		if (operationalArea != null) {
			configureSpatialObject(
					operationalArea, scoIndividual, "operational_area", 
					SmartCityObjectVocabulary.HAS_OPERATIONAL_AREA, model, namespace
					);
		}
		
		// Activation Status
		scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_ACTIVATION_STATUS,
				ResourceFactory.createResource(
						SmartCityObjectVocabulary.getURI()
						+ StringUtil.getStringWithoutSpaces(device.getActivationStatus().getLiteral())
						)
				);
		
		// Group
		String group = device.getGroup();
		if (group != null && !group.isEmpty()) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_GROUP, group);
		}
		
		// Owner
		scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_OWNER,
				ResourceFactory.createResource(
						SmartCityObjectVocabulary.getURI()
						+ StringUtil.getStringWithoutSpaces(device.getOwner().getLiteral())
						)
				);
		
		// Properties
		for (com.gtarc.chariot.api.model.properties.Property property: device.getProperties()) {
			configureProperty(property, scoIndividual, model, namespace);
		}
		
		// Type
		IRI type = device.getType();
		if (type != null) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_TYPE, type.getIRIString());
		}
	}
	
	private static void configureSWRLRule(OntModel model, SWRLRule rule, Individual ruleIndividual, String namespace) {
		ruleIndividual.addProperty(RDF.type, OwlsExpressionVocabulary.SWRL_CONDITION);
		
		// Body
		if (rule.body().count() != 0) {
			Resource r = model.createResource();
			ruleIndividual.addProperty(OwlsExpressionVocabulary.EXPRESSION_OBJECT, r);
			processSWRLAtoms(model, r, rule.body(), namespace);
		}
	}

	private static void processSWRLAtoms(Model model, Resource list, Stream<SWRLAtom> atoms, String namespace) {
		Iterator<SWRLAtom> iterator = atoms.iterator();
		Resource resource = list;
		while (iterator.hasNext()) {
			resource.addProperty(RDF.type, SwrlVocabulary.ATOM_LIST);
			SWRLAtom atom = iterator.next();
			Resource object = null;
			if (atom instanceof SWRLClassAtom) {
				object = model.createResource(SwrlVocabulary.CLASS_ATOM);
				SWRLClassAtom classAtom = (SWRLClassAtom) atom;
				object.addProperty(SwrlVocabulary.ARGUMENT1,
						ResourceFactory.createResource(getIRI(classAtom.getArgument(), namespace)));
				object.addProperty(SwrlVocabulary.CLASS_PREDICATE,
						ResourceFactory.createResource(classAtom.getPredicate().asOWLClass().getIRI().getIRIString()));
				if (classAtom.getArgument() instanceof SWRLVariable) {
					configureSWRLVariable((SWRLVariable)classAtom.getArgument(), model, namespace);
				}
			} else if (atom instanceof SWRLObjectPropertyAtom) {
				object = model.createResource(SwrlVocabulary.INDIVIDUAL_PROPERTY_ATOM);
				SWRLObjectPropertyAtom objectPropertyAtom = (SWRLObjectPropertyAtom) atom;
				object.addProperty(SwrlVocabulary.ARGUMENT1,
						ResourceFactory.createResource(getIRI(objectPropertyAtom.getFirstArgument(), namespace)));
				object.addProperty(SwrlVocabulary.ARGUMENT2,
						ResourceFactory.createResource(getIRI(objectPropertyAtom.getSecondArgument(), namespace)));
				object.addProperty(SwrlVocabulary.PROPERTY_PREDICATE,
						ResourceFactory.createResource(
								objectPropertyAtom.getPredicate().asOWLObjectProperty().getIRI().getIRIString()));
				if (objectPropertyAtom.getFirstArgument() instanceof SWRLVariable) {
					configureSWRLVariable((SWRLVariable)objectPropertyAtom.getFirstArgument(), model, namespace);
				}
				if (objectPropertyAtom.getSecondArgument() instanceof SWRLVariable) {
					configureSWRLVariable((SWRLVariable)objectPropertyAtom.getSecondArgument(), model, namespace);
				}
			} else if (atom instanceof SWRLDataPropertyAtom) {
				object = model.createResource(SwrlVocabulary.DATAVALUED_PROPERTY_ATOM);
				SWRLDataPropertyAtom dataPropertyAtom = (SWRLDataPropertyAtom) atom;
				object.addProperty(SwrlVocabulary.ARGUMENT1,
						ResourceFactory.createResource(getIRI(dataPropertyAtom.getFirstArgument(), namespace)));
				if (dataPropertyAtom.getSecondArgument() instanceof SWRLLiteralArgument) {
					SWRLLiteralArgument literal = (SWRLLiteralArgument) dataPropertyAtom.getSecondArgument();
					object.addProperty(SwrlVocabulary.ARGUMENT2,
							model.createTypedLiteral(
									literal.getLiteral().getLiteral(),
									literal.getLiteral().getDatatype().getIRI().toString()
									));
				} else {
					LOG.error("SWRL datavalued property atoms with {} as second argument currently not supported!",
							dataPropertyAtom.getSecondArgument().getClass().getSimpleName());
				}
				object.addProperty(SwrlVocabulary.PROPERTY_PREDICATE,
						ResourceFactory.createResource(
								dataPropertyAtom.getPredicate().asOWLDataProperty().getIRI().getIRIString()));
				if (dataPropertyAtom.getFirstArgument() instanceof SWRLVariable) {
					configureSWRLVariable((SWRLVariable)dataPropertyAtom.getFirstArgument(), model, namespace);
				}
			} else if (atom instanceof SWRLBuiltInAtom) {
				object = model.createResource(SwrlVocabulary.BUILTIN_ATOM);
				object.addProperty(
						SwrlVocabulary.BUILTIN,
						ResourceFactory.createResource(((SWRLBuiltInAtom) atom).getPredicate().getIRIString())
						);
				Resource arguments = model.createResource();
				object.addProperty(SwrlVocabulary.ARGUMENTS, arguments);
				SWRLBuiltInAtom builtInAtom = (SWRLBuiltInAtom) atom;
				processSWRLListArguments(model, arguments, builtInAtom.arguments(), namespace);
				
			}
			resource.addProperty(RDF.first, object);
			if (!iterator.hasNext()) {
				resource.addProperty(RDF.rest, RDF.nil);
			} else {
				Resource rest = model.createResource();
				resource.addProperty(RDF.rest, rest);
				resource = rest;
			}
			
		}
	}

	private static void processSWRLListArguments(Model model, Resource list, Stream<SWRLDArgument> stream,
			String namespace) {
		Iterator<SWRLDArgument> iterator = stream.iterator();
		Resource resource = list;
		while (iterator.hasNext()) {
			resource.addProperty(RDF.type, RDF.List);
			SWRLDArgument argument = iterator.next();
			RDFNode object = null;
			if (argument instanceof SWRLVariable) {
				SWRLVariable variable = (SWRLVariable) argument;
				object =  ResourceFactory.createResource(getIRI(variable, namespace));
				configureSWRLVariable(variable, model, namespace);
			} else { // argument instanceof SWRLLiteralArgument
				SWRLLiteralArgument literal = (SWRLLiteralArgument) argument;
				object = model.createTypedLiteral(
						literal.getLiteral().getLiteral(),
						literal.getLiteral().getDatatype().getIRI().toString()
						);
			}
			resource.addProperty(RDF.first, object);
			if (!iterator.hasNext()) {
				resource.addProperty(RDF.rest, RDF.nil);
			} else {
				Resource rest = model.createResource();
				resource.addProperty(RDF.rest, rest);
				resource = rest;
			}
		}
	}

	private static void configureSWRLVariable(SWRLVariable variable, Model model, String namespace) {
		Resource variableResource = model.createResource(getIRI(variable, namespace));
		variableResource.addProperty(RDF.type, SwrlVocabulary.VARIABLE);
	}

	private static String getIRI(SWRLIArgument argument, String namespace) {
		if (argument instanceof SWRLVariable) {
			return getIRI((SWRLVariable) argument, namespace);
		} else { // argument instanceof SWRLIndividualArgument
			return getIRI((SWRLIndividualArgument) argument, namespace);
		}
	}

	private static String getIRI(SWRLIndividualArgument argument, String namespace) {
		return namespace + XMLUtils.getNCNameSuffix(argument.getIndividual().asOWLNamedIndividual().getIRI());
	}

	private static String getIRI(SWRLVariable argument, String namespace) {
		return namespace + XMLUtils.getNCNameSuffix(argument.getIRI());
	}

	private static void configureProperty(com.gtarc.chariot.api.model.properties.Property property,
			Individual scoIndividual, OntModel model, String namespace) {
		//TODO Implement
	}

	private static void confgureLocation(Individual scoIndividual, Property individualProperty, Location location,
			String locationName, OntModel model, String namespace) {
		Individual locationIndividual =
				model.createIndividual(namespace + locationName, SpatialDataVocabulary.LOCATION_CLASS);
		locationIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		double latitude = location.getLatitude();
		if (latitude != 0d) {
			locationIndividual.addLiteral(SpatialDataVocabulary.LATITUDE, latitude);
		}
		double longitude = location.getLongitude();
		if (longitude != 0d) {
			locationIndividual.addLiteral(SpatialDataVocabulary.LONGITUDE, longitude);
		}
		double altitude = location.getAltitude();
		if (altitude != 0d) {
			locationIndividual.addLiteral(SpatialDataVocabulary.ALTITUDE, altitude);
		}
		scoIndividual.addProperty(individualProperty, locationIndividual);
	}

	private static void configureServiceModel(Service service, Individual scoIndividual,
			OntModel model, String namespace) {
		// Region
		SpatialObject region = service.getRegion();
		if (region != null) {
			configureSpatialObject(
					region, scoIndividual, "region", SmartCityObjectVocabulary.HAS_REGION, model, namespace
					);
		}
		
		// Priority
		String priority = service.getPriority();
		if (priority != null && !priority.isEmpty()) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_PRIORITY, priority);
		}
		
		// Bundle
		String bundle = service.getBundle();
		if (bundle != null && !bundle.isEmpty()) {
			scoIndividual.addProperty(SmartCityObjectVocabulary.HAS_BUNDLE, bundle);
		}
		
		// inputs
		configureParameters(service.getInputs(), scoIndividual, model, namespace, OwlsProcessVocabulary.INPUT);
		
		// outputs
		configureParameters(service.getOutputs(), scoIndividual, model, namespace, OwlsProcessVocabulary.OUTPUT);
		
		// Effect
		SWRLRule effect = service.getEffect();
		if (effect != null && effect.body().count()+effect.head().count() > 0) {
			Individual effectIndividual =
					model.createIndividual(namespace + "_EFFRULE", OWL2.NamedIndividual);
			scoIndividual.addProperty(OwlsProcessVocabulary.HAS_EFFECT, effectIndividual);
			configureSWRLRule(model, effect, effectIndividual, namespace);
		}
	}

	private static void configureQuality(Object quality) {
		// TODO Implement
	}

	private static void configureParameters(List<Parameter> parameters, Individual scoIndividual, OntModel model,
			String namespace, Resource object) {
		for (Parameter parameter: parameters) {
			String label = parameter.getLabel();
			if (label == null || label.isEmpty()) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(object.asResource().equals(OwlsProcessVocabulary.INPUT) ? "input_" : "output_");
				stringBuilder.append(String.valueOf(parameters.indexOf(parameter) + 1));
				label = stringBuilder.toString();
			}
			configureParameter(parameter, label, scoIndividual, model, namespace, object);
		}
	}

	private static void configureParameter(Parameter parameter, String label, Individual scoIndividual,
			OntModel model, String namespace, Resource object) {
		Individual parameterIndividual = model.createIndividual(namespace + label, object);
		parameterIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		if (parameter.getType() != null) {
			parameterIndividual.addProperty(OwlsProcessVocabulary.PARAMETER_TYPE,
					parameter.getType().toString());
		} else {
			LOG.warn("Parameter {} has no type defined!", parameter.getLabel());
		}
		scoIndividual.addProperty(
				object.asResource().equals(
						OwlsProcessVocabulary.INPUT) ? 
								SmartCityObjectVocabulary.HAS_INPUT : SmartCityObjectVocabulary.HAS_OUTPUT,
						parameterIndividual
						);
	}

	private static void configureSpatialObject(SpatialObject region, Individual scoIndividual, String individualName,
			Property individualProperty, OntModel model, String namespace) {
		if (region instanceof Rectangle) {
			configureRectangle((Rectangle) region, scoIndividual, individualName, individualProperty, model, namespace);
		} else if (region instanceof Circle) {
			configureCircle((Circle) region, scoIndividual, individualName, individualProperty, model, namespace);
		} else if (region instanceof FreeForm) {
			configureFreeForm((FreeForm) region, scoIndividual, individualName, individualProperty, model, namespace);
		} else if (region instanceof Point ) {
			configurePoint((Point) region, scoIndividual, individualName, individualProperty, model, namespace);
		}
	}

	private static void configureFreeForm(FreeForm freeForm, Individual scoIndividual, String individualName,
			Property individualProperty, OntModel model, String namespace) {
		Individual regionIndividual =
				model.createIndividual(namespace + individualName, SpatialDataVocabulary.POLYGON);
		regionIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		int i = 0;
		for (Location location: freeForm.getLocations()) {
			confgureLocation(regionIndividual, SpatialDataVocabulary.LOCATION_PROPERTY, location,
					"location" + ++i, model, namespace);
		}
		scoIndividual.addProperty(individualProperty, regionIndividual);
	}

	private static void configureCircle(Circle circle, Individual scoIndividual, String individualName,
			Property individualProperty, OntModel model, String namespace) {
		Individual regionIndividual =
				model.createIndividual(namespace + individualName, SpatialDataVocabulary.CIRCLE);
		regionIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		confgureLocation(regionIndividual, SpatialDataVocabulary.LOCATION_PROPERTY, circle.getLocation(),
				"region_location", model, namespace);
		regionIndividual.addLiteral(SpatialDataVocabulary.RADIUS, circle.getRadius());
		scoIndividual.addProperty(individualProperty, regionIndividual);
	}

	private static void configureRectangle(Rectangle rectangle, Individual scoIndividual, String individualName,
			Property individualProperty, OntModel model, String namespace) {
		Individual regionIndividual =
				model.createIndividual(namespace + individualName, SpatialDataVocabulary.RECTANGLE);
		regionIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		confgureLocation(regionIndividual, SpatialDataVocabulary.LOCATION_PROPERTY, rectangle.getX1(), "x1", model,
				namespace);
		confgureLocation(regionIndividual, SpatialDataVocabulary.LOCATION_PROPERTY, rectangle.getX2(), "x2", model,
				namespace);
		scoIndividual.addProperty(individualProperty, regionIndividual);
	}

	private static void configurePoint(Point point, Individual scoIndividual, String individualName,
			Property individualProperty, OntModel model, String namespace) {
		Individual regionIndividual =
				model.createIndividual(namespace + individualName, SpatialDataVocabulary.POINT);
		regionIndividual.addProperty(RDF.type, OWL2.NamedIndividual);
		confgureLocation(regionIndividual, SpatialDataVocabulary.LOCATION_PROPERTY, point.getLocation(),
				"region_location", model, namespace);
		scoIndividual.addProperty(individualProperty, regionIndividual);
	}

	private static void setSmartCityObjectAttributes(SmartCityObject sco, Resource resource) throws ISCOException {
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_ID)) {
				sco.setId(UUID.fromString(statement.getObject().toString()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_LABEL)) {
				sco.setLabel(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_DESCRIPTION)) {
				sco.setDescription(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_DOMAIN)) {
				sco.getDomains().add(Domain.get(getStringWithSpaces(statement.getObject().asResource())));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_ACCESSIBILITY)) {
				sco.setAccessibility(Accessibility.get(getStringWithSpaces(statement.getObject().asResource())));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_PRECONDITION)
					|| statement.getPredicate().equals(OwlsProcessVocabulary.HAS_PRECONDITION)) {
				// TODO multiple preconditions
				// TODO set annotations
				sco.setPrecondition(getSWRLRule(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_ENDPOINT)) {
				sco.setEndpoint(getEndpoint(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_CLASSIFICATION)) {
				sco.setClassification(IRI.create(statement.getObject().asLiteral().getString()));
			}
		}
		iterator.close();
		
		// If there was no ID then generate a random one.
		if (sco.getId().equals(UUID.fromString(SmartCityObjectUtil.DEFAULT_UUID))) {
			sco.setId(UUID.randomUUID());
		}
		sco.setIri(IRI.create(resource.asResource().getURI()));
	}

	private static Endpoint getEndpoint(Resource resource) throws ISCOException {
		Endpoint endpoint = null;
		ExtendedIterator<Statement> iterator = resource
				.listProperties(RDF.type)
				.filterDrop(s->s.getObject().equals(OWL2.NamedIndividual));
		if (iterator.hasNext()) {
			Resource object = iterator.next().getObject().asResource();
			if (object.equals(SmartCityObjectVocabulary.REST_ENDPOINT)) {
				iterator.close();
				return getRestEndpoint(resource);
			} else if (object.equals(SmartCityObjectVocabulary.JIAC_AGENT_ENDPOINT)) {
				iterator.close();
				return getJiacAgentEndpoint(resource);
			}
		}
		return endpoint;
	}

	private static SWRLRule getSWRLRule(Resource subject) throws ISCOException {
		StmtIterator expressionObject = subject.asResource().listProperties(OwlsExpressionVocabulary.EXPRESSION_OBJECT);
		if (expressionObject.hasNext()) {
			return new SWRLRuleImpl(getSWRLAtoms(expressionObject.next().getObject().asResource(),
					new THashSet<>()), Collections.emptySet());
		}
		return getAnnotatedSWRLRule(subject);
	}
	
	private static SWRLRule getAnnotatedSWRLRule(Resource subject) throws ISCOException {
		ResIterator annotatedSWRLSubject = subject.getModel()
				.listSubjectsWithProperty(CONDITION_ANNOTATION, subject.asResource().getURI());
		if (!annotatedSWRLSubject.hasNext()) {
			return null;
		}
		Iterator<Statement> propertiesIterator = annotatedSWRLSubject.next().listProperties();
		Resource head = null;
		Resource body = null;
		while (propertiesIterator.hasNext() && (head == null || body == null)) {
			Statement statement = propertiesIterator.next();
			if (statement.getPredicate().equals(SwrlVocabulary.HEAD)) {
				head = statement.getObject().asResource();
			} else if (statement.getPredicate().equals(SwrlVocabulary.BODY)) {
				body = statement.getObject().asResource();
			}
		}
		return new SWRLRuleImpl(getSWRLAtoms(body, new THashSet<>()), getSWRLAtoms(head, new THashSet<>()));
	}

	private static Collection<SWRLAtom> getSWRLAtoms(Resource resource, Set<SWRLAtom> atoms)
			throws ISCOException {
		Statement typedStatement = null;
		try {
			typedStatement = resource.getProperty(RDF.type);
		} catch (HasNoModelException e) {
			return atoms;
		}
		if (typedStatement != null) {
			Statement atomStatement = typedStatement.getSubject().getProperty(RDF.first);
			
			// Convert to SWRLAtom
			if (atomStatement != null) {
				
				Statement argument1Statement = null;
				Statement argument2Statement = null;
				Statement atomTypeStatement = null;
				Statement predicateStatement = null;
				Statement argumentsStatement = null;
				StmtIterator iterator = atomStatement.getObject().asResource().listProperties();
				
				while (iterator.hasNext()) {
					Statement st = iterator.next();
					if (st.getPredicate().equals(SwrlVocabulary.ARGUMENT1)) {
						argument1Statement = st;
					} else if (st.getPredicate().equals(SwrlVocabulary.ARGUMENT2)) {
						argument2Statement = st;
					} else if (st.getPredicate().equals(SwrlVocabulary.ARGUMENTS)) {
						argumentsStatement = st;
					} else if (st.getPredicate().equals(RDF.type)
							&& st.getObject().asResource().toString().contains(SwrlVocabulary.URI)) {
						atomTypeStatement = st;
					} else if (st.getPredicate().equals(SwrlVocabulary.CLASS_PREDICATE)
							|| st.getPredicate().equals(SwrlVocabulary.PROPERTY_PREDICATE)
							|| st.getPredicate().equals(SwrlVocabulary.BUILTIN)) {
						predicateStatement = st;
					}
				}
				iterator.close();
				
				SWRLAtom atom = null;
				if (atomTypeStatement == null) {
					throw new ISCOException("No type for SWRL atom found!");
				} else {
					OWLDataFactory factory = OWLManager.getOWLDataFactory();
					
					if (predicateStatement == null) {
						throw new ISCOException("No predicate for SWRL atom found!");
					} else if (argument1Statement != null) {
						// ClassAtom
						Resource argument1 = argument1Statement.getObject().asResource();
						if (atomTypeStatement.getObject().equals(SwrlVocabulary.CLASS_ATOM)) {
							atom = factory.getSWRLClassAtom(
									factory.getOWLClass(
											IRI.create(predicateStatement.getObject().asResource().getURI())
											),
									getSWRLIArgument(argument1)
									);
						} else if (argument2Statement == null) {
							throw new ISCOException("No 2nd argument for two-type SWRL atom found!");
						} else
						// ObjectPropertyAtom
						if (atomTypeStatement.getObject().equals(SwrlVocabulary.INDIVIDUAL_PROPERTY_ATOM)) {
							atom = factory.getSWRLObjectPropertyAtom(
									factory.getOWLObjectProperty(
											IRI.create(predicateStatement.getObject().asResource().getURI())),
									getSWRLIArgument(argument1),
									getSWRLIArgument(argument2Statement.getObject().asResource())
									);
						} else
						// DataPropertyAtom
						if (atomTypeStatement.getObject().equals(SwrlVocabulary.DATAVALUED_PROPERTY_ATOM)) {
							SWRLDArgument b = null;
							RDFNode object = argument2Statement.getObject();
							if (object.isLiteral()) {
								b = factory.getSWRLLiteralArgument(factory.getOWLLiteral(
										object.asLiteral().getLexicalForm(),
										OWL2Datatype.getDatatype(IRI.create(object.asLiteral().getDatatypeURI())))
										);
							} else {
								throw new ISCOException("SWRL datavalued property atoms with "
										+ object.getClass().getSimpleName() + " as second argument currently not"
										+ "supported!");
							}
							atom = factory.getSWRLDataPropertyAtom(
									factory.getOWLDataProperty(
											IRI.create(predicateStatement.getObject().asResource().getURI())
											),
									getSWRLIArgument(argument1),
									b
									);
						}
					}
					//Test for SWRL Built-In
					else if (atomTypeStatement.getObject().equals(SwrlVocabulary.BUILTIN_ATOM)
							&& argumentsStatement != null) {
						atom = factory.getSWRLBuiltInAtom(
								IRI.create(predicateStatement.getObject().asResource().getURI()), 
								getSWRLBuiltinArguments(argumentsStatement.getObject().asResource()));
					}
					if (atom != null) {
						atoms.add(atom);
					}
				}
			}
			return getSWRLAtoms(
					Optional.ofNullable(typedStatement.getSubject().getProperty(RDF.rest))
							.map(st->st.getObject().asResource())
							.orElse(RDF.nil),
					atoms);
		}
		return atoms;
	}

	private static SWRLIArgument getSWRLIArgument(Resource argument) {
		OWLDataFactory factory = OWLManager.getOWLDataFactory();
		if (isVariable(argument)) {
			return factory.getSWRLVariable(IRI.create(argument.getURI()));
		} else {
			return factory.getSWRLIndividualArgument(factory.getOWLNamedIndividual(IRI.create(argument.getURI())));
		}
	}
	
	private static boolean isVariable(Resource resource) {
		return resource.hasProperty(RDF.type, SwrlVocabulary.VARIABLE);
	}

	private static List<SWRLDArgument> getSWRLBuiltinArguments(Resource rdfDescription) {
		Statement listStatement = rdfDescription.getProperty(RDF.type);
		if (listStatement != null && listStatement.getObject().equals(RDF.List)) {
			List<SWRLDArgument> list = new ArrayList<>();
			Statement firstStatement = rdfDescription.getProperty(RDF.first);
			if (firstStatement != null) {
				OWLDataFactory factory = OWLManager.getOWLDataFactory();
				RDFNode object = firstStatement.getObject();
				if (object.isLiteral()) {
						list.add(factory.getSWRLLiteralArgument(factory.getOWLLiteral(
								object.asLiteral().getLexicalForm(),
								factory.getOWLDatatype(object.asLiteral().getDatatypeURI()))
								));
				} else {
					list.add(factory.getSWRLVariable(IRI.create(object.asResource().getURI())));
				}
			}
			Statement restStatement = rdfDescription.getProperty(RDF.rest);
			if (restStatement != null) {
				list.addAll(getSWRLBuiltinArguments(restStatement.getObject().asResource()));
			}
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	private static String getStringWithSpaces(Resource resource) {
		return StringUtil.getStringWithSpaces(resource.getLocalName());
	}
	
	private static RestEndpoint getRestEndpoint(Resource resource) throws ISCOException {
		RestEndpoint restEndpoint = DomainmodelFactory.eINSTANCE.createRestEndpoint();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_URL)) {
				try {
					restEndpoint.setUri(new URI(statement.getObject().asLiteral().getString()));
					break;
				} catch (URISyntaxException e) {
					throw new ISCOException("Endpoint URL is malformed: " + e.getMessage());
				}
			}
		}
		iterator.close();
		return restEndpoint;
	}
	
	private static JiacAgentEndpoint getJiacAgentEndpoint(Resource resource) {
		JiacAgentEndpoint jiacAgentEndpoint = DomainmodelFactory.eINSTANCE.createJiacAgentEndpoint();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_AGENT_NODE_ID)) {
				jiacAgentEndpoint.setAgentNodeId(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_AGENT_ID)) {
				jiacAgentEndpoint.setAgentId(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_AGENT_ACTION_NAME)) {
				jiacAgentEndpoint.setActionName(statement.getObject().asLiteral().getString());
			}
		}
		iterator.close();
		return jiacAgentEndpoint;
	}

	private static void setDeviceAttributes(Device device, Resource resource) {
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_LOCATION)) {
				device.setLocation(getLocation(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_OPERATIONAL_AREA)) {
				device.setOperationalArea(getSpatialObject(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_ACTIVATION_STATUS)) {
				device.setActivationStatus(
						ActivationStatus.getByName(getStringWithSpaces(statement.getObject().asResource())));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_GROUP)) {
				device.setGroup(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_OWNER)) {
				device.setOwner(Owner.getByName(getStringWithSpaces(statement.getObject().asResource())));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_QUALITY_OF_DEVICE)) {
				device.setQuality(getQuality(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_TYPE)) {
				device.setType(IRI.create(statement.getObject().asLiteral().getString()));
			}
		}
		iterator.close();
	}
	
	private static Metric<?> getQuality(Resource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Service getService(Resource subject) throws ISCOException {
		Service service = DomainmodelFactory.eINSTANCE.createService();
		setSmartCityObjectAttributes(service, subject);
		setServiceAttributes(service, subject);
		return service;
	}

	private static void setServiceAttributes(Service service, Resource resource) throws ISCOException {
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_REGION)) {
				service.setRegion(getSpatialObject(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(OwlsProcessVocabulary.HAS_EFFECT)
					|| statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_EFFECT)) {
				// TODO multiple effects
				// TODO set annotations
				service.setEffect(getSWRLRule(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_PRIORITY)) {
				service.setPriority(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_BUNDLE)) {
				service.setBundle(statement.getObject().asLiteral().getString());
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_QUALITY_OF_SERVICE)) {
				service.setQuality(getQuality(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_INPUT)) {
				service.getInputs().add(getParameter(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_OUTPUT)) {
				service.getOutputs().add(getParameter(statement.getObject().asResource()));
			}
		}
		iterator.close();
	}
	
	private static SpatialObject getSpatialObject(Resource resource) {
		SpatialObject region = null;
		ExtendedIterator<Statement> iterator = resource.listProperties(RDF.type)
				.filterDrop(statement->statement.getObject().equals(OWL2.NamedIndividual));
		if (iterator.hasNext()) {
			Statement statement = iterator.next();
			RDFNode object = statement.getObject();
			if (object.equals(SpatialDataVocabulary.RECTANGLE)) {
				region = getRectangle(resource);
			} else if (object.equals(SpatialDataVocabulary.CIRCLE)) {
				region = getCircle(resource);
			} else if (object.equals(SpatialDataVocabulary.POLYGON)) {
				region = getPolygon(resource);
			} else if (object.equals(SpatialDataVocabulary.TRIANGLE)) {
//				region = SpatialdataFactory.eINSTANCE.create
			} else if (object.equals(SpatialDataVocabulary.POINT)) {
				region = getPoint(resource);
			}
		}
		iterator.close();
		return region;
	}

	private static SpatialObject getPoint(Resource resource) {
		Point point = SpatialdataFactory.eINSTANCE.createPoint();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SpatialDataVocabulary.LOCATION_PROPERTY)) {
				point.setLocation(getLocation(statement.getObject().asResource()));
				break;
			}
		}
		iterator.close();
		return point;
	}

	private static FreeForm getPolygon(Resource resource) {
		FreeForm freeForm = SpatialdataFactory.eINSTANCE.createFreeForm();
		resource.listProperties(SpatialDataVocabulary.LOCATION_PROPERTY)
				.mapWith(Statement::getObject)
				.mapWith(RDFNode::asResource)
				.forEachRemaining(location->freeForm.getLocations().add(getLocation(location)));
		return freeForm;
	}

	private static Circle getCircle(Resource resource) {
		Circle circle = SpatialdataFactory.eINSTANCE.createCircle();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SpatialDataVocabulary.RADIUS)) {
				circle.setRadius(statement.getObject().asLiteral().getInt());
			} else if (statement.getPredicate().equals(SpatialDataVocabulary.LOCATION_PROPERTY)) {
				circle.setLocation(getLocation(statement.getObject().asResource()));
			}
		}
		iterator.close();
		return circle;
	}

	private static Rectangle getRectangle(Resource resource) {
		Rectangle rectangle = SpatialdataFactory.eINSTANCE.createRectangle();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SpatialDataVocabulary.X1)) {
				rectangle.setX1(getLocation(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SpatialDataVocabulary.X2)) {
				rectangle.setX2(getLocation(statement.getObject().asResource()));
			}
		}
		iterator.close();
		return rectangle;
	}
	
	private static Location getLocation(Resource resource) {
		Location location = SpatialdataFactory.eINSTANCE.createLocation();
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SpatialDataVocabulary.ALTITUDE)) {
				location.setAltitude(statement.getObject().asLiteral().getDouble());
			} else if (statement.getPredicate().equals(SpatialDataVocabulary.LONGITUDE)) {
				location.setLongitude(statement.getObject().asLiteral().getDouble());
			} else if (statement.getPredicate().equals(SpatialDataVocabulary.LATITUDE)) {
				location.setLatitude(statement.getObject().asLiteral().getDouble());
			}
		}
		iterator.close();
		return location;
	}

	private static Parameter getParameter(Resource resource) throws ISCOException {
		Parameter parameter = DomainmodelFactory.eINSTANCE.createParameter();
		parameter.setLabel(resource.asResource().getLocalName());
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(OwlsProcessVocabulary.PARAMETER_TYPE)) {
				parameter.setType(IRI.create(statement.getObject().asLiteral().getString()));
			}
		}
		iterator.close();
		if (parameter.getType() == null) {
			throw new ISCOException("No type for parameter " + parameter.getLabel() + " found!");
		} 
		return parameter;
	}
	
	private static Device getSensor(Resource resource) throws ISCOException {
		Sensor device = DomainmodelFactory.eINSTANCE.createSensor();
		setSmartCityObjectAttributes(device, resource);
		setDeviceAttributes(device, resource);
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_OUTPUT)) {
				device.setOutput(getParameter(statement.getObject().asResource()));
			} else if (statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_MEASURING_MODE)) {
				device.setMode(MeasuringMode.getByName(getStringWithSpaces(statement.getObject().asResource())));
			}
		}
		iterator.close();
		return device;
	}
	
	private static Device getActuator(Resource resource) throws ISCOException {
		Actuator device = DomainmodelFactory.eINSTANCE.createActuator();
		setSmartCityObjectAttributes(device, resource);
		setDeviceAttributes(device, resource);
		StmtIterator iterator = resource.listProperties();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			if (statement.getPredicate().equals(OwlsProcessVocabulary.HAS_EFFECT)
					|| statement.getPredicate().equals(SmartCityObjectVocabulary.HAS_EFFECT)) {
				device.setEffect(getSWRLRule(statement.getObject().asResource()));
				break;
			}
		}
		iterator.close();
		return device;
	}
	
}
