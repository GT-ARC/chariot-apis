package de.gtarc.chariot.humanapi.impl;

public enum Preference {
    NAME("name"),
    DESCRIPTION("description");

    private final String value;

    private Preference(final String typeName) {
        this.value = typeName;
    }

    static Preference get(final String value) throws Exception {
        for (final Preference item : values()) {
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
