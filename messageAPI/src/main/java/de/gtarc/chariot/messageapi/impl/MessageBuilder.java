package de.gtarc.chariot.messageapi.impl;

import com.google.gson.GsonBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageBuilder {
    public String url;
    public String topic;
    public String responseTopic;
    public String from;
    public String to;
    public String timeSent;
    public String timeReceived;
    public String messageType;
    public AbstractPayload payload;

    public MessageBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public MessageBuilder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MessageBuilder setResponseTopic(String responseTopic) {
        this.responseTopic = responseTopic;
        return this;
    }

    public MessageBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public MessageBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public MessageBuilder setTimeSent(String ts) {
        this.timeSent = timeSent;
        return this;
    }


    public MessageBuilder setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public MessageBuilder addPayload(AbstractPayload payload) {
        this.payload = payload;
        return this;
    }


    public AbstractMessage build() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = LocalDateTime.now().format(formatter);
        if (this.timeSent == null) {

            this.timeSent = time;
        } else {
            this.timeReceived = time;
        }

        return new MessageImpl(this);
    }

    public static AbstractMessage fromJsonString(String string) {
        return new GsonBuilder()
                .registerTypeAdapter(MessageImpl.class, new MessageInterfaceAdapterImpl())
                .create()
                .fromJson(string, MessageImpl.class);
    }
}
