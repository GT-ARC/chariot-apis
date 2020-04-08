package de.gtarc.chariot.registrationapi.entity;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.commonapi.Property;

import java.util.concurrent.Callable;

import static de.gtarc.chariot.registrationapi.client.util.ClientUtils.createEntityPropertyAdd;

/**
 * @author cemakpolat, frederic
 */
public class RunnerEntityPropertyAdd implements Callable<ClientResult>, ConnectionListener {
    private final Object lock = new Object();
    private AbstractMessage result = null;

    private Property property;
    private String securityKey;
    private String entityUUID;
    private Connection conn;


    public RunnerEntityPropertyAdd(Connection conn, Property property, String entityUUID, String securityKey) {
        this.property = property;
        this.securityKey = securityKey;
        this.entityUUID = entityUUID;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }

    @Override
    public ClientResult call() throws InterruptedException, ConnectionException {

        AbstractMessage message = createEntityPropertyAdd(
                "",
                TopicConfig.getUpdateTopic(),
                TopicConfig.getUpdateResponseTopic(entityUUID),
                "client",
                "server",
                entityUUID,
                securityKey,
                property);

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

    @Override
    public void onMessageReceived(IMessage iMessage, Connection connection) {
        synchronized (lock) {
            //System.out.println("client message result received");
            result = (AbstractMessage) iMessage;
            lock.notify();
        }
    }
}
