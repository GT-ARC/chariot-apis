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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link deviceapi.connection.impl.ServerConnectionImpl#getConnectionListener <em>Connection Listener</em>}</li>
 *   <li>{@link deviceapi.connection.impl.ServerConnectionImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 *
 */
public class ServerConnectionImpl implements ServerConnection {
    /**
     * The cached value of the '{@link #getConnectionListener() <em>Connection Listener</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectionListener()
     *
     * @ordered
     */
    protected ConnectionListener connectionListener;

    /**
     * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStatus()
     *
     * @ordered
     */
    protected static final ConnectionStatus STATUS_EDEFAULT = ConnectionStatus.UNDEFINED;

    /**
     * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStatus()
     *
     * @ordered
     */
    protected ConnectionStatus status = STATUS_EDEFAULT;
    private List<ConnectionListener> connectionListeners = new CopyOnWriteArrayList<>();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    protected ServerConnectionImpl() {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public List<ConnectionListener> getConnectionListeners() {
        return connectionListeners;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void addConnectionListener(ConnectionListener newConnectionListener) {
        this.connectionListeners.add(newConnectionListener);
    }

    public boolean removeConnectionListener(ConnectionListener listener) {
        return this.connectionListeners.remove(listener);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public ConnectionStatus getStatus() {
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void setStatus(ConnectionStatus newStatus) {
        status = newStatus == null ? STATUS_EDEFAULT : newStatus;
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void connect() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void disconnect() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public boolean isConnected() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void send(IMessage message) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void notifyListener(IMessage message) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getUID() {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void sendMessage(String message) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (status: ");
        result.append(status);
        result.append(')');
        return result.toString();
    }


} //ServerConnectionImpl
