/**
 */
package com.gtarc.chariot.api.model.properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.gtarc.chariot.api.model.properties.PropertiesFactory
 * @model kind="package"
 * @generated
 */
public interface PropertiesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "properties";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.gt-arc.com/isco/properties";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.gtarc.isco.properties";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropertiesPackage eINSTANCE = com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.properties.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.properties.impl.PropertyImpl
	 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.properties.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.properties.impl.SimplePropertyImpl
	 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getSimpleProperty()
	 * @generated
	 */
	int SIMPLE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__LABEL = PROPERTY__LABEL;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__VALUE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__UNIT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Simple Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.properties.impl.ComplexPropertyImpl <em>Complex Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.properties.impl.ComplexPropertyImpl
	 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getComplexProperty()
	 * @generated
	 */
	int COMPLEX_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_PROPERTY__LABEL = PROPERTY__LABEL;

	/**
	 * The feature id for the '<em><b>Sub Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_PROPERTY__SUB_PROPERTIES = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.properties.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see com.gtarc.chariot.api.model.properties.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.properties.Property#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.gtarc.chariot.api.model.properties.Property#getLabel()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Label();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.properties.SimpleProperty <em>Simple Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property</em>'.
	 * @see com.gtarc.chariot.api.model.properties.SimpleProperty
	 * @generated
	 */
	EClass getSimpleProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.properties.SimpleProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.gtarc.chariot.api.model.properties.SimpleProperty#getValue()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EAttribute getSimpleProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.properties.SimpleProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.gtarc.chariot.api.model.properties.SimpleProperty#getUnit()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EAttribute getSimpleProperty_Unit();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.properties.ComplexProperty <em>Complex Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Property</em>'.
	 * @see com.gtarc.chariot.api.model.properties.ComplexProperty
	 * @generated
	 */
	EClass getComplexProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gtarc.chariot.api.model.properties.ComplexProperty#getSubProperties <em>Sub Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Properties</em>'.
	 * @see com.gtarc.chariot.api.model.properties.ComplexProperty#getSubProperties()
	 * @see #getComplexProperty()
	 * @generated
	 */
	EReference getComplexProperty_SubProperties();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropertiesFactory getPropertiesFactory();

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
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.properties.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.properties.impl.PropertyImpl
		 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LABEL = eINSTANCE.getProperty_Label();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.properties.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.properties.impl.SimplePropertyImpl
		 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getSimpleProperty()
		 * @generated
		 */
		EClass SIMPLE_PROPERTY = eINSTANCE.getSimpleProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_PROPERTY__VALUE = eINSTANCE.getSimpleProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_PROPERTY__UNIT = eINSTANCE.getSimpleProperty_Unit();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.properties.impl.ComplexPropertyImpl <em>Complex Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.properties.impl.ComplexPropertyImpl
		 * @see com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl#getComplexProperty()
		 * @generated
		 */
		EClass COMPLEX_PROPERTY = eINSTANCE.getComplexProperty();

		/**
		 * The meta object literal for the '<em><b>Sub Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_PROPERTY__SUB_PROPERTIES = eINSTANCE.getComplexProperty_SubProperties();

	}

} //PropertiesPackage
