package sorting;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Distinct class.
 * 
 * @author marylene
 * @since 28 August 2018
 */
public class DistinctTest {
    
    @Test
    /**
     * This will test that the correct number of distinct values in an array is
     * retrieved.
     *
     * @covers sorting.Distinct.findMinSlice()
     */
    public void testFindDistinct() {
        System.out.println("findDistinct");
       
        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{0}, {}});// empty
        testScenarios.add(new int[][] {{1}, {1}});// one element
        testScenarios.add(new int[][] {{2}, {1, 5}});//two elements
        testScenarios.add(new int[][] {{3}, {1, 0, 2, 2}});// three distinct elements with 0
        testScenarios.add(new int[][] {{3}, {3, 3, 3, 2, 2, 4}});// three distinct elements
        
        // five distinct elements with 0, some negatives
        testScenarios.add(new int[][] {{5}, {4, 4, 0, 1, 1, 4, -8, 4, 0, 1, 1, -3}});
        
        // three distinct elements
        testScenarios.add(new int[][] {{3}, {4, 4, 0, 0, 1, 4, 4, 0, 0, 1, 4, 4, 0, 0, 1}});
        
        // 7 distinct elements with 0, some n   egatives
        testScenarios.add(new int[][] {{7}, {4, 2, 2, -5, 1, 5, -8, 4, 2, 2, 5, 1, 5, 8, 4, 2, 2, 5, 1, 5, 8}});
        
        // all the same positives
        testScenarios.add(new int[][] {{1}, {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}});
        
        // all the same negatives
        testScenarios.add(new int[][] {{1}, {-12, -12, -12, -12, -12, -12, -12, -12, -12, -12, -12, -12, -12}});
        
        // all big numbers
        testScenarios.add(new int[][] {{3}, {100000, 200000, 50000}});
        
        // some big numbers and small
        testScenarios.add(new int[][] {{9}, {100000, 0, 200000, 50000, 2, -100000, -200000, -50000, 1}});
        
        //medium numbers positive
        testScenarios.add(new int[][] {{12}, {930, 589, 400, 240, 332, 206, 100, 521, 841, 800, 200, 190}});
        
        //medium numbers both positive and negative
        testScenarios.add(new int[][] {{13}, {-930, -100, 589, -400, 240, 332, -206, 100, 521, 841, -800, 200, 190}});
        
        // all zeros
        testScenarios.add(new int[][] {{1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = Distinct.findDistinct(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
