package testing.test;

import org.junit.After;
import org.junit.Before;


/**
 * Test case for testing created ecore model for deviceAPI
 *
 * @author selim
 */

public class TestCase_2 {
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

//	
//	/**
//	 * Test if communication handler works as expected.
//	 */
//	@Test
//	public void websocketCommunicationHandler() {
//	    System.out.println("########################## Web Socket Communication Handler Test ##########################");
//
//		ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
//		actdev.setUUIdentifier(new UUID(0,1));
//		System.out.println("Actuating device created with id: "+actdev.getUUIdentifier());
//		
//		DeviceConnection websocket = new EventClient();
//		actdev.setConnectionHandler(websocket);
//		websocket.connect();
//		websocket.sendMessage("hello cem");
//		
//	}
//	
//	/**
//	 * Test if communication handler works as expected.
//	 */
//	@Test
//	public void mqttCommunicationHandler() {
//	    System.out.println("########################## MQTT Communication Handler Test ##########################");
//
//		ActuatingDevice actdev = DeviceAPIFactory.INSTANCE.createActuatingDevice();
//		actdev.setUUIdentifier(new UUID(0,1));
//		System.out.println("Actuating device created with id: "+actdev.getUUIdentifier());
//		
//		DeviceConnection mqtt = new MqttClientDev();
//		actdev.setConnectionHandler(mqtt);
//		mqtt.disconnect();
//		mqtt.connect();
//		
//		
//		
//	}
}
