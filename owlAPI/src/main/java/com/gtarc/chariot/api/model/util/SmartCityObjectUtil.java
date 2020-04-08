package com.gtarc.chariot.api.model.util;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.SWRLRule;

import com.gtarc.chariot.api.model.domainmodel.Accessibility;
import com.gtarc.chariot.api.model.domainmodel.Actuator;
import com.gtarc.chariot.api.model.domainmodel.Device;
import com.gtarc.chariot.api.model.domainmodel.Domain;
import com.gtarc.chariot.api.model.domainmodel.DomainmodelFactory;
import com.gtarc.chariot.api.model.domainmodel.Endpoint;
import com.gtarc.chariot.api.model.domainmodel.MeasuringMode;
import com.gtarc.chariot.api.model.domainmodel.Owner;
import com.gtarc.chariot.api.model.domainmodel.Parameter;
import com.gtarc.chariot.api.model.domainmodel.Sensor;
import com.gtarc.chariot.api.model.domainmodel.Service;
import com.gtarc.chariot.api.model.domainmodel.SmartCityObject;
import com.gtarc.chariot.api.model.spatialdata.Location;
import com.gtarc.chariot.api.model.spatialdata.SpatialObject;

/**
 * Utility class for creating smart city objects.
 * 
 * @author ckuster
 *
 */
public final class SmartCityObjectUtil {
	
	private static final String EMPTY_STRING = "";

	private static final String QUOTATION_MARK = "\"";

	private static final DomainmodelFactory factory = DomainmodelFactory.eINSTANCE;
	
	/**
	 * Default UUID used in {@link SmartCityObject#getId()}
	 */
	public static final String DEFAULT_UUID = "00000000-0000-0000-0000-000000000000";

	private SmartCityObjectUtil() {
	}
	
	/**
	 * Create a measuring device.
	 * 
	 * @param location The location of the device.
	 * @param operationalArea The area the device is operating in.
	 * @param output The typed output of the device.
	 * @param type A URI that points to an entity within an ontology. The entity should represent a device type.
	 * @return A measuring device
	 */
	public static Sensor createSensor(Location location, SpatialObject operationalArea, Parameter output, IRI type) {
		if (output == null) {
			throw new IllegalArgumentException("output is null!");
		}
		Sensor device = factory.createSensor();
		initializeSmartCityObject(device, null, null, null);
		initializeDevice(location, operationalArea, null, type, device);
		device.setOutput(output);
		device.setMode(MeasuringMode.UNDEFINED);
		return device;
	}

	/**
	 * Create a measuring device.
	 * 
	 * @param location The location of the device.
	 * @param operationalArea The area the device is operating in.
	 * @param owner The owner of the device.
	 * @param output The typed output of the device.
	 * @param mode The measuring mode of the device.
	 * @param domains The domains the device can be located in.
	 * @param accessibility The mode of accessibility.
	 * @param type A URI that points to an entity within an ontology. The entity should represent a device type.
	 * @param endpoint The endpoint of the device; can be used to communicate with the device.
	 * @return A measuring device
	 */
	public static Sensor createSensor(Location location, SpatialObject operationalArea, Owner owner,
			Parameter output, MeasuringMode mode, List<Domain> domains, Accessibility accessibility, IRI type,
			Endpoint endpoint) {
		if (output == null) {
			throw new IllegalArgumentException("output is null!");
		}
		if (mode == null) {
			throw new IllegalArgumentException("mode is null!");
		}
		Sensor device = factory.createSensor();
		initializeSmartCityObject(device, domains, accessibility, endpoint);
		initializeDevice(location, operationalArea, owner, type, device);
		device.setOutput(output);
		device.setMode(mode);
		return device;
	}
	
	/**
	 * Create an actuating device.
	 * 
	 * @param location The location of the device.
	 * @param operationalArea The area the device is operating in.
	 * @param effect The outcome of triggering the device.
	 * @param type A URI that points to an entity within an ontology. The entity should represent a device type.
	 * @return A measuring device
	 */
	public static Actuator createActuator(Location location, SpatialObject operationalArea, SWRLRule effect, IRI type) {
		if (effect == null || (effect.head().count() + effect.body().count()) == 0) {
			throw new IllegalArgumentException("effect is null or empty!");
		}
		Actuator device = factory.createActuator();
		initializeSmartCityObject(device, null, null, null);
		initializeDevice(location, operationalArea, null, type, device);
		device.setEffect(effect);
		return device;
	}
	
	/**
	 * Create an actuating device.
	 * 
	 * @param location The location of the device.
	 * @param operationalArea The area the device is operating in.
	 * @param owner The owner of the device.
	 * @param effect The outcome of triggering the device.
	 * @param domains The domains the device can be located in.
	 * @param accessibility The mode of accessibility.
	 * @param type A URI that points to an entity within an ontology. The entity should represent a device type.
	 * @param endpoint The endpoint of the device; can be used to communicate with the device.
	 * @return A measuring device
	 */
	public static Actuator createActuator(Location location, SpatialObject operationalArea, Owner owner,
			SWRLRule effect, List<Domain> domains, Accessibility accessibility, IRI type, Endpoint endpoint) {
		if (effect == null || (effect.head().count() + effect.body().count()) == 0) {
			throw new IllegalArgumentException("effect is null or empty!");
		}
		Actuator device = factory.createActuator();
		initializeSmartCityObject(device, domains, accessibility, endpoint);
		initializeDevice(location, operationalArea, owner, type, device);
		device.setEffect(effect);
		return device;
	}

	private static void initializeDevice(Location location, SpatialObject operationalArea, Owner owner, IRI type,
			Device device) {
		if (location == null) {
			throw new IllegalArgumentException("location is null!");
		}
		if (operationalArea == null) {
			throw new IllegalArgumentException("operationalArea is null!");
		}
		if (owner == null) {
			device.setOwner(Owner.UNDEFINED);
		} else {
			device.setOwner(owner);
		}
		if (type == null) {
			throw new IllegalArgumentException("type is null!");
		}
		device.setLocation(location);
		device.setOperationalArea(operationalArea);
		device.setType(type);
	}
	
	/**
	 * Create a service.
	 * 
	 * @param outputs The type of data that is returned by the service.
	 * @param effect The effect lists everything that is caused by the service.
	 * @return A Service
	 */
	public static Service createService(List<Parameter> outputs, SWRLRule effect) {
		Service service = factory.createService();
		initializeSmartCityObject(service, null, null, null);
		initializeService(service, outputs, effect);
		return service;
	}

	/**
	 * Create a service.
	 * 
	 * @param outputs The type of data that is returned by the service.
	 * @param effect The effect lists everything that is caused by the service.
	 * @param domains The domains the device can be located in.
	 * @param accessibility The mode of accessibility.
	 * @param endpoint The endpoint of the device; can be used to communicate with the device.
	 * @return A Service
	 */
	public static Service createService(List<Parameter> outputs, SWRLRule effect, List<Domain> domains,
			Accessibility accessibility, Endpoint endpoint) {
		Service service = factory.createService();
		initializeSmartCityObject(service, domains, accessibility, endpoint);
		initializeService(service, outputs, effect);
		return service;
	}
	
	/**
	 * Creates an empty template.
	 * @param <T> Returned class.
	 * 
	 * @return Empty template of type {@code T}
	 */
	public static <T extends SmartCityObject> T createTemplate(@SuppressWarnings("javadoc") Class<T> type) {
		if (type == null) {
			return null;
		} else if (type.equals(Service.class)) {
			return type.cast(factory.createService());
		} else if (type.equals(Actuator.class)) {
			return type.cast(factory.createActuator());
		} else if (type.equals(Sensor.class)) {
			return type.cast(factory.createSensor()); 
		} else {
			return null;
		}
	}
	
	private static void initializeService(Service service, List<Parameter> outputs, SWRLRule effect) {
		if ((outputs == null || outputs.isEmpty())
				&& (effect == null || (effect.head().count() + effect.body().count()) == 0)) {
			throw new IllegalArgumentException("Either an output or effect has to be defined!");
		}
		if (outputs != null) {
			service.getOutputs().addAll(outputs);
		}
		service.setEffect(effect);
	}

	private static void initializeSmartCityObject(SmartCityObject sco, List<Domain> domains,
			Accessibility accessibility, Endpoint endpoint) {
		if (domains == null || domains.isEmpty()) {
			sco.getDomains().addAll(Collections.singletonList(Domain.SMART_CITY));
        } else {
        	sco.getDomains().addAll(domains);
        }
        if (accessibility == null) {
        	sco.setAccessibility(Accessibility.UNDEFINED);
        } else {
        	sco.setAccessibility(accessibility);
        }
        if (endpoint != null) {
        	sco.setEndpoint(endpoint);
        }
        sco.setId(UUID.randomUUID());
	}
	
	/**
	 * Returns a printable version of the smart city object with all values.
	 * 
	 * @param smartCityObject The instance to be printed out.
	 * @return String of the smart city object
	 */
	public static String format(SmartCityObject smartCityObject) {
		return format((EObject) smartCityObject);
	}
	
	/**
	 * Returns a printable JSON version of the smart city object with all values.
	 * 
	 * @param smartCityObject The instance to be printed out.
	 * @return String of the smart city object
	 */
	public static String formatAsJson(SmartCityObject smartCityObject) {
		return formatAsJson((EObject) smartCityObject);
	}
	
	private static String formatAsJson(EObject eobject) {
		StringBuilder sb = new StringBuilder(" { ");
		sb.append("\"class\" : \"").append(eobject.getClass().getInterfaces()[0].getSimpleName()).append(" \", ");
		sb.append(eobject.eClass().getEAllStructuralFeatures().stream()
				.map(f -> fomatStructuralFeature(eobject, f, true))
				.collect(Collectors.joining(", ")));
		sb.append(" }");
		return sb.toString();
	}
	
	/**
	 * Returns a printable version of the smart city object, omitting empty values.
	 * 
	 * @param smartCityObject The instance to be printed out.
	 * @return String of the smart city object
	 */
	public static String formatNonEmpty(SmartCityObject smartCityObject) {
		String format = format((EObject) smartCityObject);
		return format
				.replaceAll("[\\w]*:[\\s](null|Undefined|\\[\\]|"+DEFAULT_UUID+")?", EMPTY_STRING)
				.replaceAll("(, )+,", ",")
				.replaceAll("\\{,[\\s]?", "{").replaceAll(",[\\s]?\\}", "}");
	}
	
	private static String format(EObject eobject) {
		StringBuilder sb = new StringBuilder(eobject.getClass().getInterfaces()[0].getSimpleName());
		sb.append("{ ");
		sb.append(eobject.eClass().getEAllStructuralFeatures().stream()
				.map(f -> fomatStructuralFeature(eobject, f, false))
				.collect(Collectors.joining(", ")));
		sb.append(" }");
		return sb.toString();
	}

	private static String fomatStructuralFeature(EObject eobject, EStructuralFeature attribute, boolean quotated) {
		if (attribute instanceof EAttribute) {
			return formatAttribute(eobject.eGet(attribute), attribute.getName(), quotated);
		} else if (attribute instanceof EReference) {
			return formatReference(eobject.eGet(attribute), attribute.getName(), quotated);
		}
		return null;
	}
	
	private static String formatAttribute(Object object, String name, boolean quotated) {
		String formattedName = quotated ? QUOTATION_MARK + name + QUOTATION_MARK : name;
		String value = null;
		if (object instanceof SWRLRule) {
			value = format((SWRLRule) object, quotated);
		} else {
			value = getAttributeValue(object, quotated, name.toLowerCase().contains("iri"));
		}
		return formattedName + " : " + value;
	}

	private static String getAttributeValue(Object object, boolean quotated, boolean fullIRI) {
		String value = "null";
		if (object != null) {
			value = fullIRI ? object.toString() : hashmarkSuffix(object.toString());
		}
		return quotated ? QUOTATION_MARK + value + QUOTATION_MARK : value;
	}

	private static String formatReference(Object object, String name, boolean quotated) {
		String formattedName = quotated ? QUOTATION_MARK + name + QUOTATION_MARK : name;
		if (object instanceof EList) {
			return formattedName + " : [ " + ((EList<?>) object).stream()
					.filter(o -> o instanceof EObject)
					.map(o -> quotated ? formatAsJson((EObject) o) : format((EObject) o))
					.collect(Collectors.joining(", ")) + " ]";
		} else if (object instanceof EObject) {
			return formattedName + " : " + (quotated ? formatAsJson((EObject) object) : format((EObject) object));
		} else {
			return formattedName + " : " + (quotated ? QUOTATION_MARK + object + QUOTATION_MARK : object);
		}
	}

	private static String format(SWRLRule attribute, boolean quotated) {
		return (quotated ? QUOTATION_MARK : EMPTY_STRING) + attribute.body().map(
				atom -> hashmarkSuffix(atom.getPredicate().toString()) + "(" 
						+ (atom.allArguments().map(
								a -> hashmarkSuffix(a.toString())).collect(Collectors.joining(","))
								) 
						+ ")" 
				)
				.collect(Collectors.joining(" ^ "))
				.replaceAll("\"", quotated ? "'" : "\"") + (quotated ? QUOTATION_MARK : EMPTY_STRING);
	}

	private static String hashmarkSuffix(String string) {
		return string.replaceAll("(Variable)?.*\\#(\\w*)(.*)$", "$1$2").replace("Variable", "?");
	}

	/**
	 * Returns the label of the Smart City Object as an URI.
	 * 
	 * @param smartCityObject The object for which the label is wanted.
	 * @param namespace The namespace of the URI to be returned.
	 * @return The label as an URI-compatible String, or a placeholder if empty.
	 */
	public static String getLabelUri(SmartCityObject smartCityObject, String namespace) {
		String label = smartCityObject.getLabel();
		if (label == null) {
			label = "unnamed_"+ smartCityObject.getClass().getInterfaces()[0].getSimpleName();
		}
		return namespace + label.replace(" ", "_");
	}

}
