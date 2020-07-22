package de.gtarc.chariot.humanapi.impl;

public enum Account {
    NAME("name"),
    USER_ID("userId"),
    LOGIN_NAME("login_name"),
    PASSWORD("password");

    private final String value;

    private Account(final String typeName) {
        this.value = typeName;
    }

    static Account get(final String value) throws Exception {
        for (final Account item : values()) {
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
