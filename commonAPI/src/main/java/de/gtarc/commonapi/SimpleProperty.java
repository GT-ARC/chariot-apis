/**
 *
 */
package de.gtarc.commonapi;


public interface SimpleProperty extends Property {
    /**
     *
     * @return
     */
    Object getValue();

    /**
     *
     * @param value
     */
    void setValue(Object value);

    /**
     *
     * @return
     */
    String getUnit();

    /**
     *
     * @param value
     */
    void setUnit(String unit);

    /**
     *
     * @return
     */
    String getType();

    /**
     *
     * @param value
     */
    void setType(String type);


} // SimpleProperty
