package de.gtarc.chariot.deviceapi.impl;

public class DevicePropertyBuilder {
    protected long timestamp;
    protected String key;
    protected String type;
    protected Object value;
    protected String unit;
    protected boolean writable;
    protected Double min;
    protected Double max;

    public DevicePropertyImpl buildDeviceProperty() {
        DevicePropertyImpl deviceProperty = new DevicePropertyImpl();

        deviceProperty.setTimestamp(timestamp);
        deviceProperty.setValue(value);
        deviceProperty.setKey(key);
        deviceProperty.setUnit(unit);
        deviceProperty.setType(type);
        deviceProperty.setWritable(writable);
        deviceProperty.setMin(min);
        deviceProperty.setMax(max);

        return deviceProperty;
    }

    public DevicePropertyBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }


    public DevicePropertyBuilder setValue(Object newValue) {
        if (newValue != null) {
            value = newValue;
        }
        return this;
    }

    public DevicePropertyBuilder setUnit(String newUnit) {
        if (newUnit != null) {
            unit = newUnit;
            return this;
        }

        return this;
    }

    public DevicePropertyBuilder setType(String newType) {
        if (newType != null) {
            type = newType;
        }
        return this;
    }

    public DevicePropertyBuilder setWritable(boolean writable) {
        this.writable = writable;

        return this;
    }

    public DevicePropertyBuilder setMin(Double min) {
        this.min = min;
        return this;
    }

    public DevicePropertyBuilder setMax(Double max) {
        this.max = max;
        return this;
    }

    public DevicePropertyBuilder setKey(String newKey) {
        key = newKey;
        return this;
    }
}
