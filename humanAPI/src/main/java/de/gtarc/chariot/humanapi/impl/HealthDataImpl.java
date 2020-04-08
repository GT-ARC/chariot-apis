package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.human.utils.CommonDate;
import de.gtarc.chariot.humanapi.HealthData;
import org.bson.types.ObjectId;

import java.util.UUID;

public class HealthDataImpl implements HealthData {
//	
//	public static final String TAG_HEALTH_DATA = "health_data";
//	public static final String TAG_WORKER_ID = "worker_id";
//	public static final String TAG_MEASUREMENT_TIME = "measurement_time";
//	public static final String TAG_HEART_RATE = "heart_rate";
//	public static final String TAG_STEP_STATUS = "step_status";
//	public static final String TAG_FEEL_STATUS = "feel_status";
//	public static final String TAG_WORK_STATUS = "work_status";

    private String healthDataId;
    private String humanId;
    private CommonDate time;
    private int heartRate;
    private String stepStatus;
    private String feelStatus;
    private String workStatus;
    private String status;
    private ObjectId _id;

    public HealthDataImpl() {
        this.healthDataId = UUID.randomUUID().toString();
    }

    public HealthDataImpl(UUID workerId, CommonDate time, int heartRate, String stepStatus, String feelStatus,
                          String workStatus) {
        this.humanId = workerId.toString();
        this.time = time;
        this.heartRate = heartRate;
        this.stepStatus = stepStatus;
        this.feelStatus = feelStatus;
        this.workStatus = workStatus;
        this.healthDataId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public UUID getHealthDataId() {
        return UUID.fromString(healthDataId);
    }

    public HealthDataImpl(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public UUID getHumanId() {
        return UUID.fromString(humanId);
    }

    public void setHumanId(UUID humanId) {
        this.humanId = humanId.toString();
    }

    public CommonDate getTime() {
        return time;
    }

    public void setTime(CommonDate time) {
        this.time = time;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getStepStatus() {
        return stepStatus;
    }

    public void setStepStatus(String stepStatus) {
        this.stepStatus = stepStatus;
    }

    public String getFeelStatus() {
        return feelStatus;
    }

    public void setFeelStatus(String feelStatus) {
        this.feelStatus = feelStatus;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
