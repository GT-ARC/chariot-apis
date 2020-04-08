package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.DeviceStatus;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DeviceBuilder {

    private List<Property> properties = new ArrayList<Property>();
    private List<Operation> operations = new ArrayList<Operation>();

    private String platform;
    private int status;

    private String name;
    private URI namespaceUri;
    private URI identifier;
    private String type;

    private Location location;

    private UUID uuid;
    private String friendlyName;
    private String vendor;
    private DeviceStatus deviceStatus = new DeviceStatusImpl();
    private Connection connection;
    public Location getDeviceLocation() {
        return location;
    }

    public DeviceBuilder setDeviceLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public DeviceBuilder setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public DeviceBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public DeviceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public URI getNamespaceUri() {
        return namespaceUri;
    }

    public DeviceBuilder setNamespaceUri(URI namespaceUri) {
        this.namespaceUri = namespaceUri;
        return this;
    }

    public URI getIdentifier() {
        return identifier;
    }

    public DeviceBuilder setIdentifier(URI identifier) {
        this.identifier = identifier;
        return this;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public DeviceBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public String getVendor() {
        return vendor;
    }

    public DeviceBuilder setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public DeviceBuilder addProperty(Property property) {
        properties.add(property);
        return this;
    }


    public DeviceBuilder addOperation(Operation operation) {
        operations.add(operation);
        return this;
    }

    public String getType() {
        return this.type;
    }

    public DeviceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public DeviceBuilder setConnectionHandler(Connection con){
        this.connection = con;
        return this;
    }
    public Connection getConnectionHandler(){
        return this.connection;
    }

    public DeviceStatus getDeviceStatus() {
        return this.deviceStatus;
    }

    public DeviceBuilder setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public DeviceBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public SensingDeviceImpl buildSensingDevice()  {
        SensingDeviceImpl device = new SensingDeviceImpl();
        device.setDeviceDescription(new DeviceDescriptionImpl());
        device.setName(name);
        device.setNamespaceUri(namespaceUri);

        device.setUUIdentifier(uuid);
        device.setFriendlyName(friendlyName);
        device.setVendor(vendor);
        device.setConnectionHandler((DeviceConnection) connection);

        device.setDeviceLocation(location);

        device.setPlatform(platform);
        device.setDeviceStatus(deviceStatus);

        properties.forEach(device::addProperty);
        operations.forEach(device::addOperation);

        return device;
    }

    public ActuatingDeviceImpl buildActuating() {
        ActuatingDeviceImpl device = new ActuatingDeviceImpl();
        device.setName(name);
        device.setNamespaceUri(namespaceUri);
        device.setUUIdentifier(uuid);
        device.setFriendlyName(friendlyName);
        device.setVendor(vendor);
        device.setConnectionHandler((DeviceConnection) connection);
        device.setDeviceLocation(location);

        device.setPlatform(platform);
        device.setStatus(status);

        properties.forEach(device::addProperty);
        operations.forEach(device::addOperation);

        return device;
    }
}
