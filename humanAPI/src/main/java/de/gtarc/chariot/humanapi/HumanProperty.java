package de.gtarc.chariot.humanapi;

import de.gtarc.commonapi.Property;

public interface HumanProperty extends Property {

    Object getValue();

    void setValue(Object value);

    String getUnit();

    void setUnit(String unit);

    String getType();

    void setType(String type);

    boolean getWritable();

    void setWritable(boolean writable);

    Double getMin();

    void setMin(Double min);

    Double getMax();

    void setMax(Double max);


}
