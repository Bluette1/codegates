package sorting;

import java.util.Arrays;

/**
 * Solution for the MaxProductOfThree task
 * 
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingAAMSK5-N9M/
 * @since 28 August 2018
 */
public class MaxProductOfThree {
    
    /**
     * This will find the max product A[P] * A[Q] * A[R] for any triplet 
     * (P, Q, R), 0 ≤ P < Q < R < N (N being the length of the array).
     *
     * @param array an array
     * @return the maximum product of any three elements of the array
     */
    public static int findMaxProductOfThree(int[] array) {
        int length = array.length;

        if (length == 3) {// minimal case, just return the product
            return array[0] * array[1] * array[2];
        }
        int j = 0; // for keeping track of the number of the negative numbers
        int k = 0; // for keeping track of the number of the positive numbers
        int countZero = 0; // for counting zero if there is a zero
        
        // loop through array to count negatives, positives and zero
        for (int i = 0; i < length; i++) { 
            if (array[i] < 0) {
                j++;

            } else if (array[i] > 0) {
                k++;
            } else if (countZero == 0) {
                countZero++;
            }

        }
        // Create two arrays for one for negatives, the other for positives
        int[] negatives = new int[j];
        int[] positives = new int[k];
        j = 0;
        k = 0;
 
        //loop through again to fill the two arrays negatives and positives
        for (int i = 0; i < length; i++) { 

            if (array[i] < 0) { // this is a negative number
                negatives[j] = Math.abs(array[i]);;
                j++;

            } else if (array[i] > 0) { // this is a positive number
                positives[k] = array[i];
                k++;
            }

        }
        Arrays.sort(negatives, 0, j); // sort the negatives
        Arrays.sort(positives, 0, k); // sort the positives
   
        if (j < 2) { // zero or one negative number
            return positives[k - 3] * positives[k - 2] * positives[k - 1];
        }

        if (k == 0) { // there are no positive numbers
            if (countZero > 0) { // if there is a zero
                return 0;
            }
            return -1 * negatives[0] * negatives[1] * negatives[2];
        } else if (k == 1) {// there is only one positive number
            return positives[0] * negatives[j - 1] * negatives[j - 2];
        } else if (k == 2) { // there are two positive numbers
            return positives[1] * negatives[j - 1] * negatives[j - 2];
        } else {
            //check which product is greater, the first two negatives and the last
            // positive or the last three positives
            if (negatives[j - 1] * negatives[j - 2] * positives[k - 1] > positives[k - 1] * positives[k - 2] * positives[k - 3]) {
                return negatives[j - 1] * negatives[j - 2] * positives[k - 1];
            }
            return positives[k - 3] * positives[k - 2] * positives[k - 1];
        }
    }
}
