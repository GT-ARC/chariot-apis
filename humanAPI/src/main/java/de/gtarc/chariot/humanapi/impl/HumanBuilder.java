package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.connectionapi.Connection;
import de.gtarc.chariot.connectionapi.HumanConnection;
import de.gtarc.commonapi.Operation;
import de.gtarc.commonapi.Property;
import de.gtarc.commonapi.utils.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HumanBuilder {


    private UUID uuid;
    private String name;

    private Location location;
    private Connection connection;
    private String securitykey;
    private String ip;
    private String reId;
    private String vendor;
    private String platform;

    private UUID account;
    private UUID healthData;
    private List<UUID> preferences = new ArrayList<UUID>();
    private List<UUID> actions = new ArrayList<UUID>();
    private List<UUID> tasks = new ArrayList<UUID>();
    private List<UUID> skills = new ArrayList<UUID>();
    private List<UUID> permissions = new ArrayList<UUID>();
    private List<Property> properties = new ArrayList<Property>();
    private List<UUID> humanRoles = new ArrayList<UUID>();
    private List<Operation> operations = new ArrayList<Operation>();

    public HumanBuilder() {
    }

    public HumanBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public HumanBuilder setSecuritykey(String securitykey) {
        this.securitykey = securitykey;
        return this;
    }

    public HumanBuilder setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public HumanBuilder setReId(String reId) {
        this.reId = reId;
        return this;
    }

    public HumanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder setAccount(UUID account) {
        this.account = account;
        return this;
    }

    public HumanBuilder setHealtData(UUID healthData) {
        this.healthData = healthData;
        return this;
    }

    public HumanBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public HumanBuilder setConnection(Connection connection) {
        this.connection = (HumanConnection) connection;
        return this;
    }

    public HumanBuilder setPreferences(List<UUID> preferences) {
        this.preferences = preferences;
        return this;
    }

    public HumanBuilder setActions(List<UUID> actions) {
        this.actions = actions;
        return this;
    }

    public HumanBuilder addAction(UUID action) {
        this.actions.add(action);
        return this;
    }

    public HumanBuilder setTasks(List<UUID> tasks) {
        this.tasks = tasks;

        return this;
    }

    public HumanBuilder addTask(UUID task) {
        this.tasks.add(task);
        return this;
    }

    public HumanBuilder setSkills(List<UUID> skills) {
        this.skills = skills;
        return this;
    }

    public HumanBuilder addSkill(UUID skill) {
        this.skills.add(skill);
        return this;
    }

    public HumanBuilder setPermissions(List<UUID> permissions) {
        this.permissions = permissions;
        return this;
    }

    public HumanBuilder addPermission(UUID permission) {
        this.permissions.add(permission);
        return this;
    }

    public HumanBuilder setProperties(List<Property> properties) {
        this.properties = properties;
        return this;
    }

    public HumanBuilder setRoles(ArrayList<UUID> roles) {
        this.humanRoles = roles;
        return this;
    }

    public HumanBuilder addRole(UUID role) {
        this.humanRoles.add(role);
        return this;
    }

    public HumanBuilder addOperation(Operation operation) {
        this.operations.add(operation);
        return this;
    }

    public HumanBuilder addProperty(Property prop) {
        this.properties.add(prop);
        return this;
    }

    public HumanImpl build() {

        HumanImpl human = new HumanImpl();
        human.setUUIdentifier(this.uuid);
        human.setName(this.name);
        human.setReId(this.reId);
        human.setIp(this.ip);
        human.setSecurityKey(this.securitykey);
        human.setPlatform(this.platform);
        human.setVendor(this.vendor);
        human.setLocation(this.location);

        properties.forEach(human::addProperty);
        operations.forEach(human::addOperation);
        human.setConnectionHandler(connection);
        long timestamp = System.currentTimeMillis();

        if (this.account != null) {
            human.addProperty(new HumanPropertyImpl(timestamp,"account", "uuid", this.account.toString(), "", true));
        }

        if (this.healthData != null) {
            human.addProperty(new HumanPropertyImpl(timestamp,"healthData", "uuid", this.healthData.toString(),"", true));
        }
        if (this.preferences.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"preferences", "array", this.preferences.toArray(), "", true));

        }
        if (this.actions.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"actions", "array", this.actions.toArray(), "", true));
        }
        if (this.tasks.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"tasks", "array", this.tasks.toArray(), "", true));
        }

        if (this.skills.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"skills", "array", this.skills.toArray(), "", true));
        }
        if (this.permissions.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"permissions", "array", this.permissions.toArray(), "", true));
        }

        if (this.humanRoles.size() > 0) {
            human.addProperty(new HumanPropertyImpl(timestamp,"humanRoles", "array", this.humanRoles.toArray(), "", true));
        }
        // add properties
//
        human.setAccount(this.account);
        human.setHealthData(this.healthData);
        human.setPreferences(this.preferences);
        human.setActions(this.actions);
        human.setTasks(this.tasks);
        human.setSkills(this.skills);
        human.setPermissions(this.permissions);
        human.setProperties(this.properties);
        human.setHumanRoles(this.humanRoles);
        return human;
    }


}
