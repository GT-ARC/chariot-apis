package de.gtarc.chariot.deviceapi;

import de.gtarc.commonapi.Description;

public interface DeviceDescription extends Description {

    /* Returns the value of the '<em><b>Device Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Device Name</em>' attribute.
     * @see #setDeviceName(String)
     * @see deviceapi.DeviceAPIPackage#getDeviceDescription_DeviceName()
     * @model required="true"
     *
     */
    String getDeviceName();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.DeviceDescription#getDeviceName <em>Device Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Device Name</em>' attribute.
     * @see #getDeviceName()
     */
    void setDeviceName(String value);


    String getDeviceType();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.DeviceDescription#getDeviceType <em>Device Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Device Type</em>' attribute.
     * @see #getDeviceType()
     */
    void setDeviceType(String value);


}
