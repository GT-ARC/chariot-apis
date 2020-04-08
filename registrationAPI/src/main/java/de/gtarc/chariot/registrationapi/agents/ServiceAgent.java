package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.dbhandlerapi.impl.KmsHandlerImpl;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.registrationapi.client.RegistrationClient;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.chariot.serviceapi.Service;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceAgent extends IoTEntityExposingBean {


    private String clientID = "ServiceClientID";
    private Service service;
    private Connection conn; 

    @Override
    public AbstractMessage register() throws ConnectionException, ExecutionException, InterruptedException {

        this.setAgentActionsAsOperations();
        this.configureDatabaseConnection("/services/");

        this.conn = getMqttConnect(getHost(), getUsername(), getPassword(), clientID);
        this.service.setConnectionHandler((ServiceConnection)this.conn);

        try {
            this.kmsHandler = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
        this.entity = entity;
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
//        configureDatabaseConnection("services/" + service.getUUIdentifier().toString() + "/" + serviceProperty.getKey() + "/");
        kmsHandler.updateEntityProperty(service.getUUIdentifier().toString(),
                new PayloadEntityProperty(
                        new Date().getTime(),
                        IoTEntity.SERVICE_OBJECTTYPE,
                        serviceProperty.getKey(),
                        serviceProperty.getUnit(),
                        serviceProperty.getType(),
                        serviceProperty.getValue(),
                        serviceProperty.getRelatedTo(),
                        serviceProperty.getOperation()
                ));
    }

    public Service getService() {
        return this.service;
    }

}
