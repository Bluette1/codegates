package primeandcompositenumbers;

/**
 * Solution for the MinPerimeterRectangle task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingTSRN5S-ZZU/
 * @since 9 August 2018
 */
public class MinPerimeterRectangle {

    /**
     * This will find the minimal perimeter of any rectangle with a given area.
     *
     * @param area the area
     * @return minPerimeter the minimal perimeter
     */
    static int findMinPerimeter(int area) {
        // set minimum perimeter to arbitrary value
        int minPerimeter = Integer.MAX_VALUE; 
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int perimeter = (2 * (area / i + i));
                minPerimeter = Math.min(minPerimeter, perimeter);
            }

        }
        return minPerimeter;
    }
}
