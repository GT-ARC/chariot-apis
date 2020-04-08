/**
 */
package com.gtarc.chariot.api.model.domainmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jiac Agent Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A JIAC Agent endpoint enables for accessing SCOs that are encapsulated in JIAC V agents.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentNodeId <em>Agent Node Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentId <em>Agent Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getActionName <em>Action Name</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getJiacAgentEndpoint()
 * @model
 * @generated
 */
public interface JiacAgentEndpoint extends Endpoint {
	/**
	 * Returns the value of the '<em><b>Agent Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Agent Node ID of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Agent Node Id</em>' attribute.
	 * @see #setAgentNodeId(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getJiacAgentEndpoint_AgentNodeId()
	 * @model
	 * @generated
	 */
	String getAgentNodeId();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentNodeId <em>Agent Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Node Id</em>' attribute.
	 * @see #getAgentNodeId()
	 * @generated
	 */
	void setAgentNodeId(String value);

	/**
	 * Returns the value of the '<em><b>Agent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Agent ID of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Agent Id</em>' attribute.
	 * @see #setAgentId(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getJiacAgentEndpoint_AgentId()
	 * @model
	 * @generated
	 */
	String getAgentId();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentId <em>Agent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Id</em>' attribute.
	 * @see #getAgentId()
	 * @generated
	 */
	void setAgentId(String value);

	/**
	 * Returns the value of the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The action name that can be called by another JIAC V agent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action Name</em>' attribute.
	 * @see #setActionName(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getJiacAgentEndpoint_ActionName()
	 * @model
	 * @generated
	 */
	String getActionName();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getActionName <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Name</em>' attribute.
	 * @see #getActionName()
	 * @generated
	 */
	void setActionName(String value);

} // JiacAgentEndpoint
