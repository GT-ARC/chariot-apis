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

public class ActuatingDeviceImpl implements ActuatingDevice {

    protected String name;
    protected String friendlyName;
    protected String type = "actuator";

    protected DeviceStatus deviceStatus;
    /**
     * The cached value of the '{@link #getDeviceDescription() <em>Device Description</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getDeviceDescription()
     */
    protected DeviceDescription deviceDescription;

    /**
     * The cached value of the '{@link #getHardwareDescription() <em>Hardware Description</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getHardwareDescription()
     */
    protected HardwareDescription hardwareDescription;

    /**
     * The cached value of the '{@link #getOptionalProperties() <em>Optional Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getOptionalProperties()
     */

    protected List<Property> properties = new ArrayList<Property>();
    protected List<Property> optionalProperties = new ArrayList<Property>();
    protected List<Operation> operations = new ArrayList<Operation>();


    /**
     * The default value of the ' ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     */
    protected static final UUID UID_EDEFAULT = null;

    /**
     * The cached value of the ' ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     */
    protected UUID uid = UID_EDEFAULT;

    /**
     * The default value of the '{@link #getNamespaceUri() <em>Namespace Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getNamespaceUri()
     */
    protected static final URI NAMESPACE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNamespaceUri() <em>Namespace Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getNamespaceUri()
     */
    protected URI namespaceUri = NAMESPACE_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getVendor()
     */
    protected static final String VENDOR_EDEFAULT = null;

    /**
     * The default value of the '{@link #getDeviceLocation() <em>Location</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getDeviceLocation() ()
     */
    protected static final Location LOCATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getVendor()
     */
    protected String vendor = VENDOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getDeviceLocation()} () <em>Locatiom</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getDeviceLocation()
     */
    protected Location location = LOCATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getConnectionHandler() <em>Handler</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getConnectionHandler()
     */
    protected DeviceConnection handler;

    /**
     * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getStatus()
     */
    protected static final int STATUS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getStatus()
     */
    protected int status = STATUS_EDEFAULT;

    /**
     * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getPlatform()
     */
    protected static final String PLATFORM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @ordered
     * @see #getPlatform()
     */
    protected String platform = PLATFORM_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public ActuatingDeviceImpl() {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public DeviceDescription getDeviceDescription() {
        return deviceDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setDeviceDescription(DeviceDescription newDeviceDescription) {
        deviceDescription = newDeviceDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public HardwareDescription getHardwareDescription() {
        return hardwareDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setHardwareDescription(HardwareDescription newHardwareDescription) {
        hardwareDescription = newHardwareDescription;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public UUID getUUIdentifier() {
        return uid;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setUUIdentifier(UUID newUid) {
        uid = newUid;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public URI getNamespaceUri() {
        return namespaceUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setNamespaceUri(URI newNamespaceUri) {
        namespaceUri = newNamespaceUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setVendor(String newVendor) {
        vendor = newVendor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public Location getDeviceLocation() {
        return location;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * LOCATION_EDEFAULT
     */
    public void setDeviceLocation(Location newlocation) {
        location = newlocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public DeviceConnection getConnectionHandler() {
        return handler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setConnectionHandler(DeviceConnection newHandler) {
        handler = newHandler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public int getStatus() {
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setStatus(int newStatus) {
        status = newStatus;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setPlatform(String newPlatform) {
        platform = newPlatform;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void setFriendlyName(String value) {
        friendlyName = value;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (uid: ");
        result.append(uid);
        result.append(", NamespaceUri: ");
        result.append(namespaceUri);
        result.append(", Vendor: ");
        result.append(vendor);
        result.append(", status: ");
        result.append(status);
        result.append(", platform: ");
        result.append(platform);
        result.append(')');
        return result.toString();
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus value) {
        deviceStatus = value;

    }

    public void addProperty(Property property) {
        if (!properties.contains(property)) {
            properties.add(property);
        }
    }

    public void addOptionalProperty(Property property) {
        if (!optionalProperties.contains(property)) {
            optionalProperties.add(property);
        }
    }

    @Override
    public void addOperation(Operation operation) {
        if (!operations.contains(operation)) {
            operations.add(operation);
        }
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }


    @Override
    public List<Property> getProperty() {
        return this.properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Property> getOptionalProperties() {
        return optionalProperties;
    }


    @Override
    public void setName(String value) {
        this.name = value;
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
		// TODO Auto-generated method stub
		return location;
	}


	@Override
	public void setLocation(Location location) {
		this.location = location;
		
	}

} // ActuatingDevice

