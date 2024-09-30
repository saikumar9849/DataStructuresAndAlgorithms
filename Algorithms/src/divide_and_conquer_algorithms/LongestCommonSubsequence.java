package divide_and_conquer_algorithms;

//Problem Statement:
//S1 and S2 are given strings
//Find the length of the longest subsequence which is common to both strings
//Subsequence: a sequence that can be driven from another sequence by deleting some elements without changing the order

//Example:
//s1 = "elephant"
//s2 = "erepat"
//Explanation: Longest String: "eepat"
//Output = 5
public class LongestCommonSubsequence {

	public static int longestSubsequence(String s1, String s2) {
		return longestSubsequence(s1, s2, 0, 0);
	}

	private static int longestSubsequence(String s1, String s2, int index1, int index2) {
		if (index1 >= s1.length() || index2 >= s2.length()) {
			return 0;
		}
		int same = 0;
		if (s1.charAt(index1) == s2.charAt(index2)) {
			same = 1 + longestSubsequence(s1, s2, index1 + 1, index2 + 1);
		}
		int parseS1 = longestSubsequence(s1, s2, index1 + 1, index2);
		int parseS2 = longestSubsequence(s1, s2, index1, index2 + 1);
		return Math.max(same, Math.max(parseS1, parseS2));
	}

}
