package de.gtarc.commonapi.impl;

import de.gtarc.commonapi.Operation;

import java.util.Arrays;

/**
 * @author cemakpolat
 */
//@JsonAdapter(OperationInterfaceAdapter.class)
public class OperationImpl implements Operation {

    private static final String NAME_EDEFAULT = "operation";

    private static final Object[] INPUTS_EDEFAULT = null;

    private static final Object[] OUTPUTS_EDEFAULT = null;


    protected String name = NAME_EDEFAULT;

    protected Object[] inputs = INPUTS_EDEFAULT;

    protected Object[] outputs = OUTPUTS_EDEFAULT;

    public OperationImpl() {
        super();
    }

    public OperationImpl(String newName, Object[] newInput, Object[] newOutput) {
        this.name = newName;
        this.inputs = newInput;
        this.outputs = newOutput;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setValue(String newValue) {
        if (newValue != null) {
            name = newValue;
        }

    }

    public Object getInputs() {
        return inputs;
    }

    public void setInputs(Object... inputs) {
        if (inputs != null) {
            this.inputs = inputs;
        }

    }

    public Object[] getOutputs() {
        return outputs;
    }


    public void setOutputs(Object... outputs) {
        if (outputs != null) {
            this.outputs = outputs;
        }

    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append("{\n\"name\": \"");
        result.append(name);
        result.append("\",\n\"inputs\": \"");
        result.append(Arrays.toString(inputs));
        result.append("\",\n\"outputs\": \"");
        result.append(Arrays.toString(outputs));
        return result.toString();

    }

} //OperationImpl
