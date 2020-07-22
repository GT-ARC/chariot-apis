package de.gtarc.chariot.deviceapi;

import com.google.gson.annotations.JsonAdapter;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.util.DeviceInterfaceAdapter;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@JsonAdapter(DeviceInterfaceAdapter.class)
public interface Device extends Entity {


    DeviceStatus getDeviceStatus();

    Location getDeviceLocation();

    void setDeviceLocation(Location location);

    void setDeviceStatus(DeviceStatus value);


    DeviceDescription getDeviceDescription();

    void setDeviceDescription(DeviceDescription value);


    HardwareDescription getHardwareDescription();


    void setHardwareDescription(HardwareDescription value);


    List<Property> getOptionalProperties();


    List<Property> getProperties();


    UUID getUUIdentifier();


    void setUUIdentifier(UUID value);

    URI getNamespaceUri();


    void setNamespaceUri(URI value);

    String getVendor();


    void setVendor(String value);


    DeviceConnection getConnectionHandler();


    void setConnectionHandler(DeviceConnection value);

    String getName();

    void setName(String value);


    String getFriendlyName();


    void setFriendlyName(String friendlyName);

    /**
     * add new mandatory property
     *
     * @param property
     */
    void addProperty(Property property);


    /**
     * Add a new Operation
     *
     * @param operation
     */
    void addOperation(Operation operation);

    List<Operation> getOperations();

    String getPlatform();


    void setPlatform(String value);

    String getType();

    void setType(String type);
}
