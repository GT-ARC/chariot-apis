package de.gtarc.chariot.registrationapi.entity;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.commonapi.Entity;

import java.util.concurrent.Callable;

import static de.gtarc.chariot.registrationapi.client.util.ClientUtils.createKeepAliveMessage;

// This class is used for Keep Alive, this is an implementation of a Callable and ConnectionListener interfaces.
public class RunnerEntityKeepAlive implements Callable<ClientResult>, ConnectionListener {
    private final Object lock = new Object();
    private AbstractMessage result = null;

    private Entity entity;
    private String reId;
    private String aliveTime;

    private String securityKey;
    private long timestamp;
    private Connection conn;

    public RunnerEntityKeepAlive(Connection conn, Entity entity, String reId, String aliveTime, String securityKey, long timestamp) {
        this.entity = entity;
        this.reId = reId;
        this.aliveTime = aliveTime;
        this.securityKey = securityKey;
        this.timestamp = timestamp;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }


    /**
     * Send a registration message and set your connection listener to get the registration response
     *
     This synchronized block makes this method to wait until the process is finished.
     And also this procedure is not blocking the main code flow because of this is in a new thread.
     The developer can wait the result with using the Java Future, for more details, please see the test code.
     * @return
     * @throws InterruptedException
     * @throws ConnectionException
     */
    @Override
    public ClientResult call() throws InterruptedException, ConnectionException {

        AbstractMessage message = createKeepAliveMessage("", TopicConfig.getKeepAliveTopic(),
                TopicConfig.getKeepAliveResponseTopic(this.entity.getUUIdentifier().toString()),
                "client", "server",reId, aliveTime, securityKey, timestamp, entity);

        this.conn.send(message);

        synchronized (lock) {
            if (result == null) {
                lock.wait();
            }
        }

        return new ClientResult(result);
    }


    @Override
    public void connectionStateChanged(Connection connection, ConnectionStatus connectionStatus) {

    }



    /**
     * // This callback method will be called when a message arrived to the response topic
     *     // This response will be the registration result message.
     * @param iMessage
     * @param connection
     */
    @Override
    public void onMessageReceived(IMessage iMessage, Connection connection) {
        synchronized (lock) {
            //System.out.println("client message result received");
            result = (AbstractMessage) iMessage;
            lock.notify();
        }


    }


}
