# Registration API for IOT Devices  :calling:

This allows the registration process of the IOT devices using the ConnectionApi, the MessageApi and the Device Api.
The main purpose of the tool is to provide an async, flexible and developable Registration API for developers in the Chariot Project.
This api can be used to create both the server(registerAgent) and the client(...sensorAgent) side.

### Build

Create a jar using 
    
```
mvn clean package
```

By default, the jar file will be added to the *target* folder in our project.
When creating jar: include the ConnectionApi, the DeviceApi and the MessageApi along with the RegsitrationApi in the jar file. 

### Usage

##### Creating server
    
```
Connection dcServer = new MqttConnectionImpl(host, username, password, clientId);
try {
    dcServer.connect();
} catch (ConnectionException e) {
    e.printStackTrace();
}
((MqttConnectionImpl) dcServer).subscribeTopic(TopicConfig.getRegisterTopic());

DbHandler dummyDbHandler = new DbHandlerDummyImpl();
KmsHandlerImpl kms = new KmsHandlerImpl("http://chariot-km.dai-lab.de:8080/v1", "/devices/");

RegistrationServer registrationServer = new RegistrationServer(dcServer, dummyDbHandler);

dcServer.disconnect();
```

##### Agent Registration(with and without reid)

```
Device chDevice = new DeviceBuilder().buildSensingDevice();
chDevice.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

AbstractMessage message = null;
DeviceConnection dcl = null;

try {
    dcl = new MqttConnectionImpl(host, username, password, clientId);
    dcl.connect();
    chDevice.setConnectionHandler(dcl);
} catch (ConnectionException e1) {
    e1.printStackTrace();
}

RegistrationClient registrationHandler = new RegistrationClient();

// Registration of the agent without re registered.
Future<RegistrationResult> result = registrationHandler.registerDeviceAgent(chDevice, agentUUID, "", chDevice.getVendor(), chDevice.getType());

try {
    message = result.get().result;
    //AbstractMessage message = result.get(5, TimeUnit.SECONDS).result;
    System.out.println("registrar agent-" +((PayloadResponse) message.getPayload()).response);
    if (((PayloadResponse) message.getPayload()).response.equalsIgnoreCase("Success")) {
        dcl.disconnect();
    }
} catch (InterruptedException e) {
    e.printStackTrace();
} catch (ExecutionException e) {
    e.printStackTrace();
} catch (ConnectionException e) {
    e.printStackTrace();
}
```

###### Tests for Agent Registration

```
// In the result, we expect the reId to be null, because RE has not been registered.
assertEquals(null, ((PayloadResponse) message.getPayload()).reId);

// We expect the reid future is not done yet, because re has not been registered.
assertFalse(result1.reid.isDone());

// After the RE registration, we can get the RE id message from the register server to get reid.
AbstractMessage reidResult = result1.reid.get(5, TimeUnit.SECONDS);

// Here we can see that the reid is same as the expected value.
assertEquals(reId, ((PayloadResponse) reidResult.getPayload()).reId);
```

##### RE Registration

```
Device device2 = new DeviceBuilder().buildSensingDevice();
device2.setUUIdentifier(UUID.fromString("a1f114f5-f47f-449d-b579-6605bba061c8"));

DeviceConnection dc2 = new MqttConnectionImpl(host, username, password, "SeparatedRE");
dc2.connect();
device2.setConnectionHandler(dc2);
RegistrationClient registrationClient2 = new RegistrationClient();



Device devices[] = new Device[]{new DeviceBuilder().setName("temperature-sensor-1")
        .setFriendlyName("Temperature Sensor")
        .setType("sensor")
        .setVendor("xx")
        .setDeviceStatus(new DeviceStatusImpl(
                new Location("", "", "", new Position("", "")),
                null, null))
        .setUuid(device2.getUUIdentifier()).buildSensingDevice()};
Future<ClientResult> result2 = registrationClient2.registerRe(device2, reId, devices, "");
AbstractMessage message2 = result2.get(5, TimeUnit.SECONDS).result;
dc2.disconnect();
```

##### RegistrationClient features

* `public Future<RegistrationResult> registerAgent(String agentUUID, String[] predict, String securityKey, String manufacturer, String objectType)`
    ```
    This method is used for agent registration.
    It takes agentUUID, prediction, securityKey, manufacturer and objectType and submits
    a new RunnerAgentRegistration object with these parameters passed.
    Returns a future RegistrationResult object.
    ```
* `public Future<ClientResult> registerRe(String reId, Device[] devices, String securityKey)` 
    ```
    This method is used for RE registration.
    It takes reId, devices and securityKey and submits a
    new RunnerReRegistration object with these parameters passed.
    Returns a future ClientResult object.
    ```
* `public Future<ClientResult> keepAlive(String reId, String aliveTime, String securityKey, String timestamp)`
    ```
    This method is used for keepAlive requests.
    It takes reId, aliveTime, securityKey and timestamp, and submits a
    new RunnerKeepAlive object with these parameters passed.
    Returns a future ClientResult object.
    ```
* `public Future<ClientResult> updateDevice(String reId, String securityKey)`
    ```
    This method is used for device update requests.
    It takes reId and securityKey, and submits a
    new RunnerDeviceUpdate object with these parameters passed.
    Returns a future ClientResult object.
    ```
* `public Future<ClientResult> deactivateDevice(Device device, String reId, String securityKey)`
    ```
    This method is used for device deactivate requests.
    It takes a device, reId and securityKey, and submits a
    new RunnerDeviceDeactivation object with these parameters passed.
    Returns a future ClientResult object.
    ```
* `public Future<ClientResult> removeDevice(Device device, String reId, String securityKey)`
    ```
    This method is used for device removal requests.
    It takes a device, reId and securityKey, and submits a
    new RunnerDeviceRemoval object with these parameters passed.
    Returns a future ClientResult object.
    ```
  