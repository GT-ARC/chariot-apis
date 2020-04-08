/**
 *
 */
package de.gtarc.chariot.serviceapi;

import de.gtarc.commonapi.Description;

/**
 *
 * @author cemakpolat
 *
 */
public interface ServiceDescription extends Description {
    /**
     * Returns the value of the '<em><b>Service Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Type</em>' attribute.
     * @see #setServiceType(String)
     * @generated
     */
    String getServiceType();

    /**
     * Sets the value of the '{@link deviceapi.serviceapi.ServiceDescription#getServiceType <em>Service Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Type</em>' attribute.
     * @see #getServiceType()
     * @generated
     */
    void setServiceType(String value);

    /**
     * Returns the value of the '<em><b>Service Provider</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Provider</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Provider</em>' attribute.
     * @see #setServiceProvider(String)
     * @generated
     */
    String getServiceProvider();

    /**
     * Sets the value of the '{@link deviceapi.serviceapi.ServiceDescription#getServiceProvider <em>Service Provider</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Provider</em>' attribute.
     * @see #getServiceProvider()
     * @generated
     */
    void setServiceProvider(String value);

} // ServiceDescription
