package de.gtarc.chariot.deviceapi;

import java.util.List;
import java.util.UUID;

public interface RuntimeEnvironment {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Id</em>' attribute.
     * @model dataType="deviceapi.UUID" required="true"
     * @see #setId(UUID)
     * @see deviceapi.DeviceAPIPackage#getRuntimeEnvironment_Id()
     */
    UUID getId();

    /**
     * Sets the value of the '{@link deviceapi.RuntimeEnvironment#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     */
    void setId(UUID value);

    /**
     * Returns the value of the '<em><b>Platform</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Platform</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Platform</em>' attribute.
     * @model required="true"
     * @see #setPlatform(String)
     * @see deviceapi.DeviceAPIPackage#getRuntimeEnvironment_Platform()
     */
    String getPlatform();

    /**
     * Sets the value of the '{@link deviceapi.RuntimeEnvironment#getPlatform <em>Platform</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Platform</em>' attribute.
     * @see #getPlatform()
     */
    void setPlatform(String value);

    /**
     * Returns the value of the '<em><b>Re Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Re Status</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Re Status</em>' attribute.
     * @model required="true"
     * @see #setReStatus(int)
     * @see deviceapi.DeviceAPIPackage#getRuntimeEnvironment_ReStatus()
     */
    int getReStatus();

    /**
     * Sets the value of the '{@link deviceapi.RuntimeEnvironment#getReStatus <em>Re Status</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Re Status</em>' attribute.
     * @see #getReStatus()
     */
    void setReStatus(int value);

    /**
     * Returns the value of the '<em><b>Managed Devices</b></em>' containment reference list.
     * The list contents are of type {@link de.gtarc.chariot.deviceapi.Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Managed Devices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Managed Devices</em>' containment reference list.
     * @model containment="true"
     * @see deviceapi.DeviceAPIPackage#getRuntimeEnvironment_ManagedDevices()
     */
    List<Device> getManagedDevices();

}
