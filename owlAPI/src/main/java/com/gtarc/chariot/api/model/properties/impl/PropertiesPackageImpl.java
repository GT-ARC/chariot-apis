/**
 */
package com.gtarc.chariot.api.model.properties.impl;

import com.gtarc.chariot.api.model.common.CommonPackage;
import com.gtarc.chariot.api.model.common.impl.CommonPackageImpl;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;

import com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl;

import com.gtarc.chariot.api.model.chariot.ChariotPackage;
import com.gtarc.chariot.api.model.chariot.impl.ChariotPackageImpl;
import com.gtarc.chariot.api.model.properties.ComplexProperty;
import com.gtarc.chariot.api.model.properties.PropertiesFactory;
import com.gtarc.chariot.api.model.properties.PropertiesPackage;
import com.gtarc.chariot.api.model.properties.Property;
import com.gtarc.chariot.api.model.properties.SimpleProperty;

import com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage;

import com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertiesPackageImpl extends EPackageImpl implements PropertiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexPropertyEClass = null;

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
	 * @see com.gtarc.chariot.api.model.properties.PropertiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PropertiesPackageImpl() {
		super(eNS_URI, PropertiesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PropertiesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PropertiesPackage init() {
		if (isInited) return (PropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);

		// Obtain or create and register package
		PropertiesPackageImpl thePropertiesPackage = (PropertiesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PropertiesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PropertiesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ChariotPackageImpl theIscoPackage = (ChariotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI) instanceof ChariotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI) : ChariotPackage.eINSTANCE);
		DomainmodelPackageImpl theDomainmodelPackage = (DomainmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI) instanceof DomainmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI) : DomainmodelPackage.eINSTANCE);
		SpatialdataPackageImpl theSpatialdataPackage = (SpatialdataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) instanceof SpatialdataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) : SpatialdataPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);

		// Create package meta-data objects
		thePropertiesPackage.createPackageContents();
		theIscoPackage.createPackageContents();
		theDomainmodelPackage.createPackageContents();
		theSpatialdataPackage.createPackageContents();
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		thePropertiesPackage.initializePackageContents();
		theIscoPackage.initializePackageContents();
		theDomainmodelPackage.initializePackageContents();
		theSpatialdataPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePropertiesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PropertiesPackage.eNS_URI, thePropertiesPackage);
		return thePropertiesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Label() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleProperty() {
		return simplePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleProperty_Value() {
		return (EAttribute)simplePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleProperty_Unit() {
		return (EAttribute)simplePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexProperty() {
		return complexPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexProperty_SubProperties() {
		return (EReference)complexPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesFactory getPropertiesFactory() {
		return (PropertiesFactory)getEFactoryInstance();
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
		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__LABEL);

		simplePropertyEClass = createEClass(SIMPLE_PROPERTY);
		createEAttribute(simplePropertyEClass, SIMPLE_PROPERTY__VALUE);
		createEAttribute(simplePropertyEClass, SIMPLE_PROPERTY__UNIT);

		complexPropertyEClass = createEClass(COMPLEX_PROPERTY);
		createEReference(complexPropertyEClass, COMPLEX_PROPERTY__SUB_PROPERTIES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		simplePropertyEClass.getESuperTypes().add(this.getProperty());
		complexPropertyEClass.getESuperTypes().add(this.getProperty());

		// Initialize classes, features, and operations; add parameters
		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Label(), ecorePackage.getEString(), "label", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simplePropertyEClass, SimpleProperty.class, "SimpleProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleProperty_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, SimpleProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleProperty_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, SimpleProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexPropertyEClass, ComplexProperty.class, "ComplexProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexProperty_SubProperties(), this.getProperty(), null, "subProperties", null, 1, -1, ComplexProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PropertiesPackageImpl
