package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.humanapi.Human;
import de.gtarc.chariot.humanapi.HumanProperty;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class HumanAgentForRE extends IoTEntityExposingBean {


    private Human human;
    private Connection conn; 
    
    public void setEntity(Entity entity) throws Exception {
        super.setEntity(entity);
        if (!(this.entity instanceof Human))
            throw new Exception("Human Agent can only register humans");
        this.human = (Human) entity;
    }

    @Override
    public AbstractMessage register() throws ConnectionException, ExecutionException, InterruptedException {

        log.info("Register Human");

        this.setAgentActionsAsOperations();
        this.configureDatabaseConnection("/humans/" + human.getUUIdentifier().toString());

        this.conn = getMqttConnect(getMqttHostURL(), getMqttUsername(), getMqttPassword(), getMqttClientId());
        this.human.setConnectionHandler(this.conn);

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(conn,human, IoTEntity.REID_REQUIRED,"123","c","","human");
        
        return getAbstractMessage(
                this.conn,
                result.get()
        );
    }

    @Override
    public AbstractMessage updateEntity() {
        return null;
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
