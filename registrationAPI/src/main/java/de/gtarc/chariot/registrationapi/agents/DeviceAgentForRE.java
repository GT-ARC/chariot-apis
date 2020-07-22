package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyBuilder;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/***
 * Interacting with devices over a runtime environment that communicates via MQTT communication protocol is provided
 * in this class.
 * @author cemakpolat
 */
public abstract class DeviceAgentForRE extends IoTEntityExposingBean implements ConnectionListener {

    private Device device;
    private Connection conn;

    String reId;
    String reTopic = "re/";
    String deviceTopic = "device/";

    private void setAgentProperties() {
        boolean hasStatus = this.device.getProperties().stream().anyMatch(property -> property.getKey().equals("status"));
        if (!hasStatus) {
            this.device.addProperty(
                    new DevicePropertyBuilder()
                            .setTimestamp(new Date().getTime())
                            .setKey("status")
                            .setType("boolean")
                            .setUnit("")
                            .setValue(true)
                            .setWritable(true)
                            .buildDeviceProperty()
            );
        }
    }

    @Override
    public AbstractMessage register() throws Exception {
        if (this.entity == null)
            throw new Exception("Pls set entity first");

        log.info("Register Device");

        setAgentActionsAsOperations();
        setAgentProperties();

        this.configureDatabaseConnection("/devices/");
        this.conn = getMqttConnect(getMqttHostURL(), getMqttUsername(), getMqttPassword(), getMqttClientId());
        this.device.setConnectionHandler((DeviceConnection)this.conn);
        this.device.setUUIdentifier(getEntityId());
        this.conn.addConnectionListener(this);

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(this.conn,
                        device,
                        IoTEntity.REID_REQUIRED,
                        "123",
                        "c",
                        "",
                        device.getType()
                );

        AbstractMessage message = null;
        try {
            message = result.get().result;

            if (((PayloadResponse) message.getPayload()).response.equalsIgnoreCase("Success")) {
                System.out.println("Device-Agent is registered");
                ((MqttConnectionImpl)conn).subscribeTopic("device/"+device.getUUIdentifier());
            }else if(((PayloadResponse) message.getPayload()).response.equalsIgnoreCase("SuccessWithReId")) {
                ((MqttConnectionImpl)conn).subscribeTopic("device/"+device.getUUIdentifier());
                this.setREID(((PayloadResponse) message.getPayload()).reId);
            }
            System.out.println("Response received from RegistrarAgent: " +((PayloadResponse) message.getPayload()).response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return message;
    }

    public Entity getEntity() {
        return this.entity;
    }
    public MqttConnectionImpl getConnection(){
        return (MqttConnectionImpl)conn;
    }
    /**
     * Send message to the device through IoT gateway interface
     * @param payload
     */
    public void sendMessageToEntity(AbstractPayload payload) {
        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic(reTopic)
                .setResponseTopic(deviceTopic+getEntityID())
                .setTo(reId)
                .setFrom(this.getEntityID())
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();

        try {
            //MqttConnectionImpl conn = (MqttConnectionImpl)getMqttConnect(getMqttHostURL(), getMqttUsername(), getMqttPassword(), getMqttClientId()+"_sender");
            conn.send(message);
            //conn.disconnect();
        } catch (ConnectionException e) {
            e.printStackTrace();
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public void setEntity(Entity entity) throws Exception {
        this.entity = entity;
        if (!(this.entity instanceof Device))
            throw new Exception("Device Agent can only register devices");
        this.device = (Device) entity;
    }

    /**
     *update the device data model in the database
     * @return
     */
    @Override
    public AbstractMessage updateEntity() {
        Future<ClientResult> result = registrationHandler.updateEntity(this.device.getConnectionHandler(),
                this.device,
                IoTEntity.REID_REQUIRED,
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
     * update the device property oin the database
     * @param property
     * @param <T>
     */
    @Override
    public <T> void updateProperty(T property) {
        PayloadEntityProperty deviceProperty = getPayloadProperty(property);
        kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.ACTUATOR,
                        deviceProperty.getType(),
                        deviceProperty.getKey(),
                        deviceProperty.getValue()
                )
        );
    }
    public <T>  PayloadEntityProperty getPayloadProperty(T property){
        PayloadEntityProperty deviceProperty = null;
        if(property instanceof DevicePropertyImpl){
            DevicePropertyImpl dprop = (DevicePropertyImpl)property;
            deviceProperty = new PayloadEntityProperty(dprop.getTimestamp(), IoTEntity.ACTUATOR, dprop.getKey(), dprop.getType(), dprop.getValue(), dprop.getUnit(), dprop.getWritable());
        }else{
            deviceProperty = (PayloadEntityProperty) property;
        }
        return deviceProperty;
    }
    /**
     * This method is called by the device itself to update the device data
     * @param key
     * @param value
     */
    public void updateProperty(String key, Object value) {
        getDevice().getProperties().stream().filter(i -> i.getKey().equals(key)).findFirst().ifPresent(i -> {
            ((DeviceProperty) i).setValue(value);
            updateProperty(i);
        });
    }


    /**
     * updates all entities with the same timestamp
     * @param properties
     * @param <T>
     */
    public <T> void updateProperties(T[] properties) {
        long timestamp = new Date().getTime();
        Arrays.stream(properties).forEach(property ->{
            PayloadEntityProperty deviceProperty = getPayloadProperty(property);
            kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                    new PayloadEntityProperty(
                            timestamp,
                            this.device.getType(),
                            deviceProperty.getType(),
                            deviceProperty.getKey(),
                            deviceProperty.getValue()
                    )
            );
        });
    }

    /**
     * Update all given key,value properties with the same timestamp
     * @param properties contains key and value parameters of the properties
     */
    public  void updateProperties(Map<String,Object> properties) {
        long timestamp = new Date().getTime();
        properties.forEach((key,value) ->{
            getDevice().getProperties().stream().filter(i -> i.getKey().equals(key)).findFirst().ifPresent(i -> {
                i.setValue(value);
                PayloadEntityProperty deviceProperty = getPayloadProperty(i);
                kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                        new PayloadEntityProperty(
                                timestamp,
                                this.device.getType(),
                                deviceProperty.getType(),
                                deviceProperty.getKey(),
                                deviceProperty.getValue()
                        )
                );
            });
        });
    }
    /**
     * Update the value of the given device property on the device (only for Actuators not Sensors)
     *@param property
     * @param <T>
     */
    public <T> void updateIoTEntityProperty(T property) {
        PayloadEntityProperty entityProperty = getPayloadProperty(property);
        this.sendMessageToEntity(new PayloadEntityProperty(
                new Date().getTime(),
                IoTEntity.ACTUATOR,
                entityProperty.getType(),
                entityProperty.getKey(),
                entityProperty.getValue().toString()
        ));
    }

    /**
     * update iot device property
     * @param key
     * @param value
     */
    public void updateIoTEntityProperty(String key, Object value){
        getDevice().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
            i.setValue(value);
            updateIoTEntityProperty(i);
        });
    }

    /**
     * update the device attribute except properties and operations such as groupid, ip, name if possible
     * @param key
     * @param value
     */
    public void updateEntityAttribute(String key, Object value) {
        if (device.getName().equals(key)){
            device.setName(value.toString());
        }else if (device.getVendor().equals(key)){
            device.setVendor(value.toString());
        }else if (device.getFriendlyName().equals(key)){
            device.setFriendlyName(value.toString());
        }else if (device.getPlatform().equals(key)){
            device.setPlatform(value.toString());
        }

        kmsHandler.updateEntityAttribute(device.getUUIdentifier().toString(), new PayloadEntityAttribute(device.getType(),key,value));
    }


    /**
     * Handling the incoming message in order to call a method or change the property of the entity.
     * Message format: command="value", "uuid"="deviceId", inputs = {property,..}
     * @param message
     */
    public abstract void handleProperty(String message);

    public Device getDevice() {
        return device;
    }
    public void setREID(String reId) {
        this.reId = reId;
        reTopic = reTopic+reId+"/";
        System.out.println("REID sent by RegistrarAgent: " + reId);

    }

    @Override
    public void connectionStateChanged(Connection connection, ConnectionStatus status) {

    }

    @Override
    public void onMessageReceived(IMessage mes, Connection connection) throws ConnectionException {
        AbstractMessage result = (AbstractMessage) mes;
        String message = result.getPayload().getJsonString(result.getPayload().getClass());
        System.out.println("payload content:"+ message);
        if (result.getPayload() instanceof PayloadResponse) {
            if (reId != null){
                if (((PayloadResponse) result.getPayload()).response.equalsIgnoreCase("ReIdUpdate")) {
                    this.setREID(((PayloadResponse) result.getPayload()).reId);
                }else{
                    System.out.println("payload response:"+ message);
                }
            }
            else {
                System.out.println("payload response:"+ message);
            }
        }else if (result.getPayload() instanceof PayloadEntity) {
            System.out.println("payload device:"+ message);
            PayloadEntity device = AbstractPayload.fromJsonString(result.getPayload().getJsonString(result.getPayload().getClass()), PayloadEntity.class);
            this.updateEntity();
        }else if (result.getPayload() instanceof PayloadEntityProperty) {
            System.out.println("payload device property:"+ message);
            PayloadEntityProperty property = AbstractPayload.fromJsonString(result.getPayload().getJsonString(result.getPayload().getClass()), PayloadEntityProperty.class);
            this.updateProperty(property);

        }
    }
}
