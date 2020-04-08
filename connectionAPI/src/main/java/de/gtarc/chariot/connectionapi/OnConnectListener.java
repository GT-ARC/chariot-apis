/**
 *
 */
package de.gtarc.chariot.connectionapi;

import de.gtarc.chariot.messageapi.IMessage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On Connect Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 *
 */
public interface OnConnectListener extends ConnectionListener {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void connectionStateChanged(DeviceConnection connection, ConnectionStatus status);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void onMessageReceived(IMessage message, DeviceConnection connection);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    void onConnect(DeviceConnection connection);

} // OnConnectListener
