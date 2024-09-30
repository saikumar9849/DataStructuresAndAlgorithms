package dynamic_programming;

//Problem Statement:
//Given N number of houses along the street with some amount of money.
//Adjacent houses cannot be stolen
//Find the maximum amount that can be stolen

//Example:
//Houses = {6 7 1 30 8 2 4}
//Maximum amount = 41
//Houses that are stolen: 7, 30, 4
public class HouseRobberDp {

	public static int memorization(int[] houses) {
		return memorization(houses, 0, new int[houses.length]);
	}

	private static int memorization(int[] houses, int index, int[] dp) {
		if (index >= houses.length) {
			return 0;
		}
		if (dp[index] == 0) {
			int stealCurrentHouse = houses[index] + memorization(houses, index + 2, dp);
			int skipCurrentHouse = memorization(houses, index + 1, dp);
			dp[index] = Math.max(stealCurrentHouse, skipCurrentHouse);
		}
		return dp[index];
	}

	public static int tabulation(int[] houses) {
		if (houses.length == 1) {
			return houses[0];
		}
		if (houses.length == 2) {
			return Math.max(houses[0], houses[1]);
		}
		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);
		for (int i = 2; i < houses.length; i++) {
			dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[houses.length - 1];
	}

}
