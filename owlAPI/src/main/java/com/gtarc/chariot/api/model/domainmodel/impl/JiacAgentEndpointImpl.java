/**
 */
package com.gtarc.chariot.api.model.domainmodel.impl;

import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;
import com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jiac Agent Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl#getAgentNodeId <em>Agent Node Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl#getAgentId <em>Agent Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl#getActionName <em>Action Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JiacAgentEndpointImpl extends EndpointImpl implements JiacAgentEndpoint {
	/**
	 * The default value of the '{@link #getAgentNodeId() <em>Agent Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENT_NODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgentNodeId() <em>Agent Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentNodeId()
	 * @generated
	 * @ordered
	 */
	protected String agentNodeId = AGENT_NODE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgentId() <em>Agent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentId()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgentId() <em>Agent Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentId()
	 * @generated
	 * @ordered
	 */
	protected String agentId = AGENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
	protected String actionName = ACTION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JiacAgentEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainmodelPackage.Literals.JIAC_AGENT_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgentNodeId() {
		return agentNodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentNodeId(String newAgentNodeId) {
		String oldAgentNodeId = agentNodeId;
		agentNodeId = newAgentNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_NODE_ID, oldAgentNodeId, agentNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentId(String newAgentId) {
		String oldAgentId = agentId;
		agentId = newAgentId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_ID, oldAgentId, agentId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionName(String newActionName) {
		String oldActionName = actionName;
		actionName = newActionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.JIAC_AGENT_ENDPOINT__ACTION_NAME, oldActionName, actionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_NODE_ID:
				return getAgentNodeId();
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_ID:
				return getAgentId();
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__ACTION_NAME:
				return getActionName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_NODE_ID:
				setAgentNodeId((String)newValue);
				return;
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_ID:
				setAgentId((String)newValue);
				return;
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__ACTION_NAME:
				setActionName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_NODE_ID:
				setAgentNodeId(AGENT_NODE_ID_EDEFAULT);
				return;
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_ID:
				setAgentId(AGENT_ID_EDEFAULT);
				return;
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__ACTION_NAME:
				setActionName(ACTION_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_NODE_ID:
				return AGENT_NODE_ID_EDEFAULT == null ? agentNodeId != null : !AGENT_NODE_ID_EDEFAULT.equals(agentNodeId);
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__AGENT_ID:
				return AGENT_ID_EDEFAULT == null ? agentId != null : !AGENT_ID_EDEFAULT.equals(agentId);
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT__ACTION_NAME:
				return ACTION_NAME_EDEFAULT == null ? actionName != null : !ACTION_NAME_EDEFAULT.equals(actionName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (agentNodeId: ");
		result.append(agentNodeId);
		result.append(", agentId: ");
		result.append(agentId);
		result.append(", actionName: ");
		result.append(actionName);
		result.append(')');
		return result.toString();
	}

} //JiacAgentEndpointImpl
