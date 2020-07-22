/**
 *
 */
package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.ComplexDeviceProperty;
import de.gtarc.commonapi.SimpleProperty;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;

import java.util.List;


public class ComplexDevicePropertyImpl extends ComplexPropertyImpl implements ComplexDeviceProperty {

    public ComplexDevicePropertyImpl() {
        super();
    }

    public ComplexDevicePropertyImpl(long timestamp, String key, String type, List<SimpleProperty> values, String unit, boolean writable) {
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = values;
        this.unit = unit;
        this.writable = writable;
    }

    public ComplexDevicePropertyImpl(long timestamp, String key, List<SimpleProperty> values) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = values;
    }

} //ComplexDeviceProperty
