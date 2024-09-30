package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;

//Create buckets and distribute elements of array into buckets
//Sort buckets individually
//Merge buckets after sorting
//Number of buckets = round(sqrt(number of elements))
//Appropriate bucket = ceil(value*number of buckets/maxValue)
//sort all buckets (using any sorting algorithm)

//when to use Bucket sort:
//1. when input uniformly distributed over range (e.g:- (uniformly distributed: 1,2,4,5,3,8,7,9), (Not uniformly distributed: 1, 2, 4, 91, 93, 95(diff b/w 4 & 91 is more)))

//when to avoid Bucket sort:
//1. when space is a concern
public class BucketSort {

	// Time Complexity -> O(n log n)
	// Space Complexity -> O(n)
	public static void bucketSort(int[] arr) {
		// determining the number of buckets
		int numberOfBuckets = (int) Math.round(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		for (int value : arr) {
			maxValue = Math.max(maxValue, value);
		}

		// creating buckets
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		for (int i = 0; i < numberOfBuckets; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		// adding values into respective buckets
		for (int value : arr) {
			int bucketNumber = (int) Math.ceil((float) value * (numberOfBuckets / (float) maxValue));
			buckets[bucketNumber - 1].add(value);
		}

		// printing buckets before sorting
		System.out.println("Printing Buckets before sorting");
		printBuckets(buckets);

		// sorting elements in individual buckets
		for (ArrayList<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		// printing buckets after sorting
		System.out.println("Printing Buckets after sorting");
		printBuckets(buckets);

		// getting the sorted values from the buckets into the original array
		int index = 0;
		for (ArrayList<Integer> bucket : buckets) {
			for (int value : bucket) {
				arr[index] = value;
				index++;
			}
		}
	}

	private static void printBuckets(ArrayList<Integer>[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			System.out.print("Bucket#" + i + ": ");
			for (int val : buckets[i]) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
