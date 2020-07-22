package de.gtarc.chariot.humanapi.impl;

public enum Permission {
    NAME("name"),
    DESCRIPTION("description");

    private final String value;

    private Permission(final String typeName) {
        this.value = typeName;
    }

    static Permission get(final String value) throws Exception {
        for (final Permission item : values()) {
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
