package timecomplexity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Frogjmp class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class FrogjmpTest {

    @Test
    /**
     * This will test that the correct number of minimum jumps is calculated.
     *
     * @covers timecomplexity.Frogjmp.findFrogjmp()
     */
    public void testFindFrogjmp() {
        System.out.println("findFrogjmp");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
        
        testScenarios.add(new int[][]{{3}, {10, 85, 30}});
        testScenarios.add(new int[][]{{0}, {10, 10, 30}});
        testScenarios.add(new int[][]{{1}, {25, 55, 30}});
        testScenarios.add(new int[][]{{1}, {250, 300, 100}});
        testScenarios.add(new int[][]{{100}, {2000, 3000, 10}});
        testScenarios.add(new int[][]{{100}, {10000, 20000, 100}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] params = scenario[1];
            int result = Frogjmp.findFrogjmp(params[0], params[1], params[2]);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
