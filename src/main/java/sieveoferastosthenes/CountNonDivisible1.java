package sieveoferastosthenes;

import java.util.Arrays;

/**
 * Alternative Solution for the CountNonDivisible task.
 * This solution does not pass all the performance tests.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training8QE4MR-J6R/
 * @since 9 August 2018
 */
public class CountNonDivisible1 {

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
     * Given an array A consisting of N integers. For each number A[i] such that
     * 0 ≤ i < N, this function will count the number of elements of the array
     * that are not the divisors of A[i].
     *
     * @param array the input array
     * @return arrNonVisible the resulting array of computed non divisors
     */
    static int[] countNonDivisible(int[] A) {
        int n = A.length;
        int[] B = Arrays.copyOf(A, n);
        Arrays.sort(B);
        int max = B[n - 1];
        int[] arrNonVisible = new int[n];
        int[] counts = new int[max + 1];
        boolean[] divisors = new boolean[max + 1];
        for (int i = 0; i < n; i++) {
            counts[A[i]]++;
            divisors[A[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 2; j * A[i] <= max; j++) {
                if (divisors[j * A[i]]) {
                    counts[j * A[i]]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            arrNonVisible[i] = n - counts[A[i]];
        }

        return arrNonVisible;
    }
}
