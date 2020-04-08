/**
 *
 */

package de.gtarc.chariot.serviceapi;

import com.google.gson.annotations.JsonAdapter;
import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.chariot.serviceapi.util.ServiceInterfaceAdapter;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Property;

import java.util.List;

/**
 *
 * @author cemakpolat
 *
 */
@JsonAdapter(ServiceInterfaceAdapter.class)
public interface Service extends Entity {

    ServiceDescription getDescription();

    void setDescription(ServiceDescription value);

    List<Property> getProperties();

    ServiceConnection getConnectionHandler();

    void setConnectionHandler(ServiceConnection value);

} // Service
