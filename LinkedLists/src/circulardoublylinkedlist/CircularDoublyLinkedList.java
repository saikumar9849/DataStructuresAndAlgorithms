package circulardoublylinkedlist;

import linkedlist.DoublyNode;

public class CircularDoublyLinkedList {

	public DoublyNode head;
	public DoublyNode tail;
	public int size;

	public CircularDoublyLinkedList() {
		this.size = 0;
	}

	// TC -> O(n)
	// SC -> O(1)
	public void insert(int ele, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = ele;
		newNode.next = null;
		newNode.prev = null;
		size++;
		if (head == null) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		} else if (location == 0) {
			newNode.next = head;
			head.prev = newNode;
			tail.next = newNode;
			newNode.prev = tail;
			head = newNode;
		} else if (location >= size - 1) {
			newNode.next = head;
			newNode.prev = tail;
			tail.next = newNode;
			head.prev = newNode;
			tail = newNode;
		} else {
			DoublyNode tmpNode = head;
			for (int i = 0; i < location - 1; i++) {
				tmpNode = tmpNode.next;
			}
			newNode.next = tmpNode.next;
			newNode.prev = tmpNode;
			tmpNode.next.prev = newNode;
			tmpNode.next = newNode;
		}
	}

	// TC -> O(n)
	// SC -> O(1)
	public void delete(int index) {
		if (head == null) {
			System.out.println("LinkedList is null");
			return;
		} else if (index < 0 || index >= size) {
			System.out.println("Index is out of Range");
			return;
		} else if (index == 0) {
			if (size == 1) {
				head.prev = null;
				head.next = null;
				head = tail = null;
			} else {
				tail.next = head.next;
				head.next.prev = tail;
				head = head.next;
			}
		} else if (index == size - 1) {
			if (size == 1) {
				head.prev = null;
				head.next = null;
				head = tail = null;
			} else {
				head.prev = tail.prev;
				tail.prev.next = head;
				tail = head.prev;
			}
		} else {
			DoublyNode tmpNode = head;
			for (int i = 0; i < index - 1; i++) {
				tmpNode = tmpNode.next;
			}
			tmpNode.next = tmpNode.next.next;
			tmpNode.next.prev = tmpNode;
		}
		size--;
	}

	// TC -> O(n)
	// SC -> O(1)
	public void deleteComplteList() {
		DoublyNode tmpNode = head;
		for (int i = 0; i < size; i++) {
			tmpNode.prev = null;
			tmpNode = tmpNode.next;
		}
		head = null;
		tail = null;
		System.out.println("LinkedList is deleted!");
	}

	// TC -> O(n)
	// SC -> O(1)
	public void traverse() {
		if (head == null) {
			System.out.println("No data in Single LinkedList");
		} else {
			DoublyNode tmpnode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tmpnode.value);
				if (i != size - 1) {
					System.out.print(" ->");
				}
				tmpnode = tmpnode.next;
			}
			System.out.println();
		}
	}

	// TC -> O(n)
	// SC -> O(1)
	public void reverseTraversal() {
		if (head == null) {
			System.out.println("No data in Single LinkedList");
		} else {
			DoublyNode tmpnode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tmpnode.value);
				if (i != size - 1) {
					System.out.print(" <-");
				}
				tmpnode = tmpnode.prev;
			}
			System.out.println();
		}
	}

	// TC -> O(n)
	// SC -> O(1)
	public boolean search(int value) {
		if (head != null) {
			DoublyNode tmpnode = head;
			for (int i = 0; i < size; i++) {
				if (tmpnode.value == value) {
					System.out.println("Node found At index: " + i);
					return true;
				}
				tmpnode = tmpnode.next;
			}
		}
		System.out.println("No data in Single LinkedList");
		return false;
	}

}
