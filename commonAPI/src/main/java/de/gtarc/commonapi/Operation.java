/**
 *
 */
package de.gtarc.commonapi;


import com.google.gson.annotations.JsonAdapter;
import de.gtarc.commonapi.utils.OperationInterfaceAdapter;

/**
 *
 * @author cemakpolat
 *
 */
@JsonAdapter(OperationInterfaceAdapter.class)
public interface Operation {

    String getName();

    void setName(String newName);

    void setValue(String newValue);

    Object getInputs();

    void setInputs(Object... inputs);

    Object[] getOutputs();

    void setOutputs(Object... outputs);

} // Operation
