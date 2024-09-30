package main;

import java.util.Arrays;

import searchingalgorithms.BinarySearch;
import searchingalgorithms.LinearSearch;
import sortingalgorithms.BubbleSort;
import sortingalgorithms.BucketSort;
import sortingalgorithms.HeapSort;
import sortingalgorithms.InsertionSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.QuickSort;
import sortingalgorithms.SelectionSort;

public class Main {

	public static void main(String[] args) {

		System.out.println("<-- Searching Algorithms -->");
		searchingAlgorithms();

		System.out.println("\n<-- Sorting Algorithms -->");
		sortingAlgorithms();

	}

	private static void searchingAlgorithms() {
		int[] nums = { 1, 2, 3, 4, 6, 8, 9, 13, 14, 17, 20, 30, 35 };
		System.out.println("Array used for all Searching Algorithms: " + Arrays.toString(nums));

		System.out.println("\nLinear Search Algorithm:");
		int linearSearchIndex = LinearSearch.linearSearch(nums, 4);
		searchingOutput(linearSearchIndex, 4);

		System.out.println("\nBinary Search Algorithm:");
		int binarySearchIndex1 = BinarySearch.binarySearch(nums, 35);
		searchingOutput(binarySearchIndex1, 35);

		System.out.println("\nBinary Search Algorithm (using Recurrsion):");
		int binarySearchIndex2 = BinarySearch.binarySearchRecursive(nums, 1, 0, nums.length - 1);
		searchingOutput(binarySearchIndex2, 1);
	}

	private static void searchingOutput(int index, int element) {
		if (index == -1) {
			System.out.println("Target Element: " + element + " is not found!");
		} else {
			System.out.println("Target Element: " + element + " is found at index: " + index);
		}
	}

	private static void sortingAlgorithms() {
		int[] arr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		System.out.println("Array used for all Sortings: " + Arrays.toString(arr));

		System.out.println("\nBubble Sort or Sinking Sort Algorithm:");
		int[] bubbleSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		BubbleSort.bubbleSort(bubbleSortArr);
		System.out.println("Array output after sorting: " + Arrays.toString(bubbleSortArr));

		System.out.println("\nSelection Sort Algorithm:");
		int[] selectionSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		SelectionSort.selectionSort(selectionSortArr);
		System.out.println("Array output after sorting: " + Arrays.toString(selectionSortArr));

		System.out.println("\nInsertion Sort Algorithm:");
		int[] insertionSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		InsertionSort.insertionSort(insertionSortArr);
		System.out.println("Array output after sorting: " + Arrays.toString(insertionSortArr));

		System.out.println("\nMerge Sort Algorithm:");
		int[] mergeSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		MergeSort.mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
		System.out.println("Array output after sorting: " + Arrays.toString(mergeSortArr));

		System.out.println("\nQuick Sort Algorithm:");
		int[] quickSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		QuickSort.quickSort(quickSortArr, 0, quickSortArr.length - 1);
		System.out.println("Array output after sorting: " + Arrays.toString(quickSortArr));

		System.out.println("\nBucket Sort Algorithm:");
		int[] bucketSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		BucketSort.bucketSort(bucketSortArr);
		;
		System.out.println("Array output after sorting: " + Arrays.toString(bucketSortArr));

		System.out.println("\nHeap Sort Algorithm:");
		int[] heapSortArr = { 4, 1, 30, 6, 3, 20, 8, 6, 2, 35, 13, 17, 14 };
		HeapSort.heapSort(heapSortArr);
		System.out.println("Array output after sorting: " + Arrays.toString(heapSortArr));
	}

}
