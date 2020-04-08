package de.gtarc.chariot.messageapi.payload;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.gtarc.chariot.messageapi.AbstractPayload;

import java.util.List;

/**
 * @author cemakpolat
 */
public class PayloadEntityProperty extends AbstractPayload {

    String objectType;
    String key;
    Object value;
    long timestamp;
    String type;
    String unit;
    boolean writable;
    String min;
    String max;
    List<String> relatedTo; // url, related to a service accesible via URL address
    Object operation; // operation details


    public PayloadEntityProperty() {
    }

    public PayloadEntityProperty(long timestamp, String objectType, String key, String type, Object value, String unit, boolean writable) {
        this.objectType = objectType;
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;
        if (type.equalsIgnoreCase("array")) {
            this.value = payloadEntityProperty(value);
        } else {
            this.unit = unit;
        }
        this.unit = unit;
        this.writable = writable;

    }

    public PayloadEntityProperty(long timestamp, String objectType, String key, String unit, String type, Object value, List<String> relatedTo, Object operation) {
        this.objectType = objectType;
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;

        if (type.equalsIgnoreCase("array")) {
            this.value = payloadServiceProperty(value);
        } else {
            this.value = value;

        }
        this.unit = unit;
        this.relatedTo = relatedTo;
        this.operation = operation;
    }

    public PayloadEntityProperty(long timestamp, String objectType, String key, String type, Object value, String unit,
                                 boolean writable, String min, String max) {
        this.objectType = objectType;
        this.timestamp = timestamp;
        this.key = key;
        this.type = type;
        this.value = value;

        if (type.equalsIgnoreCase("array")) {
            this.value = payloadEntityProperty(value);
        } else {
            this.unit = unit;
        }

        this.writable = writable;
        this.min = min;
        this.max = max;
    }

    public PayloadEntityProperty(String objectType, String type, String key, String value, boolean writable) {
        this.objectType = objectType;
        this.key = key;
        this.type = type;
        this.value = value;
        this.writable = writable;
    }

    // TODO: The object case is not planned
    public PayloadEntityProperty payloadServiceProperty(Object value) {
        PayloadEntityProperty obj = new PayloadEntityProperty();
        JsonParser jsonParser = new JsonParser();
        throw new UnsupportedOperationException();
    }

    public PayloadEntityProperty payloadLightEntityProperty(Object value) {

        PayloadEntityProperty property = new PayloadEntityProperty();
        JsonParser jsonParser = new JsonParser();

        JsonElement element = jsonParser.parse((String) value);
        JsonObject jsonObject = element.getAsJsonObject();
        property.timestamp = jsonObject.get("timestamp").getAsLong();
        property.key = jsonObject.get("key").getAsString();
        property.value = jsonObject.get("value").getAsString();

        return property;
    }

    public PayloadEntityProperty payloadEntityProperty(Object value) {

        PayloadEntityProperty property = new PayloadEntityProperty();
        JsonParser jsonParser = new JsonParser();

        JsonElement element = jsonParser.parse((String) value);
        JsonObject jsonObject = element.getAsJsonObject();
        property.timestamp = jsonObject.get("timestamp").getAsLong();
        property.key = jsonObject.get("key").getAsString();
        property.type = jsonObject.get("type").getAsString();
        property.value = jsonObject.get("value").getAsString();
        property.unit = jsonObject.get("unit").getAsString();
        property.writable = jsonObject.get("writable").getAsBoolean();

        if (jsonObject.has("min")) {
            property.min = jsonObject.get("min").getAsString();
        }
        if (jsonObject.has("max")) {
            property.max = jsonObject.get("max").getAsString();
        }

        return property;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean getWritable() {
        return writable;
    }

    public Object getOperationDetails() {
        return operation;
    }

    public void setOperationDetails(Object operation) {
        this.operation = operation;
    }

    public List<String> getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(List<String> relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public Object getOperation() {
        return operation;
    }

    public void setOperation(Object operation) {
        this.operation = operation;
    }
}
