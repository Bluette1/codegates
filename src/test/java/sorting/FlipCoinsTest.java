package sorting;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the FlipCoins Class
 *
 * @author marylene
 * @since 20 May 2019
 */
public class FlipCoinsTest {

    @Test
    /**
     * This will test that the correct number of minimum coins flipped is
     * obtained.
     *
     * @covers sorting.FlipCoins.flipCoins()
     */
    public void testFlipCoins() {
        System.out.println("flipCoins");

        int[][] testScenarios = {
            {0},
            {1},
            {0, 1},
            {0, 0},
            {0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1}
        };

        int[] expectedResults = {0, 0, 1, 0, 1, 2, 2, 2, 0, 0};

        for (int i = 0; i < testScenarios.length; i++) {
            int result = FlipCoins.flipCoins(testScenarios[i]);
            int expectedResult = expectedResults[i];
            assertEquals(
                "The result was expected to equal the expected result",
                expectedResult,
                result
            );
        }
    }
}
