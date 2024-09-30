package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

//Fibonacci series
public class Fibonacci {

	public static int memorization(int n) {
		Map<Integer, Integer> memo = new HashMap<>();
		return memorization(n, memo);
	}

	private static int memorization(int n, Map<Integer, Integer> memo) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		memo.put(n, memorization(n - 1, memo) + memorization(n - 2, memo));
		return memo.get(n);
	}

	public static int tabulation(int n) {
		int fibTable[] = new int[n];
		fibTable[0] = 0;
		fibTable[1] = 1;
		for (int i = 2; i < n; i++) {
			fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
		}
		return fibTable[n - 1];
	}
}
