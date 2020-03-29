package primeandcompositenumbers;

/**
 * Solution for the Peaks task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingRPBMHD-78M/
 * @since 9 August 2018
 */
public class Peaks {

    /**
     * This will find the maximum number of same-sized blocks of an array, each
     * block should contain a peak: an index P such that A[P - 1] < A[P] > A[P +
     * 1].
     *
     * @param array the array
     * @return maxBlocks the maximum number of blocks that the array can be
     * divided into.
     */
    static int findMaxBlocks(int[] array) {
        int n = array.length;
        if (n < 3) {
            return 0; //zero blocks, as there are no peaks
        }

        int numOfDivisors = countFactors(n); // find the number of divisors

        // create an array to hold all the divisors
        int[] divisors = new int[numOfDivisors];
        int j = 0;

        // Add the divisors to array in ascending order
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors[j] = i; // add first divisor
                if (i != Math.sqrt(n)) {
                    // add corresponding divisor
                    divisors[numOfDivisors - 1 - j] = n / i;
                }
                j++;
            }
        }
        
        // loop through divisors array starting from the biggest to the smallest
        // divisor
        for (int i = numOfDivisors - 2; i >= 0; i--) {
            boolean validBlocks = true;// flag too indicate if a block has a peak
            for (int k = 0; k < n; k += n / divisors[i]) {
                int peaks = countPeaks(array, k, n / divisors[i]);
                if (peaks == 0) {
                    validBlocks = false; //there are no peaks hence invalid blocks
                }
            }
            if (validBlocks) {
                return divisors[i]; //this is the maximum number of blocks
            }
        }
        return 0; // there are no valid blocks
    }

    /**
     * This will obtain the number of divisors of a given number.
     *
     * @param number the number
     * @return count the number of divisors
     */
    static int countFactors(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i == Math.sqrt(number)) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    /**
     * This will obtain the number of peaks in a given block of the array.
     *
     * @param array the array
     * @param start the start index of the block
     * @param number the length of the block
     * @return peaks the number of peaks
     */
    static int countPeaks(int[] array, int start, int number) {
        int peaks = 0;
        for (int i = start; i < start + number; i++) {
            if (i > 0 && i + 1 < array.length) {
                if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                    peaks++;
                }
            }
        }

        return peaks;
    }
}
