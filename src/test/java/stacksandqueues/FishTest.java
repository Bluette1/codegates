package stacksandqueues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Fish class.
 * 
 * @author marylene
 * @since 29 August 2018
 */
public class FishTest {
    
    @Test
    /**
     * This will test that the correct predicate: whether a triangle can be built 
     * from a given set of edges[1] or not[0] is determined.
     *
     * @covers stacksandqueues.Fish.countFish()
     */
    public void testCountFish() {
        System.out.println("countFish");
       
//        Map<Integer, int[][]> testScenarios = new HashMap();
        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
        testScenarios.add(new int[][] {{2}, {4, 3, 2, 1, 5}, {0, 1, 0, 0, 0}});

        testScenarios.add(new int[][] {{1}, {3}, {0}}); // one fish flowing upstream
        testScenarios.add(new int[][] {{1}, {7}, {1}});; // one fish flowing downstream
        testScenarios.add(new int[][] {{2}, {3, 7}, {1, 1}}); // two fish flowing downstream
        testScenarios.add(new int[][] {{2}, {3, 7}, {0, 0}}); // two fish flowing upstream
        testScenarios.add(new int[][] {{1}, {3, 7}, {1, 0}});// two fish one, opposite directions
        testScenarios.add(new int[][] {{2}, {4, 3, 2, 1, 5}, {0, 1, 0, 0, 0}});// simple test
        testScenarios.add(new int[][] {{5}, {4, 3, 2, 1, 5}, {0, 0, 0, 0, 0}});// all in the same direction
       
        Iterator<int[][]> scenarios = testScenarios.iterator();
        
        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] size = scenario[1];
            int[] direction = scenario[2];
            int result = Fish.countFish(size, direction);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            ); 
        }
    }
   
}
