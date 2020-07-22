package de.gtarc.chariot.messageapi;

public class PayloadEntityAttribute extends AbstractPayload {

    protected String objectType;
    protected String key;
    protected Object value;

    public PayloadEntityAttribute(){}

    public PayloadEntityAttribute(String oType,String key, Object value) {
        this.objectType = oType;
        this.key = key;
        this.value = value;
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

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
