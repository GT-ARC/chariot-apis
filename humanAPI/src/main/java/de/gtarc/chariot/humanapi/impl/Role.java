package de.gtarc.chariot.humanapi.impl;

public enum Role {
    NAME("name"),
    DESCRIPTION("description");

    private final String value;

    private Role(final String typeName) {
        this.value = typeName;
    }

    static Role get(final String value) throws Exception {
        for (final Role item : values()) {
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
