/**
 *
 */
package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.Property;

public class PropertyImpl implements Property {

    protected static final String KEY_EDEFAULT = null;

    protected String key = KEY_EDEFAULT;

    public PropertyImpl() {
        super();
    }


    public String getKey() {
        return key;
    }

    public void setKey(String newKey) {
        if (newKey != null) {
            key = newKey;
        }
    }


    @Override
    public String toString() {

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (key: ");
        result.append(key);
        result.append(')');
        return result.toString();
    }

} //PropertyImpl
