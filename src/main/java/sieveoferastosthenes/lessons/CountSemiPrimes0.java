package sieveoferastosthenes.lessons;

import java.util.Arrays;

/**
 * Alternative Solution to CountSemiPrimes0. This algorithm has a bad time
 * complexity.
 *
 * @author marylene
 * @see https://codility.com/media/train/9-Sieve.pdf
 * @see https://app.codility.com/demo/results/training73UQHC-324/
 * @since 13 April 2019
 */
public class CountSemiPrimes0 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        int max = 26;

        int length = P.length;
        int[] arrayResults = new int[length];

        int[] countedPrimes = new int[max];
        countedPrimes[0] = 0;
        for (int i = 2; i < max + 1; i++) {
            if (countPrimeFactors(i) == 2) {
                countedPrimes[i - 1] = 1; // count the semiprime   
            }
        }

        int[] prefixSemiPrimes = prefixSemiPrimes(countedPrimes);

        for (int i = 0; i < length; i++) {
            arrayResults[i] = prefixSemiPrimes[Q[i]] - prefixSemiPrimes[P[i] - 1];
        }
        System.out.println(Arrays.toString(arrayResults));
    }

    /**
     * This will calculate the sums in a given slice of the array. Its main idea
     * uses "prefix sums" which are defined as the consecutive sums of the first
     * 0, 1, 2, . . . , n elements of the array.
     *
     * @param array the array
     * @return prefixSums the resulting prefix sums
     */
    public static int[] prefixSemiPrimes(int[] array) {

        int length = array.length;
        int[] prefixSums = new int[length + 1];

        for (int i = 1; i < length + 1; i++) {
            prefixSums[i] = prefixSums[i - 1] + array[i - 1];
        }
        return prefixSums;
    }

    /**
     * Calculates the number of prime factors of a given number n
     *
     * @param number an integer
     * @return countPrimes the number of prime factors of n
     */
    static int countPrimeFactors(int number) {
        int countPrimes = 0;

        int[] arrayFactorization = ArrayFactorization.arrayFactorize(number);
        int x = number;
        while (arrayFactorization[x] > 0) {
            countPrimes++;
            x = x / arrayFactorization[x];
        }

        countPrimes++;

        return countPrimes;
    }
}
