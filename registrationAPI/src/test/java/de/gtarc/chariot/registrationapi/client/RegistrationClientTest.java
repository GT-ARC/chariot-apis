package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.chariot.registrationapi.server.RegistrationServer;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
@Ignore
public class RegistrationClientTest {

    String host = "tcp://130.149.232.235:1083";
    //String mqttHostURL = "tcp://localhost:1883";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";
    String clientId = "ClientRegistrationTest";

    String agentUUID = "001";

    @Ignore
    @Test
    // Test to create a client and check the response message is correct.
    public void createClient() throws ExecutionException, InterruptedException, TimeoutException, ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();
        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

        Location location = new Location("", "", "", 1, new Position(0.0, 0.0, null), new Indoorposition(null, 0.0, 0.0));

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
        AbstractMessage message = registrationClient.registerEntity(dc,device, "", "", "xx","", "sensor").get(5, TimeUnit.SECONDS).result;

        assertEquals(message.getMessageType(), PayloadResponse.class.getName());
        dc.disconnect();
        dcServer.disconnect();
    }

    @Ignore
    @Test
    // Create multiple clients and register them both.
    public void multipleRegistration() throws ExecutionException, InterruptedException, TimeoutException, ConnectionException {
        Device device1 = new DeviceBuilder().buildSensingDevice();
        Device device2 = new DeviceBuilder().buildSensingDevice();
        device1.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        device2.setUUIdentifier(UUID.fromString("bfe8efe8-ecf7-4f17-ae64-805c3ff6ff1b"));

        Location location = new Location("", "", "", 1, new Position(0.0, 0.0, null), new Indoorposition(null, 0.0, 0.0));

        DeviceConnection dc1 = new MqttConnectionImpl(host, username, password, "TestClient_MultipleClient1");
        dc1.connect();
        device1.setConnectionHandler(dc1);

        DeviceConnection dc2 = new MqttConnectionImpl(host, username, password, "TestClient_MultipleClient2");
        dc2.connect();
        device2.setConnectionHandler(dc2);

        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "TestClient_MultipleServer");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();

        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        RegistrationClient registrationClient1 = new RegistrationClient();
        RegistrationClient registrationClient2 = new RegistrationClient();
        Future<RegistrationResult> result1 = registrationClient1.registerEntity(dc1,device1, "", "","", "xx", "sensor");
        Future<RegistrationResult> result2 = registrationClient2.registerEntity(dc2, device2, "", "", "", "xx", "sensor");


        // You can wait until the result is returned, the get() method is a blocking method
        // But the general procedure of client registering is not a blocking process.
        // The usage of get() is optional.
        AbstractMessage message = result1.get(5, TimeUnit.SECONDS).result;

        AbstractMessage message2 = result2.get(5, TimeUnit.SECONDS).result;

        assertEquals(message.getMessageType(), PayloadResponse.class.getName());
        assertEquals(message2.getMessageType(), PayloadResponse.class.getName());


        dc1.disconnect();
        dc2.disconnect();
        dcServer.disconnect();
    }


}
