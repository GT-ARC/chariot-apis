package de.gtarc.chariot.humanapi.impl;

public enum Skill {
    NAME("name"),
    DESCRIPTION("description");

    private final String value;

    private Skill(final String value) {
        this.value = value;
    }

    static Skill get( final String value) throws Exception {
        for (final Skill item : values()) {
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
