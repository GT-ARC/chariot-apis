package de.gtarc.commonapi;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import de.gtarc.commonapi.utils.Location;

public interface Entity {


    UUID getUUIdentifier();

    void setUUIdentifier(UUID value);

    URI getNamespaceUri();

    void setNamespaceUri(URI value);

    String getVendor();

    void setVendor(String value);

    String getName();

    void setName(String value);

    String getFriendlyName();

    void setFriendlyName(String friendlyName);

    void addOperation(Operation operation);

    List<Operation> getOperations();

    void addProperty(Property property);

    List<Property> getProperty();

    String getPlatform();

    void setPlatform(String value);

    String getType();

    void setType(String type);
    
    Location getLocation();
    
    void setLocation(Location location);
}
