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
public final class OwlsProcessVocabulary {

    /**
     * The namespace of the vocabulary as a string
     */
    public static final String uri = "http://www.daml.org/services/owl-s/1.2/Process.owl#";
    
    /*
     * Classes
     */
    public static final Resource INPUT = resource("Input");
    public static final Resource OUTPUT = resource("Output");
    
    /*
     * Object Properties
     */
    public static final Property PARAMETER_TYPE = property("parameterType");
	public static final Property HAS_PRECONDITION = property("hasPrecondition");
	public static final Property HAS_EFFECT = property("hasEffect");
    
    /**
     * Hidden constructor
     */
    private OwlsProcessVocabulary() {}

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
