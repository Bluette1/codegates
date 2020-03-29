package sieveoferastosthenes.lessons;

import java.util.Arrays;

/**
 * Implementation for the Sieve Of Erastosthenes Algorithm which finds all the 
 * prime numbers in a given range from 2...n.
 * This has O(log log n) time complexity
 * 
 * @author marylene
 * @see https://codility.com/media/train/9-Sieve.pdf
 * @see https://repl.it/@MaryleneSawyer/FindPrimeNumbers
 * @since 13 April 2019
 */
public class FindPrimeNumbers {
        /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findPrimeNumbers(17)));
    }

    /**
     * Implementation for the Sieve Of Erastosthenes Algorithm which finds all the 
     * prime numbers in a given range from 2...n.
     *
     * @param number an integer
     * @return resultArray array indicating all prime numbers in the range 2...n
     */
    static boolean[] findPrimeNumbers(int number) {
        boolean [] resultArray = new boolean[number + 1];
        
        // 0 and 1 are neither composite nor prime
        resultArray[0] = resultArray[1] = true;
        
        for (int i = 2; i <= Math.sqrt(number); i++) 
            if (!resultArray[i]) {
                for (int k = i * i; k <= number; k += i ) {
                    resultArray[k] = true;// this is composite
                }
            }                                                       
        return resultArray;
        }
}
