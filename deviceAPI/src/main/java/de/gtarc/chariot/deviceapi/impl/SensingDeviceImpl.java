/**
 *
 */
package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.*;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class SensingDeviceImpl implements SensingDevice {

    protected String name;
    protected String friendlyName;
    protected DeviceStatus deviceStatus;
    protected String type = "sensor";



    protected DeviceDescription deviceDescription;


    protected HardwareDescription hardwareDescription;

    @Override
    public void addProperty(Property property) {
        if(!this.properties.contains(property))
            this.properties.add(property);
    }

    @Override
    public List<Property> getProperty() {
        return this.properties;
    }

    protected List<Property> optionalProperties = new ArrayList<Property>();


    protected List<Property> properties = new ArrayList<Property>();

    protected static final UUID UID_EDEFAULT = null;

    protected UUID uid = UID_EDEFAULT;

    protected static final URI NAMESPACE_URI_EDEFAULT = null;


    protected URI namespaceUri = NAMESPACE_URI_EDEFAULT;


    protected static final Location LOCATION_EDEFAULT = null;

    protected static final String VENDOR_EDEFAULT = null;

    protected Location location = LOCATION_EDEFAULT;

    protected String vendor = VENDOR_EDEFAULT;

    protected static final String PLATFORM_EDEFAULT = null;

    protected String platform = PLATFORM_EDEFAULT;

    protected DeviceConnection handler;
    protected List<Operation> operations = new ArrayList<>();

    public SensingDeviceImpl() {
        super();
    }

    public DeviceDescription getDeviceDescription() {
        return deviceDescription;
    }


    public void setDeviceDescription(DeviceDescription newDeviceDescription) {
        deviceDescription = newDeviceDescription;
    }

    public HardwareDescription getHardwareDescription() {
        return hardwareDescription;
    }

    public void setHardwareDescription(HardwareDescription newHardwareDescription) {
        hardwareDescription = newHardwareDescription;
    }


    public void addOptionalProperty(Property property) {
        if (!optionalProperties.contains(property)) {
            optionalProperties.add(property);
        }
    }

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Property> getOptionalProperties() {
        return optionalProperties;
    }

    public UUID getUUIdentifier() {
        return uid;
    }

    public void setUUIdentifier(UUID newUid) {
        uid = newUid;
    }

    public URI getNamespaceUri() {
        return namespaceUri;
    }

    public void setNamespaceUri(URI newNamespaceUri) {
        namespaceUri = newNamespaceUri;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Location getDeviceLocation() {
        return location;
    }

    public void setDeviceLocation(Location newlocation) {
        location = newlocation;
    }


    public DeviceConnection getConnectionHandler() {
        return handler;
    }


    public void setConnectionHandler(DeviceConnection newHandler) {
        handler = newHandler;
    }

    public String getName() {
        return name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (uid: ");
        result.append(uid);
        result.append(", NamespaceUri: ");
        result.append(namespaceUri);
        result.append(", Vendor: ");
        result.append(vendor);
        result.append(')');
        return result.toString();
    }


    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }


    public void setDeviceStatus(DeviceStatus value) {
        deviceStatus = value;
    }


    @Override
    public void setName(String value) {
        this.name = value;

    }


    @Override
    public String getPlatform() {
        // TODO Auto-generated method stub
        return platform;
    }


    @Override
    public void setPlatform(String value) {
        this.platform = value;

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {

        return this.getUUIdentifier().equals(((Device) o).getUUIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUUIdentifier());
    }

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
		
	}
} //SensingDeviceImpl
