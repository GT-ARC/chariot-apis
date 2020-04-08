package testing.websocket;


import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import de.gtarc.chariot.connectionapi.impl.AbstractConnectionImpl;
import org.eclipse.jetty.util.component.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

//https://github.com/akshaymhetre/Javax-Jetty-WebsocketExample
//https://github.com/eugenp/tutorials/tree/master/java-websocket
//https://www.javatips.net/api/websocket-message-handlers-example-master/websocket.messagehandler.client/src/main/java/websocket/messagehandler/example/App.java
//https://www.javatips.net/api/websocket-message-handlers-example-master/websocket.messagehandler.web/src/main/java/websocket/messagehandler/example/endpoints/FullEchoEndpoint.java

public class WSClient extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection {
//	public static void main(String[] args) throws Exception {
//		WSClient client = new WSClient();
//		client.setConnectionURI("ws://localhost:8090/events/");
//		client.connect();
//		client.sendMessage("Hello Cem!");
//	}

    private static final Logger log = LoggerFactory.getLogger(WSClient.class);

    private URI uri;
    private Session session;
    WebSocketContainer container = null;


    public WSClient() {
        this.setConnectionURI("ws://localhost:8090/events/");
    }

    public void setConnectionURI(String url) {
        this.uri = URI.create(url); // example
        //this.uri = URI.create(url);
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    private void initConnection() throws IOException {
        if (session == null) {
            try {
                container = ContainerProvider.getWebSocketContainer();
                //attempt to connect
                session = container.connectToServer(EventSocket.class, uri);
            } catch (Throwable t) {
                t.printStackTrace(System.err);
            }
        }
    }

    public void connect() {
        try {
            setStatus(ConnectionStatus.CONNECTING);
            if (!isConnected()) {
                initConnection(); // Setup
                setStatus(ConnectionStatus.CONNECTED); //NOTE: is fired in Events
            }
        } catch (IOException e) {
            setStatus(ConnectionStatus.FAIL); //(fired on 'connection.on(new
            // Function<IOException>() {')
        }
    }

    public boolean isConnected() {
        return session != null;
    }

    public void reconnectTo(String url) {
        log.debug("re-connect to: " + this.uri.toString());

        if (isConnected())
            disconnect();
        this.uri = URI.create(url);
        connect();

    }

    public void disconnect() {
        if (isConnected()) {
            // Send CLOSE request..
            try {
                if (container instanceof LifeCycle) {
                    ((LifeCycle) container).stop();
                }
                setStatus(ConnectionStatus.DISCONNECTING);
            } catch (IOException e) {
                setStatus(ConnectionStatus.FAIL);
                e.printStackTrace();
            } catch (Exception e) {
                setStatus(ConnectionStatus.FAIL);
                e.printStackTrace();
            }

        } else {
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        session = null;
    }


    public void sendMessage(String message) {
        if (isConnected()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                log.debug("Message couldn't be sent!");
                e.printStackTrace();
            }
        } else {
            log.warn("Can't send command, not Connected !");
        }
    }

}
