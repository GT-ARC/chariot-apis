package de.gtarc.chariot.messageapi;

import com.google.gson.GsonBuilder;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.MessageImpl;
import de.gtarc.chariot.messageapi.impl.MessageInterfaceAdapterImpl;

public abstract class AbstractMessage implements IMessage {


    private String url;
    private String topic;
    private String responseTopic;
    private String from;
    private String to;
    private String timeSent;
    private String timeReceived;
    private String messageType;
    private AbstractPayload payload;

    public AbstractMessage(MessageBuilder builder) {

        this.setUrl(builder.url);
        this.setTopic(builder.topic);
        this.setResponseTopic(builder.responseTopic);
        this.setFrom(builder.from);
        this.setTo(builder.to);
        this.setTimeSent(builder.timeSent);
        this.setTimeReceived(builder.timeReceived);
        this.setMessageType(builder.messageType);
        this.setPayload(builder.payload);
    }

    public String getUrl() {
        return this.url;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getResponseTopic() {
        return this.responseTopic;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getTimeSent() {
        return this.timeSent;
    }

    public String getTimeReceived() {
        return this.timeReceived;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public AbstractPayload getPayload() {
        return this.payload;
    }

    public String getJsonObject() {
        return new GsonBuilder()
                .registerTypeAdapter(MessageImpl.class, new MessageInterfaceAdapterImpl())
                .create()
                .toJson(this);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setResponseTopic(String responseTopic) {
        this.responseTopic = responseTopic;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public void setTimeReceived(String timeReceived) {
        this.timeReceived = timeReceived;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setPayload(AbstractPayload payload) {
        this.payload = payload;
    }

}
