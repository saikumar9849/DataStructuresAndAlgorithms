package stack;

import java.util.LinkedList;

public class LinkedListStack {

	LinkedList<Integer> stack;

	// Creation
	// TC -> O(1)
	// SC -> O(1)
	public LinkedListStack() {
		stack = new LinkedList<>();
	}

	// TC -> O(1)
	// SC -> O(1)
	public void push(int ele) {
		stack.addFirst(ele);
		System.out.println(ele + " is inserted.");
	}

	// TC -> O(1)
	// SC -> O(1)
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	// TC -> O(1)
	// SC -> O(1)
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = stack.removeFirst();
		return res;
	}

	// TC -> O(1)
	// SC -> O(1)
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = stack.getFirst();
		return res;
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteStack() {
		stack = null;
		System.out.println("Stack is deleted");
	}

}
