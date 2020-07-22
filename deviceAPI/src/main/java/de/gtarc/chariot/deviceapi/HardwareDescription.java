package de.gtarc.chariot.deviceapi;

public interface HardwareDescription {


    Object getCPU();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.HardwareDescription#getCPU <em>CPU</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>CPU</em>' attribute.
     * @see #getCPU()
     */
    void setCPU(Object value);


    Object getMemory();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.HardwareDescription#getMemory <em>Memory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Memory</em>' attribute.
     * @see #getMemory()
     */
    void setMemory(Object value);

    String getConnectiontype();


    void setConnectiontype(String value);

}

