package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Contact;
import org.bson.types.ObjectId;

import java.util.UUID;

public class ContactImpl implements Contact {

    private boolean isHuman;
    private String humanId;
    private String agentIdOfNoneHuman;
    private boolean unseenMessage;
    private String name;
    private ObjectId _id;
    private String contactId;
    //public LinkedList<Message>messages;

    public ContactImpl() {
        this.contactId = UUID.randomUUID().toString();
    }

    public ContactImpl(boolean ishuman, UUID humanID, String name) throws Exception {
        if (!ishuman)
            throw new Exception();
        this.isHuman = ishuman;
        this.humanId = humanID.toString();
        // this.messages = new LinkedList<Message>();
        this.agentIdOfNoneHuman = "";
        this.unseenMessage = false;
        this.name = name;
        this.contactId = UUID.randomUUID().toString();
    }

    public ContactImpl(boolean ishuman, String agentIdOfNoneHuman, String name) throws Exception {
        if (ishuman)
            throw new Exception();
        this.isHuman = ishuman;
        this.agentIdOfNoneHuman = agentIdOfNoneHuman;
        // this.messages = new LinkedList<Message>();
        this.humanId = null;
        this.unseenMessage = false;
        this.name = name;
        this.contactId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public UUID getHumanId() {
        return UUID.fromString(humanId);
    }

    public void setHumanId(UUID humanId) {
        this.humanId = humanId.toString();
    }

    public String getAgentIdOfNoneHuman() {
        return agentIdOfNoneHuman;
    }

    public void setAgentIdOfNoneHuman(String agentIdOfNoneHuman) {
        this.agentIdOfNoneHuman = agentIdOfNoneHuman;
    }

    public boolean isUnseenMessage() {
        return unseenMessage;
    }

    public void setUnseenMessage(boolean unseenMessage) {
        this.unseenMessage = unseenMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getContactId() {
        return UUID.fromString(contactId);
    }
}
