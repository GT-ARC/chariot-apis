//package testing.test;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import deviceapi.connection.DeviceConnection;
//import deviceapi.connection.URIBasedConnection;
//import deviceapi.connection.impl.AbstractConnectionImpl;
//
//public class WebSocketClient  extends AbstractConnectionImpl implements DeviceConnection, URIBasedConnection  {
//	private static final Logger log = LoggerFactory.getLogger(WebSocketClient.class);
//
//	@Override
//	public String getConnectionURI() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setConnectionURI(String value) {
//		// TODO Auto-generated method stub
//		
//	}
//
//    @Override
//    public void connect() throws ConnectionException {
//        try {
//            log.debug("connecting...");
//
//            if(!isConnected()){
//
//                initConnection(); // Setup
//                
//
//                //setStatus(ConnectionStatus.CONNECTED); 
//
//            }
//        } catch (Exception e) {
//            setStatus(ConnectionStatus.FAIL);
//            throw new ConnectionException(e);
//        }
//
//    }
//
//    public void reconnectTo(String url) throws ConnectionException{
//        log.debug("re-connect to: " + this.url);
//
//        if(isConnected()) disconnect();
//
//        this.url = url;
//
//        connect();
//
//    }
//
//    @Override
//    public void disconnect() throws ConnectionException {
//    	 log.debug("disconnecting... (isConnected: "+isConnected()+")");
//
//         if(isConnected()){
//             // Send CLOSE request..
//             connection.close();  // will fire event CLOSE on 'wrapped connection'
//             setStatus(ConnectionStatus.DISCONNECTING);
//         }else{ // set 'disconnected' in case of previous connection fail.
//             setStatus(ConnectionStatus.DISCONNECTED);
//         }
//         connection = null;
//    }
//
//    @Override
//    public boolean isConnected() {
//        return false;
//    }
//
//    @Override
//    public void send(Message message) throws IOException {
//      
//    }
//
//    private void initConnection() throws IOException{
//        
//    }
//}
