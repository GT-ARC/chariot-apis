/**
 *
 */
package de.gtarc.chariot.deviceapi.impl;


import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

public class DevicePropertyImpl extends SimplePropertyImpl implements DeviceProperty {

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


    public DevicePropertyImpl(long timestamp, String key, String type, String value, String unit, boolean writable, Double min, Double max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, int value, String unit, boolean writable, Double min, Double max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, double value, String unit, boolean writable, Double min, Double max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, float value, String unit, boolean writable, Double min, Double max) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public DevicePropertyImpl(long timestamp, String key, String type, boolean value, String unit, boolean writable, Double min, Double max) {
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
