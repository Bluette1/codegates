package euclideanalgorithm;
/**
 * Solution for the ChocolatesByNumbers task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingSRCNQD-5VN/
 * @since 9 August 2017
 */
public class ChocolatesByNumbers {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.out.println("count: " + countChocolates(10, 4));

    }
    
    /**
     * This will retrieve the number of chocolates you will eat. 
     * The trick used is to write out in a trace table the values of each of the
     * parameters N, M, X, GCD and number of chocolates eaten at each stage and
     * then try to figure out a relationship.
     * 
     * @param N the number of chocolates arranged in a circle numbered 0 - N - 1
     * @param M the number of chocolates to skip plus one before eating next one 
     * @return the number of chocolates that will be eaten
     */
    
    public static int countChocolates(int N, int M) {
        return N / gcd(N, M);
    }
    
    /**
     * This will find the greatest common divisor of any two given numbers by
     * dividing.
     * The time complexity is O(log(a + b)).
     * 
     * @param N the first number
     * @param M the second number
     * @return the greatest common divisor
     */

    public static int gcd(int N, int M) {
        if (N % M == 0) {
            return M;
        }
        return gcd(M, N % M);

    }
}
