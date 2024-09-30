package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import queue.ArrayQueue;
import queue.CircularQueue;
import queue.LinkedListQueue;
import stack.ArrayStack;
import stack.LinkedListStack;

public class Main {

	public static void main(String[] args) {

		System.out.println("<!-- Stack using Array -->");
		ArrayStack stack = new ArrayStack(5);
		System.out.println(stack.isEmpty());
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.deleteStack();

		System.out.println("\n\n<!-- Stack using LinkedList -->");
		LinkedListStack llstack = new LinkedListStack();
		System.out.println(llstack.isEmpty());
		llstack.push(5);
		llstack.push(4);
		llstack.push(3);
		llstack.push(2);
		llstack.push(1);
		llstack.push(12);
		System.out.println(llstack.isEmpty());
		System.out.println(llstack.peek());
		System.out.println(llstack.pop());
		System.out.println(llstack.pop());
		System.out.println(llstack.peek());
		llstack.deleteStack();

		System.out.println("\n\n<!-- Stack using inbuilt Library(java.util) -->");
		Stack<Integer> inbuiltStack = new Stack<>();
		System.out.println(inbuiltStack.isEmpty());
		inbuiltStack.push(5);
		inbuiltStack.push(4);
		inbuiltStack.push(3);
		inbuiltStack.push(2);
		inbuiltStack.push(1);
		System.out.println(inbuiltStack.isEmpty());
		System.out.println(inbuiltStack.peek());
		System.out.println(inbuiltStack.pop());
		System.out.println(inbuiltStack.pop());
		System.out.println(inbuiltStack.peek());
		System.out.println(inbuiltStack.toString());

		System.out.println("\n\n<!-- Queue using Array -->");
		ArrayQueue queue = new ArrayQueue(5);
		System.out.println(queue.isEmpty());
		queue.enQueue(5);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		queue.enQueue(4);
		queue.enQueue(3);
		queue.enQueue(2);
		queue.enQueue(1);
		queue.enQueue(12);
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.peek());
		queue.deleteQueue();

		System.out.println("\n\n<!-- Circular Queue using Array -->");
		CircularQueue cqueue = new CircularQueue(5);
		System.out.println(cqueue.isEmpty());
		cqueue.enQueue(5);
		System.out.println(cqueue.deQueue());
		System.out.println(cqueue.deQueue());
		cqueue.enQueue(4);
		cqueue.enQueue(3);
		cqueue.enQueue(2);
		cqueue.enQueue(1);
		cqueue.enQueue(12);
		System.out.println(cqueue.isFull());
		System.out.println(cqueue.isEmpty());
		System.out.println(cqueue.peek());
		System.out.println(cqueue.deQueue());
		System.out.println(cqueue.deQueue());
		System.out.println(cqueue.peek());
		cqueue.enQueue(13);
		cqueue.enQueue(14);
		cqueue.print();
		cqueue.deleteQueue();

		System.out.println("\n\n<!-- Queue using LinkedList -->");
		LinkedListQueue lqueue = new LinkedListQueue();
		System.out.println(lqueue.isEmpty());
		lqueue.enQueue(5);
		System.out.println(lqueue.deQueue());
		System.out.println(lqueue.deQueue());
		lqueue.enQueue(4);
		lqueue.enQueue(3);
		lqueue.enQueue(2);
		lqueue.enQueue(1);
		lqueue.enQueue(12);
		System.out.println(lqueue.isEmpty());
		System.out.println(lqueue.peek());
		System.out.println(lqueue.deQueue());
		System.out.println(lqueue.deQueue());
		System.out.println(lqueue.peek());

		System.out.println("\n\n<!-- Queue using inbuilt Library(java.util) -->");
		Queue<Integer> jqueue = new LinkedList<>();
		System.out.println(jqueue.isEmpty());
		jqueue.add(5);
		System.out.println(jqueue.remove());
		System.out.println(jqueue.peek());
		jqueue.add(4);
		jqueue.add(3);
		jqueue.add(2);
		jqueue.add(1);
		jqueue.add(12);
		System.out.println(jqueue.isEmpty());
		System.out.println(jqueue.peek());
		System.out.println(jqueue.remove());
		System.out.println(jqueue.remove());
		System.out.println(jqueue.peek());
	}

}
