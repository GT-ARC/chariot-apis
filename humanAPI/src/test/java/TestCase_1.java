import de.gtarc.chariot.humanapi.impl.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;


/**
 * Test cases for the human apis
 *
 * @author cem akpolat
 */
@Ignore
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

    }

    @Test
    public void createHumanUsingBuilder() throws Exception {
        System.out.println("########################## Human Creation using Human Worker Builder ##########################");

//

    }

    @Test
    public void createHumanUsingBuild() throws Exception {
        System.out.println("########################## Human Creation using Human Worker Builder ##########################");




        // for the test purposes we will use only task and skills
        HumanImpl human1 = new HumanBuilder()
                .setName("cem")
                .setUuid(UUID.randomUUID())

                .addProperty(new HumanPropertyImpl(0,"account", "uuid", "", "", true))
                .build();

        System.out.println("id:" + human1.getUUIdentifier());

    }
}
