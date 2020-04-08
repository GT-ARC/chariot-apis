package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.Component;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.commonapi.Property;

import java.util.List;

public class ComponentImpl implements Component {
    String componentId = null;
    List<Device> devices = null;
    List<Property> properties = null;
    List<Component> subComponents = null;

    public String getComponentId() {
        return this.componentId;
    }

    public void setComponentId(String value) {
        this.componentId = value;
    }

    public List<Device> getDevices() {
        return this.devices;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public List<Component> getComponents() {
        // TODO Auto-generated method stub
        return this.subComponents;
    }

    @Override
    public void setDevices(List<Device> list) {
        this.devices = list;
    }

    @Override
    public void setProperties(List<Property> list) {
        this.properties = list;
    }

    @Override
    public void setComponents(List<Component> list) {
        this.subComponents = list;
    }

}
