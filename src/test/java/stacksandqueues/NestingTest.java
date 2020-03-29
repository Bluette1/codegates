package stacksandqueues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Nesting class
 *
 * @author marylene
 * @since 29 August 2018
 */
public class NestingTest {
    
   @Test
    /**
     * This will test that the correct predicate: a given string of parentheses
     * is properly nested.
     *
     * @covers stacksandqueues.Nesting.isNested()
     */
    public void testIsNested() {
        System.out.println("isNested");
       
        List<String[]> testScenarios = new ArrayList(); //a list of test scenarios
        
        testScenarios.add(new String[] {"1", ""}); // empty
        testScenarios.add(new String[] {"0", "("});; // one open bracket
        testScenarios.add(new String[] {"0", ")"}); // one close bracket
        testScenarios.add(new String[] {"1", "()"}); // basic nested
        testScenarios.add(new String[] {"1", "(()(())())"}); // group simple test nested
        testScenarios.add(new String[] {"0", "(()((())())("}); // group simple test unnested
        // long nested
        testScenarios.add(new String[] {"1", "(()(())())(()(())())(()(())())()(()(())())(()(())())(())()"});
        // long unnested
        testScenarios.add(new String[] {"0", "((()(())())()(())())()(())())(()(())())()(())()))(()(())())"});
        
        Iterator<String[]> scenarios = testScenarios.iterator();
        
        while (scenarios.hasNext()) {
            String[] scenario = scenarios.next();
            int expResult = Integer.parseInt(scenario[0]);
            String string = scenario[1];
            int result = Nesting.isNested(string);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            ); 
        }
    }
}
