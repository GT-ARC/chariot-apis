package de.gtarc.chariot.messageapi.impl;


import com.google.gson.*;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.IMessageInterfaceAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MessageInterfaceAdapterImpl implements IMessageInterfaceAdapter {
    @Override
    public JsonElement serialize(AbstractMessage abstractMessage, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject header = new JsonObject();

        if (abstractMessage.getUrl() != null) header.add("url", new JsonPrimitive(abstractMessage.getUrl()));
        if (abstractMessage.getTopic() != null) header.add("topic", new JsonPrimitive(abstractMessage.getTopic()));
        if (abstractMessage.getResponseTopic() != null)
            header.add("responseTopic", new JsonPrimitive(abstractMessage.getResponseTopic()));
        if (abstractMessage.getFrom() != null) header.add("from", new JsonPrimitive(abstractMessage.getFrom()));
        if (abstractMessage.getTo() != null) header.add("to", new JsonPrimitive(abstractMessage.getTo()));
        if (abstractMessage.getTimeSent() != null)
            header.add("timeSent", new JsonPrimitive(abstractMessage.getTimeSent()));
        if (abstractMessage.getMessageType() != null)
            header.add("messageType", new JsonPrimitive(abstractMessage.getMessageType()));

        JsonObject result = new JsonObject();
        result.add("header", header);

        if (abstractMessage.getPayload() != null && abstractMessage.getPayload().getJsonString(abstractMessage.getPayload().getClass()) != null) {
            JsonObject obj = new JsonObject();

            result.add("payload", new JsonParser().
                    parse(abstractMessage.getPayload().getJsonString(abstractMessage.getPayload().getClass())).getAsJsonObject());

        }
        return result;

    }

    @Override
    public AbstractMessage deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject header = (JsonObject) jsonObject.get("header");
        String url = null;
        String topic = null;
        String responseTopic = null;
        String from = null;
        String to = null;
        String timeSent = null;
        String messageType = null;

        if (((JsonPrimitive) header.get("url")) != null)
            url = ((JsonPrimitive) header.get("url")).getAsString();
        if (((JsonPrimitive) header.get("topic")) != null)
            topic = ((JsonPrimitive) header.get("topic")).getAsString();
        if (((JsonPrimitive) header.get("responseTopic")) != null)
            responseTopic = ((JsonPrimitive) header.get("responseTopic")).getAsString();
        if (((JsonPrimitive) header.get("from")) != null)
            from = ((JsonPrimitive) header.get("from")).getAsString();
        if (((JsonPrimitive) header.get("to")) != null)
            to = ((JsonPrimitive) header.get("to")).getAsString();
        if (((JsonPrimitive) header.get("timeSent")) != null)
            timeSent = ((JsonPrimitive) header.get("timeSent")).getAsString();
        if (((JsonPrimitive) header.get("messageType")) != null)
            messageType = ((JsonPrimitive) header.get("messageType")).getAsString();


        if ((JsonObject) jsonObject.get("payload") != null) {
            String payload = ((JsonObject) jsonObject.get("payload")).toString();
            Class classPayload = getObjectClass(messageType);
            try {
                Method method = classPayload.getMethod("fromJsonString", String.class, classPayload.getClass());
                AbstractPayload payloadObject = (AbstractPayload) method.invoke(null, payload, classPayload);
                return new MessageBuilder().setUrl(url)
                        .setTopic(topic)
                        .setResponseTopic(responseTopic)
                        .setFrom(from)
                        .setTo(to)
                        .setTimeSent(timeSent)
                        .setMessageType(messageType)
                        .addPayload(payloadObject)
                        .build();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return new MessageBuilder().setUrl(url)
                .setTopic(topic)
                .setResponseTopic(responseTopic)
                .setFrom(from)
                .setTo(to)
                .setTimeSent(timeSent)
                .setMessageType(messageType)
                .build();


    }

    public Class getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
    }
}
