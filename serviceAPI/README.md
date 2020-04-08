#serviceAPI

##How to create a Service?

A service can be created using ServiceBuilder(). After the properties are set, buildService() method
will be called. An example can be found here: 

    Service service = new ServiceBuilder()
                        .setUuid(UUID.fromString(uuid))
                        .setName("Example-Agent-Service")
                        .buildService();
                        
A single Property can be added using addProperties() method,
a list of Properties can be added using setProperties() method:

    service.addProperties(property);
    service.setProperties(properties);            
    
##How to create a Service Property?

The functions above expects the type Property from the commonAPI. However, in order to save a service property
to the KMS, PayloadServiceProperty() is used. The fields "timestamp", "key", "unit", "type", "value", "relatedTo", "operation" should be set in order to be acceptable by KMS:

    PayloadServiceProperty propOne = new PayloadServiceProperty(timeStamp2, "status", "", "number", 3.0, Collections.singletonList("http://chariot-km.dai-lab.de:8001/services/aaa"), "op1");
