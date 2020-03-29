package sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Triangle class.
 * 
 * @author marylene
 * @since 29 August 2018
 */
public class TriangleTest {
    
    @Test
    /**
     * This will test that the correct predicate: whether a triangle can be built 
     * from a given set of edges[1] or not[0] is determined.
     *
     * @covers sorting.Triangle.triangle()
     */
    public void testTriangle() {
        System.out.println("triangle");
       
        List<int[][]> testScenarios = new ArrayList(); //a list of test scenarios
           
        testScenarios.add(new int[][]{{0}, {}});// empty
        testScenarios.add(new int[][]{{0}, {5, 7}});// only two elements
        testScenarios.add(new int[][]{{0}, {0, 1, 0}});// three elements
        testScenarios.add(new int[][]{{1}, {10, 1, 2, 8, 5, 20}});// simple test
        testScenarios.add(new int[][]{{0}, {Integer.MAX_VALUE, 1, 4}});// with MAXINT value
        
        //testing arithmetic overflows
        testScenarios.add(new int[][]{{1}, {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE}});
        testScenarios.add(new int[][]{{1}, {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}});

        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = Triangle.triangle(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
