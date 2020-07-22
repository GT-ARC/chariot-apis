package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.PayloadEntityAttribute;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.RegistrationClient;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.chariot.serviceapi.Service;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class ServiceAgent extends IoTEntityExposingBean {

    private Service service;
    private Connection conn; 

    @Override
    public AbstractMessage register() throws ConnectionException, ExecutionException, InterruptedException {

        this.setAgentActionsAsOperations();
        this.configureDatabaseConnection("/services/");
        this.mqttClientId = this.entity.getUUIdentifier().toString();
        this.conn = getMqttConnect(getMqttHostURL(), getMqttUsername(), getMqttPassword(), getMqttClientId());
        this.service.setConnectionHandler((ServiceConnection)this.conn);

        Future<RegistrationResult> result = registrationHandler
                .registerEntity(
                		conn,
                        service,
                        IoTEntity.REID_NOTREQUIRED,
                        "123",
                        "c",
                        "",
                        "service"
                );
        return getAbstractMessage(
                this.service.getConnectionHandler(),
                result.get()
        );
    }

    public void setEntity(Entity entity) throws Exception {
        super.setEntity(entity);
        if (!(this.entity instanceof Service))
            throw new Exception("Service Agent can only register services");
        this.service = (Service) entity;
    }



    @Override
    public AbstractMessage updateEntity() {
        return null;
    }

    public AbstractMessage addEntityProperty(ServiceProperty serviceProperty) throws ConnectionException, ExecutionException, InterruptedException {
        serviceProperty.setConnectionHandler((ServiceConnection) this.conn);
        RegistrationClient registrationHandler = new RegistrationClient();
        Future<ClientResult> result = registrationHandler.addEntityProperty(
        		this.conn,
                serviceProperty,
                service.getUUIdentifier().toString(),
                "123"
        );
        return getAbstractMessage(
                serviceProperty.getConnectionHandler(),
                result.get()
        );
    }

    @Override
    public <T> void updateProperty(T property) {
        ServiceProperty serviceProperty = (ServiceProperty) property;
        kmsHandler.updateEntityProperty(service.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.SERVICE,
                        serviceProperty.getType(),
                        serviceProperty.getKey(),
                        serviceProperty.getValue()
                ));
    }

    /**
     * Update service data in the database
     * @param key
     * @param value
     */
    public void updateProperty(String key, Object value) {
        service.getProperties().stream().filter(i -> i.getKey().equals(key)).findFirst().ifPresent(i -> {
            ((ServiceProperty) i).setValue(value);
            updateProperty(i);
        });
    }
    //TODO: What else could be updated in a service?
    public void updateEntityAttribute(String key, Object value) {
        if (service.getName().equals(key)){
            service.setName(value.toString());
        }
        kmsHandler.updateEntityAttribute(service.getUUIdentifier().toString(), new PayloadEntityAttribute(service.getType(), key,value));
    }
    public Service getService() {
        return this.service;
    }

}
