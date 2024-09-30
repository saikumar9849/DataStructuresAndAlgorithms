package queue;

import java.util.Arrays;

public class CircularQueue {

	int[] arr;
	int begin;
	int top;

	// Creation
	// TC -> O(1)
	// SC -> O(n)
	public CircularQueue(int size) {
		arr = new int[size];
		top = -1;
		begin = -1;
	}

	// TC -> O(1)
	// SC -> O(1)
	public boolean isFull() {
		if ((top + 1) % arr.length == begin) {
			return true;
		}
		return false;
	}

	// TC -> O(1)
	// SC -> O(1)
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	// TC -> O(1)
	// SC -> O(1)
	public void enQueue(int ele) {
		if (isFull()) {
			System.out.println("Queue is Full");
			return;
		}
		if (top == -1) {
			begin = 0;
		}
		top = (top + 1) % arr.length;
		arr[top] = ele;
	}

	// TC -> O(1)
	// SC -> O(1)
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Full");
			return -1;
		}
		int res = arr[begin];
		arr[begin] = 0;
		begin = (begin + 1) % arr.length;
		if (begin > top) {
			top = -1;
			begin = -1;
		}
		return res;
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is Deleted");
	}

	// TC -> O(1)
	// SC -> O(1)
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return arr[begin];
	}

	public void print() {
		System.out.println(Arrays.toString(arr));
	}

}
