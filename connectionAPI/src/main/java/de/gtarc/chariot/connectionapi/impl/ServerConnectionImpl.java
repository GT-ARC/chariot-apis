/**
 *
 */
package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.ServerConnection;
import de.gtarc.chariot.messageapi.IMessage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerConnectionImpl implements ServerConnection {

    protected ConnectionListener connectionListener;


    protected static final ConnectionStatus STATUS_EDEFAULT = ConnectionStatus.UNDEFINED;


    protected ConnectionStatus status = STATUS_EDEFAULT;
    private List<ConnectionListener> connectionListeners = new CopyOnWriteArrayList<>();


    protected ServerConnectionImpl() {
        super();
    }



    public List<ConnectionListener> getConnectionListeners() {
        return connectionListeners;
    }


    public void addConnectionListener(ConnectionListener newConnectionListener) {
        this.connectionListeners.add(newConnectionListener);
    }

    public boolean removeConnectionListener(ConnectionListener listener) {
        return this.connectionListeners.remove(listener);
    }


    public ConnectionStatus getStatus() {
        return status;
    }


    public void setStatus(ConnectionStatus newStatus) {
        status = newStatus == null ? STATUS_EDEFAULT : newStatus;
    }


    public void connect() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    public void disconnect() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    public boolean isConnected() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    public void send(IMessage message) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    public void notifyListener(IMessage message) {
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


} //ServerConnectionImpl
