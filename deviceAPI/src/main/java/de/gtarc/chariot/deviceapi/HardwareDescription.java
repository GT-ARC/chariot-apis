package de.gtarc.chariot.deviceapi;

public interface HardwareDescription {

    /**
     * Returns the value of the '<em><b>CPU</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CPU</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>CPU</em>' attribute.
     * @model
     * @see #setCPU(Object)
     * @see deviceapi.DeviceAPIPackage#getHardwareDescription_CPU()
     */
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

    /**
     * Returns the value of the '<em><b>Memory</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Memory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Memory</em>' attribute.
     * @model
     * @see #setMemory(Object)
     * @see deviceapi.DeviceAPIPackage#getHardwareDescription_Memory()
     */
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

    /**
     * Returns the value of the '<em><b>Connectiontype</b></em>' attribute.
     * The literals are from the enumeration {@link deviceapi.ConectionType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connectiontype</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Connectiontype</em>' attribute.
     * @model required="true"
     * @see deviceapi.ConectionType
     * @see #setConnectiontype(ConectionType)
     * @see deviceapi.DeviceAPIPackage#getHardwareDescription_Connectiontype()
     */
    String getConnectiontype();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.HardwareDescription#getConnectiontype <em>Connectiontype</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Connectiontype</em>' attribute.
     * @see deviceapi.ConectionType
     * @see #getConnectiontype()
     */
    void setConnectiontype(String value);

}

