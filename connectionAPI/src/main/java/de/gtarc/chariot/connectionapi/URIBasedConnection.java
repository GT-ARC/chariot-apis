/**
 *
 */
package de.gtarc.chariot.connectionapi;

public interface URIBasedConnection {
    /**
     * Returns the value of the '<em><b>Connection URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection URI</em>' attribute.
     * @see #setConnectionURI(String)
     *
     */
    String getConnectionURI();

    /**
     * Sets the value of the '{@link deviceapi.connection.URIBasedConnection#getConnectionURI <em>Connection URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection URI</em>' attribute.
     * @see #getConnectionURI()
     *
     */
    void setConnectionURI(String value);

} // URIBasedConnection
