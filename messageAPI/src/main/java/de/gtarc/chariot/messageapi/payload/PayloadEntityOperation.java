package de.gtarc.chariot.messageapi.payload;

import de.gtarc.chariot.messageapi.AbstractPayload;

/**
 * "operations": [
 * {
 * "name": "action-1",
 * "inputs": "required-inputs types boolean|integer|float|long|...",
 * "outputs": "output type",
 * }
 * ],
 *
 * @author cemakpolat
 */
public class PayloadEntityOperation extends AbstractPayload {
	String objectType;
    String name;
    Object[] inputs;
    Object output;


    public PayloadEntityOperation(String name, String[] inputs, String output) {
        this.name = name;
        this.inputs = inputs;
        this.output = output;
    }

    public PayloadEntityOperation(String name, Object[] inputs, Object output) {
        this.name = name;
        this.inputs = inputs;
        this.output = output;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Object[] getInputs() {
        return inputs;
    }


    public void setInputs(Object[] inputs) {
        this.inputs = inputs;
    }


    public Object getOutput() {
        return output;
    }


    public void setOutput(Object output) {
        this.output = output;
    }


}
