package de.gtarc.chariot.registrationapi.client;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.DeviceConnection;
import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.registrationapi.client.util.ClientResult;
import de.gtarc.chariot.registrationapi.client.util.RegistrationResult;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityDeactivation;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityKeepAlive;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityPropertyAdd;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityRegistration;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityRemoval;
import de.gtarc.chariot.registrationapi.entity.RunnerEntityUpdate;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Property;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***
 *  Registration client aims at easing the integration of an IoT entity through its functions. IoT actors ranging from devices, services to human actors can be registered in the system
 *  as an IoT entity. 
 * @author cemakpolat
 *
 */
public class RegistrationClient {
    // ExecutorService is a executor which can produce Future async tasks.
    private ExecutorService executorService;

    public RegistrationClient() {
        // We are creating a single thread executor by default.
        executorService = Executors.newSingleThreadExecutor();
    }
    /**
     *
     * This method is used for ServiceAgent registration.
     * It takes device, agentUUID, securityKey, groupId, manufacturer and objectType; then submits them
     * a new RunnerDeviceRegistration object with these parameters passed.
     * Returns a future RegistrationResult object.
     * @param conn
     * @param entity
     * @param reId
     * @param securityKey
     * @param groupId
     * @param manufacturer
     * @param objectType
     * @return
     */
    public Future<RegistrationResult> registerEntity(Connection conn, Entity entity, String reId, String securityKey, String groupId, String manufacturer, String objectType) {
        return executorService.submit(new RunnerEntityRegistration(conn, entity, reId, securityKey, groupId, manufacturer, objectType));
    }

    /**
     *
     * @param conn
     * @param entity
     * @param securityKey
     * @param groupId
     * @param manufacturer
     * @param objectType
     * @return
     */
    public Future<RegistrationResult> registerEntity(Connection conn, Entity entity, String securityKey, String groupId, String manufacturer, String objectType) {
        return executorService.submit(new RunnerEntityRegistration(conn, entity, securityKey, groupId, manufacturer, objectType));
    }
    /**
     *  * This method is used for keepAlive requests.
     * It takes reId, aliveTime, securityKey and timestamp, and submits a
     * new RunnerKeepAlive object with these parameters passed.
     * Returns a future ClientResult object.
     * @param conn
     * @param device
     * @param reId
     * @param aliveTime
     * @param securityKey
     * @param timestamp
     * @return
     */
    public Future<ClientResult> keepAliveEntity(Connection conn,Entity device, String reId, String aliveTime, String securityKey, long timestamp) {
        return executorService.submit(new RunnerEntityKeepAlive(conn,device, reId, aliveTime, securityKey, timestamp));
    }
    /**
     * This method is used for entity update requests.
     * It takes reId and securityKey, and submits a
     * new RunnerEntityUpdate object with these parameters passed.
     * Returns a future ClientResult object.
     * @param conn
     * @param entity
     * @param reId
     * @param securityKey
     * @return
     */
    public Future<ClientResult> updateEntity(Connection conn,Entity entity, String reId, String securityKey) {
        return executorService.submit(new RunnerEntityUpdate(conn,entity, reId, securityKey));
    }
    /**
     * This method is used for entity deactivate requests. It takes a entity and securityKey, and submits a
     * new RunnerEntityDeactivation object with these parameters passed.
     * Returns a future ClientResult object.
     * @param conn
     * @param entity
     * @param reId
     * @param securityKey
     * @return
     */
    public Future<ClientResult> deactivateEntity(Connection conn,Entity entity, String reId, String securityKey) {
        return executorService.submit(new RunnerEntityDeactivation(conn,entity, reId, securityKey));
    }
    
    /**
     * * This method is used for entity removal requests.
     * It takes a entity and securityKey, and submits a
     * new RunnerEntityRemoval object with these parameters passed.
     * Returns a future ClientResult object.
     * @param conn
     * @param entity
     * @param reId
     * @param securityKey
     * @return
     */
    public Future<ClientResult> removeEntity(Connection conn,Entity entity, String reId, String securityKey) {
        return executorService.submit(new RunnerEntityRemoval(conn,entity, reId, securityKey));
    }

   
    /**
     * This method is used for setting the executorService
     *
     * @param executorService
     */
    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * @param property
     * @param entityUUID
     * @param securityKey
     * @return
     */
    public Future<ClientResult> addEntityProperty(Connection conn, Property property, String entityUUID, String securityKey) {
        return executorService.submit(new RunnerEntityPropertyAdd(conn, property, entityUUID, securityKey));
    }

    
    /**
     * This method closes the registration client by shutting down the executor service and device connection handler.
     *
     * @throws ConnectionException
     */
    public void close() throws ConnectionException {
        this.executorService.shutdown();
    }


}
