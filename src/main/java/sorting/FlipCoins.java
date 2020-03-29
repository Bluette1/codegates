package sorting;

import java.util.Arrays;

/**
 * Solution for the FlipCoins task. 
 * An array containing integers: 0's and 1's,
 * representing heads or tails respectively is provided. The minimum number of 
 * coins which must be flipped in order for all the faces to be the same is
 * retrieved.
 *
 * @author marylene
 * @since 20 May 2019
 */
public class FlipCoins {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {1, 0, 0, 1, 0, 0};

        System.out.println(flipCoins(array));
    }

    /**
     * An array containing integers: 0's and 1's, representing heads or tails 
     * respectively is provided.
     * The minimum number of coins which must be 
     * flipped in order for all the faces to be the same is retrieved.
     * 
     * @param array an array
     * @return headsFlipped|tailsFlipped the minimum number of coins that must 
     *         be flipped
     */
    static int flipCoins(int[] array) {

        int[] arrayCopy = array.clone();
        int length = array.length;
        Arrays.sort(arrayCopy);

        int mid;
        boolean flipHeads = false;
        
        if (length == 1) {// edge case with one element
            return 0;
        }

        if (length % 2 == 0) {
            mid = length / 2;
            if (array[mid - 1] == 1) {// tails are more
                flipHeads = true;
            }
        } else {
            mid = length / 2;
            if (array[mid] == 1 ) {// tails are more
                flipHeads = true;
            }
        }
        if (flipHeads) {
            // flip heads
            int headsFlipped = 0;
            for (int j = 0; j < length; j++) {
                if (array[j] == 0) {
                    array[j] = 1;
                    headsFlipped++;
                }
            }
            return headsFlipped;
        } else {
            // flip tails
            int tailsFlipped = 0;
            for (int j = 0; j < length; j++) {
                if (array[j] == 1) {
                    array[j] = 0;
                    tailsFlipped++;
                }
            }
            return tailsFlipped;
        }
    }
}