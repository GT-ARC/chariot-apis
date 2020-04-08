package de.gtarc.chariot.serviceapi;

import de.gtarc.chariot.connectionapi.ServiceConnection;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.SimpleProperty;

import java.util.List;

/**
 * @author cemakpolat
 */
public interface ServiceProperty extends SimpleProperty {

    Object getValue();

    void setValue(Object value);

    String getUnit();

    void setUnit(String unit);

    String getType();

    void setType(String type);

    boolean getWritable();

    void setWritable(boolean writable);

    String getMin();

    void setMin(String min);

    String getMax();

    void setMax(String max);

    List<String> getRelatedTo();

    void setRelatedTo(List<String> relatedTo);

    String getOperation();

    void setOperation(String operation);

    void setTimestamp(long timestamp);

    long getTimestamp();

    void setConnectionHandler(ServiceConnection value);

    ServiceConnection getConnectionHandler();
} // SimpleProperty
