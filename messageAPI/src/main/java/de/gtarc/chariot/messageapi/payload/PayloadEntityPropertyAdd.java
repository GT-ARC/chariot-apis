package de.gtarc.chariot.messageapi.payload;

import com.google.gson.JsonParser;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.commonapi.Property;

import java.util.List;

/**
 * {
 * "type": "boolean|integer|float|long|...",
 * "key": "operation-name",
 * "value": "operation-result in the given type",
 * "timestamp": "timestamp",
 * "unit": "? do we need the unit?",
 * "relatedTo": "url-of-requester",
 * "operation": "operation-details:selected-methods, a bundle object etc."
 * },
 *
 * @author cemakpolat
 */
public class PayloadEntityPropertyAdd extends AbstractPayload {

    String entityUUID;
    public String securitykey;
    PayloadEntityProperty payloadProperty;
    public String objectType;

 

	private PayloadEntityPropertyAdd() {
    }

    public PayloadEntityPropertyAdd(String objectType, String entityID, String securitykey, long timestamp, String key, String unit, String type, Object value, List<String> relatedTo, Object operation) {
        this.entityUUID = entityID;
        this.objectType = objectType;
        this.securitykey = securitykey;
        this.payloadProperty = new PayloadEntityProperty(
                timestamp,
                objectType,
                key,
                unit,
                type,
                type.equalsIgnoreCase("Object") ? payloadEntityProperty(value) : value,
                relatedTo, operation);
    }

    public PayloadEntityPropertyAdd payloadEntityProperty(Object value) {
        PayloadEntityPropertyAdd obj = new PayloadEntityPropertyAdd();
        JsonParser jsonParser = new JsonParser();
        throw new UnsupportedOperationException();
    }

    public void setPayloadEntityProperty(PayloadEntityProperty payloadEntityProperty) {
        this.payloadProperty = payloadEntityProperty;
    }

    public PayloadEntityProperty getPayloadEntityProperty() {
        return payloadProperty;
    }

    public String entityUUID() {
        return entityUUID;
    }

    public void setEntityUUID(String entityUUID) {
        this.entityUUID = entityUUID;
    }
    public String getObjectType() {
 		return objectType;
 	}

 	public void setObjectType(String objectType) {
 		this.objectType = objectType;
 	}

 	public String getKey() {
	    return this.payloadProperty.getKey();
    }
}
