package de.gtarc.chariot.connectionapi.impl;


import de.gtarc.chariot.connectionapi.*;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;
import de.gtarc.chariot.messageapi.impl.MessageBuilder;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MqttConnectionImpl extends AbstractConnectionImpl implements DeviceConnection, ServiceConnection, HumanConnection, MqttCallback {


    private MqttClient client;
    private MqttConnectOptions conOpt;

    private String host;
    private String clientName;

    public Map<String, MessageResponse> tempTopics = new ConcurrentHashMap<>();
    public List<String> subscribedTopics = new CopyOnWriteArrayList<>();


    public MqttConnectionImpl(String host, String username, String password, String clientName) throws ConnectionException {


        this.host = host;
        this.clientName = clientName;


        conOpt = new MqttConnectOptions();
        conOpt.setCleanSession(true);
        conOpt.setUserName(username);
        conOpt.setPassword(password.toCharArray());

        try {
            this.client = new MqttClient(this.host, this.clientName, new MemoryPersistence());
        } catch (MqttException e) {
            throw new ConnectionExceptionImpl(e);
        }
        this.client.setCallback(this);
    }


    @Override
    public void connect() throws ConnectionException {

        if (!isConnected()) {

            for (int i = 0; i < 3; i++) {
                try {
                    client.connect(conOpt);
                    if (client.isConnected()) {
                        break;
                    }
                } catch (MqttException e) {
                    System.out.println("Connection failed to the server, try: " + (i + 1));
                    if (i == 2) {
                        throw new ConnectionExceptionImpl(e);
                    }
                    try {
                        client.disconnectForcibly();
                        client.close();
                        client = new MqttClient(this.host, this.clientName, new MemoryPersistence());
                        Thread.sleep(10000);
                    } catch (InterruptedException | MqttException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            System.out.println("MQTT connected and connected: " + this.host);
        }


    }


    @Override
    public void disconnect() throws ConnectionException {
        System.out.println("MQTT disconnected from: " + this.host);
        if (isConnected()) {
            try {
                client.disconnect();
                client.close();
                setStatus(ConnectionStatus.DISCONNECTED);
            } catch (MqttException e) {
                setStatus(ConnectionStatus.FAIL);
                throw new ConnectionExceptionImpl(e);
            }
        } else {
            setStatus(ConnectionStatus.DISCONNECTED);
        }
        client = null;
    }

    @Override
    public boolean isConnected() {
        return this.client != null && this.client.isConnected();
    }


    public void subscribeTopic(String topic) throws ConnectionException {
        if (!subscribedTopics.contains(topic)) {
            subscribedTopics.add(topic);
            try {
                client.subscribe(topic);
            } catch (MqttException e) {
                throw new ConnectionExceptionImpl(e);
            }
            System.out.println("MQTT subscribed to topic: " + topic);

        }
    }

    public void unsubscribeTopic(String topic) throws ConnectionException {
        if (subscribedTopics.contains(topic)) {
            subscribedTopics.remove(topic);
            try {
                client.unsubscribe(topic);
            } catch (MqttException e) {
                throw new ConnectionExceptionImpl(e);
            }
            System.out.println("MQTT unsubscribed from topic: " + topic);

        }

    }

    public void send(String topic, String message) {
        try {
            client.publish(topic, new MqttMessage(message.getBytes()));
        } catch (MqttException e) {
            try {
                throw new ConnectionExceptionImpl(e);
            } catch (ConnectionExceptionImpl connectionException) {
                connectionException.printStackTrace();
            }
        }
    }


    @Override
    public void send(IMessage message) throws ConnectionException {
        if (isConnected()) {
            if (((AbstractMessage) message).getResponseTopic() != null) {
                try {
                    if (!this.subscribedTopics.contains(((AbstractMessage) message).getResponseTopic())) {
                        tempTopics.put(((AbstractMessage) message).getResponseTopic(), new MessageResponse());
                        System.out.println("MQTT subscribed response topic temporarily: " + ((AbstractMessage) message).getResponseTopic());
                        client.subscribe(((AbstractMessage) message).getResponseTopic());
                    }
                } catch (MqttException e) {
                    throw new ConnectionExceptionImpl(e);
                }
            }
            MqttMessage mqttMsg = new MqttMessage(((AbstractMessage) message).getJsonObject().getBytes());
            try {
                System.out.println("Sending message: " + ((AbstractMessage) message).getMessageType() + ", to topic: " +
                        ((AbstractMessage) message).getTopic());
                client.publish(((AbstractMessage) message).getTopic(), mqttMsg);
            } catch (MqttException e) {
                throw new ConnectionExceptionImpl(e);
            }
        }
    }


    @Override
    public void notifyListener(IMessage message) throws ConnectionException {
        try {
            if (tempTopics.containsKey(((AbstractMessage) message).getTopic())) {
                client.unsubscribe(((AbstractMessage) message).getTopic());
                tempTopics.get(((AbstractMessage) message).getTopic()).setResponse((AbstractMessage) message);

                System.out.println("MQTT unsubscribed from temporarily response topic: "
                        + ((AbstractMessage) message).getTopic());
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
        for (ConnectionListener listener : this.connectionListeners) {
            System.out.println("onMessageReceived called, listener: " + listener.getClass().getName());
            listener.onMessageReceived(message, this);
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("Connection lost: " + throwable);
        try {
            disconnect();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    //callback function for incoming messages.
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String str = new String(mqttMessage.getPayload());
        AbstractMessage msg = MessageBuilder.fromJsonString(str);
        this.notifyListener(msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        return;
    }


    @Override
    public List<ConnectionListener> getConnectionListeners() {
        return this.connectionListeners;
    }

    @Override
    public void addConnectionListener(ConnectionListener listener) {
        System.out.println("setconnectionlistener: " + listener.getClass().getName());
        this.connectionListeners.add(listener);
    }

    @Override
    public boolean removeConnectionListener(ConnectionListener listener) {
        return this.connectionListeners.remove(listener);
    }

    public AbstractMessage sendAndWaitResponse(IMessage message) throws ConnectionException {
        send(message);
        AbstractMessage result = null;
        try {
            result = this.tempTopics.get(((AbstractMessage) message).getResponseTopic()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public class MessageResponse implements Future<AbstractMessage> {
        private boolean isFinished = false;
        private AbstractMessage response = null;
        private Object object = new Object();

        public void setResponse(AbstractMessage message) {
            synchronized (object) {
                this.response = message;
                isFinished = true;
                this.object.notify();
            }
        }

        @Override
        public boolean cancel(boolean b) {
            object.notify();
            return true;
        }

        @Override
        public boolean isCancelled() {
            return isFinished;
        }

        @Override
        public boolean isDone() {
            return isFinished;
        }

        @Override
        public AbstractMessage get() throws InterruptedException {
            synchronized (object) {
                if (!isFinished) {
                    object.wait();
                }
            }
            isFinished = true;
            return response;
        }

        @Override
        public AbstractMessage get(long l, TimeUnit timeUnit) throws InterruptedException {
            synchronized (object) {
                timeUnit.timedWait(object, l);
            }
            isFinished = true;
            return response;

        }
    }
}
