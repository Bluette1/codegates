package euclideanalgorithm;

import sieveoferastosthenes.lessons.Factorization;

/**
 * Solution for the CommonPrimeDivisors task.This is a longer way of doing it; 
 * it fails the performance tests.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingATTPTA-TNW/
 * @see https://codility.com/media/train/9-Sieve.pdf
 * @see https://repl.it/@MaryleneSawyer/Factorization
 * @since 13 April 2019
 */
public class CommonPrimeDivisors1 {
    public static void main(String[] args) {

        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};

        System.out.println(commonPrimeDivisors1(A, B));

    }

    /**
     * This will calculate the number of occurrences of common prime divisors in
     * two given arrays
     *
     * @param A array containing integers
     * @param B array containing integers
     * @return count number of occurrences of common prime divisors
     */
    public static int commonPrimeDivisors1(int[] A, int[] B) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                count++;
                continue;
            }
            
            if (Factorization.primeDivisors(A[i]).equals(Factorization.primeDivisors(B[i]))) {
                count++;
            }
        }
        return count;
    }
}
