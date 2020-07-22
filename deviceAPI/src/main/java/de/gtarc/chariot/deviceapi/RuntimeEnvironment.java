package de.gtarc.chariot.deviceapi;

import java.util.List;
import java.util.UUID;

public interface RuntimeEnvironment {

    UUID getId();

    void setId(UUID value);


    String getPlatform();

    void setPlatform(String value);


    int getReStatus();


    void setReStatus(int value);


    List<Device> getManagedDevices();

}
