package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ApiOriginFilter;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.IRestServerConnection;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;

public class WebServerConnection extends AbstractConnectionImpl implements IRestServerConnection {


    // example usage
//	public static void main(String[] args) throws Exception {
//		WebServerConnection server = new WebServerConnection();
//		server.addResource(NetworkOperatorResource.class); // TODO: Network Operator resource example is given below:
//		server.connect();
//	}


    public final int DEFAULT_PORT = 8282;
    private int port = DEFAULT_PORT;
    private Server server = null;
    private ResourceConfig resourceConfig = null;
    ArrayList<Class<?>> registeredResources = new ArrayList<Class<?>>();
    ArrayList<Class<?>> packageResources = new ArrayList<Class<?>>();


    public WebServerConnection(int port) {
        this.port = port;
    }

    public WebServerConnection() {
    }

    private void configure() {

        resourceConfig = new ResourceConfig();
        if (registeredResources.size() > 0) {
            for (Class<?> resource : registeredResources) {
                resourceConfig.register(resource);
            }
        }
        if (packageResources.size() > 0) {
            for (Class<?> resource : registeredResources) {
                resourceConfig.packages(resource.getPackage().getName());
            }
        }

        resourceConfig.register(JacksonFeature.class); // default
        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder sh = new ServletHolder(servletContainer);
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(sh, "/*");

        // filter 
        context.addFilter(ApiOriginFilter.class, "/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        server.setHandler(context);

    }

    //add only the class names as a resource
    public void addResource(Class<?> component) {
        registeredResources.add(component);
        //resourceConfig.register(NetworkOperatorResource.class); // example
    }

    public void addResources(Class<?> component) {
        packageResources.add(component);
        //resourceConfig.packages(NetworkOperatorResource.class.getPackage().getName()); // example
    }

    protected void initServer() {
        this.configure();
    }

    public void updatePort(int port) throws IOException {
        if (server != null) {
            //log.debug("Updating WebServer port. (" + this.port + "->" + port + ")");
            this.port = port;

            boolean connected = isConnected();
            if (connected) {
                try {
                    server.stop();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (connected) connect();
            //log.debug("Port updated , connected = " + isConnected());
        }
    }

    public void connect() {
        //log.debug("Connecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.CONNECTING);

        if (!isConnected()) {
            try {
                initServer();
                server.start();
                server.join();
                setStatus(ConnectionStatus.CONNECTED);
            } catch (Exception e) {
                //log.debug("Connection Exception");
            }
        }
    }

    public void disconnect() {
        //log.debug("Disconnecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.DISCONNECTING);
        if (isConnected()) {
            try {
                server.stop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setStatus(ConnectionStatus.DISCONNECTED);
        }
    }

    public boolean isConnected() {
        return server != null && super.isConnected();
    }

    public void setPort(int port) {
        this.port = port;

    }


/**
 * A simple web resource example to
 * Functions:
 *
 * @author cemakpolat
 *
 */
/*
 * 
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;


	import io.swagger.annotations.Api;
	import io.swagger.annotations.ApiOperation;
	import io.swagger.annotations.ApiParam;
	import io.swagger.annotations.ApiResponse;
	import io.swagger.annotations.ApiResponses;

	@Path("/")
	@Api(tags = { "" })
	@Produces({ "application/json", "application/xml" })
	public class NetworkOperatorResource {

		@GET
		@Path("/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response NetworkOperatorResource() {
			String answer = "network operator test";
			return Response.ok(answer).build();
		}

		@GET
		@Path("/hello/")
		@Produces(MediaType.APPLICATION_JSON)
		public String getHello() {
			return "hello";
		}
	}
*/
}
