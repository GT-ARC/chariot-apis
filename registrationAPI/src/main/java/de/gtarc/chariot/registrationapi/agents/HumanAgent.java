package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.HumanConnection;
import de.gtarc.chariot.humanapi.Human;
import de.gtarc.chariot.humanapi.HumanProperty;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HumanAgent extends IoTEntityExposingBean {


    private String clientID = "HumanClientID";
    private Human human;
    private Connection conn; 
    
    public void setEntity(Entity entity) throws Exception {
        this.entity = entity;
        if (!(this.entity instanceof Human))
            throw new Exception("Human Agent can only register humans");
        this.human = (Human) entity;
    }

    @Override
    public AbstractMessage register() throws ConnectionException, ExecutionException, InterruptedException {

        log.info("Register Human");

        this.setAgentActionsAsOperations();
        this.configureDatabaseConnection("/humans/" + human.getUUIdentifier().toString());

        this.conn = getMqttConnect(getHost(), getUsername(), getPassword(), clientID);
        this.human.setConnectionHandler((HumanConnection)this.conn);

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(conn,human, IoTEntity.REID_NOTREQUIRED,"123","c","","human");
        
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
//        configureDatabaseConnection("services/" + service.getUUIdentifier().toString() + "/" + serviceProperty.getKey() + "/");
        kmsHandler.updateEntityProperty(human.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.HUMAN,
                        humanProperty.getKey(),
                        humanProperty.getType(),
                        humanProperty.getValue(),
                        humanProperty.getUnit(),
                        humanProperty.getWritable()
                )
        );
    }

    public Human getHuman() {
        return this.human;
    }
}
