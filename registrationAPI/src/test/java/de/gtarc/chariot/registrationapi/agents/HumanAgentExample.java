package de.gtarc.chariot.registrationapi.agents;

import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.gtarc.chariot.humanapi.HumanProperty;
import de.gtarc.chariot.humanapi.impl.HumanBuilder;
import de.gtarc.chariot.humanapi.impl.SkillImpl;
import de.gtarc.chariot.humanapi.impl.TaskImpl;

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

        List<SkillImpl> list = new ArrayList<SkillImpl>();
        List<UUID> uuids = new ArrayList<UUID>();

        for (int i = 0; i < 10; i++) {
            uuids.add(list.get(i).getSkillId());
        }

        return uuids;
    }

    // create life skills and tasks
    public static List<UUID> createTasks() {
        // add skills here

        List<TaskImpl> list = new ArrayList<TaskImpl>();
        List<UUID> uuids = new ArrayList<UUID>();

        for (int i = 0; i < 10; i++) {
            uuids.add(list.get(i).getTaskId());
        }

        return uuids;
    }

    @Expose(name = ACTION_NAME_2, scope = ActionScope.GLOBAL)
    public void myUpdateEntity() {
        // Push updated value in db
        updateEntity();
    }

    @Expose(name = ACTION_NAME_1, scope = ActionScope.GLOBAL)
    public String updateProperty(String key, Object value) {
        getHuman().getProperties().stream().filter(i -> i.getKey().equalsIgnoreCase(key)).findFirst().ifPresent(i -> {
            ((HumanProperty) i).setValue(value);
            updateProperty(i);
        });

        return "Success";
    }
    // create task

}
