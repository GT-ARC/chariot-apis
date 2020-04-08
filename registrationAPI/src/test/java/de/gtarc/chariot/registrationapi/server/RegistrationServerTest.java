package de.gtarc.chariot.registrationapi.server;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.OperationImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Ignore
public class RegistrationServerTest {


    String host = "tcp://130.149.232.235:1083";
    String username = "plbwvpgf";
    String password = "mJTPb6z12Bag";


    @Test
    public void createConnection() throws ConnectionException {
        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "RegistrationServerTest_createConnection");
        dc.connect();
        ((MqttConnectionImpl) dc).subscribeTopic("register");
        assertTrue(dc.isConnected());
        dc.disconnect();
    }

    @Test
    public void createHandler() throws ConnectionException {
        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "RegistrationServerTest_createHandler");
        dc.connect();
        ((MqttConnectionImpl) dc).subscribeTopic("register");
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        KmsHandler kmsHandler = new KmsHandlerImpl();
        RegistrationServer registrationServer = new RegistrationServer(dc, kmsHandler);

        assertFalse(registrationServer.executorService.isTerminated());
        dc.disconnect();
    }


    @Test
    // This method tests the registration server by sending a device registration message
    public void sendRegisterMessage() throws ConnectionException {
        Property[] properties = new SimplePropertyImpl[2];
        properties[0] = new PropertyBuilder().setKey("temperature").setValue("20").setUnit("Celcius").build();
        properties[1] = new PropertyBuilder().setKey("humidity").setValue("1").setUnit("Percent").build();

        Location location = new Location("id", "type", "name", 1, new Position(1.0, 1.0, "lng"), new Indoorposition(null, 1.0, 1.0));

        UUID uuid = UUID.randomUUID();

        PayloadEntity payload = new PayloadEntity("Sensor", "001", uuid.toString(), "device-name",
                "", "", "", "192.168.1.1", "xx", location, properties, new Operation[]{new OperationImpl()});


        System.out.println("payload class: " + payload.getClass().getName());
        AbstractMessage message = new MessageBuilder()
                .setUrl(host)
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();

        DeviceConnection dcSender = new MqttConnectionImpl(host, username, password, "RegistrationServerTest_sendRegisterMessage_1");
        dcSender.connect();

        DeviceConnection dc = new MqttConnectionImpl(host, username, password, "RegistrationServerTest_sendRegisterMessage_2");
        dc.connect();
        ((MqttConnectionImpl) dc).subscribeTopic("register");

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();

        RegistrationServer mockRegistrationServer = mock(RegistrationServer.class);


        doCallRealMethod().when(mockRegistrationServer).setExecutorService(any());
        doCallRealMethod().when(mockRegistrationServer).setConn(any());
        doCallRealMethod().when(mockRegistrationServer).onMessageReceived(any(), any());
        doCallRealMethod().when(mockRegistrationServer).setDbHandler(any());

        mockRegistrationServer.setExecutorService(Executors.newFixedThreadPool(10));
        mockRegistrationServer.setConn(dc);
        mockRegistrationServer.setDbHandler(dummyDbHandler);

        dcSender.send(message);

        verify(mockRegistrationServer, timeout(1000)).onMessageReceived(any(), any());
        //compare agent ids
        assertEquals("001", dummyDbHandler.getEntity(uuid.toString()));
        dc.disconnect();
        dcSender.disconnect();


    }

}
