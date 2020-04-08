/**
 *
 */
package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.serviceapi.Service;

/**
 *
 * @author cemakpolat
 *
 */
public abstract class AbstractService implements Service {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public abstract void start();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public abstract void run();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public abstract void stop();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public abstract boolean isRunning();


} //AbstractService
