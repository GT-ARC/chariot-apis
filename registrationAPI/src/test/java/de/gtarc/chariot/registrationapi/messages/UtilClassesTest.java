package de.gtarc.chariot.registrationapi.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DeviceStatusImpl;
import de.gtarc.chariot.deviceapi.util.DeviceInterfaceAdapter;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@Ignore
public class UtilClassesTest {

    @Test
    public void testProperty() {

        SimplePropertyImpl prop = new SimplePropertyImpl();
        prop.setKey("temperature");

        prop.setUnit("Celcius");
        prop.setValue("20");
        String test = new GsonBuilder()
                .create()
                .toJson(prop);
        System.out.println(test);
        assertEquals("{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"\",\"value\":\"20\",\"unit\":\"Celcius\"}", test);
    }

    @Test
    public void testComplexProperty() {

        SimplePropertyImpl simpleProp = new SimplePropertyImpl();

        simpleProp.setKey("temperature");
        simpleProp.setUnit("Celcius");
        simpleProp.setValue("20");

        Property prop = new PropertyBuilder().addSubProperty(simpleProp).build();

        String test = new GsonBuilder()
                .create()
                .toJson(prop);
        System.out.println(test);
        assertEquals("[{\"timestamp\":\"\",\"key\":\"temperature\",\"type\":\"\",\"value\":\"20\",\"unit\":\"Celcius\"}]", test);
        ComplexPropertyImpl newProp2 = (ComplexPropertyImpl) new GsonBuilder().create().fromJson(test, Property.class);

        assertEquals("temperature", newProp2.getSubProperties().get(0).getKey());
    }

    @Test
    public void testDevice() {
        //ActuatingDevice device = DeviceAPIFactoryImpl.INSTANCE.createActuatingDevice();

        Device device = new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("", "", "", 1, new Position(1.0, 1.0, null), new Indoorposition(null, 1.0, 1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Device.class, new DeviceInterfaceAdapter());
        Gson customGson = gsonBuilder.create();

        String test = customGson.toJson(device, Device.class);
        System.out.println(test);
        assertEquals("{\"identifier\":\"temperature-sensor-1\",\"name\":\"Temperature Sensor\",\"type\":\"sensor\",\"manufacturer\":\"xx\",\"location\":{\"identifier\":\"id\",\"type\":\"type\",\"name\":\"name\",\"position\":{\"lat\":\"lat\",\"lng\":\"lng\"},\"level\":\"1.1\",\"indoorPosition\":{\"lat\":\"lat\",\"lng\":\"lng\"}},\"properties\":[],\"uuid\":\"c9d6789c-3e81-4109-88d2-11199237db9a\"}", test);
    }
}
