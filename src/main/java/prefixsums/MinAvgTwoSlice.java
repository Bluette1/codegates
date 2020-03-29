package prefixsums;

/**
 * Solution for the MinAvgTwoSlice task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingEMYSG4-FDF/
 * @since 28 August 2018
 */
public class MinAvgTwoSlice {

    /**
     * This will calculate the minimal average of any slice containing at least
     * two elements.
     *
     * @param array an array
     * @return index the index of the slice with the minimal average .
     */
    public static int findMinSlice(int[] array) {
        int length = array.length;
        double[] doubles = new double[length];
        double[] tripples = new double[length];
        // set the starting average to a large arbitrary value outside of the
        // range we are dealing with in this problem
        double avg = Double.POSITIVE_INFINITY;
        int index = -1;

        for (int i = 1; i < length; i++) {
            
            // The minimum average corresponds to the minimum sum.
            // Slices of bigger sizes are created from such smaller slices.
            // At the basic level, we are either adding two elements or three elements, and 
            // then dividing by two or three.
            doubles[i] = (double) (array[i] + array[i - 1]) / 2;
            if (doubles[i] < avg) {
                avg = doubles[i];
                index = i - 1;
            }
            if (i > 1) {
                tripples[i] = (double) (array[i] + array[i - 1] + array[i - 2]) / 3;
                if (tripples[i] < avg) {
                    avg = tripples[i];
                    index = i - 2;
                }
            }
        }
        return index;
    }

}
