package de.gtarc.chariot.registrationapi.agents;

import com.gtarc.chariot.api.jiacbinding.annotations.UseServiceOWLFile;
import de.dailab.jiactng.agentcore.SimpleAgentNode;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.lifecycle.LifecycleException;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyBuilder;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.UUID;

public class REDeviceAgenExample extends DeviceAgentForRE {

    /**
     * Dont forget to add the GatewayConfig in the
     * agent configuration as parent with
     * <import resource="classpath:GatewayConfig.xml" />
     * and
     * <bean name="DeviceNode" parent="GatewayNode" scope="prototype">
     */

    private final static String uuid = "9d0262ca-9cb4-451a-8a4d-677c723caabd";
    private final static String ACTION_NAME_1 = "de.gtarc.chariot.registrationapi.agents.DeviceAgentExample#updateProperty";
    private final static String ACTION_NAME_2 = "de.gtarc.chariot.registrationapi.agents.DeviceAgentExample#myUpdateEntity";

    @Override
    public void doStart() throws Exception {
        this.setEntity(
                new DeviceBuilder()
                        .setUuid(UUID.randomUUID())
                        .setName("Device-Example-Agent")
                        .setDeviceLocation(
                                new Location(
                                        "PL-Location",
                                        "Room",
                                        "Production Line",
                                        0,
                                        new Position(0, 0, "0"),
                                        new Indoorposition("0", 0, 0)
                                )
                        )
                        .addProperty( new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                                .setKey("sophisticated_property").setType("boolean").setValue(false)
                                .setUnit("").setWritable(false).buildDeviceProperty())
                        .addProperty(new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                                .setKey("sophisticated_property_2").setType("boolean").setValue(false)
                                .setUnit("").setWritable(false).buildDeviceProperty())
                        .buildSensingDevice()
        );
        this.register();
    }

    @UseServiceOWLFile(filename = "owls/chariot_service_clear.owl")
    @Expose(name = ACTION_NAME_2, scope = ActionScope.GLOBAL)
    public void myUpdateEntity() {
        // Push updated value in db
        updateEntity();
    }

    /**
     * Data on Device Update comes through the extern request
     * @param key
     * @param value
     */
    @Expose(name = ACTION_NAME_1, scope = ActionScope.GLOBAL)
    public void updateEntityProperty(String key, Object value) {
        getDevice().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
            ((DeviceProperty) i).setValue(value);
            updateProperty(i);
            updateIoTEntityProperty(i);
        });
    }

    @Override
    @Expose(name = PROPERTY_ACTION, scope = ActionScope.GLOBAL)
    public void handleProperty(String message) {

    }


    public static void main(String[] args) {
        ApplicationContext context = SimpleAgentNode.startAgentNode("classpath:agentConfig/ExampleDeviceAgent.xml",
                "jiactng_log4j.properties");
        SimpleAgentNode node = (SimpleAgentNode) context.getBean("ExampleDeviceAgentNode");
        try {
            System.out.println("Start Node");
            node.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
