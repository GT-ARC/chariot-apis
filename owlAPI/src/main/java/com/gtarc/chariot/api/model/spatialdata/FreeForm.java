/**
 */
package com.gtarc.chariot.api.model.spatialdata;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Free Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Polygon.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.FreeForm#getLocations <em>Locations</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getFreeForm()
 * @model
 * @generated
 */
public interface FreeForm extends SpatialObject {
	/**
	 * Returns the value of the '<em><b>Locations</b></em>' containment reference list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.spatialdata.Location}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locations</em>' containment reference list.
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage#getFreeForm_Locations()
	 * @model containment="true" lower="3"
	 * @generated
	 */
	List<Location> getLocations();

} // FreeForm
