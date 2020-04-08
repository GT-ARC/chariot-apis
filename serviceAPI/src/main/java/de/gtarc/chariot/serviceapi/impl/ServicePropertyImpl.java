package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.commonapi.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cemakpolat
 */
//@JsonAdapter(PropertyInterfaceAdapter.class) // TODO: This should be defined here or not, I am not sure!
public class ServicePropertyImpl implements ServiceProperty {

    private static final long TIMESTAMP_EDEFAULT = 5;

    private static final String KEY_EDEFAULT = "";

    private static final String OPERATION_EDEFAULT = "Default Operation";

    private static final String TYPE_EDEFAULT = "";

    private static final Object VALUE_EDEFAULT = null;

    private static final String UNIT_EDEFAULT = null;

    private static final boolean WRITABLE_EDEFAULT = false;

    private static final String MIN_EDEFAULT = null;

    private static final String MAX_EDEFAULT = null;

    private static final ArrayList<String> RELATED_TO_EDEFAULT = new ArrayList<>();


    protected long timestamp = TIMESTAMP_EDEFAULT;

    protected String key = KEY_EDEFAULT;

    protected String operation = OPERATION_EDEFAULT;

    protected String type = TYPE_EDEFAULT;

    protected Object value = VALUE_EDEFAULT;

    protected String unit = UNIT_EDEFAULT;

    protected boolean writable = WRITABLE_EDEFAULT;

    protected String min = MIN_EDEFAULT;

    protected String max = MAX_EDEFAULT;

    protected List<String> relatedTo = RELATED_TO_EDEFAULT;

    private ServiceConnection serviceConnection;

    public ServicePropertyImpl() {
        super();
    }

    public ServicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable, List<String> relatedTo) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable, List<String> relatedTo) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable, List<String> relatedTo) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable, List<String> relatedTo) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable, List<String> relatedTo) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
    }


    public ServicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable, List<String> relatedTo, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
        this.min = min;
        this.max = max;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable, List<String> relatedTo, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
        this.min = min;
        this.max = max;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable, List<String> relatedTo, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
        this.min = min;
        this.max = max;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable, List<String> relatedTo, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
        this.min = min;
        this.max = max;
    }

    public ServicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable, List<String> relatedTo, String min, String max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.relatedTo = relatedTo;
        this.min = min;
        this.max = max;
    }


    public ServicePropertyImpl(long timestamp, String key, String value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public ServicePropertyImpl(long timestamp, String key, int value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public ServicePropertyImpl(long timestamp, String key, double value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public ServicePropertyImpl(long timestamp, String key, float value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public ServicePropertyImpl(long timestamp, String key, boolean value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Object getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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
     *
     * @generated
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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

    @Override
    public List<String> getRelatedTo() {
        return relatedTo;
    }

    @Override
    public void setRelatedTo(List<String> relatedTo) {
        this.relatedTo = relatedTo;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public void setConnectionHandler(ServiceConnection connectionHandler) {
        this.serviceConnection = connectionHandler;
    }

    @Override
    public ServiceConnection getConnectionHandler() {
        return this.serviceConnection;
    }

    @Override
    public String getOperation(){
        return operation;
    }

    @Override
    public void setOperation(String operation){
        this.operation = operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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
        result.append("\",\n\"relatedTo\": \"");
        result.append(Arrays.toString(relatedTo.toArray()));
        result.append("\"\n}");
        return result.toString();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setKey(String newKey) {
        key = newKey;
    }


} //SimplePropertyImpl
