package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.HumanProperty;

public class HumanPropertyImpl implements HumanProperty {

    private static final long TIMESTAMP_EDEFAULT = 5;

    private static final String KEY_EDEFAULT = "";

    private static final String TYPE_EDEFAULT = "";

    private static final Object VALUE_EDEFAULT = null;

    private static final String UNIT_EDEFAULT = null;

    private static final boolean WRITABLE_EDEFAULT = false;

    private static final Double MIN_DEFAULT = 0.0;

    private static final Double MAX_DEFAULT = 0.0;

    protected long timestamp = TIMESTAMP_EDEFAULT;

    protected String key = KEY_EDEFAULT;

    protected String type = TYPE_EDEFAULT;

    protected Object value = VALUE_EDEFAULT;

    protected String unit = UNIT_EDEFAULT;

    protected boolean writable = WRITABLE_EDEFAULT;

    protected Double min = MIN_DEFAULT;
    protected Double max = MAX_DEFAULT;

    public HumanPropertyImpl() {
        super();
    }

    public HumanPropertyImpl(long timestamp, String key, String type, Object value,  String unit, boolean writable) {
        this.key = key;
        this.type = type;
        this.value = value;
        this.writable = writable;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    public HumanPropertyImpl(String key, Object value, long timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;

    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean getWritable() {
        return writable;
    }

    @Override
    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public Double getMin() {
        return min;
    }

    @Override
    public void setMin(Double min) {
        this.min = min;
    }

    @Override
    public Double getMax() {
        return max;
    }

    @Override
    public void setMax(Double max) {
        this.max = max;
    }

}
