package sieveoferastosthenes;

import java.util.Arrays;

/**
 * Solution for the CountSemiprimes task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training5GWXYB-JCW/
 * @since 9 August 2018
 */
public class CountSemiprimes {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        System.out.println(Arrays.toString(countSemiPrimes(N, P, Q)));
    }
    
    /**
     * Calculates the number of semiprimes in the given ranges indicated by 
     * by start and end arrays.
     * 
     * @param number an integer
     * @param start the array of starting indices in the given ranges
     * @param end the array of ending indices in the given ranges
     * @return semiPrimesCount the resulting array with the number of semiprimes  
     *         in the given ranges
     */
    public static int[] countSemiPrimes(int number, int[] start, int[] end) {
        int length = start.length;
        int[] semiPrimesCount = new int[length];
        int[] arrFactorzn = arrFactorzn(number);
        int[] arrSemiPrimes = semiPrimes(number, arrFactorzn);
        int m = arrSemiPrimes.length;
        int[] prefixSums = new int[m + 1];

        for (int i = 1; i < m + 1; i++) {
            prefixSums[i] = prefixSums[i - 1] + arrSemiPrimes[i - 1];
        }

        int count = 0;
        while (count < length) {
            semiPrimesCount[count] = prefixSums[end[count] + 1] - prefixSums[start[count]];
            count++;
        }
        return semiPrimesCount;
    }

    /**
     * Calculates the semiprimes of a given number
     *
     * @param number an integer
     * @param arrFactorzn the preparation array for factorization
     * @return semiPrimes the resulting array of flags indicating the semiprimes 
     *         in the range 0...n
     */
    public static int[] semiPrimes(int number, int[] arrFactorzn) {
        int[] semiPrimes = new int[number + 1];
        for (int j = 1; j <= number; j++) {
            int x = j;
            int i = 0;// Set the counter
            if (arrFactorzn[x] > 0) {
                x /= arrFactorzn[x];
                i++;
            }
            // There's only two prime factors
            if (arrFactorzn[x] == 0 && i > 0) {
                semiPrimes[j] = 1;
            }
        }

        return semiPrimes;
    }

    /**
     * Factorization of a given number n into primes p 1 , p 2 , . . . , p k
     * whose product equals n.
     *
     * @param number an integer
     * @return primeFactors an array list containing the prime factors of n
     */
    public static int[] arrFactorzn(int number) {
        int[] arrFact = new int[number + 1];
        for (int j = 2; j * j <= number; j++) {
            if (arrFact[j] == 0) {
                int k = j * j;
                while (k <= number) {
                    if (arrFact[k] == 0) {
                        arrFact[k] = j;
                    }
                    k += j;
                }
            }
        }
        return arrFact;
    }

}
