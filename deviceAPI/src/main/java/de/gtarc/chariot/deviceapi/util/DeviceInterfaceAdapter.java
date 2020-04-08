package de.gtarc.chariot.deviceapi.util;

import com.google.gson.*;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DeviceStatusImpl;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeviceInterfaceAdapter implements JsonSerializer<Device>, JsonDeserializer<Device> {


    @Override
    public JsonElement serialize(Device device, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identifier", device.getName());
        jsonObject.addProperty("name", device.getFriendlyName());
        jsonObject.addProperty("type", device.getType());
        jsonObject.addProperty("manufacturer", device.getVendor());
        jsonObject.add("location", jsonSerializationContext.serialize(device.getDeviceLocation()));
        jsonObject.add("properties", jsonSerializationContext.serialize(device.getProperties()));
        jsonObject.addProperty("uuid", device.getUUIdentifier().toString());

        return jsonObject;
    }

    public Device deserialize(JsonElement jsonElement, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String identifier = null;
        String name = null;
        String deviceType = null;
        String manufacturer = null;
        Location location = null;
        List<Property> properties = new ArrayList<>();
        String uuid = null;

        if (jsonObject.get("identifier") != null) {
            identifier = jsonObject.get("identifier").getAsString();
        }
        if (jsonObject.get("name") != null) {
            name = jsonObject.get("name").getAsString();
        }
        if (jsonObject.get("type") != null) {
            deviceType = jsonObject.get("type").getAsString();
        }
        if (jsonObject.get("manufacturer") != null) {
            manufacturer = jsonObject.get("manufacturer").getAsString();
        }
        if (jsonObject.get("location") != null) {
            location = jsonDeserializationContext.deserialize(jsonObject.get("location"), Location.class);
        }

        if (jsonObject.get("properties") != null) {
            jsonObject.get("properties").getAsJsonArray()
                    .forEach(p -> properties.add(jsonDeserializationContext.deserialize(p, Property.class)));
        }
        if (jsonObject.get("uuid") != null) {
            uuid = jsonObject.get("uuid").getAsString();
        }

        if (deviceType.equals("sensor")) {
            return new DeviceBuilder().setName(identifier)
                    .setFriendlyName(name)
                    .setType(deviceType)
                    .setVendor(manufacturer)
                    .setDeviceLocation(location)
                    .setDeviceStatus(new DeviceStatusImpl(null, null))
                    .setUuid(UUID.fromString(uuid)).buildSensingDevice();
        } else {
            return new DeviceBuilder().setName(identifier)
                    .setFriendlyName(name)
                    .setType(deviceType)
                    .setVendor(manufacturer)
                    .setDeviceLocation(location)
                    .setDeviceStatus(new DeviceStatusImpl(null, null))
                    .setUuid(UUID.fromString(uuid)).buildActuating();
        }
    }

}

