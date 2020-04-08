package de.gtarc.chariot.serviceapi.util;

import com.google.gson.*;
import de.gtarc.chariot.serviceapi.Service;
import de.gtarc.chariot.serviceapi.impl.ServiceBuilder;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author cemakpolat
 */
public class ServiceInterfaceAdapter implements JsonSerializer<Service>, JsonDeserializer<Service> {


    @Override
    public JsonElement serialize(Service service, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("identifier", service.getName());
        jsonObject.addProperty("name", service.getFriendlyName());
        jsonObject.addProperty("vendor", service.getVendor());
        jsonObject.addProperty("platform", service.getPlatform());
        //jsonObject.addProperty("description", service.getDescriptions());
        jsonObject.add("properties", jsonSerializationContext.serialize(service.getProperties()));
        jsonObject.add("operations", jsonSerializationContext.serialize(service.getOperations()));
        jsonObject.addProperty("uuid", service.getUUIdentifier().toString());

        return jsonObject;
    }

    public Service deserialize(JsonElement jsonElement, Type type,
                               JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String identifier = null;
        String name = null;
        String vendor = null;
        String platform = null;
        List<Property> properties = new ArrayList<>();
        List<Operation> operations = new ArrayList<>();
        String uuid = null;

        if (jsonObject.get("identifier") != null) {
            identifier = jsonObject.get("identifier").getAsString();
        }

        if (jsonObject.get("name") != null) {
            name = jsonObject.get("name").getAsString();
        }

        if (jsonObject.get("vendor") != null) {
            vendor = jsonObject.get("vendor").getAsString();
        }

        if (jsonObject.get("platform") != null) {
            platform = jsonObject.get("platform").getAsString();
        }

        if (jsonObject.get("properties") != null) {
            jsonObject.get("properties").getAsJsonArray()
                    .forEach(p -> properties.add(jsonDeserializationContext.deserialize(p, Property.class)));
        }

        if (jsonObject.get("operations") != null) {
            jsonObject.get("operations").getAsJsonArray()
                    .forEach(p -> operations.add(jsonDeserializationContext.deserialize(p, Operation.class)));
        }
        if (jsonObject.get("uuid") != null) {
            uuid = jsonObject.get("uuid").getAsString();
        }


        return new ServiceBuilder()
                .setName(identifier)
                .setFriendlyName(name)
                .setVendor(vendor)
                .setPlatform(platform)
                .setProperties(properties)
                .setOperations(operations)
                .setUuid(UUID.fromString(uuid)).buildService();

    }

}

