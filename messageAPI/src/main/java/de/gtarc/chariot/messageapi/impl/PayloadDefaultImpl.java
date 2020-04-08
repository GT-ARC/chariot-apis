package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.AbstractPayload;

public class PayloadDefaultImpl extends AbstractPayload {

    public String payload;

    public PayloadDefaultImpl(String string) {

        payload = string;
    }

}
