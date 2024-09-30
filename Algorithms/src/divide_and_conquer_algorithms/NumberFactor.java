package divide_and_conquer_algorithms;

//problem Statement:
//Given N, find the number of ways to express N as a sum of 1, 3, 4.
public class NumberFactor {

	public static int noOfways(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		} else if (n == 3) {
			return 2;
		}
		int a = noOfways(n - 4);
		int b = noOfways(n - 3);
		int c = noOfways(n - 1);
		return a + b + c;
	}

}
