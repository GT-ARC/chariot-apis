/**
 *
 */
package de.gtarc.chariot.connectionapi;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 */
public interface ConnectionFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    //ConnectionFactory INSTANCE =

    /**
     * Returns a new object of class Server Connection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class Server Connection
     *
     */
    ConnectionException createConnectionException();

    /**
     * Returns a new object of class Server Connection
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class Server Connection
     *
     */
    ServerConnection createServerConnection();

} //ConnectionFactory
