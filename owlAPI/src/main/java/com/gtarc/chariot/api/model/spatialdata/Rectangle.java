/**
 */
package com.gtarc.chariot.api.model.spatialdata;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A rectangle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX1 <em>X1</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX2 <em>X2</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getRectangle()
 * @model
 * @generated
 */
public interface Rectangle extends SpatialObject {
	/**
	 * Returns the value of the '<em><b>X1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X1</em>' containment reference.
	 * @see #setX1(Location)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getRectangle_X1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Location getX1();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX1 <em>X1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X1</em>' containment reference.
	 * @see #getX1()
	 * @generated
	 */
	void setX1(Location value);

	/**
	 * Returns the value of the '<em><b>X2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X2</em>' containment reference.
	 * @see #setX2(Location)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getRectangle_X2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Location getX2();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX2 <em>X2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X2</em>' containment reference.
	 * @see #getX2()
	 * @generated
	 */
	void setX2(Location value);

} // Rectangle
