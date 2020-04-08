package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.websocket.server.ServerContainer;
import java.io.IOException;
import java.util.ArrayList;

public class WebSocketServerImpl extends AbstractConnectionImpl implements DeviceConnection {

    public final int DEFAULT_PORT = 8090;
    private int port = DEFAULT_PORT;
    private Server server = null;

    ArrayList<Class<?>> endPoints = new ArrayList<Class<?>>();

    public WebSocketServerImpl() {
    }

    public WebSocketServerImpl(int port) {
        this.port = port;
    }

    public void initConnection() throws IOException {
        try {
            server = new Server();
            ServerConnector connector = new ServerConnector(server);
            connector.setPort(port);
            server.addConnector(connector);
            // Setup the basic application "context" for this application at "/"
            // This is also known as the handler tree (in jetty speak)
            ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            contextHandler.setContextPath("/");
            server.setHandler(contextHandler);
            // Initialize javax.websocket layer
            ServerContainer wsContainer = WebSocketServerContainerInitializer.configureContext(contextHandler);
            if (this.endPoints.size() > 0) {
                for (Class<?> endpoint : endPoints) {
                    wsContainer.addEndpoint(endpoint);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }

    public void addResource(Class<?> component) {
        endPoints.add(component);
    }

    @Override
    public boolean isConnected() {
        return ((server != null) && server.isRunning());
    }

    @Override
    public void connect() {
        try {
            setStatus(ConnectionStatus.CONNECTING);
            if (!isConnected()) {
                initConnection();
                try {
                    server.start();
                    server.dump(System.err);
                    server.join();
                    setStatus(ConnectionStatus.CONNECTED);
                } catch (Exception e) {
                    setStatus(ConnectionStatus.FAIL);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            setStatus(ConnectionStatus.FAIL);
        }
        this.disconnect();
    }

    @Override
    public void disconnect() {
        if (isConnected()) {
            try {
                server.stop();
                setStatus(ConnectionStatus.DISCONNECTING);
            } catch (Exception e) {
                setStatus(ConnectionStatus.FAIL);
                e.printStackTrace();
            }
        } else {
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        server = null;
    }

    public void restart() {
        if (isConnected()) {
            disconnect();
        }
        connect();
    }
}
