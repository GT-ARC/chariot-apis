package testing.test;

import de.gtarc.chariot.deviceapi.ActuatingDevice;
import de.gtarc.chariot.deviceapi.Component;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.DeviceAPIFactory;
import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;
import de.gtarc.commonapi.impl.SimplePropertyImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Test case for testing created ecore model for deviceAPI
 *
 * @author selim
 */

public class TestCase_1 {
    /*String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
       assertEquals(message,messageUtil.printMessage());
    }*/
    @Before
    public void before() {
        System.out.println("Starting test...");
    }

    @After
    public void after() {
        System.out.println("Test ended.");
        System.out.println("");
    }

    /**
     * Test if an actuating device is created as expected.
     */
    @Test
    public void testActuatingDeviceCreation() {
        System.out.println("########################## Actuating Device Creation Test ##########################");

        ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
        actdev.setUUIdentifier(new UUID(0, 4));

        System.out.println("Actuating device created with id: " + actdev.getUUIdentifier());
        System.out.println("Testing if act.dev.1 is an instance of Device");
        assertTrue(actdev instanceof Device);

        ActuatingDevice actdev2 = DeviceAPIFactory.INSTANCE.createActuatingDevice();
        actdev.setUUIdentifier(new UUID(0, 2));
        System.out.println("Actuating device created with id: " + actdev2.getUUIdentifier());
        System.out.println("Testing if act.dev.2 is an instance of Device");

    }


    /**
     * Test if adding properties to a device works as expected.
     */
    @Test
    public void testAddingProperties() {
        System.out.println("########################## Adding Properties Test ##########################");

        ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
        actdev.setUUIdentifier(new UUID(0, 1));
        System.out.println("Actuating device created with id: " + actdev.getUUIdentifier());
        System.out.println("Testing if act.dev.1 is an instance of Device");
        assertTrue(actdev instanceof Device);

        SimpleProperty prop1 = DeviceAPIFactory.INSTANCE.createSimplePropertyImpl();
        prop1.setKey("holder");
        prop1.setValue("holding this");
        System.out.println("SimplePropertyImpl created with label: \"" + prop1.getKey() + "\" and with value: \"" + prop1.getValue() + "\"");
        actdev.getOptionalProperties().add(prop1);
        System.out.println("optional properties of act. device" + actdev.getOptionalProperties());
        System.out.println("Comparing actdev1's optionalproperty with prop1" + actdev.getOptionalProperties().get(0).getKey());
        assertEquals(actdev.getOptionalProperties().get(0).getKey(), "holder");
        assertEquals(((SimplePropertyImpl) (actdev.getOptionalProperties().get(0))).getValue(), "holding this");

    }


    /**
     * Test if a component is created as expected and functional.
     */
    @Test
    public void testComponentCreation() {
        System.out.println("########################## Component Creation Test ##########################");

        Component comp1 = DeviceAPIFactory.INSTANCE.createComponent();
        comp1.setComponentId("component1");
        System.out.println("Component created with componentid: " + comp1.getComponentId());
        System.out.println("Testing if created component is instance of IComponent");
        assertTrue(comp1 instanceof Component);

        ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
        actdev.setUUIdentifier(new UUID(0, 1));
        System.out.println("Actuating device created with id: " + actdev.getUUIdentifier());
//		
        SimpleProperty prop1 = DeviceAPIFactory.INSTANCE.createSimplePropertyImpl();
        prop1.setKey("sproperty1");

        comp1.setProperties(new ArrayList<Property>());
        comp1.getProperties().add(prop1);
        System.out.println("Adding property with label: " + prop1.getKey() + " to component with componentid: " + comp1.getComponentId());
        System.out.println(comp1.getProperties().size());
//		System.out.println("Comparing sproperty1' with component1's device");
        assertEquals(comp1.getProperties().get(0), prop1);

//		comp1.getDevices().add(actdev);
//		System.out.println("Adding device with uid: "+actdev.getUUIdentifier()+" to component with componentid: "+comp1.getComponentId());
//		System.out.println(comp1);
//		System.out.println("Comparing actdev1' with component1's device");
//		assertEquals(comp1.getDevices().get(0),actdev);


    }


    /**
     * Test of complex property structure.
     */
    @Test
    public void testComplexProperty() {
        System.out.println("########################## Complex Property Test ##########################");

        SimpleProperty prop1 = DeviceAPIFactory.INSTANCE.createSimplePropertyImpl();
        prop1.setKey("sproperty1");
        SimpleProperty prop2 = DeviceAPIFactory.INSTANCE.createSimplePropertyImpl();
        prop2.setKey("sproperty2");

        ComplexProperty comp = DeviceAPIFactory.INSTANCE.createComplexPropertyImpl();
        assertTrue(comp instanceof Property);
        comp.getSubProperties().add(prop1);
        comp.getSubProperties().add(prop2);
        System.out.println(comp.getSubProperties());


    }
    /**
     * Test if communication handler works as expected.
     */
    //@Test
//	public void testCommunicationHandler() {
//	    System.out.println("########################## Communication Handler Test ##########################");
//
//		ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
//		actdev.setUUIdentifier(new UUID(0,1));
//		System.out.println("Actuating device created with id: "+actdev.getUUIdentifier());
//		
//		DeviceConnection websocket = new EventClient();
//		actdev.setConnectionHandler(websocket);
////		websocket.connect();
////		websocket.sendMessage("hello cem");
////		websocket.disconnect();
//		
//		WSClient client = new WSClient();
//		actdev.setConnectionHandler(client);
//		client.setConnectionURI("ws://localhost:8090/events/");
//		client.connect();
//		client.sendMessage("Hello Cem!");
//	
//		
//	}

}
