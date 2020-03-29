package leader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the Dominator Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class DominatorTest {
    
     @Test
    /**
     * This will test that the correct index of dominator is returned.
     *
     * @covers leader.Dominator.findDominatorIndex()
     */
    public void testFindDominatorIndex() {
        System.out.println("findDominatorIndex");
        
        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
        
        testScenarios.add(new int[][] {{-1}, {}});// empty
        testScenarios.add(new int[][] {{0}, {4}});// one element
        testScenarios.add(new int[][] {{6}, {3, 4, 3, 2, 3, -1, 3, 3}});// simple test
        testScenarios.add(new int[][] {{-1}, {1, 2, 3,  4, 5, 6, 7}});// all different
        testScenarios.add(new int[][] {{0}, {1, 1, 1, 1, 1, 1, 1}}); // all same
        
        // 2 different elements occurring equal number of times
        testScenarios.add(new int[][] {{-1}, {1, 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6}}); 
        
        // 2 different elements first one occurring n/2 + 1 times
        testScenarios.add(new int[][] {{0}, {1, 1, 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6}}); 
        
        // 2 different elements second one occurring n/2 + 1 times
        testScenarios.add(new int[][] {{12}, {1, 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 6}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
         
            int expResult = scenario[0][0];
            int result = Dominator.findDominatorIndex(scenario[1]);
                assertEquals(
                    "The result was expected to equal the expected result",
                    expResult,
                    result
                );
            }
        }
}
