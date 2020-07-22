package de.gtarc.chariot.serviceapi;

import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.SimpleProperty;

import java.util.List;

/**
 * @author cemakpolat
 */
public interface ServiceProperty extends SimpleProperty {

    List<String> getRelatedTo();

    void setRelatedTo(List<String> relatedTo);

    String getOperation();

    void setOperation(String operation);


    void setConnectionHandler(ServiceConnection value);

    ServiceConnection getConnectionHandler();
} // SimpleProperty
