/**
 */
package com.gtarc.chariot.api.model.domainmodel.impl;

import com.gtarc.chariot.api.model.common.CommonPackage;
import com.gtarc.chariot.api.model.common.impl.CommonPackageImpl;
import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.ActivationStatus;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.JiacAgentEndpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Owner;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.RestEndpoint;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.chariot.ChariotPackage;
import com.gtarc.chariot.api.model.chariot.impl.ChariotPackageImpl;
import com.gtarc.chariot.api.model.properties.PropertiesPackage;

import com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl;

import com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage;

import com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl;
import com.gtarc.quality.qualitymodel.metric.Metric;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainmodelPackageImpl extends EPackageImpl implements DomainmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smartCityObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actuatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jiacAgentEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum activationStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ownerEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum measuringModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum domainEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType metricEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomainmodelPackageImpl() {
		super(eNS_URI, DomainmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DomainmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomainmodelPackage init() {
		if (isInited) return (DomainmodelPackage)EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI);

		// Obtain or create and register package
		DomainmodelPackageImpl theDomainmodelPackage = (DomainmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomainmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomainmodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ChariotPackageImpl theIscoPackage = (ChariotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI) instanceof ChariotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI) : ChariotPackage.eINSTANCE);
		SpatialdataPackageImpl theSpatialdataPackage = (SpatialdataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) instanceof SpatialdataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) : SpatialdataPackage.eINSTANCE);
		PropertiesPackageImpl thePropertiesPackage = (PropertiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI) instanceof PropertiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI) : PropertiesPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);

		// Create package meta-data objects
		theDomainmodelPackage.createPackageContents();
		theIscoPackage.createPackageContents();
		theSpatialdataPackage.createPackageContents();
		thePropertiesPackage.createPackageContents();
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		theDomainmodelPackage.initializePackageContents();
		theIscoPackage.initializePackageContents();
		theSpatialdataPackage.initializePackageContents();
		thePropertiesPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomainmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomainmodelPackage.eNS_URI, theDomainmodelPackage);
		return theDomainmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmartCityObject() {
		return smartCityObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Label() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Domains() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Id() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Description() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Accessibility() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Precondition() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartCityObject_Endpoint() {
		return (EReference)smartCityObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Quality() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Iri() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmartCityObject_Classification() {
		return (EAttribute)smartCityObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDevice() {
		return deviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_Location() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_OperationalArea() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_ActivationStatus() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Group() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Owner() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDevice_Properties() {
		return (EReference)deviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Type() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActuator() {
		return actuatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActuator_Effect() {
		return (EAttribute)actuatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensor() {
		return sensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensor_Mode() {
		return (EAttribute)sensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensor_Output() {
		return (EReference)sensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Region() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Effect() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Priority() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Bundle() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Inputs() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Outputs() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Label() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Type() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndpoint() {
		return endpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestEndpoint() {
		return restEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRestEndpoint_Uri() {
		return (EAttribute)restEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJiacAgentEndpoint() {
		return jiacAgentEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJiacAgentEndpoint_AgentNodeId() {
		return (EAttribute)jiacAgentEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJiacAgentEndpoint_AgentId() {
		return (EAttribute)jiacAgentEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJiacAgentEndpoint_ActionName() {
		return (EAttribute)jiacAgentEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessibility() {
		return accessibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActivationStatus() {
		return activationStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOwner() {
		return ownerEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMeasuringMode() {
		return measuringModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDomain() {
		return domainEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMetric() {
		return metricEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainmodelFactory getDomainmodelFactory() {
		return (DomainmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		smartCityObjectEClass = createEClass(SMART_CITY_OBJECT);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__LABEL);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__DOMAINS);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__ID);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__DESCRIPTION);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__ACCESSIBILITY);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__PRECONDITION);
		createEReference(smartCityObjectEClass, SMART_CITY_OBJECT__ENDPOINT);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__QUALITY);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__IRI);
		createEAttribute(smartCityObjectEClass, SMART_CITY_OBJECT__CLASSIFICATION);

		deviceEClass = createEClass(DEVICE);
		createEReference(deviceEClass, DEVICE__LOCATION);
		createEReference(deviceEClass, DEVICE__OPERATIONAL_AREA);
		createEAttribute(deviceEClass, DEVICE__ACTIVATION_STATUS);
		createEAttribute(deviceEClass, DEVICE__GROUP);
		createEAttribute(deviceEClass, DEVICE__OWNER);
		createEReference(deviceEClass, DEVICE__PROPERTIES);
		createEAttribute(deviceEClass, DEVICE__TYPE);

		actuatorEClass = createEClass(ACTUATOR);
		createEAttribute(actuatorEClass, ACTUATOR__EFFECT);

		sensorEClass = createEClass(SENSOR);
		createEAttribute(sensorEClass, SENSOR__MODE);
		createEReference(sensorEClass, SENSOR__OUTPUT);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__REGION);
		createEAttribute(serviceEClass, SERVICE__EFFECT);
		createEAttribute(serviceEClass, SERVICE__PRIORITY);
		createEAttribute(serviceEClass, SERVICE__BUNDLE);
		createEReference(serviceEClass, SERVICE__INPUTS);
		createEReference(serviceEClass, SERVICE__OUTPUTS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__LABEL);
		createEAttribute(parameterEClass, PARAMETER__TYPE);

		endpointEClass = createEClass(ENDPOINT);

		restEndpointEClass = createEClass(REST_ENDPOINT);
		createEAttribute(restEndpointEClass, REST_ENDPOINT__URI);

		jiacAgentEndpointEClass = createEClass(JIAC_AGENT_ENDPOINT);
		createEAttribute(jiacAgentEndpointEClass, JIAC_AGENT_ENDPOINT__AGENT_NODE_ID);
		createEAttribute(jiacAgentEndpointEClass, JIAC_AGENT_ENDPOINT__AGENT_ID);
		createEAttribute(jiacAgentEndpointEClass, JIAC_AGENT_ENDPOINT__ACTION_NAME);

		// Create enums
		accessibilityEEnum = createEEnum(ACCESSIBILITY);
		activationStatusEEnum = createEEnum(ACTIVATION_STATUS);
		ownerEEnum = createEEnum(OWNER);
		measuringModeEEnum = createEEnum(MEASURING_MODE);
		domainEEnum = createEEnum(DOMAIN);

		// Create data types
		metricEDataType = createEDataType(METRIC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ChariotPackage theChariotPackage = (ChariotPackage)EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI);
		SpatialdataPackage theSpatialdataPackage = (SpatialdataPackage)EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI);
		PropertiesPackage thePropertiesPackage = (PropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(metricEDataType, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		deviceEClass.getESuperTypes().add(this.getSmartCityObject());
		actuatorEClass.getESuperTypes().add(this.getDevice());
		sensorEClass.getESuperTypes().add(this.getDevice());
		serviceEClass.getESuperTypes().add(this.getSmartCityObject());
		restEndpointEClass.getESuperTypes().add(this.getEndpoint());
		jiacAgentEndpointEClass.getESuperTypes().add(this.getEndpoint());

		// Initialize classes, features, and operations; add parameters
		initEClass(smartCityObjectEClass, SmartCityObject.class, "SmartCityObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSmartCityObject_Label(), ecorePackage.getEString(), "label", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Domains(), this.getDomain(), "domains", null, 1, -1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Id(), theChariotPackage.getUUID(), "id", "00000000-0000-0000-0000-000000000000", 1, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Description(), ecorePackage.getEString(), "description", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Accessibility(), this.getAccessibility(), "accessibility", null, 1, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Precondition(), theChariotPackage.getSWRLRule(), "precondition", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmartCityObject_Endpoint(), this.getEndpoint(), null, "endpoint", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getMetric());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getSmartCityObject_Quality(), g1, "quality", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Iri(), theChariotPackage.getIRI(), "iri", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmartCityObject_Classification(), theChariotPackage.getIRI(), "classification", null, 0, 1, SmartCityObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceEClass, Device.class, "Device", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDevice_Location(), theSpatialdataPackage.getLocation(), null, "location", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_OperationalArea(), theSpatialdataPackage.getSpatialObject(), null, "operationalArea", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_ActivationStatus(), this.getActivationStatus(), "activationStatus", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Group(), ecorePackage.getEString(), "group", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Owner(), this.getOwner(), "owner", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDevice_Properties(), thePropertiesPackage.getProperty(), null, "properties", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Type(), theChariotPackage.getIRI(), "type", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actuatorEClass, Actuator.class, "Actuator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActuator_Effect(), theChariotPackage.getSWRLRule(), "effect", null, 0, 1, Actuator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sensorEClass, Sensor.class, "Sensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensor_Mode(), this.getMeasuringMode(), "mode", null, 0, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSensor_Output(), this.getParameter(), null, "output", null, 1, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_Region(), theSpatialdataPackage.getSpatialObject(), null, "region", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Effect(), theChariotPackage.getSWRLRule(), "effect", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Priority(), ecorePackage.getEString(), "priority", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Bundle(), ecorePackage.getEString(), "bundle", "", 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Inputs(), this.getParameter(), null, "inputs", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Outputs(), this.getParameter(), null, "outputs", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Label(), ecorePackage.getEString(), "label", "", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Type(), theChariotPackage.getIRI(), "type", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endpointEClass, Endpoint.class, "Endpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(restEndpointEClass, RestEndpoint.class, "RestEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRestEndpoint_Uri(), theChariotPackage.getURI(), "uri", null, 0, 1, RestEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jiacAgentEndpointEClass, JiacAgentEndpoint.class, "JiacAgentEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJiacAgentEndpoint_AgentNodeId(), ecorePackage.getEString(), "agentNodeId", null, 0, 1, JiacAgentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJiacAgentEndpoint_AgentId(), ecorePackage.getEString(), "agentId", null, 0, 1, JiacAgentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJiacAgentEndpoint_ActionName(), ecorePackage.getEString(), "actionName", null, 0, 1, JiacAgentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessibilityEEnum, Accessibility.class, "Accessibility");
		addEEnumLiteral(accessibilityEEnum, Accessibility.UNDEFINED);
		addEEnumLiteral(accessibilityEEnum, Accessibility.OPEN);
		addEEnumLiteral(accessibilityEEnum, Accessibility.PROTECTED);

		initEEnum(activationStatusEEnum, ActivationStatus.class, "ActivationStatus");
		addEEnumLiteral(activationStatusEEnum, ActivationStatus.UNDEFINED);
		addEEnumLiteral(activationStatusEEnum, ActivationStatus.OFF);
		addEEnumLiteral(activationStatusEEnum, ActivationStatus.ON);
		addEEnumLiteral(activationStatusEEnum, ActivationStatus.BLOCKED);

		initEEnum(ownerEEnum, Owner.class, "Owner");
		addEEnumLiteral(ownerEEnum, Owner.UNDEFINED);
		addEEnumLiteral(ownerEEnum, Owner.PRIVATE);
		addEEnumLiteral(ownerEEnum, Owner.MUNICIPALITY);

		initEEnum(measuringModeEEnum, MeasuringMode.class, "MeasuringMode");
		addEEnumLiteral(measuringModeEEnum, MeasuringMode.UNDEFINED);
		addEEnumLiteral(measuringModeEEnum, MeasuringMode.CONSTANT);
		addEEnumLiteral(measuringModeEEnum, MeasuringMode.BY_REQUEST);
		addEEnumLiteral(measuringModeEEnum, MeasuringMode.INTERVAL);
		addEEnumLiteral(measuringModeEEnum, MeasuringMode.CONTINUOUS);

		initEEnum(domainEEnum, Domain.class, "Domain");
		addEEnumLiteral(domainEEnum, Domain.SMART_CITY);
		addEEnumLiteral(domainEEnum, Domain.TRANSPORTATION_AND_MOBILITY);
		addEEnumLiteral(domainEEnum, Domain.LIVING);
		addEEnumLiteral(domainEEnum, Domain.BUILDINGS);
		addEEnumLiteral(domainEEnum, Domain.ECONOMY_AND_PEOPLE);
		addEEnumLiteral(domainEEnum, Domain.GOVERNMENT);
		addEEnumLiteral(domainEEnum, Domain.NATURAL_RESOURCES_AND_ENERGY);

		// Initialize data types
		initEDataType(metricEDataType, Metric.class, "Metric", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //DomainmodelPackageImpl
