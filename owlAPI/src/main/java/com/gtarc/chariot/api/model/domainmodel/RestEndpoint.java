/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import java.net.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rest Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A REST endpoint defines only the URI to call.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.RestEndpoint#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getRestEndpoint()
 * @model
 * @generated
 */
public interface RestEndpoint extends Endpoint {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The REST endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(URI)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getRestEndpoint_Uri()
	 * @model dataType="com.gtarc.isco.api.model.isco.URI"
	 * @generated
	 */
	URI getUri();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.RestEndpoint#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(URI value);

} // RestEndpoint
