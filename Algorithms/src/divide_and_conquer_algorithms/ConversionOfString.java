package divide_and_conquer_algorithms;

//Problem Statement:
//S1 and S2 are given Strings
//Convert s2 to s1 using delete, insert or replace operations
//Find the minimum count of edit operations

//Example:
//s1 = "table"
//s2 = "tbres"
//Explanation: Insert "a" to second position, replace "r" with "l" and delete "s";
//Output = 3
public class ConversionOfString {
	public static int minimumOperations(String s1, String s2) {
		return minimumOperations(s1, s2, 0, 0);
	}

	private static int minimumOperations(String s1, String s2, int index1, int index2) {
		if (index1 == s1.length()) {
			return s2.length() - index2;
		}
		if (index2 == s2.length()) {
			return s1.length() - index1;
		}
		if (s1.charAt(index1) == s2.charAt(index2)) {
			return minimumOperations(s1, s2, index1 + 1, index2 + 1);
		}
		int deleteOp = 1 + minimumOperations(s1, s2, index1, index2 + 1);
		int insertOp = 1 + minimumOperations(s1, s2, index1 + 1, index2);
		int replaceOp = 1 + minimumOperations(s1, s2, index1 + 1, index2 + 1);
		return Math.min(replaceOp, Math.min(insertOp, deleteOp));
	}
}
