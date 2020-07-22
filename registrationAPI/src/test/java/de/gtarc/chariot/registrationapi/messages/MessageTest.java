package de.gtarc.chariot.registrationapi.messages;

import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.messageapi.payload.PayloadEntityDeactivation;
import de.gtarc.chariot.messageapi.payload.PayloadEntityKeepAlive;
import de.gtarc.chariot.messageapi.payload.PayloadEntityRemoval;
import de.gtarc.chariot.messageapi.payload.PayloadEntityUpdate;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.impl.OperationImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Unit tests for messages, this tests can be fail if there are some changes in message api.
// But normally, we dont expect to these tests fail.
@Ignore
public class MessageTest {

    @Ignore
    public void createRegistrationMessage() {


        SimplePropertyImpl[] properties = new SimplePropertyImpl[2];
        properties[0] = (SimplePropertyImpl) new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = (SimplePropertyImpl) new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();


        Location location = new Location("id", "type", "name", 1, new Position(1.0, 1.0, "lng"), new Indoorposition("id", 1.0, 1.0));

        PayloadEntity payload = new PayloadEntity("Sensor", "001", "0001", "name",
                "", "", "192.168.1.1", "groupId", "xx",
                location, properties, new Operation[]{new OperationImpl()});


        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
//        assertEquals("{\"objectType\":\"Sensor\",\"uuid\":\"001\",\"id\":\"0001\",\"name\":\"name\",\"securitykey\":\"\",\"reId\":\"\",\"ip\":\"192.168.1.1\",\"manufacturer\":\"xx\",\"location\":{\"identifier\":\"id\",\"type\":\"type\",\"name\":\"name\",\"position\":{\"id\":\"id\",\"lat\":\"lat\",\"lng\":\"lng\"},\"level\":\"1\",\"indoorPosition\":{\"id\":\"id\",\"lat\":\"lat\",\"lng\":\"lng\"}},\"properties\":[{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"float\",\"value\":\"20\",\"unit\":\"Celcius\"},{\"timestamp\":\"\",\"key\":\"humidity\",\"type\":\"float\",\"value\":\"1\",\"unit\":\"Percent\"}],\"groupId\":\"groupId\"}",
//                message.getPayload().getJsonString(message.getPayload().getClass()));
    }

//    @Test // This function won't be required since we register devices one by one. If it will be required, then please adapt the message comparison.
//    public void createReDeviceRegistrationMessage() {
//
//        SimplePropertyImpl[] properties = new SimplePropertyImpl[2];
//        properties[0] = (SimplePropertyImpl) new PropertyBuilder().setKey("temperature").setType("float").setType("float").setValue("20").setUnit("Celcius").build();
//        properties[1] = (SimplePropertyImpl) new PropertyBuilder().setKey("humidity").setType("float").setType("float").setValue("1").setUnit("Percent").build();
//
//        Location location = new Location("id","type","name","1", new Position("lat","lng"), new Position("lat","lng"));
//
//
//        Device[] devices = new Device[1];
//        devices[0] = new DeviceBuilder().setName("temperature-sensor-1")
//                .setFriendlyName("Temperature Sensor")
//                .setType("sensor")
//                .setVendor("xx")
//                .setDeviceStatus(new DeviceStatusImpl(location, null, null))
//                .addMandatoryProperties(properties[0])
//                .addMandatoryProperties(properties[1])
//                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice();
//
//
//        SimplePropertyImpl[] propertiesRe = new SimplePropertyImpl[2];
//        propertiesRe[0] = (SimplePropertyImpl) new PropertyBuilder().setKey("re-prop").setType("float").setValue("value").setUnit("unit").build();
//        propertiesRe[1] = (SimplePropertyImpl) new PropertyBuilder().setKey("re-prop-2").setType("float").setValue("1").setUnit("unit").build();
//
//
//        PayloadReDeviceRegistration payload = new PayloadReDeviceRegistration("001", "", "192.168.1.1", devices, location, propertiesRe);
//
//
//        AbstractMessage message = new MessageBuilder()
//                .setUrl("")
//                .setTopic("register")
//                .setResponseTopic("register_result")
//                .setTo("1")
//                .setFrom("2")
//                .setMessageType(payload.getClass().getName())
//                .addPayload(payload)
//                .build();
//
//
//        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
//        assertEquals("{\"uuid\":\"001\",\"securitykey\":\"a\",\"ip\":\"0.0.0.0 ?\",\"objectType\":\"Device\",\"groupId\":\"b\",\"name\":\"\",\"id\":\"intern id\",\"manufacturer\":\"\",\"reId\":\"\",\"location\":{\"type\":\"aa\",\"name\":\"aa\",\"identifier\":\"aa\",\"position\":{\"lat\":0,\"lng\":1,\"id\":null},\"id\":null,\"indoorposition\":{\"id\":null,\"indoorlat\":1,\"indoorlng\":1},\"level\":1},\"properties\":[{\"timestamp\":\"\",\"key\":\"re-prop\",\"type\":\"float\",\"value\":\"value\",\"unit\":\"unit\"},{\"timestamp\":\"\",\"key\":\"re-prop-2\",\"type\":\"float\",\"value\":\"1\",\"unit\":\"unit\"}],\"devices\":[{\"identifier\":\"temperature-sensor-1\",\"name\":\"Temperature Sensor\",\"type\":\"sensor\",\"manufacturer\":\"xx\",\"location\":{\"identifier\":\"\",\"type\":\"\",\"name\":\"\",\"position\":{\"lat\":\"\",\"lng\":\"\"}},\"properties\":[{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"float\",\"value\":\"20\",\"unit\":\"Celcius\"},{\"timestamp\":\"\",\"key\":\"humidity\",\"type\":\"float\",\"value\":\"1\",\"unit\":\"Percent\"}],\"uuid\":\"c9d6789c-3e81-4109-88d2-11199237db9a\"}]}" ,
//                message.getPayload().getJsonString(message.getPayload().getClass()));
//    }

    @Test
    public void createKeepAliveMessage() {


        SimplePropertyImpl[] properties = new SimplePropertyImpl[2];
        properties[0] = (SimplePropertyImpl) new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = (SimplePropertyImpl) new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();


        PayloadEntityKeepAlive payload = new PayloadEntityKeepAlive("", "2019-02-12 17:31:54", "001","","", 0L, properties);

        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
        assertEquals("{\"reId\":\"\",\"aliveTime\":\"2019-02-12 17:31:54\",\"uuid\":\"001\",\"securitykey\":\"\",\"timestamp\":\"\",\"properties\":[{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"float\",\"value\":\"20\",\"unit\":\"Celcius\"},{\"timestamp\":\"\",\"key\":\"humidity\",\"type\":\"float\",\"value\":\"1\",\"unit\":\"Percent\"}]}",
                message.getPayload().getJsonString(message.getPayload().getClass()));
    }

    @Test
    public void createDeActivationMessage() {
    	PayloadEntityDeactivation payload = new PayloadEntityDeactivation("", "001", "");
        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
        assertEquals("{\"reId\":\"\",\"uuid\":\"001\",\"securitykey\":\"\"}",
                message.getPayload().getJsonString(message.getPayload().getClass()));
    }

    @Test
    public void createDeviceRemovalMessage() {
    	PayloadEntityRemoval payload = new PayloadEntityRemoval("", "001", "");
        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
        assertEquals("{\"reId\":\"\",\"uuid\":\"001\",\"securitykey\":\"\"}",
                message.getPayload().getJsonString(message.getPayload().getClass()));
    }

    @Test
    public void createDeviceUpdateMessage() {
        SimplePropertyImpl[] properties = new SimplePropertyImpl[2];
        properties[0] = (SimplePropertyImpl) new PropertyBuilder().setKey("temperature").setType("float").setValue("20").setUnit("Celcius").build();
        properties[1] = (SimplePropertyImpl) new PropertyBuilder().setKey("humidity").setType("float").setValue("1").setUnit("Percent").build();


        PayloadEntityUpdate payload = new PayloadEntityUpdate("", "001", "", properties, new Operation[]{new OperationImpl()});
        AbstractMessage message = new MessageBuilder()
                .setUrl("")
                .setTopic("register")
                .setResponseTopic("register_result")
                .setTo("1")
                .setFrom("2")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();


        System.out.println(message.getPayload().getJsonString(message.getPayload().getClass()));
        assertEquals("{\"reId\":\"\",\"uuid\":\"001\",\"securitykey\":\"\",\"properties\":[{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"float\",\"value\":\"20\",\"unit\":\"Celcius\"},{\"timestamp\":\"\",\"key\":\"humidity\",\"type\":\"float\",\"value\":\"1\",\"unit\":\"Percent\"}]}",
                message.getPayload().getJsonString(message.getPayload().getClass()));
    }


}
