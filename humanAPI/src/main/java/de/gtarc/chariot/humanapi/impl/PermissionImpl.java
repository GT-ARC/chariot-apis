package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Permission;
import org.bson.types.ObjectId;

import java.util.UUID;

public class PermissionImpl implements Permission {
    private ObjectId _id;
    private String name;
    private String description;
    private String permissionId;

    public PermissionImpl() {
        this.permissionId = UUID.randomUUID().toString();
    }

    public PermissionImpl(String name, String description) {
        this.name = name;
        this.description = description;
        this.permissionId = UUID.randomUUID().toString();
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
        return UUID.fromString(permissionId);
    }

}
