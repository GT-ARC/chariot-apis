package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadDefaultResult extends AbstractPayload {

    public String getResult() {
        return result;
    }

    public String getValue() {
        return value;
    }

    String result;
    String value;

    public PayloadDefaultResult(String result, String value) {
        this.result = result;
        this.value = value;
    }
}
