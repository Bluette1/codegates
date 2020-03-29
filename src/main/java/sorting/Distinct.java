package sorting;

/**
 * Solution for the Distinct task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingEKPCVG-5WR/
 * @since 28 August 2018
 */
public class Distinct {

    /**
     * This will compute the number of distinct values in an array.
     *
     * @param array an array
     * @return the number of distinct values in an array
     */
    public static int findDistinct(int[] array) {
        int length = array.length;
        
        int[] arrNegatives = new int[length];
        int[] arrPositives = new int[length];
        int j = 0; // for keeping track of the number of the negative numbers
        int k = 0; // for keeping track of the number of positive numbers
        
        // This value will help us to keep within the correct range of the 
        // numbers when we apply the bin sort. We initially set it to a large  
        // arbitrary value outside of the range we are dealing with in this task
        int max = Integer.MIN_VALUE;
        
        int countZero = 0; //for counting zero if there is a zero
        
        for (int i = 0; i < length; i++) {
            if (Math.abs(array[i]) > max) {
                max = Math.abs(array[i]);
            }
            if (array[i] < 0) { // this is a negative number
                arrNegatives[j] = Math.abs(array[i]);;
                j++;

            } else if (array[i] > 0) { // this is a positive number
                arrPositives[k] = array[i];
                k++;
            } else if (countZero == 0) { // this is a zero, count it only once
                countZero++; 
            }

        }
        
        int countNegative = 0; // count for distinct negative numbers
        int countPositive = 0; // count for distinct positive numbers
        if (j > 0) { // if there are negative numbers
            if (j > max) { // max is within the range 0- arrNegatives.length - 1
                countNegative = binSortCount(arrNegatives, j, j);
            } else { // max does not lie within the range 0- arrNegatives.length - 1
                countNegative = binSortCount(arrNegatives, j, max);
            }
        }
        if (k > 0) { // if there are positive numbers
            if (k > max) { // max is within the range 0- arrPositives.length - 1
                countPositive = binSortCount(arrPositives, k, k);
            } else { // max does not lie within the range 0- arrPositives.length - 1
                countPositive = binSortCount(arrPositives, k, max);
            }
        }
        return countNegative + countPositive + countZero;
    }

    /**
     * This uses bin/bucket sort method to sort and count the distinct elements 
     * in a  given array. A default value of zero will be retained at the index where the missing element should
     * be. Bucket sort is an efficient sorting algorithm for a permutation of 
     * integers 1...n with O(n) running time. 
     *
     * @param array an array
     * @param length length of numbers to be sorted
     * @param boundary the boundary within which the elements of the array lie
     * @return count the number of distinct elements in the array
     */
    public static int binSortCount(int[] array, int length, int boundary) {
        int[] arrSorted = new int[boundary];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != 0 && arrSorted[array[i] - 1] == 0) {
                arrSorted[array[i] - 1] = array[i];
                count++;
            }
        }

        return count;
    }
}
