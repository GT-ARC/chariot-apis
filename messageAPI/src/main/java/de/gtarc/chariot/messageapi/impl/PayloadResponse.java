package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadResponse extends AbstractPayload {
    public String response;
    public String reId;

    public PayloadResponse(String response, String reId) {
        this.response = response;
        this.reId = reId;
    }

    public PayloadResponse(String response) {
        this.response = response;
    }
}
