package de.gtarc.chariot.messageapi;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface IMessageInterfaceAdapter extends JsonSerializer<AbstractMessage>, JsonDeserializer<AbstractMessage> {
}
