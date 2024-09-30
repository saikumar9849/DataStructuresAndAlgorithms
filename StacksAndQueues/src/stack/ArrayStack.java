package stack;

public class ArrayStack {
	int[] arr;
	int top;

	// Creation
	// TC -> O(1)
	// SC -> O(n)
	public ArrayStack(int size) {
		arr = new int[size];
		top = -1;
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
	public boolean isFull() {
		if (top >= arr.length - 1) {
			return true;
		}
		return false;
	}

	// TC -> O(1)
	// SC -> O(1)
	public void push(int ele) {
		if (isFull()) {
			System.out.println("Stack is Full!");
			return;
		}
		top++;
		arr[top] = ele;
		System.out.println(ele + " is inserted.");
	}

	// TC -> O(1)
	// SC -> O(1)
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = arr[top];
		top--;
		return res;
	}

	// TC -> O(1)
	// SC -> O(1)
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return arr[top];
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteStack() {
		arr = null;
		top = -1;
		System.out.println("Stack is deleted");
	}

}
