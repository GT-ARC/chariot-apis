package de.gtarc.chariot.registrationapi.agents;

import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.humanapi.Human;
import de.gtarc.chariot.humanapi.HumanProperty;
import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class HumanAgent extends IoTEntityExposingBean {


    private Human human;
    private Connection conn; 
    
    public void setEntity(Entity entity) throws Exception {
        super.setEntity(entity);
        if (!(this.entity instanceof Human))
            throw new Exception("Human Agent can only register humans");
        this.human = (Human) entity;
    }
    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public AbstractMessage register() throws ConnectionException, ExecutionException, InterruptedException {

        log.info("Register Human");

        this.setAgentActionsAsOperations();
        this.configureDatabaseConnection("/humans/");

        this.conn = getMqttConnect(getMqttHostURL(), getMqttUsername(), getMqttPassword(), getMqttClientId());
        this.human.setConnectionHandler(this.conn);

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(conn, human, IoTEntity.REID_NOTREQUIRED,"123","c","",IoTEntity.HUMAN);

        AbstractMessage message = null;
        try {
            message = result.get().result;
            if (((PayloadResponse) message.getPayload()).response.equals("Success")) {
                System.out.println("Human-Agent is registered");
            }
            System.out.println("Response received from RegistrarAgent: " +((PayloadResponse) message.getPayload()).response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * update the device data model in the database
     * @return
     */
    @Override
    public AbstractMessage updateEntity() {
        Future<ClientResult> result = registrationHandler.updateEntity(conn,
                this.human,
                IoTEntity.REID_NOTREQUIRED ,
                "123"
        );
        try {
            return getAbstractMessage(
                    this.conn,
                    result.get()
            );
        } catch (ConnectionException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method is called by the device itself to update the device data
     * @param key
     * @param value
     */
    public void updateProperty(String key, Object value) {
        getHuman().getProperties().stream().filter(i -> i.getKey().equals(key)).findFirst().ifPresent(i -> {
            (i).setValue(value);
            updateProperty(i);
        });
    }

    @Override
    public <T> void updateProperty(T property) {
        HumanProperty humanProperty = (HumanProperty) property;
        kmsHandler.updateEntityProperty(human.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.HUMAN,
                        humanProperty.getType(),
                        humanProperty.getKey(),
                        humanProperty.getValue()
                )
        );
    }
    /**
     * Handling the incoming message in order to call a method or change the property of the entity.
     * Message format: command="value", "uuid"="deviceId", inputs = {property,..}
     * @param message
     */
    @Expose(name = PROPERTY_ACTION, scope = ActionScope.GLOBAL, returnTypes = {})
    public abstract void handleProperty(String message);


    /**
     * update the human attribute except properties and operations such as groupid, ip, name if possible
     * @param key
     * @param value
     */

    public void updateEntityAttribute(String key, Object value) {
        if (human.getName().equals(key)){
            human.setName(value.toString());
        }
        kmsHandler.updateEntityAttribute(human.getUUIdentifier().toString(), new PayloadEntityAttribute(human.getType(), key,value));
    }
    public Human getHuman() {
        return this.human;
    }
}
