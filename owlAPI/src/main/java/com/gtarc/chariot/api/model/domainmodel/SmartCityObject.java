/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import com.gtarc.quality.qualitymodel.metric.Metric;
import java.util.List;
import java.util.UUID;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smart City Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Smart City Objects are heterogeneous IT-enabled entities, namely physical devices as well as virtual services, that provide a certain functionality.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getLabel <em>Label</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDomains <em>Domains</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getId <em>Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDescription <em>Description</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getAccessibility <em>Accessibility</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getQuality <em>Quality</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getIri <em>Iri</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getClassification <em>Classification</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject()
 * @model abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface SmartCityObject extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The readable name of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' attribute list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.domainmodel.Domain}.
	 * The literals are from the enumeration {@link com.gtarc.chariot.api.model.domainmodel.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of domains of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domains</em>' attribute list.
	 * @see com.gtarc.chariot.api.model.domainmodel.Domain
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Domains()
	 * @model required="true"
	 * @generated
	 */
	List<Domain> getDomains();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>"00000000-0000-0000-0000-000000000000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The unique identifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(UUID)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Id()
	 * @model default="00000000-0000-0000-0000-000000000000" id="true" dataType="com.gtarc.isco.api.model.isco.UUID" required="true"
	 * @generated
	 */
	UUID getId();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(UUID value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A description of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Accessibility</b></em>' attribute.
	 * The literals are from the enumeration {@link com.gtarc.chariot.api.model.domainmodel.Accessibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The accessibility of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Accessibility</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.Accessibility
	 * @see #setAccessibility(Accessibility)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Accessibility()
	 * @model required="true"
	 * @generated
	 */
	Accessibility getAccessibility();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getAccessibility <em>Accessibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessibility</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.Accessibility
	 * @see #getAccessibility()
	 * @generated
	 */
	void setAccessibility(Accessibility value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The condition that must be true to allow the access to this SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Precondition</em>' attribute.
	 * @see #setPrecondition(SWRLRule)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Precondition()
	 * @model dataType="com.gtarc.isco.api.model.isco.SWRLRule"
	 * @generated
	 */
	SWRLRule getPrecondition();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getPrecondition <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' attribute.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(SWRLRule value);

	/**
	 * Returns the value of the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The endpoint to access this entity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endpoint</em>' containment reference.
	 * @see #setEndpoint(Endpoint)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Endpoint()
	 * @model containment="true"
	 * @generated
	 */
	Endpoint getEndpoint();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getEndpoint <em>Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint</em>' containment reference.
	 * @see #getEndpoint()
	 * @generated
	 */
	void setEndpoint(Endpoint value);

	/**
	 * Returns the value of the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The quality measures of this entity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quality</em>' attribute.
	 * @see #setQuality(Metric)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Quality()
	 * @model dataType="com.gtarc.isco.api.model.domainmodel.Metric&lt;?&gt;"
	 * @generated
	 */
	Metric<?> getQuality();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getQuality <em>Quality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' attribute.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(Metric<?> value);

	/**
	 * Returns the value of the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The IRI of the SCO.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Iri</em>' attribute.
	 * @see #setIri(IRI)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Iri()
	 * @model dataType="com.gtarc.isco.api.model.isco.IRI"
	 * @generated
	 */
	IRI getIri();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getIri <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iri</em>' attribute.
	 * @see #getIri()
	 * @generated
	 */
	void setIri(IRI value);

	/**
	 * Returns the value of the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classification</em>' attribute.
	 * @see #setClassification(IRI)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSmartCityObject_Classification()
	 * @model dataType="com.gtarc.isco.api.model.isco.IRI"
	 * @generated
	 */
	IRI getClassification();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getClassification <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classification</em>' attribute.
	 * @see #getClassification()
	 * @generated
	 */
	void setClassification(IRI value);

} // SmartCityObject
