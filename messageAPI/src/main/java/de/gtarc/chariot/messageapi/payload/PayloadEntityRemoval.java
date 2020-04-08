package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadEntityRemoval extends AbstractPayload {

	private String objectType; 
	private String reId;
	private String uuid;
	private String securitykey;

    public PayloadEntityRemoval(String objectType, String reId, String uuid, String securitykey) {
        this.reId = reId;
        this.uuid = uuid;
        this.securitykey = securitykey;
    }

    public PayloadEntityRemoval(String objectType, String uuid, String securitykey) {
        this.uuid = uuid;
        this.securitykey = securitykey;
    }
    
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSecuritykey() {
		return securitykey;
	}

	public void setSecuritykey(String securitykey) {
		this.securitykey = securitykey;
	}

}
