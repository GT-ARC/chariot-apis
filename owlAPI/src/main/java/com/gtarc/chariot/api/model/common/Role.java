/**
 */
package com.gtarc.chariot.api.model.common;

import com.gtarc.chariot.api.model.domainmodel.SerializableEObject;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.common.Role#getRights <em>Rights</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.common.CommonPackage#getRole()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Role extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Rights</b></em>' reference list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.common.Right}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rights</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rights</em>' reference list.
	 * @see com.gtarc.chariot.api.model.common.CommonPackage#getRole_Rights()
	 * @model
	 * @generated
	 */
	List<Right> getRights();

} // Role
