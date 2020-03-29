package timecomplexity;

import java.util.Scanner;

/**
 * Solution for the Frogjmp task.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training5AZMQR-KRA/
 * @since 12 August 2018
 */
public class Frogjmp {
    
    /**
     * This will calculate the minimum number of jumps needed to cover 
     * a given distance, beginning at 'start' and stopping at 'end'. This is an
     * example of an O(1) algorithm. 
     *
     * @param start the starting point
     * @param end the ending point
     * @param dist the distance covered in one jump
     * @return the minimum number of jumps needed to cover the given distance
     */
    public static int findFrogjmp(int start, int end, int dist) {

        return (int) Math.ceil((double) (end - start) / dist);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the starting point (should be in the range "
            + "[1...1000,000,000]:");
        int start = input.nextInt();
        System.out.println("Enter the ending point (ending point should be "
            + "<=  starting point");
        int end = input.nextInt();
        System.out.println("Enter the distance covered in one jump: ");
        int dist = input.nextInt();
        System.out.println(findFrogjmp(start, end, dist));
    }
}
