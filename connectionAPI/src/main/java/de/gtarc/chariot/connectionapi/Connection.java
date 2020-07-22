/**
 *
 */
package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

import java.util.List;

public interface Connection {

    List<ConnectionListener> getConnectionListeners();

    void addConnectionListener(ConnectionListener value);


    // Removes the connection listener and returns the result that if removal was success or not.
    boolean removeConnectionListener(ConnectionListener listener);


    ConnectionStatus getStatus();


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
