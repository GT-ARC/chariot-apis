/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory
 * @model kind="package"
 * @generated
 */
public interface DomainmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domainmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.gt-arc.com/isco/domainmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.gtarc.isco.domainmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainmodelPackage eINSTANCE = com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl <em>Smart City Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getSmartCityObject()
	 * @generated
	 */
	int SMART_CITY_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__DOMAINS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__ID = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Accessibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__ACCESSIBILITY = 4;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__PRECONDITION = 5;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__ENDPOINT = 6;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__QUALITY = 7;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__IRI = 8;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT__CLASSIFICATION = 9;

	/**
	 * The number of structural features of the '<em>Smart City Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Smart City Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_CITY_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__LABEL = SMART_CITY_OBJECT__LABEL;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DOMAINS = SMART_CITY_OBJECT__DOMAINS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ID = SMART_CITY_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DESCRIPTION = SMART_CITY_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accessibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ACCESSIBILITY = SMART_CITY_OBJECT__ACCESSIBILITY;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PRECONDITION = SMART_CITY_OBJECT__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ENDPOINT = SMART_CITY_OBJECT__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__QUALITY = SMART_CITY_OBJECT__QUALITY;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__IRI = SMART_CITY_OBJECT__IRI;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__CLASSIFICATION = SMART_CITY_OBJECT__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__LOCATION = SMART_CITY_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operational Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__OPERATIONAL_AREA = SMART_CITY_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Activation Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ACTIVATION_STATUS = SMART_CITY_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__GROUP = SMART_CITY_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__OWNER = SMART_CITY_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PROPERTIES = SMART_CITY_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__TYPE = SMART_CITY_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = SMART_CITY_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_OPERATION_COUNT = SMART_CITY_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ActuatorImpl <em>Actuator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.ActuatorImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getActuator()
	 * @generated
	 */
	int ACTUATOR = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__LABEL = DEVICE__LABEL;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__DOMAINS = DEVICE__DOMAINS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__ID = DEVICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__DESCRIPTION = DEVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accessibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__ACCESSIBILITY = DEVICE__ACCESSIBILITY;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__PRECONDITION = DEVICE__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__ENDPOINT = DEVICE__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__QUALITY = DEVICE__QUALITY;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__IRI = DEVICE__IRI;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__CLASSIFICATION = DEVICE__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__LOCATION = DEVICE__LOCATION;

	/**
	 * The feature id for the '<em><b>Operational Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__OPERATIONAL_AREA = DEVICE__OPERATIONAL_AREA;

	/**
	 * The feature id for the '<em><b>Activation Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__ACTIVATION_STATUS = DEVICE__ACTIVATION_STATUS;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__GROUP = DEVICE__GROUP;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__OWNER = DEVICE__OWNER;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__PROPERTIES = DEVICE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__TYPE = DEVICE__TYPE;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR__EFFECT = DEVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actuator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_FEATURE_COUNT = DEVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Actuator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_OPERATION_COUNT = DEVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.SensorImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__LABEL = DEVICE__LABEL;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DOMAINS = DEVICE__DOMAINS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ID = DEVICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DESCRIPTION = DEVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accessibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ACCESSIBILITY = DEVICE__ACCESSIBILITY;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__PRECONDITION = DEVICE__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ENDPOINT = DEVICE__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__QUALITY = DEVICE__QUALITY;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__IRI = DEVICE__IRI;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__CLASSIFICATION = DEVICE__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__LOCATION = DEVICE__LOCATION;

	/**
	 * The feature id for the '<em><b>Operational Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__OPERATIONAL_AREA = DEVICE__OPERATIONAL_AREA;

	/**
	 * The feature id for the '<em><b>Activation Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ACTIVATION_STATUS = DEVICE__ACTIVATION_STATUS;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__GROUP = DEVICE__GROUP;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__OWNER = DEVICE__OWNER;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__PROPERTIES = DEVICE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__TYPE = DEVICE__TYPE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__MODE = DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__OUTPUT = DEVICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = DEVICE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_OPERATION_COUNT = DEVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.ServiceImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LABEL = SMART_CITY_OBJECT__LABEL;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DOMAINS = SMART_CITY_OBJECT__DOMAINS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ID = SMART_CITY_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = SMART_CITY_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Accessibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ACCESSIBILITY = SMART_CITY_OBJECT__ACCESSIBILITY;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PRECONDITION = SMART_CITY_OBJECT__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ENDPOINT = SMART_CITY_OBJECT__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__QUALITY = SMART_CITY_OBJECT__QUALITY;

	/**
	 * The feature id for the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__IRI = SMART_CITY_OBJECT__IRI;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CLASSIFICATION = SMART_CITY_OBJECT__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__REGION = SMART_CITY_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__EFFECT = SMART_CITY_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PRIORITY = SMART_CITY_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BUNDLE = SMART_CITY_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INPUTS = SMART_CITY_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__OUTPUTS = SMART_CITY_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = SMART_CITY_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = SMART_CITY_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.ParameterImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.EndpointImpl <em>Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.EndpointImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getEndpoint()
	 * @generated
	 */
	int ENDPOINT = 6;

	/**
	 * The number of structural features of the '<em>Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDPOINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.RestEndpointImpl <em>Rest Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.RestEndpointImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getRestEndpoint()
	 * @generated
	 */
	int REST_ENDPOINT = 7;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ENDPOINT__URI = ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rest Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ENDPOINT_FEATURE_COUNT = ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rest Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_ENDPOINT_OPERATION_COUNT = ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl <em>Jiac Agent Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getJiacAgentEndpoint()
	 * @generated
	 */
	int JIAC_AGENT_ENDPOINT = 8;

	/**
	 * The feature id for the '<em><b>Agent Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JIAC_AGENT_ENDPOINT__AGENT_NODE_ID = ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Agent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JIAC_AGENT_ENDPOINT__AGENT_ID = ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JIAC_AGENT_ENDPOINT__ACTION_NAME = ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Jiac Agent Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JIAC_AGENT_ENDPOINT_FEATURE_COUNT = ENDPOINT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Jiac Agent Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JIAC_AGENT_ENDPOINT_OPERATION_COUNT = ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.Accessibility <em>Accessibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.Accessibility
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getAccessibility()
	 * @generated
	 */
	int ACCESSIBILITY = 9;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.ActivationStatus <em>Activation Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.ActivationStatus
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getActivationStatus()
	 * @generated
	 */
	int ACTIVATION_STATUS = 10;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.Owner <em>Owner</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.Owner
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getOwner()
	 * @generated
	 */
	int OWNER = 11;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.MeasuringMode <em>Measuring Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.MeasuringMode
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getMeasuringMode()
	 * @generated
	 */
	int MEASURING_MODE = 12;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.domainmodel.Domain <em>Domain</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.domainmodel.Domain
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 13;

	/**
	 * The meta object id for the '<em>Metric</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.quality.qualitymodel.metric.Metric
	 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 14;


	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject <em>Smart City Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smart City Object</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject
	 * @generated
	 */
	EClass getSmartCityObject();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getLabel()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Label();

	/**
	 * Returns the meta object for the attribute list '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domains</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDomains()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Domains();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getId()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getDescription()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getAccessibility <em>Accessibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accessibility</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getAccessibility()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Accessibility();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precondition</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getPrecondition()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Precondition();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Endpoint</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getEndpoint()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EReference getSmartCityObject_Endpoint();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getQuality()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Quality();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getIri <em>Iri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iri</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getIri()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Iri();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getClassification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classification</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.SmartCityObject#getClassification()
	 * @see #getSmartCityObject()
	 * @generated
	 */
	EAttribute getSmartCityObject_Classification();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.domainmodel.Device#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getLocation()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Location();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.domainmodel.Device#getOperationalArea <em>Operational Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operational Area</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getOperationalArea()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_OperationalArea();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Device#getActivationStatus <em>Activation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Status</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getActivationStatus()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_ActivationStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Device#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getGroup()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Group();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Device#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getOwner()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gtarc.chariot.api.model.domainmodel.Device#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getProperties()
	 * @see #getDevice()
	 * @generated
	 */
	EReference getDevice_Properties();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Device#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Device#getType()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Type();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Actuator <em>Actuator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actuator</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Actuator
	 * @generated
	 */
	EClass getActuator();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Actuator#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Actuator#getEffect()
	 * @see #getActuator()
	 * @generated
	 */
	EAttribute getActuator_Effect();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Sensor#getMode()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Mode();

	/**
	 * Returns the meta object for the reference '{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Sensor#getOutput()
	 * @see #getSensor()
	 * @generated
	 */
	EReference getSensor_Output();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the reference '{@link com.gtarc.chariot.api.model.domainmodel.Service#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Region</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getRegion()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Region();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Service#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getEffect()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Effect();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Service#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getPriority()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Service#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getBundle()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Bundle();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gtarc.chariot.api.model.domainmodel.Service#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getInputs()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gtarc.chariot.api.model.domainmodel.Service#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Service#getOutputs()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Outputs();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Parameter#getLabel()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Label();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Type();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.Endpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endpoint</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Endpoint
	 * @generated
	 */
	EClass getEndpoint();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.RestEndpoint <em>Rest Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rest Endpoint</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.RestEndpoint
	 * @generated
	 */
	EClass getRestEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.RestEndpoint#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.RestEndpoint#getUri()
	 * @see #getRestEndpoint()
	 * @generated
	 */
	EAttribute getRestEndpoint_Uri();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint <em>Jiac Agent Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jiac Agent Endpoint</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint
	 * @generated
	 */
	EClass getJiacAgentEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentNodeId <em>Agent Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agent Node Id</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentNodeId()
	 * @see #getJiacAgentEndpoint()
	 * @generated
	 */
	EAttribute getJiacAgentEndpoint_AgentNodeId();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentId <em>Agent Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agent Id</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getAgentId()
	 * @see #getJiacAgentEndpoint()
	 * @generated
	 */
	EAttribute getJiacAgentEndpoint_AgentId();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getActionName <em>Action Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Name</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint#getActionName()
	 * @see #getJiacAgentEndpoint()
	 * @generated
	 */
	EAttribute getJiacAgentEndpoint_ActionName();

	/**
	 * Returns the meta object for enum '{@link com.gtarc.chariot.api.model.domainmodel.Accessibility <em>Accessibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Accessibility</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Accessibility
	 * @generated
	 */
	EEnum getAccessibility();

	/**
	 * Returns the meta object for enum '{@link com.gtarc.chariot.api.model.domainmodel.ActivationStatus <em>Activation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activation Status</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.ActivationStatus
	 * @generated
	 */
	EEnum getActivationStatus();

	/**
	 * Returns the meta object for enum '{@link com.gtarc.chariot.api.model.domainmodel.Owner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Owner</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Owner
	 * @generated
	 */
	EEnum getOwner();

	/**
	 * Returns the meta object for enum '{@link com.gtarc.chariot.api.model.domainmodel.MeasuringMode <em>Measuring Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Measuring Mode</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.MeasuringMode
	 * @generated
	 */
	EEnum getMeasuringMode();

	/**
	 * Returns the meta object for enum '{@link com.gtarc.chariot.api.model.domainmodel.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Domain</em>'.
	 * @see com.gtarc.chariot.api.model.domainmodel.Domain
	 * @generated
	 */
	EEnum getDomain();

	/**
	 * Returns the meta object for data type '{@link com.gtarc.quality.qualitymodel.metric.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Metric</em>'.
	 * @see com.gtarc.quality.qualitymodel.metric.Metric
	 * @model instanceClass="com.gtarc.quality.qualitymodel.metric.Metric" typeParameters="T"
	 * @generated
	 */
	EDataType getMetric();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainmodelFactory getDomainmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl <em>Smart City Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getSmartCityObject()
		 * @generated
		 */
		EClass SMART_CITY_OBJECT = eINSTANCE.getSmartCityObject();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__LABEL = eINSTANCE.getSmartCityObject_Label();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__DOMAINS = eINSTANCE.getSmartCityObject_Domains();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__ID = eINSTANCE.getSmartCityObject_Id();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__DESCRIPTION = eINSTANCE.getSmartCityObject_Description();

		/**
		 * The meta object literal for the '<em><b>Accessibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__ACCESSIBILITY = eINSTANCE.getSmartCityObject_Accessibility();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__PRECONDITION = eINSTANCE.getSmartCityObject_Precondition();

		/**
		 * The meta object literal for the '<em><b>Endpoint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMART_CITY_OBJECT__ENDPOINT = eINSTANCE.getSmartCityObject_Endpoint();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__QUALITY = eINSTANCE.getSmartCityObject_Quality();

		/**
		 * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__IRI = eINSTANCE.getSmartCityObject_Iri();

		/**
		 * The meta object literal for the '<em><b>Classification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMART_CITY_OBJECT__CLASSIFICATION = eINSTANCE.getSmartCityObject_Classification();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__LOCATION = eINSTANCE.getDevice_Location();

		/**
		 * The meta object literal for the '<em><b>Operational Area</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__OPERATIONAL_AREA = eINSTANCE.getDevice_OperationalArea();

		/**
		 * The meta object literal for the '<em><b>Activation Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__ACTIVATION_STATUS = eINSTANCE.getDevice_ActivationStatus();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__GROUP = eINSTANCE.getDevice_Group();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__OWNER = eINSTANCE.getDevice_Owner();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE__PROPERTIES = eINSTANCE.getDevice_Properties();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__TYPE = eINSTANCE.getDevice_Type();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ActuatorImpl <em>Actuator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.ActuatorImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getActuator()
		 * @generated
		 */
		EClass ACTUATOR = eINSTANCE.getActuator();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTUATOR__EFFECT = eINSTANCE.getActuator_Effect();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.SensorImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__MODE = eINSTANCE.getSensor_Mode();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENSOR__OUTPUT = eINSTANCE.getSensor_Output();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.ServiceImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__REGION = eINSTANCE.getService_Region();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__EFFECT = eINSTANCE.getService_Effect();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PRIORITY = eINSTANCE.getService_Priority();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__BUNDLE = eINSTANCE.getService_Bundle();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__INPUTS = eINSTANCE.getService_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__OUTPUTS = eINSTANCE.getService_Outputs();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.ParameterImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__LABEL = eINSTANCE.getParameter_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.EndpointImpl <em>Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.EndpointImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getEndpoint()
		 * @generated
		 */
		EClass ENDPOINT = eINSTANCE.getEndpoint();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.RestEndpointImpl <em>Rest Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.RestEndpointImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getRestEndpoint()
		 * @generated
		 */
		EClass REST_ENDPOINT = eINSTANCE.getRestEndpoint();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_ENDPOINT__URI = eINSTANCE.getRestEndpoint_Uri();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl <em>Jiac Agent Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.JiacAgentEndpointImpl
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getJiacAgentEndpoint()
		 * @generated
		 */
		EClass JIAC_AGENT_ENDPOINT = eINSTANCE.getJiacAgentEndpoint();

		/**
		 * The meta object literal for the '<em><b>Agent Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JIAC_AGENT_ENDPOINT__AGENT_NODE_ID = eINSTANCE.getJiacAgentEndpoint_AgentNodeId();

		/**
		 * The meta object literal for the '<em><b>Agent Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JIAC_AGENT_ENDPOINT__AGENT_ID = eINSTANCE.getJiacAgentEndpoint_AgentId();

		/**
		 * The meta object literal for the '<em><b>Action Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JIAC_AGENT_ENDPOINT__ACTION_NAME = eINSTANCE.getJiacAgentEndpoint_ActionName();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.Accessibility <em>Accessibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.Accessibility
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getAccessibility()
		 * @generated
		 */
		EEnum ACCESSIBILITY = eINSTANCE.getAccessibility();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.ActivationStatus <em>Activation Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.ActivationStatus
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getActivationStatus()
		 * @generated
		 */
		EEnum ACTIVATION_STATUS = eINSTANCE.getActivationStatus();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.Owner <em>Owner</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.Owner
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getOwner()
		 * @generated
		 */
		EEnum OWNER = eINSTANCE.getOwner();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.MeasuringMode <em>Measuring Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.MeasuringMode
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getMeasuringMode()
		 * @generated
		 */
		EEnum MEASURING_MODE = eINSTANCE.getMeasuringMode();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.domainmodel.Domain <em>Domain</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.domainmodel.Domain
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getDomain()
		 * @generated
		 */
		EEnum DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em>Metric</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.quality.qualitymodel.metric.Metric
		 * @see com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl#getMetric()
		 * @generated
		 */
		EDataType METRIC = eINSTANCE.getMetric();

	}

} //DomainmodelPackage
