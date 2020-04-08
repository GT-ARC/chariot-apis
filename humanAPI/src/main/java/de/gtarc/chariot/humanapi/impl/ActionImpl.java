package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Action;
import org.bson.types.ObjectId;

import java.util.UUID;


public class ActionImpl implements Action {

    private String name;
    private String description;
    private UUID actionId;
    private ObjectId _id;

    public ActionImpl() {
        this.actionId = UUID.randomUUID();
    }

    public ActionImpl(String name, String description) {
        this.name = name;
        this.description = description;
        this.actionId = UUID.randomUUID();
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

    public UUID getActionId() {
        return actionId;
    }


}
