package de.gtarc.chariot.registrationapi.client.util;

import de.gtarc.chariot.messageapi.AbstractMessage;

import java.util.concurrent.Future;

// This class is used for registration results, it extends the ClientResult class and has got
// an additional future AbstractMessage field named reid, this is used for this scenario:
// If an agent registers earlier than its RE, the agent needs to be informed when the RE registers.
// This future object reid makes this possible. You can access the reid message if the reid needed.
public class RegistrationResult extends ClientResult {

    public Future<AbstractMessage> reid;

    public RegistrationResult(AbstractMessage result, Future<AbstractMessage> reid) {
        super(result);
        this.reid = reid;
    }
}
