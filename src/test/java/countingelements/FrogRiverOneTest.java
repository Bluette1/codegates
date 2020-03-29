package countingelements;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for the FrogRiverOne class.
 *
 * @author marylene
 * @since 9 August 2018
 */
public class FrogRiverOneTest {

    @Test
    /**
     * This will test that the correct earliest time when the frog can jump to
     * the other side of the river is retrieved.
     *
     * @covers countingelements.FrogRiverOne.findEarliestTime()
     * @covers countingelements.FrogRiverOne.binSort()
     */
    public void testFindEarliestTime() {
        System.out.println("findEarliestTime");
        Table<Integer, int[], Integer> testScenarios = HashBasedTable.create();

        testScenarios.put(1, new int[] {1}, 0); // single element, frog crosses the river
        testScenarios.put(1, new int[] {5}, -1); // single element, frog never across the river
        testScenarios.put(5, new int[] {1}, -1); // single element, frog never across the river
        testScenarios.put(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}, 6); // frog crosses the river
        testScenarios.put(8, new int[] {1, 3, 1, 4, 2, 3, 5, 4}, -1); // frog never across the river
        testScenarios.put(3, new int[] {2, 2, 2, 2, 2, 2, 2, 2}, -1); // all leaves in the same place.

        Iterator<Table.Cell<Integer, int[], Integer>> scenarios = testScenarios.cellSet()
            .iterator();
        while (scenarios.hasNext()) {

            Table.Cell<Integer, int[], Integer> scenario = scenarios.next();

            int position = scenario.getRowKey();
            int[] array = scenario.getColumnKey();
            int expectedTime = scenario.getValue();
            int actualTime = FrogRiverOne.findEarliestTime(position, array);
            assertEquals(
                "Expected the actual time to equal the expected time",
                expectedTime,
                actualTime
            );
        }
    }
}
