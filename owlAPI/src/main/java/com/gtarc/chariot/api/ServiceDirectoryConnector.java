package com.gtarc.chariot.api;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryParseException;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLDataPropertyAtom;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.ActivationStatus;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.RestEndpoint;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.exception.ISCOException;
import com.gtarc.chariot.api.model.exception.ISCORequestException;
import com.gtarc.chariot.api.model.util.SmartCityObjectUtil;
import com.gtarc.chariot.api.model.util.StringUtil;
import com.gtarc.chariot.api.model.util.sparql.JenaConverter;
import com.gtarc.chariot.api.model.util.sparql.SparqlQueryBuilder;
import com.gtarc.chariot.api.model.util.sparql.SwrlVocabulary;
import com.gtarc.quality.qualitymodel.metric.Metric;
import com.gtarc.quality.qualitymodel.parameter.Requirement;

import gnu.trove.map.hash.THashMap;

/**
 * Utility class for the service directory. It provides methods for interacting
 * with the service directory.
 * 
 * @author ckuster
 *
 */
public class ServiceDirectoryConnector {
	
	static final Logger LOG = LoggerFactory.getLogger(ServiceDirectoryConnector.class);
	
	/**
	 * SPARQL Separator
	 */
	private static final String SEP = " . ";

	/**
	 * Generic statement to bind variables X, Y, Z
	 */
	private static final String X_Y_Z = "?x ?y ?z . ";

	/**
	 * Statement that says X is a Service
	 */
	private static final String X_A_SCO_SERVICE = "?x a sco:Service . ";
	
	/**
	 * Statement that says X is a Sensor
	 */
	private static final String X_A_SCO_SENSOR = "?x a sco:Sensor . ";
	
	/**
	 * Statement that says X is an Actuator
	 */
	private static final String X_A_SCO_ACTUATOR = "?x a sco:Actuator . ";
	
	private static final String NESTED_CONSTRUCT = "?item ?childprop ?childpropval . "
			+ "?somesubj ?incomingchildprop ?item . ";
	
	private static final String NESTED_CLAUSE = "?x (sco:hasID|!sco:hasID)+ ?item . "
			+ "OPTIONAL {?item ?childprop ?childpropval . "
			+ "?somesubj ?incomingchildprop ?item} ";

	/**
	 * URL to the SPARQL address of the Apache Jena Fuseki server.
	 */
	protected URL endpoint;
	
	/**
	 * URL to the graph model.
	 */
	protected URL graphModel;
	
	private Map<UUID, SmartCityObject> smartCityObjects = new THashMap<>();

	/**
	 * Prefixes for SPARQL queries
	 */
	protected String[] prefixes = new String[]{
			"prefix owl: <http://www.w3.org/2002/07/owl#>",
			"prefix sco: <http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#>",
			"prefix owls: <http://www.daml.org/services/owl-s/1.2/Process.owl#>",
			"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>",
			"prefix swrl: <http://www.w3.org/2003/11/swrl#>",
			"prefix dc: <http://purl.org/dc/elements/1.1/>",
			"prefix xsd: <http://www.w3.org/2001/XMLSchema#>"
			};
	
	protected String getGraphModel() {
		return graphModel.toString().replaceAll(":[\\d]+/", "/");
	}

	public ServiceDirectoryConnector(URL endpoint, String graphModelName) throws MalformedURLException {
		this.endpoint = endpoint;
		
		String endpointString = endpoint.toString();
		if (!endpoint.toString().endsWith("/")) {
			endpointString = this.endpoint.toString() + "/";
		}
		this.graphModel = new URL(endpointString + graphModelName);
	}

	/**
	 * Register the given smart city object at the service directory.
	 * 
	 * @param smartCityObject
	 *            The smart city object that should be registered.
	 * @param serviceProviderId
	 *            The ID of the service provider.
	 * @param serviceProviderPassword
	 *            The password for authenticating the service provider.
	 */
	public void register(SmartCityObject smartCityObject, String serviceProviderId, String serviceProviderPassword) {
		String namespace = getNamespace(smartCityObject);
		Model model = JenaConverter.convertToJenaModel(smartCityObject, namespace);
		OutputStream stream = new ByteArrayOutputStream();
		model.write(stream, "N-TRIPLE");
		String query = null;
		query = " INSERT DATA { GRAPH <" + getGraphModel() + "> { " + stream.toString() + " } }; "
				+ "DELETE { <" + graphModel + "> dc:date ?date } "
				+ "INSERT { <" + graphModel + "> dc:date \""
				+ new XSDDateTime(Calendar.getInstance()).toString() + "\"^^xsd:dateTime"
				+ "} WHERE {"
				+ " <" + graphModel + "> dc:date ?date "
				+ "}";
		
		if (requestSmartCityObject(smartCityObject.getId()).isPresent()) {
			query = String.join(" ", prefixes)
					+ " WITH <" + getGraphModel() + ">\nDELETE {" + X_Y_Z + NESTED_CONSTRUCT + "}\nWHERE {" 
					+ X_Y_Z + " ?x sco:hasID \""
					+ smartCityObject.getId() + "\" "+ SEP + NESTED_CLAUSE + "}; " + query;
		} else {
			query = String.join(" ", prefixes) + query;
		}
		LOG.debug("Registering {}", smartCityObject);
		try {
			UpdateRequest r = UpdateFactory.create(query);
			UpdateProcessor processor = UpdateExecutionFactory.createRemote(r, this.endpoint.toString());
			processor.execute();
		} catch (QueryParseException e) {
			LOG.error("Error parsing query: {}", query, e);
		}
		// After SCO is successfully registered update the SCO IRI
		smartCityObject.setIri(getIRI(smartCityObject));
	}
	
	/**
	 * Returns the IRI for a Smart City Object in the context of this Service Directory Connector.
	 * 
	 * @param smartCityObject The entity for which the IRI should be returned.
	 * @return The IRI valid in the context of this connector
	 */
	public IRI getIRI(SmartCityObject smartCityObject) {
		if (smartCityObject.getIri() != null && smartCityObject.getIri().getIRIString().contains(getGraphModel())) {
			return smartCityObject.getIri();
		} else {
			return IRI.create(SmartCityObjectUtil.getLabelUri(smartCityObject, getNamespace(smartCityObject)));
		}
	}
	
	/**
	 * Unregister the given smart city object at the service directory.
	 * 
	 * @param smartCityObject
	 *            The smart city object that should be unregistered.
	 * @param serviceProviderId
	 *            The ID of the service provider.
	 * @param serviceProviderPassword
	 *            The password for authenticating the service provider.
	 */
	public void unregister(SmartCityObject smartCityObject, String serviceProviderId, String serviceProviderPassword) {
		Model model = JenaConverter.convertToJenaModel(smartCityObject, getNamespace(smartCityObject));
		OutputStream stream = new ByteArrayOutputStream();
		model.write(stream, "N-TRIPLE");
		String query = null;
		query = "PREFIX sco: <http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#>"
				+ "WITH <" + getGraphModel() + ">\nDELETE {" + X_Y_Z + NESTED_CONSTRUCT + " ?o ?a ?c}\nWHERE {" 
				+ X_Y_Z + " OPTIONAL {?o ?a ?c . ?o a <http://www.w3.org/2002/07/owl#Ontology> .} ?x sco:hasID \""
				+ smartCityObject.getId() + "\" "+ SEP + NESTED_CLAUSE + "}";
		UpdateRequest r = UpdateFactory.create(query);
		UpdateProcessor processor = UpdateExecutionFactory.createRemote(r, this.endpoint.toString());
		processor.execute();
	}

	private String getNamespace(SmartCityObject smartCityObject) {
		String namespace = getGraphModel();
		if (namespace.endsWith("#")) {
			namespace = namespace.substring(0, namespace.length()-1) + "/" + smartCityObject.getId() + "#";
		} else {
			namespace = namespace + "/" + smartCityObject.getId() + "#";
		}
		return namespace;
	}
	
	/**
	 * Request a specific service from the service directory using a sparql query.
	 * 
	 * @param id
	 *            The ID of the requested Smart city Object. 
	 * @return The corresponding service, or {@code null} if no fitting service
	 *         was found.
	 */
	public Optional<SmartCityObject> requestSmartCityObject(UUID id) {
		if (isGraphUnmodified() && !smartCityObjects.isEmpty()) {
			return Optional.ofNullable(smartCityObjects.get(id));
		}
		LOG.debug("requestSmartCityObject called with parameter: UUID id = {}", id);
		Set<SmartCityObject> set = requestSmartCityObject(
				X_Y_Z
				+ NESTED_CONSTRUCT,
				X_Y_Z 
				+ "?x sco:hasID \"" + id + "\" "+ SEP 
				+ NESTED_CLAUSE);
		if (set.isEmpty()) {
			return Optional.empty();
		}
		SmartCityObject smartCityObject = set.iterator().next();
		smartCityObjects.put(id, smartCityObject);
		return Optional.of(smartCityObject);
	}
	
	private boolean isGraphUnmodified() {
		String query = String.join(" ", prefixes)  + " ASK { <" + graphModel + "> dc:date ?date FILTER ( ?date < \""
				+ new XSDDateTime(Calendar.getInstance()).toString() + "\"^^xsd:dateTime ) }";
		LOG.trace("Query = {}", query);
		QueryExecution q = QueryExecutionFactory.sparqlService(endpoint.toString(), query);
		return q.execAsk();
	}

	private Set<SmartCityObject> requestSmartCityObject(String constructClause, String whereClause) {
		String query = SparqlQueryBuilder.buildQuery(
				prefixes,
				"<" + getGraphModel() + ">",
				"CONSTRUCT {" + constructClause + "} WHERE",
				whereClause);
		LOG.trace("Query = {}", query);
		try (QueryExecution q = QueryExecutionFactory.sparqlService(endpoint.toString(), query)) {
			Set<SmartCityObject> set = JenaConverter.convertToSmartCityObjects(
					q.execConstruct(),
					isGraphUnmodified() && !smartCityObjects.isEmpty() ? smartCityObjects : Collections.emptyMap()
					);
			set.forEach(sco->smartCityObjects.put(sco.getId(), sco));
			return set;
		} catch (ISCOException e) {
			return Collections.emptySet();
		}
	}
	
	/**
	 * Request Smart city Objects that fulfil the given template. Only set attributes are considered.
	 * 
	 * @param template The template that has to match the results.
	 * @return A set of matching Smart City Objects
	 * @throws ISCORequestException 
	 */
	public Set<SmartCityObject> requestSmartCityObject(SmartCityObject template) throws ISCORequestException {
		if (template != null) {
			// Search for ID
			UUID id = template.getId();
			if (id != null && !id.equals(UUID.fromString(SmartCityObjectUtil.DEFAULT_UUID))) {
				LOG.debug("Found id \"{}\"", id);
				Optional<SmartCityObject> optional = requestSmartCityObject(id);
				return optional.isPresent() ? Collections.singleton(optional.get()) : Collections.emptySet();
			}
		}
		
		// If we are here, we have to generate the SPARQL triples for the template
		String sparqlTriplesForTemplate = getSPARQLTriplesForTemplate(template);
		LOG.debug("Template as SPARQL triples: t={}" , sparqlTriplesForTemplate);
		return  requestSmartCityObject(
				X_Y_Z
				+ NESTED_CONSTRUCT,
				X_Y_Z 
				+ getSPARQLTypeTriple(template)
				+ sparqlTriplesForTemplate
				+ NESTED_CLAUSE);
	}

	private String getSPARQLTriplesForTemplate(SmartCityObject template) throws ISCORequestException {
		StringBuilder templateStringBuilder = new StringBuilder();
			if (template != null) {
				templateStringBuilder.append(generateSPARQLTriplesForSmartCityObject(template));
			if (template instanceof Device) {
				templateStringBuilder.append(generateSPARQLTriplesforDevice((Device) template));
			} else if (template instanceof Service) {
				templateStringBuilder.append(generateSPARQLTriplesforService((Service) template));
			}
		}
		return templateStringBuilder.toString();
	}

	private String getSPARQLTypeTriple(SmartCityObject template) {
		if (template != null) {
			if (template instanceof Service) {
				return X_A_SCO_SERVICE;
			} else if (template instanceof Sensor) {
				return X_A_SCO_SENSOR;
			} else {
				return X_A_SCO_ACTUATOR;
			}
		}
		return null;
	}

	private String generateSPARQLTriplesForSmartCityObject(SmartCityObject template) {
		StringBuilder sb = new StringBuilder();
		if (template.getLabel() != null && !template.getLabel().isEmpty()) {
			sb.append("?x sco:hasLabel \"" + template.getLabel() + "\"" + SEP);
		}
		if (template.getDescription() != null && !template.getDescription().isEmpty()) {
			sb.append("?x sco:hasDescription \"" + template.getDescription() + "\"" + SEP);
		}
		if (template.getDomains().isEmpty()) {
			for (Domain domain : template.getDomains()) {
				sb.append("?x sco:hasDomain sco:"
						+ StringUtil.getStringWithoutSpaces(domain.getLiteral()) + SEP);
			}
		}
		if (!template.getAccessibility().equals(Accessibility.UNDEFINED)) {
			sb.append("?x sco:hasAccessibility sco:"
					+ StringUtil.getStringWithoutSpaces(template.getAccessibility().getLiteral()) + SEP);
		}
		SWRLRule precondition = template.getPrecondition();
		if (precondition != null) {
			sb.append(generateSPARQLQueryForSWRLRule(precondition, "pre"));
		}
		Endpoint templateEndpoint = template.getEndpoint();
		if (templateEndpoint != null) {
			sb.append("?x sco:hasEndpoint ?endpoint" + SEP);
			if (templateEndpoint instanceof RestEndpoint) {
				sb.append("?endpoint sco:hasUrl \"" + ((RestEndpoint) templateEndpoint).getUri() + "\"" + SEP);
			} else { // JiacAgentEndpoint
				sb.append("?endpoint sco:hasEndpoint ?endpoint" + SEP);
			}
		}
		if (template.getQuality() != null) {
			sb.append(generateSPARQLTriplesForQualityMatching(template.getQuality()));
		}
		return sb.toString();
	}

	private String generateSPARQLQueryForSWRLRule(SWRLRule swrlRule, String prefix) {
		StringBuilder sb = new StringBuilder();
		final AtomicInteger i = new AtomicInteger(1);
		swrlRule.body().forEach(
				atom -> {
					Integer suffix = Integer.valueOf(i.getAndIncrement());
					sb.append(String.format("?%1$simp (sco:hasID|!sco:hasID)+ ?%1$sitem%2$d", prefix, suffix) + SEP);
					String predicate = null;
					String object = null;
					if (atom instanceof SWRLObjectPropertyAtom) {
						predicate = "<" + SwrlVocabulary.PROPERTY_PREDICATE.getURI() + ">";
						object = ((SWRLObjectPropertyAtom) atom).getPredicate().asOWLObjectProperty().getIRI()
								.getIRIString() + ">";
					} else if (atom instanceof SWRLClassAtom) {
						predicate = "<" + SwrlVocabulary.CLASS_PREDICATE.getURI() + ">";
						object = "<" + ((SWRLClassAtom) atom).getPredicate().asOWLClass().getIRI().getIRIString() + ">";
					} else if (atom instanceof SWRLDataPropertyAtom) {
						predicate = "<" + SwrlVocabulary.PROPERTY_PREDICATE.getURI() + ">";
						object = "<" + ((SWRLDataPropertyAtom) atom).getPredicate().asOWLDataProperty().getIRI()
								.getIRIString() + ">";
					}
					//?effitem1 <http://www.w3.org/2003/11/swrl#classPredicate> <http://example-ontology.de/#Example1Class> .
					sb.append(
							String.format(
									"?%1$sitem%2$d %3$s %4$s", prefix, suffix, predicate, object
									) + SEP
							);
					});
		return sb.toString();
	}

	private String generateSPARQLTriplesforService(Service template) throws ISCORequestException {
		StringBuilder sb = new StringBuilder();
		if (template.getBundle() != null && !template.getBundle().isEmpty()) {
			sb.append("?x sco:hasBundle \"" + template.getBundle() + "\"" + SEP);
		}
		SWRLRule effect = template.getEffect();
		if (effect != null) {
			sb.append(generateSPARQLQueryForSWRLRule(effect, "eff"));
		}
		if (!template.getInputs().isEmpty()) {
			for (Parameter parameter : template.getInputs()) {
				sb.append("?x sco:hasInput ?" + parameter.getLabel() + SEP);
				sb.append("?" + parameter.getLabel() + " owls:parameterType \"" + parameter.getType() + "\"" + SEP);
			}
		}
		if (!template.getOutputs().isEmpty()) {
			for (Parameter parameter : template.getOutputs()) {
				sb.append("?x sco:hasOutput ?" + parameter.getLabel() + SEP);
				sb.append("?" + parameter.getLabel() + " owls:parameterType \"" + parameter.getType() + "\"" + SEP);
			}
		}
		if (template.getPriority() != null && !template.getPriority().isEmpty()) {
			sb.append("?x sco:hasPriority \"" + template.getPriority() + "\"" + SEP);
		}
		if (template.getRegion() != null) {
			// TODO Implement
			throw new ISCORequestException("Template matching for region not yet implemented!");
		}
		return sb.toString();
		
	}

	private String generateSPARQLTriplesforDevice(Device template) throws ISCORequestException {
		StringBuilder sb = new StringBuilder();
		if (template.getLocation() != null) {
			// TODO Implement
			throw new ISCORequestException("Template matching for location not yet implemented!");
		}
		if (template.getOperationalArea() != null) {
			// TODO Implement
			throw new ISCORequestException("Template matching for operational area not yet implemented!");
		}
		if (!template.getActivationStatus().equals(ActivationStatus.UNDEFINED)) {
			sb.append("?x sco:hasActivationStatus sco:"
					+ StringUtil.getStringWithoutSpaces(template.getActivationStatus().getLiteral()) + SEP);
		}
		String group = template.getGroup();
		if (group != null && !group.isEmpty()) {
			sb.append("?x sco:hasGroup \"" + template.getGroup() + "\"" + SEP);
		}
		if (!template.getProperties().isEmpty()) {
			// TODO Implement
			throw new ISCORequestException("Template matching for device properties not yet implemented!");
		}
		if (template.getType() != null) {
			sb.append("?x sco:hasType <" + template.getType() + ">" + SEP);
		}
		
		if (template instanceof Sensor) {
			Sensor templateSensor = (Sensor) template;
			if (templateSensor.getOutput() != null) {
				sb.append("?x sco:hasOutput ?sensoroutput" + SEP);
				sb.append("?sensoroutput" + " owls:parameterType \"" + templateSensor.getType() + "\"" + SEP);
			}
			if (!templateSensor.getMode().equals(MeasuringMode.UNDEFINED)) {
				sb.append("?x sco:hasMeasuringMode sco:" +
						StringUtil.getStringWithoutSpaces(templateSensor.getMode().getLiteral()) + "" + SEP);
			}
		} else if (template instanceof Actuator) {
			Actuator templateActuator = (Actuator) template;
			SWRLRule effect = templateActuator.getEffect();
			if (effect != null) {
				sb.append(generateSPARQLQueryForSWRLRule(effect, "eff"));
			}
		}
		return sb.toString();
	}
	
	private String generateSPARQLTriplesForQualityMatching(Metric<?> quality) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Request Smart city Objects that fulfil the given metric.
	 * 
	 * @param requirement The metric to be matched.
	 * @return A set of matching Smart City Objects
	 */
	public Set<SmartCityObject> requestSmartCityObject(Requirement requirement) {
		LOG.debug("requestSmartCityObject called with parameter: Requirement requirement = {}", requirement);
		return Collections.emptySet();
	}

	/**
	 * Request all services from given domain(s).
	 * 
	 * @param domains
	 *            The requested domain(s).
	 * @return A set of found services. May be empty.
	 */
	public Set<SmartCityObject> requestAllSmartCityObjectsFromDomains(Domain... domains) {
		StringBuilder whereClause = new StringBuilder(X_Y_Z);
		if (domains != null) {
			String s = Arrays.asList(domains).stream()
					.map(domain -> "sco:" + StringUtil.getStringWithoutSpaces(domain.getLiteral()))
					.collect(Collectors.joining(" "));
			whereClause.append("VALUES ?domain {").append(s).append("}");
			whereClause.append(" . ?x sco:hasDomain ?domain . ");
		}
		whereClause.append(NESTED_CLAUSE + "?x sco:hasDomain ?domain");
		String constructClause = X_Y_Z + NESTED_CONSTRUCT;
		String query = SparqlQueryBuilder.buildQuery(
				prefixes,
				"<" + getGraphModel() + ">",
				"CONSTRUCT {" + constructClause + "} WHERE",
				whereClause.toString());
		
		try (QueryExecution q = QueryExecutionFactory.sparqlService(endpoint.toString(), query)) {
			Set<SmartCityObject> set = JenaConverter.convertToSmartCityObjects(
					q.execConstruct(),
					isGraphUnmodified() && !smartCityObjects.isEmpty() ? smartCityObjects: Collections.emptyMap()
					);
			set.forEach(sco->smartCityObjects.put(sco.getId(), sco));
			return set;
		} catch (ISCOException e) {
			return Collections.emptySet();
		}
	}

	public Set<String> query(String sparqlQuery) {
		try (QueryExecution q = QueryExecutionFactory.sparqlService(endpoint.toString(), sparqlQuery)) {
			ResultSet results = q.execSelect();
			Set<String> resultSet = new HashSet<>();
			results.forEachRemaining(r->resultSet.add(r.toString()));
			return resultSet;
		}
	}
	
	/**
	 * This method can be used for update queries. For select queries use {@link #query(String)}.
	 * 
	 * @param query The update query to process.
	 */
	public void update(String query) {
		UpdateRequest r = UpdateFactory.create(query);
		UpdateProcessor processor = UpdateExecutionFactory.createRemote(r, this.endpoint.toString());
		processor.execute();
	}
	
	public URL getEndpoint() {
		return endpoint;
	}

}
