package sieveoferastosthenes;

/**
 * The Primality class
 * 
 * @author marylene
 * @since 13 June 
 */
public class Primality {
    
    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(primality((long)(2 * Math.pow(10, 9))));
    }
    
    /**
     * This will check if the number is prime or not.
     * 
     * @param number
     * @return "Prime"|"Not Prime"
     */
    static String primality(long number) {
        if (number == 0 || number == 1) {
            return "Not prime";// 0 or 1 are neither prime nor composite
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            
            if (number % i == 0) {
                
                return "Not prime"; // break out of the loop and return the result
            }
        }
        return "Prime"; // not prime
    }
}
