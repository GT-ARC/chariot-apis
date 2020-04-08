package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;

/**
 * @author cemakpolat
 */
public class ConnectionHandler implements ConnectionListener {
    private String reId;
    String reTopic = "re/";
    String deviceTopic = "device/";
    DeviceAgentExample entity;
    ConnectionHandler(DeviceAgentExample deviceAgentExample){
        entity = deviceAgentExample;
    }
    @Override
    public void connectionStateChanged(Connection connection, ConnectionStatus status) {

    }
    @Override
    public void onMessageReceived(IMessage mes, Connection connection) throws ConnectionException {
        AbstractMessage result = (AbstractMessage) mes;
        String message = result.getPayload().getJsonString(result.getPayload().getClass());
        if (result.getPayload() instanceof PayloadResponse) {
            if (reId != null){
                if (((PayloadResponse) result.getPayload()).response.equalsIgnoreCase("ReIdUpdate")) {
                    this.reTopic = reTopic+""+((PayloadResponse) result.getPayload()).reId+"/";
                }else{
                    System.out.println("payload response:"+ message);
                }
            }
            else {
                System.out.println("payload response:"+ message);
            }
        }else if (result.getPayload() instanceof PayloadEntity) {
            PayloadEntity device = AbstractPayload.fromJsonString(result.getPayload().getJsonString(result.getPayload().getClass()), PayloadEntity.class);
            entity.updateEntity();
        }else if (result.getPayload() instanceof PayloadEntityProperty) {
            PayloadEntityProperty property = AbstractPayload.fromJsonString(result.getPayload().getJsonString(result.getPayload().getClass()), PayloadEntityProperty.class);
            entity.updateProperty(property);

        }
    }
    /**
     * Send message to the device through IoT gateway interface
     * @param payload
     */
    public void sendMessageToEntity(AbstractPayload payload) {
        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic(reTopic+reId) // find here the device topic
                .setResponseTopic(deviceTopic+entity.getEntityID())
                .setTo(reId)
                .setFrom(entity.getEntityID())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();

        try {
            entity.getDevice().getConnectionHandler().send(message);
        } catch (ConnectionException e) {
            e.printStackTrace();
            System.out.println("Exception: "+e.getMessage());
        }
    }
    public void setRuntimeEnvironmentId(String reId) {
        reTopic = reTopic+reId+"/";
        System.out.println("REID sent by RegistrarAgent: " + reId);

    }
}
