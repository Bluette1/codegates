package countingelements;

import java.util.Scanner;

/**
 * Solution for the MissingInteger task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingAEDXZZ-3ZC/
 * @since  9 August 2018
 */
public class MissingInteger {
    
    /**
     * This will return the smallest positive integer (greater than 0) that
     * does not occur in array.
     *
     * @param array an array
     * @return the smallest positive integer (greater than 0) that does not 
     *         occur in array.
     */
    public static int findMissingInteger(int[] array) {
        int length = array.length;
        array = binSort(array);
        int i;
        for (i = 0; i < length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    /**
     * This uses bin/bucket sort method to sort a given array. A default value
     * of zero will be retained at the index where the missing element should
     * be. Bucket sort is an efficient sorting algorithm for a permutation of
     * integers 1...n with O(n) running time.
     *
     * @param array an array
     * @return sortedArray the sorted array with zeros at indices of missing
     *         elements
     */
    public static int[] binSort(int[] array) {
        int length = array.length;
        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (array[i] > 0 && array[i] - 1 < length) {
                sortedArray[array[i] - 1] = array[i];
            }
        }
        return sortedArray;
    }
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of items in array (should be an "
            + "integer within the range [1..100,000]).");
        int length = input.nextInt();
        int[] array = new int[length];
        System.out.println("Enter the items in the array (each element of array "
            + "should be an integer within the range [−1,000,000..1,000,000]:");
        
        int count = 0;
        while (count < length) {
            array[count] = input.nextInt();
            count++;
        }
        System.out.println("Missing Integer: " + findMissingInteger(array));
    }
}
