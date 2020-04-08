
import de.gtarc.chariot.dbhandlerapi.impl.*;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.chariot.messageapi.payload.PayloadEntityProperty;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.payload.PayloadEntityRegistration;
import de.gtarc.chariot.messageapi.payload.PayloadEntityRemoval;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.utils.Location;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

//CAVEAT: In order to do the tests, make the entities in dummydbhandler public!

public class dummydbHandlerTest {
    @Test
    public void getEntityTest() {
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(1, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(1, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);
        /*
        assertEquals("{\"objectType\":\"sensor\",\"uuid\":\"dd78636f-1149-4ddd-903a-629728ae98e4\",\"groupId\":\"groupId\",\"id\":\"dd78636f-1149-4ddd-903a-629728ae98e4\",\"name\":\"tempsensor\",\"securitykey\":\"securitKey\",\"reId\":\"123\",\"ip\":\"\",\"manufacturer\":\"GT-arc\",\"location\":{\"level\":0},\"properties\":[{\"timestamp\":1580388070936,\"key\":\"status\",\"type\":\"boolean\",\"value\":false,\"unit\":\"\",\"writable\":false},{\"timestamp\":1580388070936,\"key\":\"color\",\"type\":\"string\",\"value\":\"red\",\"unit\":\"\",\"writable\":false}]}"
, dbhandler.getEntity(payload.getUuid()));
         */
        System.out.print(dbhandler.getEntity(payload.getUuid()));
    }

    @Test
    public void registerEntityTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.registerEntity(payload);
        AbstractPayload answer = dbhandler.entities.get(payload.getUuid());
        System.out.print(answer.getJsonString(answer.getClass()));
    }

    @Test
    public void removeEntityTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;

        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});

        dbhandler.entities.put(payload.getUuid(), payload);
        PayloadEntityRemoval removal_payload = new PayloadEntityRemoval(payload.getObjectType(), payload.getUuid(), "securitKey");
        dbhandler.removeEntity(payload.getUuid(),removal_payload);
        assertEquals(null, dbhandler.entities.get(payload.getUuid()));
    }

    @Test
    public void isEntityAvailableTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);
        boolean answer = dbhandler.isEntityAvailable(payload.getUuid());
        assertEquals(true, answer);
    }

    @Test
    public void updateEntity() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);

        PayloadEntityRegistration newpayload = new PayloadEntityRegistration("NEWsensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
//        dbhandler.updateEntity(newpayload.getUuid(), newpayload);
        AbstractPayload answer = dbhandler.entities.get(payload.getUuid());
        System.out.print(answer.getJsonString(answer.getClass()));
    }

    @Test
    public void getAllEntitiesTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        PayloadEntityRegistration newpayload = new PayloadEntityRegistration("Newsensor", "2ad20f93-64fb-47f1-843a-3cba87486e57", "2ad20f93-64fb-47f1-843a-3cba87486e57", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);
        dbhandler.entities.put(newpayload.getUuid(), newpayload);
        String answer = dbhandler.getAllEntities();
        System.out.print(answer);
    }

    @Test
    public void removeEntityPropertyTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntity payload = new PayloadEntity("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);

        PayloadEntityProperty newprop = new PayloadEntityProperty(timeStamp, "sensor", "color", "string", "red", "", false);

        dbhandler.removeEntityProperty(payload.getUuid(), newprop);
        AbstractPayload answer = dbhandler.entities.get(payload.getUuid());
        System.out.print(answer.getJsonString(answer.getClass()));
    }

    @Test
    public void updateEntityPropertyTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntityRegistration payload = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);

        PayloadEntityProperty newprop = new PayloadEntityProperty(timeStamp, "sensor", "color", "string", "yellow", "", false);

        dbhandler.updateEntityProperty(payload.getUuid(), newprop);
        AbstractPayload answer = dbhandler.entities.get(payload.getUuid());
        System.out.print(answer.getJsonString(answer.getClass()));
    }

    @Test
    public void getEntityPropertyKeysTest() {
        long timeStamp = (new Date()).getTime();
        DummyDbHandlerImpl dbhandler = new DummyDbHandlerImpl();
        DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
        properties[0] = statusProperty;
        properties[1] = colorProperty;
        PayloadEntity payload = new PayloadEntity("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "dd78636f-1149-4ddd-903a-629728ae98e4", "tempsensor", "securitKey", "123",
                "", "groupId", "GT-arc", new Location(), properties, new Operation[]{});
        dbhandler.entities.put(payload.getUuid(), payload);

        ArrayList<String> answer = dbhandler.getEntityPropertyKeys(payload.getUuid());
        System.out.print(answer);
    }
}
