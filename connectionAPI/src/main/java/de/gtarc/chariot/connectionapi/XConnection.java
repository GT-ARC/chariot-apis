/**
 *
 */
package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

public interface XConnection extends Connection {

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
    ConnectionListener getConnectionListener();


    void setConnectionListener(ConnectionListener value);

    ConnectionStatus getStatus();


    void setStatus(ConnectionStatus value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void connect();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void disconnect();

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
    void send(IMessage message);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void notifyListener(IMessage message);

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
} // XConnection
