/**
 *
 */
package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

public interface OnConnectListener extends ConnectionListener {

    void connectionStateChanged(DeviceConnection connection, ConnectionStatus status);

    void onMessageReceived(IMessage message, DeviceConnection connection);

    void onConnect(DeviceConnection connection);

} // OnConnectListener
