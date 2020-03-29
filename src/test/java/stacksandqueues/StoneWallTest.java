package stacksandqueues;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the StoneWall class
 *
 * @author marylene
 * @since 29 August 2018
 */
public class StoneWallTest {

    @Test
    /**
     * This will test that the correct predicate: a given string of parentheses
     * is properly nested.
     *
     * @covers stacksandqueues.StoneWall.findNumberOfBricks()
     */
    public void testFindNumberOfBricks() {

        System.out.println("findNumberOfBricks");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios

        testScenarios.add(new int[][]{{1}, {1}});
        testScenarios.add(new int[][]{{1}, {1, 1}});
        testScenarios.add(new int[][]{{1}, {1, 1, 1}});
        testScenarios.add(new int[][]{{3}, {3, 2, 3}});
        testScenarios.add(new int[][]{{9}, {2, 5, 1, 4, 6, 7, 9, 10, 3}});
        testScenarios.add(new int[][]{{7}, {8, 8, 5, 7, 9, 8, 7, 4, 8}});
        testScenarios.add(new int[][]{{8}, {2, 5, 1, 4, 6, 7, 9, 10, 1}});
        testScenarios.add(new int[][]{{3}, {10, 10, 10, 10, 6, 10, 10, 10, 10}});
        testScenarios.add(new int[][]{{1}, {10, 10, 10, 10, 10, 10, 10, 10, 10}});
        
        Iterator<int[][]> scenarios = testScenarios.iterator();
        
        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] arrayHeights = scenario[1];

            int result = StoneWall.findNumberOfBricks(arrayHeights);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }

}
