package de.gtarc.chariot.deviceapi;

public interface DeviceStatus {

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
