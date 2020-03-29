package primeandcompositenumbers;

import java.util.Arrays;

/**
 * Solution for the Flags task
 *
 * https://app.codility.com/demo/results/training2JTVYA-W9Q/
 *
 * @author marylene
 */
public class Flags {

    public static void main(String[] args) {
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(findMaxFlags(A));
    }

    static int findMaxFlags(int[] A) {
        int maxFlags = 0;
        int n = A.length;
        if (n < 3) {
            return 0;
        }

        int j = 0;
        int[] peaks = new int[n];
        for (int i = 1; i < n - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[j] = i;
                j++;
            }
        }

        System.out.println("Peaks: " + Arrays.toString(peaks));
        if (j < 2) {
            return j;
        }

        int flags = 2;
        while (true) {
            int setFlags = 1;
            int lastFlag = 0;
            for (int i = 1; i < j && setFlags < flags; i++) {
                if (Math.abs(peaks[lastFlag] - peaks[i]) >= flags) {
                    setFlags++;
                    lastFlag = i;
                }
            }
            if (maxFlags < setFlags) {
                maxFlags = setFlags;
            } else {
                break;
            }
            flags++;
        }
        return maxFlags;
    }

}
