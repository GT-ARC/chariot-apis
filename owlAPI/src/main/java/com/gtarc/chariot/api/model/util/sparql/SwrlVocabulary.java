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
public final class SwrlVocabulary {

    /**
     * The namespace of the vocabulary as a string
     */
    public static final String URI = "http://www.w3.org/2003/11/swrl#";
    
    /*
     * Classes
     */
    public static final Resource IMP = resource("Imp");
    public static final Resource ATOM_LIST = resource("AtomList");
    public static final Resource INDIVIDUAL_PROPERTY_ATOM = resource("IndividualPropertyAtom");
    public static final Resource CLASS_ATOM = resource("ClassAtom");
    public static final Resource DATAVALUED_PROPERTY_ATOM = resource("DatavaluedPropertyAtom");
    public static final Resource BUILTIN_ATOM = resource("BuiltinAtom");
    public static final Resource VARIABLE = resource("Variable");
    
    
    /*
     * Object Properties
     */
    public static final Property HEAD = property("head");
    public static final Property BODY = property("body");
    public static final Property ARGUMENT1 = property("argument1");
    public static final Property ARGUMENT2 = property("argument2");
    public static final Property PROPERTY_PREDICATE = property("propertyPredicate");
	public static final Property CLASS_PREDICATE = property("classPredicate");
	public static final Property BUILTIN = property("builtin");
	public static final Property ARGUMENTS = property("arguments");
	
    
    /**
     * Hidden constructor
     */
    private SwrlVocabulary() {}

    public static String getURI() {
    	return URI;
    }

    private static final Resource resource(String local) {
    	return ResourceFactory.createResource(URI + local);
    }
    
    protected static final Property property(String local) {
    	return ResourceFactory.createProperty(URI, local);
    }

}
