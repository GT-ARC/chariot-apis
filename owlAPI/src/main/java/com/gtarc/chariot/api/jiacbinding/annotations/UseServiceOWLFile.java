package com.gtarc.chariot.api.jiacbinding.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * With this annotation JIAC V actions can be linked to a SCO description file in the OWL format.
 * 
 * @author ckuster
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseServiceOWLFile {
	
	String filename() default "";

}
