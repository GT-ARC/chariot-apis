package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.registrationapi.client.util.ClientUtils;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RunnerDeviceRegistrationTest {

    String host = "tcp://130.149.232.235:1083";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";

    String agentUUID = "001";

    @Ignore
    @Test
    // Creates an agent registration message check if its correctly created.
    public void createRegistrationMessage() throws UnknownHostException, SocketException, ConnectionException {
        Device device = new DeviceBuilder().buildSensingDevice();
        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "RunnerAgentRegisterTest");
        device.setConnectionHandler(dc);

        Location location = new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0));

        Property[] properties = new SimplePropertyImpl[2];
        properties[0] = new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();

        device.addProperty(properties[0]);
        device.addProperty(properties[1]);

        device.setDeviceLocation(location);

        device.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));
        AbstractMessage message = ClientUtils.createRegistrationMessage("", "register",
                "register_result", "client", "server", device, agentUUID,
                null, "", "", "xx", "Sensor");


        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            System.out.println();
            assertEquals(socket.getLocalAddress().getHostAddress(), ((PayloadEntity) message.getPayload()).getIp());
        }

        assertEquals(properties[0], ((PayloadEntity) message.getPayload()).getProperties()[0]);
        assertEquals(properties[1], ((PayloadEntity) message.getPayload()).getProperties()[1]);

    }

}
