/**
 *
 */
package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

import java.util.List;

public interface Connection {

    /**
     * Returns the value of the '<em><b>Connection Listener</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Listener</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Listener</em>' containment reference.
     * @see #setConnectionListener(ConnectionListener)
     *
     */
    List<ConnectionListener> getConnectionListeners();

    /**
     * Sets the value of the '{@link chariot.device.model.connection.api.connection.DeviceConnection#getConnectionListener <em>Connection Listener</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Listener</em>' containment reference.
     * @see #getConnectionListener()
     *
     */
    void addConnectionListener(ConnectionListener value);


    // Removes the connection listener and returns the result that if removal was success or not.
    boolean removeConnectionListener(ConnectionListener listener);

    /**
     * Returns the value of the '<em><b>Status</b></em>' attribute.
     * The default value is <code>"UNDEFINED"</code>.
     * The literals are from the enumeration {@link deviceapi.connection.ConnectionStatus}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Status</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Status</em>' attribute.
     * @see deviceapi.connection.ConnectionStatus
     * @see #setStatus(ConnectionStatus)
     *
     */
    ConnectionStatus getStatus();

    /**
     * Sets the value of the '{@link chariot.device.model.connection.api.connection.DeviceConnection#getStatus <em>Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Status</em>' attribute.
     * @see deviceapi.connection.ConnectionStatus
     * @see #getStatus()
     *
     */
    void setStatus(ConnectionStatus value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void connect() throws ConnectionException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void disconnect() throws ConnectionException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    boolean isConnected();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */

    void send(IMessage message) throws ConnectionException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void notifyListener(IMessage message) throws ConnectionException;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    String getUID();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void sendMessage(String message);
} // DeviceConnection
