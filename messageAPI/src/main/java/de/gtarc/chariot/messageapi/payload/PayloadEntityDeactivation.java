package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadEntityDeactivation extends AbstractPayload {
    
	public String reId;
    public String uuid;
    public String securitykey;
    public String objectType;

    public PayloadEntityDeactivation(String objectType, String reId, String uuid, String securitykey) {
        this.reId = reId;
        this.uuid = uuid;
        this.securitykey = securitykey;
    }

    public PayloadEntityDeactivation(String objectType, String uuid, String securitykey) {
        this.uuid = uuid;
        this.securitykey = securitykey;
    }
    public PayloadEntityDeactivation(String objectType, String uuid) {
        this.uuid = uuid;
    }
}
