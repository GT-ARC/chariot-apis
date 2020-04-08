/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import org.semanticweb.owlapi.model.SWRLRule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actuator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An actuator is a device that alters the world state.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Actuator#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getActuator()
 * @model
 * @generated
 */
public interface Actuator extends Device {
	/**
	 * Returns the value of the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effect of the triggered actuator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effect</em>' attribute.
	 * @see #setEffect(SWRLRule)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getActuator_Effect()
	 * @model dataType="com.gtarc.isco.api.model.isco.SWRLRule"
	 * @generated
	 */
	SWRLRule getEffect();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Actuator#getEffect <em>Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' attribute.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(SWRLRule value);

} // Actuator
