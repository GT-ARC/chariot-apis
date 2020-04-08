package de.gtarc.chariot.deviceapi;

import com.google.gson.annotations.JsonAdapter;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.util.DeviceInterfaceAdapter;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@JsonAdapter(DeviceInterfaceAdapter.class)
public interface Device extends Entity {


    DeviceStatus getDeviceStatus();

    Location getDeviceLocation();

    void setDeviceLocation(Location location);

    void setDeviceStatus(DeviceStatus value);

    /**
     * Returns the value of the '<em><b>Device Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device Description</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Device Description</em>' containment reference.
     * @model containment="true" required="true"
     * @see #setDeviceDescription(DeviceDescription)
     * @see deviceapi.DeviceAPIPackage#getDevice_DeviceDescription()
     */
    DeviceDescription getDeviceDescription();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getDeviceDescription <em>Device Description</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Device Description</em>' containment reference.
     * @see #getDeviceDescription()
     */
    void setDeviceDescription(DeviceDescription value);

    /**
     * Returns the value of the '<em><b>Hardware Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hardware Description</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Hardware Description</em>' containment reference.
     * @model containment="true" required="true"
     * @see #setHardwareDescription(HardwareDescription)
     * @see deviceapi.DeviceAPIPackage#getDevice_HardwareDescription()
     */
    HardwareDescription getHardwareDescription();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getHardwareDescription <em>Hardware Description</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Hardware Description</em>' containment reference.
     * @see #getHardwareDescription()
     */
    void setHardwareDescription(HardwareDescription value);

    /**
     * Returns the value of the '<em><b>Optional Properties</b></em>' containment reference list.
     * The list contents are of type {@link deviceapi.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Optional Properties</em>' containment reference list.
     * @model containment="true"
     * @see deviceapi.DeviceAPIPackage#getDevice_OptionalProperties()
     */
    List<Property> getOptionalProperties();

    /**
     * Returns the value of the '<em><b>Mandatory Properties</b></em>' containment reference list.
     * The list contents are of type {@link deviceapi.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Mandatory Properties</em>' containment reference list.
     * @model containment="true"
     * @see deviceapi.DeviceAPIPackage#getDevice_MandatoryProperties()
     */
    List<Property> getProperties();

    /**
     * Returns the value of the '<em><b>Uid</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uid</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Uid</em>' attribute.
     * @model dataType="deviceapi.UUID" required="true"
     * @see #setUid(UUID)
     * @see deviceapi.DeviceAPIPackage#getDevice_Uid()
     */
    UUID getUUIdentifier();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getUid <em>Uid</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Uid</em>' attribute.
     * @see #getUid()
     */
    void setUUIdentifier(UUID value);

    /**
     * Returns the value of the '<em><b>Namespace Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Namespace Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Namespace Uri</em>' attribute.
     * @model dataType="deviceapi.URI" required="true"
     * @see #setNamespaceUri(URI)
     * @see deviceapi.DeviceAPIPackage#getDevice_NamespaceUri()
     */
    URI getNamespaceUri();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getNamespaceUri <em>Namespace Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Namespace Uri</em>' attribute.
     * @see #getNamespaceUri()
     */
    void setNamespaceUri(URI value);

    /**
     * Returns the value of the '<em><b>Vendor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vendor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Vendor</em>' attribute.
     * @model required="true"
     * @see #setVendor(String)
     * @see deviceapi.DeviceAPIPackage#getDevice_Vendor()
     */
    String getVendor();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getVendor <em>Vendor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Vendor</em>' attribute.
     * @see #getVendor()
     */
    void setVendor(String value);

    /**
     * Returns the value of the '<em><b>Handler</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Handler</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Handler</em>' containment reference.
     * @model containment="true" required="true"
     * @see #setConnectionHandler(DeviceConnection)
     * @see deviceapi.DeviceAPIPackage#getDevice_Handler()
     */
    DeviceConnection getConnectionHandler();

    /**
     * Sets the value of the '{@link de.gtarc.chariot.deviceapi.Device#getHandler <em>Handler</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Handler</em>' containment reference.
     * @see #getConnectionHandler()
     */
    void setConnectionHandler(DeviceConnection value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @model kind="operation"
     */
    String getName();

    void setName(String value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @model kind="operation"
     */
    String getFriendlyName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @model
     */
    void setFriendlyName(String friendlyName);

    /**
     * add new mandatory property
     *
     * @param property
     */
    void addProperty(Property property);


    /**
     * Add a new Operation
     *
     * @param operation
     */
    void addOperation(Operation operation);

    List<Operation> getOperations();

    String getPlatform();

    /**
     * Sets the value of the '{@link deviceapi.ActuatingDevice#getPlatform <em>Platform</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Platform</em>' attribute.
     * @see #getPlatform()
     */
    void setPlatform(String value);

    String getType();

    void setType(String type);
}
