import java.util.Arrays;

/** 
 * Solution for the Ladder task
 * 
 * @see https://app.codility.com/demo/results/trainingVYZY83-JDE/
 * 
 * @author marylene
 */
public class Ladder {
	public static void main(String[] args) {
		int[] A = {4, 4, 5, 5, 1};
		int[] B = {3, 2, 4, 3, 1};
		System.out.println(Arrays.toString(getSteps(A, B)));
	}

	public static int[] getSteps(int[] A, int[] B) {
		int n = A.length;
		int[] steps = new int[n];
		int max = 0;
		int maxB = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, A[i]);
			maxB = Math.max(maxB, B[i]);
		}
		
		int[] fib = fibonacciDynamic(max + 1, maxB);
		System.out.println(Arrays.toString(fib));
		for(int i = 0; i < n; i++) {
			steps[i] = fib[A[i] + 1] & ((1 << B[i]) - 1);
		}
		return steps;
	}
	public static int[] fibonacciDynamic(int n, int max) {
		int[] fib = new int[n + 1];
		fib[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) & ((1 << max) - 1);
			System.out.println("fib[i]: " + fib[i]);
		}
		return fib;
	}
}
