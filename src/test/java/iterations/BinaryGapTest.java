package iterations;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.List;

/**
 * Test for BinaryGap Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class BinaryGapTest {

    @Test
    /**
     * This will test that conversion from decimal to binary is done correctly.
     *
     * @covers iterations.BinaryGap.binaryConvert()
     */
    public void testBinaryConvert() {
        System.out.println("binaryConvert");
        
        List<String[]> testScenarios = new ArrayList(); //a list of test scenarios

        testScenarios.add(new String[] {"32", "100000"});
        testScenarios.add(new String[] {"9", "1001"});
        testScenarios.add(new String[] {"15", "1111"});
        testScenarios.add(new String[] {"529", "1000010001"});
        testScenarios.add(new String[] {"20", "10100"});
        testScenarios.add(new String[] {"1041", "10000010001"});

        Iterator<String[]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            String[] scenario = scenarios.next();
            int decimal = Integer.parseInt(scenario[0]);;
            String startString = "";
            String expResult = scenario[1];
            String result = BinaryGap.binaryConvert(decimal, startString);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }

    @Test
    /**
     * This will test that the correct length of maximum binary gap is returned.
     *
     * @covers Iterations.BinaryGap.binaryGap()
     */
    public void testMaxBinaryGap() {
        System.out.println("maxBinaryGap");
        List<String[]> testScenarios = new ArrayList();

        testScenarios.add(new String[]{"100000", "0"});
        testScenarios.add(new String[]{"1001", "2"});
        testScenarios.add(new String[]{"1111", "0"});
        testScenarios.add(new String[]{"1000010001", "4"});
        testScenarios.add(new String[]{"10100", "1"});
        testScenarios.add(new String[]{"10000010001", "5"});
        testScenarios.add(new String[]{"101", "1"});
        
        Iterator<String[]> scenarios = testScenarios.iterator();

        while (scenarios.hasNext()) {
            String[] scenario = scenarios.next();
            String binaryString = scenario[0];
            int expResult = Integer.parseInt(scenario[1]);;
            int result = BinaryGap.maxBinaryGap(binaryString);
            assertEquals(expResult, result);
        }

    }
}
