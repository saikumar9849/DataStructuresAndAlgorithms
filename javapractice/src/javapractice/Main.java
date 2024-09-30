package javapractice;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		List<Integer> x = Arrays.asList(1, 2, 3, 4);

		x.forEach(n -> System.out.println(n + 5));
		x.stream().forEach(n -> System.out.println(n));

		List<String> list = Arrays.asList("Geeks", "for", "gfg", "GeeksforGeeks", "GeeksQuiz");
		list.stream().mapToInt(str -> str.length()).forEach(System.out::println);

		System.out.println("12345 sum digits:" + sumofDigits(12345));
		System.out.println("GCD of (25,5):" + GCD(25, 5));
		System.out.println("binary number of 5:" + decimalToBinary(4));

		int[] nums = { 1, 2, 3, 4, 5, 7, 10, 11, 12, 15, 21 };
		System.out.println("LinearSearch withOut Recurssion: " + linearSearch(nums, 12));
		System.out.println("LinearSearch with Recursion: " + linearSearchRecursive(nums, 12, 0));
		System.out.println("BinarySearch withOut Recurssion: " + binarySearch(nums, 21));
		System.out.println("BinarySearch with Recurssion: " + binarySearchRecursive(nums, 1, 0, nums.length));
	}

	private static int sumofDigits(int n) {
		if (n <= 0) {
			return 0;
		}
		return n % 10 + sumofDigits(n / 10);
	}

	private static int GCD(int a, int b) {
		if (a < 0 || b < 0) {
			return -1;
		}
		if (a == 0) {
			return b;
		}
		return GCD(b % a, a);
	}

	private static int decimalToBinary(int n) {
		if (n <= 0) {
			return 0;
		}
		return n % 2 + 10 * decimalToBinary(n / 2);
	}

	private static int linearSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private static int linearSearchRecursive(int[] nums, int target, int index) {
		if (index >= nums.length) {
			return -1;
		} else if (nums[index] == target) {
			return index;
		}
		return linearSearchRecursive(nums, target, index + 1);
	}

	private static int binarySearch(int nums[], int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int binarySearchRecursive(int nums[], int target, int start, int end) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if (target == nums[mid]) {
			return mid;
		} else if (target > nums[mid]) {
			return binarySearchRecursive(nums, target, mid + 1, end);
		} else {
			return binarySearchRecursive(nums, target, start, mid - 1);
		}
	}

}
