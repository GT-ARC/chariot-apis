/**
 */
package com.gtarc.chariot.api.model.chariot.impl;

import com.gtarc.chariot.api.model.common.CommonPackage;
import com.gtarc.chariot.api.model.common.impl.CommonPackageImpl;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;

import com.gtarc.chariot.api.model.domainmodel.impl.DomainmodelPackageImpl;

import com.gtarc.chariot.api.model.chariot.ChariotFactory;
import com.gtarc.chariot.api.model.chariot.ChariotPackage;
import com.gtarc.chariot.api.model.properties.PropertiesPackage;

import com.gtarc.chariot.api.model.properties.impl.PropertiesPackageImpl;

import com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage;

import com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.semanticweb.owlapi.model.SWRLRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChariotPackageImpl extends EPackageImpl implements ChariotPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType swrlRuleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uuidEDataType = null;

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
	 * @see ChariotPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChariotPackageImpl() {
		super(eNS_URI, ChariotFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ChariotPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ChariotPackage init() {
		if (isInited) return (ChariotPackage)EPackage.Registry.INSTANCE.getEPackage(ChariotPackage.eNS_URI);

		// Obtain or create and register package
		ChariotPackageImpl theChariotPackage = (ChariotPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ChariotPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ChariotPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DomainmodelPackageImpl theDomainmodelPackage = (DomainmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI) instanceof DomainmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI) : DomainmodelPackage.eINSTANCE);
		SpatialdataPackageImpl theSpatialdataPackage = (SpatialdataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) instanceof SpatialdataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI) : SpatialdataPackage.eINSTANCE);
		PropertiesPackageImpl thePropertiesPackage = (PropertiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI) instanceof PropertiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI) : PropertiesPackage.eINSTANCE);
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);

		// Create package meta-data objects
		theChariotPackage.createPackageContents();
		theDomainmodelPackage.createPackageContents();
		theSpatialdataPackage.createPackageContents();
		thePropertiesPackage.createPackageContents();
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		theChariotPackage.initializePackageContents();
		theDomainmodelPackage.initializePackageContents();
		theSpatialdataPackage.initializePackageContents();
		thePropertiesPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChariotPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ChariotPackage.eNS_URI, theChariotPackage);
		return theChariotPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIRI() {
		return iriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSWRLRule() {
		return swrlRuleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUUID() {
		return uuidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChariotFactory getIscoFactory() {
		return (ChariotFactory)getEFactoryInstance();
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

		// Create data types
		iriEDataType = createEDataType(IRI);
		uriEDataType = createEDataType(URI);
		swrlRuleEDataType = createEDataType(SWRL_RULE);
		uuidEDataType = createEDataType(UUID);
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
		DomainmodelPackage theDomainmodelPackage = (DomainmodelPackage)EPackage.Registry.INSTANCE.getEPackage(DomainmodelPackage.eNS_URI);
		SpatialdataPackage theSpatialdataPackage = (SpatialdataPackage)EPackage.Registry.INSTANCE.getEPackage(SpatialdataPackage.eNS_URI);
		PropertiesPackage thePropertiesPackage = (PropertiesPackage)EPackage.Registry.INSTANCE.getEPackage(PropertiesPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDomainmodelPackage);
		getESubpackages().add(theSpatialdataPackage);
		getESubpackages().add(thePropertiesPackage);
		getESubpackages().add(theCommonPackage);

		// Initialize data types
		initEDataType(iriEDataType, org.semanticweb.owlapi.model.IRI.class, "IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(swrlRuleEDataType, SWRLRule.class, "SWRLRule", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uuidEDataType, java.util.UUID.class, "UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //IscoPackageImpl
