package prefixsums;

import java.util.Scanner;

/**
 * Solution for the CountDiv task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingGJERZF-ACX/
 * @since 9 August 2018
 */
public class CountDiv {

    /**
     * This will compute number of integers divisible by the divisor in range 
     * [first..last] 
     *
     * @param first the first number in the range
     * @param last the last number in the range
     * @param divisor the divisor
     * @return count the number of integers divisible by the divisor in that range
     */
    static int countDiv(int first, int last, int divisor) {
        int count = 0;
        if (first % divisor == 0) { //the first one is divisible by divisor
            count++; 
        } else { //the first one is not divisible by divisor
            /**
             * if first is not divisible by divisor, calculate the nearest 
             * integer that is divisible by divisor by subtracting the remainder 
             * (first % divisor) from first and then adding the divisor.
             */
            first = first - (first % divisor) + divisor;
            if (first % divisor == 0 && first < last) {
                count++;
            }
        }
        count += (last - first) / divisor; //add the rest of the factors 

        return count;
    }
    
     /**
     * The main method.
     *
     * @param args the arguments
     */
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
     
        System.out.println("Enter the value of the first number in the range "
            + "(can be an integer within the range [0..2,000,000,000]):");
        int first = input.nextInt();
     
        System.out.println("Enter the value of the last number in the range "
            + "(can be an integer within the range [0..2,000,000,000]):"); 
        int last = input.nextInt();
        
        System.out.println("Enter the value of the divisor "
            + "(can be an integer within the range [0..2,000,000,000]):"); 
        int divisor = input.nextInt();
        
        System.out.println("Factors of divisor: " + countDiv(first, last, divisor));

    }


}
