package de.gtarc.chariot.registrationapi.entity;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.impl.PayloadResponse;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.utils.IoTEntity;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static de.gtarc.chariot.registrationapi.client.util.ClientUtils.createRegistrationMessage;

/***
 * This class is used for Entity Registration, this is an implementation of a Callable and ConnectionListener interfaces.
 * @author cemakpolat
 */
public class RunnerEntityRegistration implements Callable<RegistrationResult>, ConnectionListener {

    //Current device
    private Entity entity;
    
    private Connection conn;
    // Lock object
    private final Object lock = new Object();

    // Result object
    private AbstractMessage result;

    private RegistrationReResponse reResponse = new RegistrationReResponse();
    
   private String reId = null;
   
    private String securityKey;
    private String manufacturer;
    private String objectType;
    private String groupId;
    

    public RunnerEntityRegistration(Connection conn, Entity entity, String reId, String securityKey, String groupId, String manufacturer, String objectType) {

        this.entity = entity;
        this.groupId = groupId;
        this.reId = reId;
        this.securityKey = securityKey;
        this.manufacturer = manufacturer;
        this.objectType = objectType;
        this.groupId = groupId;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }

    public RunnerEntityRegistration(Connection conn, Entity entity, String securityKey, String groupId, String manufacturer, String objectType) {

        this.entity = entity;
        this.groupId = groupId;
        this.reId = IoTEntity.REID_NOTREQUIRED;
        this.securityKey = securityKey;
        this.manufacturer = manufacturer;
        this.objectType = objectType;
        this.groupId = groupId;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }
    


    /**
     * // Sends a registration message and set your connection listener to get the registration response
     * // This synchronized block makes this method to wait until the process is finished.
     *         // And also this procedure is not blocking the main code flow because of this is in a new thread.
     *         // The developer can wait the result with using the Java Future, for more details, please see the test code.
     * @return
     * @throws InterruptedException
     * @throws ConnectionException
     * @throws SocketException
     * @throws UnknownHostException
     */
    @Override
    public RegistrationResult call() throws InterruptedException, ConnectionException, SocketException, UnknownHostException {
        AbstractMessage message = createRegistrationMessage(
                "",
                TopicConfig.getRegisterTopic(),
                TopicConfig.getRegisterResponseTopic(this.entity.getUUIdentifier().toString()),
                "client",
                "server",
                entity,
                entity.getName(),
                reId,
                securityKey,
                groupId,
                manufacturer,
                objectType);
        this.conn.send(message);
        synchronized (lock) {
            if (result == null) {
                lock.wait();
            }
        }
        return new RegistrationResult(result, reResponse);
    }


    @Override
    public void connectionStateChanged(Connection connection, ConnectionStatus connectionStatus) {

    }

    /**
     * This callback method will be called when a message arrived to the response topic
     * This response will be the registration result message.
     * If the response is ReIdUpdate, then we will set the reResponse and unsubscribe from the response topic channel.
     * If this response is a normal agent registration response, then we will set the result and notify the lock.
     * @param iMessage
     * @param connection
     * @throws ConnectionException
     */
    @Override
    public void onMessageReceived(IMessage iMessage, Connection connection) throws ConnectionException {
        result = (AbstractMessage) iMessage;
        if (result.getPayload() instanceof PayloadResponse) {
            //System.out.println("client message result received, message: " + ((PayloadResponse) result.getPayload()).response + " reId:" + ((PayloadResponse) result.getPayload()).reId);
            if (((PayloadResponse) result.getPayload()).response.equals("ReIdUpdate")) {
                //System.out.println("ReIdUpdate message received");
                reResponse.setResponse(result);
            } else {
                synchronized (lock) {
                    if (((PayloadResponse) result.getPayload()).reId != null) {
                        reResponse.setResponse(result);
                    }
                    lock.notify();
                }
            }
        }
    }

    /**
     * This inner class is used for listening ReId notification from the registration server.
     *
     */
    public class RegistrationReResponse implements Future<AbstractMessage> {

        private AbstractMessage response = null;
        private final Object object = new Object();

        public void setResponse(AbstractMessage message) {
            synchronized (object) {
                this.response = message;
                this.object.notify();
            }
        }

        @Override
        public boolean cancel(boolean b) {
            object.notify();
            return true;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return response != null;
        }

        @Override
        public AbstractMessage get() throws InterruptedException {
            synchronized (object) {
                if (response == null) {
                    object.wait();
                }

                return response;
            }
        }

        @Override
        public AbstractMessage get(long l, TimeUnit timeUnit) throws InterruptedException {
            synchronized (object) {
                if (response == null) {
                    timeUnit.timedWait(object, l);
                }
                return response;
            }

        }
    }
}
