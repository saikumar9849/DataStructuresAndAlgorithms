package sortingalgorithms;

import java.util.PriorityQueue;

//Step 1. Insert data to Binary Heap Tree
//Step 2. Extract data from Binary Heap
//It is best suited with array, it does not work with Linked List

//Binary Heap is a binary tree with special properties like:
//1. The value of any given node must be less or equal of its children (min heap)
//2. The value of any given node must be greater or equal of its children (max heap)

//Algorithm:
//1. write the Binary heap code (refer Trees lecture for Binary Heap)
//2. now insert into binary Heap and again extract it to get the sorted Array

//Also see the code of Heap sort in geekforgeeks or google
public class HeapSort {
	
	// Time Complexity -> O(n log n)
	// Space Complexity -> O(n)
	public static void heapSort(int[] arr) {
		//as we implemented Binary in other project(Trees) so we can't include it at present
		//Instead we can use the Priority Queue which has some similar properties it will store the elements in sorted order.
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i: arr) {
			minHeap.add(i);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = minHeap.poll();
		}
	}
}
