package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import main.BinaryNodeInt;

public class BinarySearchTree {

	public BinaryNodeInt root;

	// TC -> O(1)
	// SC -> O(1)
	public BinarySearchTree() {
		this.root = null;
	}

	// TC -> O(logn)
	// SC -> O(logn)
	private BinaryNodeInt insert(BinaryNodeInt currentNode, int data) {
		if (currentNode == null) {
			BinaryNodeInt newNode = new BinaryNodeInt();
			newNode.value = data;
			if (root == null) {
				this.root = newNode;
			}
			return newNode;
		} else if (data <= currentNode.value) {
			currentNode.left = insert(currentNode.left, data);
			return currentNode;
		} else {
			currentNode.right = insert(currentNode.right, data);
			return currentNode;
		}
	}

	public void insert(int data) {
		insert(root, data);
	}

	// TC -> O(n)
	// SC -> O(n)
	public void preOrder(BinaryNodeInt currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.print(currentNode.value + " ");
		preOrder(currentNode.left);
		preOrder(currentNode.right);
	}

	// TC -> O(n)
	// SC -> O(n)
	public void inOrder(BinaryNodeInt currentNode) {
		if (currentNode == null) {
			return;
		}
		inOrder(currentNode.left);
		System.out.print(currentNode.value + " ");
		inOrder(currentNode.right);
	}

	// TC -> O(n)
	// SC -> O(n)
	public void postOrder(BinaryNodeInt currentNode) {
		if (currentNode == null) {
			return;
		}
		postOrder(currentNode.left);
		postOrder(currentNode.right);
		System.out.print(currentNode.value + " ");
	}

	// TC -> O(n)
	// SC -> O(n)
	public void levelOrder() {
		Queue<BinaryNodeInt> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNodeInt node = q.poll();
			System.out.print(node.value + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	// TC -> O(logn)
	// SC -> O(logn)
	public BinaryNodeInt search(BinaryNodeInt currentNode, int data) {
		if (currentNode == null) {
			System.out.println(data + " is not found");
			return null;
		} else if (currentNode.value == data) {
			System.out.println(data + " is found");
			return currentNode;
		} else if (data <= currentNode.value) {
			return search(currentNode.left, data);
		} else {
			return search(currentNode.right, data);
		}
	}

	private BinaryNodeInt getMinNode(BinaryNodeInt node) {
		if (node.left == null) {
			return node;
		}
		return getMinNode(node.left);
	}

	public void deleteNode(int data) {
		this.root = delete(root, data);
	}

	// TC -> O(logn)
	// SC -> O(logn)
	private BinaryNodeInt delete(BinaryNodeInt node, int data) {
		if (node == null) {
			System.out.println(data + " is Not found");
			return null;
		} else if (data < node.value) {
			node.left = delete(node.left, data);
		} else if (data > node.value) {
			node.right = delete(node.right, data);
		} else {
			if (node.left == null && node.right == null) {
				System.out.println(data + " is deleted from BST");
				return null;
			} else if (node.left == null || node.right == null) {
				if (node.left != null) {
					System.out.println(data + " is deleted from BST");
					return node.left;
				} else {
					System.out.println(data + " is deleted from BST");
					return node.right;
				}
			} else {
				BinaryNodeInt minNode = getMinNode(node.right);
				node.value = minNode.value;
				node.right = delete(node.right, minNode.value);
				System.out.println(data + " is deleted from BST");
			}
		}
		return node;
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteBST() {
		this.root = null;
		System.out.println("Binary Search Tree is deleted");
	}
}
