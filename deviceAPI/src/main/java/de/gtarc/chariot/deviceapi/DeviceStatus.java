package de.gtarc.chariot.deviceapi;

public interface DeviceStatus {

    /**
     * Returns the value of the '<em><b>Cpu Usage</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cpu Usage</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Cpu Usage</em>' attribute.
     * @model
     * @see #setCpuUsage(Double)
     * @see deviceapi.DeviceAPIPackage#getDeviceStatus_CpuUsage()
     */
    Double getCpuUsage();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.DeviceStatus#getCpuUsage <em>Cpu Usage</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Cpu Usage</em>' attribute.
     * @see #getCpuUsage()
     */
    void setCpuUsage(Double value);

    /**
     * Returns the value of the '<em><b>Memory Usage</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Memory Usage</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Memory Usage</em>' attribute.
     * @model
     * @see #setMemoryUsage(Double)
     * @see deviceapi.DeviceAPIPackage#getDeviceStatus_MemoryUsage()
     */
    Double getMemoryUsage();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.DeviceStatus#getMemoryUsage <em>Memory Usage</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Memory Usage</em>' attribute.
     * @see #getMemoryUsage()
     */
    void setMemoryUsage(Double value);

}
