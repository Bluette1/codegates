package sorting;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the NumberOfDiscIntersections class
 *
 * @author marylene
 * @since 28 August 2018
 */
public class NumberOfDiscIntersectionsTest {
    
    @Test
    /**
     * This will test that the correct number of disc intersections in a 
     * sequence of discs is retrieved.
     *
     * @covers sorting.NumberOfDiscIntersections.findNumberOfDiscIntersectionsMethodOne()
     */
    public void testFindNumberOfDiscIntersections() {
        System.out.println("findNumberOfDiscIntersections");
       
        List<int[][]> testScenarios = new ArrayList();
        
        testScenarios.add(new int[][] {{0}, {}});
        testScenarios.add(new int[][] {{0}, {0, 0}});
        testScenarios.add(new int[][] {{1}, {0, 1}});
        testScenarios.add(new int[][] {{4}, {1,0,0,3}});
        testScenarios.add(new int[][] {{11}, {1, 5, 2, 1, 4, 0}});
      
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = NumberOfDiscIntersections.findNumberOfDiscIntersectionsSolution(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
            int resultOne = NumberOfDiscIntersections.findNumberOfDiscIntersectionsAltMethodOne(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                resultOne
            );
            int resultTwo = NumberOfDiscIntersections.findNumberOfDiscIntersectionsAltMethodTwo(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                resultTwo
            );
            
             int resultThree = NumberOfDiscIntersections.findNumberOfDiscIntersectionsAltMethodThree(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                resultThree
            );
             int resultFour = NumberOfDiscIntersections.findNumberOfDiscIntersectionsAltMethodFour(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                resultFour
            ); 
        }
    }
}
