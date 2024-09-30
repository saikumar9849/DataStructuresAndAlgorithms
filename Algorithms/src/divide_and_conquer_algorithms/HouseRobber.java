package divide_and_conquer_algorithms;

//Problem Statement:
//Given N number of houses along the street with some amount of money.
//Adjacent houses cannot be stolen
//Find the maximum amount that can be stolen

//Example:
// Houses = {6 7 1 30 8 2 4}
// Maximum amount = 41
// Houses that are stolen: 7, 30, 4
public class HouseRobber {

	public static int maximumAmount(int[] houses) {
		return calculate(houses, 0);
	}

	private static int calculate(int[] houses, int index) {
		if (index >= houses.length) {
			return 0;
		}
		int stealCurrentHouse = houses[index] + calculate(houses, index + 2);
		int skipCurrentHouse = calculate(houses, index + 1);
		return Math.max(stealCurrentHouse, skipCurrentHouse);
	}

}
