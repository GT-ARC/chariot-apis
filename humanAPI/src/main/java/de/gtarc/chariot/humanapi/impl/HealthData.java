package de.gtarc.chariot.humanapi.impl;

public enum HealthData {
    HUMAN_ID("humanId"),
    TIMESTAMP("timestamp"),
    HEART_RATE("heartRate"),
    STEP_STATUS("deadline"),
    FEEL_STATUS("status"),
    WORK_STATUS("description"),
    STATUS("description");

    private final String value;

    private HealthData(final String typeName) {
        this.value = typeName;
    }

    static HealthData get(final String value) throws Exception {
        for (final HealthData item : values()) {
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