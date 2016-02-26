import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by softi on 23.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Result rs = JUnitCore.runClasses(Matrix2x2Test.class);
        for (Failure f : rs.getFailures()) {
            System.out.println(f);
        }
    }
}
