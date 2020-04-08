package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DeviceStatusImpl;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
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
import static org.junit.Assert.assertFalse;

@Ignore
public class SeparatedAgentAndReTest {

    String host = "tcp://130.149.232.235:1083";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";

    String agentUUID = "001";

    String reId = "0001";


    @Test
    // First, a RE register itself and then an agent is trying to register,
    // we expect that the reid will be delivered in response.
    public void createReAndAgent() throws ExecutionException, InterruptedException, TimeoutException, ConnectionException {
        Device device1 = new DeviceBuilder().buildSensingDevice();
        Device device2 = new DeviceBuilder().buildSensingDevice();
        device1.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        device2.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));

        DeviceConnection dc1 = new MqttConnectionImpl(host, username, password, "SeparatedAgent1");

        dc1.connect();

        device1.setConnectionHandler(dc1);

        DeviceConnection dc2 = new MqttConnectionImpl(host, username, password, "SeparatedRE1");
        dc2.connect();

        device2.setConnectionHandler(dc2);

        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "SeparatedRegisterServer1");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();

        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        RegistrationClient registrationClient1 = new RegistrationClient();
        RegistrationClient registrationClient2 = new RegistrationClient();

        Device devices[] = new Device[]{new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(device1.getUUIdentifier()).buildSensingDevice()};

        // You can wait until the result is returned, the get() method is a blocking method
        // But the general procedure of client registering is not a blocking process.
        // The usage of get() is optional.
//        Future<ClientResult> result2 = registrationClient2.registerRe(device2, reId, devices, "");
//        AbstractMessage message2 = result2.get(5, TimeUnit.SECONDS).result;

        Future<RegistrationResult> result1 = registrationClient1.registerEntity(dc1,device1, agentUUID,
        		"",
                "", "xx", "Sensor");
        AbstractMessage message = result1.get(5, TimeUnit.SECONDS).result;

        assertEquals(reId, ((PayloadResponse) message.getPayload()).reId);

        dc1.disconnect();
        dc2.disconnect();
        dcServer.disconnect();
    }


    /*Test scenario:
    Agent registers first without a RE, then the register agent will register this agent without a ReId
    After that, the RE registers itselt, then we expect to register servis will notify the agent that
    the device has been registered, and delivers the ReId to the agent.
     */
    @Test
    public void createAgentAndReAfter() throws ExecutionException, InterruptedException, TimeoutException, ConnectionException {


        Device device1 = new DeviceBuilder().buildSensingDevice();
        device1.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        Device device2 = new DeviceBuilder().buildSensingDevice();
        device2.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));

        DeviceConnection dc1 = new MqttConnectionImpl(host, username, password, "SeparatedAgent2");
        dc1.connect();
        device1.setConnectionHandler(dc1);

        DeviceConnection dc2 = new MqttConnectionImpl(host, username, password, "SeparatedRE2");
        dc2.connect();
        device2.setConnectionHandler(dc2);

        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "SeparatedRegisterServer2");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();

        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        RegistrationClient registrationClient1 = new RegistrationClient();
        RegistrationClient registrationClient2 = new RegistrationClient();


        // Registration of the agent without re registered.
        System.out.println("Now waiting agent registration from server");
        RegistrationResult result1 = registrationClient1.registerEntity(dc1, device1, agentUUID, "","",
                "xx", "Sensor").get(5, TimeUnit.SECONDS);

        AbstractMessage message = result1.result;


        // In the result, we expect the reId to be null, because RE has not been registered.
        assertEquals(null, ((PayloadResponse) message.getPayload()).reId);

        // We expect the reid future is not done yet, because re has not been registered.
        assertFalse(result1.reid.isDone());

        Device devices[] = new Device[]{new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(device1.getUUIdentifier()).buildSensingDevice()};

//        Future<ClientResult> result2 = registrationClient2.registerRe(device2, reId, devices, "");
//        System.out.println("Now waiting re registration message from server");
//        AbstractMessage message2 = result2.get(5, TimeUnit.SECONDS).result;
//
//        // After the RE registration, we can get the RE id message from the register server to get reid.
//        System.out.println("Now waiting agent reid notification from server");
//        AbstractMessage reidResult = result1.reid.get(5, TimeUnit.SECONDS);
//
//        // Here we can see that the reid is same as the expected value.
//        assertEquals(reId, ((PayloadResponse) reidResult.getPayload()).reId);


        dc1.disconnect();
        dc2.disconnect();
        dcServer.disconnect();
    }
}
