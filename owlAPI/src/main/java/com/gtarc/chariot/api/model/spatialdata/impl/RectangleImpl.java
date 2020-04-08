/**
 */
package com.gtarc.chariot.api.model.spatialdata.impl;

import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.Rectangle;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rectangle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl#getX2 <em>X2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RectangleImpl extends SpatialObjectImpl implements Rectangle {
	/**
	 * The cached value of the '{@link #getX1() <em>X1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX1()
	 * @generated
	 * @ordered
	 */
	protected Location x1;

	/**
	 * The cached value of the '{@link #getX2() <em>X2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX2()
	 * @generated
	 * @ordered
	 */
	protected Location x2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RectangleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpatialdataPackage.Literals.RECTANGLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getX1() {
		return x1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetX1(Location newX1, NotificationChain msgs) {
		Location oldX1 = x1;
		x1 = newX1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpatialdataPackage.RECTANGLE__X1, oldX1, newX1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX1(Location newX1) {
		if (newX1 != x1) {
			NotificationChain msgs = null;
			if (x1 != null)
				msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpatialdataPackage.RECTANGLE__X1, null, msgs);
			if (newX1 != null)
				msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpatialdataPackage.RECTANGLE__X1, null, msgs);
			msgs = basicSetX1(newX1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpatialdataPackage.RECTANGLE__X1, newX1, newX1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getX2() {
		return x2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetX2(Location newX2, NotificationChain msgs) {
		Location oldX2 = x2;
		x2 = newX2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpatialdataPackage.RECTANGLE__X2, oldX2, newX2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX2(Location newX2) {
		if (newX2 != x2) {
			NotificationChain msgs = null;
			if (x2 != null)
				msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpatialdataPackage.RECTANGLE__X2, null, msgs);
			if (newX2 != null)
				msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpatialdataPackage.RECTANGLE__X2, null, msgs);
			msgs = basicSetX2(newX2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpatialdataPackage.RECTANGLE__X2, newX2, newX2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpatialdataPackage.RECTANGLE__X1:
				return basicSetX1(null, msgs);
			case SpatialdataPackage.RECTANGLE__X2:
				return basicSetX2(null, msgs);
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
			case SpatialdataPackage.RECTANGLE__X1:
				return getX1();
			case SpatialdataPackage.RECTANGLE__X2:
				return getX2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpatialdataPackage.RECTANGLE__X1:
				setX1((Location)newValue);
				return;
			case SpatialdataPackage.RECTANGLE__X2:
				setX2((Location)newValue);
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
			case SpatialdataPackage.RECTANGLE__X1:
				setX1((Location)null);
				return;
			case SpatialdataPackage.RECTANGLE__X2:
				setX2((Location)null);
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
			case SpatialdataPackage.RECTANGLE__X1:
				return x1 != null;
			case SpatialdataPackage.RECTANGLE__X2:
				return x2 != null;
		}
		return super.eIsSet(featureID);
	}

} //RectangleImpl
