package prefixsums;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the GenomicRangeQuery class.
 * 
 * @author marylene
 * @since 9 August 2018
 */
public class GenomicRangeQueryTest {
    
    @Test
    /**
     * This will test that the method returns the correct minimal nucleotide
     * from a range of sequence DNA.
     *
     * @covers prefixsums.GenomicRangeQuery.minGenomicQuery()
     * @covers prefixsums.GenomicRangeQuery.prefixLast()
     */
    public void testMinGenomicQuery() {
        System.out.println("minGenomicQuery");
        Multimap<String, int[][]> testScenarios = ArrayListMultimap.create();
        
        testScenarios.put("A", new int[][] {{0}, {0}, {1}}); // single character A
        testScenarios.put("C", new int[][] {{0}, {0}, {2}}); // single character C
        testScenarios.put("G", new int[][] {{0}, {0}, {3}});// single character G
        testScenarios.put("T", new int[][] {{0}, {0}, {4}}); // single character T
        testScenarios.put("AT", new int[][] {{0, 0}, {0, 1}, {1, 1}});// two characters A and T
        testScenarios.put("GC", new int[][] {{0, 0}, {0, 1}, {3, 2}});// two characters G and C
        testScenarios.put("AC", new int[][] {{0, 0}, {0, 1}, {1, 1}});// two characters A and C
        testScenarios.put("GT", new int[][] {{0, 0}, {0, 1}, {3, 3}});// two characters G and T
        testScenarios.put("CAGCCTA", new int[][] {{2, 5, 0}, {4, 5, 6}, {2, 4, 1}}); // simple test
        
        // almost all the same A
        testScenarios.put(
            "CAGCCTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 1, 1, 1, 1}
        });
        
        // almost all the same C
        testScenarios.put(
            "CAGCCTACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 2, 2, 2, 2}
        });
        
         // almost all the same G
         testScenarios.put(
            "CAGCCTAGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 3, 3, 3, 3}
        });
         
          // almost all the same T
         testScenarios.put(
            "CAGCCTATTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 4, 4, 4, 4}
        });

        Iterator<Map.Entry<String, int[][]>> scenarios = testScenarios.entries()
            .iterator();

        while (scenarios.hasNext()) {
            
            Map.Entry<String, int[][]> scenario = scenarios.next();
            
            String dnaString = scenario.getKey();
            int[][] arrays = scenario.getValue();
            int[]start = arrays[0];
            int[]end = arrays[1];
            int[]expResult = arrays[2];
            
            int[] result = GenomicRangeQuery.minGenomicQuery(dnaString, start, end);
            assertArrayEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
    }
    
    @Test
    /**
     * This will test that the method returns the correct minimal nucleotide
     * from a range of sequence DNA.
     * 
     * @covers prefixsums.GenomicRangeQuery.findPrefixMin()
     * @covers prefixsums.GenomicRangeQuery.prefixMin()
     */
    public void testFindPrefixMin() {
        System.out.println("findPrefixMin");
        Multimap<String, int[][]> testScenarios = ArrayListMultimap.create();
        
        testScenarios.put("A", new int[][] {{0}, {0}, {1}}); // single character A
        testScenarios.put("C", new int[][] {{0}, {0}, {2}}); // single character C
        testScenarios.put("G", new int[][] {{0}, {0}, {3}});// single character G
        testScenarios.put("T", new int[][] {{0}, {0}, {4}}); // single character T
        testScenarios.put("AT", new int[][] {{0, 0}, {0, 1}, {1, 1}});// two characters A and T
        testScenarios.put("GC", new int[][] {{0, 0}, {0, 1}, {3, 2}});// two characters G and C
        testScenarios.put("AC", new int[][] {{0, 0}, {0, 1}, {1, 1}});// two characters A and C
        testScenarios.put("GT", new int[][] {{0, 0}, {0, 1}, {3, 3}});// two characters G and T
        testScenarios.put("CAGCCTA", new int[][] {{2, 5, 0}, {4, 5, 6}, {2, 4, 1}}); // simple test
        
        // almost all the same A
        testScenarios.put(
            "CAGCCTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 1, 1, 1, 1}
        });
        
        // almost all the same C
        testScenarios.put(
            "CAGCCTACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 2, 2, 2, 2}
        });
        
         // almost all the same G
         testScenarios.put(
            "CAGCCTAGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 3, 3, 3, 3}
        });
         
          // almost all the same T
         testScenarios.put(
            "CAGCCTATTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT", 
            new int[][]{
            {2, 5, 0, 7, 10, 12, 13},
            {4, 5, 6, 9, 11, 14, 16},
            {2, 4, 1, 4, 4, 4, 4}
        });
         
        Iterator<Map.Entry<String, int[][]>> scenarios = testScenarios.entries()
            .iterator();

        while (scenarios.hasNext()) {
            Map.Entry<String, int[][]> scenario = scenarios.next();
            String dnaString = scenario.getKey();
            
            int[][] arrays = scenario.getValue();
            int[]start = arrays[0];
            int[]end = arrays[1];
            int[]expResult = arrays[2];
            
            int[] result = GenomicRangeQuery.findPrefixMin(dnaString, start, end);
            Assert.assertArrayEquals(
                "The result was expected to equal the expected result",
                expResult,
                result
            );
        }
  
    }
}