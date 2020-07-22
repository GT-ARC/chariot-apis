/**
 *
 */
package de.gtarc.chariot.connectionapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum ConnectionStatus {

    CONNECTING(0, "CONNECTING", "CONNECTING"),

    CONNECTED(1, "CONNECTED", "CONNECTED"),


    DISCONNECTING(2, "DISCONNECTING", "DISCONNECTING"),


    DISCONNECTED(3, "DISCONNECTED", "DISCONNECTED"),

    LOGGINGIN(4, "LOGGINGIN", "LOGGINGIN"),


    FAIL(5, "FAIL", "FAIL"),


    UNDEFINED(6, "UNDEFINED", "UNDEFINED");


    public static final int CONNECTING_VALUE = 0;

    public static final int CONNECTED_VALUE = 1;


    public static final int DISCONNECTING_VALUE = 2;


    public static final int DISCONNECTED_VALUE = 3;

    public static final int LOGGINGIN_VALUE = 4;

    public static final int FAIL_VALUE = 5;


    public static final int UNDEFINED_VALUE = 6;

    private static final ConnectionStatus[] VALUES_ARRAY =
            new ConnectionStatus[]{
                    CONNECTING,
                    CONNECTED,
                    DISCONNECTING,
                    DISCONNECTED,
                    LOGGINGIN,
                    FAIL,
                    UNDEFINED,
            };


    public static final List<ConnectionStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));


    public static ConnectionStatus get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConnectionStatus result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }


    public static ConnectionStatus getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConnectionStatus result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    public static ConnectionStatus get(int value) {
        switch (value) {
            case CONNECTING_VALUE:
                return CONNECTING;
            case CONNECTED_VALUE:
                return CONNECTED;
            case DISCONNECTING_VALUE:
                return DISCONNECTING;
            case DISCONNECTED_VALUE:
                return DISCONNECTED;
            case LOGGINGIN_VALUE:
                return LOGGINGIN;
            case FAIL_VALUE:
                return FAIL;
            case UNDEFINED_VALUE:
                return UNDEFINED;
        }
        return null;
    }

    private final int value;


    private final String name;


    private final String literal;


    private ConnectionStatus(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    public int getValue() {
        return value;
    }


    public String getName() {
        return name;
    }


    public String getLiteral() {
        return literal;
    }

    @Override
    public String toString() {
        return literal;
    }

} //ConnectionStatus
