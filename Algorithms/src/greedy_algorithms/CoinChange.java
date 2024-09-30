package greedy_algorithms;

import java.util.Arrays;

//Problem Statement:
//Your are given coins of different denominations and total amount of money.
//find the minimum number of coins that we need to make up the given amount.

//Example:
//Infinite supply of denominations[] = {1,5,2,10,50,20,1000,100}
//Total amount = 2035
//Explanation: Take 1000, 1000, 20, 10, 5
//Output = 5

//Algorithm:
//Find the biggest coin that is less than given total number
//Add coin to the result and subtract coin from total number
//If v is equal to zero: then print result. else: repeat step 2 and 3
public class CoinChange {

	// TC -> O(NlogN)
	// SC -> O(1)
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int noOfCoins = 0;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] <= amount) {
				int count = (int) Math.floor(amount / coins[i]);
				noOfCoins += count;
				amount -= count * coins[i];
				System.out.println("Coin value: " + coins[i] + " taken count: " + count);
			}
			if (amount == 0) {
				break;
			}
		}
		return noOfCoins;
	}

}
