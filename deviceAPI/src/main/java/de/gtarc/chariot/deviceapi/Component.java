package de.gtarc.chariot.deviceapi;

import de.gtarc.commonapi.Property;

import java.util.List;

public interface Component extends IComponent {

    String getComponentId();


    void setComponentId(String value);

    List<Device> getDevices();

    void setDevices(List<Device> list);


    List<Property> getProperties();

    void setProperties(List<Property> list);


    List<Component> getComponents();

    void setComponents(List<Component> list);

}
