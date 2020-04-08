package de.gtarc.chariot.connectionapi;

import org.eclipse.californium.core.CoapResource;


public interface ICoapServerConnection extends ServerConnection {
    //void addWebResource(String path);
    void addResource(CoapResource resource);
}
