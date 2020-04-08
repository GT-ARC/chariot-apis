package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Task;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class TaskImpl implements Task {


    private ObjectId _id;
    private String taskId;
    private String name;
    private String description;
    private boolean assigned;


    // we may not need the following parameters
    private UUID contractorId;
    private UUID customerId;
    private String customerName;

    private List<UUID> requiredPermissions; //needed
    private List<UUID> requiredSkills; //needed
    private TaskPriority priority;
    private Calendar deadline;

    // open, in processing or completed
    private TaskStatus status;

    public TaskImpl() {
        this.taskId = UUID.randomUUID().toString();
    }

    public TaskImpl(String name, String description) {
        this.contractorId = null;
        this.customerId = null;
        this.customerName = "unknown";
        this.name = name;
        this.description = description;
        this.priority = TaskPriority.LOW;
        this.status = TaskStatus.PENDING;
        this.requiredPermissions = new ArrayList<UUID>();
        this.requiredSkills = new ArrayList<UUID>();
        this.taskId = UUID.randomUUID().toString();
        this.assigned = false;

    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public UUID getTaskId() {
        return UUID.fromString(taskId);
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setName(boolean assigned) {
        this.assigned = assigned;
    }

    public String getName() {
        return name;
    }

    public void setName(String taskName) {
        this.name = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String taskDescription) {
        this.description = taskDescription;
    }

    public List<UUID> getRequiredPermissions() {
        return requiredPermissions;
    }

    public void setRequiredPermissions(List<UUID> requiredPermissions) {
        this.requiredPermissions = requiredPermissions;
    }

    public List<UUID> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<UUID> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public UUID getContractorId() {
        return contractorId;
    }

    public void setContractorId(UUID contractorId) {
        this.contractorId = contractorId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
