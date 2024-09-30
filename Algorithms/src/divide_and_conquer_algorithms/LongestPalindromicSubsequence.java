package divide_and_conquer_algorithms;

//Problem Statement:
//S is a given string
//Find the longest palindromic subsequence
//Subsequence: a sequence that can be driven from another sequence by deleting some elements without changing the order
//palindrome is a string that reads the same backward as well as forward

//Example:
//s = "elrmenmet"
//Explanation: Longest String: "ememe"
//Output = 5
public class LongestPalindromicSubsequence {
	public static int longestPalindrome(String s) {
		return longestPalindrome(s, 0, s.length() - 1);
	}

	private static int longestPalindrome(String s, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		}
		if (startIndex == endIndex) {
			return 1;
		}
		int equal = 0;
		if (s.charAt(startIndex) == s.charAt(endIndex)) {
			equal = 2 + longestPalindrome(s, startIndex + 1, endIndex - 1);
		}
		int parseFromStart = longestPalindrome(s, startIndex + 1, endIndex);
		int parseFromEnd = longestPalindrome(s, startIndex, endIndex - 1);
		return Math.max(equal, Math.max(parseFromStart, parseFromEnd));
	}
}
