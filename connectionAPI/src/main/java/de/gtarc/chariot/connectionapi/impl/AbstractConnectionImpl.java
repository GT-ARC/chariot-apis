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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link deviceapi.connection.impl.AbstractConnectionImpl#getConnectionListener <em>Connection Listener</em>}</li>
 *   <li>{@link deviceapi.connection.impl.AbstractConnectionImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 *
 */
public abstract class AbstractConnectionImpl implements AbstractConnection {
    /**
     * The cached value of the '{@link #getConnectionListener() <em>Connection Listener</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectionListener()
     *
     * @ordered
     */
    protected List<ConnectionListener> connectionListeners = new CopyOnWriteArrayList<>();

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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    protected AbstractConnectionImpl() {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
    public List<ConnectionListener> getConnectionListeners() {
        return connectionListeners;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
    public void addConnectionListener(ConnectionListener newConnectionListener) {
        this.connectionListeners.add(newConnectionListener);
    }

    @Override
    public boolean removeConnectionListener(ConnectionListener listener) {
        return this.connectionListeners.remove(listener);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
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
    public void connect() throws ConnectionExceptionImpl, ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void disconnect() throws ConnectionException {
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
    public void send(IMessage message) throws ConnectionException {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void notifyListener(IMessage message) throws ConnectionException {
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

} //AbstractConnectionImpl
