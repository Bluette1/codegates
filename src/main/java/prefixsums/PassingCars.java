package prefixsums;

import java.util.Scanner;

/**
 * Solution for the PassingCars task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training7Q6N99-5EW/
 * @since 12 August 2018
 */
public class PassingCars {

    public static final int LIMIT = 1000000000;
    
    
    /**
     * This will count the number of pairs of passing cars on the road.
     *
     * @param array an array whose elements represent consecutive cars on a road.
     * @return count the number of pairs of passing cars on the road
     */
    static int countPassingCars(int[] array) {
        int count = 0;

        int[] prefixSums = prefixSums(array);

        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == 0) {
                count += prefixSums[length] - prefixSums[i];
                if (count > LIMIT) {
                    return count;
                }
            }
        }

        return count;
    }
    
    /**
     * This will calculate the sums in a given slice of the 
     * array. Its main idea uses "prefix sums" which
     * are defined as the consecutive sums of the first 0, 1, 2, . . . , n 
     * elements of the array.
     *
     * @param array the array
     * @return prefixSums the resulting prefix sums
     */
    public static int[] prefixSums(int[] array) {

        int length = array.length;
        int[] prefixSums = new int[length + 1];

        for (int i = 1; i < length + 1; i++) {
            prefixSums[i] = prefixSums[i - 1] + array[i - 1];
        }
        return prefixSums;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
     
        System.out.println("Enter the number of items in array (can be within "
            + "the range [1..100,000]):");
        int length = input.nextInt();
        int[] array = new int[length];
        System.out.println("Enter the items in the array (each element can have "
            + "one of the following values: 0, 1):");
        
        int count = 0;
        while (count < length) {
            array[count] = input.nextInt();
            count++;
        }
        System.out.println("Number of passing cars :" + countPassingCars(array));
    }
}
