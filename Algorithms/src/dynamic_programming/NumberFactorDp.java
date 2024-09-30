package dynamic_programming;

//problem Statement:
//Given N, find the number of ways to express N as a sum of 1, 3, 4.
public class NumberFactorDp {

	public static int memorization(int n) {
		return memorization(n, new int[n + 1]);
	}

	private static int memorization(int n, int[] memo) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		if (n == 3) {
			return 2;
		}
		if (memo[n] != 0) {
			return memo[n];
		}
		int a = memorization(n - 4, memo);
		int b = memorization(n - 3, memo);
		int c = memorization(n - 1, memo);
		return memo[n] = a + b + c;
	}

	public static int tabulation(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		if (n == 3) {
			return 2;
		}
		int[] numFactorTab = new int[n + 1];
		numFactorTab[0] = 0;
		numFactorTab[1] = 1;
		numFactorTab[2] = 2;
		numFactorTab[3] = 2;
		for (int i = 4; i <= n; i++) {
			numFactorTab[i] = numFactorTab[i - 4] + numFactorTab[i - 3] + numFactorTab[i - 1];
		}
		return numFactorTab[n];
	}

}
