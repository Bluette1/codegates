package arrays;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for OddOccurrencesInArray
 *
 * @author marylene
 * @since 12 August 2018
 */
public class OddOccurrencesInArrayTest {
    
    @Test
    /**
     * This will test that the correct unpaired element is retrieved.
     *
     * @covers arrays.OddOccurrencesInArray.findUnpaired()
     */
    public void findUnpaired() {
        System.out.println("findUnpaired");
        
        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{1}, {1}});
        testScenarios.add(new int[][] {{2}, {1, 1, 3, 3, 2}});
        testScenarios.add(new int[][] {{7}, {9, 3, 9, 3, 9, 7, 9}});
        testScenarios.add(new int[][] {{3}, {3, 3, 3, 2, 2}});
        testScenarios.add(new int[][] {{1}, {1, 1, 1, 1, 1}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = OddOccurrencesInArray.findUnpaired(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }

}
