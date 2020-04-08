/**
 */
package com.gtarc.chariot.api.model.domainmodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sensor measures specific information from its environment.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getMode <em>Mode</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSensor()
 * @model
 * @generated
 */
public interface Sensor extends Device {
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link com.gtarc.chariot.api.model.domainmodel.MeasuringMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mode of operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.MeasuringMode
	 * @see #setMode(MeasuringMode)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSensor_Mode()
	 * @model
	 * @generated
	 */
	MeasuringMode getMode();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see com.gtarc.chariot.api.model.domainmodel.MeasuringMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(MeasuringMode value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of output of this sensor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' reference.
	 * @see #setOutput(Parameter)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getSensor_Output()
	 * @model required="true"
	 * @generated
	 */
	Parameter getOutput();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Sensor#getOutput <em>Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Parameter value);

} // Sensor
