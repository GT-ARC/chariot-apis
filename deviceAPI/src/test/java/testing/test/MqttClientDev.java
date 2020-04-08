package testing.test;
/*
 * *****************************************************************************
 * Copyright (c) 2013-2014 CriativaSoft (www.criativasoft.com.br)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Ricardo JL Rufino - Initial API and Implementation
 * *****************************************************************************
 */


import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import de.gtarc.chariot.connectionapi.impl.AbstractConnectionImpl;
import de.gtarc.chariot.messageapi.IMessage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.IOException;

/**
 * TODO: Add docs.
 *
 * @author Ricardo JL Rufino
 * @date 19/10/16
 */
public class MqttClientDev extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection /*implements IWSConnection*/ {

    private String url;
    private MqttClient client;
    private MqttConnectOptions connectOptions;
    int qos = 2;
    private String topic = "test/temperature";
    private String moduleName = "#";


    //private static final Logger log = LoggerFactory.getLogger(WebSocketClientConnection.class);

    public MqttClientDev() {
        this.url = "http://130.149.232.227:1883";
    }

    public MqttClientDev(String url) {
        setConnectionURI(url);
    }

    @Override
    public void setConnectionURI(String uri) {
        this.url = uri;
    }


    @Override
    public String getConnectionURI() {
        return this.url;
    }


    @Override
    public void connect() {
        try {
            //log.debug("connecting...");
            System.out.println("connecting ...");
            if (!isConnected()) {

                initConnection(); // Setup

                client.connect(connectOptions);

                String apiKey = "";//TenantProvider.getCurrentID();
                //client.subscribe("test/temperature" + "/in/" + moduleName);

                client.subscribe("Output/#");
                client.subscribe("Registration/#");
                client.subscribe("Update/#");
                this.sendMessage("hello cem");
                setStatus(ConnectionStatus.CONNECTED);

            }
        } catch (Exception e) {
            setStatus(ConnectionStatus.FAIL);
            //throw new ConnectionException(e);
        }

    }

    public void reconnectTo(String url) {
        //log.debug("re-connect to: " + this.url);

        if (isConnected()) disconnect();
        this.url = url;
        connect();
    }

    @Override
    public void disconnect() {
        //log.debug("disconnecting... (isConnected: "+isConnected()+")");

        if (isConnected()) {
            // Send CLOSE request..
            try {
                client.disconnect();
                setStatus(ConnectionStatus.DISCONNECTED);
            } catch (MqttException e) {
                //log.error(e.getMessage(), e);
            }
        } else { // set 'disconnected' in case of previous connection fail.
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        client = null;
    }

    @Override
    public boolean isConnected() {
        return client != null && (client.isConnected());
    }

    @Override
    public void send(IMessage message) {
        if (isConnected()) {
//            byte[] bytes = getSerializer().serialize(message);
//            MqttMessage msg = new MqttMessage(bytes);
//            msg.setQos(qos);
//            try {
//                client.publish(topic, msg);
//            } catch (MqttException e) {
//                //throw new CommandException(e);
//            }
        } else {
            //log.warn("Can't send command, not Connected !");
        }
    }

    @Override
    public void sendMessage(String message) {
        if (isConnected()) {

            MqttMessage msg = new MqttMessage(message.getBytes());
            msg.setQos(qos);
            try {
                client.publish(topic, msg);
            } catch (MqttException e) {
                //throw new CommandException(e);
            }
        } else {
            //log.warn("Can't send command, not Connected !");
        }
    }

    private void initConnection() throws IOException {
        if (client == null) {

            String topic = "MQTT Examples";
            String content = "Message from MqttPublishSample";
            int qos = 2;
            String broker = "tcp://iot.eclipse.org:1883";
            String clientId = "JavaSample";
            MemoryPersistence persistence = new MemoryPersistence();

            try {
                MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                System.out.println("Connecting to broker: " + broker);
                sampleClient.connect(connOpts);
                System.out.println("Connected");
                System.out.println("Publishing message: " + content);
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Message published");
                sampleClient.disconnect();
                System.out.println("Disconnected");
                System.exit(0);
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }

    //https://gitlab.dai-labor.de/isco/network-layer/blob/kura/kura-gateway/src/main/java/de/gtarc/isco/network/gateway/kura/CoapGatewayServer.java
//    public void mqttPub(String topic, JSONObject rawMessage) {
//    	//String topic        = "MQTT Examples";
//        String content      = rawMessage.toString();
//        //String IP = rawMessage.getJSONObject("Content").getString("DeviceIP");
//        int qos             = 2;
//        String broker       = "tcp://"+"172.24.1.51"+":1883";
//        String clientId     = "JavaSample";
//        MemoryPersistence persistence = new MemoryPersistence();
//
//        try {
//            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
//            MqttConnectOptions connOpts = new MqttConnectOptions();
//            connOpts.setCleanSession(true);
//            System.out.println("Connecting to broker: "+broker);
//            sampleClient.connect(connOpts);
//            System.out.println("Connected");
//            System.out.println("Publishing message: "+content);
//            System.out.println("Publishing topic: "+topic);
//            MqttMessage message = new MqttMessage(content.getBytes());
//            message.setQos(qos);
//            sampleClient.publish(topic, message);
//            System.out.println("Message published");
//            sampleClient.disconnect();
//            System.out.println("Disconnected");
//        } catch(MqttException me) {
//            System.out.println("reason "+me.getReasonCode());
//            System.out.println("msg "+me.getMessage());
//            System.out.println("loc "+me.getLocalizedMessage());
//            System.out.println("cause "+me.getCause());
//            System.out.println("excep "+me);
//            me.printStackTrace();
//        }
//        return;
//    	
//    }

}
