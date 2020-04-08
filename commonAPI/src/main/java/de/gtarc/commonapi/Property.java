/**
 *
 */
package de.gtarc.commonapi;


import com.google.gson.annotations.JsonAdapter;
import de.gtarc.commonapi.utils.PropertyInterfaceAdapter;

@JsonAdapter(PropertyInterfaceAdapter.class)
public interface Property {

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the '{@link deviceapi.Property#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setKey(String value);

} // Property
