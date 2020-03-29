package arrays;

import java.util.Iterator;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for CyclicRotation
 *
 * @author marylene
 * @since 12 August 2018
 */
public class CyclicRotationTest {

    @Test
     /**
       * Test that the correct output array is returned for a given number of rotations.
       *
       * @author marylene
       * @since  10 August 2018
       *
       * @covers arrays.CyclicRotation.findSquareRoot
       */
    public void rotate() {
        System.out.println("rotate");
        Table<int[], int[], Integer> testScenarios = HashBasedTable.create();

        testScenarios.put(new int[] {}, new int[] {}, 1);
        testScenarios.put(new int[] {0}, new int[] {0}, 2);
        testScenarios.put(new int[] {1, 1, 1}, new int[] {1, 1, 1}, 3);
        testScenarios.put(new int[] {3, 8, 9, 7, 6}, new int[] {6, 3, 8, 9, 7}, 1);
        testScenarios.put(new int[] {3, 8, 9, 7, 6}, new int[] {7, 6, 3, 8, 9}, 2);
        testScenarios.put(new int[] {3, 8, 9, 7, 6}, new int[] {9, 7, 6, 3, 8}, 3);
        testScenarios.put(new int[] {3, 8, 9, 7, 6}, new int[] {8, 9, 7, 6, 3}, 4);
        testScenarios.put(new int[] {3, 8, 9, 7, 6}, new int[] {3, 8, 9, 7, 6}, 5);
        testScenarios.put(new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}, 4);

        Iterator<Table.Cell<int[], int[], Integer>> scenarios = testScenarios.cellSet()
            .iterator();

        while (scenarios.hasNext()) {
            Table.Cell<int[], int[], Integer> scenario = scenarios.next();

            int[] inputArray = scenario.getRowKey();
            int[] outputArray = scenario.getColumnKey();
            int rotations = scenario.getValue();
            int[] result = CyclicRotation.rotate(inputArray, rotations);
            Assert.assertArrayEquals(
                "The result was expected to equal outputArray",
                outputArray, 
                result
            );
        }
    }
    
}
