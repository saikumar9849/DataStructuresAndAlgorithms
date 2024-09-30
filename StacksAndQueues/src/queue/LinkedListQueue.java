package queue;

import java.util.LinkedList;

public class LinkedListQueue {

	LinkedList<Integer> queue;

	// Creation
	// TC -> O(1)
	// SC -> O(1)
	public LinkedListQueue() {
		queue = new LinkedList<>();
	}

	// TC -> O(1)
	// SC -> O(1)
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	// TC -> O(1)
	// SC -> O(1)
	public void enQueue(int ele) {
		queue.addLast(ele);
	}

	// TC -> O(1)
	// SC -> O(1)
	public int peek() {
		return queue.getFirst();
	}

	// TC -> O(1)
	// SC -> O(1)
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return queue.removeFirst();
	}

}
