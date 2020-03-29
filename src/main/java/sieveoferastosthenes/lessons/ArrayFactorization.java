package sieveoferastosthenes.lessons;

import java.util.Arrays;

/**
 * Modification of the Sieve Of Erastosthenes to prepare a given array for
 * factorization. The resulting array has minimum prime factors at each index.
 * This has O(log log n) time complexity
 *
 * @author marylene
 * @see https://codility.com/media/train/9-Sieve.pdf
 * @see https://repl.it/@MaryleneSawyer/ArrayFactorization
 * @since 13 April 2019
 */
public class ArrayFactorization {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(Arrays.toString(arrayFactorize(20)));
    }

    /**
     * Modification of the Sieve Of Erastosthenes to prepare a given array for
     * factorization
     *
     * @param number an integer
     * @return arrayFactorization resulting preparation array
     */
    static int[] arrayFactorize(int number) {
        int[] arrayFactorization = new int[number + 1];

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (arrayFactorization[i] == 0) {
                for (int k = i * i; k <= number; k += i) {
                    if (arrayFactorization[k] == 0) {

                        arrayFactorization[k] = i;
                    }
                }
            }
        }
        return arrayFactorization;
    }
}
