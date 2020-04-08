package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Skill;
import org.bson.types.ObjectId;

import java.util.UUID;

public class SkillImpl implements Skill {

    private String name;
    private String description;
    private String skillId;
    private ObjectId _id;

    public SkillImpl() {
        this.skillId = UUID.randomUUID().toString();
    }

    public SkillImpl(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.skillId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public UUID getSkillId() {
        return UUID.fromString(skillId);
    }

    public String getSkillDesc() {
        return description;
    }

    public void setSkillDesc(String desc) {
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
