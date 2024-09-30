package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeArray {
	
	public String arr[];
	int lastIndex;
	
	// Creation
	// TC -> O(1)
	// SC -> O(n)
	public BinaryTreeArray(int size) {
		this.arr = new String[size];
		this.lastIndex=-1;
	}
	
	// TC -> O(1)
	// SC -> O(1)
	private boolean isFull() {
		return this.lastIndex>=arr.length-1;
	}
	
	// TC -> O(1)
	// SC -> O(1)
	private boolean isEmpty() {
		return this.lastIndex==-1;
	}
	
	// TC -> O(1)
	// SC -> O(1)
	public void insert(String data) {
		if(isFull()) {
			System.out.println("Array is full");
			return;
		}
		this.lastIndex++;
		this.arr[this.lastIndex] = data;
	}
	
	// TC -> O(n)
	// SC -> O(n)
	public void levelOrderTraversal() {
		if(isEmpty()) {
			System.out.println("Tree is Empty");
			return;
		}
		//simple way
		/*for(int i=0;i<=this.lastIndex;i++) {
			System.out.print(this.arr[i]+" ");
		}*/
		
		//Normal way;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int presentIndex = q.poll();
			System.out.print(arr[presentIndex]+" ");
			if(presentIndex*2+1<=this.lastIndex) {
				q.add(presentIndex*2+1);
			}
			if(presentIndex*2+2<=this.lastIndex) {
				q.add(presentIndex*2+2);
			}
		}
	}
	
	// TC -> O(n)
	// SC -> O(1)
	public void search(String data) {
		if(isEmpty()) {
			System.out.println("Tree is Empty");
			return;
		}
		//simple way
		/*for(int i=0;i<=this.lastIndex;i++) {
			if(arr[i].equals(data)) {
				System.out.println(this.arr[i]+" is found");
				return;
			}
		}*/
		
		//Normal way;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int presentIndex = q.poll();
			if(arr[presentIndex].equals(data)) {
				System.out.println(arr[presentIndex]+" is Found");
				return;
			}
			if(presentIndex*2+1<=this.lastIndex) {
				q.add(presentIndex*2+1);
			}
			if(presentIndex*2+2<=this.lastIndex) {
				q.add(presentIndex*2+2);
			}
		}
		System.out.println(data+" is Not Found");
	}
	
	// TC -> O(n)
	// SC -> O(n)
	public void inOrderTraversal(int index) {
		if(index>this.lastIndex) {
			return;
		}
		inOrderTraversal(index*2+1);
		System.out.print(this.arr[index]+" ");
		inOrderTraversal(index*2+2);
	}
	
	// TC -> O(n)
	// SC -> O(n)
	public void preOrderTraversal(int index) {
		if(index>this.lastIndex) {
			return;
		}
		System.out.print(this.arr[index]+" ");
		preOrderTraversal(index*2+1);
		preOrderTraversal(index*2+2);
	}
	
	// TC -> O(n)
	// SC -> O(n)
	public void postOrderTraversal(int index) {
		if(index>this.lastIndex) {
			return;
		}
		postOrderTraversal(index*2+1);
		postOrderTraversal(index*2+2);
		System.out.print(this.arr[index]+" ");
	}
	
	// TC -> O(n)
	// SC -> O(1)
	public void delete(String data) {
		if(this.isEmpty()) {
			System.out.println("Tree is Empty, Nothing to delete");
			return ;
		}
		
		//simple way
		/*for(int i=0;i<=this.lastIndex;i++) {
			if(this.arr[i].equals(data)) {
				this.arr[i] = this.arr[this.lastIndex];
				this.lastIndex--;
				System.out.println("Element deleted successfully!");
			}
		}*/
		
		//Normal approach
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int presentIndex = q.poll();
			if(this.arr[presentIndex].equals(data)) {
				this.arr[presentIndex] = this.arr[this.lastIndex];
				this.lastIndex--;
				System.out.println("Element is Deleted successfully");
				return;
			}
			if(presentIndex*2+1<=this.lastIndex) {
				q.add(presentIndex*2+1);
			}
			if(presentIndex*2+2<=this.lastIndex) {
				q.add(presentIndex*2+2);
			}
		}
		System.out.println("Element is Not present in Tree");
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteBT() {
		this.lastIndex = -1;
		this.arr = null;
		System.out.println("Binary Tree is deleted");
	}
}
