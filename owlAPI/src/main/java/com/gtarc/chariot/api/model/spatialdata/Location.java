/**
 */
package com.gtarc.chariot.api.model.spatialdata;

import com.gtarc.chariot.api.model.domainmodel.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A location is defined by latitude, longitude and altitude.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Location#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Location#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.Location#getAltitude <em>Altitude</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getLocation()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface Location extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(double)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getLocation_Latitude()
	 * @model required="true"
	 * @generated
	 */
	double getLatitude();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Location#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(double)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getLocation_Longitude()
	 * @model required="true"
	 * @generated
	 */
	double getLongitude();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Location#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(double value);

	/**
	 * Returns the value of the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Altitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Altitude</em>' attribute.
	 * @see #setAltitude(double)
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getLocation_Altitude()
	 * @model
	 * @generated
	 */
	double getAltitude();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.spatialdata.Location#getAltitude <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude</em>' attribute.
	 * @see #getAltitude()
	 * @generated
	 */
	void setAltitude(double value);

} // Location
