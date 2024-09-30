package searchingalgorithms;

//Binary search is faster then linear search
//half of the remaining elements can be eliminated  at a time, instead of eliminating them one by one
//Binary search only works for sorted arrays

//Binary search pseudocode:
//1. create function with two parameters which are a sorted array and a target value
//2. Create two pointers: a left pointer at the start of the array & a right pointer at the end of the array.
//3. Based on left and right pointers calculate middle pointer
//4. If middle element is equal to the target value return the index else continue Step-5
//5. while middle is not equal to the value and start<=end loop:
//		-If the middle is greater than the value move the right pointer down
//		-If the middle is less than the value move the left pointer up
//4. If the value is never found return -1;
public class BinarySearch {

	// Time Complexity -> O(log n)
	// Space Complexity -> O(1)
	public static int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	// Time Complexity -> O(log n)
	// Space Complexity -> O(1)
	public static int binarySearchRecursive(int[] nums, int target, int left, int right) {
		if (left <= right && left <= nums.length - 1) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				return binarySearchRecursive(nums, target, mid + 1, right);
			}
			return binarySearchRecursive(nums, target, left, mid - 1);
		}
		return -1;
	}
}
