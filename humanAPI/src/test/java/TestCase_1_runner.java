import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestCase_1_runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase_1.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("test case result: " + result.wasSuccessful());

    }

}  
