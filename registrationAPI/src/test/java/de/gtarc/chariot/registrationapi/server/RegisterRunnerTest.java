package de.gtarc.chariot.registrationapi.server;

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
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterRunnerTest {

    @Test
    public void createResponse() {

        Property[] properties = new SimplePropertyImpl[2];
        properties[0] = new PropertyBuilder().setKey("temperature").setValue("20").setUnit("Celcius").build();
        properties[1] = new PropertyBuilder().setKey("humidity").setValue("1").setUnit("Percent").build();


        Location location = new Location("id", "type", "name", 1, new Position(1.0, 1.0, "lng"), new Indoorposition(null, 1.0, 1.0));

        PayloadEntity payload = new PayloadEntity("sensor", "001", "0001", "device-name",
                "", "", "192.168.1.1", "", "xx",
                location, properties, new Operation[]{new OperationImpl()});

        AbstractMessage message = new MessageBuilder()
                .setUrl("m24.cloudmqtt.com:10933")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        RegisterRunner runner = new RegisterRunner(message, null, null);

        AbstractMessage response = runner.createResponse(true);

        assertEquals(message.getFrom(), response.getTo());
        assertEquals(message.getTo(), response.getFrom());
        assertEquals(message.getUrl(), response.getUrl());
        assertEquals(message.getResponseTopic(), response.getTopic());
    }
}
