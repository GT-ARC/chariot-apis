package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.DeviceStatus;

public class DeviceStatusImpl implements DeviceStatus {
    Double cpuUsage = null;
    Double memUsage = null;

    public DeviceStatusImpl() {
    }

    public DeviceStatusImpl(Double cpuUsage, Double memUsage) {
        this.cpuUsage = cpuUsage;
        this.memUsage = memUsage;
    }

    @Override
    public Double getCpuUsage() {
        return cpuUsage;
    }

    @Override
    public void setCpuUsage(Double value) {
        this.cpuUsage = value;

    }

    @Override
    public Double getMemoryUsage() {
        return memUsage;
    }

    @Override
    public void setMemoryUsage(Double value) {
        this.memUsage = value;
    }

}
