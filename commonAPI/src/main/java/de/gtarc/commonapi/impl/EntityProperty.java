package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.Property;

public class EntityProperty implements   Property {
    private static final long TIMESTAMP_DEFAULT = 0;
    private static final String KEY_DEFAULT = "";
    private static final String TYPE_DEFAULT = "";
    private static final Object VALUE_DEFAULT = null;
    private static final String UNIT_DEFAULT = null;
    private static final Double MIN_DEFAULT = 0.0;
    private static final Double MAX_DEFAULT = 0.0;
    private static final boolean WRITABLE_DEFAULT = false;


    protected long timestamp = TIMESTAMP_DEFAULT;
    protected String key = KEY_DEFAULT;
    protected String type = TYPE_DEFAULT;
    protected Object value = VALUE_DEFAULT;
    protected String unit = UNIT_DEFAULT;
    protected boolean writable = WRITABLE_DEFAULT;
    protected Double min = MIN_DEFAULT;
    protected Double max = MAX_DEFAULT;

    public EntityProperty() {
        super();
    }

    public EntityProperty(long timestamp, String key, String type, Object value, String unit, boolean writable) {
        this.key = key;
        this.type = type;
        this.value = value;
        this.writable = writable;
        this.unit = unit;
        this.timestamp = timestamp;
    }
    public EntityProperty(long timestamp, String key, String type, Object value, String unit, boolean writable, Double min, Double max) {
        this.key = key;
        this.type = type;
        this.value = value;
        this.writable = writable;
        this.unit = unit;
        this.timestamp = timestamp;
        this.max = max;
        this.min = min;
    }
    public EntityProperty(String key, Object value, long timestamp) {
        this.key = key;
        this.value = value;
        this.setTimestamp(timestamp);
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public void setTimestamp(long timestamp) {

    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public void setKey(String value) {

    }

    @Override
    public String getUnit() {
        return null;
    }

    @Override
    public void setUnit(String unit) {

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public boolean getWritable() {
        return false;
    }

    @Override
    public void setWritable(boolean writable) {

    }

    public Double getMin() {
        return min;
    }


    public void setMin(Double min) {
        this.min = min;
    }


    public Double getMax() {
        return  max;
    }


    public void setMax(Double max) {
        this.max = max;
    }
}
