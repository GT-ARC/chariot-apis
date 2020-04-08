/**
 *
 */
package de.gtarc.commonapi;

import java.util.List;

public interface ComplexProperty extends Property {
    /**
     * Returns the value of the '<em><b>Sub Properties</b></em>' containment reference list.
     * The list contents are of type {@link deviceapi.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Properties</em>' containment reference list.
     *
     */

    List<Property> getSubProperties();

    void addSubProperty(Property property);

    void removeSubProperty(Property property);

} // ComplexProperty
