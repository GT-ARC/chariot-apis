package de.gtarc.chariot.deviceapi.impl;

import com.google.gson.GsonBuilder;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;
import de.gtarc.util.PropertyBuilder;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DevicePropertyImplTest {

    @Ignore
    public void testDeviceProperty() {
        Property prop = new PropertyBuilder().setKey("printingModel").setType("string")
                .setValue("prop").setMax(Double.NaN).setMin(Double.NaN).setUnit("").setWritable(false).build();

        Property prop2 = new PropertyBuilder().setKey("printingModel").setType("string").
                setValue("prop-2").setUnit("").addSubProperty(prop).addSubProperty(prop).build();

        assertTrue(prop instanceof DevicePropertyImpl);
        assertFalse(prop2 instanceof DevicePropertyImpl);
        //assertTrue(prop2 instanceof SimplePropertyImpl);
        assertTrue(prop instanceof SimpleProperty);
        String test = new GsonBuilder()
                .create()
                .toJson(prop2);
        System.out.println(test);
        //assertEquals("{\"timestamp\":\"5\",\"key\":\"printingModel\",\"type\":\"string\",\"value\":\"modelName\",\"unit\":\"\",\"writable\":\"false\"}", test);
    }

}
