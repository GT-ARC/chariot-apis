package de.gtarc.commonapi.utils;

import com.google.gson.*;
import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

import java.lang.reflect.Type;

public class PropertyInterfaceAdapter implements JsonSerializer<Property>, JsonDeserializer<Property> {


    @Override
    public JsonElement serialize(Property property, Type type, JsonSerializationContext jsonSerializationContext) {
        if (property instanceof ComplexPropertyImpl) {
            JsonElement complexproperty = jsonSerializationContext.serialize(property);
            JsonArray jsonArray = new JsonArray();
            for (Property subProperty : ((ComplexPropertyImpl) property).getSubProperties()) {
                jsonArray.add(jsonSerializationContext.serialize(subProperty));
            }
            complexproperty.getAsJsonObject().add("value", jsonArray);
            return complexproperty;
        } else {
            return jsonSerializationContext.serialize(property);
        }
    }

    @Override
    public Property deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        //checking if it is a complex property
        if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has("value") &&
                jsonElement.getAsJsonObject().get("value").isJsonArray()) {

            JsonObject complexJsonObject = jsonElement.getAsJsonObject();

            // If you dont like the explicit approach
            ComplexPropertyImpl complexProperty = new ComplexPropertyImpl();
            if (complexJsonObject.has("timestamp"))
                complexProperty.setTimestamp(complexJsonObject.get("timestamp").getAsLong());
            if (complexJsonObject.has("key"))
                complexProperty.setKey(complexJsonObject.get("key").getAsString());
            if (complexJsonObject.has("type"))
                complexProperty.setType(complexJsonObject.get("type").getAsString());
            if (complexJsonObject.has("unit"))
                complexProperty.setUnit(complexJsonObject.get("unit").getAsString());
            if (complexJsonObject.has("writable"))
                complexProperty.setWritable(complexJsonObject.get("writable").getAsBoolean());

            JsonArray jsonArray = jsonElement.getAsJsonObject().get("value").getAsJsonArray();
            for (JsonElement element : jsonArray) {
                complexProperty.addSubProperty(jsonDeserializationContext.deserialize(element, SimplePropertyImpl.class));
            }
            return complexProperty;
        } else {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonDeserializationContext.deserialize(jsonObject, SimplePropertyImpl.class);
        }

    }

}

