import de.gtarc.chariot.humanapi.impl.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


/**
 * Test cases for the human apis
 *
 * @author cem akpolat
 */

public class TestCase_1 {

    @Before
    public void before() {
        System.out.println("Starting test...");
    }

    @After
    public void after() {
        System.out.println("Test ended.");
        System.out.println("");
    }

    @Test
    public void testHumanWorker() throws Exception {
        System.out.println("########################## Human Creation Test ##########################");
        UUID id = UUID.randomUUID();

        HumanImpl human = new HumanImpl(id);
        human.setName("cem");
        assertEquals(id, human.getUUIdentifier());

        ActionImpl action = new ActionImpl(null, null);
        human.addAction(action.getActionId());

        PermissionImpl permission = new PermissionImpl("new task", "task description");
        human.addPermission(permission.getPermissionId());

        assertEquals(permission.getPermissionId(), human.getPermissions().get(0));
    }

    @Test
    public void createHumanUsingBuilder() throws Exception {
        System.out.println("########################## Human Creation using Human Worker Builder ##########################");


        HealthDataImpl health = new HealthDataImpl();

        HumanImpl human = new HumanBuilder().
                setName("cem").
                setUuid(UUID.randomUUID()).
                setAccount(new AccountImpl("cem", "pass").getAccountId()).
                setHealtData(health.getHealthDataId()).
                build();

        System.out.println("id:" + human.getUUIdentifier().toString());

    }

    @Test
    public void createHumanUsingBuild() throws Exception {
        System.out.println("########################## Human Creation using Human Worker Builder ##########################");
        // TODO: extend the following test-case

        // define the worker
        // add the worker to the features
        // define the tasks
        // define the skills
        // save tasks and skills in the database
        // assign the skills uuid to the human

        TaskImpl task = new TaskImpl();
        SkillImpl skill = new SkillImpl();

        // for the test purposes we will use only task and skills
        HumanImpl human1 = new HumanBuilder()
                .setName("cem")
                .setUuid(UUID.randomUUID())
                .setAccount(new AccountImpl("cem", "pass").getAccountId())
                .addTask(task.getTaskId())
                .addSkill(skill.getSkillId())
                .addProperty(new HumanPropertyImpl(0,"account", "uuid", new AccountImpl("cem", "pass").getAccountId(), "", true))
                .build();

        System.out.println("id:" + human1.getUUIdentifier());

    }
}
