package timecomplexity;

import java.util.Scanner;

/**
 * The PermMissingElem class. This is a solution for the PermMissingElement
 * task.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingPSEGQE-55C/
 * @since 04 August 2018
 */
public class PermMissingElem {
    
    /**
     * This will return the missing element in a array of length n containing
     * a permutation of numbers 1..n + 1.
     *
     * @param array an array
     * @return the missing element
     */
    public static int findMissingElement(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 1;
        }

        array = binSort(array);

        int i;

        for (i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }

    /**
     * This uses bin/bucket sort method to sort a given array. A default value
     * of zero will be retained at the index where the missing element should
     * be. Bucket is an efficient sorting algorithm for a permutation of 
     * integers 1...n with O(n) running time.
     *
     * @param array an array
     * @return the sorted array with zero at index of missing element
     */
    public static int[] binSort(int[] array) {

        int length = array.length;
        int[] sortedArray = new int[length + 1];

        for (int i = 0; i < length; i++) {
            sortedArray[array[i] - 1] = array[i];
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
        System.out.println("Enter the number of items n in the array (should be "
            + "one less than the number of items 1...n + 1):");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the items in the array (should contain numbers"
            + " 1...n + 1 with one missing element:");
        int count = 0;
        while (count < n) {
            array[count] = input.nextInt();
            count++;
        }
        System.out.println("Missing element is: " + findMissingElement(array));
    }
}
