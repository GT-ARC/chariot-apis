package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntityBuilder {
    private List<Property> properties = new ArrayList<Property>();
    private List<Operation> operations = new ArrayList<Operation>();

    private String name;
    private UUID uuid;
    private String vendor;

    private String reId ;
    private String ip;
    private String securityKey;
    private String objectType;
    private String groupId;
    private Location location;

    public EntityBuilder setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public EntityBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }
    public EntityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EntityBuilder setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public EntityBuilder addProperty(Property property) {
        properties.add(property);
        return this;
    }

    public EntityBuilder addOperation(Operation operation) {
        operations.add(operation);
        return this;
    }

    public EntityBuilder setProperties(List<Property> value) {
        this.properties = value;
        return this;
    }

    public EntityBuilder setOperations(List<Operation> value) {
        this.operations = value;
        return this;
    }

    public EntityBuilder setReId(String reId) {
        this.reId = reId;
        return this;
    }

    public EntityBuilder setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
        return this;
    }


    public EntityBuilder setObjectType(String objectType) {
        this.objectType = objectType;
        return this;
    }

    public EntityBuilder setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public EntityBuilder setUUIdentifier(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public PayloadEntity buildEntity() {
        PayloadEntity entity = new PayloadEntity();

        entity.setName(name);
        entity.setGroupId(groupId);
        entity.setUuid(uuid.toString());
        entity.setIp(ip);
        entity.setReId(reId);
        entity.setSecuritykey(securityKey);
        entity.setLocation(location);
        entity.setManufacturer(vendor);
        entity.setObjectType(objectType);
        entity.setProperties(properties.stream().toArray(Property[]::new));

        if(operations.size() > 0 )
            entity.setOperations(operations.stream().toArray(Operation[]::new));
        return entity;
    }
}
