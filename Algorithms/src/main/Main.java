package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import divide_and_conquer_algorithms.ConversionOfString;
import divide_and_conquer_algorithms.HouseRobber;
import divide_and_conquer_algorithms.LongestCommonSubsequence;
import divide_and_conquer_algorithms.LongestPalindromicSubsequence;
import divide_and_conquer_algorithms.MinCostToReachLastCell;
import divide_and_conquer_algorithms.NumberFactor;
import divide_and_conquer_algorithms.NumberOfPathsToReachLastCell;
import divide_and_conquer_algorithms.ZeroOneKnapsack;
import dynamic_programming.ConversionOfStringDp;
import dynamic_programming.Fibonacci;
import dynamic_programming.HouseRobberDp;
import dynamic_programming.NumberFactorDp;
import greedy_algorithms.Activity;
import greedy_algorithms.ActivitySelection;
import greedy_algorithms.CoinChange;
import greedy_algorithms.FractionalKnapsack;
import greedy_algorithms.KnapSackItem;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("<-- Greedy Algorithms -->");
		greedyAlgorithms();
		
		System.out.println("\n<-- Divide and Conquer Algorithms -->");
		divideAndConquerAlgorithm();
		
		System.out.println("\n<-- Dynamic Programming(DP) Algorithms -->");
		dynamicProgramming();
		
	}
	
	private static void greedyAlgorithms() {
		System.out.println("\nActivity Selection Problem:");
		List<Activity> activities = new ArrayList<>();
		activities.add(new Activity("A1", 0, 6));
		activities.add(new Activity("A2", 3, 4));
		activities.add(new Activity("A3", 1, 2));
		activities.add(new Activity("A4", 5, 8));
		activities.add(new Activity("A5", 5, 7));
		activities.add(new Activity("A6", 8, 9));
		ActivitySelection.activitySelection(activities);
		
		System.out.println("\nCoin change Problem:");
		int[] coins = {1,5,2,10,50,20,1000,100};
		int amount = 2035;
		System.out.println("Coins Available "+Arrays.toString(coins));
		System.out.println("Number of coins(Output): "+CoinChange.coinChange(coins, amount));
		
		System.out.println("\nFractional Knapsack Problem:");
		int[] values = {100,120,60};
		int[] weights = {20,30,10};
		int capacity = 50;
		List<KnapSackItem> items = new ArrayList<>();
		for(int i=0;i<weights.length;i++) {
			items.add(new KnapSackItem(i, weights[i], values[i]));
		}
		System.out.println("Total value (Output): "+FractionalKnapsack.fractionalKnapsack(items, capacity));
	}
	
	private static void divideAndConquerAlgorithm() {
		System.out.println("\nNumber Factor Problem:");
		int n = 4;
		System.out.println("Number of ways(Output) to express "+n+" as sum of 1, 3, 4: "+NumberFactor.noOfways(n));
		
		System.out.println("\nHouse Robber Problem:");
		int[] houses = {6,7,1,30,8,2,4};
		System.out.println("Maximum amount (output) that can be stolen from the houses "+Arrays.toString(houses)+" is: "+HouseRobber.maximumAmount(houses));
		
		System.out.println("\nConvert one string to another Problem:");
		String s1 = "table";
		String s2 = "tbres";
		System.out.println("Minimum operations (output) needed to convert "+s2+" to "+s1+" is: "+ConversionOfString.minimumOperations(s1, s2));
		
		System.out.println("\nZero One Knapsack Problem:");
		int[] weights = {3, 1, 2, 5};
		int[] profits = {31, 26, 17, 72};
		int capacity = 7;
		System.out.println("Maximum profit (output) within a given capacity C= "+capacity+" from the weights "+Arrays.toString(weights)+" and profits "+Arrays.toString(profits)+" is: "+ZeroOneKnapsack.maximumProfit(weights, profits, capacity));
		
		System.out.println("\nLongest common Subsequence Problem:");
		String ss1 = "elephant";
		String ss2 = "erepat";
		System.out.println("Longest common Subsequence (output) among the Strings S1="+ss1+" and S2="+ss2+" is: "+LongestCommonSubsequence.longestSubsequence(ss1, ss2));
		
		System.out.println("\nLongest Palindromic Subsequence Problem:");
		String s = "elrmenmet";
		System.out.println("Longest Palindromic Subsequence (output) for the string S="+s+" is: "+LongestPalindromicSubsequence.longestPalindrome(s));
		
		System.out.println("\nMinimum cost to reach Last Cell Problem:");
		int[][] matrix = {{4, 7, 8, 6, 4}, {6, 7, 3, 9, 2}, {3, 8, 1, 2, 4}, {7, 1, 7, 3, 7}, {2, 9, 8, 9, 3}};
		System.out.println("Minimum cost to reach Last Cell (output) in the matrix "+Arrays.deepToString(matrix)+" is: "+MinCostToReachLastCell.findMinCost(matrix));
		
		System.out.println("\nNumvvv ber of ways to reach Last Cell Problem:");
		int[][] matrix2 = {{4, 7, 1, 6}, {5, 7, 3, 9}, {3, 2, 1, 2}, {7, 1, 6, 3}};
		int totalCost = 25;
		System.out.println("Number of ways to reach Last Cell (output) in the matrix "+Arrays.deepToString(matrix2)+" within the cost="+totalCost+" is: "+NumberOfPathsToReachLastCell.numberOfPaths(matrix2, totalCost));
	}
	
	private static void dynamicProgramming() {
		System.out.println("\nFibonacci Series Problem:");
		int n = 7;
		System.out.println("Fibonacci Series(Output) for n="+n+" using 'MEMORIZATION DP approach' is: "+Fibonacci.memorization(n));
		System.out.println("Fibonacci Series(Output) for n="+n+" using 'TABULATION DP approach' is: "+Fibonacci.tabulation(n));
		
		System.out.println("\nNumber Factor Problem:");
		int n1 = 5;
		System.out.println("Number of ways(Output) to express "+n+" as sum of 1, 3, 4 using 'MEMORIZATION DP approach' is: "+NumberFactorDp.memorization(n1));
		System.out.println("Number of ways(Output) to express "+n+" as sum of 1, 3, 4 using 'TABULATION DP approach' is: "+NumberFactorDp.tabulation(n1));
		
		System.out.println("\nHouse Robber Problem:");
		int[] houses = {6,7,1,30,8,2,4};
		System.out.println("Maximum amount (output) that can be stolen from the houses "+Arrays.toString(houses)+" using 'MEMORIZATION DP approach' is: "+HouseRobberDp.memorization(houses));
		System.out.println("Maximum amount (output) that can be stolen from the houses "+Arrays.toString(houses)+" using 'TABULATION DP approach' is: "+HouseRobberDp.tabulation(houses));
		
		System.out.println("\nConvert one string to another Problem:");
		String s1 = "table";
		String s2 = "tbres";
		System.out.println("Minimum operations (output) needed to convert "+s2+" to "+s1+" using 'MEMORIZATION DP approach' is: "+ConversionOfStringDp.memorization(s1, s2));
	}

}
