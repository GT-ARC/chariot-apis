package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.*;
import de.gtarc.commonapi.ComplexProperty;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.SimpleProperty;
import de.gtarc.commonapi.impl.ComplexPropertyImpl;
import de.gtarc.commonapi.impl.PropertyImpl;
import de.gtarc.commonapi.impl.SimplePropertyImpl;

public class DeviceAPIFactoryImpl implements DeviceAPIFactory {


    public static final DeviceAPIFactoryImpl INSTANCE = init();

    public static DeviceAPIFactoryImpl deviceAPIFactory = null;

    public static DeviceAPIFactoryImpl init() {
        if (deviceAPIFactory == null) {
            deviceAPIFactory = new DeviceAPIFactoryImpl();
            return deviceAPIFactory;
        }
        return deviceAPIFactory;
    }


    public DeviceAPIFactoryImpl() {
        super();
    }

//    @Override
//    public Property createPropertyImpl() {
//        PropertyImpl propertyImpl = new PropertyImpl();
//        return propertyImpl;
//    }

    @Override
    public SimpleProperty createSimplePropertyImpl() {
        SimplePropertyImpl simplePropertyImpl = new SimplePropertyImpl();
        return simplePropertyImpl;

    }

    @Override
    public ComplexProperty createComplexPropertyImpl() {
        ComplexPropertyImpl complexPropertyImpl = new ComplexPropertyImpl();
        return complexPropertyImpl;

    }

    @Override
    public RuntimeEnvironment createRuntimeEnvironment() {

        RuntimeEnvironmentImpl runtimeEnvironment = new RuntimeEnvironmentImpl();
        return runtimeEnvironment;

    }

    @Override
    public Component createComponent() {
        ComponentImpl component = new ComponentImpl();
        return component;

    }

    @Override
    public ActuatingDevice createActuatingDevice() {
        ActuatingDeviceImpl actuatingDevice = new ActuatingDeviceImpl();
        return actuatingDevice;

    }

    @Override
    public SensingDevice createSensingDevice() {
        SensingDeviceImpl sensingDevice = new SensingDeviceImpl();
        return sensingDevice;

    }


}
