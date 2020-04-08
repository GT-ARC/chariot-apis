/**
 *
 */
package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionFactory;
import de.gtarc.chariot.connectionapi.ServerConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 */
public class ConnectionFactoryImpl implements ConnectionFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public static final ConnectionFactoryImpl ConnectionFactoryImpl = init();
    //public static final ConnectionFactoryImpl ConnectionFactoryImpl = null;
    public static ConnectionFactoryImpl theConnectionFactory = null;

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */

    public static ConnectionFactoryImpl init() {
        if (theConnectionFactory == null) {
            theConnectionFactory = new ConnectionFactoryImpl();
            return theConnectionFactory;
        }
        return theConnectionFactory;
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public ConnectionFactoryImpl() {
        super();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public ConnectionException createConnectionException() {
        ConnectionExceptionImpl connectionException = new ConnectionExceptionImpl(new Exception());
        return connectionException;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public ServerConnection createServerConnection() {
        ServerConnectionImpl serverConnection = new ServerConnectionImpl();
        return serverConnection;
    }


} //ConnectionFactoryImpl
