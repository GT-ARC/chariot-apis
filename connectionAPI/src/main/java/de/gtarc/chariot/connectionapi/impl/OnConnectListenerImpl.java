/**
 *
 */
package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.OnConnectListener;
import de.gtarc.chariot.messageapi.IMessage;


public abstract class OnConnectListenerImpl implements OnConnectListener {

    protected OnConnectListenerImpl() {
        super();
    }


    public void connectionStateChanged(DeviceConnection connection, ConnectionStatus status) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    public void onMessageReceived(IMessage message, DeviceConnection connection) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    public void onConnect(DeviceConnection connection) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


} //OnConnectListenerImpl
