package sortingalgorithms;

//Quick sort is a divide and conquer algorithm.
//find pivot number and make sure smaller numbers located at the left of pivot and bigger numbers are located at the right of the pivot.
//unlike merge sort extra space is not required.

//when to use Quick sort:
//1. when average expected time is O(NlogN)

//when to avoid Selection sort:
//1. when space is a concern
//2. when you need stable sort
public class QuickSort {

	// Time Complexity -> O(n log n)
	// Space Complexity -> O(n)
	public static void quickSort(int[] nums, int start, int end) {
		if (start < end) {
			int pivot = partition(nums, start, end);
			quickSort(nums, start, pivot - 1);
			quickSort(nums, pivot + 1, end);
		}
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = end;
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] <= nums[pivot]) {
				i++;
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
			}
		}
		i++;
		int tmp = nums[pivot];
		nums[pivot] = nums[i];
		nums[i] = tmp;
		return i;
	}

}
