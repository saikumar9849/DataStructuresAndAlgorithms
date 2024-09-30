package sortingalgorithms;

//In case of Selection sort we repeatedly find the minimum element and move it to the sorted part of array to make unsorted part sorted.

//when to use Selection sort:
//1. when we have insufficient memory
//2. Easy to implement

//when to avoid Selection sort:
//1. when time is a concern
public class SelectionSort {

	// Time Complexity -> O(n^2)
	// Space Complexity -> O(1)
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			// swapping
			int tmp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = tmp;
		}
	}

}
