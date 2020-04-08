/*
package de.gtarc.chariot.registrationapi.data;

import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.impl.DummyDbHandlerImpl;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.impl.DeviceBuilder;
import de.gtarc.chariot.deviceapi.impl.DeviceStatusImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

// Some unit tests for db handler dummy impl is working correctly.
public class DbHandlerTest {

    @Test
    public void isDeviceRegistered() {
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        assertFalse(dummyDbHandler.isDeviceRegistered("0001"));
    }

    @Test
    public void registerDevice() {
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        UUID uuid = UUID.randomUUID();
        Device device = new DeviceBuilder().buildSensingDevice();
        device.setUUIdentifier(uuid);
        dummyDbHandler.registerDevice(uuid.toString(), device, "0003");
        assertTrue(dummyDbHandler.isDeviceRegistered(uuid.toString()));
    }

    @Test
    public void registerAgent() {

        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        Device devices[] = new Device[]{new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("","","",1,new Position(1.0,1.0, null), new Indoorposition(null,1.0,1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice()};


        for (Device device : devices) {
            dummyDbHandler.registerAgent("0003", device);
        }

        assertTrue(dummyDbHandler.isDeviceRegistered(devices[0].getUUIdentifier().toString()));
        assertNull(dummyDbHandler.getDeviceRecord(devices[0].getUUIdentifier().toString()).getValue());
    }

    @Test
    public void registerRE() {
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        Device devices[] = new Device[]{new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("","","",1,new Position(1.0,1.0, null), new Indoorposition(null,1.0,1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice()};


        for (Device device : devices) {
            dummyDbHandler.registerRE("0003", device);
        }
        assertTrue(dummyDbHandler.isDeviceRegistered(devices[0].getUUIdentifier().toString()));
    }

    @Test
    public void getDeviceRecord() {
        UUID uuid = UUID.randomUUID();
        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();
        Device device = new DeviceBuilder().buildSensingDevice();
        device.setUUIdentifier(uuid);
        dummyDbHandler.registerDevice("0001", device, "0003");
        assertEquals("0003", dummyDbHandler.getDeviceRecord(uuid.toString()).getValue());
    }


    @Test
    public void deactivate() {
        Device device = new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("","","",1,new Position(1.0,1.0, null), new Indoorposition(null,1.0,1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice();


        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();

        dummyDbHandler.registerRE("0003", device);
        dummyDbHandler.registerAgent("0004", device);

        assertEquals("0004", dummyDbHandler.getDeviceRecord(device.getUUIdentifier().toString()).getKey());
        dummyDbHandler.deactivateDevice(device.getUUIdentifier().toString());
        assertFalse(dummyDbHandler.isDeviceRegistered(device.getUUIdentifier().toString()));
    }

    @Test
    public void deviceRemoval() {
        Device device = new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("","","",1,new Position(1.0,1.0, null), new Indoorposition(null,1.0,1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice();


        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();

        dummyDbHandler.registerRE("0003", device);
        dummyDbHandler.registerAgent("0004", device);

        assertEquals("0004", dummyDbHandler.getDeviceRecord(device.getUUIdentifier().toString()).getKey());
        dummyDbHandler.deactivateDevice(device.getUUIdentifier().toString());
        assertFalse(dummyDbHandler.isDeviceRegistered(device.getUUIdentifier().toString()));
    }

    @Test
    public void devicel() {
        Device device = new DeviceBuilder().setName("temperature-sensor-1")
                .setFriendlyName("Temperature Sensor")
                .setType("sensor")
                .setVendor("xx")
                .setDeviceLocation(new Location("","","",1,new Position(1.0,1.0, null), new Indoorposition(null,1.0,1.0)))
                .setDeviceStatus(new DeviceStatusImpl(null, null))
                .setUuid(UUID.fromString("c9d6789c-3e81-4109-88d2-11199237db9a")).buildSensingDevice();


        DummyDbHandler dummyDbHandler = new DummyDbHandlerImpl();

        dummyDbHandler.registerRE("0003", device);
        dummyDbHandler.registerAgent("0004", device);

        assertEquals("0004", dummyDbHandler.getDeviceRecord(device.getUUIdentifier().toString()).getKey());
        dummyDbHandler.deactivateDevice(device.getUUIdentifier().toString());
        assertFalse(dummyDbHandler.isDeviceRegistered(device.getUUIdentifier().toString()));
    }
}


 */