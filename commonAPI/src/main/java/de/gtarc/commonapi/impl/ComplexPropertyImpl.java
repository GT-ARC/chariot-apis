/**
 *
 */
package de.gtarc.commonapi.impl;

import com.google.gson.annotations.JsonAdapter;
import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.PropertyInterfaceAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gtarc.device.model.api.impl.gtarc.isco.api.model.properties.impl.ComplexPropertyImpl#getSubProperties <em>Sub Properties</em>}</li>
 * </ul>
 *
 *
 */
@JsonAdapter(PropertyInterfaceAdapter.class)
public class ComplexPropertyImpl implements ComplexProperty {

    protected static final String LABEL_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     *
     * @ordered
     */
    protected String key = LABEL_EDEFAULT;

    protected List<Property> subProperties;

    public ComplexPropertyImpl() {
        super();
    }

    public List<Property> getSubProperties() {
        if (subProperties == null) {
            subProperties = new ArrayList<Property>();
        }
        return subProperties;
    }

    public void addSubProperty(Property property) {
        if (subProperties == null) {
            subProperties = new ArrayList<Property>();
        }
        subProperties.add(property);
    }

    public void removeSubProperty(Property property) {
        subProperties.remove(property);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public void setKey(String newKey) {
        key = newKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (key: ");
        result.append(key);
        result.append(')');
        return result.toString();


    }

} //ComplexPropertyImpl
