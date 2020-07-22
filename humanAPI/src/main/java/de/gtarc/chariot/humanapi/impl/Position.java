package de.gtarc.chariot.humanapi.impl;

public enum Position {
    POSITION_NAME("position_name"),
    XAXIS("xaxis"),
    YAXIS("yaxis"),
    ZAXIS("zaxis");
    
    private final String value;

    private Position(final String typeName) {
        this.value = typeName;
    }

    static Position get(final String value) throws Exception {
        for (final Position item : values()) {
            if (item.getValue().equalsIgnoreCase(value)) {
                return item;
            }
        }
        throw new Exception(String.format("Unknown name type '%s'", value));
    }

    String getValue() {
        return this.value;
    }
}
