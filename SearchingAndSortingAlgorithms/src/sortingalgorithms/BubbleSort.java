package sortingalgorithms;

//Bubble Sort is also referred as sinking sort.
//we repeatedly compare each pair of adjacent items and swap them if they are in the wrong order.

//when to use Bubble sort:
//1. when the input is almost sorted
//2. space is a concern
//3. Easy to implement

//when to avoid Bubble sort:
//1. Average time complexity is poor
public class BubbleSort {

	// Time Complexity -> O(n^2)
	// Space Complexity -> O(1)
	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					// swapping
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}
	}

}
