package countingelements;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for the MaxCounters task
 * 
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingM9JEFG-72H/
 * @since 12 August 2018
 */
public class MaxCounters {

    /**
     * This will calculate the values of counters after applying all alternating
     * operations: increase counter by 1; set value of all counters to current 
     * maximum.
     *
     * @param numOfCounters the number of counters
     * @param ops the array of operations to be carried out 
     * @return counters the array of counters
     */
    static int[] maxCounters(int numOfCounters, int[] ops) {
        int length = ops.length;
        int[] counters = new int[numOfCounters]; //Counters are all initially set to zero

        boolean allMaxOps = true;
        for (int i = 0; i < length; i++) {
            if (ops[i] <= numOfCounters) {
                allMaxOps = false;
            }
        }
        if (allMaxOps) {
            return counters; //All operations are max operations
        }

        int maxCount = 0; // for keeping track of max count
        boolean maxOp = false; //check if max opration was done
        int lastMaxCount = 0; //for keeping track of the last max count

        for (int i = 0; i < length; i++) {
            if (ops[i] <= numOfCounters) { // this is an increase operation
                if (counters[ops[i] - 1] == 0 && maxOp) {// update to last maxcount
                    counters[ops[i] - 1] += lastMaxCount;
                }
                counters[ops[i] - 1] += 1; // increase counter by one

                if (maxCount < counters[ops[i] - 1]) {//update maxcount
                    maxCount = counters[ops[i] - 1];
                }

            } else { // this is a max operation
                counters = new int[numOfCounters];
                if (!maxOp) {
                    maxOp = true;
                }
                lastMaxCount = maxCount; //update last maxCount
            }
        }

        if (maxOp) {// max op was done, update counters with 0 to last maxCount 
            for (int i = 0; i < numOfCounters; i++) {
                if (counters[i] == 0) {
                    counters[i] = lastMaxCount;
                }
            }
        }

        return counters;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the the number of counters N (should be an "
            + "integer within the range [1..100,000]).");
        int numOfCounters = input.nextInt();
        
        System.out.println("Enter the number of items in operations array (should be an "
            + "integer within the range [1..100,000]).");
        int length = input.nextInt();
        int[] ops = new int[length];
        System.out.println("Enter the items in the array (each element of array "
            + "should be an integer within the range [1..N + 1]:");
        
        int count = 0;
        while (count < length) {
            ops[count] = input.nextInt();
            count++;
        }
        System.out.println(Arrays.toString(maxCounters(numOfCounters, ops)));
    }
}
