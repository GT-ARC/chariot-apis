/**
 *
 */
package de.gtarc.commonapi;


import com.google.gson.annotations.JsonAdapter;
import de.gtarc.commonapi.utils.PropertyInterfaceAdapter;

@JsonAdapter(PropertyInterfaceAdapter.class)
public interface Property<T> {

    long getTimestamp();

    void setTimestamp(long timestamp);



    String getKey();


    void setKey(String value);


    String getUnit();

    void setUnit(String unit);


    String getType();


    void setType(String type);


    T getValue();


    void setValue(T value);

    boolean getWritable();

    void setWritable(boolean writable);

} // Property
