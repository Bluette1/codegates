package timecomplexity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the TapeEquilibrium class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class TapeEquilibriumTest {
    @Test
    /**
     * This will test that the correct missing element is retrieved.
     *
     * @covers timecomplexity.TapeEquilibrium.findMinAbsDist()
     */
    public void testFindMinAbsDist() {
        System.out.println("findMinAbsDist");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
        
        testScenarios.add(new int[][]{{3}, {1, 4}});// only two elements
        testScenarios.add(new int[][]{{1}, {3, 1, 2, 4, 3}});// all positives
        testScenarios.add(new int[][]{{1}, {-3, -1, -2, -4, -3}});// all negatives
        testScenarios.add(new int[][]{{1}, {-3, 1, -2, 4, -3}});// random 
        testScenarios.add(new int[][]{{400}, {-300, 1000, -200, 400, -300}});// random large values;

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = TapeEquilibrium.findMinAbsDist(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
