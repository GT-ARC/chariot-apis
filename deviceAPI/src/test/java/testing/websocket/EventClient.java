package testing.websocket;

import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.impl.AbstractConnectionImpl;
import org.eclipse.jetty.util.component.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;


//import de.gtarc.chariot.agentre.ConnectionException;

//https://github.com/akshaymhetre/Javax-Jetty-WebsocketExample
//https://github.com/eugenp/tutorials/tree/master/java-websocket
//Server echo point
//https://www.javatips.net/api/websocket-message-handlers-example-master/websocket.messagehandler.web/src/main/java/websocket/messagehandler/example/ApplicationConfig.java
//https://www.javatips.net/api/websocket-message-handlers-example-master/websocket.messagehandler.web/src/main/java/websocket/messagehandler/example/endpoints/FullEchoEndpoint.java
// Client web socket points
//https://www.javatips.net/api/websocket-message-handlers-example-master/websocket.messagehandler.client/src/main/java/websocket/messagehandler/example/App.java


public class EventClient extends AbstractConnectionImpl {

    private static final Logger log = LoggerFactory.getLogger(EventClient.class);

    private URI uri;
    private Session session;


    public EventClient() {
        this.uri = URI.create("ws://localhost:8090/events/");
    }

    public void setConnectionURI(String uri) {
        this.uri = URI.create("ws://localhost:8090/events/");
        //this.uri = URI.create(uri);
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    private void initConnection() throws IOException {
        if (session == null) {
            try {
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();

                try {
                    // attempt to connect
                    session = container.connectToServer(EventSocket.class, uri);
                    // Send a message
                    session.getBasicRemote().sendText("Hello init connection");
                    // Close session
                    //session.close();

                } finally {

                    if (container instanceof LifeCycle) {
                        ((LifeCycle) container).stop();
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace(System.err);
            }
        }
    }

    public void connect() {
        try {
            if (!isConnected()) {
                initConnection(); // Setup
                setStatus(ConnectionStatus.CONNECTED);
            }
        } catch (IOException e) {
            setStatus(ConnectionStatus.FAIL);
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
                session.close();
                setStatus(ConnectionStatus.DISCONNECTING);
            } catch (IOException e) {
                e.printStackTrace();
            } // will fire event CLOSE on 'wrapped connection'

        } else { // set 'disconnected' in case of previous connection fail.
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        session = null;
    }

    @Override
    public void sendMessage(String message) {
        if (isConnected()) {
            // Send a message
            try {
                session.getAsyncRemote().sendText(message);
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            log.warn("Can't send command, not Connected !");

        }
    }

}
