/**
 *
 */
package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.Property;

public abstract class PropertyImpl<T> implements Property<T> {

    protected static final String KEY_EDEFAULT = null;

    private static final long TIMESTAMP_EDEFAULT = 0;

    private static final String TYPE_EDEFAULT = "";

    private static final String UNIT_EDEFAULT = null;

    private static final boolean WRITABLE_EDEFAULT = false;


    protected long timestamp = TIMESTAMP_EDEFAULT;

    protected String key = KEY_EDEFAULT;

    protected String type = TYPE_EDEFAULT;

    protected String unit = UNIT_EDEFAULT;

    protected boolean writable = WRITABLE_EDEFAULT;

    public PropertyImpl() {
        super();
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String newKey) {
        if (newKey != null) {
            key = newKey;
        }
    }

    @Override
    public String getUnit() {
        return unit;
    }


    @Override
    public void setUnit(String newUnit) {
        if (newUnit != null) {
            unit = newUnit;
        }

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String newType) {
        if (newType != null) {
            type = newType;
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

    @Override
    public boolean getWritable() {
        return writable;
    }

    @Override
    public void setWritable(boolean writable) {
        this.writable = writable;
    }

} //PropertyImpl
