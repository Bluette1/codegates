package timecomplexity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the PermMissingElem class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class PermMissingElemTest {
  @Test
    /**
     * This will test that the correct missing element 
     * in a given permutation is retrieved.
     *
     * @covers timecomplexity.PermMissingElem.findMissingElement()
     * @covers timecomplexity.PermMissingElem.binSort()
     */
    public void testFindMissingElement() {
        System.out.println("findMissingElement");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
        
        testScenarios.add(new int[][]{{1}, {}});// empty array
        testScenarios.add(new int[][]{{2}, {1}});// only one element
        testScenarios.add(new int[][]{{1}, {2, 3, 4}});// missing element at the start
        testScenarios.add(new int[][]{{4}, {2, 3, 1, 5}});// missing element in the middle
        testScenarios.add(new int[][]{{5}, {2, 3, 1, 4}});// missing element at the end

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = PermMissingElem.findMissingElement(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
