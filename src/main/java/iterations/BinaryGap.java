package iterations;

import java.util.Scanner;

/**
 * The BinaryGap class. This is a solution for the BinaryGap task.
 * 
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingBT2RYK-CYQ/
 * @since 04 August 2018
 */
public class BinaryGap {
    
    /**
     * This will return the a binary string representation of a given decimal
     * number. This is a recursive method; the initial arguments passed are the decimal
     * to be converted and an empty string.
     *
     * @param decimal a decimal number
     * @param binaryStr  a string
     * @return binaryStr binary string representation of the decimal
     *         number.
     */
    public static String binaryConvert(int decimal, String binaryStr) {
        if (decimal == 0) {
            return binaryStr;
        } else {
            return binaryConvert(decimal / 2, decimal % 2 + binaryStr);
        }
    }

    /**
     * This will return the maximum binary gap in a given binary number.
     *
     * @param binaryStr a String representation of a binary number
     * @return maxGap the maximum binary gap in the binary number
     */
    public static int maxBinaryGap(String binaryStr) {
        int maxGap = 0;
        int count = 0;

        for (int i = 1; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '0') {
                count++;
            } else {
                if (maxGap < count) {
                    maxGap = count;
                }
                count = 0;
            }
        }
        return maxGap;
    }

    /**
     * The main method.                 
     *
     * @param args the arguments 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal integer to convert to binary:");
        int n = input.nextInt();

        System.out.println("The longest binary gap in " + n + " is of length " + maxBinaryGap(binaryConvert(n, "")));

    }
}
