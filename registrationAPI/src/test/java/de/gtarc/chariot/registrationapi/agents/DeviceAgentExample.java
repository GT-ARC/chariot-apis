package de.gtarc.chariot.registrationapi.agents;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gtarc.chariot.api.jiacbinding.annotations.UseServiceOWLFile;
import de.dailab.jiactng.agentcore.SimpleAgentNode;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.lifecycle.LifecycleException;
import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.DeviceProperty;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.IoTEntity;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class DeviceAgentExample extends DeviceAgent  {

    /**
     * Dont forget to add the GatewayConfig in the
     * agent configuration as parent with
     * <import resource="classpath:GatewayConfig.xml" />
     * and
     * <bean name="DeviceNode" parent="GatewayNode" scope="prototype">
     */

    private final static String ACTION_NAME_1 = "de.gtarc.chariot.registrationapi.agents.DeviceAgentExample#updateProperty";
    private final static String ACTION_NAME_2 = "de.gtarc.chariot.registrationapi.agents.DeviceAgentExample#myUpdateEntity";
    private ConnectionHandler chandler;
    @Override
    public void doStart() throws Exception {
        this.setEntity( new DeviceBuilder()
                .setUuid(getEntityId())
                .setName("Device-Example-Agent")
                .setDeviceLocation(
                        new Location(
                                "PM-Location", "Room",
                                "Predictev Maintenance Room", 0,
                                new Position(0, 0, "0"),
                                new Indoorposition("0", 0, 0)
                        )
                )
                .addProperty( new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                        .setKey("sophisticated_property").setType("boolean").setValue(false)
                        .setUnit("").setWritable(false).buildDeviceProperty())
                .buildSensingDevice());

        this.register();
    }

    @UseServiceOWLFile(filename = "owls/chariot_service_clear.owl")
    @Expose(name = ACTION_NAME_2, scope = ActionScope.GLOBAL)
    public void myUpdateEntity() {
        // Push updated value in db
        updateEntity();
    }

    @Override
    @Expose(name = PROPERTY_ACTION, scope = ActionScope.GLOBAL)
    public void handleProperty(String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String command = jsonObject.get("command").getAsString();
        JsonObject inputs = jsonObject.get("inputs").getAsJsonObject();
        Set<String> keys = inputs.keySet();
        String value;
        for(String key : keys){
            value = inputs.get(key).getAsString();
            updateProperty(key,value);
            updateIoTEntityProperty(key,value);
        }
    }
    /**
     * Data on Device Update comes through the extern request
     * @param key
     * @param value
     */
    @Expose(name = ACTION_NAME_1, scope = ActionScope.GLOBAL)
    public void updateIoTEntityProperty(String key, Object value) {
        getDevice().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
            ((DeviceProperty) i).setValue(value);
            updateIoTEntityProperty(i);
        });
    }


    @Override
    public <T> void updateIoTEntityProperty(T property) {
        if (property != null) {
            PayloadEntityProperty entityProperty = (PayloadEntityProperty) property;
            chandler.sendMessageToEntity(new PayloadEntityProperty(
                    new Date().getTime(),
                    this.getDevice().getType(),
                    entityProperty.getKey(),
                    entityProperty.getType(),
                    entityProperty.getValue().toString(),
                    entityProperty.getUnit(),
                    entityProperty.getWritable()
            ));
        }
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

