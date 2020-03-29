package maximumsliceproblem;

/**
 * Solution for the MaxProfit task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingA76D85-DMC/
 * @since 9 August 2018
 */
public class MaxProfit {

    /**
     * This will compute the maximum possible profit given an array of stock
     * prices elements.If a single share was bought on day P and sold on day Q,
     * where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q]
     * − A[P]
     *
     * @param array an array containing daily prices of a stock price over a
     * consecutive number of days.
     * @return maxProfit the the maximum profit
     */
    static int findMaxProfit(int[] array) {
        int n = array.length;

        if (n == 0) { // if array is empty, return profit zero
            return 0;
        }

        /**
         * This problem can easily be computed in O(N^2) time but we want to do
         * in a more efficient time. So we first calculate the minimum price at
         * each day, and then with that we are able to compute the max profit
         * straight away in a single loop.
         */
        int minPrice = array[0];
        int[] minPrices = new int[n];
        minPrices[0] = array[0];

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, array[i]);
            minPrices[i] = minPrice;
        }

        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, array[i] - minPrices[i]);
        }

        return maxProfit;
    }
}
