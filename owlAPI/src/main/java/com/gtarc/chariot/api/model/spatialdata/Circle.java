/**
 */
package com.gtarc.chariot.api.model.spatialdata;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Circle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A cricle with a certain radius.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Circle#getRadius <em>Radius</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getCircle()
 * @model
 * @generated
 */
public interface Circle extends Point {
	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(int)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getCircle_Radius()
	 * @model required="true"
	 * @generated
	 */
	int getRadius();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Circle#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(int value);

} // Circle
