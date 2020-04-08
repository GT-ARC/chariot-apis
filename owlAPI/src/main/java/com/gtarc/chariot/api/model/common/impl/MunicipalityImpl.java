/**
 */
package com.gtarc.chariot.api.model.common.impl;

import com.gtarc.chariot.api.model.common.CommonPackage;
import com.gtarc.chariot.api.model.common.Municipality;
import com.gtarc.chariot.api.model.common.Right;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Municipality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gtarc.chariot.api.model.common.impl.MunicipalityImpl#getRights <em>Rights</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MunicipalityImpl extends MinimalEObjectImpl.Container implements Municipality {
	/**
	 * The cached value of the '{@link #getRights() <em>Rights</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected EList<Right> rights;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MunicipalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.MUNICIPALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Right> getRights() {
		if (rights == null) {
			rights = new EObjectResolvingEList<Right>(Right.class, this, CommonPackage.MUNICIPALITY__RIGHTS);
		}
		return rights;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.MUNICIPALITY__RIGHTS:
				return getRights();
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
			case CommonPackage.MUNICIPALITY__RIGHTS:
				getRights().clear();
				getRights().addAll((Collection<? extends Right>)newValue);
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
			case CommonPackage.MUNICIPALITY__RIGHTS:
				getRights().clear();
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
			case CommonPackage.MUNICIPALITY__RIGHTS:
				return rights != null && !rights.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MunicipalityImpl
