package de.gtarc.chariot.humanapi.impl;

import org.bson.types.ObjectId;

import java.util.UUID;

public class PositionImpl {

    private ObjectId _id;
    private String positionName;
    private String positionId;
    private float xaxis, yaxis, zaxis;


    public PositionImpl(float x, float y, float z) {
        this.xaxis = x;
        this.yaxis = y;
        this.zaxis = z;
        this.positionId = UUID.randomUUID().toString();
    }

    public PositionImpl() {
        this.positionId = UUID.randomUUID().toString();
    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public UUID getPositionId() {
        return UUID.fromString(positionId);
    }

    public float getXaxis() {
        return xaxis;
    }

    public void setXaxis(float xaxis) {
        this.xaxis = xaxis;
    }

    public float getYaxis() {
        return yaxis;
    }

    public void setYaxis(float yaxis) {
        this.yaxis = yaxis;
    }

    public float getZaxis() {
        return zaxis;
    }

    public void setZaxis(float zaxis) {
        this.zaxis = zaxis;
    }

}
