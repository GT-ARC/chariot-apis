package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.AbstractMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageBuilderTest {

    @Test
    public void setUrl() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("url", message.getUrl());
    }

    @Test
    public void setTopic() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("topic", message.getTopic());
    }

    @Test
    public void setResponseTopic() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("responsetopic", message.getResponseTopic());
    }

    @Test
    public void setFrom() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("from", message.getFrom());
    }

    @Test
    public void setTo() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("to", message.getTo());
    }

    @Test
    public void setMessageType() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertEquals("type", message.getMessageType());
    }

    @Test
    public void addPayload() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertNull(message.getPayload());
    }

    @Test
    public void build() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        assertNotNull(message.getTimeSent());
    }
}
