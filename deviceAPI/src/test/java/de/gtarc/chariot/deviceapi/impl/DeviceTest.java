package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.commonapi.impl.OperationImpl;
import org.junit.Test;

public class DeviceTest {

    @Test
    public void deviceBuilderTest() {
        Device device = new DeviceBuilder()
                .addOperation(
                        new OperationImpl(
                                "TestOperatin",
                                new String[]{"String"},
                                new String[]{"String"}
                        )
                )
                .buildActuating();
        System.out.println(device);
        System.out.println(device.getOperations());
    }

}
