package divide_and_conquer_algorithms;

//Problem Statement:
//Given the weights and profits of N items
//Find the maximum profit within given capacity C.
//Items cannot be broken

//Example:
//weights[] = {3, 1, 2, 5}
//profits[] = {31, 26, 17, 72}
//capacity = 7
//Explanation: Take 5, 1 weights with profits 72, 26
//Output = 98
public class ZeroOneKnapsack {
	public static int maximumProfit(int[] weights, int[] profits, int capacity) {
		return maximumProfit(weights, profits, capacity, 0);
	}

	private static int maximumProfit(int[] weights, int[] profits, int capacity, int index) {
		if (index >= weights.length) {
			return 0;
		}
		int include = 0;
		if (weights[index] <= capacity) {
			include = profits[index] + maximumProfit(weights, profits, capacity - weights[index], index + 1);
		}
		int exclude = maximumProfit(weights, profits, capacity, index + 1);
		return Math.max(include, exclude);
	}
}
