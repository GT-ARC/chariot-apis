package de.gtarc.chariot.registrationapi.server;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.ConnectionListener;
import de.gtarc.chariot.connectionapi.ConnectionStatus;
import de.gtarc.chariot.dbhandlerapi.DbHandler;
import de.gtarc.chariot.dbhandlerapi.DummyDbHandler;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.messageapi.AbstractMessage;
import de.gtarc.chariot.messageapi.IMessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class will be used for managing the registration server. It can be started either as dummy server or as real server interface.
 * @author cemakpolat
 *
 */
public class RegistrationServer implements ConnectionListener {

    public ExecutorService executorService;
    Connection conn;
    DbHandler dbhandler;
    private int poolSize = 100;

    public RegistrationServer(Connection conn, DbHandler dummyDbHandler) {
        executorService = Executors.newFixedThreadPool(poolSize);

        this.dbhandler = dummyDbHandler;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }
    
    public RegistrationServer(Connection conn, KmsHandler dbhandler) {
        executorService = Executors.newFixedThreadPool(poolSize);

        this.dbhandler = dbhandler;
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }


    public void setConn(Connection conn) {
        if (this.conn != null)
            this.conn.getConnectionListeners().forEach(listener -> this.conn.removeConnectionListener(listener));
        this.conn = conn;
        this.conn.addConnectionListener(this);
    }

    public DbHandler getDbHandler() {
        return dbhandler;
    }

    public void setDbHandler(DbHandler dbhandler) {
        this.dbhandler = dbhandler;
    }


    @Override
    public void connectionStateChanged(Connection connection, ConnectionStatus connectionStatus) {

    }
    
    @Override
    public void onMessageReceived(IMessage iMessage, Connection connection) {
        System.out.print("Message is arrived on Registration Server:");
        
        if(dbhandler instanceof DummyDbHandler) {
        	executorService.execute(new DummyRegisterRunner((AbstractMessage) iMessage, connection, dbhandler));	
        }if(dbhandler instanceof KmsHandler) {
        	executorService.execute(new RegisterRunner((AbstractMessage) iMessage, connection, dbhandler));
        }
    }


    public void close() throws ConnectionException {
        if (this.conn != null) {
            this.conn.disconnect();
        }
    }


}
