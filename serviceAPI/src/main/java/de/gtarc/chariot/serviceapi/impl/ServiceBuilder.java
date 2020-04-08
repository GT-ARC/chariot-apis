package de.gtarc.chariot.serviceapi.impl;


import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.serviceapi.ServiceDescription;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author cemakpolat
 */
public class ServiceBuilder {

    private List<Property> properties = new ArrayList<Property>();
    private List<Operation> operations = new ArrayList<Operation>();

    private String name;
    private String friendlyName;
    private UUID uuid;
    private String platform;
    private String vendor;
    private ServiceDescription description;
    public String getPlatform() {
        return platform;
    }
    public Connection connection;
    public ServiceBuilder setPlatform(String platform) {
        this.platform = platform;
        return this;
    }


    public String getName() {
        return name;
    }

    public ServiceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public ServiceBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public String getVendor() {
        return vendor;
    }

    public ServiceDescription getDescriptions() {
        return this.description;
    }

    public ServiceBuilder setFriendlyName(ServiceDescription value) {
        this.description = value;
        return this;
    }

    public ServiceBuilder setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public ServiceBuilder addProperty(Property property) {
        properties.add(property);
        return this;
    }

    public ServiceBuilder addOperation(Operation operation) {
        operations.add(operation);
        return this;
    }

    public ServiceBuilder setProperties(List<Property> value) {
        this.properties = value;
        return this;
    }

    public ServiceBuilder setOperations(List<Operation> value) {
        this.operations = value;
        return this;
    }


    public UUID getUuid() {
        return uuid;
    }

    public ServiceBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public ServiceBuilder setConnection(Connection conn) {
        this.connection = conn;
        return this;
    }

    public ServiceImpl buildService() {
        ServiceImpl service = new ServiceImpl();

        service.setName(name);
        service.setUUIdentifier(uuid);
        service.setFriendlyName(friendlyName);
        service.setVendor(vendor);
        service.setPlatform(platform);
        service.setDescription(description);
        service.setConnectionHandler((ServiceConnection) connection);
        properties.forEach(service::addProperty);
        operations.forEach(service::addOperation);

        return service;
    }
}
