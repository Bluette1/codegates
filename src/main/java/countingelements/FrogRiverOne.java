package countingelements;

import java.util.Scanner;

/**
 * Solution for the FrogRiverOne task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingH4HJ2F-8TX/
 * @since 9 August 2018
 */
public class FrogRiverOne {
    
    /**
     * This will find the earliest time in seconds when the frog can jump to the 
     * other side of the river.
     *
     * @param position the position across the river that needs to be covered by
     *        leaves.
     * @param array an array
     * @return time the earliest time in seconds when the frog can jump to the 
     *         other side of the river.
     */
    public static int findEarliestTime(int position, int[] array) {
        int length = array.length;
        if (length == 1) {
            if (array[0] != 1 || position != 1)
            return -1;
        }

        int[][] resultArray = binSort(array);
        int time = resultArray[0][0];
        array = resultArray[1];
        
        int i;
        for (i = 0; i < position; i++) {
            if (array[i] != i + 1) {
                return -1;
            }
        }
        return time;
    }

    /**
     * This uses bin/bucket sort method to sort a given array. A default value
     * of zero will be retained at the index where the missing element should
     * be. Bucket sort is an efficient sorting algorithm for a permutation of
     * integers 1...n with O(n) running time.
     *
     * @param array an array
     * @return resultArray result with the index at which binSort completes and
     *         sorted array with zeros at indices of missing elements;
     */
    public static int[][] binSort(int[] array) {
        int length = array.length;
        int[] sortedArray = new int[length];
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (array[i] - 1 < length && sortedArray[array[i] - 1] == 0) {
                sortedArray[array[i] - 1] = array[i];
                index = i;
            }
        }

        int[][] resultArray = {{index}, sortedArray};
        return resultArray;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the position across the river that needs to be"
            + " covered by leaves:");
        int position = input.nextInt();
        System.out.println("Enter the number of items in array.");
        int length = input.nextInt();
        int[] array = new int[length];
        System.out.println("Enter the items in the array (each element of "
            + "array should be an integer within the range [1..position]:");
        
        int count = 0;
        while (count < length) {
            array[count] = input.nextInt();
            count++;
        }
        
        System.out.println(findEarliestTime(position, array));
    }
}
