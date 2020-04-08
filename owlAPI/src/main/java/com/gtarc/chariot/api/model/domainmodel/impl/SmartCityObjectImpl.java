/**
 */
package com.gtarc.chariot.api.model.domainmodel.impl;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;

import com.gtarc.chariot.api.model.chariot.ChariotFactory;
import com.gtarc.chariot.api.model.chariot.ChariotPackage;
import com.gtarc.quality.qualitymodel.metric.Metric;
import java.util.Collection;

import java.util.List;
import java.util.UUID;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.SWRLRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smart City Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getAccessibility <em>Accessibility</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getIri <em>Iri</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.SmartCityObjectImpl#getClassification <em>Classification</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SmartCityObjectImpl extends MinimalEObjectImpl.Container implements SmartCityObject {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domains;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final UUID ID_EDEFAULT = (UUID) ChariotFactory.eINSTANCE.createFromString(ChariotPackage.eINSTANCE.getUUID(), "00000000-0000-0000-0000-000000000000");

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected UUID id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccessibility() <em>Accessibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessibility()
	 * @generated
	 * @ordered
	 */
	protected static final Accessibility ACCESSIBILITY_EDEFAULT = Accessibility.UNDEFINED;

	/**
	 * The cached value of the '{@link #getAccessibility() <em>Accessibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessibility()
	 * @generated
	 * @ordered
	 */
	protected Accessibility accessibility = ACCESSIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected static final SWRLRule PRECONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected SWRLRule precondition = PRECONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoint()
	 * @generated
	 * @ordered
	 */
	protected Endpoint endpoint;

	/**
	 * The cached value of the '{@link #getQuality() <em>Quality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality()
	 * @generated
	 * @ordered
	 */
	protected Metric<?> quality;

	/**
	 * The default value of the '{@link #getIri() <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIri()
	 * @generated
	 * @ordered
	 */
	protected static final IRI IRI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIri() <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIri()
	 * @generated
	 * @ordered
	 */
	protected IRI iri = IRI_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassification() <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassification()
	 * @generated
	 * @ordered
	 */
	protected static final IRI CLASSIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassification() <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassification()
	 * @generated
	 * @ordered
	 */
	protected IRI classification = CLASSIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmartCityObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainmodelPackage.Literals.SMART_CITY_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Domain> getDomains() {
		if (domains == null) {
			domains = new EDataTypeUniqueEList<Domain>(Domain.class, this, DomainmodelPackage.SMART_CITY_OBJECT__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(UUID newId) {
		UUID oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accessibility getAccessibility() {
		return accessibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessibility(Accessibility newAccessibility) {
		Accessibility oldAccessibility = accessibility;
		accessibility = newAccessibility == null ? ACCESSIBILITY_EDEFAULT : newAccessibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__ACCESSIBILITY, oldAccessibility, accessibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SWRLRule getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(SWRLRule newPrecondition) {
		SWRLRule oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__PRECONDITION, oldPrecondition, precondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Endpoint getEndpoint() {
		return endpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpoint(Endpoint newEndpoint, NotificationChain msgs) {
		Endpoint oldEndpoint = endpoint;
		endpoint = newEndpoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT, oldEndpoint, newEndpoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpoint(Endpoint newEndpoint) {
		if (newEndpoint != endpoint) {
			NotificationChain msgs = null;
			if (endpoint != null)
				msgs = ((InternalEObject)endpoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT, null, msgs);
			if (newEndpoint != null)
				msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT, null, msgs);
			msgs = basicSetEndpoint(newEndpoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT, newEndpoint, newEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric<?> getQuality() {
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuality(Metric<?> newQuality) {
		Metric<?> oldQuality = quality;
		quality = newQuality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__QUALITY, oldQuality, quality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRI getIri() {
		return iri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIri(IRI newIri) {
		IRI oldIri = iri;
		iri = newIri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__IRI, oldIri, iri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRI getClassification() {
		return classification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassification(IRI newClassification) {
		IRI oldClassification = classification;
		classification = newClassification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.SMART_CITY_OBJECT__CLASSIFICATION, oldClassification, classification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT:
				return basicSetEndpoint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomainmodelPackage.SMART_CITY_OBJECT__LABEL:
				return getLabel();
			case DomainmodelPackage.SMART_CITY_OBJECT__DOMAINS:
				return getDomains();
			case DomainmodelPackage.SMART_CITY_OBJECT__ID:
				return getId();
			case DomainmodelPackage.SMART_CITY_OBJECT__DESCRIPTION:
				return getDescription();
			case DomainmodelPackage.SMART_CITY_OBJECT__ACCESSIBILITY:
				return getAccessibility();
			case DomainmodelPackage.SMART_CITY_OBJECT__PRECONDITION:
				return getPrecondition();
			case DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT:
				return getEndpoint();
			case DomainmodelPackage.SMART_CITY_OBJECT__QUALITY:
				return getQuality();
			case DomainmodelPackage.SMART_CITY_OBJECT__IRI:
				return getIri();
			case DomainmodelPackage.SMART_CITY_OBJECT__CLASSIFICATION:
				return getClassification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomainmodelPackage.SMART_CITY_OBJECT__LABEL:
				setLabel((String)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends Domain>)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ID:
				setId((UUID)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ACCESSIBILITY:
				setAccessibility((Accessibility)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__PRECONDITION:
				setPrecondition((SWRLRule)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT:
				setEndpoint((Endpoint)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__QUALITY:
				setQuality((Metric<?>)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__IRI:
				setIri((IRI)newValue);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__CLASSIFICATION:
				setClassification((IRI)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomainmodelPackage.SMART_CITY_OBJECT__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__DOMAINS:
				getDomains().clear();
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ACCESSIBILITY:
				setAccessibility(ACCESSIBILITY_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__PRECONDITION:
				setPrecondition(PRECONDITION_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT:
				setEndpoint((Endpoint)null);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__QUALITY:
				setQuality((Metric<?>)null);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__IRI:
				setIri(IRI_EDEFAULT);
				return;
			case DomainmodelPackage.SMART_CITY_OBJECT__CLASSIFICATION:
				setClassification(CLASSIFICATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomainmodelPackage.SMART_CITY_OBJECT__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case DomainmodelPackage.SMART_CITY_OBJECT__DOMAINS:
				return domains != null && !domains.isEmpty();
			case DomainmodelPackage.SMART_CITY_OBJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DomainmodelPackage.SMART_CITY_OBJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DomainmodelPackage.SMART_CITY_OBJECT__ACCESSIBILITY:
				return accessibility != ACCESSIBILITY_EDEFAULT;
			case DomainmodelPackage.SMART_CITY_OBJECT__PRECONDITION:
				return PRECONDITION_EDEFAULT == null ? precondition != null : !PRECONDITION_EDEFAULT.equals(precondition);
			case DomainmodelPackage.SMART_CITY_OBJECT__ENDPOINT:
				return endpoint != null;
			case DomainmodelPackage.SMART_CITY_OBJECT__QUALITY:
				return quality != null;
			case DomainmodelPackage.SMART_CITY_OBJECT__IRI:
				return IRI_EDEFAULT == null ? iri != null : !IRI_EDEFAULT.equals(iri);
			case DomainmodelPackage.SMART_CITY_OBJECT__CLASSIFICATION:
				return CLASSIFICATION_EDEFAULT == null ? classification != null : !CLASSIFICATION_EDEFAULT.equals(classification);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", domains: ");
		result.append(domains);
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(", accessibility: ");
		result.append(accessibility);
		result.append(", precondition: ");
		result.append(precondition);
		result.append(", quality: ");
		result.append(quality);
		result.append(", iri: ");
		result.append(iri);
		result.append(", classification: ");
		result.append(classification);
		result.append(')');
		return result.toString();
	}

} //SmartCityObjectImpl
