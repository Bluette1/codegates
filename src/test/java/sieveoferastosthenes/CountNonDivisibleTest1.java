package sieveoferastosthenes;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * Test class for CountNonDivisible1
 *
 * @author marylene
 * @since 13 April 2019
 */
public class CountNonDivisibleTest1 {
    
    @Test
    /**
     * This will test that the correct array of non divisors is returned given an
     * input array
     *
     * @covers sieveoferastosthenes.CountNonDivisible.countNonDivisible()
     */
    public void testCountNonDivisible() {
        System.out.println("countNonDivisible");
        
        int[][] testScenarios = {
            {1},
            {2},
            {3,6},
            {3, 1, 2, 3, 6},
            {2, 3, 5, 7, 11, 13, 17, 19, 23}
        };
        
        int[][] results = {
            {0},
            {0},
            {1,0},
            {2, 4, 3, 2, 0},
            {8, 8, 8, 8, 8, 8, 8, 8, 8}        
        };
        
        for (int i = 0; i < testScenarios.length; i++) {
            int[] result = CountNonDivisible1.countNonDivisible(testScenarios[i]);
            int[] expectedResult = results[i];
            assertTrue(Arrays.equals(expectedResult, result));
        }
    }
}
