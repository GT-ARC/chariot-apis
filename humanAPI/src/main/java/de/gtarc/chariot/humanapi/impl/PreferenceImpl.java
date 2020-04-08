package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Preference;
import org.bson.types.ObjectId;

import java.util.UUID;

public class PreferenceImpl implements Preference {

    private ObjectId _id;
    private String preferenceId;
    private String name;
    private String description;

    public PreferenceImpl() {
        this.preferenceId = UUID.randomUUID().toString();
    }

    public PreferenceImpl(String name, String description) {
        this.name = name;
        this.description = description;
        this.preferenceId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }


    public UUID getPreferenceId() {
        return UUID.fromString(preferenceId);
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
}
