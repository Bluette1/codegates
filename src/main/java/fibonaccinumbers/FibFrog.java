package fibonaccinumbers;

/** 
 * Solution for the FibFrog task
 * 
 * @see https://app.codility.com/trainingRWRN2X-VSC
 * 
 * @author marylene
 */
public class FibFrog {
	public static void main(String[] args) {
		int[] A = {1, 1, 1};
//		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
//		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		System.out.println(fibFrog(A));
	}

//		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
	public static int fibFrog(int[] A) {
//		int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		int count = 0;
		int n = A.length;
		System.out.println("n:::::::: " + n);
		int dist = 0;
		int K = 0;
		for(int i = 0; i <= n; i++) {
			K++;
			System.out.println("K:::::::: " + K);
			if ((i < n && A[i] == 1 && i + 1 < n && A[i + 1] == 0 && fibonacci(K)) || (i == n) && fibonacci(K)) {
				System.out.println("K: " + K);
				count++;
				dist += K;
				System.out.println("dist: " + dist);
				K = 0;
			}
		}
		if (dist == n + 1) 
			return count;
		return -1;
	}

//	public static int[] fibonacciDynamic(int n) {
//		int[] fib = new int[n + 1];
//		fib[1] = 1;
//		for(int i = 2; i < n + 1; i++) {
//			int k = fib[i - 1] + fib[i - 2];
//			if (k - 1 >= n + 1)
//				break;
//			else 
//				fib[i] = k;
//			System.out.println("fib" + Arrays.toString(fib));
//
//		}
//		return fib;
//	}
	
	public static boolean fibonacci(int n) {
            int fib = 0;
            int k = 0;
            while (fib < n) {
                    fib = (int) ((Math.pow((1 + Math.sqrt(5))/2, k) - Math.pow((1 - Math.sqrt(5))/2, k)) / Math.sqrt(5));
                    if (fib == n) 
                            return true;
                    k++;
            }
            return false;
	}
}
