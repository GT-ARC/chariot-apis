package de.gtarc.chariot.registrationapi.entity;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.TopicConfig;
import de.gtarc.commonapi.Entity;

import java.util.concurrent.Callable;

import static de.gtarc.chariot.registrationapi.client.util.ClientUtils.createRemoval;

/**
 *  This class is used for Device Removal, this is an implementation of a Callable and ConnectionListener interfaces.
 * @author cemakpolat
 */
public class RunnerEntityRemoval implements Callable<ClientResult>, ConnectionListener {
    private final Object lock = new Object();
    private AbstractMessage result = null;

    private Entity entity;
    private String reId;
    private String securityKey;
    private Connection conn;

    public RunnerEntityRemoval(Connection conn, Entity entity, String reId, String securityKey) {
        this.entity = entity;
        this.reId = reId;
        this.securityKey = securityKey;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }

    @Override
    public ClientResult call() throws InterruptedException, ConnectionException {

        AbstractMessage message = createRemoval("", TopicConfig.getRemovalTopic(),
                TopicConfig.getRemovalResponseTopic(this.entity.getUUIdentifier().toString()),
                "client", "server", reId, this.entity.getUUIdentifier().toString(), securityKey, entity);

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
            result = (AbstractMessage) iMessage;
            lock.notify();
        }
    }
}
