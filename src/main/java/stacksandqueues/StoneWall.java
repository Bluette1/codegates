package stacksandqueues;

/**
 * Solution for the StoneWall task.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingEXXG9U-CDT
 * @since 29 August 2018
 */
public class StoneWall {

    /**
     * This will determine the minimum number of bricks needed to build the 
     * Manhattan wall.
     *
     * @param array an array specifying the heights of the wall
     * @return count the minimum number of bricks needed to build the 
     *         Manhattan wall
     */ 
    static int findNumberOfBricks(int[] array) {
        int count = 0;
        Stack oldBricks = new Stack();
        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (oldBricks.isEmpty()) {
                oldBricks.push(array[i]);
                count++;
            } else if (array[i] > oldBricks.peek()) {            
                  oldBricks.push(array[i]);
                  count++;

            } else if (array[i] < oldBricks.peek()) {
                
                while (!oldBricks.isEmpty() && array[i] < oldBricks.peek()) {
                        oldBricks.pop();
                }
                if (oldBricks.isEmpty() || array[i] > oldBricks.peek()) {
                    oldBricks.push(array[i]);
                    count++;
                }
            }
        }
        return count;
    }
}
