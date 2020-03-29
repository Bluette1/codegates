package countingelements;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the MaxCounters class.
 *
 * @author marylene
 * @since 9 August 2018
 */
public class MaxCountersTest {

    @Test
    /**
     * This will test that the correct counters array is retrieved.
     *
     * @covers countingelements.MaxCounters.maxCounters()
     */
    public void testMaxCounters() {
        System.out.println("maxCounters");

        Table<Integer, int[], int[]> testScenarios = HashBasedTable.create();
        
        testScenarios.put(5, new int[] {1}, new int[] {1, 0, 0, 0, 0});// only one operation
        
        // all max operations
        testScenarios.put(5, new int[] {6, 6, 6, 6, 6, 6, 6}, new int[] {0, 0, 0, 0, 0}); 
        
        // no max operations
        testScenarios.put(8, new int[] {3, 4, 4, 2, 1, 4, 4}, new int[] {1, 1, 1, 4, 0, 0, 0, 0}); 
        
        // one max counter
        testScenarios.put(5, new int[] {3, 4, 4, 6, 1, 4, 4}, new int[] {3, 2, 2, 4, 2});
        
        // five max counters
        testScenarios.put(
            9,
            new int[] {3, 10, 4, 10, 1, 4, 4, 10, 5, 10, 3, 10, 7, 8},
            new int[] {6, 6, 6, 6, 6, 6, 7, 7, 6}
        ); 
        
        // ten max counters
        testScenarios.put(
            6,
            new int[] {3, 7, 4, 7, 1, 4, 4, 7, 5, 7, 3, 7, 3, 7, 4, 7, 1, 4, 4, 7, 5, 7, 3, 7, 4, 1, 4, 3, 2, 2, 5},
            new int[] {13, 14, 13, 14, 13, 12}
        ); 

        Iterator<Table.Cell<Integer, int[], int[]>> scenarios = testScenarios.cellSet()
            .iterator();
        while (scenarios.hasNext()) {

            Table.Cell<Integer, int[], int[]> scenario = scenarios.next();
           
            int numOfCounters = scenario.getRowKey();
            int[] ops = scenario.getColumnKey();
            int[] expected = scenario.getValue();
            int[] actual = MaxCounters.maxCounters(numOfCounters, ops);
            Assert.assertArrayEquals(
                "Expected the actual result to equal the expected result",
                expected,
                actual
            );
        }
    }
}