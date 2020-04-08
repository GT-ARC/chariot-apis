/**
 */
package com.gtarc.chariot.api.model.properties.impl;

import com.gtarc.chariot.api.model.properties.ComplexProperty;
import com.gtarc.chariot.api.model.properties.PropertiesPackage;
import com.gtarc.chariot.api.model.properties.Property;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.properties.impl.ComplexPropertyImpl#getSubProperties <em>Sub Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexPropertyImpl extends PropertyImpl implements ComplexProperty {
	/**
	 * The cached value of the '{@link #getSubProperties() <em>Sub Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> subProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PropertiesPackage.Literals.COMPLEX_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getSubProperties() {
		if (subProperties == null) {
			subProperties = new EObjectContainmentEList<Property>(Property.class, this, PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES);
		}
		return subProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES:
				return ((InternalEList<?>)getSubProperties()).basicRemove(otherEnd, msgs);
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
			case PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES:
				return getSubProperties();
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
			case PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES:
				getSubProperties().clear();
				getSubProperties().addAll((Collection<? extends Property>)newValue);
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
			case PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES:
				getSubProperties().clear();
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
			case PropertiesPackage.COMPLEX_PROPERTY__SUB_PROPERTIES:
				return subProperties != null && !subProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexPropertyImpl
