# CHARIOT APIs Documentation

## Common API

All common terms that are required for the other apis are defined unter this api. The definition of the IoT entities along with their relevant properties are described in detail. From the basic property to the complex `property` definitions are implemented. All composing parts of an IoT entity is implemented. 

The supported variable types are `array`, `number`, `string` and `boolean`. This model can be extended if the corresponding components are implemented. The extension of the current system can be done under the chariot-kms [link].

Each IoT entity extends `de.gtarc.commonapi.Entity.java` interface to have a similar IoT concept. This concept can be used independently in other projects as well. `IoTEntity.java` class is used to differentiate the IoT entities from each other during the registration process. `Actuators, Sensors,Services, Humans, Tasks,Skills` are supported entity types. Besides properties, `operations` represent the entity related methods and functions.  

During the registration process of an Entity, the class extending Entity interface has to be serialized and deserialized. `PropertyInterfaceAdapter` and`OperationInterfaceAdapter` are separately evaluated by the Google gson convertor. If you plan to extend the property or operations you should adapt this classes accordingly. 

After the serialization of a property and an operation, their json models are shown as follows:

**Property**

```json
{
  "value": "value",
  "timestamp": 0,
  "key": "key",
  "type": "string",
  "unit": "",
  "writable": true
}
```

**Operation**

``` json
{
  "name": "de.gtarc.chariot.handlePropertyAction",
  "inputs": [
    "java.lang.String"
  ],
  "outputs": []
}
```

**GatewayConfig**

CHARIO middleware is based on JIAC agents and the communication among distributed agents are carried out through a gateway node in order to enable their interaction under the different network domains. `resources/GatewayConfig.xml` file describes the connection details. This configuration is only necessary if the agents are not running in the same network. For your network, you need to change `networkURI` as well as other configurable parameters if required.

**Integration of IoT entities over Runtime Environments**

The registration process distinguishes when a device is connected through a runtime environment. The following variables in IoTEntity class makes this difference:

- REID_REQUIRED: A device is connected via a runtime environment. Device Agent must separately register itself. 
- REID_NOTREQUIRED: A device is connected direclty via an agent, since device can run its agent on its platform.

These two parameters are only required for the registration process. if the purpose is just to use this api, you can ignore them. A detailed registration process is presented under the `registration-api` module.

##Connection API

The purpose of connection API is to ease the integration of IoT entitites that is connected through a communication protocol. A common  pattern is implemented for various communication protocols, so that the developers can utilize in different projects and extend it with the same principle. The available communication protocols are `MQTT`, `HTTP`, `CoAP` and `WebSocket`. 

Even though the abstraction of the connection API is designed considering the requirements of CHARIOT middleware and its entities, as aforementioned, its adaption to other projects or adding a new communicaton protocol is easy. 

Besides the implemented code pattern, the procotol itself is also accessible to the developer so that the full feature of the communication protocol can be consumed. 

The communication behavior differs from procotol to protocols, i.e. MQTT is based on a publish/subscribe system, whereas HTTP and CoAP have a client/server connection. For this reason, the some communication protocols are implement using client/server structure, whereas others with the publish/subsribe message system.

#### Usage of Available Communication Protocols

**CoAP Client**

```java
CoapClientService client = new CoapClientService();
client.setConnectionURI("coap://127.0.0.1:5683/temp2");
client.connect();
client.sendMessage(); // tested with json data
client.disconnect();
```

**CoAP Server**

```java
CoapServerService server = new CoapServerService();
server.addResource(new RTemperatureMeasurement("temp2"));
server.addResource(new RTemperatureMeasurement("temp4"));
server.connect();
Thread.sleep(30000);
server.disconnect();

```

**HTTP Client**

```java
WebClientConnection	client = new WebClientConnection();
client.setConnectionURI("http://localhost:8282/");
client.connect();
client.sendByGet(client.getConnectionURI());
client.disconnect();
```

**HTTP Server**

```java
WebServerConnection server = new WebServerConnection();
server.addResource(NetworkOperatorResource.class);
server.connect();
Thread.sleep(30000);
server.disconnect();
	
```

**MQTT**

```java
MqttConnectionImpl mqtt = new MqttConnectionImpl(host, username, password, "clientName");
mqtt.connect();
mqtt.send("topic","message");
mqtt.disconnect();
```

Apart from a simple implementation of  MQTT protocol, MQTT class is extended to cover the messages created by messageAPI. Although this approach is not followed by other communication protocols, they can be also adapted by using either the same message format or a different message format that fulfils the related communication protocol.

```java
MqttConnectionImpl mqtt = new MqttConnectionImpl(host, username, password, "clientName");
mqtt.connect();
IMessage message = new MessageBuilder()
    .setUrl("{url}")
    .setTopic("{topic}")
    .setResponseTopic("{responsetopic}")
    .setFrom("{from}")
    .setTo("{to}")
    .setMessageType(payload.getClass().getName())
    .addPayload(payload)
    .build();
mqtt.send(message);
mqtt.disconnect();

```

**WebSocket Client**

javax.websocket library is wrapped with WebSocketImpl class. An websocket client example with its endpoint are demonstrated as follows:

```java
public class WSEndpoint extends WebSocketClient {
    private final CountDownLatch closeLatch;
    @SuppressWarnings("unused")
    private Session session;
    public WSEndpoint() {
        this.closeLatch = new CountDownLatch(1);
    }
    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }
    @OnOpen
    public void onWebSocketConnect(Session session) throws IOException {
        this.session = session;
    }
    @OnMessage
    public void onWebSocketText(String message, Session session) throws IOException {
        System.out.println("Received Message: " + message);
        this.closeLatch.countDown();
        this.session = null;
    }
    @OnClose
    public void onWebSocketClose(CloseReason reason) {
        System.out.println("Connection closed: " + reason);
        this.session = null;
        this.closeLatch.countDown();
    }
    @OnError
    public void onWebSocketError(Throwable cause) {
        cause.printStackTrace(System.err);
    }
}
```


```java

WebSocketClientImpl wsClient = new WebSocketClientImpl((new WSEndpoint()));
wsClient.setConnectionURI("ws://localhost:1000/");
wsClient.connect();
wsClient.sendMessage("message-content");
```



**WebSocket Server**
```java 
WebSocketServerImpl server = new WebSocketClientImpl(10000);
server.addResource(WSEndpoint.class);
Thread.sleep(30000);
server.connect();
```


## DBHandler API

Database(db)-handler API targets to communicate with a database that supports the entity models described in messageAPI and commonAPI. The current implementation is composed of two database handler, namely, knowledge-management-service (kms) handler and a dummydbhandler. 

`KMShandler` communicates with CHARIOT mongodb database to provide all CRUD operations for IoT entities. All attributes of IoT entities can be edited, removed or updated by means of this handler. 

`DummyDbHandler` has the similar structure to `KMShandler`, since they inheret a common interface, called DbHandler. The aim of implementing this handler is to demonstrate its modularity and extensibility . By inhereting `DbHandler`, a developer can create a totally new database implementation without affecting all other APIs. The specialized methods for the database technology can be additionally implemented in the exteded class. 

CHARIOT entities utilizes the dbhandlerAPI for the registration, deactivation, removing, getting, adding and updating an IoT entity. 

An IoT device registration using the dbhandlerAPI is exemplified below:

```java
KmsHandlerImpl kms = new KmsHandlerImpl("http://localhost:8080/v1", "/devices/");
long timeStamp = (new Date()).getTime();
Property[] properties = new DevicePropertyImpl[2];
properties[0] =  new DevicePropertyImpl(timeStamp, "status", "boolean", false, "", false);
properties[1] =  new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true);
Location location = new Location("locationId", "type", "Production Line", 11, new Position(5.0, 5.0, "1"), new Indoorposition("1", 5.0, 5.0));
PayloadEntityRegistration payload 
  = new PayloadEntityRegistration("sensor", "dd78636f-1149-4ddd-903a-629728ae98e4", "5e2b00507993f14664c326b2", "tempsensor", "securitKey", "123","", "groupId", "GT-arc", location, properties, new Operation[]{});
kms.registerEntity(payload);
```

## Device API

Devices plays a crucial role in IoT middleware project and their unified description is required to ensure their mutual interaction. Device API provides the way of describing the devices in CHARIOT middleware. As in other APIs,  device API can be also independently embedded in many project thanks to the modular design. This API have two dependencies, namely, `connection API` and `common API`. 

A sensor can be implemented as below:

```java
Device device = new DeviceBuilder()
  .setUuid(UUID.randomUUID())
  .setName("Device-Example-Agent")
  .setDeviceLocation(
  new Location(
    "PL-Location",
    "Room",
    "Production Line",
    0,
    new Position(0, 0, "0"),
    new Indoorposition("0", 0, 0)
  )
)
  .addProperty( new DevicePropertyBuilder().setTimestamp(new Date().getTime())
               .setKey("status").setType("boolean").setValue(false)
               .setUnit("").setWritable(false).buildDeviceProperty())
  .addProperty(new DevicePropertyImpl(timeStamp, "color", "string", "red", "", true))
  .buildSensingDevice()
```

DeviceConnection can be also added to the above code block.

## Human API

The integration human actor in smart spaces and her interaction with the surrounding environment require a special API for these purposes. human API integrates the human actor in the CHARIOT ecosystem, and enables her communication with other IoT entities based on her skills. The data model of human is quite similar to other data models and its is constructed indeed on the entity data model being introduced in `common api`. The prominent characteristics of the human api are published in paper[link]. Apart from that, a simple human actor can be instantiated with the following code piece:

``` java
 HumanImpl human1 = new HumanBuilder()
   .setName("human-name")
   .setUuid(UUID.randomUUID())
   .addProperty(new HumanPropertyImpl(0,"skills", "array", [], "", true))
   .addProperty(new HumanPropertyImpl(0,"tasks", "array", [], "", true))
   .addProperty(new HumanPropertyImpl(0,"permissions", "array", [], "", true))
   .addProperty(new HumanPropertyImpl(0,"username", "string", "chariot", "", true))
   .build();

```

The property number can be increased as much as possible according to the use case requirements.

## Message API

The communication among CHARIOT entities occurs through the encapsulated message structure and the purpose of message API is to provide the message ingredients. The message form does includes meta information, we can call it as header information, and the payload that contains the message itself. All messages are serialized/deserialized va Google gson library. The message structure is designed by thinking of a publish/subscbribe system, however, it can be also adapted for other message exchanging types such as REST.

A simple message looks like as shown below:

- `url`: host url
- `topic`: publish topic name
- `responseTopic`: response topic if a response is needed
- `from`: sending the message, message sender 
- `to`: receiving the message, message receiver
- `timeSent`: The time that the message has been sent
- `timeReceived`: The time tat the message has been received
- `messageType`: The class name of the payload,which is later used for the message desirialization
- `payload`: The payload object that stores the message content

#### Build

`$ mvn clean package`

#### Usage

A custom message creation can be easily performed by using message api, since the payload classes are automically serialized/desirialized. A simple payload can be created by extending `AbstractPayload` . In case a custom seralizer/desirialized is required, you can override gsonString and fromJsonStringImpl methods to have fully a customized payload. With the current version of the API, you can implement as below:

```java

public class PayloadExampleImpl extends AbstractPayload {
  // Some custom variables in the payload.
  // By default, the payload json string will contain all of the variables defined.
  public String payload;

  // Default constructor
  public PayloadDefaultImpl() {}

  // An example contructor
  public PayloadDefaultImpl(String string) {
    payload = string;
  }

  @Override
  // This is not required, this override method is only in here because to show the override procedure for custom classes.
  public String getJsonString() {
    return new Gson().toJson(this);
  }

  @Override
  // This is not required, this override method is only in here because to show the override procedure for custom classes.
  public AbstractPayload fromJsonStringImpl(String string) {
    return new Gson().fromJson(string, this.getClass());
  }
}
```

Afterwards,  a message can be easily created using `MessageBuilder` class. 

```java
/*Create a custom payload and plug into the message.*/
AbstractPayload payload = new PayloadExampleImpl();

/* Create a message using the builder pattern*/
IMessage message = new MessageBuilder()
  .setUrl("{url}")
  .setTopic("{topic}")
  .setResponseTopic("{responsetopic}")
  .setFrom("{from}")
  .setTo("{to}")
  .setMessageType(payload.getClass().getName())
  .addPayload(payload)
  .build();

/* With this string, you can reconstruct the message whenever it needed.*/
String string = message.getJsonObject();

/* Reconstruct the message using a json string.*/
IMessage newMessage = MessageBuilder.fromJsonString(string);
```

All message  are inhereted from `Imessage` interface to have a common message tree in the message api.

#### Usage of message API in CHARIOT Middleware

**Description of an Entity in CHARIOT**

Entity describes an IoT object data model in CHARIOT world and it contains the following attributes:

``` json
{
  "objectType": "device",
  "uuid": "b9a391a4-0328-4792-83ae-94b1482151fd",
  "groupId": "devices",
  "id": "b9a391a4-0328-4792-83ae-94b1482151fd",
  "name": "lamp",
  "securitykey": "secretkey",
  "ip": "0.0.0.0",
  "reId": "REIDNOTREQUIRED",
  "location": {
    "identifier": "Smart Factory",
    "type": "Room",
    "name": "Production Line",
    "position": {
      "id": "0",
      "lat": 0,
      "lng": 0
    },
    "level": 0,
    "indoorposition": {
      "id": "0",
      "indoorlat": 0,
      "indoorlng": 0
    }
  },
  "manufacturer": "",
  "properties": [
    {
      "value": "",
      "min": 0,
      "max": 0,
      "timestamp": 0,
      "key": "account",
      "type": "string",
      "unit": "",
      "writable": true
    }
  ],
  "operations": [
    {
      "name": "de.gtarc.chariot.handlePropertyAction",
      "inputs": [
        "java.lang.String"
      ],
      "outputs": []
    }
  ]
}
```

The majority of items in the above json model is covered in the **commonAPI**. 

**Available Payloads for CHARIOT Middleware**

Based on the aforementioned message format, all chariot payloads are created under `de.gtarc.chariot.messageapi.payload` package. The short description of these messages are given below:

- `PayloadEntity`: Message representing an IoT entity  
- `PayloadEntityDeactivation`: Deactivation message for an IoT entity
- `PayloadEntityOperation`: Message illustrating an IoT entity operation
- `PayloadEntityProperty`: Message illustrating an IoT entity property
- `PayloadEntityPropertyAdd`: Message used for adding a property to an IoT entity
- `PayloadEntityRegistration`: Message used for registering an IoT entity in CHARIOT middleware
- `PayloadEntityRemoval`: Message used for removing an IoT entity from CHARIOT middleware
- `PayloadEntityResponse`: A simple response from the message requestee
- `PayloadEntityUpdate`: Similar to `PayloadEntity` and `PayloadEntityRegistration`
- `PayloadEntityAttribute`: Message for modifiying an entity attribute such as `location`,`ip` except `operations` and `properties`. 

## Service API

A service API is needed for describing a service in an IoT environment. Unlike device api, a service should be  customizable and should communicate with other IoT entities such as devices, humans and other services. Service API is built upon entity definition in `common api`. It offers adding new properties at the runtime with the aim of storing and processing an entity value.

A simplified service can be written as below:

```java

Service service = new ServiceBuilder()
 .setUuid(UUID.fromString(uuid))
 .setName("Example-Agent-Service")
 .setOperations(new Operations[]{})
 .setProperties(new Property[]{})
 .buildService();

```

Predictive Maintenance Service reflects the full featured usage of the service api.

## Registration API

IoT entities registers themselves using the `registration api` , so that they can be represented as an agent in CHARIOT middleware and can interact with each other. The registration process relies on a client-server interaction. Each entity having registration intentation behaves as a client and send a registration request to the registration server. Afterwards, the registation server forwards the entity registration request to the Knowledge Management Service, which is responsible for storing the entity data models. A successful registration is completed with saving this model in the database and returns a success response to the client. Apart from the registration process, there are also other operations such as entity-deactivation, -update, -remove, and adding a new entity property to an existing entity.  

Registration API is implemented as modular as possible and can be adapted to any system if the required parts are implemented.   The registration process uses MQTT communication protocol while transmitting the messages. If you plan to use another protocol, then a similar structure with the current implementation is doable.

### CHARIOT Entity Registration Process

This API is an important piece of CHARIOT middleware and it is already in the beginning explained how IoT entities register themselves, so that they can interact with each other on the same platform. CHARIOT middleware due to the entity heterogeneity offers two different registration processes, which are explained below.

The first registration process is conducted directly by the CHARIOT agents, whereas the second one requires two step registration, where an IoT entity tries to match its agent in the agent world. 

#### Registrar Agent

As aforementioned one of the registration api component is the registration server, which is embedded in Registrar Agent. It is accessible by all other agents and it can multiplied in different domains if required. This agent difers from agents representing IoT entities, since it is unique role is to answer the registration requests and direct them to the suitable component. 

Registrar Agent starts with a MQTT topic and listens all requests from this channel. The requester subscribes itself to a topic with its UUID, and start listening this channel. The incoming registration request is forwarded to the KMS (Knowledge Management Service), where it is saved in the database if the entity data model is correct. The response sent by KMS is forwarded to the topic, which is listened by the requester. As soon as the requester receives the response, the registration process is completed.

#### Agent Registration

An IoT entity is represented via an Agent in CHARIOT world. As soon as it is started, its registration is triggered and it starts communicating with Registrar Agent. A completed registration makes avaible IoT entity along with its features in CHARIOT middleware, so all functionalities provided by the agent will be reachable by other agents. Registration api supports four agent registration types, namely, actor-,sensor-, service-, and human-registration. Below we give the usage examples for each entity. In order to execute the following examples, it is recommended to look at an agent implementation example in which all following codes are already implemented. 

**Device (Sensor & Actor) Agent Registration:**

```java
public class DeviceAgentExample extends DeviceAgent  {

    @Override
    public void doStart() throws Exception {
        this.setEntity( new DeviceBuilder()
                .setUuid(getEntityId())
								.setType(IoTEntity.SENSOR)
                .setName("Example-Agent")
                .setDeviceLocation(
                        new Location(
                                "PM-Location", "Room",
                                "Predictive Maintenance Room", 0,
                                new Position(0, 0, "0"),
                                new Indoorposition("0", 0, 0)
                        )
                )
                .addProperty( new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                        .setKey("status").setType(ValueTypes.BOOLEAN).setValue(false)
                        .setUnit("").setWritable(false).buildDeviceProperty())
                .buildSensingDevice());

        this.register();
    }
}
```



**Service Agent Registration:**

```java
public class ServiceAgentExample extends ServiceAgent {

    @Override
    public void doStart() throws Exception {
         this.setEntity(new ServiceBuilder()
                .setName("container-service-1")
                .setUuid(getEntityId())
                .addProperty(new ServicePropertyImpl(timestamp,"squareid",ValueTypes.STRING,"id","",false,null))
                .addProperty(new ServicePropertyBuilder()
                        .setTimestamp(new Date().getTime()).setKey("products").setType("string")
                        .setValue(new String[0]).setUnit("").setWritable(true)
                        .buildServiceProperty())
                .addProperty(new ServicePropertyBuilder()
                        .setTimestamp(new Date().getTime()).setKey("devices").setType("string")
                        .setValue(new String[0]).setUnit("").setWritable(true)
                        .buildServiceProperty())
                .buildService()
        );
        this.register();
    }
}
```



**Human Registration:**

```java
public class HumanAgentExample extends HumanAgent {

    @Override
    public void doStart() throws Exception {
        this.setEntity(new HumanBuilder()
            .setUuid(getEntityId())
            .setName(username)
            .setType(IoTEntity.HUMAN)
            .setLocation( new Location(
              "Smart Factory", "Room",
              "Production Line", 0,
              new Position(0, 0, "0"),
              new Indoorposition("0", 0, 0)
            ))
            .addProperty(new HumanPropertyImpl(0, "name","string","value","",true) )
            .addProperty(new HumanPropertyImpl(0, "skills","string","","",true) )
            .addProperty(new HumanPropertyImpl(0, "tasks","string","","",true))
            .addProperty(new HumanPropertyImpl(0, "permissions","string","","",true))
            .build()
        );
        this.register();
    }
}
```



#### Entity Registration via Runtime Environment (RE) & Agent 

Devices that have less capacities and are not able to run agents on their resource-constrained environments are connected through CHARIOT REs to their agents. RE plays IoT gateway role and transmits the messages in both direction, namely, from agent to device and vice versa. In the previous section, it is detailed how IoT entities are registered using the relevant classes. The unique difference from those classes, IoT  entity agent has to recognize beforehand its entity that will be connected through an RE. The recognition process is done via entity UUID. In addition, the entity model should include in the `reId`field `REIDREQUIRED`. Registrar Agent distinguishes by checking this field, whether it is only an agent registration or its device and its agent registration. In case this field is encountered, Registrar Agent informs the device or agent as soon as possible in order to start the communication between them. The order of the registrations for the agent and device does not make difference. 

This type of registration is commonly employed for the resource constrained devices, therefore a device registration example from the agent perspective is given below:



```java
public class DeviceBean extends DeviceAgentForRE {

	@Override
	public void doStart() throws Exception {
		this.setEntity(new DeviceBuilder()
            .setName("color-sensor")
            .setType(IoTEntity.SENSOR)
            .setUuid(getEntityId())
            .setDeviceLocation(
                    new Location(
                            "PL-Location", "Room", "Production Line", 11,
                            new Position(0, 0, "0"),
                            new Indoorposition("0", 0, 0)
                    )
            ).
            addProperty(new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                    .setKey("status").setType(ValueTypes.BOOLEAN).setValue(false)
                    .setUnit("").setWritable(false).buildDeviceProperty())
            .addProperty( new DevicePropertyBuilder().setTimestamp(new Date().getTime())
                    .setKey("color").setType(ValueTypes.STRING).setValue("red").setUnit("")
                    .setWritable(false).buildDeviceProperty())
            .buildSensingDevice()
    );
	register(); 
}
```

As seen, the identifiable discrepiency from the previous device registration process is only the extended class name. `DeviceAgentForRE` is a specialized class that assumes the connection with the related RE will be over MQTT. If another communication protocol is aimed, then it is recommended to use `DeviceAgent` class and describe separately the interaction way with the RE to be connected. As CHARIOT REs integrates MQTT protocol, it is preferred to implement an additional class for devices that are connected via an RE.

The registration  must be also started by the RE in order to complete this process and establish device-agent path. How the registration is started by an RE is explained in Runtime Environments section. It is recommended to look at it in case more details required.



## Contacts: 
Any question related to the CHARIOT APIs can be directed to the following contributors:
- Cem Akpolat: [akpolatcem@gmail.com](mailto://akpolatcem@gmail.com)
- Frederic Abraham: [mail@fabraham.dev](mailto://mail@fabraham.dev)
