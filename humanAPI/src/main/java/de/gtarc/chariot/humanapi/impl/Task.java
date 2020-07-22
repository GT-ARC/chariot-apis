package de.gtarc.chariot.humanapi.impl;

public enum Task {
    NAME("name"),
    REQUIRED_SKILLS("required_skills"),
    PRIORITY("priority"),
    DEADLINE("deadline"),
    STATUS("status"),
    DESCRIPTION("description");

    private final String value;

    private Task(final String val) {
        this.value = val;
    }

    static Task get( final String value) throws Exception {
        for (final Task item : values()) {
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