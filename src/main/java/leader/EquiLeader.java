package leader;

/**
 * Solution for the EquiLeader task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingB8XHRP-WSF/
 * @since 16 September 2018
 */
public class EquiLeader {

    static int countEquiLeaders(int[] A) {
        int n = A.length;

        int equileaders = 0; // Initialise the number of equileders to zero

        // there can only be one leader in the array, we find its index and count
        int[] arrDominator = findDominator(A);
        int index = arrDominator[0];
        if (index < 0) {
            return 0; //there is no leader / dominator, hence no equileaders
        }
        
        int count = arrDominator[1];
        int leader = A[index];
        
        // Create a variable counter to hold the number of occurrences of the 
        // leader in first section of the array
        int counter = 0; 
        
        // Here we iterate through the array to count the number of equileaders
        for (int i = 0; i < n; i++) {
            if (A[i] == leader) {
                counter++; // increase counter
            }
            
            // We check that the leader is a leader in both sections of the array
            if ((counter > (i + 1) / 2) && ((count - counter) > (n - (i + 1)) / 2)) {
                equileaders++; //this implies there's an equileader so we add it
            }
        }
        return equileaders;
    }

    /**
     * This will find an index of an array such that its value occurs at more
     * than half of indices in the array.
     *
     * @param array an array of integers
     * @return arrDominator the result array containing the index of the
     * dominator and the number of times it occurs in the array
     */
    static int[] findDominator(int[] array) {
        int[] arrDominator = new int[2];
        int count = 0;
        int index = 0;
        int length = array.length;
        if (length == 0) {// Array is empty,so there is no dominator
            index = -1;
            arrDominator[0] = index;
            arrDominator[1] = count;
            return arrDominator;
        }

        /**
         * Compare this to an initially empty stack onto which we will be
         * pushing consecutive elements. After each such operation we check
         * whether the two elements at the top of the stack are different. If
         * they are, we remove them from the stack.
         */
        int size = 0; //to Keep track of the size of the *stack

        int value = array[0]; // to keep track of the value of the element
        for (int i = 0; i < length; i++) {
            if (size == 0) {
                size++;
                value = array[i];
                index = i;
            } else {
                if (array[i] != value) {
                    size--;
                } else {
                    size++;
                }
            }
        }
        /**
         * After removing all pairs of different elements, we end up with a
         * sequence containing all the same values. This value is not
         * necessarily the dominator; it is only a candidate for the dominator.
         * we iterate through all the elements and count the occurrences of the
         * candidate; if it is greater than n/2 then we have found the
         * dominator; otherwise the sequence does not contain a dominator.
         */

        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                count++;
            }
        }

        if (count < length / 2) {
            index = -1;
        }

        arrDominator[0] = index;
        arrDominator[1] = count;
        return arrDominator;
    }
}
