package de.gtarc.chariot.connectionapi.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.connectionapi.URIBasedConnection;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.*;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * A simple HTTP client implementation, which is based on Jetty Http client.
 *
 * @author cemakpolat
 */
public class WebClientConnection extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection {

    // example usage
//	public static void main(String[] args) throws Exception {
//		WebClientConnection	client = new WebClientConnection();
//		client.setConnectionURI("http://localhost:8282/");
//		client.connect();
//		client.sendByGet(client.getConnectionURI());
//		client.connect();
//		client.sendByGet(client.getConnectionURI()+"hello/");
//	}

    private static final Logger log = Logger.getLogger(WebClientConnection.class);

    private URI uri;
    HttpClient client = null;
    public final int DEFAULT_PORT = 8282;
    private int port = DEFAULT_PORT;

    ArrayList<Class<?>> registeredResources = new ArrayList<Class<?>>();
    ArrayList<Class<?>> packageResources = new ArrayList<Class<?>>();

    public void setConnectionURI(String url) {
        this.uri = URI.create(url); // example
        //this.uri = URI.create(url);
    }

    public String getConnectionURI() {
        return this.uri.toString();
    }

    public WebClientConnection(int port) {
        this.port = port;
    }

    public WebClientConnection() {

    }

    public void setPort(int port) {
        this.port = port;
    }

    protected void initClient() {
        client = new HttpClient();
    }

    @Override
    public void connect() {
        //log.info("Connecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.CONNECTING);

        if (!isConnected()) {
            try {
                initClient();
                try {
                    client.start();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                setStatus(ConnectionStatus.CONNECTED);
            } catch (Exception e) {
                //log.info("Connection Exception");
            }
        }
    }

    @Override
    public void disconnect() {
        //log.info("Disconnecting ... isConnected = " +isConnected());
        setStatus(ConnectionStatus.DISCONNECTING);
        if (isConnected()) {
            try {
                client.stop();
            } catch (Exception e) {

                e.printStackTrace();
            }
            setStatus(ConnectionStatus.DISCONNECTED);
        }
    }

    @Override
    public boolean isConnected() {
        return client != null && client.isRunning();
    }


    // update this function
    public String createRequestPath(String url, String requesttype, String query, String token) {
        System.out.println("\n\n\n Request completed" + new String(url + requesttype + "/" + query));
        return url + requesttype + "/" + query + "?token=" + token;
    }

    public String uploadFile(String url, String content, String fileName) throws IOException {
        MultiPartContentProvider multiPart = new MultiPartContentProvider();
        multiPart.addFieldPart("field", new StringContentProvider(content), null);
        multiPart.addFilePart("file", fileName, new BytesContentProvider(content.getBytes(Charset.defaultCharset())), null);
        multiPart.close();

        log.info("Upload file {" + fileName + "}" + " to " + url);

        ContentResponse response = null;
        try {
            response = client.newRequest(url)
                    .method(HttpMethod.POST)
                    .content(multiPart)
                    .send();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return response.getContentAsString();
    }

    // do a get request simple request max 2MB
    public String sendByGet(String url) {

        String response = null;
        try {
            response = client.GET(url).getContentAsString();
            // Issue a post request
//			System.out.println("HttpClientHelper:Request completed ->" +url+" result:"+ new String(response));
            return response;
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (TimeoutException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return null;
    }// Blocking request

    // DELETE Request
    public void sendByDelete(String url) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(url);

            log.info("Executing request " + httpDelete.getRequestLine());
            ResponseHandler<String> responseHandler = httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // PUT Request
    public String sendByPut(String url, String content) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(url);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            String json = content;
            StringEntity stringEntity = new StringEntity(json);
            httpPut.setEntity(stringEntity);

            log.info("Executing request " + httpPut.getRequestLine());

            ResponseHandler<String> responseHandler = httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);

                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);

            return responseBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PATCH Request
    public void sendByPatch(String url, String content) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPatch httpPatch = new HttpPatch(url);
            httpPatch.setHeader("Accept", "application/json");
            httpPatch.setHeader("Content-type", "application/json");
            String json = content;
            StringEntity stringEntity = new StringEntity(json);
            httpPatch.setEntity(stringEntity);

            System.out.println("Executing request " + httpPatch.getRequestLine());

            ResponseHandler<String> responseHandler = httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPatch, responseHandler);
            log.info("----------------------------------------");
            log.info(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendByPost(String url, String key, String value) {
        String response = null;
        try {
            if (!this.isConnected()) {
                this.connect();
            }
            response = client.POST(url).param(key, value).send().getContentAsString();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (TimeoutException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return response;
    }// Blocking request

    public String sendContentByPost(String url, String content) {
        ContentResponse response = null;
        // do a post request simple request max 2MB
        try {
            if (!this.isConnected()) {
                this.connect();
            }
            response = client.newRequest(url).method(HttpMethod.POST)
                    .content(new StringContentProvider(content), "text/plain")
                    .send();
            //System.out.println("Request completed" + response.getContentAsString());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (TimeoutException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return response.getContentAsString();
    }// Blocking request

    public String sendJsonByPost(String url, String content) {
        ContentResponse response = null;
        // do a post request simple request max 2MB
        try {
            if (!this.isConnected()) {
                this.connect();
            }
            response = client.newRequest(url).method(HttpMethod.POST)
                    .content(new StringContentProvider(content), "application/json")
                    .send();
            log.info("Request completed" + response.getContentAsString());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (TimeoutException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return response.getContentAsString();
    }// Blocking request


    public String sendFileByPost(String url, String filePathName) {
        String response = null;
        try {
            if (!this.isConnected()) {
                this.connect();
            }
            response = client.newRequest(url)
                    .method(HttpMethod.POST)
                    .file(Paths.get(filePathName), "text/xml").send().getContentAsString();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {

            e1.printStackTrace();
        } catch (TimeoutException e1) {

            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        return response;
    }


    // TODO: If asynchronous comm is foreseen, then the code structure need to be changed and event-based code structure need to be written here.
    // Non-Blocking request (Each request is operated via a thread)
    public String sendAsynchronousOnContent(String url, String content) {
        // asynchronous this works as well
        if (!this.isConnected()) {
            this.connect();
        }
        // with content
        client.newRequest(url).method(HttpMethod.POST)
                .content(new StringContentProvider(content), "text/plain").send(new Response.Listener.Adapter() {
            @Override
            public void onContent(Response response, ByteBuffer buffer) {
                String s = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("sendAsynchronousOnContent: response Listener Adapter completed" + s.toString());
            }
        });
        // without content
//		client.newRequest(url).send(new Response.Listener.Adapter() {
//			@Override
//			public void onContent(Response response, ByteBuffer buffer) {
//				String s = StandardCharsets.UTF_8.decode(buffer).toString();
//				System.out.println("response Listener Adapter completed" + s.toString());
//			}
//		});
        return null;
    }

    // Non-Blocking requests (Each request is operated via a thread)
    public void sendAsynchronousOnComplete(String url) {
        if (!this.isConnected()) {
            this.connect();
        }
        client.newRequest(url)
                // Buffer response content up to 8 MiB
                .send(new BufferingResponseListener(8 * 1024 * 1024) {
                    @Override
                    public void onComplete(Result result) {
                        if (!result.isFailed()) {
                            byte[] responseContent = getContent();
                            String s = "";
                            try {
                                s = new String(responseContent, "US-ASCII");
                                System.out.println("Request completed" + s);
                            } catch (UnsupportedEncodingException e) {

                                e.printStackTrace();
                            }

                            // Your logic here
                        }
                    }
                });
    }

    // Non-Blocking requests (Each request is operated via a thread)
    public void sendAsynchronousInputStream(String url) {
        if (!this.isConnected()) {
            this.connect();
        }
        // asynchronous inpuystreampResponseListener, this works!
        InputStreamResponseListener listener = new InputStreamResponseListener();
        client.newRequest(url).send(listener);

        // Wait for the response headers to arrive
        Response res = null;
        try {
            res = listener.get(5, TimeUnit.SECONDS);
            // Look at the response
            if (res.getStatus() == HttpStatus.OK_200) {
                // Use try-with-resources to close input stream.

                try {
                    InputStream responseContent = listener.getInputStream();
                    String theString = IOUtils.toString(responseContent, StandardCharsets.UTF_8);
                    System.out.println("Request completed" + theString.toString());
                    // Your logic here
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        } catch (TimeoutException e1) {

            e1.printStackTrace();
        } catch (ExecutionException e1) {

            e1.printStackTrace();
        } finally {
            this.disconnect();
        }
    }


}
