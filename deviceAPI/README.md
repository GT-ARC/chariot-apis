#deviceAPI

##How to create a Device?

A device can be created using DeviceBuilder(). After the properties are set, buildSensingDevice() method
will be called. An example can be found here: 

    Device device = new DeviceBuilder()
                        .setUuid(UUID.fromString(deviceId))
                        .setName("colorsensor")
                        .setDeviceLocation(location)
                        .setVendor("GT-ARC GmbH")
                        .setType("sensor")
                        .addMandatoryProperties(statusProperty)
                        .addMandatoryProperties(colorProperty)
                        .buildSensingDevice();
                        
Properties can be added using addMandatoryProperties() method:

    device.addMandatoryProperties(statusProperty)            
    
##How to create a Device Property?

DevicePropertyImpl() can be used to create a property. The fields "timestamp", "key", "type", "value", "unit", "writable" should be set in order to be acceptable by KMS:

    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
             
             