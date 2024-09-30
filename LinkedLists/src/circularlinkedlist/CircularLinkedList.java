package circularlinkedlist;

import linkedlist.SinglyNode;

public class CircularLinkedList {

	public SinglyNode head;
	public SinglyNode tail;
	public int size;

	public CircularLinkedList() {
		this.size = 0;
	}

	//TC -> O(n)
	//SC -> O(1)
	public void insert(int value, int location) {
		SinglyNode newNode = new SinglyNode();
		newNode.value = value;
		newNode.next = null;
		size++;
		if (head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
		} else if (location == 0) {
			newNode.next = head;
			head = newNode;
			tail.next = head;
		} else if (location >= size - 1) {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		} else {
			SinglyNode tmpNode = head;
			for (int i = 0; i < location - 1; i++) {
				tmpNode = tmpNode.next;
			}
			newNode.next = tmpNode.next;
			tmpNode.next = newNode;
		}
	}

	//TC -> O(n)
	//SC -> O(1)
	public void traverse() {
		if (head == null) {
			System.out.println("No data in Single LinkedList");
		} else {
			SinglyNode tmpnode = head;
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

	//TC -> O(n)
	//SC -> O(1)
	public boolean search(int value) {
		if (head != null) {
			SinglyNode tmpnode = head;
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

	//TC -> O(n)
	//SC -> O(1)
	public void delete(int index) {
		if (head == null) {
			System.out.println("No data in Single LinkedList");
		} else if (index < 0 || index >= size) {
			System.out.println("Index is out of Range");
		} else if (index == 0) {
			if (head.next == null) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				tail.next = head;
			}
			size--;
		} else if (index == size - 1) {
			SinglyNode tmpNode = head;
			for (int i = 0; i < index - 1; i++) {
				tmpNode = tmpNode.next;
			}
			if (tmpNode == head) {
				tail = head;
				head.next = head;
			} else {
				tail = tmpNode;
				tmpNode.next = head;
			}
			size--;
		} else {
			SinglyNode tmpNode = head;
			for (int i = 0; i < index - 1; i++) {
				tmpNode = tmpNode.next;
			}
			tmpNode.next = tmpNode.next.next;
			size--;
		}
	}

	//TC -> O(1)
	//SC -> O(1)
	public void deleteComplteList() {
		if (tail != null) {
			tail.next = null;
		}
		head = null;
		tail = null;
		System.out.println("LinkedList is deleted!");
	}

}
