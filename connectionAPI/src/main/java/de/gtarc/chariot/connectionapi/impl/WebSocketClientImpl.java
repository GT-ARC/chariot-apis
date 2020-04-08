package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import org.eclipse.jetty.util.component.LifeCycle;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

public class WebSocketClientImpl extends AbstractConnectionImpl implements DeviceConnection {

    Class<?> WSClientSocketClass;

    private URI uri;
    private Session session;
    WebSocketContainer container;

    public WebSocketClientImpl(Class<?> WSClientSocketClass) {
        this.WSClientSocketClass = WSClientSocketClass;
    }

    public void setConnectionURI(String url) {
        this.uri = URI.create(url);
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    private void initConnection() throws IOException {
        if (session == null) {
            try {
                container = ContainerProvider.getWebSocketContainer();
                session = container.connectToServer(WSClientSocketClass, uri);

            } catch (Throwable t) {
                t.printStackTrace(System.err);
            }
        }
    }

    @Override
    public boolean isConnected() {
        return session != null;
    }

    @Override
    public void connect() throws ConnectionException {
        try {
            setStatus(ConnectionStatus.CONNECTING);
            if (!isConnected()) {
                initConnection();
                setStatus(ConnectionStatus.CONNECTED);
            }
        } catch (IOException e) {
            setStatus(ConnectionStatus.FAIL);
        }
    }

    @Override
    public void disconnect() throws ConnectionException {
        if (isConnected()) {
            try {
                if (container instanceof LifeCycle) {
                    ((LifeCycle) container).stop();
                }
                setStatus(ConnectionStatus.DISCONNECTING);
            } catch (Exception e) {
                setStatus(ConnectionStatus.FAIL);
                e.printStackTrace();
            }
        } else {
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        session = null;
    }

    public void reconnectTo(String url) throws ConnectionException {
        if (isConnected()) {
            disconnect();
        }
        setConnectionURI(url);
        connect();
    }

    public void sendMessage(String message) {
        if (isConnected()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Session getClientSession(){
        return session;
    }

}
