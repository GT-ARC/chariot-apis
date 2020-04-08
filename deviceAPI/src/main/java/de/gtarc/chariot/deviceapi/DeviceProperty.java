/**
 *
 */
package de.gtarc.chariot.deviceapi;


import de.gtarc.commonapi.SimpleProperty;

public interface DeviceProperty extends SimpleProperty {

    Object getValue();

    void setValue(Object value);

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
