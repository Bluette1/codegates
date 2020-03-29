package maximumsliceproblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the MaxDoubleSliceSum Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class MaxDoubleSliceSumTest {
    
     @Test
    /**
     * This will test that the correct maximum double slice sum is obtained.
     *
     * @covers maximumsliceproblem.MaxDoubleSliceSum.getMaxDoubleSliceSum()
     */
    public void testGetMaxDoubleSliceSum() {
        System.out.println("getMaxDoubleSliceSum");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios

        // first simple test
        testScenarios.add(new int[][]{{17}, {3, 2, 6, -1, 4, 5, -1, 2}});
        
        // second simple test
        testScenarios.add(new int[][]{{37}, {3, 2, 6, -1, 4, 5, -1, 2, 3, 2, 6, -1, 4, 5, -1, 2}});
        
        // third simple test
        testScenarios.add(new int[][]{{57}, {3, 2, 6, -1, 4, 5, -1, 2, 3, 2, 6, -1, 4, 5, -1, 2, 3, 2, 6, -1, 4, 5, -1, 2}});
        
        // all positive
        testScenarios.add(new int[][]{{18}, {3, 2, 6, 1, 4, 5, 1, 2}});
        
        // all negative
        testScenarios.add(new int[][]{{0}, {-3, -2, -6, -1, -4, -5, -1, -2}});
        
        // three elements
        testScenarios.add(new int[][]{{0}, {5, 1, 2}});
        
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int result = MaxDoubleSliceSum.getMaxDoubleSliceSum(scenario[1]);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
