/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import com.gtarc.chariot.api.model.properties.Property;

import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import java.util.List;
import org.semanticweb.owlapi.model.IRI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A physical device that offers a functionality.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getLocation <em>Location</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getOperationalArea <em>Operational Area</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getActivationStatus <em>Activation Status</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getGroup <em>Group</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Device#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice()
 * @model abstract="true"
 * @generated
 */
public interface Device extends SmartCityObject {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The physical location of the device.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Location)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_Location()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Location getLocation();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Location value);

	/**
	 * Returns the value of the '<em><b>Operational Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Area</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operational are in which this device is doing something.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operational Area</em>' containment reference.
	 * @see #setOperationalArea(SpatialObject)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_OperationalArea()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SpatialObject getOperationalArea();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getOperationalArea <em>Operational Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operational Area</em>' containment reference.
	 * @see #getOperationalArea()
	 * @generated
	 */
	void setOperationalArea(SpatialObject value);

	/**
	 * Returns the value of the '<em><b>Activation Status</b></em>' attribute.
	 * The literals are from the enumeration {@link com.gtarc.chariot.api.model.domainmodel.ActivationStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activation Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The current activation status of the device.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Activation Status</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.ActivationStatus
	 * @see #setActivationStatus(ActivationStatus)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_ActivationStatus()
	 * @model
	 * @generated
	 */
	ActivationStatus getActivationStatus();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getActivationStatus <em>Activation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Status</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.ActivationStatus
	 * @see #getActivationStatus()
	 * @generated
	 */
	void setActivationStatus(ActivationStatus value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An identifier for the group this entity belongs to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * The literals are from the enumeration {@link com.gtarc.chariot.api.model.domainmodel.Owner}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The owner of this device (person/company).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.Owner
	 * @see #setOwner(Owner)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_Owner()
	 * @model required="true"
	 * @generated
	 */
	Owner getOwner();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.Owner
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Owner value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.properties.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Further generic attributes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_Properties()
	 * @model containment="true"
	 * @generated
	 */
	List<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of this entity; points to a taxonomy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(IRI)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDevice_Type()
	 * @model dataType="com.gtarc.isco.api.model.isco.IRI"
	 * @generated
	 */
	IRI getType();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Device#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(IRI value);

} // Device
