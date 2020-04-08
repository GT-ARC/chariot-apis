package de.gtarc.commonapi.utils;

import com.google.gson.*;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

import java.lang.reflect.Type;

public class PropertyInterfaceAdapter implements JsonSerializer<Property>, JsonDeserializer<Property> {


    @Override
    public JsonElement serialize(Property property, Type type, JsonSerializationContext jsonSerializationContext) {

        if (property instanceof ComplexPropertyImpl) {
            JsonArray jsonArray = new JsonArray();

            for (Property subProperty : ((ComplexPropertyImpl) property).getSubProperties()) {
                jsonArray.add(jsonSerializationContext.serialize(subProperty));
            }
            return jsonArray;
        } else {
            return jsonSerializationContext.serialize(property);
        }

    }

    @Override
    public Property deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {


        //checking if it is a complex property
        if (jsonElement.isJsonArray()) {
            ComplexPropertyImpl complexProperty = new ComplexPropertyImpl();
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement element : jsonArray) {
                complexProperty.addSubProperty(jsonDeserializationContext.deserialize(element, Property.class));
            }
            return complexProperty;
        } else {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonDeserializationContext.deserialize(jsonObject, SimplePropertyImpl.class);
        }

    }

}

