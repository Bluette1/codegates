package sieveoferastosthenes.lessons;

import java.util.Arrays;
import org.junit.Test;
import sieveoferastosthenes.lessons.ArrayFactorization;
import sieveoferastosthenes.lessons.ArrayFactorization;
import static org.junit.Assert.*;

/**
 * Test for the ArrayFactorization Class
 *
 * @author marylene
 * @since 13 April 2019
 */
public class ArrayFactorizationTest {

    @Test
    /**
     * This will test that the correct array of prime factors of a given
     * number is retrieved.
     *
     * @covers sieveoferastosthenes.lessons.ArrayFactorization.arrayFactorize()
     */
    public void testArrayFactorize() {
        System.out.println("arrayFactorize");
        
        int[] testScenarios = {2, 3, 4, 5, 6, 9, 17, 18, 20};
        
        int[][] results = {
            {0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0, 2},
            {0, 0, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 2},
            {0, 0, 0, 0, 2, 0, 2, 0, 2, 3},
            {0, 0, 0, 0, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 2, 3, 2, 0},
            {0, 0, 0, 0, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 2, 3, 2, 0, 2},
            {0, 0, 0, 0, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 2}        
        };
        
        for (int i = 0; i < testScenarios.length; i++) {
            int[] result = ArrayFactorization.arrayFactorize(testScenarios[i]);
            int[] expectedResult = results[i];
            assertTrue(Arrays.equals(expectedResult, result));
        }
    }
}
