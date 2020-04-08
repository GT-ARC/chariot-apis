/**
 *
 */
package de.gtarc.chariot.connectionapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration 'Status',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see deviceapi.connection.impl.ConnectionPackageImpl#getConnectionStatus()
 *
 */
public enum ConnectionStatus {
    /**
     * The 'CONNECTING' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONNECTING_VALUE
     *
     *
     */
    CONNECTING(0, "CONNECTING", "CONNECTING"),

    /**
     * The 'CONNECTED' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONNECTED_VALUE
     *
     *
     */
    CONNECTED(1, "CONNECTED", "CONNECTED"),

    /**
     * The 'DISCONNECTING' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISCONNECTING_VALUE
     *
     *
     */
    DISCONNECTING(2, "DISCONNECTING", "DISCONNECTING"),

    /**
     * The 'DISCONNECTED' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISCONNECTED_VALUE
     *
     *
     */
    DISCONNECTED(3, "DISCONNECTED", "DISCONNECTED"),

    /**
     * The 'LOGGINGIN' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LOGGINGIN_VALUE
     *
     *
     */
    LOGGINGIN(4, "LOGGINGIN", "LOGGINGIN"),

    /**
     * The 'FAIL' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FAIL_VALUE
     *
     *
     */
    FAIL(5, "FAIL", "FAIL"),

    /**
     * The 'UNDEFINED' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNDEFINED_VALUE
     *
     *
     */
    UNDEFINED(6, "UNDEFINED", "UNDEFINED");

    /**
     * The 'CONNECTING' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'CONNECTING' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CONNECTING
     *
     *
     */
    public static final int CONNECTING_VALUE = 0;

    /**
     * The 'CONNECTED' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'CONNECTED' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CONNECTED
     *
     *
     */
    public static final int CONNECTED_VALUE = 1;

    /**
     * The 'DISCONNECTING' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'DISCONNECTING' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISCONNECTING
     *
     *
     */
    public static final int DISCONNECTING_VALUE = 2;

    /**
     * The 'DISCONNECTED' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'DISCONNECTED' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISCONNECTED
     *
     *
     */
    public static final int DISCONNECTED_VALUE = 3;

    /**
     * The 'LOGGINGIN' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'LOGGINGIN' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LOGGINGIN
     *
     *
     */
    public static final int LOGGINGIN_VALUE = 4;

    /**
     * The 'FAIL' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'FAIL' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FAIL
     *
     *
     */
    public static final int FAIL_VALUE = 5;

    /**
     * The 'UNDEFINED' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of 'UNDEFINED' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNDEFINED
     *
     *
     */
    public static final int UNDEFINED_VALUE = 6;

    /**
     * An array of all the 'Status' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
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

    /**
     * A public read-only list of all the 'Status' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public static final List<ConnectionStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the 'Status' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     *
     */
    public static ConnectionStatus get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConnectionStatus result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the 'Status' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     *
     */
    public static ConnectionStatus getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConnectionStatus result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the 'Status' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     *
     */
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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    private ConnectionStatus(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     */
    @Override
    public String toString() {
        return literal;
    }

} //ConnectionStatus
