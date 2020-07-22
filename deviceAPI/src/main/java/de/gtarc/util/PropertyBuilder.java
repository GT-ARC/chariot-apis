package de.gtarc.util;

import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

import java.util.ArrayList;
import java.util.List;


public class PropertyBuilder {

    protected String key;

    /* Simple Property Only */
    protected Object value;
    protected String unit;
    protected String type;

    /* Device Property Only */
    protected boolean writable;
    protected Double min;
    protected Double max;

    /* Complex Property */
    List<Property> subProperties = new ArrayList<Property>();

    public String getKey() {
        return key;
    }

    public PropertyBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public PropertyBuilder setValue(Object value) {
        this.value = value;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public PropertyBuilder setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getType() {
        return type;
    }

    public PropertyBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public boolean getWritable() {
        return writable;
    }

    public PropertyBuilder setWritable(boolean writable) {
        this.writable = writable;
        return this;
    }

    public Double getMin() {
        return min;
    }

    public PropertyBuilder setMin(Double min) {
        this.min = min;
        return this;
    }

    public Double getMax() {
        return max;
    }

    public PropertyBuilder setMax(Double max) {
        this.max = max;
        return this;
    }

    public List<Property> getSubProperties() {
        return subProperties;
    }

    public PropertyBuilder addSubProperty(Property subProperty) {
        this.subProperties.add(subProperty);
        return this;
    }

    public Property build() {
        Property property;

        if (subProperties.isEmpty()) {
            if (!Double.isNaN(min) || !Double.isNaN(max)) {
                property = new DevicePropertyImpl();
                ((DevicePropertyImpl) property).setMin(this.min);
                ((DevicePropertyImpl) property).setMax(this.max);
                ((DevicePropertyImpl) property).setWritable(this.writable);
                ((DevicePropertyImpl) property).setUnit(this.unit);
                ((DevicePropertyImpl) property).setValue(this.value);
                ((DevicePropertyImpl) property).setType(this.type);
            } else {
                property = new SimplePropertyImpl();
                ((SimplePropertyImpl) property).setUnit(this.unit);
                ((SimplePropertyImpl) property).setValue(this.value);
                ((SimplePropertyImpl) property).setType(this.type);
            }
        } else {
            property = new ComplexPropertyImpl();
            Property finalProperty = property;
            this.subProperties.forEach(p -> ((ComplexPropertyImpl) finalProperty).addSubProperty((SimpleProperty) p));
        }

        property.setKey(this.key);

        return property;
    }
}
