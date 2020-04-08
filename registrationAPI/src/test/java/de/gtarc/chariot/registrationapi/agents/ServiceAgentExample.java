package de.gtarc.chariot.registrationapi.agents;

import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.chariot.serviceapi.impl.ServiceBuilder;
import de.gtarc.chariot.serviceapi.impl.ServicePropertyBuilder;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ServiceAgentExample extends ServiceAgent {

    /**
     * Dont forget to add the GatewayCobfug in the
     * agent configuration as parent with
     * <import resource="classpath:GatewayConfig.xml" />
     * and
     * <bean name="DeviceNode" parent="GatewayNode" scope="prototype">
     */

    private final static String uuid = "9d0262ca-9cb4-451a-8a4d-677c723caabd";
    private final static String ACTION_NAME_1 = "de.gtarc.chariot.registrationapi.agents.ServiceAgentExample#updateProperty";
    private final static String ACTION_NAME_2 = "de.gtarc.chariot.registrationapi.agents.ServiceAgentExample#addProperty";

    private ServiceProperty myServiceProperty;

    @Override
    public void doStart() throws Exception {
        this.setEntity(
                new ServiceBuilder()
                        .setUuid(UUID.fromString(uuid))
                        .setName("Example-Agent-Service")
                        .buildService()
        );
        this.register();
    }

    @Expose(name = ACTION_NAME_1, scope = ActionScope.GLOBAL)
    public String updateProperty(String key, Object value) {
        getService().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
            ((DeviceProperty) i).setValue(value);
            updateProperty(i);
        });
        // Push updated value in db
        myServiceProperty.setValue(value);
        updateProperty(myServiceProperty);
        return "Success";
    }

    @Expose(name = ACTION_NAME_2, scope = ActionScope.GLOBAL)
    public void addProperty() throws ConnectionException, ExecutionException, InterruptedException {
        this.myServiceProperty = new ServicePropertyBuilder()
                .setTimestamp(new Date().getTime())
                .setKey("sophisticated_key")
                .setType("boolean")
                .setValue(false)
                .setUnit("")
                .setWritable(false)
                .buildServiceProperty();

        addEntityProperty(myServiceProperty);
    }

    public void servicePropertyUpdateTest() {
        ServiceProperty serviceProperty = new ServicePropertyBuilder()
                .setTimestamp(new Date().getTime())
                .setKey("sophisticated_key")
                .setType("number")
                .setValue(1)
                .setUnit("degree")
                .setWritable(false)
                .buildServiceProperty();
        ;
        kmsHandler.updateEntityProperty("9e38f6ac-c58d-41d9-8e7c-bcfcc5cf386e",
                new PayloadEntityProperty(
                        new Date().getTime(),
                        "service",
                        serviceProperty.getKey(),
                        serviceProperty.getUnit(),
                        serviceProperty.getType(),
                        serviceProperty.getValue(),
                        serviceProperty.getRelatedTo(),
                        serviceProperty.getOperation()
                )
        );
    }
}
