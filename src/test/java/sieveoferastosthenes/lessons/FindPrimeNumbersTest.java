package sieveoferastosthenes.lessons;

import java.util.Arrays;
import org.junit.Test;
import sieveoferastosthenes.lessons.FindPrimeNumbers;
import sieveoferastosthenes.lessons.FindPrimeNumbers;
import static org.junit.Assert.*;

/**
 * Test for the FindPrimeNumbers Class
 *
 * @author marylene
 * @since 13 April 2019
 */
public class FindPrimeNumbersTest {

    @Test
    /**
     * This will test that the correct array of prime numbers within a given
     * range is retrieved.
     *
     * @covers sieveoferastosthenes.lessons.FindPrimeNumbers.findPrimeNumbers()
     */
    public void testFindPrimeNumbers() {
        System.out.println("findPrimeNumbers");
        
        boolean[][] testScenarios = {
            {true, true, false},
            {true, true, false, false},
            {true, true, false, false, true},
            {true, true, false, false, true, false},
            {true, true, false, false, true, false, true},
            {true, true, false, false, true, false, true, false, true, true},
            {true, true, false, false, true, false, true, false, true, true,
            true, false, true, false, true, true, true, false},
            {true, true, false, false, true, false, true, false, true, true,
            true, false, true, false, true, true, true, false, true},
            {true, true, false, false, true, false, true, false, true, true,
            true, false, true, false, true, true, true, false, true, false, true}
        };
        
        int[] numbers = {2, 3, 4, 5, 6, 9, 17, 18, 20};
        
        for (int number = 0; number < numbers.length; number++) {
            boolean[] result = FindPrimeNumbers.findPrimeNumbers(numbers[number]);
            boolean[] expectedResult = testScenarios[number];
            assertTrue(Arrays.equals(expectedResult, result));
        }
    }
}
