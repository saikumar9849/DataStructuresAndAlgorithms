package sortingalgorithms;

//Merge sort is a divide and conquer algorithm
//Divide the input array in two halves and we keep halving recursively until they become too small that cannot be broken further.
//Merge halves by sorting them.

//when to use Merge sort:
//1. when we need stable sort
//2. when average expected time is O(N logN)

//when to avoid Merge sort:
//1. when space is a concern
public class MergeSort {

	// Time Complexity -> O(n log n)
	// Space Complexity -> O(n)
	public static void mergeSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		merge(nums, left, mid, right);
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int[] leftArr = new int[mid - left + 1];
		int[] rightArr = new int[right - mid];

		for (int i = 0; i < mid - left + 1; i++) {
			leftArr[i] = nums[left + i];
		}
		for (int i = 0; i < right - mid; i++) {
			rightArr[i] = nums[mid + i + 1];
		}

		int l = 0, r = 0;
		int j = left;
		while (l < leftArr.length && r < rightArr.length) {
			if (leftArr[l] <= rightArr[r]) {
				nums[j] = leftArr[l];
				l++;
			} else {
				nums[j] = rightArr[r];
				r++;
			}
			j++;
		}
		for (int i = l; i < leftArr.length; i++) {
			nums[j] = leftArr[i];
			j++;
		}
		for (int i = r; i < rightArr.length; i++) {
			nums[j] = rightArr[i];
			j++;
		}
	}

}
