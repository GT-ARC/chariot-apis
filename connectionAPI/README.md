#connectionAPI

##MqttConnection

How to create an MqttConnection?

    Connection dcl = new MqttConnectionImpl(host, username, password, clientId);
    
How to connect?

    dcl.connect();    
    
How to disconnect?

    dcl.disconnect();       

How to subscribe to a topic?

    dcl.subscribeTopic(String topic);

How to unsubscribe a topic?

    dcl.unsubscribeTopic(String topic);

How to add a connection listener?

    dcl.addConnectionListener(ConnectionListener listener);

##WebClientConnection

How to create a WebClientConnection?
    
    WebClientConnection client = new WebClientConnection();
    
How to set connection URI?    
    
    client.setConnectionURI(host);

How to connect?

    client.connect();
    
How to disconnect?

    client.disconnect();   

####sendByDelete

    void sendByDelete(String url);

Example:

    client.sendByDelete(client.getConnectionURI() + this.entityPath + entityId + "/");

####sendByPut

    String sendByPut(String url, String content);

Example:

    client.sendByPut(client.getConnectionURI() + this.entityPath + entityId + "/", jsonpayload);

####sendByPost

    String sendByPost(String url, String key, String value);

####sendJsonByPost

    String sendJsonByPost(String url, String content);

Example:

    client.sendJsonByPost(client.getConnectionURI() + this.entityPath, jsonpayload);

####sendContentByPost

    String sendContentByPost(String url, String content);

####sendFileByPost

    String sendFileByPost(String url, String filePathName);

####sendByGet

    String sendByGet(String url);

Example:

    allentities = client.sendByGet(client.getConnectionURI() + this.entityPath);

####sendByPatch

    void sendByPatch(String url, String content);

Example:

    client.sendByPatch(client.getConnectionURI() + this.entityPath + entityId + "/" + ((PayloadProperty) payload).getKey() + "/", stringpayload.toString());

####sendAsynchronousOnContent

    String sendAsynchronousOnContent(String url, String content);
    
####sendAsynchronousOnComplete    
    
    void sendAsynchronousOnComplete(String url);
    
####sendAsynchronousInputStream    
    
    void sendAsynchronousInputStream(String url)