package stacksandqueues;

/**
 * Solution for the Fish task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingS7TRXX-Y4D
 * @since 29 August 2018
 */
public class Fish {

     /**
     * This will compute the number of fish left alive along the river.
     *
     * @param size an array representing the size of the fish
     * @param direction an array representing the direction of the fish. 
     *        Fish number i is represented by size[i] and direction[i].
     * @return count the number of fish that are alive
    */
    static int countFish(int[] size, int[] direction) {
        int count = 0;
        Stack downStream = new Stack(); // create a stack to hold the downstream fish
        int length = size.length;
        for (int i = 0; i < length; i++) {
            if (direction[i] == 1) {// downstream fish
                downStream.push(size[i]);
                count++;

            }
            if (direction[i] == 0) {// upstream fish
                //wh ile upstream fish is bigger it eats up the downstream smaller fish 
                while (!downStream.isEmpty() && downStream.peek() < size[i]) {
                    downStream.pop();
                    count--;
                }
                if (downStream.isEmpty()) { // no more downstream fish, continue
                    count++;
                } else {// downstream fish is bigger, so upstream fish is eaten up
                    //don't count upstream fish
                }
            }
        }
        return count;
    }
}
