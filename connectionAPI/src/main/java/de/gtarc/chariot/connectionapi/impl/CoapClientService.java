package de.gtarc.chariot.connectionapi.impl;


import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Example for coap https://www.programcreek.com/java-api-examples/?api=org.eclipse.californium.core.CoapClient
 *
 * @author cemakpolat
 */
public class CoapClientService extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection {

    public static void main(String[] args) throws Exception {
        CoapClientService client = new CoapClientService();
        client.setConnectionURI("coap://127.0.0.1:5683/temp2");
        client.connect();
        //client.sendMessage(); // tested with json data

    }

    public String gatewayCoapURIAddress = "coap://130.149.232.227:5683/coapKura"; // this ip is


    private URI uri = null; // coap client uri, example: "coap://130.149.232.227:5683/coapKura"; // this ip is 
    private String deviceId = "8b6b023a";
    private CoapClient client = null;
    private CoapResponse response = null;

    public CoapClientService() {
    }

    public CoapClientService(String url) {
        setConnectionURI(url);
    }

    public void setConnectionURI(String url) {
        try {
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    @Override
    public void connect() {
        try {
            //log.debug("connecting...");
            System.out.println("connecting ...");
            if (!isConnected()) {
                if (this.uri != null) {
                    client = new CoapClient(uri);
                    setStatus(ConnectionStatus.CONNECTED);
                } else {
                    setStatus(ConnectionStatus.FAIL);
                    //log.debug("coap uri is null!");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            setStatus(ConnectionStatus.FAIL);
            //throw new ConnectionException(e);
        }

    }

    public void reconnectTo(String url) {
        //log.debug("re-connect to: " + this.url);
        if (isConnected()) disconnect();
        try {
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
        connect();

    }

    @Override
    public void disconnect() {
        //log.debug("disconnecting... (isConnected: "+isConnected()+")");

        if (isConnected()) {
            client.shutdown();
            setStatus(ConnectionStatus.DISCONNECTING);
        } else { // set 'disconnected' in case of previous connection fail.
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        client = null;
    }

    @Override
    public boolean isConnected() {
        return client != null;
    }

    @Override
    public void sendMessage(String message) {
        if (isConnected()) {
            try {
                // send JSON message to CoAP server
                response = client.post(message.toString(), MediaTypeRegistry.TEXT_PLAIN);
                System.out.println("Message is posted to CoAP server. That is: " + message.toString());
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
        } else {
            //log.warn("Can't send command, not Connected !");
        }
    }
    public CoapClient getClient(){
        return client;
    }

}
