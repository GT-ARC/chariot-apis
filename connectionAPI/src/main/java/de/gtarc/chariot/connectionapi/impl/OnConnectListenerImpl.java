/**
 *
 */
package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.OnConnectListener;
import de.gtarc.chariot.messageapi.IMessage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>On Connect Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 */
public abstract class OnConnectListenerImpl implements OnConnectListener {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    protected OnConnectListenerImpl() {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void connectionStateChanged(DeviceConnection connection, ConnectionStatus status) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void onMessageReceived(IMessage message, DeviceConnection connection) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void onConnect(DeviceConnection connection) {
        // TODO: implement this method
        // Ensure that you remove  or mark it  NOT
        throw new UnsupportedOperationException();
    }


} //OnConnectListenerImpl
