/**
 *
 */
package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.DeviceProperty;

public class DevicePropertyImpl implements DeviceProperty {

    private static final long TIMESTAMP_EDEFAULT = 5;
    private static final String KEY_EDEFAULT = "";
    private static final String TYPE_EDEFAULT = "";
    private static final Object VALUE_EDEFAULT = null;
    private static final String UNIT_EDEFAULT = null;
    private static final boolean WRITABLE_EDEFAULT = false;
    private static final String MIN_EDEFAULT = null;
    private static final String MAX_EDEFAULT = null;

    protected long timestamp = TIMESTAMP_EDEFAULT;
    protected String key = KEY_EDEFAULT;
    protected String type = TYPE_EDEFAULT;
    protected Object value = VALUE_EDEFAULT;
    protected String unit = UNIT_EDEFAULT;
    protected boolean writable = WRITABLE_EDEFAULT;
    protected String min = MIN_EDEFAULT;
    protected String max = MAX_EDEFAULT;

    public DevicePropertyImpl() {
        super();
    }

    public DevicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
    }


    public DevicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }


    public DevicePropertyImpl(long timestamp, String key, String value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public DevicePropertyImpl(long timestamp, String key, int value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public DevicePropertyImpl(long timestamp, String key, double value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public DevicePropertyImpl(long timestamp, String key, float value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public DevicePropertyImpl(long timestamp, String key, boolean value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimestamp(long newValue) {
        timestamp = newValue;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getValue() {
        return value;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(Object newValue) {
        if (newValue != null) {
            value = newValue;
        }
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
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

    @Override
    public boolean getWritable() {
        return writable;
    }

    @Override
    public void setWritable(boolean writable) {
        this.writable = writable;

    }

    @Override
    public String getMin() {
        return min;
    }

    @Override
    public void setMin(String min) {
        this.min = min;
    }

    @Override
    public String getMax() {
        return max;
    }

    @Override
    public void setMax(String max) {
        this.max = max;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
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
     * @generated
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKey(String newKey) {
        key = newKey;
    }


} //SimplePropertyImpl
