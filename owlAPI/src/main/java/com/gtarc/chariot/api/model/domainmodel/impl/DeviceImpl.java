/**
 */
package com.gtarc.chariot.api.model.domainmodel.impl;

import com.gtarc.chariot.api.model.domainmodel.ActivationStatus;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage;
import com.gtarc.chariot.api.model.domainmodel.Owner;

import com.gtarc.chariot.api.model.properties.Property;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.semanticweb.owlapi.model.IRI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getOperationalArea <em>Operational Area</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getActivationStatus <em>Activation Status</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.domainmodel.impl.DeviceImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DeviceImpl extends SmartCityObjectImpl implements Device {
	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Location location;

	/**
	 * The cached value of the '{@link #getOperationalArea() <em>Operational Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationalArea()
	 * @generated
	 * @ordered
	 */
	protected SpatialObject operationalArea;

	/**
	 * The default value of the '{@link #getActivationStatus() <em>Activation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ActivationStatus ACTIVATION_STATUS_EDEFAULT = ActivationStatus.UNDEFINED;

	/**
	 * The cached value of the '{@link #getActivationStatus() <em>Activation Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationStatus()
	 * @generated
	 * @ordered
	 */
	protected ActivationStatus activationStatus = ACTIVATION_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected String group = GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final Owner OWNER_EDEFAULT = Owner.UNDEFINED;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Owner owner = OWNER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final IRI TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IRI type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainmodelPackage.Literals.DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		Location oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Location newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.DEVICE__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.DEVICE__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialObject getOperationalArea() {
		return operationalArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationalArea(SpatialObject newOperationalArea, NotificationChain msgs) {
		SpatialObject oldOperationalArea = operationalArea;
		operationalArea = newOperationalArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__OPERATIONAL_AREA, oldOperationalArea, newOperationalArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationalArea(SpatialObject newOperationalArea) {
		if (newOperationalArea != operationalArea) {
			NotificationChain msgs = null;
			if (operationalArea != null)
				msgs = ((InternalEObject)operationalArea).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.DEVICE__OPERATIONAL_AREA, null, msgs);
			if (newOperationalArea != null)
				msgs = ((InternalEObject)newOperationalArea).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomainmodelPackage.DEVICE__OPERATIONAL_AREA, null, msgs);
			msgs = basicSetOperationalArea(newOperationalArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__OPERATIONAL_AREA, newOperationalArea, newOperationalArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationStatus getActivationStatus() {
		return activationStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivationStatus(ActivationStatus newActivationStatus) {
		ActivationStatus oldActivationStatus = activationStatus;
		activationStatus = newActivationStatus == null ? ACTIVATION_STATUS_EDEFAULT : newActivationStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__ACTIVATION_STATUS, oldActivationStatus, activationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(String newGroup) {
		String oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__GROUP, oldGroup, group));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Owner newOwner) {
		Owner oldOwner = owner;
		owner = newOwner == null ? OWNER_EDEFAULT : newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, DomainmodelPackage.DEVICE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRI getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(IRI newType) {
		IRI oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmodelPackage.DEVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomainmodelPackage.DEVICE__LOCATION:
				return basicSetLocation(null, msgs);
			case DomainmodelPackage.DEVICE__OPERATIONAL_AREA:
				return basicSetOperationalArea(null, msgs);
			case DomainmodelPackage.DEVICE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case DomainmodelPackage.DEVICE__LOCATION:
				return getLocation();
			case DomainmodelPackage.DEVICE__OPERATIONAL_AREA:
				return getOperationalArea();
			case DomainmodelPackage.DEVICE__ACTIVATION_STATUS:
				return getActivationStatus();
			case DomainmodelPackage.DEVICE__GROUP:
				return getGroup();
			case DomainmodelPackage.DEVICE__OWNER:
				return getOwner();
			case DomainmodelPackage.DEVICE__PROPERTIES:
				return getProperties();
			case DomainmodelPackage.DEVICE__TYPE:
				return getType();
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
			case DomainmodelPackage.DEVICE__LOCATION:
				setLocation((Location)newValue);
				return;
			case DomainmodelPackage.DEVICE__OPERATIONAL_AREA:
				setOperationalArea((SpatialObject)newValue);
				return;
			case DomainmodelPackage.DEVICE__ACTIVATION_STATUS:
				setActivationStatus((ActivationStatus)newValue);
				return;
			case DomainmodelPackage.DEVICE__GROUP:
				setGroup((String)newValue);
				return;
			case DomainmodelPackage.DEVICE__OWNER:
				setOwner((Owner)newValue);
				return;
			case DomainmodelPackage.DEVICE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case DomainmodelPackage.DEVICE__TYPE:
				setType((IRI)newValue);
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
			case DomainmodelPackage.DEVICE__LOCATION:
				setLocation((Location)null);
				return;
			case DomainmodelPackage.DEVICE__OPERATIONAL_AREA:
				setOperationalArea((SpatialObject)null);
				return;
			case DomainmodelPackage.DEVICE__ACTIVATION_STATUS:
				setActivationStatus(ACTIVATION_STATUS_EDEFAULT);
				return;
			case DomainmodelPackage.DEVICE__GROUP:
				setGroup(GROUP_EDEFAULT);
				return;
			case DomainmodelPackage.DEVICE__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case DomainmodelPackage.DEVICE__PROPERTIES:
				getProperties().clear();
				return;
			case DomainmodelPackage.DEVICE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DomainmodelPackage.DEVICE__LOCATION:
				return location != null;
			case DomainmodelPackage.DEVICE__OPERATIONAL_AREA:
				return operationalArea != null;
			case DomainmodelPackage.DEVICE__ACTIVATION_STATUS:
				return activationStatus != ACTIVATION_STATUS_EDEFAULT;
			case DomainmodelPackage.DEVICE__GROUP:
				return GROUP_EDEFAULT == null ? group != null : !GROUP_EDEFAULT.equals(group);
			case DomainmodelPackage.DEVICE__OWNER:
				return owner != OWNER_EDEFAULT;
			case DomainmodelPackage.DEVICE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case DomainmodelPackage.DEVICE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (activationStatus: ");
		result.append(activationStatus);
		result.append(", group: ");
		result.append(group);
		result.append(", owner: ");
		result.append(owner);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DeviceImpl
