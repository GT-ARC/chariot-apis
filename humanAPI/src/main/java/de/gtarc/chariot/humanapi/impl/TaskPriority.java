package de.gtarc.chariot.humanapi.impl;

/***
 * @author cemakpolat
 */
public enum TaskPriority {
    LOW("Low"), HIGH("High");

    private String value;

    private TaskPriority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
