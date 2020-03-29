package countingelements;

import java.util.Scanner;

/**
 * Solution for the PermCheck task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingCR2YGD-S6A/
 * @since 9 August 2018
 */
public class PermCheck {
    
    /**
     * This will check if elements in a given array are a permutation i.e
     * numbers 1..n, each appearing only once.
     *
     * @param array an array
     * @return 1|0 predicate based on whether the elements in the array are a 
     *         permutation or not
     */  
    public static int permCheck(int[] array) {
        int length = array.length;
        if (length == 1 && array[0] != 1) {
            return 0;
        }

        array = binSort(array);
        int i;

        for (i = 0; i < length; i++) {
            if (array[i] != i + 1) {
                return 0;
            }
        }
        
        return 1;
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
            if (array[i] - 1 < length) {
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
        System.out.println("Enter the number of items n in the array (should be"
            + " an integer within the range [1..100,000]:");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the items in the array (should contain numbers"
            + " within the range [1..1,000,000,000]:");
        int count = 0;
        while (count < n) {
            array[count] = input.nextInt();
            count++;
        }
        System.out.println("Result: " + permCheck(array));

    }
}
