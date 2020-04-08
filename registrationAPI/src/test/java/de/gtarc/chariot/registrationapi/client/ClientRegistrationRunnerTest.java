package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientUtils;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityRegistration;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.junit.Ignore;
import org.junit.Test;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientRegistrationRunnerTest {

    String host = "tcp://130.149.232.235:1883";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";
    String clientId = "ClientRegistrationTest";

    String agentUUID = "001";

    @Ignore
    @Test
    // Simple null check test to check Runner
    public void createRunner() throws ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();
        Location location = new Location("", "", "", 1, new Position(0.0, 0.0, null), new Indoorposition(null, 0.0, 0.0));

        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "CreateRunner");
        dc.connect();
        device.setConnectionHandler(dc);

        RunnerEntityRegistration runner = new RunnerEntityRegistration(dc, device, agentUUID, "", "", "xx", "Sensor");
        assertNotNull(runner);
        dc.disconnect();
    }

    @Test
    // Simple unit test for message creation
    public void createMessage() throws ConnectionException, SocketException, UnknownHostException {
        Device device = new DeviceBuilder().buildSensingDevice();

        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        Location location = new Location("", "", "", 1, new Position(0.0, 0.0, null), new Indoorposition(null, 0.0, 0.0));
        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "CreateMessage");
        //dc.connect();
        device.setConnectionHandler(dc);
        RunnerEntityRegistration runner = new RunnerEntityRegistration(dc, device, agentUUID, "", "", "xx", "Sensor");

        AbstractMessage message = ClientUtils.createRegistrationMessage(host, "register",
                "register_result", "register_agent", "sensor", device, agentUUID, null, "", "", "xx", "Sensor");
        
        assertEquals(message.getUrl(), host);
        assertEquals(message.getTopic(), "register");
        assertEquals(message.getResponseTopic(), "register_result");
        assertEquals(message.getTo(), "register_agent");
        assertEquals(message.getFrom(), "sensor");
        dc.disconnect();
    }


    public void sendMessage() throws ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();


        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        Location location = new Location("", "", "", 1, new Position(0.0, 0.0, null), new Indoorposition(null, 0.0, 0.0));

        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "SendMessage");
        //dc.connect();
        device.setConnectionHandler(dc);

        RegistrationClient handler = new RegistrationClient();
        handler.registerEntity(dc,device, agentUUID,"", "", "xx", "Sensor");
        RunnerEntityRegistration runner = new RunnerEntityRegistration(dc, device, agentUUID, "", "", "xx", "Sensor");

        dc.disconnect();
    }

}
