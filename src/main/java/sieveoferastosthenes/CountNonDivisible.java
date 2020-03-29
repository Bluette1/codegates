package sieveoferastosthenes;

import java.util.Arrays;

/**
 * Solution for the CountNonDivisible task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training8QE4MR-J6R/
 * @since 9 August 2018
 */
public class CountNonDivisible {

     /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 3, 6};
        System.out.println(Arrays.toString(countNonDivisible(A)));
    }

    /**
     * Given an array A consisting of N integers. For each number A[i] 
     * such that 0 ≤ i < N, this function will count the number of elements of the array
     * that are not the divisors of A[i].
     *
     * @param array the input array 
     * @return arrNonVisible the resulting array of computed non divisors
     */
    static int[] countNonDivisible(int[] array) {
        int n = array.length;
        int[] arrayCopy = Arrays.copyOf(array, n);
        Arrays.sort(arrayCopy);
        int max = arrayCopy[n - 1];
        int[] arrNonVisible = new int[n];
        int[] counts = new int[max + 1];
        boolean[] divisors = new boolean[max + 1];
        for (int i = 0; i < n; i++) {
            counts[array[i]]++;
            divisors[array[i]] = true;
        }

        counts = findDivisors(max, counts, divisors);

        for (int i = 0; i < n; i++) {
            arrNonVisible[i] = n - counts[array[i]];
        }
        return arrNonVisible;
    }

    /**
     * Implementation for the Sieve Of Erastosthenes Algorithm which finds all
     * the prime numbers in a given range from 2...n.
     *
     * @param number an integer
     * @param counts the array with initial counts for each element
     * @param divisors the array containing flags (true | false)
     *        at each index where an element exists
     * @return counts array indicating all the divisors at each index
     */
    static int[] findDivisors(int number, int[] counts, boolean[] divisors) {

        int[] initialCounts = Arrays.copyOf(counts, counts.length);

        for (int i = 1; i <= number; i++) {
            for (int k = i + i; k <= number; k += i) {
               
                if (divisors[i] && divisors[k]) {
                    counts[k] += initialCounts[i] * 1;
                }
            }
        }
        return counts;
    }
}
