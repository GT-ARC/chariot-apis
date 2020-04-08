/**
 *
 */
package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.SimpleProperty;


public class SimplePropertyImpl implements SimpleProperty {

    private static final long TIMESTAMP_EDEFAULT = 0;

    private static final String KEY_EDEFAULT = "";

    private static final String TYPE_EDEFAULT = "";

    private static final Object VALUE_EDEFAULT = null;

    private static final String UNIT_EDEFAULT = null;


    protected long timestamp = TIMESTAMP_EDEFAULT;

    protected String key = KEY_EDEFAULT;

    protected String type = TYPE_EDEFAULT;

    protected Object value = VALUE_EDEFAULT;

    protected String unit = UNIT_EDEFAULT;


    public SimplePropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public Object getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void setValue(Object newValue) {
        if (newValue != null) {
            value = newValue;
        }

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void setUnit(String newUnit) {
        if (newUnit != null) {
            unit = newUnit;
        }

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String newType) {
        if (newType != null) {
            type = newType;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void setKey(String newKey) {
        key = newKey;
    }


} //SimplePropertyImpl
