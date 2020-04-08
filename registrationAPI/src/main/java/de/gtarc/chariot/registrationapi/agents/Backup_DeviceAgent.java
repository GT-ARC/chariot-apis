package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Backup_DeviceAgent extends IoTEntityExposingBean {

    private String clientID = "DeviceClientID";
    private Device device;
    private Connection conn;

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

        this.conn = getMqttConnect(getHost(), getUsername(), getPassword(), clientID);
        this.device.setConnectionHandler((DeviceConnection)this.conn);
        
        Future<RegistrationResult> result = registrationHandler
                .registerEntity(this.conn,
                        device,
                        IoTEntity.REID_NOTREQUIRED,
                        "123",
                        "c",
                        "",
                        "actuator"
                );

        return getAbstractMessage(
                this.device.getConnectionHandler(),
                result.get()
        );
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

    @Override
    public AbstractMessage updateEntity() {
        try {
            this.device.setConnectionHandler((DeviceConnection) getMqttConnect(getHost(), getUsername(), getPassword(), clientID));
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        Future<ClientResult> result = registrationHandler.updateEntity(this.conn,
                this.device,
                IoTEntity.REID_NOTREQUIRED,
                "123"
        );
        try {
            return getAbstractMessage(
                    this.device.getConnectionHandler(),
                    result.get()
            );
        } catch (ConnectionException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> void updateProperty(T property) {
        DeviceProperty deviceProperty = (DeviceProperty) property;
        kmsHandler.updateEntityProperty(device.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.ACTUATOR,
                        deviceProperty.getKey(),
                        deviceProperty.getType(),
                        deviceProperty.getValue().toString(),
                        deviceProperty.getUnit(),
                        deviceProperty.getWritable()
                )
        );
    }

    public Device getDevice() {
        return device;
    }
}
