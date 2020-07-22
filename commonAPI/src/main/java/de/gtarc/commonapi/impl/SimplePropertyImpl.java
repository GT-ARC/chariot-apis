/**
 *
 */
package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.SimpleProperty;


public class SimplePropertyImpl extends PropertyImpl<Object> implements SimpleProperty {

    private static final Object VALUE_EDEFAULT = null;

    private static final Double MIN_EDEFAULT = null;
    private static final Double MAX_EDEFAULT = null;

    protected Object value = VALUE_EDEFAULT;
    protected Double min = MIN_EDEFAULT;
    protected Double max = MAX_EDEFAULT;


    public SimplePropertyImpl() {
        super();
    }


    @Override
    public Object getValue() {
        return value;
    }


    @Override
    public void setValue(Object newValue) {
        if (newValue != null) {
            value = newValue;
        }

    }

    @Override
    public Double getMin() {
        return min;
    }

    @Override
    public void setMin(Double min) {
        this.min = min;
    }

    @Override
    public Double getMax() {
        return max;
    }

    @Override
    public void setMax(Double max) {
        this.max = max;
    }


    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append("{\n\"timestamp\": \"");
        result.append(timestamp);
        result.append("\",\n\"key\": \"");
        result.append(key);
        result.append("\",\n\"type\": \"");
        result.append(type);
        result.append("\",\n\"value\": \"");
        result.append(value);
        result.append("\",\n\"unit\": \"");
        result.append(unit);
        result.append("\"\n}");
        return result.toString();

    }

} //SimplePropertyImpl
