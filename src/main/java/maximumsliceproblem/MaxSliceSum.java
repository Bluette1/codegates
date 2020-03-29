package maximumsliceproblem;

/**
 * Solution for the MaxSliceSum task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingM7QMBQ-C6M/
 * @since 9 August 2018
 */
public class MaxSliceSum {

    /**
     * This will find the maximum sum of a compact subsequence of array
     * elements. We assume that the slice can't be empty with sum 0.
     *
     * @param array an array of integers
     * @return maxSliceSum the the maximum slice sum
     */
    static int findMaxSliceSum(int[] array) {
        
        // This will be the assumed initial value for maxEnding and maxSliceSum 
        // because elements in array can be negative.
        int maxEnding = Integer.MIN_VALUE;
        int maxSliceSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            
            // When updating maxEnding, we don't want to add a negative maxEnding
            // to an element A[i] greater than it, we have to discard the negative 
            // maxEnding, and update maxEnding to A[i]
            if (maxEnding < 0 && maxEnding <= array[i]) {
                maxEnding = array[i];
            } else {
                
                // Calculate the new maxEnding 
                maxEnding = Math.max(Integer.MIN_VALUE, maxEnding + array[i]);
            }
            
            maxSliceSum = Math.max(maxEnding, maxSliceSum);
        }

        return maxSliceSum;
    }
}
