package iterations;

import java.util.Scanner;

/**
 * The NewtonsMethod class. This applies Newton's Method to calculate the square  
 * root of a number. This is not included in the Codility exercises but is a good 
 * example for illustrating iterations.
 *
 * @author marylene
 * @since 06 August 2018
 */
public class NewtonsMethod {
    
    /**
     * This will return the square root approximation of a given number to a
     * certain degree of accuracy.Newton's method achieves quadratic convergence
     * so the correct square root
     * value with an adequate degree of accuracy is obtained after only a few
     * iterations: in most cases < 5.
     *
     * @param number a number
     * @param squareRootx the original guess of the square root of the 
     *        given number
     * @param iterations the number of iterations that are to be done
     * @return squareRootx the square root of the number
     */
    public static double findSquareRoot(double number, double squareRootx, int iterations) {
        double fx = (squareRootx * squareRootx) - number;

        int count = 0;
        while (Math.abs(fx) > 0.000001 && count < iterations) {

            double derivFx = 2 * squareRootx;
            squareRootx = squareRootx - (fx / derivFx);

            fx = (squareRootx * squareRootx) - number;
            count++;
            System.out.println("x" + count + ": " + squareRootx);
        }
        if (count != iterations) {
            System.out.println("Convergence was achieved earlier after " + count
                + " iterations, before the specified number of iterations: "
                + iterations + ".");
        }
        return squareRootx;
    }
    /**
     * The main method.                 
     *
     * @param args the arguments 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an number whose square root you want to find:");
        double n = input.nextDouble();
        System.out.println("Enter the original guess for the square root:");
        double guess = input.nextDouble();
        System.out.println("Enter the number of iterations (advisably below 5):");
        int iterations = input.nextInt();

        System.out.println("The square root of " + n + " is: "
            + findSquareRoot(n, guess, iterations));

    }
}
