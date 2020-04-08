package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

public class PayloadEntityUpdate extends AbstractPayload {
	
	private String reId;
	private String name;
	private String ip;
	private String manufacturer;
	private String groupId;
	private String uuid;
	private String securitykey;
	private Location location;
	private Property[] properties;
	private Operation[] operations;
	private String objectType;

    public PayloadEntityUpdate(String objectType, String reId, String name, String uuid, String securitykey, Property[] properties) {
    	this.objectType = objectType;
        this.reId = reId;
		this.name = name;
		this.uuid = uuid;
        this.securitykey = securitykey;
        this.properties = properties;
    }
    
    public PayloadEntityUpdate(String objectType, String reId, String name, String uuid, String securitykey, Property[] properties, Operation[] operations) {
		this.objectType = objectType;
        this.reId = reId;
		this.name = name;
		this.uuid = uuid;
        this.securitykey = securitykey;
        this.properties = properties;
        this.operations = operations;
    }

    public PayloadEntityUpdate(String objectType, String uuid, String name, String securitykey, Property[] properties, Operation[] operations) {
		this.name = name;
		this.objectType = objectType;
        this.uuid = uuid;
        this.securitykey = securitykey;
        this.properties = properties;
        this.operations = operations;
    
    }
    
    public PayloadEntityUpdate(String objectType, String uuid, String name, Property[] properties, Operation[] operations) {
		this.name = name;
		this.objectType = objectType;
        this.uuid = uuid;
        this.properties = properties;
        this.operations = operations;
    }
    public PayloadEntityUpdate(String objectType, String uuid, String name, String securitykey, Property[] properties) {
		this.name = name;
		this.objectType = objectType;
        this.uuid = uuid;
        this.securitykey = securitykey;
        this.properties = properties;
    }
    
    public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSecuritykey() {
		return securitykey;
	}

	public void setSecuritykey(String securitykey) {
		this.securitykey = securitykey;
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

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
