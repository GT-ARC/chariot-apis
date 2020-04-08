#dbHandlerAPI
dbHandlerAPI offers two types of database handlers, KmsHandler and DummyDbHandler. They both extend the DbHandler class, 
which allows the developer to use the same functions with both of the database handlers.

##Shared Methods

####Register the given entity using its object.

    public void registerEntity(AbstractPayload payload);
    
Example:

    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    kms.registerEntity(payload);    
    
####Update the given entity with its id.    
    
    public void updateEntity(String entityId, AbstractPayload payload);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    kms.updateEntity(payload.getUuid(), payload);
    
####Remove the given entity using its id.   
    
    public void removeEntity(String entityId);
    
Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    PayloadDeviceRemoval payload = new PayloadDeviceRemoval("5e2b00507993f14664c326b2", "dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
    kms.removeEntity(payload.uuid);    
    
####Remove the property of the given entity id.    
    
    public void removeEntityProperty(String entityId, AbstractPayload payload);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    PayloadDeviceRemoval payload = new PayloadDeviceRemoval("5e2b00507993f14664c326b2", "dd78636f-1149-4ddd-903a-629728ae98e4", "securitKey");
    PayloadDeviceProperty newprop = new PayloadDeviceProperty(timeStamp, "color", "string", "red", "", true);
    kms.removeEntityProperty(payload.uuid, newprop);

####Retrive the entity with the given id.

    public String getEntity(String entityId);
    
Example:
        
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    kms.getEntity(payload.getUuid());        
    
####Get all entities.    
    
    public String getAllEntities();
    
Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    kms.getAllEntities();
    
    
####Update entity property with the given entityid and payload.   
    
    public void updateEntityProperty(String entityId, AbstractPayload payload);
    
Example:

    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});

    PayloadDeviceProperty newprop = new PayloadDeviceProperty(timeStamp, "color", "string", "purple", "", true);

    kms.updateEntityProperty(payload.getUuid(), newprop);    
    
####Get all keys of the entities.

    public ArrayList<String> getEntityPropertyKeys(String entityId);    
    
Example:

    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    ArrayList<String> answer = kms.getEntityPropertyKeys(payload.getUuid());
    System.out.print(answer);
    
####Check whether the entity is available or not.
    
    public boolean isEntityAvailable(String entityId);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    boolean answer = kms.isEntityAvailable(payload.getUuid());
    //System.out.print(answer);
    assertEquals(true, answer);

####This method updates an entity attribute.    
    
    public void updateEntityAttribute(String entityId, AbstractPayload payload);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});

    PayloadProperty attribute = new PayloadProperty();
    attribute.setKey("name");
    attribute.setValue("raySensor");

    kms.updateEntityAttribute(payload.getUuid(), attribute);

####This method updates the attribute of a property.

    public void updatePropertyAttribute(String entityId, AbstractPayload payload);

Example:

    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});

    PayloadPropertyAttribute attribute = new PayloadPropertyAttribute();
    attribute.setPropertyKey("color");
    attribute.setKey("value");
    attribute.setValue("pink");

    kms.updatePropertyAttribute(payload.getUuid(), attribute);

####This method updates the location of an entity.

    public void updateLocation(String entityId, AbstractPayload payload);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});

    PayloadProperty attribute = new PayloadProperty();
    //attribute.setKey("type");
    //attribute.setValue("someType");
    attribute.setKey("indoorposition");
    Indoorposition indoor = new Indoorposition("1", 9.0, 9.0);
    attribute.setValue(indoor.getJsonString(indoor.getClass()));

    kms.updateLocation(payload.getUuid(), attribute);    

##KmsHandler Methods 

####returns the related kafka-topic of the given entity    
    
	public String getKafkaTopic(String entityId);
    
Example:
  
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    String answer = kms.getKafkaTopic(payload.getUuid());
    System.out.print(answer);
    assertEquals("kms.global.devices.dd78636f-1149-4ddd-903a-629728ae98e4.", answer);        
    
####returns reid of the given entity in the database    
    
    public String getReId(String entityId);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    String answer = kms.getReId(payload.getUuid());
    System.out.print(answer);
    assertEquals("123", answer);    

####return the agent id via the given uuid    
    
	public String getAgentId(String uuid);

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");
    long timeStamp = (new Date()).getTime();
    DevicePropertyImpl[] properties = new DevicePropertyImpl[2];
    DevicePropertyImpl statusProperty = new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
    DevicePropertyImpl colorProperty = new DevicePropertyImpl(timeStamp, "color", "string", "red", "", false);
    properties[0] = statusProperty;
    properties[1] = colorProperty;
    Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
    PayloadDevice payload = new PayloadDevice("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "visionsensor", "securitKey", "123",
            "", "groupId", "GT-arc", location, properties, new Operation[]{});
    String answer = kms.getAgentId(payload.getUuid());
    System.out.print(answer);

####Set the database interface path and related entity name    
    
    public void setURI(String url, String entity) throws URISyntaxException;

Example:
    
    KmsHandlerImpl kms = new KmsHandlerImpl();
    URI uri = new URI("http://chariot-km.dai-lab.de:8080/v1");
    String host = uri.toString();
    kms.setURI(host, "/devices/");
    System.out.print(kms.getURI());

####return the url address of the given database endpoint    
    
    public URI getURI();

####Create a connection object to the database to communicate with the database.    
    
    public Connection createDBConnection();

        