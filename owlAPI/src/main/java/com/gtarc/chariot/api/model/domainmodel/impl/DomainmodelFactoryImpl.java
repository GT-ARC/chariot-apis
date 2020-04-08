/**
 */
package com.gtarc.chariot.api.model.domainmodel.impl;

import com.gtarc.chariot.api.model.domainmodel.*;
import com.gtarc.quality.qualitymodel.metric.Metric;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainmodelFactoryImpl extends EFactoryImpl implements DomainmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomainmodelFactory init() {
		try {
			DomainmodelFactory theDomainmodelFactory = (DomainmodelFactory)EPackage.Registry.INSTANCE.getEFactory(DomainmodelPackage.eNS_URI);
			if (theDomainmodelFactory != null) {
				return theDomainmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomainmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DomainmodelPackage.ACTUATOR: return (EObject)createActuator();
			case DomainmodelPackage.SENSOR: return (EObject)createSensor();
			case DomainmodelPackage.SERVICE: return (EObject)createService();
			case DomainmodelPackage.PARAMETER: return (EObject)createParameter();
			case DomainmodelPackage.ENDPOINT: return (EObject)createEndpoint();
			case DomainmodelPackage.REST_ENDPOINT: return (EObject)createRestEndpoint();
			case DomainmodelPackage.JIAC_AGENT_ENDPOINT: return (EObject)createJiacAgentEndpoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DomainmodelPackage.ACCESSIBILITY:
				return createAccessibilityFromString(eDataType, initialValue);
			case DomainmodelPackage.ACTIVATION_STATUS:
				return createActivationStatusFromString(eDataType, initialValue);
			case DomainmodelPackage.OWNER:
				return createOwnerFromString(eDataType, initialValue);
			case DomainmodelPackage.MEASURING_MODE:
				return createMeasuringModeFromString(eDataType, initialValue);
			case DomainmodelPackage.DOMAIN:
				return createDomainFromString(eDataType, initialValue);
			case DomainmodelPackage.METRIC:
				return createMetricFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DomainmodelPackage.ACCESSIBILITY:
				return convertAccessibilityToString(eDataType, instanceValue);
			case DomainmodelPackage.ACTIVATION_STATUS:
				return convertActivationStatusToString(eDataType, instanceValue);
			case DomainmodelPackage.OWNER:
				return convertOwnerToString(eDataType, instanceValue);
			case DomainmodelPackage.MEASURING_MODE:
				return convertMeasuringModeToString(eDataType, instanceValue);
			case DomainmodelPackage.DOMAIN:
				return convertDomainToString(eDataType, instanceValue);
			case DomainmodelPackage.METRIC:
				return convertMetricToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actuator createActuator() {
		ActuatorImpl actuator = new ActuatorImpl();
		return actuator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sensor createSensor() {
		SensorImpl sensor = new SensorImpl();
		return sensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Endpoint createEndpoint() {
		EndpointImpl endpoint = new EndpointImpl();
		return endpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RestEndpoint createRestEndpoint() {
		RestEndpointImpl restEndpoint = new RestEndpointImpl();
		return restEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JiacAgentEndpoint createJiacAgentEndpoint() {
		JiacAgentEndpointImpl jiacAgentEndpoint = new JiacAgentEndpointImpl();
		return jiacAgentEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accessibility createAccessibility(String literal) {
		Accessibility result = Accessibility.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + DomainmodelPackage.Literals.ACCESSIBILITY.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accessibility createAccessibilityFromString(EDataType eDataType, String initialValue) {
		return createAccessibility(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessibility(Accessibility instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessibilityToString(EDataType eDataType, Object instanceValue) {
		return convertAccessibility((Accessibility)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationStatus createActivationStatus(String literal) {
		ActivationStatus result = ActivationStatus.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + DomainmodelPackage.Literals.ACTIVATION_STATUS.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationStatus createActivationStatusFromString(EDataType eDataType, String initialValue) {
		return createActivationStatus(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivationStatus(ActivationStatus instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivationStatusToString(EDataType eDataType, Object instanceValue) {
		return convertActivationStatus((ActivationStatus)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner createOwner(String literal) {
		Owner result = Owner.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + DomainmodelPackage.Literals.OWNER.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner createOwnerFromString(EDataType eDataType, String initialValue) {
		return createOwner(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOwner(Owner instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOwnerToString(EDataType eDataType, Object instanceValue) {
		return convertOwner((Owner)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuringMode createMeasuringMode(String literal) {
		MeasuringMode result = MeasuringMode.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + DomainmodelPackage.Literals.MEASURING_MODE.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasuringMode createMeasuringModeFromString(EDataType eDataType, String initialValue) {
		return createMeasuringMode(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasuringMode(MeasuringMode instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasuringModeToString(EDataType eDataType, Object instanceValue) {
		return convertMeasuringMode((MeasuringMode)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain createDomain(String literal) {
		Domain result = Domain.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + DomainmodelPackage.Literals.DOMAIN.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain createDomainFromString(EDataType eDataType, String initialValue) {
		return createDomain(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDomain(Domain instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDomainToString(EDataType eDataType, Object instanceValue) {
		return convertDomain((Domain)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric<?> createMetric(String literal) {
		return (Metric<?>)super.createFromString(literal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric<?> createMetricFromString(EDataType eDataType, String initialValue) {
		return createMetric(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetric(Metric<?> instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetricToString(EDataType eDataType, Object instanceValue) {
		return convertMetric((Metric<?>)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainmodelPackage getDomainmodelPackage() {
		return (DomainmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomainmodelPackage getPackage() {
		return DomainmodelPackage.eINSTANCE;
	}

} //DomainmodelFactoryImpl
