package de.gtarc.chariot.registrationapi.server;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.dbhandlerapi.DbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntityRegistration;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.chariot.messageapi.payload.*;
import de.gtarc.commonapi.utils.IoTEntity;

import java.net.URISyntaxException;
import java.util.UUID;

public class DummyRegisterRunner implements Runnable {
    private AbstractMessage request;
    private Connection connectionHandler;
    private DbHandler dummyDbHandler;
    //private KmsHandler dummyDbHandler;

    private static String responseTopicBase = TopicConfig.registerResponseBase;

    // This constructor will be used for delivering the db handler etc.

    public DummyRegisterRunner(AbstractMessage request, Connection connectionHandler, DbHandler dbhandler) {
        this.request = request;
        this.connectionHandler = connectionHandler;
        //this.dummyDbHandler = dummyDbHandler;
        this.dummyDbHandler = (KmsHandler)dbhandler;
    }
    @Override
    public void run() {
        AbstractPayload payload = request.getPayload();
        System.out.println(payload.getClass().getName());
        try {
        	if (payload instanceof PayloadEntityRegistration) {
        		registerEntity((PayloadEntityRegistration)payload);
        	}else if (payload instanceof PayloadEntityUpdate) {
        		updateEntity((PayloadEntityUpdate)payload);
        	}else if (payload instanceof PayloadEntityDeactivation) {
        		deactivateEntity((PayloadEntityDeactivation)payload);
        	}else if (payload instanceof PayloadEntityKeepAlive) {
        		keepEntityAliveCall((PayloadEntityKeepAlive)payload);
        	} else if (payload instanceof PayloadEntityPropertyAdd) {
        		addEntityProperty((PayloadEntityPropertyAdd)payload);
        	}  else if (payload instanceof PayloadEntityRemoval) {
        		removeEntity((PayloadEntityRemoval)payload);
        	}

        } catch (ConnectionException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void removeEntity(PayloadEntityRemoval payload) throws ConnectionException, URISyntaxException {
        //dummyDbHandler.removeEntity(payload.getUuid(),payload);
        //kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/"+payload.getObjectType()+"/");
        dummyDbHandler.removeEntity(payload.getUuid(), payload);
        connectionHandler.send(createResponse(true));
    }

    public void updateEntity(PayloadEntityUpdate payload) throws ConnectionException, URISyntaxException {
        //dummyDbHandler.updateEntity(payload.getUuid(), payload);
        //kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/"+payload.getObjectType()+"/");
//        kmsHandler.updateEntity(payload.getUuid(), payload);
        connectionHandler.send(createResponse(true));
    }

    public void registerEntity(PayloadEntityRegistration payload) throws ConnectionException, URISyntaxException {
    	
    	if (payload.getObjectType().equalsIgnoreCase(IoTEntity.SERVICE)) {
    		callServiceRegistration(payload);
    	} else if (payload.getObjectType().equalsIgnoreCase(IoTEntity.DEVICE)) {
    		callDeviceRegistration(payload);
    	}else if (payload.getObjectType().equalsIgnoreCase(IoTEntity.HUMAN)) {
    		callHumanRegistration(payload);
    	}
    }

    private void callHumanRegistration(PayloadEntityRegistration payload) throws ConnectionException, URISyntaxException {
		// TODO Auto-generated method stub
//         kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/humans/");

        dummyDbHandler.registerEntity(payload);
         connectionHandler.send(createResponse(true));
	}

	private void callDeviceRegistration(PayloadEntityRegistration payload)  throws ConnectionException, URISyntaxException {
		AbstractMessage response = null;
        System.out.println("deviceRegistrationCall:" + payload.getId() + " " + payload.getIp() + " " + payload.getReId());
        // When a device registration request arrives, it creates a new device from the payload and stores it in the dbhandler.
        //kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/devices/");

//        dummyDbHandler.setEntityPath(payload.getObjectType());
//        // Messages sent by Device Agents
//        if (payload.getReId() != null && payload.getReId().equalsIgnoreCase(IoTEntity.REID_NOTREQUIRED)) { //Call from deviceAgent that does not expect reId, posts deviceAgent data to Kms
//            kmsHandler.registerEntity(payload);
//            response = createResponse(true);
//        } else if (payload.getReId() != null && payload.getReId().equalsIgnoreCase(IoTEntity.REID_REQUIRED)) { //Call from deviceAgent, that expects reId, posts deviceAgent data to Kms
//            if (kmsHandler.isEntityAvailable(payload.getUuid())) { //Checks if deviceAgent is in Kms
//                if (kmsHandler.getReId(payload.getUuid()).equalsIgnoreCase(IoTEntity.REID_REQUIRED)) {  //Checks if deviceAgent has already found its reId
//                    response = createResponse(true);
//                } else { // DeviceAgent has already found its reId
//                    String REID = kmsHandler.getReId(payload.getUuid()); //kms get reID
//                    System.out.println("Registered without reId and found the reId from the db, reId: " + REID);
//                    payload.setReId(REID);
//                    kmsHandler.updateEntity(payload.getUuid(), payload);
//                    response = createResponse(REID); // sent REID over MQTT protocol to Device Agent
//                }
//            } else {
//                kmsHandler.registerEntity(payload);
//                response = createResponse(true);
//            }
//        } else { //Messages sent by IOLITE
//            try {
//                UUID reId = UUID.fromString(payload.getReId()); // try to generate UUID from the given string uuid format
//                if (dummyDbHandler.isEntityAvailable(payload.getUuid())) { // return boolean
//                    if (dummyDbHandler.getReId(payload.getUuid()).equalsIgnoreCase(IoTEntity.REID_REQUIRED)) { //Checks if deviceAgent has already found its reId
//                        // get agent Id from kms
//                        String agentId = dummyDbHandler.getAgentId(payload.getUuid());
//                        payload.setId(agentId);
//                        dummyDbHandler.updateEntity(payload.getUuid(), payload);
//                        response = createResponse(reId.toString()); // sent REID over MQTT protocol to Device Agent
//                        // TODO: Identify which message format is right!
//                        //AbstractMessage agentMessage = createAgentResponse(payload.getReId(), agentId, device.getUUIdentifier().toString());
//
//                    } else {
//                        response = createResponse(true);
//                    }
//                } else {
//                    dummyDbHandler.registerEntity(payload);
//                    response = createResponse(true);
//                }
//            } catch (IllegalArgumentException exception) {
//                System.out.println("REID is not in the form of UUID: " + payload.getReId());
//            }
//        }
        if (response != null) {
            connectionHandler.send(response);
        }
	}

	private void callServiceRegistration(PayloadEntityRegistration payload) throws ConnectionException, URISyntaxException {
        System.out.print("serviceRegistrationCall: \n\n");
        //kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/services/");
        dummyDbHandler.registerEntity(payload);
        connectionHandler.send(createResponse(true));
    }


    /**
     * When a service registration request arrives, it creates a new service from the payload
     * @param payload
     * @throws URISyntaxException
     * @throws ConnectionException
     */

    private void addEntityProperty(PayloadEntityPropertyAdd payload) throws URISyntaxException, ConnectionException {
        //kmsHandler.setURI("http://chariot-km.dai-lab.de:8080/v1/", "/"+payload.objectType+"/" + payload.entityUUID() + "/properties/");
        //TODO: This part should be fixed
        //String kmsResponse = kmsHandler.updateEntityProperty(payload.); putServiceProperty(payload.getPayloadServiceProperty());
        String kmsResponse = "response";
        connectionHandler.send(createResponse(kmsResponse));
    }


	public void keepEntityAliveCall(PayloadEntityKeepAlive payload) throws ConnectionException {
        connectionHandler.send(createResponse(true));
    }
    public void deactivateEntity(PayloadEntityDeactivation payload) throws ConnectionException {
        connectionHandler.send(createResponse(true));
    }
    public AbstractMessage createResponse(boolean success) {
        PayloadResponse payload;
        if (success)
            payload = new PayloadResponse("Success");
        else
            payload = new PayloadResponse("Failure");

        return new MessageBuilder()
                .setUrl(request.getUrl())
                .setTopic(request.getResponseTopic())
                .setTo(request.getFrom())
                .setFrom(request.getTo())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();
    }

    public AbstractMessage createStringResponse(String response) {
        PayloadResponse payload = new PayloadResponse(response);
        return new MessageBuilder()
                .setUrl(request.getUrl())
                .setTopic(request.getResponseTopic())
                .setTo(request.getFrom())
                .setFrom(request.getTo())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();
    }

    public AbstractMessage createResponse(String reId) {
        PayloadResponse payload = new PayloadResponse("SuccessWithReId", reId);
        return new MessageBuilder()
                .setUrl(request.getUrl())
                .setTopic(request.getResponseTopic())
                .setTo(request.getFrom())
                .setFrom(request.getTo())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();
    }

    public AbstractMessage createAgentResponse(String reId, String agentId, String deviceId) {
        PayloadResponse payload = new PayloadResponse("ReIdUpdate", reId);
        return new MessageBuilder()
                .setUrl(request.getUrl())
                .setTopic(responseTopicBase + deviceId)
                .setTo(agentId)
                .setFrom(request.getTo())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();
    }

}

