/**
 *
 */
package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.SimpleProperty;


import java.util.ArrayList;
import java.util.List;

public class ComplexPropertyImpl extends PropertyImpl<List<SimpleProperty>> implements ComplexProperty {


    protected List<SimpleProperty> value;

    public ComplexPropertyImpl() {
        super();
    }

    @Override
    public List<SimpleProperty> getValue() {
        return value;
    }

    @Override
    public void setValue(List<SimpleProperty> value) {
        this.value = value;
    }

    public List<SimpleProperty> getSubProperties() {
        if (value == null) {
            value = new ArrayList<SimpleProperty>();
        }
        return value;
    }

    public void addSubProperty(SimpleProperty property) {
        if (value == null) {
            value = new ArrayList<SimpleProperty>();
        }
        value.add(property);
    }

    public void removeSubProperty(SimpleProperty property) {
        value.remove(property);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (key: ");
        result.append(key);
        result.append(')');
        return result.toString();
    }

} //ComplexPropertyImpl
