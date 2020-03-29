package euclideanalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * The ChocolatesByNumbers1 class.
 * Contains alternative methods to the one in ChocolatesByN, but with inferior
 * time complexity for very big numbers. Worst time exceeds log N for very big
 * numbers.
 * 
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingDM38VB-UZQ/
 * @since 20 June 2019
 * 
 * 
 */
public class ChocolatesByNumbers1 {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("chocolatesByNumbers solution: "
            + chocolatesByNumbers(10, 4));
        System.out.println("recursiveChocolatesByNumbers solution: "
            + recursiveChocolatesByNumbers(10, 4, 0, 1));
        
//        System.out.println("chocolatesByNumbers solution: " 
//            + chocolatesByNumbers(1000000000, 1));
//        System.out.println("recursiveChocolatesByNumbers solution: "
//            + recursiveChocolatesByNumbers(1000000000, 1, 0, 1));

    }

    /**
     * This calculates the number of chocolates eaten using iteration.
     * 
     * @param N the number of chocolates arranged in a circle numbered 0 - N - 1
     * @param M the number of chocolates to skip plus one before eating next one 
     * @return the number of chocolates that will be eaten
     */
    public static int chocolatesByNumbers(int N, int M) {

        List<Integer> chocolateNumbersList = new ArrayList();

        int X = 0;
        int numberOfChocolates = 0;

        do {
            chocolateNumbersList.add(X);
            numberOfChocolates++;
            X = (X + M) % N;

        } while (X != 0);

        System.out.println(chocolateNumbersList);
        return numberOfChocolates;
    }
    
      /**
     * This calculates the number of chocolates eaten using iteration.
     * 
     * @param N the number of chocolates arranged in a circle numbered 0 - N - 1
     * @param M the number of chocolates to skip plus one before eating next one 
     * @param X the number of chocolate at the start - initially 0
     * @param n the number of chocolates that will have been eaten
     * 
     * @return the number of chocolates that will be eaten
     */
    public static int recursiveChocolatesByNumbers(int N, int M, int X, int n) {

        if ((X + M) % N == 0) {
            return n;
        }
        
        return recursiveChocolatesByNumbers (N, M, (X + M) % N, n + 1);
    } 
}
