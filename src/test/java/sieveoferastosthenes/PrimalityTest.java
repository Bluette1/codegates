package sieveoferastosthenes;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The PrimalityTest class
 *
 * @author marylene 16 July
 */
public class PrimalityTest {

    private static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private static long randLong(long low, long high) {
        long LOWER_RANGE = low;
        long UPPER_RANGE = high;
        Random random = new Random();
        long randomValue = LOWER_RANGE
                + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
        return randomValue;
    }

    private static String primeSol(long n) {
        if (n == 2) {
            return "Prime";
        } else if ((n < 2) || (n % 2 == 0)) {
            return "Not prime";
        } else {
            for (long i = 3; i <= Math.sqrt(n); ++i) {
                if (n % i == 0) {
                    return "Not prime";
                }
            }
            return "Prime";
        }
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests");
        // 0 is neither prime nor composite 
        assertEquals("Not prime", Primality.primality(0));
        // 1 is neither prime nor composite
        assertEquals("Not prime", Primality.primality(1));
        assertEquals("Prime", Primality.primality(101));
        assertEquals("Prime", Primality.primality(103));
        assertEquals("Not prime", Primality.primality(100));
        assertEquals("Prime", Primality.primality(107));
        assertEquals("Not prime", Primality.primality(110));
        assertEquals("Not prime", Primality.primality(300));
        assertEquals("Prime", Primality.primality(359));
        assertEquals("Prime", Primality.primality(367));
        assertEquals("Prime", Primality.primality(337));
        assertEquals("Prime", Primality.primality(347));
        assertEquals("Not prime", Primality.primality(400));
        assertEquals("Prime", Primality.primality(30109));
        assertEquals("Prime", Primality.primality(30113));
        assertEquals("Prime", Primality.primality(30091));
        assertEquals("Prime", Primality.primality(30097));
        assertEquals("Prime", Primality.primality(30161));
        assertEquals("Prime", Primality.primality(30169));
        assertEquals("Not prime", Primality.primality(30000));
        assertEquals("Not prime", Primality.primality(100000));
        assertEquals("Not prime", Primality.primality(10000000));
        assertEquals("Not prime", Primality.primality(11000000));
        assertEquals("Prime", Primality.primality(10000139));
        assertEquals("Prime", Primality.primality(10000141));
    }
    
    @Test
    public void test2() {
        System.out.println("100 Random Tests");
        for (int i = 0; i < 100; i++) {
            int n = 0;
             if (randInt(0, 99) % 2 == 0)// this is for extra randomization
            {
                n = randInt(0, 499);
            } else {
                n = randInt(500, 999);
            }
            assertEquals(primeSol(n), Primality.primality(n));
        }
    }

    @Test
    public void test3() {
        System.out.println("300 Random Tests");
        for (int i = 0; i < 300; i++) {
            long n = 0;
            if (randInt(0, 99) % 5 == 0)// this is for extra randomization
            {
                n = randLong(1000, 2000);
            } else {
                n = randLong(100000, 1000000);
            }

            assertEquals(primeSol(n), Primality.primality(n));
        }
    }
}
