package de.gtarc.chariot.humanapi.impl;

public enum Action {
    NAME("name"),
    DESCRIPTION("description");

    private final String value;

    private Action(final String typeName) {
        this.value = typeName;
    }

    static Action get(final String value) throws Exception {
        for (final Action item : values()) {
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
