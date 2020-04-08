package de.gtarc.chariot.humanapi.impl;

import org.bson.types.ObjectId;

import java.util.UUID;

public class MessageImpl {

    private ObjectId _id;
    private String name;
    private String description;
    private String messageId;

    public MessageImpl() {
        this.messageId = UUID.randomUUID().toString();
    }

    public MessageImpl(String name, String description) {
        this.name = name;
        this.description = description;
        this.messageId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getPermissionId() {
        return UUID.fromString(messageId);
    }
}
