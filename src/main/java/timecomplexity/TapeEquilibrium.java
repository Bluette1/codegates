package timecomplexity;

import java.util.Scanner;

/**
 * Solution for the TapeEquilibrium task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingD8QP78-XFV/
 * @since 04 August 2018
 */
public class TapeEquilibrium {
    
    /**
     * This calculates the minimum absolute difference between any two parts of 
     * an array. This is an O(N) algorithm.
     *
     * @param array an array
     * @return minDist the minimum distance
     */
    static int findMinAbsDist(int[] A) {
        
        int length = A.length;
        int sum = 0;
        
        for (int i = 0; i < length; i++) {
            sum += A[i];
        }

        int minDist = -1;
        int currentSum = 0;
        int dist = 0;

        for (int i = 0; i < length - 1; i++) {
            currentSum += A[i];
            dist = Math.abs(currentSum - (sum - currentSum));
            if (dist < minDist || minDist < 0) {
                minDist = dist;
            }
        }

        return minDist;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items n in the array (n is an"
            + " integer within the range [2..100,000]):");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the items in the array (each element of array"
            + " should be an integer within the range [−1,000..1,000]:");
        int count = 0;
        while (count < n) {
            array[count] = input.nextInt();
            count++;
        }
        System.out.println("Minimum difference: " + findMinAbsDist(array));
    }
}
