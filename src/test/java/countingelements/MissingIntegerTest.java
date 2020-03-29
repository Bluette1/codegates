package countingelements;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the MissingInteger class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class MissingIntegerTest {
    
   @Test
    /**
     * This will test that the method returns the smallest positive integer
     * (greater than 0) that does not occur in array.
     *
     * @covers countingelements.MissingInteger.findMissingInteger()
     * @covers countingelements.MissingInteger.findMissingInteger()
     */
    public void testFindMissingInteger() {
        System.out.println("findMissingInteger");

        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{1}, {0}}); // only one element, missing element)
        testScenarios.add(new int[][] {{2}, {1}}); // a permutation of one element
        testScenarios.add(new int[][] {{4}, {3, 2, 1}}); // a permutation of 3 elements
        testScenarios.add(new int[][] {{1}, {2, 3, 4}}); // missing element at the start
        testScenarios.add(new int[][] {{4}, {2, 3, 1, 5}}); // missing element in the middle
        testScenarios.add(new int[][] {{5}, {4, 1, 3, 2}}); // a permutation of 4 elements
        testScenarios.add(new int[][] {{2}, {4, 1, 3, 100}}); // missing element in the middle with large int
        testScenarios.add(new int[][] {{1}, {4, -1, -1, 3, 2}}); // Contains negative elements
        testScenarios.add(new int[][] {{1}, {-4, -1, -1, -3, -2}});// Only negatives
        
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = MissingInteger.findMissingInteger(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}