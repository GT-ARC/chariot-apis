package de.gtarc.chariot.dbhandlerapi.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.gtarc.chariot.connectionapi.impl.WebClientConnection;
import de.gtarc.chariot.dbhandlerapi.EntityURIPath;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.humanapi.ObjectTypes;
import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.PayloadPropertyAttribute;
import de.gtarc.chariot.messageapi.payload.*;
import de.gtarc.commonapi.utils.IoTEntity;
import org.apache.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/***
 * This class provides an interface between Chariot entities (device, service, human) and the KMS database
 * @author aksoy
 *
 */

public class KmsHandlerImpl implements KmsHandler {

    private static final Logger log = Logger.getLogger(KmsHandlerImpl.class);

    URI uri;
    String host;
    String entityPath;

    public KmsHandlerImpl() {
    }

    /**
     * The url and entity type can be set when instantiating the class.
     * The entity type depends on the type of agent.
     * For device  "/devices/", for services "/services/", for human  "/humans/"
     * Example: KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
     *
     * @param url path
     * @param entity type
     */
    public KmsHandlerImpl(String url, String entity) throws URISyntaxException {
        this.uri = new URI(url);
        this.host = uri.toString().substring(0, uri.toString().length() + 3 - uri.getPath().length());
        this.entityPath = entity;
    }

    /**
     * Uri and entity type can also be set after instantiation of the class
     *
     * @param url
     * @param entity
     */
    @Override
    public void setURI(String url, String entity) throws URISyntaxException {
        this.uri = new URI(url);
        this.host = uri.toString().substring(0, uri.toString().length() + 3 - uri.getPath().length());
        this.entityPath = entity;
    }

    @Override
    public void setURL(String url) throws URISyntaxException {
        this.uri = new URI(url);
        this.host = uri.toString().substring(0, uri.toString().length() + 3 - uri.getPath().length());
    }

    /**
     * THis method returns the Uri that is set
     *
     * @return uri
     */
    @Override
    public URI getURI() {
        return this.uri;
    }


    @Override
    public void setEntityPath(String path) {
        this.entityPath = path ;
    }


    /**
     * This method creates the connection to the database.
     *
     * @return http connection
     */
    public WebClientConnection createDBConnection() {
        WebClientConnection client = new WebClientConnection();
        client.setConnectionURI(host);
        return client;
    }
    /**
     * This method registers device, service and human to the KMS.
     *
     * @param payload
     * @return response
     */
    @Override
    public String registerEntity(PayloadEntityRegistration payload) {
        String jsonpayload = payload.getJsonString(payload.getClass());
        log.info(jsonpayload);
        WebClientConnection client = createDBConnection();

        String result = "FAILURE";
        try {
            client.connect();
            result = client.sendJsonByPost(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()), jsonpayload);

            log.info("registration result: " + result);
            // check here the model includes the id
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
        return result;
    }

    /**
     * Add an Entity in the database
     * @param payload
     * @return result
     */
    @Override
    public String addEntity(PayloadEntity payload) {
        String jsonpayload = payload.getJsonString(payload.getClass());
        log.info(jsonpayload);
        WebClientConnection client = createDBConnection();

        String result = "FAILURE";
        try {
            client.connect();
            result = client.sendJsonByPost(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()), jsonpayload);

            log.info("registration result: " + result);
            // check here the model includes the id
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
        return result;
    }
    /**
     * This method updates device, service and human.
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void updateEntity(String entityId, PayloadEntityRegistration payload) {
        String jsonpayload = payload.getJsonString(payload.getClass());
        System.out.println("jsonpayload: \n"+ jsonpayload);
        System.out.println("entityId: \n"+ entityId);
        System.out.println("uri: \n"+ getEntityURIPath(payload.getObjectType()) + entityId + "/");
        WebClientConnection client = createDBConnection();
        try {
            client.connect();
            client.sendByPut(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/", jsonpayload);
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }

    }


    /**
     * This method removes device, service and human.
     *
     * @param entityId
     */
    @Override
    public void removeEntity(String entityId, PayloadEntityRemoval payload) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            client.sendByDelete(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/");
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }

    }
    /**
     * This method removes the given entity id in the database
     *
     * @param entityId
     */
    public void removeEntity(String entityId, String oType) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            client.sendByDelete(client.getConnectionURI() + getEntityURIPath(oType) + entityId + "/");
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    /**
     * This method gets the property keys of device, service and human.
     *
     * @param entityId
     * @return
     */
    @Override
    public ArrayList<String> getEntityPropertyKeys(String entityId) {
        ArrayList<String> propertyKeys = new ArrayList<String>();
        String entity;

        try {
            entity = getEntity(entityId);
            JsonParser parser = new JsonParser();
            JsonElement entityElement = parser.parse(entity);
            JsonObject entityobject = entityElement.getAsJsonObject();
            log.info(entityobject);

            JsonArray props = entityobject.get("properties").getAsJsonArray();

            for (int i = 0; i < props.size(); i++) {
                JsonElement el = props.get(i);
                JsonObject obj = el.getAsJsonObject();
                String thekey = obj.get("key").getAsString();
                propertyKeys.add(thekey);
            }
        } catch (Exception e) {
            throw e;
        }
        return propertyKeys;
    }

    /**
     * This method updates the properties of device, service and human.
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void updateEntityProperty(String entityId, PayloadEntityProperty payload) {
        String objectType = payload.getObjectType();
        payload.setObjectType(null);
        String jsonpayload = payload.getJsonString(payload.getClass());
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            log.info("Send to kms: " + jsonpayload);
            client.sendByPut(client.getConnectionURI() + getEntityURIPath(objectType) + entityId + "/properties/" + payload.getKey() + "/", jsonpayload);
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    @Override
    public void addEntityProperty(String entityId, PayloadEntityPropertyAdd payload) {
        String jsonpayload = payload.getPayloadEntityProperty().getJsonString(payload.getPayloadEntityProperty().getClass());
        WebClientConnection client = createDBConnection();

        log.info(jsonpayload);

        try {
            client.connect();
            client.sendByPut(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/properties/", jsonpayload);
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    /**
     * This method removes the properties of device, service and human.
     * CAVEAT: This functionality is not implemented in the database!
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void removeEntityProperty(String entityId, PayloadEntityProperty payload) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            if (payload != null) {
                client.sendByDelete(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/properties/" + payload.getKey() + "/");
            }
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    /**
     * This method gets all entities in the given entityPath.
     *
     * @return all entities in json string
     */
    @Override
    public String getAllEntities() {

        WebClientConnection client = createDBConnection();
        String allentities;

        try {
            client.connect();
            allentities = client.sendByGet(client.getConnectionURI() + getEntityURIPath(entityPath));
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
        return allentities;
    }

    /**
     * This method returns asked entity.
     *
     * @param entityId
     * @return entity in json stirng
     */
    @Override
    public String getEntity(String entityId) {

        WebClientConnection client = createDBConnection();
        String entity;
        try {
            client.connect();
            //log.info("\n\n" +this.entityPath);
            //log.info("\n\n"+client.getConnectionURI() + getEntityURIPath(this.entityPath) + entityId + "/");
            entity = client.sendByGet(client.getConnectionURI() + getEntityURIPath(this.entityPath) + entityId + "/");
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }

        return entity;
    }

    /**
     * This method returns the kafka topic of the entity
     *
     * @param entityId
     * @return kafka topic
     */
    @Override
    public String getKafkaTopic(String entityId) {
        String entity;
        String kafkaTopic = null;
        try {
            entity = getEntity(entityId);
            JsonParser parser = new JsonParser();
            JsonElement entityElement = parser.parse(entity);
            JsonObject obj = entityElement.getAsJsonObject();
            kafkaTopic = obj.get("kafka_topic").getAsString();
        } catch (Exception e) {
            throw e;
        }
        return kafkaTopic;
    }

    /**
     * This method returns the reID of the entity
     *
     * @param entityId
     * @return reId
     */
    @Override
    public String getReId(String entityId) {
        String entity;
        String REID = null;
        try {
            entity = getEntity(entityId);
            JsonParser parser = new JsonParser();
            JsonElement entityElement = parser.parse(entity);
            JsonObject obj = entityElement.getAsJsonObject();
            REID = obj.get("reId").getAsString();
        } catch (Exception e) {
            throw e;
        }
        return REID;
    }

    /**
     * This method returns the agent ID of the entity
     *
     * @param entityId
     * @return agentId
     */
    @Override
    public String getAgentId(String entityId) {
        String entity;
        String agentId = null;
        try {
            // TODO: another call is required here to access to th agent-id. <agent,device> tuple is listed under chariot-kms.../monitoring-service/
            entity = getEntity(entityId);
            JsonParser parser = new JsonParser();
            JsonElement entityElement = parser.parse(entity);
            JsonObject obj = entityElement.getAsJsonObject();
            agentId = obj.get("_id").getAsString();
        } catch (Exception e) {
            throw e;
        }
        return agentId;
    }

    /**
     * This method checks if the entity is in the database.
     *
     * @param entityId
     * @return status
     */
    @Override
    public boolean isEntityAvailable(String entityId) {
        String entity;
        boolean inKms = false;
        try {
            entity = getEntity(entityId);
            System.out.print(entity);
            if (!entity.equals("\"Model not found\"\n")) {
                inKms = true;
            }
        } catch (Exception e) {
            throw e;
        }
        return inKms;
    }

    /**
     * This method updates the attributes of an entity.
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void updateEntityAttribute(String entityId, PayloadEntityAttribute payload) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            if (payload != null) {
                client.sendByPatch(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/" + ( payload).getKey() + "/", payload.getValue().toString());
            }
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    /**
     * This method updates the attributes of a property of an entity.
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void updatePropertyAttribute(String entityId, PayloadPropertyAttribute payload) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            if (payload != null) {
                client.sendByPatch(client.getConnectionURI() + getEntityURIPath(payload.getObjectType()) + entityId + "/properties/" + payload.getPropertyKey() + "/" + payload.getKey() + "/", payload.getValue().toString());
            }
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    /**
     * This method updates the attributes of location
     * If the location attribute is complex, it should be converted to json string.
     *
     * @param entityId
     * @param payload
     */
    @Override
    public void updateLocation(String entityId, String otype, PayloadEntityAttribute payload) {
        WebClientConnection client = createDBConnection();

        try {
            client.connect();
            if (payload != null) {
                client.sendByPatch(client.getConnectionURI() + "/" + otype + "/" + entityId + "/location/" + (payload).getKey() + "/", payload.getValue().toString());
            }
            client.disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            client.disconnect();
        }
    }

    String getEntityURIPath(String objectType) {
        System.out.print("\n\n objectType:"+objectType);
        if (objectType.equalsIgnoreCase(IoTEntity.SERVICE)) {
            return "/" + EntityURIPath.SERVICES + "/";
        } else if (objectType.equalsIgnoreCase(IoTEntity.SENSOR)) {
            return "/" + EntityURIPath.DEVICES + "/";
        } else if (objectType.equalsIgnoreCase(IoTEntity.ACTUATOR)) {
            return "/" +  EntityURIPath.DEVICES + "/";
        } else if (objectType.equalsIgnoreCase(IoTEntity.HUMAN)) {
            return "/" + EntityURIPath.HUMANS + "/";
        }else if (objectType.equalsIgnoreCase(IoTEntity.TASK)) {
            return "/" + EntityURIPath.TASKS+ "/";
        }else if (objectType.equalsIgnoreCase(IoTEntity.SKILL)) {
            return "/" + EntityURIPath.SKILLS+ "/";
        }else {
            log.error("The given objectType is unknown!" + objectType);

        }

        return "NONE";
    }

}
