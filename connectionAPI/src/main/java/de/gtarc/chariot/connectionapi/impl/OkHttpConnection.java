package de.gtarc.chariot.connectionapi.impl;

import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * A simple HTTP client implementation, which is based on okHttp3 client.
 *
 * @author nuryilmaz
 */
public class OkHttpConnection extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection {

    // example usage
//	public static void main(String[] args) throws Exception {
//		OkHttpConnection client = new OkHttpConnection();
//		client.setConnectionURI("http://chariot-km.dai-lab.de:8080/v1/humans/");
//		client.connect();
//		String stringToParse = "";
//		JSONParser parser = new JSONParser();
//		JSONObject json = (JSONObject) parser.parse(stringToParse);
//		client.send("http://chariot-km.dai-lab.de:8080/v1/humans/",json);
//		client.getMappings(client.getConnectionURI()+"uuid");
//		client.remove("http://chariot-km.dai-lab.de:8080/v1/humans/5dcc0d03f6bb7588249f0d44/");
//	}

    private URI uri;
    private static String url = "";
    private static final String postfix = "?format=json";
    private OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    ArrayList<Class<?>> registeredResources = new ArrayList<Class<?>>();
    ArrayList<Class<?>> packageResources = new ArrayList<Class<?>>();

    public void setConnectionURI(String url) {
        this.uri = URI.create(url); // example
        this.url = url;
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    public OkHttpConnection() {

    }

    @Override
    public void connect() {
        //log.debug("Connecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.CONNECTING);

        Request request = new Request.Builder()
                .url(url + postfix)
                .get()
                .build();

        System.out.println("Connected...");

        try (Response response = client.newCall(request).execute()) {
            if (response.code() == 404) {
                connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    //not necessary
    public void disconnect() {
        //log.debug("Disconnecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.DISCONNECTING);
        try {
            client.dispatcher().executorService().shutdown();
            client.connectionPool().evictAll();
            client.cache().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setStatus(ConnectionStatus.DISCONNECTED);
    }

    /**
     * @param url:           the url that the object will be saved in
     * @param requestObject: the json object that will be added
     * @return The body of the new entry
     * @throws IOException
     */
    public String send(String url, JSONObject requestObject) throws IOException {
        RequestBody body = RequestBody.create(JSON, requestObject.toString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        String responseBody = null;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            responseBody = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    public JSONObject getMappings(String url) throws IOException, ParseException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        JSONParser parser = new JSONParser();
        JSONObject receivedObj;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            receivedObj = (JSONObject) parser.parse(response.body().string());
        }
        return receivedObj;
    }

    public String remove(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        String responseString;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            responseString = response.body().string();
        }
        return responseString;
    }

    public String sendAsynchronous(String url, JSONObject requestObject) throws IOException, InterruptedException, ExecutionException {
        RequestBody body = RequestBody.create(JSON, requestObject.toJSONString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpResponseFuture callback = new OkHttpResponseFuture();
        client.newCall(request).enqueue(callback);

        String responseString;
        try (Response response = callback.future.get()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            responseString = response.body().string();
        }
        return responseString;
    }

    public JSONObject getAsynchronous(String url) throws InterruptedException, ExecutionException, IOException, ParseException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpResponseFuture callback = new OkHttpResponseFuture();
        client.newCall(request).enqueue(callback);

        JSONParser parser = new JSONParser();
        JSONObject receivedObj;
        try (Response response = callback.future.get()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            receivedObj = (JSONObject) parser.parse(response.body().string());
        }
        return receivedObj;
    }


}
