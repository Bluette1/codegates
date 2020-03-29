package sieveoferastosthenes;

import java.util.Iterator;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for CountSemiPrimes
 *
 * @author marylene
 * @since 13 April 2019
 */
public class CountSemiPrimesTest {

    @Test
    /**
     * Test that the correct output array is returned for the given ranges.
     *
     * @covers sieveoferastosthenes.CountSemiprimes.countSemiPrimes
     */
    public void testCountSemiPrimes() {
        System.out.println("countSemiPrimes");
        Table<int[], int[], Integer> testScenarios = HashBasedTable.create();
        
        testScenarios.put(new int[] {1, 4, 16}, new int[] {26, 10, 20}, 26);

        testScenarios.put(new int[] {}, new int[] {}, 5);
 
        int[][] results = {
            {10, 4, 0},
            {}
        };
        Iterator<Table.Cell<int[], int[], Integer>> scenarios = testScenarios.cellSet()
                .iterator();

        int resultsCount = 0;
        while (scenarios.hasNext()) {
            Table.Cell<int[], int[], Integer> scenario = scenarios.next();

            int[] start = scenario.getRowKey();
            int[] end = scenario.getColumnKey();
            int[] outputArray = results[resultsCount];
            int number = scenario.getValue();
            int[] result = CountSemiprimes.countSemiPrimes(number, start, end);
            Assert.assertArrayEquals(
                    "The result was expected to equal outputArray",
                    outputArray,
                    result
            );
            
            resultsCount++;
        }
    }

}
