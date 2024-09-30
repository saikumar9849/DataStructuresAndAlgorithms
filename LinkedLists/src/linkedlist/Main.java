package linkedlist;

import java.util.LinkedList;

import circulardoublylinkedlist.CircularDoublyLinkedList;
import circularlinkedlist.CircularLinkedList;
import doublylinkedlist.DoublyLinkedList;
import singlylinkedlist.SinglyLinkedList;

public class Main {

	public static void main(String[] args) {
		System.out.println("<!-- Single LinkedList -->");
		SinglyLinkedList sLL = new SinglyLinkedList();
		sLL.delete(0);
		sLL.insert(2, 0);
		sLL.insert(1, 0);
		sLL.insert(21, 1);
		sLL.insert(12, 3);
		sLL.insert(15, 2);
		sLL.insert(6, 1);
		sLL.traverse();
		sLL.search(21);
		sLL.delete(0);
		sLL.delete(2);
		sLL.delete(3);
		sLL.traverse();

		System.out.println("\n\n<!-- Circular LinkedList -->");
		CircularLinkedList cLL = new CircularLinkedList();
		cLL.delete(0);
		cLL.insert(2, 0);
		cLL.insert(1, 0);
		cLL.insert(21, 1);
		cLL.insert(12, 3);
		cLL.insert(15, 2);
		cLL.insert(6, 1);
		cLL.traverse();
		cLL.search(21);
		cLL.delete(0);
		cLL.delete(2);
		cLL.delete(3);
		cLL.traverse();

		System.out.println("\n\n<!-- Doubly LinkedList -->");
		DoublyLinkedList dLL = new DoublyLinkedList();
		dLL.delete(0);
		dLL.insert(2, 0);
		dLL.insert(1, 0);
		dLL.insert(21, 1);
		dLL.insert(12, 3);
		dLL.insert(15, 2);
		dLL.insert(6, 1);
		dLL.traverse();
		dLL.reverseTraversal();
		dLL.search(21);
		dLL.delete(0);
		dLL.delete(2);
		dLL.delete(3);
		dLL.traverse();

		System.out.println("\n\n<!-- Circular Doubly LinkedList -->");
		CircularDoublyLinkedList cDLL = new CircularDoublyLinkedList();
		cDLL.delete(0);
		cDLL.insert(2, 0);
		cDLL.insert(1, 0);
		cDLL.insert(21, 1);
		cDLL.insert(12, 3);
		cDLL.insert(15, 2);
		cDLL.insert(6, 1);
		cDLL.traverse();
		cDLL.reverseTraversal();
		cDLL.search(21);
		cDLL.delete(0);
		cDLL.delete(2);
		cDLL.delete(3);
		cDLL.traverse();

		System.out.println("\n\n<!-- LinkedList using inbuilt Library -->");
		LinkedList<Integer> jLL = new LinkedList<>();
		jLL.add(2);
		jLL.add(0, 1);
		jLL.add(1, 21);
		jLL.add(3, 12);
		jLL.add(2, 15);
		jLL.add(1, 6);
		System.out.println(jLL.toString());
		System.out.println("Node found At index: " + jLL.indexOf(21));
		jLL.remove(0);
		jLL.remove(2);
		jLL.remove(3);
		System.out.println(jLL.toString());
	}

}
