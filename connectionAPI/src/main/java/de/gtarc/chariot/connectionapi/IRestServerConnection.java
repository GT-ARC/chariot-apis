package de.gtarc.chariot.connectionapi;

public interface IRestServerConnection extends ServerConnection {
    //void addWebResource(String path);
    void addResource(Class<?> resource);
}
