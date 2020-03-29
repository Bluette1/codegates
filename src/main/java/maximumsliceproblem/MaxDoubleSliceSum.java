package maximumsliceproblem;

/**
 * Solution for the MaxDoubleSliceSum task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingYX3PWH-CHZ/
 * @since 9 August 2018
 */
public class MaxDoubleSliceSum {
    
    /**
     * This will find the maximum sum of any double slice of an array
     *
     * @param array an array of integers
     * @return maxDoubleSliceSum the the maximum double slice sum
     * @see https://rafal.io/posts/codility-max-double-slice-sum.html
     */
    static int getMaxDoubleSliceSum(int[] array) {
        int n = array.length;
        int[] maxLeft = new int[n]; 
        int[] maxRight = new int[n];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(0, maxLeft[i - 1] + array[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(0, maxRight[i + 1] + array[i]);
        }
        int maxDoubleSliceSum = 0;

        for (int i = 1; i < n - 1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxRight[i + 1] + maxLeft[i - 1]);
        }

        return maxDoubleSliceSum;
    }

}
