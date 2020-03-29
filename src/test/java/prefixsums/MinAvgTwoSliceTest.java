package prefixsums;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the MinAvgTwoSlice class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class MinAvgTwoSliceTest {
    
    @Test
    /**
     * This will test that the correct  minimal average of any slice containing 
     * at least two elements is returned.
     *
     * @covers prefixsums.MinAvgTwoSlice.findMinSlice()
     */
    public void findMinSlice() {
        System.out.println("findMinSlice");
       
        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{0}, {1, 1}});
        testScenarios.add(new int[][] {{0}, {1, 0, 2, 2}});
        testScenarios.add(new int[][] {{3}, {3, 3, 3, 2, 2, 4}});
        testScenarios.add(new int[][] {{2}, {4, 4, 0, 1, 1, 4, 4, 0, 1, 1}});
        testScenarios.add(new int[][] {{2}, {4, 4, 0, 0, 1, 4, 4, 0, 0, 1, 4, 4, 0, 0, 1}});
        testScenarios.add(new int[][] {{1}, {4, 2, 2, 5, 1, 5, 8, 4, 2, 2, 5, 1, 5, 8, 4, 2, 2, 5, 1, 5, 8}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = MinAvgTwoSlice.findMinSlice(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
