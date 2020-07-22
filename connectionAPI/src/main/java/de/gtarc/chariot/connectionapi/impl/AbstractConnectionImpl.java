/**
 *
 */

package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.AbstractConnection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.messageapi.IMessage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractConnectionImpl implements AbstractConnection {

    protected List<ConnectionListener> connectionListeners = new CopyOnWriteArrayList<>();


    protected static final ConnectionStatus STATUS_EDEFAULT = ConnectionStatus.UNDEFINED;

    protected ConnectionStatus status = STATUS_EDEFAULT;

    protected AbstractConnectionImpl() {
        super();
    }


    @Override
    public List<ConnectionListener> getConnectionListeners() {
        return connectionListeners;
    }

    @Override
    public void addConnectionListener(ConnectionListener newConnectionListener) {
        this.connectionListeners.add(newConnectionListener);
    }

    @Override
    public boolean removeConnectionListener(ConnectionListener listener) {
        return this.connectionListeners.remove(listener);
    }

    @Override
    public ConnectionStatus getStatus() {
        return status;
    }


    public void setStatus(ConnectionStatus newStatus) {
        status = newStatus == null ? STATUS_EDEFAULT : newStatus;
    }


    public void connect() throws ConnectionExceptionImpl, ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public void disconnect() throws ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public boolean isConnected() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public void send(IMessage message) throws ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public void notifyListener(IMessage message) throws ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public String getUID() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public void sendMessage(String message) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }



    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (status: ");
        result.append(status);
        result.append(')');
        return result.toString();
    }

} //AbstractConnectionImpl
