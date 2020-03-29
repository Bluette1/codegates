package maximumsliceproblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the MaximumSliceSum Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class MaxProfitTest {

    @Test
    /**
     * This will test that the correct maximum profit is obtained.
     *
     * @covers maximumsliceproblem.MaxProfit.findMaxProfit()
     */
    public void testFindMaxProfit() {
        System.out.println("findMaxProfit");

        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios

        testScenarios.add(new int[][]{{0}, {}});// empty price array
        testScenarios.add(new int[][]{{0}, {23171}});// one price
        testScenarios.add(new int[][]{{0}, {23171, 21011}});// two prices zero profit
        testScenarios.add(new int[][]{{2160}, {21011, 23171}});// two prices profit
        testScenarios.add(new int[][]{{2}, {23171, 21013, 21015}});// three prices
        
        // simple test
        testScenarios.add(new int[][]{{356}, {23171, 21011, 21123, 21366, 21013, 21367}});
        
        // ascending prices
        testScenarios.add(new int[][]{{500}, {21000, 21100, 21200, 21300, 21400, 21500}});
        
        // descending prices
        testScenarios.add(new int[][]{{0}, {21500, 21400, 21300, 21200, 21100, 21000}});
       
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int result = MaxProfit.findMaxProfit(scenario[1]);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
