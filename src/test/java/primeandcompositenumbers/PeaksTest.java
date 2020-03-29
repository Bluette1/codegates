package primeandcompositenumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the Peaks Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class PeaksTest {
    
     @Test
    /**
     * This will test that the method returns the correct number of maximum blocks
     *
     * @covers primeandcompositenumbers.Peaks.findMaxBlocks()
     */
    public void testFindMaxBlocks() {
        System.out.println("findMaxBlocks");

        List<int[][]> testScenarios = new ArrayList();
        
        testScenarios.add(new int[][] {{0}, {4, 1}});// extreme minimum
        testScenarios.add(new int[][] {{1}, {3, 4, 1,}});// minimal positive
        testScenarios.add(new int[][] {{0}, {1, 2, 3}});// minimal negative
        
        // simple test
        testScenarios.add(new int[][] {{3}, {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}}); 
        
        // another simple test
        testScenarios.add(new int[][] {{6}, {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}}); 
       
        // prime sequence length test
        testScenarios.add(new int[][] {{1}, {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 5}}); 
        
        Iterator<int[][]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            int[][] scenario = scenarios.next();
            int expResult = scenario[0][0];
            int[] array = scenario[1];
            int result = Peaks.findMaxBlocks(array);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
   
}
