package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.HumanRole;
import org.bson.types.ObjectId;

import java.util.UUID;

public class HumanRoleImpl implements HumanRole {
    private String name;
    private String description;
    private String roleId;
    private ObjectId _id;

    public HumanRoleImpl() {
        this.roleId = UUID.randomUUID().toString();
    }

    public HumanRoleImpl(String name, String description) {
        this.name = name;
        this.description = description;
        this.roleId = UUID.randomUUID().toString();
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

    public UUID getRoleId() {
        return UUID.fromString(roleId);
    }


}
