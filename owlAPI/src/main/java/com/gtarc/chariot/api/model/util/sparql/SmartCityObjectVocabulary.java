package com.gtarc.chariot.api.model.util.sparql;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * Smart City Objects Vocabulary
 * 
 * @author ckuster
 *
 */
public final class SmartCityObjectVocabulary {

    /**
     * The namespace of the vocabulary as a string
     */
    public static final String uri = "http://isco-dev.aot.tu-berlin.de/ontologies/smart_city_objects.owl#";
    
    /*
     * Classes
     */
    public static final Resource SMART_CITY_OBJECT = resource("SmartCityObject");
    public static final Resource SERVICE = resource("Service");
    public static final Resource DEVICE = resource("Device");
    public static final Resource SENSOR = resource("Sensor");
    public static final Resource ACTUATOR = resource("Actuator");
    public static final Resource REST_ENDPOINT = resource("RestEndpoint");
    public static final Resource JIAC_AGENT_ENDPOINT = resource("JiacAgentEndpoint");
    
    /*
     * Object Properties
     */
    public static final Property HAS_ACCESSIBILITY = property("hasAccessibility");
    public static final Property HAS_ACTIVATION_STATUS = property("hasActivationStatus");
    public static final Property HAS_DOMAIN = property("hasDomain");
    public static final Property HAS_INPUT = property("hasInput");
    public static final Property HAS_OPERATIONAL_AREA = property("hasOperationalArea");
    public static final Property HAS_OUTPUT = property("hasOutput");
    public static final Property HAS_OWNER = property("hasOwner");
    public static final Property HAS_PRECONDITION = property("hasPrecondition");
    public static final Property HAS_QUALITY = property("hasQuality");
    public static final Property HAS_QUALITY_OF_SERVICE = property("hasQualityOfService");
    public static final Property HAS_QUALITY_OF_DEVICE = property("hasQualityOfDevice");
    public static final Property HAS_QUANTITY_KIND = property("hasQuantityKind");
    public static final Property HAS_REGION = property("hasRegion");
    public static final Property HAS_EFFECT = property("hasEffect");
    public static final Property HAS_UNIT = property("hasUnit");
    public static final Property HAS_USED_SERVICES = property("hasUsedServices");
    public static final Property HAS_ENDPOINT = property("hasEndpoint");
    public static final Property HAS_MEASURING_MODE = property("hasMeasuringMode");
    public static final Property HAS_TYPE = property("hasType");
    public static final Property HAS_CLASSIFICATION = property("hasClassification");
    public static final Property HAS_LOCATION = property("hasLocation");
    
    /*
     * Data Properties
     */
    public static final Property HAS_BUNDLE = property("hasBundle");
    public static final Property HAS_DESCRIPTION = property("hasDescription");
    public static final Property HAS_GROUP = property("hasGroup");
    public static final Property HAS_ID = property("hasID");
    public static final Property HAS_LABEL = property("hasLabel");
    public static final Property HAS_PRIORITY = property("hasPriority");
    public static final Property HAS_URL = property("hasUrl");
    public static final Property HAS_AGENT_ID = property("hasAgentId");
    public static final Property HAS_AGENT_NODE_ID = property("hasAgentNodeId");
    public static final Property HAS_AGENT_ACTION_NAME = property("hasAgentActionName");

    /**
     * Hidden constructor
     */
    private SmartCityObjectVocabulary() {}

    public static String getURI() {
    	return uri;
    }

    private static final Resource resource(String local) {
    	return ResourceFactory.createResource(uri + local);
    }
    
    protected static final Property property(String local) {
    	return ResourceFactory.createProperty(uri, local);
    }

}
