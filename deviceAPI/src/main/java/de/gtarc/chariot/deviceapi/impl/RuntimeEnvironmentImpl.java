package de.gtarc.chariot.deviceapi.impl;

import de.gtarc.chariot.deviceapi.Device;
import de.gtarc.chariot.deviceapi.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RuntimeEnvironmentImpl implements RuntimeEnvironment {

    private UUID id;
    private String platform;
    private int reStatus;
    private List<Device> managedDevices = new ArrayList<Device>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Device> getManagedDevices() {
        return managedDevices;
    }

    public void registerDevice(Device device) {
        if (this.managedDevices == null) {
            this.managedDevices = new ArrayList<Device>();
        } else {
            this.managedDevices.add(device);
        }
    }

    public int getReStatus() {
        return reStatus;
    }

    public void setReStatus(int value) {
        reStatus = value;
    }

}
