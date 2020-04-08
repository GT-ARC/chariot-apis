package de.gtarc.chariot.registrationapi.client.util;

import de.gtarc.chariot.messageapi.AbstractMessage;


// This is a simple class for wrapping results from future executors.
public class ClientResult {

    public AbstractMessage result;

    public ClientResult(AbstractMessage result) {
        this.result = result;
    }
}
