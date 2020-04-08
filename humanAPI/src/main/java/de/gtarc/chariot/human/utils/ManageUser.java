//package de.gtarc.chariot.human.utils;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.UUID;
//
//import de.gtarc.chariot.humanapi.IAccount;
//import de.gtarc.chariot.humanapi.IAction;
//import de.gtarc.chariot.humanapi.ICommInterface;
//import de.gtarc.chariot.humanapi.IContact;
//import de.gtarc.chariot.humanapi.IHealthData;
//import de.gtarc.chariot.humanapi.IHumanRole;
//import de.gtarc.chariot.humanapi.IPermission;
//import de.gtarc.chariot.humanapi.IPreference;
//import de.gtarc.chariot.humanapi.IProperty;
//import de.gtarc.chariot.humanapi.ISkill;
//import de.gtarc.chariot.humanapi.ITask;
//import de.gtarc.chariot.humanapi.impl.Account;
//import de.gtarc.chariot.humanapi.impl.Action;
//import de.gtarc.chariot.humanapi.impl.HealthData;
//import de.gtarc.chariot.humanapi.impl.HumanRole;
//import de.gtarc.chariot.humanapi.impl.HumanWorker;
//import de.gtarc.chariot.humanapi.impl.Location;
//import de.gtarc.chariot.humanapi.impl.Permission;
//import de.gtarc.chariot.humanapi.impl.Preference;
//import de.gtarc.chariot.humanapi.impl.Property;
//import de.gtarc.chariot.humanapi.impl.Skill;
//import de.gtarc.chariot.humanapi.impl.Task;
//
//public class ManageUser {
//	Permissions perm;
//	Preferences pref;
//
//	public ManageUser() {
//		this.perm = new Permissions();
//		this.pref = new Preferences();
//	}
//
//	public LinkedList<IPermission> setExpectedPermissionsFor(String humanRole) {
//		LinkedList<IPermission> permissions = new LinkedList<>();
//		switch (humanRole) {
//		case "system engineer":
//			setPermissionsSystemEngineer(permissions);
//			break;
//		case "supervisor":
//			setPermissionsSupervisor(permissions);
//			break;
//		case "operator":
//			setPermissionsOperator(permissions);
//			break;
//		case "technicians":
//			setPermissionsTechnican(permissions);
//			break;
//		case "worker":
//			setPermissionsWorker(permissions);
//			break;
//
//		}
//		return permissions;
//	}
//
//	public LinkedList<ISkill> setExpectedSkillsFor(String humanRole) {
//		LinkedList<ISkill> skills = new LinkedList<>();
//		switch (humanRole) {
//		case "system engineer":
//			setSkillsSystemEngineer(skills);
//			break;
//		case "supervisor":
//			setSkillsSupervisor(skills);
//			break;
//		case "operator":
//			setSkillsOperator(skills);
//			break;
//		case "technicians":
//			setSkillsTechnican(skills);
//			break;
//		case "worker":
//			setSkillsWorker(skills);
//			break;
//
//		}
//		return skills;
//	}
//
//	public LinkedList<IAction> setExpectedActionsFor(String humanRole) {
//		LinkedList<IAction> actions = new LinkedList<>();
//		switch (humanRole) {
//		case "system engineer":
//			setActionsSystemEngineer(actions);
//			break;
//		case "supervisor":
//			setActionsSupervisor(actions);
//			break;
//		case "operator":
//			setActionsOperator(actions);
//			break;
//		case "technicians":
//			setActionsTechnican(actions);
//			break;
//		case "worker":
//			setActionsWorker(actions);
//			break;
//
//		}
//		return actions;
//	}
//
//	private void setPermissionsWorker(LinkedList<IPermission> permissions) {
//		permissions.add(new Permission(this.perm.factoryArea1,
//				"Permission to enter the non-safety critical part of the factory"));
//		permissions.add(
//				new Permission(this.perm.factoryArea2, "Permission to enter the safety-critical part of the factory"));
//		permissions.add(new Permission(this.perm.receiveSensorData, "Permission to retrieve the sensor data"));
//		permissions.add(new Permission(this.perm.workOnConveyorBelt, "Permission to work on the conveyor belt"));
//		permissions.add(new Permission(this.perm.interactWithRobot, "Permission to interact with the robot"));
//
//	}
//
//	private void setPermissionsTechnican(LinkedList<IPermission> permissions) {
//		permissions.add(new Permission(this.perm.factoryArea1,
//				"Permission to enter the non-safety critical part of the factory"));
//		permissions.add(
//				new Permission(this.perm.factoryArea2, "Permission to enter the safety-critical part of the factory"));
//		permissions.add(new Permission(this.perm.receiveSensorData, "Permission to retrieve the sensor data"));
//		permissions.add(new Permission(this.perm.receiveFactoryAnalysisData,
//				"Permission to retrieve statistics and analysis data of the factory"));
//		permissions.add(new Permission(this.perm.interactWithRobot, "Permission to interact with the robot"));
//		permissions.add(new Permission(this.perm.workOnConveyorBelt, "Permission to work on the conveyor belt"));
//	}
//
//	private void setPermissionsOperator(LinkedList<IPermission> permissions) {
//		permissions.add(new Permission(this.perm.factoryArea1,
//				"Permission to enter the non-safety critical part of the factory"));
//		permissions.add(new Permission(this.perm.receiveSensorData, "Permission to retrieve the sensor data"));
//		permissions.add(new Permission(this.perm.receiveFactoryAnalysisData,
//				"Permission to retrieve statistics and analysis data of the factory"));
//
//	}
//
//	private void setPermissionsSupervisor(LinkedList<IPermission> permissions) {
//		permissions.add(new Permission(this.perm.addUser, "Permission to create a new user account"));
//		permissions.add(new Permission(this.perm.addSkill, "Permission to add a skill to a user account"));
//		permissions.add(new Permission(this.perm.addTask, "Permission to add a a task to a user account"));
//		permissions.add(new Permission(this.perm.removeTask, "Permission to delete a task"));
//		permissions.add(new Permission(this.perm.factoryArea1,
//				"Permission to enter the non-safety critical part of the factory"));
//		permissions.add(
//				new Permission(this.perm.factoryArea2, "Permission to enter the safety-critical part of the factory"));
//		permissions.add(new Permission(this.perm.receiveSensorData, "Permission to retrieve the sensor data"));
//		permissions.add(new Permission(this.perm.receiveFactoryAnalysisData,
//				"Permission to retrieve statistics and analysis data of the factory"));
//		permissions.add(new Permission(this.perm.addHumanRole, "Permission to add a Role to a user"));
//		permissions.add(new Permission(this.perm.removeHumanRole, "Permission to remove a Role from a user"));
//		permissions.add(new Permission(this.perm.addAction,
//				"Permission to add an Action(Action describes an assigned man area of responsibility"));
//		permissions.add(new Permission(this.perm.removeAction,
//				"Permission to remove an Action(Action describes an assigned man area of responsibility"));
//		permissions.add(new Permission(this.perm.addProperty, "Permission to add a Property to a user"));
//		permissions.add(new Permission(this.perm.removeProperty, "Permission to remove a Property to a user"));
//
//	}
//
//	private void setPermissionsSystemEngineer(LinkedList<IPermission> permissions) {
//		permissions.add(new Permission(this.perm.addUser, "Permission to create a new user account"));
//		permissions.add(new Permission(this.perm.removeUser, "Permission to delete a user account"));
//		permissions.add(new Permission(this.perm.addSkill, "Permission to add a skill to a user account"));
//		permissions.add(new Permission(this.perm.removeSkill, "Permision to delete a skill from a user account"));
//		permissions.add(new Permission(this.perm.addTask, "Permission to add a a task to a user account"));
//		permissions.add(new Permission(this.perm.removeTask, "Permission to delete a task"));
//		permissions.add(new Permission(this.perm.changeName, "Permission to change the name of a user"));
//		permissions.add(new Permission(this.perm.changeAccount,
//				"Permission to change the login Name and password of a user (even of a different user)"));
//		permissions.add(new Permission(this.perm.addHumanRole, "Permission to add a Role to a user"));
//		permissions.add(new Permission(this.perm.removeHumanRole, "Permission to remove a Role from a user"));
//		permissions.add(new Permission(this.perm.addAction,
//				"Permission to add an Action(Action describes an assigned man area of responsibility"));
//		permissions.add(new Permission(this.perm.removeAction,
//				"Permission to remove an Action(Action describes an assigned man area of responsibility"));
//		permissions.add(
//				new Permission(this.perm.addPreference, "Permission to add a preference (even from a different user)"));
//		permissions.add(new Permission(this.perm.removePreference,
//				"Permission to remove a preference (even from a different user)"));
//		permissions.add(new Permission(this.perm.addProperty, "Permission to add a Property to a user"));
//		permissions.add(new Permission(this.perm.removeProperty, "Permission to remove a Property to a user"));
//		permissions.add(new Permission(this.perm.changeHealthStatus,
//				"Permission to change the health status of a different user"));
//		permissions
//				.add(new Permission(this.perm.chnageLocation, "Permission to change the location of a different user"));
//		// permissions.add(new Permission(this.perm.addCommInterface, "Permission a add
//		// a new device to a user"));
//		permissions.add(new Permission(this.perm.changeCommInterface, "Permission to change CommInterface"));
//		// permissions.add(new Permission(this.perm.removeCommInterface, "Permission a
//		// remove a new device to a user"));
//
//	}
//
//	private void setSkillsWorker(LinkedList<ISkill> skills) {
//		skills.add(new Skill("safetyTraining",
//				"Safety training completed to enter the safety-critical area of the factory"));
//		skills.add(new Skill("interactWithRobots", "Training completed to work with robots"));
//		skills.add(new Skill("checkProductQuality", "Ability to check the quality status of the produced product"));
//
//	}
//
//	private void setSkillsTechnican(LinkedList<ISkill> skills) {
//		skills.add(new Skill("safetyTraining",
//				"Safety training completed to enter the safety-critical area of the factory"));
//		skills.add(new Skill("interactWithRobots", "Training completed to work with robots"));
//		skills.add(new Skill("programmingSkills", "Has the required programming skills"));
//		skills.add(new Skill("electricalEngineeringKnowledge", "Has the required electrical engineering knowledge"));
//		skills.add(new Skill("KnowledgeOfTheFactorySystem",
//				"Is able to monitor the status of the factory based on real-time data"));
//
//	}
//
//	private void setSkillsOperator(LinkedList<ISkill> skills) {
//		skills.add(new Skill("KnowledgeOfTheFactorySystem",
//				"Is able to monitor the status of the factory based on real-time data"));
//	}
//
//	private void setSkillsSupervisor(LinkedList<ISkill> skills) {
//		skills.add(new Skill("safetyTraining",
//				"Safety training completed to enter the safety-critical area of the factory"));
//		skills.add(new Skill("checkProductQuality", "Ability to check the quality status of the produced product"));
//		skills.add(new Skill("KnowledgeOfTheFactorySystem",
//				"Is able to monitor the status of the factory based on real-time data"));
//		skills.add(new Skill("ManagementKnowledge", "Is able to coordinate tasks"));
//	}
//
//	private void setSkillsSystemEngineer(LinkedList<ISkill> skills) {
//		skills.add(new Skill("programmingSkills", "Has the required programming skills"));
//	}
//
//	private void setActionsWorker(LinkedList<IAction> actions) {
//		actions.add(new Action("productQualityCheck",
//				"Check the quality of the produced products on the conveyor belt. This is done in collaboration with a robot."));
//
//	}
//
//	private void setActionsTechnican(LinkedList<IAction> actions) {
//		actions.add(new Action("maintenanceWork", "Perform maintenance in the factory."));
//
//	}
//
//	private void setActionsOperator(LinkedList<IAction> actions) {
//		actions.add(new Action("monitorFactoryStatus",
//				"Monitor the status of the factory. At the factory headquarters, all real-time data from the factory is collected and evaluated."));
//
//	}
//
//	private void setActionsSupervisor(LinkedList<IAction> actions) {
//		actions.add(new Action("assignTasks", "Assign tasks to workers."));
//		actions.add(new Action("removeTasks", "Take off completed tasks."));
//
//	}
//
//	private void setActionsSystemEngineer(LinkedList<IAction> actions) {
//		actions.add(new Action("programming", "Program the system."));
//
//	}
//
//	public String getName(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideName)) {
//			return targetHuman.getName();
//		}
//
//		return null;
//	}
//
//	public List<IPreference> getPreferences(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId()== targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hidePreferences)) {
//			return targetHuman.getPreferences();
//		}
//
//		return null;
//	}
//
//	public IAccount getAccount(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideAccount)) {
//			return targetHuman.getAccount();
//		}
//
//		return null;
//	}
//
//	public List<ITask> getTasks(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideTasks)) {
//			return targetHuman.getTasks();
//		}
//
//		return null;
//	}
//
//	public List<ISkill> getSkills(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideSkills)) {
//			return targetHuman.getSkills();
//		}
//
//		return null;
//	}
//
//	public List<IProperty> getProperties(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideProperties)) {
//			return targetHuman.getProperties();
//		}
//
//		return null;
//	}
//
//	public List<IHumanRole> getHumanRoles(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideHumanRoles)) {
//			return targetHuman.getHumanRoles();
//		}
//
//		return null;
//	}
//
//	public List<IAction> getActions(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideActions)) {
//			return targetHuman.getActions();
//		}
//
//		return null;
//	}
//
//	public IHealthData getHealthStatus(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideHealthStatus)) {
//			return targetHuman.getHealthData();
//		}
//
//		return null;
//	}
//
//	public Location getLocation(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideLocation)) {
//			return targetHuman.getLocation();
//		}
//
//		return null;
//	}
//
//	public ICommInterface getCommInterface(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideCommInterfaces)) {
//			return targetHuman.getCommInterface();
//		}
//
//		return null;
//	}
//
//	public List<IPermission> getPermissions(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hidePermissions)) {
//			return targetHuman.getPermissions();
//		}
//
//		return null;
//	}
//
//	public List<IContact> getContacts(HumanWorker executiveHuman, HumanWorker targetHuman) {
//		if (executiveHuman.getHumanId() == targetHuman.getHumanId()
//				|| !this.containsPref(targetHuman, this.pref.hideContacts)) {
//			if (targetHuman.getContacts() == null)
//				targetHuman.setContacts(new LinkedList<IContact>());
//			return targetHuman.getContacts();
//		}
//		return null;
//	}
//
//	public boolean hasPermissionToAddUser(HumanWorker human) {
//		if (human.getPermissions() == null)
//			return false;
//		if (this.containsPerm(human, this.perm.addUser))
//			return true;
//		return false;
//	}
//
//	public boolean hasPermissionToRemoveUser(HumanWorker human) {
//		if (human.getPermissions() == null)
//			return false;
//		if (this.containsPerm(human, this.perm.removeUser))
//			return true;
//		return false;
//	}
//
//	public boolean changeName(HumanWorker executiveHuman, HumanWorker targetHuman, String name) {
//		if (this.containsPerm(executiveHuman, this.perm.changeName)) {
//			targetHuman.setName(name);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean addPreference(HumanWorker executiveHuman, HumanWorker targetHuman, Preference preference) {
//		if (this.containsPerm(executiveHuman, this.perm.addPreference)
//				|| targetHuman.getHumanId() == targetHuman.getHumanId()) {
//			if (targetHuman.getPreferences() == null)
//				targetHuman.setPreferences(new LinkedList<IPreference>());
//			if (this.containsName(targetHuman, "Preference", preference.getName()))
//				return false;
//			targetHuman.getPreferences().add(preference);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removePreference(HumanWorker executiveHuman, HumanWorker targetHuman, String preferenceName) {
//		if (this.containsPerm(executiveHuman, this.perm.removePreference)
//				|| targetHuman.getHumanId() == targetHuman.getHumanId()) {
//			if (targetHuman.getPreferences() == null)
//				return false;
//			return this.removeByName(targetHuman, "Preference", preferenceName);
//		}
//		return false;
//	}
//
//	public boolean changeAccount(HumanWorker executiveHuman, HumanWorker targetHuman, String loginName, String password) {
//		if (this.containsPerm(executiveHuman, this.perm.changeAccount)
//				|| executiveHuman.getHumanId() == targetHuman.getHumanId()) {
//			((Account)targetHuman.getAccount()).setLoginName(loginName);
//			((Account)targetHuman.getAccount()).setPassword(password);
//			return true;
//		}
//		return false;
//
//	}
//
//	public boolean addTask(HumanWorker executiveHuman, HumanWorker targetHuman, Task task) {
//		if (this.containsPerm(executiveHuman, this.perm.addTask)) {
//			if (targetHuman.getTasks() == null)
//				targetHuman.setTasks(new LinkedList<ITask>());
//			if (this.containsName(targetHuman, "Task", task.getName()))
//				return false;
//			task.setContractorId(UUID.fromString(targetHuman.getHumanId()));
//			//task.customerID = executiveHuman.getHumanID(); // this is not clear, this must be changed
//			task.setCustomerName(executiveHuman.getName());
//			targetHuman.getTasks().add(task);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removeTask(HumanWorker executiveHuman, HumanWorker targetHuman, String taskName) {
//		if (this.containsPerm(executiveHuman, this.perm.removeTask)) {
//			if (targetHuman.getTasks() == null)
//				return false;
//			return this.removeByName(targetHuman, "Task", taskName);
//		}
//		return false;
//	}
//
//	public boolean addSkill(HumanWorker executiveHuman, HumanWorker targetHuman, Skill skill) {
//		if (this.containsPerm(executiveHuman, this.perm.addSkill)) {
//			if (targetHuman.getSkills() == null)
//				targetHuman.setSkills(new LinkedList<ISkill>());
//			if (this.containsName(targetHuman, "Skill", skill.getName()))
//				return false;
//			targetHuman.getSkills().add(skill);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removeSkill(HumanWorker executiveHuman, HumanWorker targetHuman, String skillName) {
//		if (this.containsPerm(executiveHuman, this.perm.removeSkill)) {
//			if (targetHuman.getSkills() == null)
//				return false;
//			return this.removeByName(targetHuman, "Skill", skillName);
//		}
//		return false;
//	}
//
//	public boolean addProperty(HumanWorker executiveHuman, HumanWorker targetHuman, Property property) {
//		if (this.containsPerm(executiveHuman, this.perm.addProperty)) {
//			if (targetHuman.getProperties() == null)
//				targetHuman.setProperties(new LinkedList<IProperty>());
//			if (this.containsName(targetHuman, "Property", property.getName()))
//				return false;
//			targetHuman.getProperties().add(property);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removeProperty(HumanWorker executiveHuman, HumanWorker targetHuman, String propertyName) {
//		if (this.containsPerm(executiveHuman, this.perm.removeProperty)) {
//			if (targetHuman.getProperties() == null)
//				return false;
//			return this.removeByName(targetHuman, "Property", propertyName);
//		}
//		return false;
//	}
//
//	public boolean addHumanRole(HumanWorker executiveHuman, HumanWorker targetHuman, HumanRole humanRole) {
//		if (this.containsPerm(executiveHuman, this.perm.addHumanRole)) {
//			if (targetHuman.getHumanRoles() == null)
//				targetHuman.setHumanRoles(new LinkedList<IHumanRole>());
//			if (this.containsName(targetHuman, "HumanRole", humanRole.getName()))
//				return false;
//			targetHuman.getHumanRoles().add(humanRole);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removeHumanRole(HumanWorker executiveHuman, HumanWorker targetHuman, String roleName) {
//		if (this.containsPerm(executiveHuman, this.perm.removeHumanRole)) {
//			if (targetHuman.getHumanRoles() == null)
//				return false;
//			return this.removeByName(targetHuman, "HumanRole", roleName);
//		}
//		return false;
//	}
//
//	public boolean addAction(HumanWorker executiveHuman, HumanWorker targetHuman, Action action) {
//		if (this.containsPerm(executiveHuman, this.perm.addAction)) {
//			if (targetHuman.getActions() == null)
//				targetHuman.setActions(new LinkedList<IAction>());
//			if (this.containsName(targetHuman, "Action", action.getName()))
//				return false;
//			targetHuman.getActions().add(action);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removeAction(HumanWorker executiveHuman, HumanWorker targetHuman, String actionName) {
//		if (this.containsPerm(executiveHuman, this.perm.removeAction)) {
//			if (targetHuman.getActions() == null)
//				return false;
//			return this.removeByName(targetHuman, "Action", actionName);
//		}
//		return false;
//	}
//
//	public boolean changeHealthStatus(HumanWorker executiveHuman, HumanWorker targetHuman, HealthData status) {
//		if (this.containsPerm(executiveHuman, this.perm.changeHealthStatus)
//				|| executiveHuman.getHumanId() == targetHuman.getHumanId()) {
//			targetHuman.setHealthData(status);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean changeLocation(HumanWorker executiveHuman, HumanWorker targetHuman, Location location) {
//		if (this.containsPerm(executiveHuman, this.perm.chnageLocation)
//				|| executiveHuman.getHumanId() == targetHuman.getHumanId()) {
//			targetHuman.setLocation(location);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean changeCommInterface(HumanWorker executiveHuman, HumanWorker targetHuman, ICommInterface commInt) {
//		if (this.containsPerm(executiveHuman, this.perm.changeCommInterface)
//				|| executiveHuman.getHumanId() == targetHuman.getHumanId()) {
//			targetHuman.setCommInterface(commInt);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean addPermission(HumanWorker executiveHuman, HumanWorker targetHuman, Permission permission) {
//		if (this.containsPerm(executiveHuman, this.perm.addPermission)) {
//			if (targetHuman.getPermissions() == null)
//				targetHuman.setPermissions(new LinkedList<IPermission>());
//			if (this.containsName(targetHuman, "Permission", permission.getName()))
//				return false;
//			targetHuman.getPermissions().add(permission);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean removePermission(HumanWorker executiveHuman, HumanWorker targetHuman, String permissionName) {
//		if (this.containsPerm(executiveHuman, this.perm.removePermission)) {
//			if (targetHuman.getPermissions() == null)
//				return false;
//			return this.removeByName(targetHuman, "Permission", permissionName);
//		}
//		return false;
//	}
//
//	public boolean containsPerm(HumanWorker human, String permission) {
//		if (human.getPermissions() == null)
//			return false;
//		for (IPermission perm : human.getPermissions()) {
//			if (((Permission)perm).getName().equals(permission))
//				return true;
//		}
//		return false;
//	}
//
//	public boolean containsPref(HumanWorker human, String preference) {
//		if (human.getPreferences() == null)
//			return false;
//		for (IPreference pref : human.getPreferences()) {
//			if (((Preference)pref).getName().equals(preference))
//				return true;
//		}
//		return false;
//	}
//
//	private boolean removeByName(HumanWorker targetHuman, String objectType, String name) {
//		switch (objectType) {
//		case "Action":
//			for (IAction action : targetHuman.getActions())
//				if (((Action)action).getName().equals(name))
//					return targetHuman.getActions().remove(action);
//			break;
//		case "Permission":
//			for (IPermission permission : targetHuman.getPermissions())
//				if (((Permission)permission).getName().equals(name))
//					return targetHuman.getPermissions().remove(permission);
//			break;
//		case "Preference":
//			for (IPreference preference : targetHuman.getPreferences())
//				if (((Preference)preference).getName().equals(name))
//					return targetHuman.getPreferences().remove(preference);
//			break;
//		case "Property":
//			for (IProperty property : targetHuman.getProperties())
//				if (((Property)property).getName().equals(name))
//					return targetHuman.getProperties().remove(property);
//			break;
//		case "Skill":
//			for (ISkill skill : targetHuman.getSkills())
//				if (((Skill)skill).getName().equals(name))
//					return targetHuman.getSkills().remove(skill);
//			break;
//		case "Task":
//			for (ITask task : targetHuman.getTasks())
//				if (((Task)task).getName().equals(name))
//					return targetHuman.getTasks().remove(task);
//			break;
//		case "HumanRole":
//			for (IHumanRole humanRole : targetHuman.getHumanRoles())
//				if (((HumanRole)humanRole).getName().equals(name))
//					return targetHuman.getHumanRoles().remove(humanRole);
//			break;
//		}
//
//		return false;
//	}
//
//	private boolean containsName(HumanWorker targetHuman, String objectType, String name) {
//
//		switch (objectType) {
//		case "Action":
//			for (IAction action : targetHuman.getActions())
//				if (((Action)action).getName().equals(name))
//					return true;
//			break;
//		case "Permission":
//			for (IPermission permission : targetHuman.getPermissions())
//				if (((Permission)permission).getName().equals(name))
//					return true;
//			break;
//		case "Preference":
//			for (IPreference preference : targetHuman.getPreferences())
//				if (((Preference)preference).getName().equals(name))
//					return true;
//			break;
//		case "Property":
//			for (IProperty property : targetHuman.getProperties())
//				if (((Property)property).getName().equals(name))
//					return true;
//			break;
//		case "Skill":
//			for (ISkill skill : targetHuman.getSkills())
//				if (((Skill)skill).getName().equals(name))
//					return true;
//			break;
//		case "Task":
//			for (ITask task : targetHuman.getTasks())
//				if (((Task)task).getName().equals(name))
//					return true;
//			break;
//		case "HumanRole":
//			for (IHumanRole humanRole : targetHuman.getHumanRoles())
//				if (((HumanRole)humanRole).getName().equals(name))
//					return true;
//			break;
//		}
//
//		return false;
//	}
//
//	// for testing only
//	public void setExampleDataForWorker(HumanWorker targetHuman) {
//		HumanWorker god = this.createGod();
//
//		// Preferences
//		this.addPreference(god, targetHuman, new Preference(null, this.pref.hideHealthStatus,
//				"forbid that the HealthStatus may be accessed by someone else"));
//
//		// Tasks
//		this.addTask(god, targetHuman, new Task("productQualityCheck",
//				"Check the quality of the produced products on the conveyor belt. This is done in collaboration with a robot."));
//
//		// Skills
//		targetHuman.setSkills(this.setExpectedSkillsFor("worker"));
//
//		// Properties
//		this.addProperty(god, targetHuman,
//				new Property("roboArm_1", "robot", "A robotic arm that can take products off the conveyor belt."));
//
//		// HumanRole
//		this.addHumanRole(god, targetHuman, new HumanRole("worker", "Work on the production line"));
//
//		// Actions
//		targetHuman.setActions(this.setExpectedActionsFor("worker"));
//
//		// Permissions
//		targetHuman.setPermissions(this.setExpectedPermissionsFor("worker"));
//	}
//
//	// for testing only
//	public HumanWorker createGod() {
//		HumanWorker god = new HumanWorker(new UUID(0,4), "god", "", "");
//		LinkedList<IPermission> permissions = new LinkedList<>();
//		this.setPermissionsWorker(permissions);
//		this.setPermissionsOperator(permissions);
//		this.setPermissionsSupervisor(permissions);
//		this.setPermissionsSystemEngineer(permissions);
//		this.setPermissionsTechnican(permissions);
//		god.setPermissions(permissions);
//		return god;
//	}
//}
