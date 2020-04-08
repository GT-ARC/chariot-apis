package de.gtarc.chariot.dbhandlerapi.impl;

import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.PayloadProperty;
import de.gtarc.chariot.messageapi.PayloadPropertyAttribute;
import de.gtarc.chariot.messageapi.payload.*;
import de.gtarc.commonapi.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/***
 * This class aims at providing an interface to all CHARIOT entities as it has a database interface. 
 * Each entity such as device, service or human can communicate with this interface in order to test the functionality of the database and how their code manage this interaction.
 * The purpose enables the interaction with entities without having a direct database connection.  
 * @author cemakpolat
 *
 */
public class DummyDbHandlerImpl implements DummyDbHandler {

    // check device id, user id
    public Map<String, AbstractPayload> entities = new HashMap<>();

    //device id, agent uuid, re uuid
    // Instead of using a db in this dummy impl, we are using hashmap to store data in memory.

    @Override
    public boolean isEntityAvailable(String entityId) {
        for (String entityID : entities.keySet()) {
            if (entityID.equalsIgnoreCase(entityID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateEntityAttribute(String entityId, PayloadProperty payload) {

    }

    @Override
    public void updatePropertyAttribute(String entityId, PayloadPropertyAttribute payload) {

    }

    @Override
    public void updateLocation(String entityId, String otype, PayloadProperty payload) {

    }

    @Override
    public String registerEntity(PayloadEntityRegistration payload) {
        this.entities.put((((PayloadEntityRegistration) payload).getUuid()).toString(), payload);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }


    // Updates the device, simply removes from dbRE and re puts with the same reId and agentId
    @Override
    public void updateEntity(String entityId, PayloadEntityRegistration payload) {
        if (this.entities.containsKey(entityId)) {
            this.entities.remove(entityId);
            this.entities.put(entityId, payload);
        }
    }

    @Override
    public void removeEntity(String entityId, PayloadEntityRemoval payload) {
        if (this.entities.containsKey(entityId)) {
            entities.remove(entityId);
            //dbRE.remove(getEntity(entityId));
        }
    }

    @Override
    public void removeEntityProperty(String entityId, PayloadEntityProperty payload) {
        if (this.entities.containsKey(entityId)) {

            AbstractPayload apayload = entities.get(entityId);

            PayloadEntity pentitiy = (PayloadEntity) apayload;
            Property[] properties = pentitiy.getProperties();
            Property[] addprops = new Property[properties.length - 1];
            int i = 0;
            for (Property prop : properties) {
                PayloadEntityProperty pdp = (PayloadEntityProperty) payload;
                DevicePropertyImpl dprop = (DevicePropertyImpl) prop;
                if (!dprop.getKey().equalsIgnoreCase(pdp.getKey())) {
                    addprops[i] = dprop;
                    i += 1;
                }
            }
            pentitiy.setProperties(addprops);
        }
    }

    @Override
    public String getEntity(String id) {

        AbstractPayload entity = entities.get(id);
        if (entity != null) {
            return entity.getJsonString(entity.getClass());
        }

        return null;
    }

    // Returns all the entities
    public String getAllEntities() {
        String allEntities = "";
        for (String entityID : entities.keySet()) {
            allEntities += this.entities.get(entityID).getJsonString(this.entities.get(entityID).getClass());
        }
        return allEntities;
    }

    @Override
    public void updateEntityProperty(String entityId, PayloadEntityProperty payload) {

    }

    @Override
    public void addEntityProperty(String entityId, PayloadEntityPropertyAdd payload) {

    }

    // Updates the properties of an entity
    public void updateEntityProperty(String entityId, AbstractPayload payload) {
        if (this.entities.containsKey(entityId)) {
            AbstractPayload apayload = entities.get(entityId);
            PayloadEntityRegistration pentitiy = (PayloadEntityRegistration) apayload;
            Property[] properties = pentitiy.getProperties();
            for (Property prop : properties) {
                PayloadEntityProperty pdp = (PayloadEntityProperty) payload;
                DevicePropertyImpl dprop = (DevicePropertyImpl) prop;
                if (dprop.getKey().equalsIgnoreCase(pdp.getKey())) {
                    dprop.setValue(pdp.getValue().toString());
                }
            }
            

        }
    }

    @Override
    // Returns the property keys of an entity
    public ArrayList<String> getEntityPropertyKeys(String entityId) {
        ArrayList<String> list = new ArrayList<String>();
        if (this.entities.containsKey(entityId)) {
            AbstractPayload apayload = entities.get(entityId);
            Property[] props = ((PayloadEntity) apayload).getProperties();
            for (Property prop : props) {
                list.add(prop.getKey());
            }
        }
        return list;
    }

}
