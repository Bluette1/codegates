package euclideanalgorithm;

/**
 * Solution for the CommonPrimeDivisors task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training3H7X2X-6KG/
 * @since 13 April 2019
 */
public class CommonPrimeDivisors {

    /**
     * The main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        System.out.println(commonPrimeDivisors(A, B));

    }

    /**
     * This will calculate the number of occurrences of common prime divisors in
     * two given arrays
     *
     * @param A array containing integers
     * @param B array containing integers
     * @return count number of occurrences of common prime divisors
     */
    public static int commonPrimeDivisors(int[] A, int[] B) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                count++;
                continue;
            }
            // calculate the gcd; the gcd contains all common distinct prime divisors
            int gcd = gcd(A[i], B[i], 1);

            //this a shortcut method for verifying all prime divisors in both  
            // numbers are shared, by using the gcd
            if (haveCommonPrimes(gcd, A[i]) && haveCommonPrimes(gcd, B[i])) {
                count++;
            }
        }
        return count;
    }

    /**
     * This will check if a given number is a common prime divisor with the gcd. 
     * 
     * @param gcd
     * @param x
     * @return true|false whether a given number is a common prime divisor with 
     *         the gcd
     */
    public static boolean haveCommonPrimes(int gcd, int x) {
        if (x == 1) {
            return true;
        }
        gcd = gcd(x, gcd, 1);
        if (gcd == 1) {
            return false;
        }

        x /= gcd;
        return haveCommonPrimes(gcd, x);
    }

    /**
     * The Binary Euclidean Algorithm for finding the greatest common factor of 
     * two numbers.
     * 
     * @param a given number
     * @param b given number
     * @param res 
     * @return the gcd
     */
    public static int gcd(int a, int b, int res) {
        if (a == b) {
            return res * a;
        } else if (a % 2 == 0 && b % 2 == 0) {
            return gcd(a / 2, b / 2, 2 * res);
        } else if (a % 2 == 0) {
            return gcd(a / 2, b, res);
        } else if (b % 2 == 0) {
            return gcd(a, b / 2, res);
        } else if (a > b) {
            return gcd(a - b, b, res);
        } else {
            return gcd(a, b - a, res);
        }
    }
}
