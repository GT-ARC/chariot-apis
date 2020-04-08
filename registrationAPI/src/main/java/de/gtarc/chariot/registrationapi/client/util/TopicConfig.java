package de.gtarc.chariot.registrationapi.client.util;

public class TopicConfig {

    public static final String registerBase = "register";
    public static final String registerResponseBase = "register/result/";

    public static String getRegisterTopic() {

        return registerBase;
    }

    public static String getRegisterResponseTopic(String deviceId) {

        return registerResponseBase + deviceId;
    }

    public static String getUpdateTopic() {
        return registerBase;
    }

    public static String getUpdateResponseTopic(String deviceId) {
        return registerResponseBase + deviceId;
    }

    public static String getRemovalTopic() {
        return registerBase;
    }

    public static String getRemovalResponseTopic(String deviceId) {
        return registerResponseBase + deviceId;
    }

    public static String getDeactivationTopic() {
        return registerBase;
    }

    public static String getDeactivationResponseTopic(String deviceId) {
        return registerResponseBase + deviceId;
    }

    public static String getKeepAliveTopic() {
        return registerBase;
    }

    public static String getKeepAliveResponseTopic(String deviceId) {
        return registerResponseBase + deviceId;
    }

    public static String getReRegistrationTopic() {
        return registerBase;
    }

    public static String getReRegistrationResponseTopic(String deviceId) {
        return registerResponseBase + deviceId;
    }
}
