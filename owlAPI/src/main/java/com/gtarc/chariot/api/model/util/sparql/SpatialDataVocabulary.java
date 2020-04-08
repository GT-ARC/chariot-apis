package com.gtarc.chariot.api.model.util.sparql;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * Spatial Data Vocabulary
 * 
 * @author ckuster
 *
 */
public final class SpatialDataVocabulary {

    /**
     * The namespace of the vocabulary as a string
     */
    public static final String uri = "http://isco-dev.aot.tu-berlin.de/ontologies/spatialdata.owl#";
    
    /*
     * Classes
     */
    public static final Resource SPATIALOBJECT = resource("SpatialObject");
    public static final Resource POINT = resource("Point");
    public static final Resource RECTANGLE = resource("Rectangle");
    public static final Resource CIRCLE = resource("Circle");
    public static final Resource POLYGON = resource("Polygon");
    public static final Resource TRIANGLE = resource("Triangle");
    public static final Resource LOCATION_CLASS = resource("Location");
    
    /*
     * Data Properties
     */
    public static final Property ALTITUDE = property("altitude");
    public static final Property LATITUDE = property("latitude");
    public static final Property LONGITUDE = property("longitude");
    public static final Property RADIUS = property("radius");
    
    /*
     * Object Properties
     */
    public static final Property IS_NEAREST = property("isNearest");
    public static final Property IS_WITHIN = property("isWithin");
    public static final Property LOCATION_PROPERTY = property("location");
    public static final Property X1 = property("x1");
    public static final Property X2 = property("x2");
    
    /**
     * Hidden constructor
     */
    private SpatialDataVocabulary() {}

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
