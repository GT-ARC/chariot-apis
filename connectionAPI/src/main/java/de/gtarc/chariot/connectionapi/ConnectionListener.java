package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Listener</b></em>'.
 * <!-- end-user-doc -->
 */
public interface ConnectionListener {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    void connectionStateChanged(Connection connection, ConnectionStatus status);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    void onMessageReceived(IMessage message, Connection connection) throws ConnectionException;

} // ConnectionListener
