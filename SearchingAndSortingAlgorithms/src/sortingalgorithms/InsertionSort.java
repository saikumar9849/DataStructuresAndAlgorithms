package sortingalgorithms;

//Insertion sort:
//First we Divide the given array into two parts (sorted & unsorted Array)
//Take first element from unsorted array and find its correct position in sorted array.
//Repeat until unsorted array is empty

//when to use Insertion sort:
//1. when we have insufficient memory
//2. Easy to implement
//3. when we have continuous inflows of numbers and we want to keep them sorted.

//when to avoid Insertion sort:
//1. when time is a concern
public class InsertionSort {

	// Time Complexity -> O(n^2)
	// Space Complexity -> O(1)
	public static void insertionSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i], j = i - 1;
			while (j >= 0 && tmp < nums[j]) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = tmp;
		}
	}

}
