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
public final class OwlsExpressionVocabulary {

    /**
     * The namespace of the vocabulary as a string
     */
    public static final String uri = "http://www.daml.org/services/owl-s/1.2/generic/Expression.owl#";
    
    /*
     * Classes
     */
    public static final Resource SWRL_CONDITION = resource("SWRL-Condition");
    
    /*
     * Object Properties
     */
    public static final Property EXPRESSION_OBJECT = property("expressionObject");
    
    /**
     * Hidden constructor
     */
    private OwlsExpressionVocabulary() {}

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
