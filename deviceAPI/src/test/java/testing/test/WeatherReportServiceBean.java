//package testing.test;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.net.InetSocketAddress;
//import java.util.UUID;
//
//
//
//
//import java.net.BindException;
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.net.URI;
//import java.util.Objects;
//
//import org.eclipse.californium.core.CoapClient;
//import org.eclipse.californium.core.CoapResource;
//import org.eclipse.californium.core.CoapResponse;
//import org.eclipse.californium.core.CoapServer;
//import org.eclipse.californium.core.coap.MediaTypeRegistry;
//import org.eclipse.californium.core.network.CoapEndpoint;
//import org.eclipse.californium.core.network.EndpointManager;
//import org.eclipse.californium.core.network.config.NetworkConfig;
//import org.eclipse.californium.core.server.resources.CoapExchange;
//import org.json.JSONObject;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class WeatherReportServiceBean {
//	
//	private final Logger logger = LoggerFactory.getLogger(WeatherReportServiceBean.class);
//	private static final int COAP_PORT = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);
//	public static final String ACTION_GET_WEATHER_REPORT = "com.gtarc.isco.iscoServices.WeatherReportServiceBean#getWeatherReport";
//	
//	private double temperature = 0; // latest measurement
//	private String deviceId = "8b6b023a";
//	private int coapPortNumber = 10001;
//
//	public String gatewayCoapURIAddress = "coap://130.149.232.227:5683/coapKura"; // this ip is 
//	private String coapServerAgentIP  ="10.0.6.54";
//		
//	
//	public void doStart() throws Exception {
//	
//		logger.info("WeatherReportServiceBean is ready.");
//		startCoapServer(coapPortNumber);
//		agentRegistration(); // register agent to a gateway
//	}
//
//	
//	public final void doStop() throws Exception {
//		this.agentDeregistration();
//	}
//	
//	public void agentRegistration() {
//		JSONObject message = new JSONObject();
//		message.put("Type", "Agent-Registration");
//		message.put("IP", this.coapServerAgentIP);
//		message.put("Port", this.coapPortNumber +"");
//		message.put("DeviceId", this.deviceId);
//		coapClientSend(message);
//	}
//	public void agentDeregistration() {
//		JSONObject message = new JSONObject();
//		message.put("Type", "Agent-Deregistration");
//		message.put("IP", this.coapServerAgentIP);
//		message.put("Port", this.coapPortNumber+"");
//		message.put("DeviceId", this.deviceId);
//		coapClientSend(message);
//	}
//	
//	public void startCoapServer(int portNumber) {
//		try {
//			// create server
//			CoapSDServer server = new CoapSDServer();
//			// add endpoints on all IP addresses
//			server.addEndpoints(portNumber);
//			server.start();
//			
//			logger.info("Server is started");
//		} catch (SocketException e) {
//			System.err.println("Failed to initialize server: " + e.getMessage());
//		}
//	}
//	
//
//	class CoapSDServer extends CoapServer {
//		public CoapSDServer() throws SocketException {
//			add(new RTemperatureMeasurement());
//		}
//		// add all communication network interfaces, this function lists all available network interfaces that might be accessed by the CoAP clients
//		private void addEndpoints(int portNumber) {
//			for (InetAddress addr : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
//				System.out.println(addr.toString());
//				// only binds to IPv4 addresses and localhost
//				if (addr instanceof Inet4Address || addr.isLoopbackAddress()) {
//					InetSocketAddress bindToAddress = new InetSocketAddress(addr, portNumber);	
//					addEndpoint(new CoapEndpoint(bindToAddress));
//
//				}
//			}
//		}
//	}
//	
//	public void coapClientSend(JSONObject sendMessage) {
//		String coapClientUri = gatewayCoapURIAddress;
//		URI uri = null; // URI parameter of the request
//		try {
//
//			uri = new URI(coapClientUri);
//		} catch (Exception e) {
//			System.err.println("Invalid URI: " + e.getMessage());
//			// System.exit(-1);
//		}
//
//		CoapClient client = null;
//		CoapResponse response = null;
//
//		try {
//			client = new CoapClient(uri);
//			
//			// send JSON message to CoAP server
//			response = client.post(sendMessage.toString(), MediaTypeRegistry.TEXT_PLAIN);
//			System.out.println("Message is posted to CoAP server of the KURA. That is: " + sendMessage.toString());
//		} catch (Exception e) {
//			System.out.println("Invalid response " + e.getMessage());
//			// System.exit(-1);
//		}
//		if (response != null) {
//
//			System.out.println(response.getCode());
//			System.out.println(response.getOptions());
//			System.out.println(response.getResponseText());
//			System.out.println(" ");
//			System.out.println(System.lineSeparator() + "ADVANCED" + System.lineSeparator());
//			// access advanced API with access to more details through
//			// .advanced()
//			// System.out.println(Utils.prettyPrint(response));
//		} else {
//			System.out.println("No response received.");
//		}
//	}
//
//	/**
//	 * Incoming Message:
//	 * 
//	 * 
//
//		{
//		  "CanMeasure": "Temperature",
//		  "Status": "Active",
//		  "DeviceIP": "172.24.1.138",
//		  "lowpanIP": "fe80::fc70:8ffb:81af:5796%lowpan0",
//		  "Unit": "Celcius",
//		  "ConnectedDevice": "fe80::ba27:ebff:fe65:6064%wlan0",
//		  "Type": "Output",
//		  "Output": "28.25",
//		  "Model": "DS18B20",
//		  "ID": "0004",
//		  "UUID": "hello",
//		  "DeploymentDate": "2018-08-08 14:53:41",
//		  "Location": {
//		    "Latitude": "52.5155",
//		    "Longitude": "13.4062"
//		  }
//		}
//	 * @author cemakpolat
//	 *
//	 */
//	class RTemperatureMeasurement extends CoapResource {
//		
//		public String coapClientUri = gatewayCoapURIAddress;//"coap://130.149.232.227:5683/coapKura";
//		
//		public RTemperatureMeasurement() {
//			super("coapSD");
//			getAttributes().setTitle("CoAP-Server Publish Center");
//		}
//
//		@Override
//		public void handleGET(CoapExchange exchange) {
//			exchange.respond("Welcome to CoAP-SD Publisher!");
//		}
//
//		public void handlePOST(CoapExchange exchange) {
//			JSONObject rawMessage = new JSONObject(exchange.getRequestText());
//			String Type = rawMessage.getString("Type");
//			if(rawMessage.getString("UUID").toString().equalsIgnoreCase(deviceId)) {
//				
//			}
//			// message type : removal
//			if (Objects.equals("Removal", Type)) {
//				// pass topic and json to mqtt publisher
//				System.out.println("Got a Removal send request");
//				coapClientSend(rawMessage);
//				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
//						+ " is sent to the CoAP client of the SD.");
//			}
//			// message type : KeepAlive
//			else if (Objects.equals("KeepAlive", Type)) {
//				// pass topic and json to mqtt publisher
//				System.out.println("Got a KeepAlive send request");
//				coapClientSend(rawMessage);
//				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
//						+ " is sent to the CoAP client of the SD.");
//			}
//			// message type : Deactivation
//			else if (Objects.equals("Deactivation", Type)) {
//				// pass topic and json to mqtt publisher
//				System.out.println("Got a Deactivation send request");
//				coapClientSend(rawMessage);
//				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
//						+ " is sent to the CoAP client of the SD.");
//			} else if (Objects.equals("Output", Type)) {
//				System.out.println("New Measurement is arrived"+rawMessage.toString());
//				temperature = Double.parseDouble(rawMessage.get("Output")+"");
//				//agentRegistration();
//				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
//						+ " is sent to the CoAP client of the Agent.");
//			}
//		}
//		
//		public void coapClientSend(JSONObject sendMessage) {
//			URI uri = null; // URI parameter of the request
//			try {
//
//				uri = new URI(coapClientUri);
//			} catch (Exception e) {
//				System.err.println("Invalid URI: " + e.getMessage());
//				// System.exit(-1);
//			}
//
//			CoapClient client = null;
//			CoapResponse response = null;
//
//			try {
//				client = new CoapClient(uri);
//				// send JSON message to CoAP server
//				response = client.post(sendMessage.toString(), MediaTypeRegistry.TEXT_PLAIN);
//				System.out.println("Message is posted to CoAP server of the KURA. That is: " + sendMessage.toString());
//			} catch (Exception e) {
//				System.out.println("Invalid response " + e.getMessage());
//				// System.exit(-1);
//			}
//			if (response != null) {
//
//				System.out.println(response.getCode());
//				System.out.println(response.getOptions());
//				System.out.println(response.getResponseText());
//				System.out.println(" ");
//				System.out.println(System.lineSeparator() + "ADVANCED" + System.lineSeparator());
//				// access advanced API with access to more details through
//				// .advanced()
//				// System.out.println(Utils.prettyPrint(response));
//			} else {
//				System.out.println("No response received.");
//			}
//		}
//
//	}
//
//}
