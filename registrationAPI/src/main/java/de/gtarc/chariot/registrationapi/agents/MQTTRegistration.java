package de.gtarc.chariot.registrationapi.agents;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;

public interface MQTTRegistration {

    // get mqtt connection
    public Connection getMqttConnect(String host, String username, String password, String clientId) throws ConnectionException;

    // get connection result after sending the registration request
    AbstractMessage getAbstractMessage(Connection dcl, ClientResult clientResult) throws ConnectionException;

    // configure the database connection for each entity
    void configureDatabaseConnection(String entityName);

    // register the entity
    AbstractMessage register() throws Exception;

    //  update entity
    AbstractMessage updateEntity();

    // update property
    <T> void updateProperty(T property);

    /**
     * Getter for the mqttHostURL
     *
     * @return
     */
    public String getMqttHostURL();

    /**
     * Setter for the mqttHostURL
     *
     * @param Host
     */
    public void setMqttHostURL(String Host);

    /**
     * Getter for the mqttUsername
     *
     * @return
     */
    public String getMqttUsername();

    /**
     * Setter for the mqttUsername
     *
     * @param Username
     */
    public void setMqttUsername(String Username);

    /**
     * Getter for the mqttPassword
     *
     * @return
     */
    public String getMqttPassword();

    /**
     * Setter for the mqttPassword
     *
     * @param Password
     */
    public void setMqttPassword(String Password);

    public String getMqttClientId();

    public void setMqttClientId(String clientId);
}
