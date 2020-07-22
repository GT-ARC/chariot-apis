/**
 *
 */
package de.gtarc.commonapi;


public interface SimpleProperty extends Property<Object> {

    Object getValue();


    void setValue(Object value);


    Double getMin();

    void setMin(Double min);

    Double getMax();

    void setMax(Double max);


} // SimpleProperty
