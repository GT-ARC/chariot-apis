package de.gtarc.chariot.connectionapi.impl;


import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.ICoapServerConnection;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.core.network.config.NetworkConfig;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;


/**
 * This class is an example of coap service connection.
 * Serverconnection
 *
 * @author cemakpolat
 */

public class CoapServerService extends AbstractConnectionImpl implements DeviceConnection, ICoapServerConnection {
    private static final int COAP_PORT = NetworkConfig.getStandard().getInt(NetworkConfig.Keys.COAP_PORT);


    private CoapServer server = null;
    private int port = COAP_PORT;

    // example usage
    /**
     * Resource should be added as a CoapResources for instance public class RTemperatureMeasurement extends CoapResource {
     */
//	public static void main(String[] args) throws Exception {
//		CoapServerService server = new CoapServerService();
//		server.addResource(new RTemperatureMeasurement("temp2"));
//		server.addResource(new RTemperatureMeasurement("temp4"));
//		server.connect();
//	}


    public ArrayList<CoapResource> resources = new ArrayList<CoapResource>();

    public CoapServerService() {
    }

    public CoapServerService(int port) {
        this.port = port;
    }

    public void addResource(CoapResource resource) {
        resources.add(resource);
    }

    public void initServer() {
        server = new CoapServer();
        addEndpoints();// add endpoints on all IP addresses
        for (CoapResource resource : resources) {
            server.add(resource);    //add(new RTemperatureMeasurement()); // example
        }
    }

    @Override
    public void connect() {
        try {
            //log.debug("connecting...");
            if (!isConnected()) {
                if (resources.size() == 0) {
                    //log.debug("there is any coap resource!");
                    throw new Exception();
                } else {
                    System.out.println("connecting ...");
                    initServer();
                    server.start();
                    //log.info("Server is started");
                    setStatus(ConnectionStatus.CONNECTED);
                }
            }
        } catch (Exception e) {
            setStatus(ConnectionStatus.FAIL);
            e.printStackTrace();
            //System.out.println("exception:"+e.printStackTrace());
        }

    }

    public void reconnectTo(String url) {
        //log.debug("re-connect to: " + this.url);
        if (isConnected()) disconnect();
        connect();
    }

    /**
     * Add individual endpoints listening on default CoAP port on all IPv4 addresses of all network interfaces.
     */
    private void addEndpoints() {
        for (InetAddress addr : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
            // only binds to IPv4 addresses and localhost
            if (addr instanceof Inet4Address || addr.isLoopbackAddress()) {
                InetSocketAddress bindToAddress = new InetSocketAddress(addr, port);
                server.addEndpoint(new CoapEndpoint(bindToAddress));
            }
        }
    }


    public void disconnect() {
        //log.debug("disconnecting... (isConnected: "+isConnected()+")");
        if (isConnected()) {

            server.stop();
            setStatus(ConnectionStatus.DISCONNECTING);
        } else { // set 'disconnected' in case of previous connection fail.
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        server = null;
    }


    public boolean isConnected() {

        return server != null;
    }

//    @Override
//    public void sendMessage(String message) {
//        if(isConnected()){
//        	try {
//    			// send JSON message to CoAP server
//    			response = client.post(message.toString(), MediaTypeRegistry.TEXT_PLAIN);
//    			System.out.println("Message is posted to CoAP server. That is: " + message.toString());
//    		} catch (Exception e) {
//    			System.out.println("Invalid response " + e.getMessage());
//    			// System.exit(-1);
//    		}
//    		if (response != null) {
//    			System.out.println(response.getResponseText());
//    			System.out.println(" ");
//    			System.out.println(System.lineSeparator() + "ADVANCED" + System.lineSeparator());
//    			// access advanced API with access to more details through
//    			// .advanced()
//    			// System.out.println(Utils.prettyPrint(response));
//    		} else {
//    			System.out.println("No response received.");
//    		}
//        }else{
//            log.warn("Can't send command, not Connected !");
//        }
//    }

	/*
	 * 
	 * A simple coap resource example to show how to integrate a coap resource
	 
	  import java.net.URI;
	import java.util.Objects;
	
	import org.eclipse.californium.core.CoapClient;
	import org.eclipse.californium.core.CoapResource;
	import org.eclipse.californium.core.CoapResponse;
	import org.eclipse.californium.core.coap.MediaTypeRegistry;
	import org.eclipse.californium.core.server.resources.CoapExchange;
	import org.json.JSONObject;
	
	public class RTemperatureMeasurement extends CoapResource {
	
		private double temperature = 0; // latest measurement
		private String deviceId = "8b6b023a";
		private static String name ="tempsensor";
		public RTemperatureMeasurement(String name) {
			super(name);
		}
		public String coapClientUri = "";//"coap://130.149.232.227:5683/coapKura";
		//  Instantiates a new publish resource.
         
		public RTemperatureMeasurement() {
			super(name);
			getAttributes().setTitle("CoAP-Server Publish Center");
		}
		// generated by coap resoirce 
		@Override
		public void handleGET(CoapExchange exchange) {
			// This message should be adapted to your case.
			exchange.respond("Welcome to CoAP-SD Publisher!");
		}
		// generated by  coapresource
		public void handlePOST(CoapExchange exchange) {
			System.out.println(exchange.getRequestText());
			
			JSONObject rawMessage = new JSONObject(exchange.getRequestText());
			String Type = rawMessage.getString("Type");
			if(rawMessage.getString("UUID").toString().equalsIgnoreCase(deviceId)) {
				
			}
			// message type : removal
			if (Objects.equals("Removal", Type)) {
				// pass topic and json to mqtt publisher
				System.out.println("Got a Removal send request");
				coapClientSend(rawMessage);
				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
						+ " is sent to the CoAP client of the SD.");
			}
			// message type : KeepAlive
			else if (Objects.equals("KeepAlive", Type)) {
				// pass topic and json to mqtt publisher
				System.out.println("Got a KeepAlive send request");
				coapClientSend(rawMessage);
				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
						+ " is sent to the CoAP client of the SD.");
			}
			// message type : Deactivation
			else if (Objects.equals("Deactivation", Type)) {
				// pass topic and json to mqtt publisher
				System.out.println("Got a Deactivation send request");
				coapClientSend(rawMessage);
				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
						+ " is sent to the CoAP client of the SD.");
			} else if (Objects.equals("Output", Type)) {
				System.out.println("New Measurement is arrived"+rawMessage.toString());
				Double temperature = Double.parseDouble(rawMessage.get("Output")+"");
				//agentRegistration();
				exchange.respond("Message with topic " + Type + " and payload " + rawMessage.toString()
						+ " is sent to the CoAP client of the Agent.");
			}
		}
			public void coapClientSend(JSONObject sendMessage) {
				URI uri = null; // URI parameter of the request
				try {
	
					uri = new URI(coapClientUri);
				} catch (Exception e) {
					System.err.println("Invalid URI: " + e.getMessage());
					// System.exit(-1);
				}
	
				CoapClient client = null;
				CoapResponse response = null;
	
				try {
					client = new CoapClient(uri);
					// send JSON message to CoAP server
					response = client.post(sendMessage.toString(), MediaTypeRegistry.TEXT_PLAIN);
					System.out.println("Message is posted to CoAP server of the KURA. That is: " + sendMessage.toString());
				} catch (Exception e) {
					System.out.println("Invalid response " + e.getMessage());
					// System.exit(-1);
				}
				if (response != null) {
	
					System.out.println(response.getCode());
					System.out.println(response.getOptions());
					System.out.println(response.getResponseText());
					System.out.println(" ");
					System.out.println(System.lineSeparator() + "ADVANCED" + System.lineSeparator());
					// access advanced API with access to more details through
					// .advanced()
					// System.out.println(Utils.prettyPrint(response));
				} else {
					System.out.println("No response received.");
				}
			}
	}

	 */


}

	
