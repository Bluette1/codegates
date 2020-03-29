package maximumsliceproblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the MaxSliceSum Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class MaxSliceSumTest {

    @Test
    /**
     * This will test that the correct maximum slice sum is obtained.
     *
     * @covers maximumsliceproblem.MaxSliceSum.findMaxSliceSum()
     */
    public void testFindMaxSliceSum() {
        System.out.println("findMaxSliceSum");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios

        testScenarios.add(new int[][]{{-1}, {-1}});// one element
        testScenarios.add(new int[][]{{5}, {4, 1}});// two elements; both positive
        
        // two different elements; first element positive and second one negative
        testScenarios.add(new int[][]{{4}, {4, -1}});
        
        // two different elements; first element negative and second one positive
        testScenarios.add(new int[][]{{1}, {-4, 1}});
       
        testScenarios.add(new int[][]{{7}, {4, 1, 2}});// three elements; all positive
        testScenarios.add(new int[][]{{5}, {4, -1, 2}});// three elements; one negative
        testScenarios.add(new int[][]{{7}, {4, 1, 2}});// three elements; all negative

        testScenarios.add(new int[][]{{10}, {5, -7, 3, 5, -2, 4, -1}});// simple test
        testScenarios.add(new int[][]{{21}, {4, 3, 4, 4, 4, 2}});// another simple test
        testScenarios.add(new int[][]{{7}, {1, 1, 1, 1, 1, 1, 1}}); // all same ponsitive
        testScenarios.add(new int[][]{{-1}, {-1, -1, -1, -1, -1, -1, -1}}); // all same negative

        // one element extreme minimum 
        testScenarios.add(new int[][]{{Integer.MIN_VALUE}, {Integer.MIN_VALUE}});

        // two elements with extreme minimum
        testScenarios.add(new int[][]{{-1}, {Integer.MIN_VALUE, -1}});

        // with extreme minimum
        testScenarios.add(new int[][]{{21}, {4, 3, 4, 4, 4, 2, Integer.MIN_VALUE}});

        // another example with extreme minimum
        testScenarios.add(new int[][]{{16}, {4, -3, 4, 4, 4, -2, 3, 2, Integer.MIN_VALUE, 5, -7, 3, 5, -2, 4, -1}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();

            int expResult = scenario[0][0];
            int result = MaxSliceSum.findMaxSliceSum(scenario[1]);
            assertEquals(
                    "The result was expected to equal the expected result",
                    expResult,
                    result
            );
        }
    }
}
