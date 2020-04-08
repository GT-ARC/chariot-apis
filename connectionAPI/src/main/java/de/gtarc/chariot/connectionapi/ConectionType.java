package de.gtarc.chariot.connectionapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ConectionType {
    /**
     * The '<em><b>MQTT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #MQTT_VALUE
     */
    MQTT(0, "MQTT", "MQTT"),

    /**
     * The '<em><b>WEBSOCKET</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #WEBSOCKET_VALUE
     */
    WEBSOCKET(1, "WEBSOCKET", "WEBSOCKET"),

    /**
     * The '<em><b>COAP</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #COAP_VALUE
     */
    COAP(2, "COAP", "COAP"),

    /**
     * The '<em><b>HTTP</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #HTTP_VALUE
     */
    HTTP(3, "HTTP", "HTTP");

    /**
     * The '<em><b>MQTT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MQTT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #MQTT
     */
    public static final int MQTT_VALUE = 0;

    /**
     * The '<em><b>WEBSOCKET</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WEBSOCKET</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #WEBSOCKET
     */
    public static final int WEBSOCKET_VALUE = 1;

    /**
     * The '<em><b>COAP</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>COAP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #COAP
     */
    public static final int COAP_VALUE = 2;

    /**
     * The '<em><b>HTTP</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HTTP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @see #HTTP
     */
    public static final int HTTP_VALUE = 3;

    /**
     * An array of all the '<em><b>Conection Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    private static final ConectionType[] VALUES_ARRAY = new ConectionType[]{MQTT, WEBSOCKET, COAP, HTTP,};

    /**
     * A public read-only list of all the '<em><b>Conection Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public static final List<ConectionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Conection Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * literal the literal.
     *
     * @return the matching enumerator or <code>null</code>.
     */
    public static ConectionType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConectionType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Conection Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * name the name.
     *
     * @return the matching enumerator or <code>null</code>.
     */
    public static ConectionType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ConectionType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Conection Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * value the integer value.
     *
     * @return the matching enumerator or <code>null</code>.
     */
    public static ConectionType get(int value) {
        switch (value) {
            case MQTT_VALUE:
                return MQTT;
            case WEBSOCKET_VALUE:
                return WEBSOCKET;
            case COAP_VALUE:
                return COAP;
            case HTTP_VALUE:
                return HTTP;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    private ConectionType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    @Override
    public String toString() {
        return literal;
    }

}
