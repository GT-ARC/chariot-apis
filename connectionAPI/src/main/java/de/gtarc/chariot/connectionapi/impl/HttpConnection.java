package de.gtarc.chariot.connectionapi.impl;


import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class HttpConnection extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection {
    HttpClient client = new HttpClient();


    private String url;
    private String subTopic;
    private String topic;


    public HttpConnection(String url, String topic, String subTopic) {
        this.url = url;
        this.topic = topic;
        this.subTopic = subTopic;
    }


    @Override
    public String getConnectionURI() {
        return this.url;
    }

    @Override
    public void setConnectionURI(String s) {
        if (isConnected()) disconnect();
        this.url = s;
        connect();
    }

    @Override
    public void connect() {
        try {
            if (!isConnected()) {
                client.start();
                System.out.println("WebSocket connected to to : " + this.url);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setStatus(ConnectionStatus.FAIL);
        }
    }

    @Override
    public void disconnect() {
        System.out.println("WebSocket disconnected");
        if (isConnected()) {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setStatus(ConnectionStatus.DISCONNECTED);
        client = null;
    }

    @Override
    public boolean isConnected() {
        return this.client != null && this.client.isRunning();
    }

    @Override
    public void sendMessage(String s) {
        if (isConnected()) {
            try {
                ContentResponse response = client.POST(this.url)
                        .content(new StringContentProvider(this.topic + "," + s))
                        .send();
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }

    }

    public Object sendMessageAndWaitResult(String message) {
        String result = null;

        if (isConnected()) {
            try {
                ContentResponse response = client.POST(this.url)
                        .content(new StringContentProvider(this.topic + "," + message))
                        .send();
                result = response.getContentAsString();
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
