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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@Ignore
public class ScalabilityTest {
    String host = "tcp://130.149.232.235:1083";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";

    String reId = "00001";


    @Test
    // Creates multiple clients and make them to send requests to check if the registration server could handle.
    public void createMultipleClients() throws ConnectionException, ExecutionException, InterruptedException {

        List<String> uuidList = new ArrayList<>();
        List<String> agentUUID = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            uuidList.add(UUID.randomUUID().toString());
            agentUUID.add("00" + i);
        }
        List<Device> deviceList = createDevices(uuidList);
        List<RegistrationClient> clients = createClients(deviceList.size());
        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));

        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "MultipleClientServerTest");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();
        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        List<Future<RegistrationResult>> results = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            results.add(clients.get(i).registerEntity(dcServer,deviceList.get(i), "",agentUUID.get(i),
                    "", "xx", "Sensor"));
        }

        assertTrue(((PayloadResponse) results.get(results.size() - 1).get().result.getPayload()).response.equals("Success"));

        for (String uuid : uuidList) {
            assertTrue(dummyDbHandler.isEntityAvailable(uuid));
        }

        closeClients(clients);
        closeDevices(deviceList);
        registrationServer.close();
    }


    @Test
    // Creates multiple clients and make them to send requests to check if the registration server could handle.
    // But in this time, a RE will register itself and within this test, we expect this registered devices will notified correctly.
    public void createMultipleClientsAndReNotify() throws ConnectionException, ExecutionException, InterruptedException, TimeoutException {

        List<String> uuidList = new ArrayList<>();
        List<String> agentUUID = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            uuidList.add(UUID.randomUUID().toString());
            agentUUID.add("00" + i);
        }
        List<Device> deviceList = createDevices(uuidList);
        List<RegistrationClient> clients = createClients(deviceList.size());
        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));
        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "MultipleClientServerTest");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();
        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);

        List<Future<RegistrationResult>> results = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            results.add(clients.get(i).registerEntity(dcServer,deviceList.get(i), "",agentUUID.get(i),
                    "", "xx", "Sensor"));
        }

        results.get(results.size() - 1).get(5, TimeUnit.SECONDS);
        for (String uuid : uuidList) {
            assertTrue(dummyDbHandler.isEntityAvailable(uuid));
        }

        Device devices[] = new Device[uuidList.size()];
        for (int i = 0; i < uuidList.size(); i++) {
            devices[i] = new DeviceBuilder().setName("temperature-sensor-" + i)
                    .setFriendlyName("Temperature Sensor: " + i)
                    .setType("sensor")
                    .setVendor("xx")
                    .setDeviceLocation(new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0)))
                    .setDeviceStatus(new DeviceStatusImpl(null, null))
                    .setUuid(UUID.fromString(uuidList.get(i))).buildSensingDevice();
        }


//        Future<ClientResult> result = clients.get(0).registerRe(deviceList.get(0), reId, devices, "");
//        System.out.println("Now waiting re registration message from server");
//        assertNotNull(result.get(10, TimeUnit.SECONDS).result);

        //System.out.println("Now waiting agent reid notification from server");

        //AbstractMessage reidResult = results.get(results.size() - 1).get().reid.get(5, TimeUnit.SECONDS);

        // Here we can see that the reid is same as the expected value.
        //assertEquals(reId, ((PayloadResponse) reidResult.getPayload()).reId);


        closeClients(clients);
        closeDevices(deviceList);
        registrationServer.close();

    }

    public List<Device> createDevices(List<String> uuidList) throws ConnectionException {
        List<Device> devices = new ArrayList<>();
        for (String uuid : uuidList) {
            Device tmpDevice = new DeviceBuilder().buildSensingDevice();
            tmpDevice.setUUIdentifier(UUID.fromString(uuid));
            DeviceConnection dc = new MqttConnectionImpl(host, username, password, uuid);
            dc.connect();
            tmpDevice.setConnectionHandler(dc);
            devices.add(tmpDevice);
        }
        return devices;
    }

    public List<RegistrationClient> createClients(int count) {
        List<RegistrationClient> clients = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            clients.add(new RegistrationClient());
        }
        return clients;

    }

    public void closeClients(List<RegistrationClient> clients) throws ConnectionException {
        for (RegistrationClient client : clients) {
            client.close();
        }
    }

    public void closeDevices(List<Device> devices) throws ConnectionException {
        for (Device device : devices) {
            device.getConnectionHandler().disconnect();
        }
    }

    public void a() throws ConnectionException, InterruptedException, ExecutionException, TimeoutException {
        DeviceConnection dcServer = new MqttConnectionImpl(host, username, password, "SeparatedRegisterServer");
        dcServer.connect();
        ((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();

        RegistrationServer registrationServer = new RegistrationServer(dcServer, kmsHandler);


        dcServer.disconnect();
    }

}
