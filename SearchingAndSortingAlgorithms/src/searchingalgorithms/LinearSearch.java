package searchingalgorithms;

//Linear search pseudocode:
//1. create function with two parameters which are an array and a target value
//2. Loop through the array and check if the current array element is equal to the value.
//3. If it is return the index at which the element is found
//4. If the value is never found return -1;
public class LinearSearch {

	// Time Complexity -> O(n)
	// Space Complexity -> O(1)
	public static int linearSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// Time Complexity -> O(n)
	// Space Complexity -> O(1)
	public static int linearSearchRecursive(int[] nums, int target, int index) {
		if (index >= nums.length) {
			return -1;
		} else if (nums[index] == target) {
			return index;
		}
		return linearSearchRecursive(nums, target, index + 1);
	}
}
