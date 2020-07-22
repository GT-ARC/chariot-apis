package de.gtarc.chariot.registrationapi.agents;

//import com.gtarc.chariot.api.ChariotDevServiceDirectoryConnector;
import com.gtarc.chariot.api.ChariotDevServiceDirectoryConnector;
import de.dailab.jiactng.agentcore.IAgent;
import de.dailab.jiactng.agentcore.IAgentBean;
import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.registrationapi.client.RegistrationClient;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.impl.OperationImpl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


import com.gtarc.chariot.api.ServiceDirectoryConnector;
import com.gtarc.chariot.api.jiacbinding.annotations.UseServiceOWLFile;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.exception.ISCOException;
import com.gtarc.chariot.api.model.util.sparql.JenaConverter;


public abstract class IoTEntityExposingBean extends AbstractMethodExposingBean implements MQTTRegistration {

    public static final String PROPERTY_ACTION = "de.gtarc.chariot.handlePropertyAction";
    public static final String ACTION_GET_ENTITY_ID = "com.gtarc.chariot.EntityMonitoringExposingBean#getEntityID";

    // These parameters should be set through the agent xml file
    protected String mqttHostURL;
    protected String mqttUsername;
    protected String mqttPassword;
    protected String mqttClientId;
    protected String kmsURL;
    protected RegistrationClient registrationHandler = new RegistrationClient();

    protected KmsHandler kmsHandler;
    protected Entity entity;
    private UUID entityId;
    private ServiceDirectoryConnector serviceDirectoryConnector = null;

    @Override
    public void doInit() throws Exception {
        super.doInit();

        this.serviceDirectoryConnector = new ChariotDevServiceDirectoryConnector();

        for (IAgentBean agentBean : thisAgent.getAgentBeans()) {
            Arrays.asList(agentBean.getClass().getDeclaredMethods()).stream()
                    .filter(method->method.isAnnotationPresent(UseServiceOWLFile.class))
                    .filter(method->method.isAnnotationPresent(Expose.class))
                    .filter(method->method.getAnnotation(Expose.class).scope() == ActionScope.GLOBAL
                            || method.getAnnotation(Expose.class).scope() == ActionScope.WEBSERVICE)
                    .forEach(method->{
                        String filename = method.getAnnotation(UseServiceOWLFile.class).filename();
                        log.info("Try to upload owl: " + filename);
                        try {
                            registerSmartCityObjects(this.serviceDirectoryConnector, filename, method);
                        } catch (ClassCastException e) {
                            log.error(e);
                        }
                    });
        }
    }

    private void registerSmartCityObjects(ServiceDirectoryConnector connector, String filename, Method method) {
        try {
            Set<SmartCityObject> smartCityObjects = JenaConverter.convertToSmartCityObjects(filename);
            smartCityObjects.forEach(sco->{
                JiacAgentEndpoint endpoint = DomainmodelFactory.eINSTANCE.createJiacAgentEndpoint();
                endpoint.setAgentNodeId(thisAgent.getAgentNode().getUUID());
                endpoint.setAgentId(thisAgent.getAgentId());
                endpoint.setActionName(method.getAnnotation(Expose.class).name());
                sco.setEndpoint(endpoint);
                connector.register(sco, null, null);
            });
        } catch (ISCOException e) {
            log.error(e);
        }
    }

    public Connection getMqttConnect(String host, String username, String password, String clientId) throws ConnectionException {
        ServiceConnection dcl;
        try {
            dcl = new MqttConnectionImpl(host, username, password, clientId);
            dcl.connect();
        } catch (ConnectionException e1) {
            e1.printStackTrace();
            throw e1;
        }
        return dcl;
    }

    @Override
    public AbstractMessage getAbstractMessage(Connection dcl, ClientResult clientResult) throws ConnectionException {
        AbstractMessage message = null;

        message = clientResult.result;
        System.out.println("registrar agent-" + ((PayloadResponse) message.getPayload()).response);

        return message;
    }

    void setAgentActionsAsOperations() {
        List<IActionDescription> agentActions = thisAgent.getActionList();
        agentActions = agentActions.stream().filter(a -> a.getScope() == ActionScope.GLOBAL).collect(Collectors.toList());
        for (IActionDescription actionDescription : agentActions) {
            this.entity.addOperation(
                    new OperationImpl(
                            actionDescription.getName(),
                            actionDescription.getInputTypeNames() != null ?
                                    actionDescription.getInputTypeNames().toArray(new String[0])
                                    : new String[0],
                            actionDescription.getResultTypeNames() != null ?
                                    actionDescription.getResultTypeNames().toArray(new String[0])
                                    : new String[0]
                    )
            );
        }
    }

    public void configureDatabaseConnection(String entityName) {
        this.kmsHandler = new KmsHandlerImpl();
        try {
            kmsHandler.setURI(kmsURL, entityName);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage()+" "+e.getReason());
            e.printStackTrace();
        }
    }

    public abstract AbstractMessage register() throws Exception;

    public abstract AbstractMessage updateEntity();

    public abstract <T> void updateProperty(T property);


    protected void setEntity(Entity entity) throws Exception {
        if (entity != null
                && (entity.getUUIdentifier() == null || entity.getUUIdentifier().toString().equals(""))
                && !this.getEntityID().equals(""))
            entity.setUUIdentifier(UUID.fromString(this.getEntityID()));
        this.entity = entity;
    };

    public Entity getEntity() {
        return this.entity;
    }

    public IAgent getAgent() {
        return thisAgent;
    }

    public void publicInvoke(IActionDescription actionDescription, Serializable[] parameters) {
        invoke(actionDescription, parameters);
    }

    /**
     * Getter for the entity id.
     * Exposed as global action and used by the monitoring agent
     *
     * @return The entity id
     */
    @Expose(name = ACTION_GET_ENTITY_ID, scope = ActionScope.GLOBAL)
    public String getEntityID() {
        if (this.entity == null) {
            if (this.entityId == null)
                return "";
            else
                return this.entityId.toString();
        }
        return this.entity.getUUIdentifier().toString();
    }

    /**
     * Getter for the mqttHostURL
     *
     * @return
     */
    public String getMqttHostURL() {
        return this.mqttHostURL;
    }

    /**
     * Setter for the mqttHostURL
     *
     * @param Host
     */
    public void setMqttHostURL(String Host) {
        this.mqttHostURL = Host;
    }

    /**
     * Getter for the mqttUsername
     *
     * @return
     */
    public String getMqttUsername() {
        return this.mqttUsername;
    }

    /**
     * Setter for the mqttUsername
     *
     * @param Username
     */
    public void setMqttUsername(String Username) {
        this.mqttUsername = Username;
    }

    /**
     * Getter for the mqttPassword
     *
     * @return
     */
    public String getMqttPassword() {
        return this.mqttPassword;
    }


    /**
     * Setter for the mqttPassword
     *
     * @param Password
     */
    public void setMqttPassword(String Password) {
        this.mqttPassword = Password;
    }

    /**
     * Each mqtt connection requires a client id
     * @param id
     */
    public void setMqttClientId(String id){this.mqttClientId = id;}

    /**
     * getter for client id
     * @return
     */
    public String getMqttClientId(){return this.mqttClientId;}

    /**
     * Set Database URL Address
     * @param url
     */
    public void setKmsURL(String url){
        this.kmsURL = url;
    }

    /**
     * Provides Database URL Address
     * @return
     */
    public String getKmsUrl(){return this.kmsURL;}
//
//    public ServiceDirectoryConnector getServiceDirectoryConnector() {
//        return serviceDirectoryConnector;
//    }
//
//    public void setServiceDirectoryConnector(ServiceDirectoryConnector serviceDirectoryConnector) {
//        this.serviceDirectoryConnector = serviceDirectoryConnector;
//    }

    /**
     * IoT Entity Id is set through entity.xml file
     * @param id
     */
    public void setEntityId(String id){this.entityId = UUID.fromString(id);}

    /**
     * IoT Entity Id
     * @return
     */
    public UUID getEntityId(){return this.entityId;}
}
