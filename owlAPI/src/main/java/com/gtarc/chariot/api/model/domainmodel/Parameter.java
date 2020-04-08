/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import org.semanticweb.owlapi.model.IRI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A parameter has a label and a type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getLabel <em>Label</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getParameter()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface Parameter extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The readable name of the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getParameter_Label()
	 * @model default=""
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the parameter; points to a taxonomy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(IRI)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getParameter_Type()
	 * @model dataType="com.gtarc.isco.api.model.isco.IRI"
	 * @generated
	 */
	IRI getType();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(IRI value);

} // Parameter
