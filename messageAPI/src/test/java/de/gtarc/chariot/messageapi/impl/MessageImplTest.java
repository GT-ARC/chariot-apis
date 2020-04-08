package de.gtarc.chariot.messageapi.impl;

import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//import de.gtarc.chariot.deviceapi.payload.PayloadDevice;
//import de.gtarc.chariot.deviceapi.payload.PayloadDeviceProperty;

public class MessageImplTest {

    @Test
    public void fromJsonString() {

        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        String string = message.getJsonObject();
        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
        assertEquals(message.getTimeSent(), newMessage.getTimeSent());
    }

    @Test
    public void fromJsonStringWithPayload() {

        MessageBuilder builder = new MessageBuilder();
        AbstractPayload payload = new PayloadDefaultImpl("Test");
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType(payload.getClass().getName())
                .addPayload(payload)
                .build();
        String string = message.getJsonObject();
        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
        //System.out.println(string);
        assertEquals(message.getPayload().getJsonString(message.getPayload().getClass()),
                newMessage.getPayload().getJsonString(newMessage.getPayload().getClass()));
        assertEquals(((PayloadDefaultImpl) message.getPayload()).payload,
                ((PayloadDefaultImpl) newMessage.getPayload()).payload);
    }

    @Test
    public void getJsonObject() {
        MessageBuilder builder = new MessageBuilder();
        AbstractMessage message = builder.setUrl("url")
                .setTopic("topic")
                .setResponseTopic("responsetopic")
                .setFrom("from")
                .setTo("to")
                .setMessageType("type")
                .build();
        String string = message.getJsonObject();
        assertNotNull(string);

    }
//    @Test
//    public void testDevicePropertyPayload() {
//        MessageBuilder builder = new MessageBuilder();
//        AbstractPayload payload = new PayloadDeviceProperty("timestamp","key","type","value","unit","writable");
//        AbstractMessage message = builder.setUrl("url")
//                .setTopic("topic")
//                .setResponseTopic("responsetopic")
//                .setFrom("from")
//                .setTo("to")
//                .setMessageType(payload.getClass().getName())
//                .addPayload(payload)
//                .build();
//        String string = message.getJsonObject();
//        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
//        assertEquals(message.getPayload().getJsonString(message.getPayload().getClass()),
//                newMessage.getPayload().getJsonString(newMessage.getPayload().getClass()));
//        assertEquals(((PayloadDeviceProperty)message.getPayload()).key,
//                ((PayloadDeviceProperty)newMessage.getPayload()).key);
//
//    }
//    
//    @Test
//    public void testDevicePropertyPayloadWithMoreParams() {
//        MessageBuilder builder = new MessageBuilder();
//        AbstractPayload payload = new PayloadDeviceProperty("timestamp","key","type","value","unit","writable","min","max");
//        AbstractMessage message = builder.setUrl("url")
//                .setTopic("topic")
//                .setResponseTopic("responsetopic")
//                .setFrom("from")
//                .setTo("to")
//                .setMessageType(payload.getClass().getName())
//                .addPayload(payload)
//                .build();
//        String string = message.getJsonObject();
//        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
//        //System.out.println(string);
//        
//        assertEquals(message.getPayload().getJsonString(message.getPayload().getClass()),
//                newMessage.getPayload().getJsonString(newMessage.getPayload().getClass()));
//        assertEquals(((PayloadDeviceProperty)message.getPayload()).min,
//                ((PayloadDeviceProperty)newMessage.getPayload()).min);
//
//
//    }
//    
//    @Test
//    public void testBundleDevicePropertyPayloadWith() {
//        MessageBuilder builder = new MessageBuilder();
//        AbstractPayload payload = new PayloadDeviceProperty("timestamp","key","type","{\"timestamp\":\"0\",\"key\":\"key\",\"type\":\"type\",\"value\":\"value\",\"unit\":\"m2\",\"writable\":\"true\"}","unit","writable") ;
//        AbstractMessage message = builder.setUrl("url")
//                .setTopic("topic")
//                .setResponseTopic("responsetopic")
//                .setFrom("from")
//                .setTo("to")
//                .setMessageType(payload.getClass().getName())
//                .addPayload(payload)
//                .build();
//        String string = message.getJsonObject();
//        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
//        System.out.println(string);
//        
//        assertEquals(message.getPayload().getJsonString(message.getPayload().getClass()),
//                newMessage.getPayload().getJsonString(newMessage.getPayload().getClass()));
//        assertEquals(((PayloadDeviceProperty)message.getPayload()).key,
//                ((PayloadDeviceProperty)newMessage.getPayload()).key);
//
//
//    }
//  
//    @Test
//    public void testDevicePayload() {
//        MessageBuilder builder = new MessageBuilder();
//        PayloadDeviceProperty[] list = new PayloadDeviceProperty[4];
//        list[0] = new PayloadDeviceProperty("timestamp","key","type","value","unit","writable","min","max");
//        list[1] = new PayloadDeviceProperty("timestamp","key","type","value","unit","writable","min","max");
//        list[2] = new PayloadDeviceProperty("timestamp","key","type","value","unit","writable");
//        list[3] = new PayloadDeviceProperty("timestamp","key","Object","{\"timestamp\":\"0\",\"key\":\"key\",\"type\":\"type\",\"value\":\"value\",\"unit\":\"m2\",\"writable\":\"true\"}","","writable") ;
//        
//        AbstractPayload payload = new PayloadDevice("sensor","distance-sensor","distance-sesor","groupId","","","1010101","","cooperation",new Location("id","type","name",1, new Position("lat","lng", "1"), new Indoorposition("12","lat","lng")),list );
//        AbstractMessage message = builder.setUrl("url")
//                .setTopic("topic")
//                .setResponseTopic("responsetopic")
//                .setFrom("from")
//                .setTo("to")
//                .setMessageType(payload.getClass().getName())
//                .addPayload(payload)
//                .build();
//        String string = message.getJsonObject();
//        AbstractMessage newMessage = MessageBuilder.fromJsonString(string);
//        System.out.println("test result:"+string);
//        
//        assertEquals(message.getPayload().getJsonString(message.getPayload().getClass()),
//                newMessage.getPayload().getJsonString(newMessage.getPayload().getClass()));
//        assertEquals(((PayloadDevice)message.getPayload()).id,
//                ((PayloadDevice)newMessage.getPayload()).id);
//
//
//    }

}
