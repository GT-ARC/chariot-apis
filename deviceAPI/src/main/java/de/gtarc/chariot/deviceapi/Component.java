package de.gtarc.chariot.deviceapi;

import de.gtarc.commonapi.Property;

import java.util.List;

public interface Component extends IComponent {
    /**
     * Returns the value of the '<em><b>Component Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Component Id</em>' attribute.
     * @model dataType="deviceapi.componentId" required="true"
     * @generated
     * @see #setComponentId(String)
     * @see deviceapi.DeviceAPIPackage#getComponent_ComponentId()
     */
    String getComponentId();

    /**
     * Sets the value of the '{@link deviceapi.Component#getComponentId <em>Component Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Component Id</em>' attribute.
     * @generated
     * @see #getComponentId()
     */
    void setComponentId(String value);

    /**
     * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
     * The list contents are of type {@link de.gtarc.chariot.deviceapi.Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Devices</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see deviceapi.DeviceAPIPackage#getComponent_Devices()
     */
    List<Device> getDevices();

    void setDevices(List<Device> list);

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link deviceapi.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see deviceapi.DeviceAPIPackage#getComponent_Properties()
     */
    List<Property> getProperties();

    void setProperties(List<Property> list);

    /**
     * Returns the value of the '<em><b>Components</b></em>' containment reference list.
     * The list contents are of type {@link deviceapi.Component}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Components</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see deviceapi.DeviceAPIPackage#getComponent_Components()
     */
    List<Component> getComponents();

    void setComponents(List<Component> list);

}
