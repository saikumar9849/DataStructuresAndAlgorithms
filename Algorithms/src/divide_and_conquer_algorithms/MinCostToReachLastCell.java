package divide_and_conquer_algorithms;

//Problem Statement:
//2D Matrix is given
//Each cell has a cost associated with it for accessing
//we need to start from (0,0) cell and go till (n-1, n-1) cell
//we can go only to right or down cell from current cell
//Find the way in which the cost is minimum

//Example:
//matrix = {{4, 7, 8, 6, 4}, {6, 7, 3, 9, 2}, {3, 8, 1, 2, 4}, {7, 1, 7, 3, 7}, {2, 9, 8, 9, 3}}
//Output = 36
public class MinCostToReachLastCell {

	public static int findMinCost(int[][] matrix) {
		return findMinCost(matrix, 0, 0);
	}

	private static int findMinCost(int[][] matrix, int i, int j) {
		if (i >= matrix.length || j >= matrix.length) {
			return Integer.MAX_VALUE;
		}
		if (i == matrix.length - 1 && j == matrix.length - 1) {
			return matrix[i][j];
		}

		int right = findMinCost(matrix, i, j + 1);
		int left = findMinCost(matrix, i + 1, j);
		return matrix[i][j] + Math.min(right, left);
	}

}
