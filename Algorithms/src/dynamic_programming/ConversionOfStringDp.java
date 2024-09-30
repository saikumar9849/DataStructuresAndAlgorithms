package dynamic_programming;

import java.util.Arrays;

//Problem Statement:
//S1 and S2 are given Strings
//Convert s2 to s1 using delete, insert or replace operations
//Find the minimum count of edit operations

//Example:
//s1 = "table"
//s2 = "tbres"
//Explanation: Insert "a" to second position, replace "r" with "l" and delete "s";
//Output = 3
public class ConversionOfStringDp {

	public static int memorization(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		return memorization(s1, s2, 0, 0, dp);
	}

	private static int memorization(String s1, String s2, int index1, int index2, int[][] dp) {
		if (index1 == s1.length()) {
			return s2.length() - index2;
		}
		if (index2 == s2.length()) {
			return s1.length() - index1;
		}
		if (dp[index1][index2] != -1) {
			return dp[index1][index2];
		}
		if (s1.charAt(index1) == s2.charAt(index2)) {
			return dp[index1][index2] = memorization(s1, s2, index1 + 1, index2 + 1, dp);
		}
		int insertOp = 1 + memorization(s1, s2, index1 + 1, index2, dp);
		int replaceOp = 1 + memorization(s1, s2, index1 + 1, index2 + 1, dp);
		int deleteOp = 1 + memorization(s1, s2, index1, index2 + 1, dp);
		return dp[index1][index2] = Math.min(replaceOp, Math.min(insertOp, deleteOp));
	}

}
