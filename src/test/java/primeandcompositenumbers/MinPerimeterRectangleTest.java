package primeandcompositenumbers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the MinPerimeterRectangle Class
 *
 * @author marylene
 * @since 9 August 2018
 */
public class MinPerimeterRectangleTest {
    
    @Test
    /**
     * This will test that the correct minimal perimeter of any rectangle with 
     * a given area is obtained.
     * 
     * @covers primeandcompositenumbers.MinPerimeterRectangle.findMinPerimeter()
     */
    public void testFindMinPerimeter() {
        System.out.println("findMinPerimeter");
        
        int[][] testScenarios = new int[][] {
            {4, 1}, // area = 1
            {22, 30}, // area = 30
            {24, 36}, // area = 36
            {28, 48}, // area = 48
            {204, 101}, // area = 101
            {1238, 1234}, // area = 1234
            {8552, 4564320}, // area = 4564320
            {30972904,  15486451 }, // prime
            {40000, 100000000}, // square
            {1964903308, 982451653}, // larger prime
            {126500,  1000000000}, // extreme max
        };
        
        for (int[] scenario: testScenarios) {
            int expResult = scenario[0];
            int number = scenario[1];
            int result = MinPerimeterRectangle.findMinPerimeter(number);
            assertEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
}
