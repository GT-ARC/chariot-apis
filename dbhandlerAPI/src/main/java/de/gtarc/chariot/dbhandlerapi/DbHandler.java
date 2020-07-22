package de.gtarc.chariot.dbhandlerapi;

import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.PayloadPropertyAttribute;
import de.gtarc.chariot.messageapi.payload.*;

import java.util.ArrayList;

/***
 * An abstract interface for the database handling operations. 
 * It provides main entity registration and entity update operations.
 * This interface is designed for the databases where they provide a rest API which supports the following methods.
 * @author cemakpolat
 *
 */
public interface DbHandler {

    /**
     * Register the given entity using its object
     *
     * @param payload
     */
    public String registerEntity(PayloadEntityRegistration payload);
    public String addEntity(PayloadEntity payload);
    /**
     * Update the given entity with its id
     *
     * @param entityId
     * @param payload
     */
    public void updateEntity(String entityId, PayloadEntityRegistration payload);

    /**
     * Remove the given entity using its id
     *
     * @param entityId
     */
    public void removeEntity(String entityId, PayloadEntityRemoval payload);

    /**
     * Remove the property of the given entity id
     *
     * @param entityId
     * @param payload
     */
    public void removeEntityProperty(String entityId, PayloadEntityProperty payload);

    /**
     * Check whether the entity is available
     * TODO: This method may not be required
     * @param entityId
     */

    /**
     * Retrive the entity with the given id
     *
     * @param entityId
     * @return
     */

    public String getEntity(String entityId);

    /**
     * Get all entities
     *
     * @return
     */

    public String getAllEntities();

    /**
     * Update entity property with the given entityid and payload.
     *
     * @param entityId
     * @param payload
     */
    public void updateEntityProperty(String entityId, PayloadEntityProperty payload);

    /**
     * Update entity property with the given entityid and payload.
     *
     * @param entityId
     * @param payload
     */
    public void addEntityProperty(String entityId, PayloadEntityPropertyAdd payload);


    /**
     * Get all keys of the entities
     *
     * @param entityId
     * @return
     */

    public ArrayList<String> getEntityPropertyKeys(String entityId);
    /**
     * Check whether the entity is available or not
     *
     * @param entityId
     * @return
     */

    public boolean isEntityAvailable(String entityId);
    /**
     * This method updates an entity attribute
     *
     * @param entityId
     * @param payload
     */
    public void updateEntityAttribute(String entityId, PayloadEntityAttribute payload);

    /**
     * This method updates the attribute of a property
     *
     * @param entityId
     * @param payload
     */
    public void updatePropertyAttribute(String entityId, PayloadPropertyAttribute payload);

    /**
     * THis method updates the location of an entity
     *
     * @param entityId
     * @param payload
     */
    public void updateLocation(String entityId, String otype, PayloadEntityAttribute payload);

}
