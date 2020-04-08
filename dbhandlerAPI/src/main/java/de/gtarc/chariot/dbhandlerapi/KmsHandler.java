package de.gtarc.chariot.dbhandlerapi;

import de.gtarc.chariot.connectionapi.Connection;

import java.net.URI;
import java.net.URISyntaxException;

// This is an interface for database handling, these methods defined here are required for registration server to work.
public interface KmsHandler extends DbHandler {

    /**
     * returs the related kafka-topic of the given entity
     *
     * @param entityId
     * @return
     */
    public String getKafkaTopic(String entityId);

    /**
     * returns reid of the given entity in the database
     *
     * @param entityId
     * @return
     */
    public String getReId(String entityId);

    /**
     * return the agent id via the given uuid
     *
     * @param uuid
     * @return
     */
    public String getAgentId(String uuid);

    /**
     * Set the database interface path and related entity name
     *
     * @param url
     * @param entity
     * @throws URISyntaxException
     */
    public void setURI(String url, String entity) throws URISyntaxException;

    /**
     * Set the database url
     *
     * @param url
     * @throws URISyntaxException
     */
    public void setURL(String url) throws URISyntaxException;

    /**
     * Set the database interface path
     *
     * @param path
     * @throws URISyntaxException
     */
    public void setEntityPath(String path) throws URISyntaxException;

    /**
     * @return the url address of the given database endpoint
     */
    public URI getURI();

    /**
     * Create a connection object to the database to communicate with the database.
     *
     * @return
     */
    public Connection createDBConnection();

}
