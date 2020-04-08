package testing.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

@ClientEndpoint
@ServerEndpoint(value = "/events/") // TODO: is it possible to parametirize this definition.
public class EventSocket {
    private final static Logger log = Logger.getLogger(EventSocket.class
            .getSimpleName());

    @OnOpen
    public void onWebSocketConnect(Session session, EndpointConfig config) {
        System.out.println("Socket Connected: " + session);
        final String sessionId = session.getId();


        // add text based message handler
        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String msg) {
                log.info(sessionId + ": text message: " + msg);
            }
        });

        // add binary based message handler
        session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() {

            @Override
            public void onMessage(ByteBuffer buffer) {
                log.info(sessionId + ": binary message: "
                        + new String(buffer.array()));
            }
        });
        // different type of message classes that can be used.
        session.addMessageHandler(new MessageHandler.Whole<PongMessage>() {

            @Override
            public void onMessage(PongMessage pongMessage) {
                StringBuffer pong = new StringBuffer();
                pong.append(sessionId)
                        .append(": pong message: ")
                        .append(new String(pongMessage.getApplicationData()
                                .array()));
                log.info(pong.toString());

            }
        });
        //
        String pingString = EventSocket.class.getName() + " pings";
        ByteBuffer pingData = ByteBuffer.allocate(pingString.getBytes().length);
        pingData.put(pingString.getBytes()).flip();
        try {
            session.getBasicRemote().sendPing(pingData);
        } catch (IllegalArgumentException | IOException e) {
            log.severe("error in sending ping");
        }
    }


    @OnMessage
    public void onWebSocketText(String message, Session session) {
        System.out.println("Received TEXT message: " + message);
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason) {
        System.out.println("Socket Closed: " + reason);
    }

    @OnError
    public void onWebSocketError(Throwable cause) {
        cause.printStackTrace(System.err);
    }
}

