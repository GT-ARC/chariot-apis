package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadEntityResponse extends AbstractPayload {
    public String response;
    public String reId;

    public PayloadEntityResponse(String response, String reId) {
        this.response = response;
        this.reId = reId;
    }

    public PayloadEntityResponse(String response) {
        this.response = response;
    }
}
