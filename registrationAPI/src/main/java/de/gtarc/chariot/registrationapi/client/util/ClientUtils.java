package de.gtarc.chariot.registrationapi.client.util;

import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.AbstractPayload;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import de.gtarc.chariot.messageapi.payload.*;
import de.gtarc.chariot.serviceapi.ServiceProperty;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class ClientUtils {

	// Creates a registration message with given parameters.
	public static AbstractMessage createRegistrationMessage(String url, String topic, String responseTopic, String to,
			String from, Entity entity, String name, String reId, String securityKey, String groupId,
			String manufacturer, String objectType) throws SocketException, UnknownHostException {
		PayloadEntityRegistration payloadEntityRegistration = null;

		if (entity == null) {
			throw new NullPointerException("Entity is null!");
		}
		try {
			payloadEntityRegistration = new PayloadEntityRegistration(
					objectType,
					entity.getUUIdentifier().toString(),
					entity.getUUIdentifier().toString(),
					entity.getName(),
					securityKey,
					reId,
					getIpAdress(),
					groupId,
					manufacturer,
					entity.getLocation(),
					getProperties(entity),
					getOperations(entity));
		} catch (UnknownHostException | SocketException e) {
			throw e;
		}

		// Returns the created message.
		return createMessage(url, topic, responseTopic, to, from, payloadEntityRegistration);

	}

	public static AbstractMessage createMessage(String url, String topic, String responseTopic, String to, String from,
			AbstractPayload entityPayload) {
		// Creates a message and attaches the payload
		return new MessageBuilder().setUrl(url).setTopic(topic).setResponseTopic(responseTopic).setTo(to).setFrom(from)
				.setMessageType(entityPayload.getClass().getName()).addPayload(entityPayload).build();
	}

	// Obtains the external ip adress with connecting the google dns 8.8.8.8
	public static String getIpAdress() throws SocketException, UnknownHostException {
		final DatagramSocket socket;
		socket = new DatagramSocket();
		socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		return socket.getLocalAddress().getHostAddress();
	}

	// Creates a keep alive message with given parameters.
	// TODO: Keep alivetime is not used!
	public static AbstractMessage createKeepAliveMessage(String url, String topic, String responseTopic, String to,
			String from, String reId, String aliveTime, String securityKey, long timestamp, Entity entity) {

		if (entity == null) {
			throw new NullPointerException("Entity is null!");
		}
		
		PayloadEntityKeepAlive entityPayload = new PayloadEntityKeepAlive(entity.getType(),reId, aliveTime,
				entity.getUUIdentifier().toString(), securityKey, timestamp, getProperties(entity));
		return createMessage(url, topic, responseTopic, to, from, entityPayload);

	}

	// Creates a deactivation message with given parameters.
	public static AbstractMessage createDeactivation(String url, String topic, String responseTopic, String to,
			String from, String reId, String uuid, String securityKey, Entity entity) {

		if (entity == null) {
			throw new NullPointerException("Entity is null!");
		}

		PayloadEntityDeactivation entityPayload = new PayloadEntityDeactivation(entity.getType(),reId, uuid, securityKey);

		return createMessage(url, topic, responseTopic, to, from, entityPayload);

	}

	// Creates a removal message with given parameters.
	public static AbstractMessage createRemoval(String url, String topic, String responseTopic, String to, String from,
			String reId, String uuid, String securityKey, Entity entity) {
		if (entity == null) {
			throw new NullPointerException("Entity is null!");
		}

		PayloadEntityRemoval entityPayload = new PayloadEntityRemoval(entity.getType(),reId, uuid, securityKey);

		return createMessage(url, topic, responseTopic, to, from, entityPayload);

	}

	// Creates a update message with given parameters.
	public static AbstractMessage createUpdate(String url, String topic, String responseTopic, String to, String from,
			String reId, String uuid, String securityKey, Entity entity) {

		if (entity == null) {
			throw new NullPointerException("Entity is null!");
		}

		PayloadEntityUpdate entityPayload = new PayloadEntityUpdate(entity.getType(),reId, entity.getName(), uuid, securityKey, getProperties(entity),
				getOperations(entity));
		return createMessage(url, topic, responseTopic, to, from, entityPayload);

	}

	// Creates a update message with given parameters.
	public static AbstractMessage createEntityPropertyAdd(String url, String topic, String responseTopic, String to,
			String from, String uuid, String securityKey, Property property) {
		AbstractMessage message = null;

		if (property instanceof ServiceProperty) {
			ServiceProperty serviceProperty = (ServiceProperty) property;
			PayloadEntityPropertyAdd payload = new PayloadEntityPropertyAdd("service" ,uuid, securityKey,
					serviceProperty.getTimestamp(), serviceProperty.getKey(), serviceProperty.getUnit(),
					serviceProperty.getType(), serviceProperty.getValue(), serviceProperty.getRelatedTo(),
					serviceProperty.getOperation());
			return createMessage(url, topic, responseTopic, to, from, payload);

		} else {
			try {
				throw new Exception("Property adding is supported only for ServiceProperty types!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return message;
		}
	}

	// Utility function for getting properties array.
	public static Property[] getProperties(Entity entity) {
		Property[] properties = null;
		List<Property> mandatoryProperties = entity.getProperty();
		if (mandatoryProperties.size() > 0) {
			properties = new Property[mandatoryProperties.size()];
			for (int i = 0; i < mandatoryProperties.size(); i++) {
				properties[i] = mandatoryProperties.get(i);
			}
		}
		return properties;
	}

	// Utility function for getting properties array.
	public static Operation[] getOperations(Entity service) {
		Operation[] operations = null;
		List<Operation> mandatoryOperations = service.getOperations();
		if (mandatoryOperations.size() > 0) {
			operations = new Operation[mandatoryOperations.size()];
			for (int i = 0; i < mandatoryOperations.size(); i++) {
				operations[i] = (Operation) mandatoryOperations.get(i);
			}
		}
		return operations;
	}

}
