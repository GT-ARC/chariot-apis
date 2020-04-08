/*
package de.gtarc.chariot.registrationapi.data;

import de.gtarc.chariot.connectionapi.impl.WebClientConnection;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.KmsHandlerImpl;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.chariot.deviceapi.impl.DevicePropertyImpl;
import de.gtarc.chariot.deviceapi.payload.PayloadDevice;
import de.gtarc.chariot.deviceapi.payload.PayloadDeviceProperty;
import de.gtarc.commonapi.impl.OperationImpl;
import de.gtarc.commonapi.utils.Indoorposition;
import de.gtarc.commonapi.utils.Location;
import de.gtarc.commonapi.utils.Position;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

public class KmsHandlerTest {

    @Test
    public void removeDeviceTest() throws URISyntaxException {
        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/devices/");
        kmshandler.removeEntity("b1f114f5-f47f-449d-b579-6605bba061c8");
    }

    @Test
    public void postDeviceRegistrationDataTest() throws URISyntaxException {
        long timeStamp = 9;
        Location location = new Location("k_id","k_type", "k_name",111, new Position(1.0,1.0, "1"), new Indoorposition("1",1.0,1.0));
        Property[] properties = new Property[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", "on/off", "", true);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "String", "red", "", false);

        properties[0] = statusProperty;
        properties[1] = colorProperty;

        PayloadDevice payload = new PayloadDevice("sensor","b1f114f5-f47f-449d-b579-6605bba061c8",
                "b1f114f5-f47f-449d-b579-6605bba061c8","NameofTheDevice",
                "someOthername","123","10.0.6.75","c","Kerem Gmbh",
                location, properties, new Operation[] {new OperationImpl()});
        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/");
        kmshandler.setKmsPath("/devices/");
        WebClientConnection client = kmshandler.connectionToKms();
        //System.out.print(client.getConnectionURI() + kmshandler.getKmsPath());
        //System.out.print(kmshandler.getKmsUri());
        System.out.print(kmshandler.getKmsPath());
        //kmshandler.postDeviceRegistrationData(payload);
    }

    @Test
    public void getDeviceTest() throws URISyntaxException {
        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/devices/");
        kmshandler.getEntity("b1f114f5-f47f-449d-b579-6605bba061c8");
    }

    @Test
    public void postDeviceUpdateDataTest() throws URISyntaxException {
        long timeStamp = 9;
        Location location = new Location("k_id","k_type", "k_name",111, new Position(1.0,1.0, "1"), new Indoorposition("1",1.0,1.0));
        Property[] properties = new Property[2];
        DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", "on/off", "", true);
        DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "String", "red", "", false);

        properties[0] = statusProperty;
        properties[1] = colorProperty;

        PayloadDevice payload = new PayloadDevice("sensor","b1f114f5-f47f-449d-b579-6605bba061c8",
                "b1f114f5-f47f-449d-b579-6605bba061c8","NameofTheDevice",
                "someOthername","123","10.0.6.75","c","Kerem Gmbh",
                location, properties, new Operation[] {new OperationImpl()});
        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/devices/");
        kmshandler.postDeviceUpdateData("b1f114f5-f47f-449d-b579-6605bba061c8", payload);
    }


    @Test
    public void postDevicePropertyUpdateDataTest() throws URISyntaxException {
        long timeStamp = 9L;

        PayloadDeviceProperty payload = new PayloadDeviceProperty(new Date().getTime(),"status","boolean","true","", true);

        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/devices/");
        kmshandler.postDevicePropertyUpdateData("b1f114f5-f47f-449d-b579-6605bba061c8", payload);
    }

    @Test
    public void getPropertyKeys() throws URISyntaxException {

        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/devices/");
        ArrayList<String> properties = new ArrayList<String>();
        properties = kmshandler.getPropertyKeys("b1f114f5-f47f-449d-b579-6605bba061c8");

        //System.out.print(properties);
    }

    @Test
    public void someTest() throws URISyntaxException {
        KmsHandler kmshandler = new KmsHandlerImpl();
        kmshandler.setKmsUri("http://chariot-km.dai-lab.de:8080/v1/");
        URI myuri = kmshandler.getKmsUri();
        System.out.print(myuri.toString().substring(0, myuri.toString().length()-myuri.getPath().toString().length()));
        System.out.print("\n" + myuri.getPath());
    }

    @Test
    public void sendPropertyAdd() {

    }

}

 */
