package primeandcompositenumbers;

/**
 * Solution for the CountFactors task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingWKRVQY-KQH/
 * @since 28 August 2018
 */
public class CountFactors {

    /**
     * This will count factors of a given number.
     *
     * @param number a number
     * @return count the number of factors
     */
    static int countFactors(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i == Math.sqrt(number)) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
