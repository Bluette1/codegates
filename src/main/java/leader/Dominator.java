package leader;

/**
 * Solution for the Dominator task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/training79YG7F-27Q/?showingAll=1
 * @since 16 September 2018
 */
public class Dominator {

    /**
     * This will find an index of an array such that its value occurs at more
     * than half of indices in the array.
     *
     * @param array an array of integers
     * @return index the index of the dominator
     */
    static int findDominatorIndex(int[] array) {
        int length = array.length;
        if (length == 0) {// Array is empty,so there is no dominator
            return -1;
        }
        
        /**
         * Compare this to an initially empty stack onto which we will be pushing
         * consecutive elements. After each such operation we check whether the 
         * two elements at the top of the stack are different. If they are, 
         * we remove them from the stack.
         */
        int size = 0; //to Keep track of the size of the *stack
        int index = 0;
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
         * sequence containing all the same values. This value is not necessarily
         * the dominator; it is only a candidate for the dominator. we iterate
         * through all the elements and count the occurrences of the candidate; 
         * if it is greater than n/2 then we have found the dominator; otherwise 
         * the sequence does not contain a dominator.
         */
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        if (count > length / 2) {
            return index;
        }

        return -1;
    }

}
