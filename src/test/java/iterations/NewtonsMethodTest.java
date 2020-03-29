package iterations;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class for the NewtonsMethod class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class NewtonsMethodTest {
    
    @Test
    /**
     * This will test that the correct square root value is calculated.
     *
     * @covers iterations.NewtonsMethod.findSquareRoot()
     */
    public void testFindSquareRoot() {
        System.out.println("findSquareRoot");
        List<double[][]> testScenarios = new ArrayList();

        testScenarios.add(new double[][] {{2}, {1, 3, 1.4142156862745099}});
        testScenarios.add(new double[][] {{2}, {1, 7, 1.4142135623746899}});
        testScenarios.add(new double[][] {{7}, {2, 7, 2.6457513110646933}});        
        testScenarios.add(new double[][] {{7}, {2, 3, 2.6457520483808037}});
        testScenarios.add(new double[][] {{99}, {9, 7, 9.949874371859297}});
        testScenarios.add(new double[][] {{99}, {9, 2, 9.95}});
       
        Iterator<double [][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            double [][] scenario = scenarios.next();
            int number = (int) scenario[0][0];
            double expResult = scenario[1][2];
            double guess = scenario[1][0];
            int iterations = (int) scenario[1][1];
            double result = NewtonsMethod.findSquareRoot(number, guess, iterations);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result,
                0.00000000000000001
            );
        }

    }
    
}
