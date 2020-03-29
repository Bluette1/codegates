package prefixsums;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the PassingCars class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class PassingCarsTest {
    
   @Test
    /**
     * This will test that the method returns the correct number of pairs of 
     * passing cars on the road.
     *
     * @covers prefixsums.PassingCars.countPassingCars()
     * @covers prefixsums.PassingCars.countPassingCars()
     */
    public void testCountPassingCars() {
        System.out.println("countPassingCars");

        List<int[][]> testScenarios = new ArrayList();

        testScenarios.add(new int[][] {{0}, {0}});// only one element
        testScenarios.add(new int[][] {{0}, {1, 0}});// two elements
        testScenarios.add(new int[][] {{5}, {0, 1, 0, 1, 1}}); // simple test
        testScenarios.add(new int[][] {{15}, {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}});// alternate starting with 1
        testScenarios.add(new int[][] {{15}, {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0}});// alternate starting with 0
        testScenarios.add(new int[][] {{0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});// all 0's
        testScenarios.add(new int[][] {{0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}});// all 1's
        testScenarios.add(new int[][] {{37}, {1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0}});// random
        
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = PassingCars.countPassingCars(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
