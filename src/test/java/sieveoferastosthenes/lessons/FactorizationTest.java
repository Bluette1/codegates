package sieveoferastosthenes.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import sieveoferastosthenes.lessons.Factorization;
import sieveoferastosthenes.lessons.Factorization;
import static org.junit.Assert.*;

/**
 * Test for the Factorization Class
 *
 * @author marylene
 * @since 13 April 2019
 */
public class FactorizationTest {
   
    @Test
    /**
     * This will test that the factorize method returns the correct array of 
     * prime factors
     *
     * @covers sieveoferastosthenes.lessons.Factorization.factorize()
     */
    public void testFactorize() {
        System.out.println("factorize");

        List<List<Integer>> testScenarios = new ArrayList();
        
        testScenarios.add(Arrays.asList(2));
        testScenarios.add(Arrays.asList(3));
        testScenarios.add(Arrays.asList(2, 2));
        testScenarios.add(Arrays.asList(5));
        testScenarios.add(Arrays.asList(2, 3));
        testScenarios.add(Arrays.asList(3, 3));
        testScenarios.add(Arrays.asList(17));
        testScenarios.add(Arrays.asList(2, 3, 3));
        testScenarios.add(Arrays.asList(2, 2, 5));
        
        int[] numbers = {2, 3, 4, 5, 6, 9, 17, 18, 20};
        
        for (int number = 0; number < numbers.length; number++) {
            List<Integer> result = Factorization.factorize(numbers[number]);
            List<Integer> expectedResult = testScenarios.get(number);
            assertTrue(result.equals(expectedResult));
        }
    }
}
