/**
 *
 */
package de.gtarc.commonapi;

import java.util.List;

public interface ComplexProperty extends Property<List<SimpleProperty>> {

    /**
     *
     * @return
     */
    List<SimpleProperty> getValue();

    /**
     *
     * @param value
     */
    void setValue(List<SimpleProperty> value);

    List<SimpleProperty> getSubProperties();

    void addSubProperty(SimpleProperty property);

    void removeSubProperty(SimpleProperty property);

} // ComplexProperty
