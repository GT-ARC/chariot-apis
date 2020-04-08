package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;


public class PayloadEntityRegistration extends AbstractPayload {

    String objectType;
    String uuid;
    String groupId;
    String id;
    String name;
    String securitykey;
    String ip;

    String reId;
    Location location;
    String manufacturer;

    Property[] properties;
    Operation[] operations;

    public PayloadEntityRegistration(String oType, String uuid, String id, String name, String securitykey, String reId,
                         String ip, String groupId, String manufacturer, Location location, Property[] properties) {
        this.objectType = oType;
        this.uuid = uuid;
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.securitykey = securitykey;
        this.ip = ip;
        this.properties = properties;
        this.location = location;
        this.manufacturer = manufacturer;
        this.reId = reId;
    }


    public PayloadEntityRegistration(String oType, String uuid, String id, String name, String securitykey, String reId,
                         String ip, String groupId, String manufacturer, Location location, Property[] properties, Operation[] operations) {
        this.objectType = oType;
        this.uuid = uuid;
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.securitykey = securitykey;
        this.ip = ip;
        this.reId = reId;
        this.location = location;
        this.manufacturer = manufacturer;

        this.properties = properties == null ? new Property[0] : properties;
        this.operations = operations == null ? new Operation[0] : operations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecuritykey() {
        return securitykey;
    }

    public void setSecuritykey(String securitykey) {
        this.securitykey = securitykey;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId;
    }
}

