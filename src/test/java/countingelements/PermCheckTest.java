package countingelements;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the PermCheck class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class PermCheckTest {
    
    @Test
    /**
     * This will test that the correct predicate: whether an array is a  
     * permutation or not, is determined.
     *
     * @covers countingelements.PermCheck.permCheck()
     * @covers countingelements.PermCheck.binSort()
     */
    public void testPermCheck() {
        System.out.println("permCheck");
        
        int[][][] testScenarios = new int[][][] {
            {{0}, {0}},// only one element, missing element
            {{1}, {1}},// a permutation of one element
            {{1}, {3, 2, 1}},// a permutation of 3 elements
            {{0}, {2, 3, 4}},// missing element at the start
            {{0}, {2, 3, 1, 5}},// missing element in the middle
            {{1}, {4, 1, 3, 2}},// a permutation of 4 elements
            {{0}, {4, 1, 3, 100}},// missing element in the middle with large int
            {{0}, {4, 1, 1, 3, 2}},// Contains duplicate element
        };
        
        for (int[][] scenario: testScenarios) {
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = PermCheck.permCheck(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
