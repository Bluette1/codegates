package sorting;

import java.util.Arrays;

/**
 * Solution for the Triangle task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingR5TSZ9-KV9/
 * @since 29 August 2012
 */
public class Triangle {

    /**
     * Determine whether a triangle can be built from a given set of edges.
     *
     * @param array an array
     * @return 1|0 predicate based on whether a triangle can be built from the 
     *         given set of edges or not
     */
    static int triangle(int[] array) {
        Arrays.sort(array);
        int length = array.length;

        for (int i = 2; i < length; i++) {

            if (
                (long) array[i - 2] + (long) array[i - 1] > (long) array[i] &&
                (long) array[i - 2] + (long)  array[i] > (long) array[i - 1] &&
                (long) array[i - 1] + (long) array[i] > (long) array[i - 2]
            ) {
                return 1;
            }
        }
        
        return 0;
    }

}
