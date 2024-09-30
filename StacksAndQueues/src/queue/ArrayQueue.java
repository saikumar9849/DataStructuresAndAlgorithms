package queue;

public class ArrayQueue {

	int[] arr;
	int begin;
	int top;

	// Creation
	// TC -> O(1)
	// SC -> O(n)
	public ArrayQueue(int size) {
		arr = new int[size];
		top = -1;
		begin = 0;
	}

	// TC -> O(1)
	// SC -> O(1)
	public boolean isFull() {
		if (top == arr.length - 1) {
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
		top++;
		arr[top] = ele;
	}

	// TC -> O(1)
	// SC -> O(1)
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int res = arr[begin];
		begin++;
		if (begin > top) {
			top = -1;
			begin = 0;
		}
		return res;
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

	// TC -> O(1)
	// SC -> O(1)
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is Deleted");
	}

}
