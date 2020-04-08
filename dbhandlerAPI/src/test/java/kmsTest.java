import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.chariot.humanapi.impl.HumanPropertyImpl;
import de.gtarc.chariot.messageapi.PayloadProperty;
import de.gtarc.chariot.messageapi.PayloadPropertyAttribute;
import de.gtarc.chariot.messageapi.payload.*;
import de.gtarc.chariot.serviceapi.impl.ServicePropertyImpl;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.OperationImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class kmsTest {

    @Ignore
    @Test
    public void setUriTest() throws URISyntaxException {
        KmsHandlerImpl kms = new KmsHandlerImpl();
        URI uri = new URI("http://chariot-km.dai-lab.de:8080/v1");
        String host = uri.toString();
        kms.setURI(host, "/devices/");
        System.out.print(kms.getURI());
    }

    @Ignore
    @Test
    public void registerEntityTest() throws URISyntaxException {

        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        Property[] properties = new DevicePropertyImpl[2];
        properties[0] =  new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        properties[1] =  new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        kms.registerEntity(payload);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        Property[] properties2 = new ServicePropertyImpl[2];

        properties2[0] = new ServicePropertyImpl(timeStamp2, "status", "number", 3.0, "",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));
        properties2[1] = new ServicePropertyImpl(timeStamp2, "otherstatus", "number", 2.0, "", false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));

        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location,properties2, new OperationImpl[]{});
        kms2.registerEntity(payload2);

        //HUMAN TEST
//        long timeStamp3 = (new Date()).getTime();
//        Location location3 = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
//        KmsHandlerImpl kms3 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/humanmodel/");
//        Property[] properties3 = new HumanPropertyImpl[2];
//        properties3[0] = new HumanPropertyImpl(timeStamp3, "skills", "array", new String[]{"a"}, "", true);
//        properties3[1] = new HumanPropertyImpl(timeStamp3, "tasks", "array", new String[]{"b"}, "", true);
//
//        PayloadEntity payload3 = new PayloadEntity("sensor", "3000e338-3022-454b-8e07-9816ab0a21e6", "6e2b00507493f14664c326b2", "humansensor", "securitKey", "123",
//                "","groupId","", location3, properties3, new Operation[]{});
//        kms3.registerEntity(payload3);
    }

    @Ignore
    @Test
    public void updateEntityTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
//        PayloadEntityUpdate payload = new PayloadEntityUpdate("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "visionsensor", "securitKey", "123",
//                "", "groupId", "GT-arc", location, properties, new Operation[]{});
//        kms.updateEntity(payload.getUuid(), payload);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        Property[] properties2 = new ServicePropertyImpl[2];
        properties2[0] = new ServicePropertyImpl(timeStamp2, "status",  "number", 3.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));;
        properties2[1] = new ServicePropertyImpl(timeStamp2, "otherstatus", "number", 2.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));;
//        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "someothasensor", "securitKey", "123",
//                "", "groupId", "GT-arc", location, properties2, new OperationImpl[]{});
//        kms2.updateEntity(payload2.getUuid(), payload2);
    }

    @Ignore
    @Test
    public void getEntityPropertyKeysTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        ArrayList<String> answer = kms.getEntityPropertyKeys(payload.getUuid());
        System.out.print(answer);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        Property[] properties2 = new ServicePropertyImpl[2];
        properties2[0] = new ServicePropertyImpl(timeStamp2, "status",  "number", 3.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));;
        properties2[1] = new ServicePropertyImpl(timeStamp2, "otherstatus", "number", 2.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc",location, properties2, new OperationImpl[]{});

        ArrayList<String> answer2 = kms2.getEntityPropertyKeys(payload2.getUuid());
        System.out.print(answer2);
    }

    @Ignore
    @Test
    public void updateEntityPropertyTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});

//        PayloadEntityPropertyAdd newprop = new PayloadEntityPropertyAdd(property, "color", "string", "purple", "", true);

//        kms.updateEntityProperty(payload.getUuid(), newprop);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        Property[] properties2 = new ServicePropertyImpl[2];
        properties2[0] = new ServicePropertyImpl(timeStamp2, "status",  "number", 3.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));;
        properties2[1] = new ServicePropertyImpl(timeStamp2, "otherstatus", "number", 2.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties2, new OperationImpl[]{});

        PayloadEntityProperty newprop2 = new PayloadEntityProperty(timeStamp2, "service", "otherstatus", "", "number", 6.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");

//        kms2.updateEntityProperty(payload2.getUuid(), newprop2);
    }

    @Ignore
    @Test
    public void updateEntityAttributeTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});

        PayloadProperty attribute = new PayloadProperty();
        attribute.setKey("name");
        attribute.setValue("raySensor");
        attribute.setObjectType("sensor");

        kms.updateEntityAttribute(payload.getUuid(), attribute);
        /*
        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntity payload2 = new PayloadEntity("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", properties2, new PayloadEntityOperation[]{});

        PayloadProperty attribute2 = new PayloadProperty();
        attribute.setKey("name");
        attribute.setValue("raySensor");

        kms2.updateEntityAttribute(payload2.getUuid(), attribute2);

         */
    }

    @Ignore
    @Test
    public void updatePropertyAttributeTest() throws URISyntaxException {
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntity payload = new PayloadEntity("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});

        PayloadPropertyAttribute attribute = new PayloadPropertyAttribute();
        attribute.setPropertyKey("color");
        attribute.setKey("value");
        attribute.setValue("pink");
        attribute.setObjectType("sensor");

        kms.updatePropertyAttribute(payload.getUuid(), attribute);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        Property[] properties2 = new ServicePropertyImpl[2];
        properties2[0] = new ServicePropertyImpl(timeStamp2, "status",  "number", 3.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));;
        properties2[1] = new ServicePropertyImpl(timeStamp2, "otherstatus", "number", 2.0,"",false, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"));
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("service", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});

        PayloadPropertyAttribute attribute2 = new PayloadPropertyAttribute();
        attribute2.setPropertyKey("status");
        attribute2.setKey("value");
        attribute2.setValue(4.0);
        attribute2.setObjectType("service");

        kms2.updatePropertyAttribute(payload2.getUuid(), attribute2);
    }
    @Ignore
    @Test
    public void updateLocationTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});

        PayloadProperty attribute = new PayloadProperty();
        //attribute.setKey("type");
        //attribute.setValue("someType");
        attribute.setKey("indoorposition");
        Indoorposition indoor = new Indoorposition("1", 9.0, 9.0);
        attribute.setValue(indoor.getJsonString(indoor.getClass()));

        kms.updateLocation(payload.getUuid(), payload.getObjectType(),attribute);
    }
    @Ignore
    @Test
    public void removeEntityPropertyTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        PayloadEntityRemoval payload = new PayloadEntityRemoval("5e2b00507993f14664c326b2", "dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
        PayloadEntityProperty newprop = new PayloadEntityProperty(timeStamp, "sensor", "color", "string", "red", "", true);
        kms.removeEntityProperty(payload.getUuid(), newprop);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityRemoval payload2 = new PayloadEntityRemoval("service","dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
        PayloadEntityProperty newprop2 = new PayloadEntityProperty(timeStamp2, "service", "status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        kms2.removeEntityProperty(payload2.getUuid(), newprop2);
    }

    @Ignore
    @Test
    public void getAllEntitiesTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        kms.getAllEntities();

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2,"service", "status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "service","otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc",location, properties, new Operation[]{});
        kms2.getAllEntities();
    }

    @Ignore
    @Test
    public void getEntityTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        kms.getEntity(payload.getUuid());

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "service","status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "service", "otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        kms2.getEntity(payload2.getUuid());
    }

    @Ignore
    @Test
    public void getKafkaTopicTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        String answer = kms.getKafkaTopic(payload.getUuid());
        System.out.print(answer);
        assertEquals("kms.global.devices.dd78636f-1149-4ddd-903a-629728ae98e4.", answer);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "service","status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "service","otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        String answer2 = kms2.getKafkaTopic(payload2.getUuid());
        System.out.print(answer2);
        assertEquals("kms.global.services.dd78636f-1149-4ddd-903a-629728ae98e4.", answer2);
    }

//    @Test
//    public void getReIdTest() throws URISyntaxException {
//        //DEVICE TEST
//        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
//        long timeStamp = (new Date()).getTime();
//        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
//        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
//        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
//        properties[0] = statusProperty;
//        properties[1] = colorProperty;
//        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
//        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
//                "", "groupId", "GT-arc", location, properties, new Operation[]{});
//        String answer = kms.getReId(payload.getUuid());
//        System.out.print(answer);
//        assertEquals("123", answer);
//
//        //SERVICE TEST
//        long timeStamp2 = (new Date()).getTime();
//        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
//        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
//        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
//        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
//        properties2[0] = propOne;
//        properties2[1] = propTwo;
//        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
//                "321", "groupId", "GT-arc", location, properties, new Operation[]{});
//        String answer2 = kms2.getReId(payload2.getUuid());
//        System.out.print(answer2);
//        assertEquals("321", answer2);
//    }

    @Ignore
    @Test
    public void getAgentIdTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        String answer = kms.getAgentId(payload.getUuid());
        System.out.print(answer);
        //assertEquals("5e2b00507993f14664c326b2", answer);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "service","status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "service","otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntityRegistration payload2 = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        String answer2 = kms2.getAgentId(payload2.getUuid());
        System.out.print(answer2);
    }

    @Ignore
    @Test
    public void isEntityAvailableTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        long timeStamp = (new Date()).getTime();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        boolean answer = kms.isEntityAvailable(payload.getUuid());
        //System.out.print(answer);
        assertEquals(true, answer);

        //SERVICE TEST
        long timeStamp2 = (new Date()).getTime();
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityProperty[] properties2 = new PayloadEntityProperty[2];
        PayloadEntityProperty propOne= new PayloadEntityProperty(timeStamp2, "service","status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
        PayloadEntityProperty propTwo = new PayloadEntityProperty(timeStamp2, "service","otherstatus", "", "number", 2.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op2");
        properties2[0] = propOne;
        properties2[1] = propTwo;
        PayloadEntity payload2 = new PayloadEntity("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", location, properties, new Operation[]{});
        boolean answer2 = kms2.isEntityAvailable(payload2.getUuid());
        assertEquals(true, answer);
    }

    @Ignore
    @Test
    public void removeEntityTest() throws URISyntaxException {
        //DEVICE TEST
        KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
        PayloadEntityRemoval payload = new PayloadEntityRemoval("5e2b00507993f14664c326b2", "dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
        kms.removeEntity(payload.getUuid(), payload);

        //SERVICE TEST
        KmsHandlerImpl kms2 = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/services/");
        PayloadEntityRemoval payload2 = new PayloadEntityRemoval("device","dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
        //DEVICE TEST
        kms2.removeEntity(payload2.getUuid(),payload2);
    }

}
