package de.gtarc.chariot.registrationapi.agents;

import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.gtarc.chariot.humanapi.HumanProperty;
import de.gtarc.chariot.humanapi.ObjectTypes;
import de.gtarc.chariot.humanapi.impl.HumanBuilder;
import de.gtarc.chariot.humanapi.impl.Skill;
import de.gtarc.chariot.messageapi.impl.EntityBuilder;
import de.gtarc.chariot.messageapi.payload.PayloadEntity;
import de.gtarc.commonapi.impl.EntityProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HumanAgentExample extends HumanAgent {

    /**
     * Dont forget to add the GatewayCobfug in the agent configuration as parent
     * with <import resource="classpath:GatewayConfig.xml" /> and
     * <bean name="HumanNode" parent="GatewayNode" scope="prototype">
     */

    private final static String uuid = "9d0262ca-9cb4-451a-8a4d-677c723caabd";
    private final static String ACTION_NAME_1 = "de.gtarc.chariot.registrationapi.agents.HumanAgentExample#updateProperty";
    private final static String ACTION_NAME_2 = "de.gtarc.chariot.registrationapi.agents.HumanAgentExample#myUpdateEntity";

    public List<UUID> skills = null;

    @Override
    public void doStart() throws Exception {
        this.setEntity(
                new HumanBuilder()
                        .setUuid(UUID.randomUUID())
                        .setSkills(createSkills())
                        .setTasks(createTasks())
                        .build()
        );
        this.register();
    }

    // create life skills and tasks
    public static List<UUID> createSkills() {
        // add skills here
        List<UUID> list = new ArrayList<UUID>();
        PayloadEntity skill = new EntityBuilder().setGroupId("skills").setName("skill-a")
                .addProperty(new EntityProperty(0, "name","string","skill-a","",true))
                .addProperty(new EntityProperty(0, "description","string","...","",true))
                .setObjectType(ObjectTypes.SKILL)
                .buildEntity();

        list.add(UUID.fromString(skill.getUuid()));
        return list;
    }

    // create life skills and tasks
    public static List<UUID> createTasks() {
        // add skills here
        List<UUID> list = new ArrayList<UUID>();

        PayloadEntity task = new EntityBuilder().setUUIdentifier(UUID.randomUUID()).setGroupId("tasks").setName("task-a")
                .addProperty(new EntityProperty(0, "name","string","task-a","",true))
//                .addProperty(new EntityProperty(0, Skill.DESCRIPTION.,"string","...","",true))
                .setObjectType(ObjectTypes.TASK)
                .buildEntity();

        list.add(UUID.fromString(task.getUuid()));
        return list;
    }

    @Expose(name = ACTION_NAME_2, scope = ActionScope.GLOBAL)
    public void myUpdateEntity() {
        // Push updated value in db
        updateEntity();
    }

//    @Expose(name = ACTION_NAME_1, scope = ActionScope.GLOBAL)
//    public String updateProperty(String key, Object value) {
//        getHuman().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
//            ((HumanProperty) i).setValue(value);
//            updateProperty(i);
//        });
//
//        return "Success";
//    }

    @Override
    public void handleProperty(String message) {

    }

    // create task

}
