package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cemakpolat
 */
//@JsonAdapter(PropertyInterfaceAdapter.class) // TODO: This should be defined here or not, I am not sure!
public class ServicePropertyImpl extends SimplePropertyImpl implements ServiceProperty {

    private static final String OPERATION_EDEFAULT = "Default Operation";

    private static final ArrayList<String> RELATED_TO_EDEFAULT = new ArrayList<>();

    protected String operation = OPERATION_EDEFAULT;

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


    public ServicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable, List<String> relatedTo, Double min, Double max) {
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

    public ServicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable, List<String> relatedTo, Double min, Double max) {
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

    public ServicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable, List<String> relatedTo, Double min, Double max) {
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

    public ServicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable, List<String> relatedTo, Double min, Double max) {
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

    public ServicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable, List<String> relatedTo, Double min, Double max) {
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


    @Override
    public List<String> getRelatedTo() {
        return relatedTo;
    }

    @Override
    public void setRelatedTo(List<String> relatedTo) {
        this.relatedTo = relatedTo;
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

} //SimplePropertyImpl
