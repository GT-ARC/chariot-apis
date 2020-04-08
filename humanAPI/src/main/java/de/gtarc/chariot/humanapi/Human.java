package de.gtarc.chariot.humanapi;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.HumanConnection;
import de.gtarc.commonapi.Entity;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.util.List;
import java.util.UUID;


public interface Human extends Entity {


    List<UUID> getPreferences();

    List<UUID> getActions();

    UUID getHealthData();

    List<UUID> getSkills();

    List<UUID> getPermissions();

    List<Property> getProperties();

    List<UUID> getHumanRoles();

    Location getLocation();

    void setPreferences(List<UUID> preferences);

    void addPreference(UUID preference);

    void removePreference(UUID preference);


    void setActions(List<UUID> actions);

    void addAction(UUID action);

    void removeAction(UUID action);


    void setHealthData(UUID status);

    void setLocation(Location location);


    void setSkills(List<UUID> skills);

    void addSkill(UUID skill);

    void removeSkill(UUID skill);


    void setPermissions(List<UUID> permissions);

    void addPermission(UUID permission);

    void removePermission(UUID permission);


    void setProperties(List<Property> properties);

    void addProperty(Property property);

    void removeProperty(Property property);


    void setHumanRoles(List<UUID> roles);

    void addHumanRole(UUID role);

    void removeHumanRole(UUID role);


    UUID getAccount();

    List<UUID> getTasks();

    void setAccount(UUID account);

    void setTasks(List<UUID> tasks);

    void addTask(UUID task);

    void removeTask(UUID task);

    HumanConnection getConnectionHandler();

    void setConnectionHandler(Connection value);
}
