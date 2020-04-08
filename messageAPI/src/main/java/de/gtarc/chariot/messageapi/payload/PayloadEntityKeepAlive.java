package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;

public class PayloadEntityKeepAlive extends AbstractPayload {
    public String reId;
    public String aliveTime;
    public String uuid;
    public String securitykey;
    public long timestamp;
    public Property[] properties;
    public Operation[] operations;
    public String objectType ;

    public PayloadEntityKeepAlive(String objectType, String reId, String aliveTime, String uuid, String securitykey, long timestamp, Property[] properties) {
        this.reId = reId;
        this.aliveTime = aliveTime;
        this.uuid = uuid;
        this.securitykey = securitykey;
        this.timestamp = timestamp;
        this.properties = properties;
    }
    public PayloadEntityKeepAlive(String objectType, String reId, String aliveTime, String uuid, String securitykey, long timestamp, Property[] properties, Operation[] operations) {
        this.reId = reId;
        this.aliveTime = aliveTime;
        this.uuid = uuid;
        this.securitykey = securitykey;
        this.timestamp = timestamp;
        this.properties = properties;
        this.operations = operations;
    }
}
