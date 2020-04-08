package de.gtarc.chariot.humanapi.impl;

public enum TaskStatus {
    PROCESSING("Processing"), COMPLETED("Completed"), PENDING("Pending");

    private String value;

    private TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
