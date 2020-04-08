/**
 *
 */
package de.gtarc.chariot.deviceapi;


import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;

public interface ComplexDeviceProperty extends SimpleProperty {

    Property[] getValue();

    void setValue(Property[] value);

    String getUnit();

    void setUnit(String unit);

    String getType();

    void setType(String type);

    boolean getWritable();

    void setWritable(boolean writable);

    String getMin();

    void setMin(String min);

    String getMax();

    void setMax(String max);


} // SimpleProperty
