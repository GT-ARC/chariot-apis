package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.serviceapi.ServiceDescription;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * A default service class
 *
 * @author cemakpolat
 */
public class ServiceImpl extends AbstractService {

    protected ServiceConnection handler;
    protected ServiceDescription serviceDescription;
    protected List<Property> properties = new ArrayList<Property>();
    protected List<Operation> operations = new ArrayList<Operation>();
    String name = null;
    String friendlyName = null;
    UUID uuid = null;
    ServiceDescription description = null;
    boolean isRunning = true;
    String vendor = null;
    String platform = null;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String value) {
        this.name = value;

    }

    @Override
    public String getFriendlyName() {
        return this.friendlyName;
    }

    @Override
    public void setFriendlyName(String value) {
        this.friendlyName = value;

    }

    @Override
    public UUID getUUIdentifier() {
        return this.uuid;
    }

    @Override
    public void setUUIdentifier(UUID value) {
        this.uuid = value;

    }

    @Override
    public URI getNamespaceUri() {
        return null;
    }

    @Override
    public void setNamespaceUri(URI value) {

    }

    @Override
    public ServiceDescription getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(ServiceDescription value) {
        this.description = value;

    }

    @Override
    public void start() {
        System.out.println("service is started...");
    }

    @Override
    public void run() {
        System.out.println("service is running...");

    }

    @Override
    public void stop() {
        System.out.println("service is stopped...");

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public String getVendor() {
        return this.vendor;
    }

    @Override
    public void setVendor(String value) {
        vendor = value;

    }

    @Override
    public String getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(String value) {
        platform = value;

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public void addOperation(Operation property) {
        if (!operations.contains(property)) {
            operations.add(property);
        }

    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public void addProperty(Property property) {
        if (!properties.contains(property)) {
            properties.add(property);
        }
    }

    @Override
    public List<Property> getProperty() {
        return this.properties;
    }


    public ServiceConnection getConnectionHandler() {
        return handler;
    }


    public void setConnectionHandler(ServiceConnection newHandler) {
        handler = newHandler;
    }

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		
	}

} // ServiceImpl
