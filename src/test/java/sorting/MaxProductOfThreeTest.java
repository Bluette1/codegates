package sorting;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the MaxProductOfThree class.
 * 
 * @author marylene
 * @since 28 August 2018
 */
public class MaxProductOfThreeTest {
    
     @Test
    /**
     * This will test that the correct max product of three is retrieved.
     *
     * @covers sorting.MaxProductOfThree.findMaxProductOfThree()
     */
    public void findMaxProductOfThree() {
        System.out.println("findMaxProductOfThree");

        List<int[][]> testScenarios = new ArrayList();

        // 3 elements
        testScenarios.add(new int[][] {{4}, {1, 2, 2}});
        
        // simple test all positives
        testScenarios.add(new int[][] {{300}, {3, 10, 2, 2, 5, 6, 1}});
        
        // simple test negatives and positives
        testScenarios.add(new int[][] {{60}, {-3, 1, 2, -2, 5, 6}});
        
        // more than 3 elements, one positive
        testScenarios.add(new int[][] {{72}, {1, -2, -2, -8, -9}});
        
        // more than 3 elements, two positives
        testScenarios.add(new int[][] {{720}, {10, 1, -2, -2, -8, -9}});
        
        // negatives and positives with 0, 2 larger negatives
        testScenarios.add(new int[][] {{128}, {4, -4, 0, 1, 1, 4, -8, 4, 0, 1, 1, -3}});
        
        // negatives and positives with 0
        testScenarios.add(new int[][] {{144}, {4, 4, 0, 0, -1, 4, 9, 0, 0, 1, -4, -4, 0, 0, 1}});
        
        // only negatives and zero
        testScenarios.add(new int[][] {{0}, {-8, -3, -1, -9, 0, -10, -9, -12}});
        
        // only negatives
        testScenarios.add(new int[][] {{-6}, {-8, -3, -1, -9, -10, -9, -12, -5, -2}});
        
        // only one negative
        testScenarios.add(new int[][] {{1080}, {8, 3, 1, 9, 10, -9, 12, 5, 2}});
        
        // some big and small numbers 
        testScenarios.add(new int[][] {{5000000}, {1, 0, 2, 5, 2, -200, -5000, 1}});

        Iterator< int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = MaxProductOfThree.findMaxProductOfThree(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
