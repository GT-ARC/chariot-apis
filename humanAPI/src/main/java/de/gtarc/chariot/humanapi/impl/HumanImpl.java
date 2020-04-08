package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.HumanConnection;
import de.gtarc.chariot.humanapi.Human;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HumanImpl implements Human {

    private UUID humanId;
    private String name;
    private UUID healthData;
    private Location location;
    private Connection connection;
    private UUID accountId;
    private String friendlyName;
    private String vendor;
    private String platform;
    private String type;
    private String ip;
    private String securityKey;
    private String reId;

    private List<UUID> humanRoles;
    private List<UUID> preferences = new ArrayList<UUID>();
    private List<UUID> actions = new ArrayList<UUID>();
    private List<UUID> tasks = new ArrayList<UUID>();
    private List<UUID> skills = new ArrayList<UUID>();
    private List<UUID> permissions = new ArrayList<UUID>();
    private List<Property> properties = new ArrayList<Property>();
    private List<UUID> roles = new ArrayList<UUID>();
    private List<Operation> operations = new ArrayList<Operation>();

    public HumanImpl() {
        this.humanId = UUID.randomUUID();
    }

    public HumanImpl(UUID uuid) {
        this.humanId = uuid;
    }

    public void setHealthData(UUID value) {
        healthData = value;
    }

    public String getReId() {
        return this.reId;
    }

    public void setReId(String reId) {
        this.reId = reId;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSecurityKey() {
        return this.securityKey;
    }

    public void setSecurityKey(String key) {
        this.securityKey = key;
    }

    public String getName() {
        return this.name;
    }

    public List<UUID> getPreferences() {
        return this.preferences;
    }

    public List<UUID> getActions() {
        return this.actions;
    }

    public UUID getHealthData() {
        return healthData;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<UUID> getSkills() {
        return this.skills;
    }

    public List<UUID> getPermissions() {
        return this.permissions;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public List<UUID> getHumanRoles() {
        return this.humanRoles;
    }


    @Override
    public void addTask(UUID task) {
        if (task != null) {
            if (!this.tasks.contains(task)) {
                this.tasks.add(task);
            }
        }
    }

    @Override
    public void removeTask(UUID task) {
        if (task != null) {
            this.tasks.remove(task);
        }
    }


    @Override
    public void addPreference(UUID preference) {
        if (this.preferences != null) {
            if (!this.preferences.contains(preference)) {
                this.preferences.add(preference);
            }
        }
    }

    @Override
    public void removePreference(UUID preference) {
        if (this.preferences != null) {
            this.preferences.remove(preference);
        }
    }

    @Override
    public void addAction(UUID action) {
        if (this.actions != null) {
            if (!this.actions.contains(action)) {
                this.actions.add(action);
            }
        }
    }

    @Override
    public void removeAction(UUID action) {
        if (this.actions != null) {
            this.actions.remove(action);
        }
    }

    @Override
    public void addSkill(UUID skill) {
        if (this.skills != null) {
            if (!this.skills.contains(skill)) {
                this.skills.add(skill);
            }
        }
    }

    @Override
    public void removeSkill(UUID skill) {
        if (this.skills != null) {
            this.skills.remove(skill);
        }
    }

    @Override
    public void addPermission(UUID permission) {
        if (this.permissions != null) {
            if (!this.permissions.contains(permission)) {
                this.permissions.add(permission);
            }
        }
    }

    @Override
    public void removePermission(UUID permission) {
        if (this.permissions != null) {
            this.permissions.remove(permission);
        }
    }

    @Override
    public void addProperty(Property property) {
        if (this.properties != null) {
            if (!this.properties.contains(property)) {
                this.properties.add(property);
            }
        }
    }

    @Override
    public List<Property> getProperty() {
        return this.properties;
    }

    @Override
    public void removeProperty(Property property) {
        if (this.properties != null) {
            this.properties.remove(property);
        }
    }

    @Override
    public void addHumanRole(UUID role) {
        if (this.humanRoles != null) {
            if (!this.humanRoles.contains(role)) {
                this.humanRoles.add(role);
            }
        }

    }

    @Override
    public void removeHumanRole(UUID role) {
        if (this.humanRoles != null) {
            this.humanRoles.remove(role);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreferences(List<UUID> preferences) {
        if (preferences != null) {
            for (UUID id : preferences) {
                this.preferences.add(id);
            }
        } else {
            System.out.print("Preference list is null");
        }
    }

    public void setAccount(UUID account) {
        if (account != null) {
            this.accountId = account;
        }
    }

    public void setActions(List<UUID> actions) {
        if (actions != null) {
            for (UUID id : actions) {
                this.actions.add(id);
            }
        }
    }

    public void setTasks(List<UUID> tasks) {
        if (tasks != null) {
            for (UUID id : tasks) {
                this.tasks.add(id);
            }
        }
    }

    public void setLocation(Location location) {
        if (location != null) {
            this.location = location;
        }
    }


    public void setSkills(List<UUID> skills) {
        if (skills != null) {
            for (UUID id : skills) {
                this.skills.add(id);
            }
        }
    }

    public void setPermissions(List<UUID> permissions) {
        if (permissions != null) {
            for (UUID id : permissions) {
                this.permissions.add(id);
            }
        }
    }

    public void setProperties(List<Property> properties) {
        if (properties != null) {
            this.properties = properties;
        }
    }

    public void setHumanRoles(List<UUID> roles) {
        if (roles != null) {
            for (UUID id : roles) {
                this.roles.add(id);
            }
        }
    }

    @Override
    public UUID getUUIdentifier() {
        return this.humanId;
    }

    @Override
    public void setUUIdentifier(UUID value) {
        this.humanId = value;

    }

    @Override
    public URI getNamespaceUri() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNamespaceUri(URI value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getVendor() {
        return this.vendor;
    }

    @Override
    public void setVendor(String value) {
        this.vendor = value;

    }

    @Override
    public String getFriendlyName() {
        return this.friendlyName;
    }

    @Override
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public void addOperation(Operation operation) {
        this.addOperation(operation);

    }

    @Override
    public List<Operation> getOperations() {
        return null;
    }

    @Override
    public String getPlatform() {
        return this.platform;
    }

    @Override
    public void setPlatform(String value) {
        this.platform = value;

    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public UUID getAccount() {
        return this.accountId;
    }

    @Override
    public List<UUID> getTasks() {
        return this.tasks;
    }

    @Override
    public HumanConnection getConnectionHandler() {
        return (HumanConnection) this.connection;
    }

    @Override
    public void setConnectionHandler(Connection value) {
        this.connection = (HumanConnection) value;

    }


}
