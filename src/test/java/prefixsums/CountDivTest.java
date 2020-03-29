package prefixsums;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the CountDiv class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class CountDivTest {
    
    @Test
    /**
     * This will test that the method returns the correct number of integers 
     * divisible by the divisor in range [first..last] .
     *
     * @covers prefixsums.CountDiv.countDiv()
     */
    public void testCountDiv() {
        System.out.println("countDiv");

        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{1}, {0, 1, 2}});// minimal
        testScenarios.add(new int[][] {{1}, {0, 1, 11}});// minimal;
        testScenarios.add(new int[][] {{20}, {11, 345, 17}}); // simple test
        testScenarios.add(new int[][] {{3}, {6, 11, 2}});// simple test
        testScenarios.add(new int[][] {{1}, {10, 10, 5}}); // extreme  
        testScenarios.add(new int[][] {{0}, {10, 10, 7}});// extreme if empty
        testScenarios.add(new int[][] {{0}, {10, 10, 20}}); // extreme if empty
        testScenarios.add(new int[][] {{614999951}, {100, 1230000000, 2}});// big values
        
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int first = scenario[1][0];
            int last = scenario[1][1];
            int divisor = scenario[1][2];
            int result = CountDiv.countDiv(first, last, divisor);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
