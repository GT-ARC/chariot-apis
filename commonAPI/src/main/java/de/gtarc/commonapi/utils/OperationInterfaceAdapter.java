package de.gtarc.commonapi.utils;

import com.google.gson.*;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.impl.OperationImpl;

import java.lang.reflect.Type;

public class OperationInterfaceAdapter implements JsonSerializer<Operation>, JsonDeserializer<Operation> {

    @Override
    public JsonElement serialize(Operation src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src);
    }

    @Override
    public Operation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.get("min") != null || jsonObject.get("max") != null || jsonObject.get("writable") != null) {
            return context.deserialize(jsonObject, OperationImpl.class);
        } else {
            return context.deserialize(jsonObject, OperationImpl.class);
        }
    }
}
