package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The CyclicRotation class. This is a solution for the CyclicRotation task.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingYRUVSF-MWW/
 * @since 12 August 2018
 */
public class CyclicRotation {
    
    /**
     * This will "rotate" a given array a specified number of times.
     *
     * @param inputArray an array
     * @param rotations number of rotations
     * @return outputArray the resulting array
     */
    public static int[] rotate(int[] inputArray, int rotations) {
        if (inputArray.length <= 1) {
            return inputArray;
        }
        for (int i = 0; i < rotations; i++) {
            int temp = inputArray[0];
            inputArray[0] = inputArray[inputArray.length - 1];

            for (int j = 1; j < inputArray.length; j++) {
                int current = inputArray[j];
                inputArray[j] = temp;
                temp = current;
            }
        }
        return inputArray;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items in the array:");
        int n = input.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the items in the array:");
        int count = 0;
        while (count < n) {
            A[count] = input.nextInt();
            count++;
        }
        System.out.println("Enter the number of rotations:");
        int rotations = input.nextInt();
        System.out.println(Arrays.toString(rotate(A, rotations)));
    }
}
