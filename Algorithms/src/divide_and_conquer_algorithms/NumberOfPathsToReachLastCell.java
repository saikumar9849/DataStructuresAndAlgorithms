package divide_and_conquer_algorithms;

//Problem Statement:
//2D Matrix is given
//Each cell has a cost associated with it for accessing
//we need to start from (0,0) cell and go till (n-1, n-1) cell
//we can go only to right or down cell from current cell
//we are given total cost to reach the last cell
//Find the number of ways to reach end of matrix with given "total cost"

//Example:
//matrix = {{4, 7, 1, 6}, {5, 7, 3, 9}, {3, 2, 1, 2}, {7, 1, 6, 3}}
//total cost = 25
//Output = 2
public class NumberOfPathsToReachLastCell {
//	private static int ans;
	public static int numberOfPaths(int[][] matrix, int totalCost) {
//		ans = 0;
//		numberOfPaths(matrix, totalCost, 0, 0);
//		return ans;
		return numberOfpaths(matrix, totalCost, 0, 0);
		// we can use both first and second approaches
	}

	// 1st way
	private static int numberOfpaths(int[][] matrix, int cost, int i, int j) {
		if (cost < 0 || i >= matrix.length || j >= matrix.length) {
			return 0;
		}
		if (i == matrix.length - 1 && j == matrix.length - 1) {
			return cost - matrix[i][j] == 0 ? 1 : 0;
		}
		if (i == matrix.length - 1) {
			return numberOfpaths(matrix, cost - matrix[i][j], i, j + 1);
		}
		if (j == matrix.length - 1) {
			return numberOfpaths(matrix, cost - matrix[i][j], i + 1, j);
		}
		int noOfPathsFromNextRows = numberOfpaths(matrix, cost - matrix[i][j], i + 1, j);
		int noOfPathsFromNextCols = numberOfpaths(matrix, cost - matrix[i][j], i, j + 1);
		return noOfPathsFromNextCols + noOfPathsFromNextRows;
	}
	// 2nd way
	/*
	 * private static void numberOfPaths(int[][] matrix, int cost, int i, int j) {
	 * if(i>=matrix.length || j>=matrix.length) { return ; } if(i==matrix.length-1
	 * && j==matrix.length-1) { if(cost==matrix[i][j]) { ans+=1; } return; }
	 * 
	 * numberOfPaths(matrix, cost-matrix[i][j], i, j+1); numberOfPaths(matrix,
	 * cost-matrix[i][j], i+1, j); //return matrix[i][j] + Math.min(right, left); }
	 */
}
