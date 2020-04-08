package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.PayloadProperty;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class DeviceAgent extends IoTEntityExposingBean {

    private Device device;
    private Connection conn;

    private void setAgentProperties() {
        boolean hasStatus = this.device.getProperties().stream().anyMatch(property -> property.getKey().equals("status"));
        if (!hasStatus) {
            this.device.addProperty(
                    new DevicePropertyBuilder()
                            .setTimestamp(new Date().getTime()).setKey("status").setType("boolean")
                            .setUnit("").setValue(true).setWritable(true)
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
        this.conn = getMqttConnect(getHost(), getUsername(), getPassword(), getClientId());

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(this.conn,
                        device,
                        IoTEntity.REID_NOTREQUIRED,
                        "123",
                        "c",
                        "",
                         device.getType()
                );

        AbstractMessage message = null;
        try {
            message = result.get().result;
            if (((PayloadResponse) message.getPayload()).response.equals("Success")) {
                System.out.println("Device-Agent is registered");
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

    public void setEntity(Entity entity) throws Exception {
        this.entity = entity;
        if (!(this.entity instanceof Device))
            throw new Exception("Device Agent can only register devices");
        this.device = (Device) entity;
    }

    /**
     * update the device data model in the database
     * @return
     */
    @Override
    public AbstractMessage updateEntity() {
        Future<ClientResult> result = registrationHandler.updateEntity(this.device.getConnectionHandler(),
                this.device,
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
        getDevice().getProperties().stream().filter(i -> i.getKey().equals(key)).findFirst().ifPresent(i -> {
            ((DeviceProperty) i).setValue(value);
            updateProperty(i);
        });
    }

    /**
     * update the device property oin the database
     * @param property
     * @param <T>
     */
    @Override
    public  <T> void updateProperty(T property) {
        DeviceProperty deviceProperty = (DeviceProperty) property;
        kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        this.device.getType(),
                        deviceProperty.getKey(),
                        deviceProperty.getType(),
                        deviceProperty.getValue(),
                        deviceProperty.getUnit(),
                        deviceProperty.getWritable()
                )
        );
    }

    /**
     * updates all entities with the same timestamp
     * @param properties
     * @param <T>
     */
    public <T> void updateProperties(T[] properties) {
        long timestamp = new Date().getTime();
        Arrays.stream(properties).forEach(property ->{
            DeviceProperty deviceProperty = (DeviceProperty) property;
            kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                    new PayloadEntityProperty(
                            timestamp,
                            this.device.getType(),
                            deviceProperty.getKey(),
                            deviceProperty.getType(),
                            deviceProperty.getValue(),
                            deviceProperty.getUnit(),
                            deviceProperty.getWritable()
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
                ((DeviceProperty) i).setValue(value);
                DeviceProperty deviceProperty = ((DeviceProperty) i);
                kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                        new PayloadEntityProperty(
                                timestamp,
                                this.device.getType(),
                                deviceProperty.getKey(),
                                deviceProperty.getType(),
                                deviceProperty.getValue(),
                                deviceProperty.getUnit(),
                                deviceProperty.getWritable()
                        )
                );
            });
        });
    }

    /**
     * Handling the incoming message in order to call a method or change the property of the entity.
     * Message format: command="value", "uuid"="deviceId", inputs = {property,..}
     * @param message
     */
    public abstract void handleProperty(String message);

    /**
     * Updating IoT entity property is called when the property is modified.
     * @param property
     * @param <T>
     */
    public abstract <T> void updateIoTEntityProperty(T property);

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

        PayloadProperty attribute = new PayloadProperty();
        attribute.setKey(key);
        attribute.setValue(value);
        attribute.setObjectType(device.getType());

        kmsHandler.updateEntityAttribute(device.getUUIdentifier().toString(), attribute);
    }


    public Device getDevice() {
        return device;
    }



}
