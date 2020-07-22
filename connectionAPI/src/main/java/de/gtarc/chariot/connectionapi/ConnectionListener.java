package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;


public interface ConnectionListener {

    void connectionStateChanged(Connection connection, ConnectionStatus status);

    void onMessageReceived(IMessage message, Connection connection) throws ConnectionException;

} // ConnectionListener
