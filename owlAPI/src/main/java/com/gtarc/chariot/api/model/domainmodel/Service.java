/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import java.util.List;
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A service is a virtual SCO that provides a certain (complex) functionality
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getRegion <em>Region</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getEffect <em>Effect</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getBundle <em>Bundle</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.Service#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService()
 * @model
 * @generated
 */
public interface Service extends SmartCityObject {
	/**
	 * Returns the value of the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region for which this service can deliver results.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' reference.
	 * @see #setRegion(SpatialObject)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Region()
	 * @model
	 * @generated
	 */
	SpatialObject getRegion();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Service#getRegion <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(SpatialObject value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effects of the triggered service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effect</em>' attribute.
	 * @see #setEffect(SWRLRule)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Effect()
	 * @model dataType="com.gtarc.isco.api.model.isco.SWRLRule"
	 * @generated
	 */
	SWRLRule getEffect();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Service#getEffect <em>Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' attribute.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(SWRLRule value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The service priority.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Priority()
	 * @model
	 * @generated
	 */
	String getPriority();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Service#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(String value);

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An identifier for the group the service belongs to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(String)
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Bundle()
	 * @model default=""
	 * @generated
	 */
	String getBundle();

	/**
	 * Sets the value of the '{@link com.gtarc.chariot.api.model.domainmodel.Service#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(String value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.domainmodel.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The service's input parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	List<Parameter> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link com.gtarc.chariot.api.model.domainmodel.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The service's outputs
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getService_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	List<Parameter> getOutputs();

} // Service
