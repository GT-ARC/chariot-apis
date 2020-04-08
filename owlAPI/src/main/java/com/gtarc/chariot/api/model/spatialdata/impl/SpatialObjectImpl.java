/**
 */
package com.gtarc.chariot.api.model.spatialdata.impl;

import com.gtarc.chariot.api.model.spatialdata.SpatialObject;
import com.gtarc.chariot.api.model.spatialdata.SpatialdataPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spatial Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class SpatialObjectImpl extends MinimalEObjectImpl.Container implements SpatialObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpatialObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpatialdataPackage.Literals.SPATIAL_OBJECT;
	}

} //SpatialObjectImpl
