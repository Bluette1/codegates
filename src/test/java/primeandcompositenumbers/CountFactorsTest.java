package primeandcompositenumbers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the CountFactors Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class CountFactorsTest {
    
    @Test
    /**
     * This will test that the correct number of factors of a given number is obtained
     *
     * @covers primeandcompositenumbers.CountFactors.findFactors()
     */
    public void testFindFactors() {
        System.out.println("findFactors");
        
        int[][] testScenarios = new int[][] {
            {1, 1}, // n = 1
            {2, 2}, // n = 2
            {2, 3}, // n = 3
            {3, 4}, // n = 4
            {2, 7}, // n = 7
            {8, 24}, // simple test
            {5, 16}, // square
            {9, 36}, // another square
            {2, 41}, // larger prime
            {8, 42}, // n = 42
            {4, 69}, // another large prime
            {7, 64}, // n = 64
            {16, 120}, // n = 120
            {30, 720}, // n = 120
            {4, 1111}, // large prime
            {60, 5040}, // n = 5040
            {8, 12345}, // n = 12345
            {4, 34879}, // n = 34879
            {96, 40320}, // n = 40320
        };
        
        for (int[] scenario: testScenarios) {
            int expResult = scenario[0];
            int number = scenario[1];
            int result = CountFactors.countFactors(number);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
