/**
 */
package com.gtarc.chariot.api.model.domainmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Domain</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Smart city domains
 * <!-- end-model-doc -->
 * @see com.gtarc.chariot.api.model.domainmodel.DomainmodelPackage#getDomain()
 * @model
 * @generated
 */
public enum Domain implements Enumerator {
	/**
	 * The '<em><b>SMART CITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMART_CITY_VALUE
	 * @generated
	 * @ordered
	 */
	SMART_CITY(0, "SMART_CITY", "Smart City"),

	/**
	 * The '<em><b>TRANSPORTATION AND MOBILITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORTATION_AND_MOBILITY_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORTATION_AND_MOBILITY(1, "TRANSPORTATION_AND_MOBILITY", "Transportation and Mobility"),

	/**
	 * The '<em><b>LIVING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIVING_VALUE
	 * @generated
	 * @ordered
	 */
	LIVING(2, "LIVING", "Living"),

	/**
	 * The '<em><b>BUILDINGS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUILDINGS_VALUE
	 * @generated
	 * @ordered
	 */
	BUILDINGS(3, "BUILDINGS", "Buildings"),

	/**
	 * The '<em><b>ECONOMY AND PEOPLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ECONOMY_AND_PEOPLE_VALUE
	 * @generated
	 * @ordered
	 */
	ECONOMY_AND_PEOPLE(4, "ECONOMY_AND_PEOPLE", "Economy and People"),

	/**
	 * The '<em><b>GOVERNMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOVERNMENT_VALUE
	 * @generated
	 * @ordered
	 */
	GOVERNMENT(5, "GOVERNMENT", "Government"),

	/**
	 * The '<em><b>NATURAL RESOURCES AND ENERGY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NATURAL_RESOURCES_AND_ENERGY_VALUE
	 * @generated
	 * @ordered
	 */
	NATURAL_RESOURCES_AND_ENERGY(6, "NATURAL_RESOURCES_AND_ENERGY", "Natural Resources and Energy");

	/**
	 * The '<em><b>SMART CITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMART CITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMART_CITY
	 * @model literal="Smart City"
	 * @generated
	 * @ordered
	 */
	public static final int SMART_CITY_VALUE = 0;

	/**
	 * The '<em><b>TRANSPORTATION AND MOBILITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSPORTATION AND MOBILITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSPORTATION_AND_MOBILITY
	 * @model literal="Transportation and Mobility"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSPORTATION_AND_MOBILITY_VALUE = 1;

	/**
	 * The '<em><b>LIVING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIVING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIVING
	 * @model literal="Living"
	 * @generated
	 * @ordered
	 */
	public static final int LIVING_VALUE = 2;

	/**
	 * The '<em><b>BUILDINGS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILDINGS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUILDINGS
	 * @model literal="Buildings"
	 * @generated
	 * @ordered
	 */
	public static final int BUILDINGS_VALUE = 3;

	/**
	 * The '<em><b>ECONOMY AND PEOPLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ECONOMY AND PEOPLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ECONOMY_AND_PEOPLE
	 * @model literal="Economy and People"
	 * @generated
	 * @ordered
	 */
	public static final int ECONOMY_AND_PEOPLE_VALUE = 4;

	/**
	 * The '<em><b>GOVERNMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GOVERNMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GOVERNMENT
	 * @model literal="Government"
	 * @generated
	 * @ordered
	 */
	public static final int GOVERNMENT_VALUE = 5;

	/**
	 * The '<em><b>NATURAL RESOURCES AND ENERGY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NATURAL RESOURCES AND ENERGY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NATURAL_RESOURCES_AND_ENERGY
	 * @model literal="Natural Resources and Energy"
	 * @generated
	 * @ordered
	 */
	public static final int NATURAL_RESOURCES_AND_ENERGY_VALUE = 6;

	/**
	 * An array of all the '<em><b>Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Domain[] VALUES_ARRAY =
		new Domain[] {
			SMART_CITY,
			TRANSPORTATION_AND_MOBILITY,
			LIVING,
			BUILDINGS,
			ECONOMY_AND_PEOPLE,
			GOVERNMENT,
			NATURAL_RESOURCES_AND_ENERGY,
		};

	/**
	 * A public read-only list of all the '<em><b>Domain</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Domain> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Domain result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Domain result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Domain</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Domain get(int value) {
		switch (value) {
			case SMART_CITY_VALUE: return SMART_CITY;
			case TRANSPORTATION_AND_MOBILITY_VALUE: return TRANSPORTATION_AND_MOBILITY;
			case LIVING_VALUE: return LIVING;
			case BUILDINGS_VALUE: return BUILDINGS;
			case ECONOMY_AND_PEOPLE_VALUE: return ECONOMY_AND_PEOPLE;
			case GOVERNMENT_VALUE: return GOVERNMENT;
			case NATURAL_RESOURCES_AND_ENERGY_VALUE: return NATURAL_RESOURCES_AND_ENERGY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Domain(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Domain
