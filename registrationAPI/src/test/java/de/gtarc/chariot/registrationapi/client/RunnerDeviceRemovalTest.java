package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.DummyDbHandlerImpl;
import de.gtarc.chariot.dbhandlerapi.impl.KmsHandlerImpl;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.payload.PayloadEntityRemoval;
import de.gtarc.chariot.registrationapi.client.util.ClientUtils;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.chariot.registrationapi.server.RegistrationServer;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@Ignore
public class RunnerDeviceRemovalTest {

    String host = "tcp://130.149.232.235:1083";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";

    String agentUUID = "001";

    @Test
    // Creates an device removal message check if its correctly created.
    public void createDeviceRemovalMessage() throws ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();
        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "RunnerKeepAliveTest");
        device.setConnectionHandler(dc);

        Property[] properties = new SimplePropertyImpl[2];
        properties[0] = new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();

        device.addProperty(properties[0]);
        device.addProperty(properties[1]);

        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String currentTime = LocalDateTime.now().format(formatter);


        AbstractMessage message = ClientUtils.createRemoval("", "register",
                "register_result", "client", "server",
                "0001", device.getUUIdentifier().toString(), "", device);


        assertTrue(((PayloadEntityRemoval) message.getPayload()).getReId().equals("0001"));
        assertEquals("{\"header\":{\"url\":\"\",\"topic\":\"register\",\"responseTopic\":\"register_result\",\"from\":\"server\",\"to\":\"client\",\"timeSent\":\"" + message.getTimeSent() + "\",\"messageType\":\"de.gtarc.chariot.deviceapi.payload.PayloadDeviceRemoval\"},\"payload\":{\"reId\":\"0001\",\"uuid\":\"a1f114f5-f47f-449d-b579-6605bba061c8\",\"securitykey\":\"\"}}", message.getJsonObject());
        System.out.println(message.getJsonObject());

    }

    @Test
    // Sends a device removal message and check if its correctly removed.
    public void removeDevice() throws ExecutionException, InterruptedException, TimeoutException, ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();
        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));
        Property[] properties = new SimplePropertyImpl[2];
        properties[0] = new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();


        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "TestClient_Client");
        dc.connect();

        device.setConnectionHandler(dc);

        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "TestClient_Server");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();

        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        RegistrationClient registrationClient = new RegistrationClient();
        AbstractMessage message = registrationClient.registerEntity(dc,device, agentUUID, "", "xx", "","Sensor").get(5, TimeUnit.SECONDS).result;

        assertTrue(dummyDbHandler.isEntityAvailable(device.getUUIdentifier().toString()));
        registrationClient.removeEntity(dc,device, "", "").get();
        assertFalse(dummyDbHandler.isEntityAvailable(device.getUUIdentifier().toString()));
        dc.disconnect();
        dcServer.disconnect();
    }

}
