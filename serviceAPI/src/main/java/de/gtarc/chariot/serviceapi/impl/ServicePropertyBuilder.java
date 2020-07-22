package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.connectionapi.ServiceConnection;

import java.util.List;

public class ServicePropertyBuilder {

    protected long timestamp;
    protected String key;
    protected String operation;
    protected String type;
    protected Object value;
    protected String unit;
    protected boolean writable;
    protected Double min;
    protected Double max;
    protected List<String> relatedTo;
    private ServiceConnection serviceConnection;

    public ServicePropertyImpl buildServiceProperty() {
        ServicePropertyImpl serviceProperty = new ServicePropertyImpl();

        serviceProperty.setTimestamp(timestamp);
        serviceProperty.setValue(value);
        serviceProperty.setKey(key);
        serviceProperty.setOperation(operation);
        serviceProperty.setUnit(unit);
        serviceProperty.setType(type);
        serviceProperty.setWritable(writable);
        serviceProperty.setMin(min);
        serviceProperty.setMax(max);

        serviceProperty.setRelatedTo(relatedTo);
        serviceProperty.setConnectionHandler(serviceConnection);

        return serviceProperty;
    }

    public ServicePropertyBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }


    public ServicePropertyBuilder setValue(Object newValue) {
        if (newValue != null) {
            value = newValue;
        }
        return this;
    }

    public ServicePropertyBuilder setUnit(String newUnit) {
        if (newUnit != null) {
            unit = newUnit;
            return this;
        }
        return this;
    }

    public ServicePropertyBuilder setType(String newType) {
        if (newType != null) {
            type = newType;
        }
        return this;
    }

    public ServicePropertyBuilder setOperation(String newOperation) {
        if (newOperation != null) {
            operation = newOperation;
        }
        return this;
    }

    public ServicePropertyBuilder setWritable(boolean writable) {
        this.writable = writable;

        return this;
    }

    public ServicePropertyBuilder setMin(Double min) {
        this.min = min;
        return this;
    }

    public ServicePropertyBuilder setMax(Double max) {
        this.max = max;
        return this;
    }

    public ServicePropertyBuilder setRelatedTo(List<String> relatedTo) {
        this.relatedTo = relatedTo;
        return this;
    }

    public ServicePropertyBuilder setConnectionHandler(ServiceConnection connectionHandler) {
        this.serviceConnection = connectionHandler;
        return this;
    }

    public ServicePropertyBuilder setKey(String newKey) {
        key = newKey;
        return this;
    }
}
