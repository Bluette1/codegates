package sieveoferastosthenes.lessons;

import java.util.ArrayList;
import java.util.List;

/**
 * Factorization of a given number n into primes p 1 , p 2 , . . . , p k whose
 * product equals n. This algorithm has O(log n) time complexity
 *
 * @author marylene
 * @see https://codility.com/media/train/9-Sieve.pdf
 * @see https://repl.it/@MaryleneSawyer/Factorization
 * @since 13 April 2019
 */
public class Factorization {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> primeFactors = factorize(17);
        for (int factor : primeFactors) {
            System.out.print(factor + " ");
        }
    }

    /**
     * Factorization of a given number n into primes p 1 , p 2 , . . . , p k
     * whose product equals n.
     *
     * @param number an integer
     * @return primeFactors an array list containing the prime factors of n
     */
    public static List<Integer> factorize(int number) {
        List<Integer> primeFactors = new ArrayList();

        int[] arrayFactorization = ArrayFactorization.arrayFactorize(number);
        int x = number;
        while (arrayFactorization[x] > 0) {
            primeFactors.add(arrayFactorization[x]);
            x = x / arrayFactorization[x];

        }
        primeFactors.add(x);
        return primeFactors;
    }
    
    /**
     * This will return a set of distinct prime divisors of n.
     *
     * @param number an integer
     * @return primeFactors an array list containing the distinct prime divisors
     *         of n
     */
    public static List<Integer> primeDivisors(int number) {
        List<Integer> primeFactors = new ArrayList();

        int[] arrayFactorization = ArrayFactorization.arrayFactorize(number);
        int x = number;
        while (arrayFactorization[x] > 0) {
            if (!primeFactors.contains(arrayFactorization[x])) {
                primeFactors.add(arrayFactorization[x]);
            }
            
            x = x / arrayFactorization[x];

        }
        if (!primeFactors.contains(x)) {
            primeFactors.add(x);
        }
        
        return primeFactors;
    }
}
