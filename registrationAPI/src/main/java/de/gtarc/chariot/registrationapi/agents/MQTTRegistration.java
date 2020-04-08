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
     * Getter for the host
     *
     * @return
     */
    public String getHost();

    /**
     * Setter for the host
     *
     * @param Host
     */
    public void setHost(String Host);

    /**
     * Getter for the username
     *
     * @return
     */
    public String getUsername();

    /**
     * Setter for the username
     *
     * @param Username
     */
    public void setUsername(String Username);

    /**
     * Getter for the password
     *
     * @return
     */
    public String getPassword();

    /**
     * Setter for the password
     *
     * @param Password
     */
    public void setPassword(String Password);

    public String getClientId();

    public void setClientId(String clientId);
}
