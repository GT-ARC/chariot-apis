package de.gtarc.chariot.deviceapi;

import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;

public interface DeviceAPIFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    DeviceAPIFactory INSTANCE = de.gtarc.chariot.deviceapi.impl.DeviceAPIFactoryImpl.init();

//    /**
//     * Returns a new object of class '<em>Property Impl</em>'.
//     * <!-- begin-user-doc -->
//     * <!-- end-user-doc -->
//     *
//     * @return a new object of class '<em>Property Impl</em>'.
//     */
//    Property createPropertyImpl();

    /**
     * Returns a new object of class '<em>Simple Property Impl</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Simple Property Impl</em>'.
     */
    SimpleProperty createSimplePropertyImpl();

    /**
     * Returns a new object of class '<em>Complex Property Impl</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Complex Property Impl</em>'.
     */
    ComplexProperty createComplexPropertyImpl();

    /**
     * Returns a new object of class '<em>Runtime Environment</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Runtime Environment</em>'.
     */
    RuntimeEnvironment createRuntimeEnvironment();

    /**
     * Returns a new object of class '<em>Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Component</em>'.
     */
    Component createComponent();

    /**
     * Returns a new object of class '<em>Actuating Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Actuating Device</em>'.
     */
    ActuatingDevice createActuatingDevice();

    /**
     * Returns a new object of class '<em>Sensing Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Sensing Device</em>'.
     */
    SensingDevice createSensingDevice();


}
