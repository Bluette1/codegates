package euclideanalgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The test class for CommonPrimeDivisors.
 * 
 * @author marylene
 * @since 9 August 2017
 */
public class CommonPrimeDivisorsTest {
    
    @Test
    /**
     * This will test that the correct number of common prime divisors is 
     * retrieved.
     *
     * @covers euclideanalgorithm.CommonPrimeDivisors.haveCommonPrimes()
     */
    public void testHaveCommonPrimes() {
        System.out.println("haveCommonPrimes");
       
        List<int[][]> testScenarios = new ArrayList();
        
        testScenarios.add(new int[][] {{0}, {10}, {75}});// one element negative
        testScenarios.add(new int[][] {{1}, {15}, {75}});// one element positive
        // small numbers
        testScenarios.add(new int[][] {{1}, {2, 1, 2}, {1, 3, 2}});
        // large numbers
        testScenarios.add(new int[][] {{2}, {6059, 551}, {442307, 303601}});
       
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] arrayA = scenario[1];
            int[] arrayB = scenario[2];
            int result = CommonPrimeDivisors.commonPrimeDivisors(arrayA, arrayB);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
    
    @Test
    /**
     * This will test that the correct number of common prime divisors is 
     * retrieved.
     *
     * @covers euclideanalgorithm.CommonPrimeDivisors1.haveCommonPrimes1()
     */
    public void testHaveCommonPrimes1() {
        System.out.println("haveCommonPrimes1");
       
        List<int[][]> testScenarios = new ArrayList();
        
        testScenarios.add(new int[][] {{0}, {10}, {75}});// one element negative
        testScenarios.add(new int[][] {{1}, {15}, {75}});// one element positive
        // small numbers
        testScenarios.add(new int[][] {{1}, {2, 1, 2}, {1, 3, 2}});
        // large numbers
        testScenarios.add(new int[][] {{2}, {6059, 551}, {442307, 303601}});
       
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] arrayA = scenario[1];
            int[] arrayB = scenario[2];
            int result = CommonPrimeDivisors1.commonPrimeDivisors1(arrayA, arrayB);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
