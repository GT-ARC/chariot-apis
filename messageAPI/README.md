
# Message-API

- This is an API for encapsulating messages with a header and a payload.
- It uses Google Gson, A Java serialization/deserialization library, for encoding the encapsulated messages to json strings.(https://github.com/google/gson)
- A message consists of these attributes:
    
    * url
        - The host url, example:
        - ~~~
            tcp://ec2-18-195-119-211.eu-central-1.compute.amazonaws.com:1883
          ~~~
    * topic
        - Topic name
    * responseTopic
        - Response topic if a response needed
    * from
        - Sending device info
    * to
        - Receiving device info
    * timeSent
        - The time which the message has been sent.
    * timeReceived
        - The time which the message has been recieved.
    * messageType
        - The class name of the payload, which is used for automatic object creation with using java reflection.
    * payload
        - The payload object which will store the message contents.
- ##### Build instructions:

    ~~~
    mvn clean test package
    ~~~
#### Usage:

You can create custom payload classes and easily plug & use this library to auto serialize/deserialize custom classes.

- Create a simple class and extend it using AbstractPayload
- If you want to use custom classes under the payload object, 
you can also override the **getJsonString** and **fromJsonStringImpl** methods to customize the payload.



    public class PayloadExampleImpl extends AbstractPayload {
    
        // Some custom variables in the payload.
        // By default, the payload json string will contain all of the variables defined.
        public String payload;
        
        // Default constructor
        public PayloadDefaultImpl() {
    
        }
        
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

After that, you can create a message using the MessageBuilder class
    
    //Create a custom payload and plug into the message.
    IPayload payload = new PayloadExampleImpl();
    
    // Create a message using the builder pattern
    IMessage message = new MessageBuilder()
            .setUrl("url")
            .setTopic("topic")
            .setResponseTopic("responsetopic")
            .setFrom("from")
            .setTo("to")
            .setMessageType(payload.getClass().getName())
            .addPayload(payload)
            .build();
    
    // With this string, you can reconstruct the message whenever it needed.
    String string = message.getJsonObject();
    
    
    // Reconstruct the message using a json string.
    IMessage newMessage = MessageBuilder.fromJsonString(string);



##Payload types

####They are used to communicate with the registrationAPI as well as with the dbhandlerAPI

PayloadEntity

PayloadEntityDeactivation

PayloadEntityKeepAlive

PayloadEntityOperation

PayloadEntityProperty

PayloadEntityPropertyAdd

PayloadEntityRegistration

PayloadEntityRemoval

PayloadEntityResponse

PayloadEntityUpdate