package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import main.BinaryNode;

public class BinaryTreeLL {

	public BinaryNode root;

	// TC -> O(1)
	// SC -> O(1)
	public BinaryTreeLL() {
		this.root = null;
	}

	// TC -> O(n)
	// SC -> O(n)
	public void insert(String data) {
		BinaryNode newNode = new BinaryNode();
		newNode.data = data;
		if (this.root == null) {
			this.root = newNode;
			System.out.println("Inserted newNode at root");
			return;
		}
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(this.root);
		while (!q.isEmpty()) {
			BinaryNode parent = q.poll();
			if (parent.left == null) {
				parent.left = newNode;
				System.out.println("NewNode inserted successfully");
				break;
			} else if (parent.right == null) {
				parent.right = newNode;
				System.out.println("NewNode inserted successfully");
				break;
			} else {
				q.add(parent.left);
				q.add(parent.right);
			}
		}
	}

	// TC -> O(n)
	// SC -> O(n)
	public void preOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	// TC -> O(n)
	// SC -> O(n)
	public void inOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}

	// TC -> O(n)
	// SC -> O(n)
	public void postOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + " ");
	}

	// TC -> O(n)
	// SC -> O(n)
	public void levelOrderTraversal() {
		if (root == null) {
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode present = q.poll();
			System.out.print(present.data + " ");
			if (present.left != null) {
				q.add(present.left);
			}
			if (present.right != null) {
				q.add(present.right);
			}
		}
	}

	// TC -> O(1)
	// SC -> O(n)
	public void search(String data) {
		if (root == null) {
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryNode present = q.poll();
			if (present.data.equals(data)) {
				System.out.println(present.data + " is found");
				return;
			}
			if (present.left != null) {
				q.add(present.left);
			}
			if (present.right != null) {
				q.add(present.right);
			}
		}
		System.out.println(data + " is not found");
	}

	// TC -> O(n)
	// SC -> O(1)
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		BinaryNode parent = null;
		while (!q.isEmpty()) {
			parent = q.poll();
			if (parent.left != null) {
				q.add(parent.left);
			}
			if (parent.right != null) {
				q.add(parent.right);
			}
		}
		return parent;
	}

	// TC -> O(n)
	// SC -> O(1)
	public void deleteDeepestNode() {
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);
		BinaryNode parent = null;
		while (!q.isEmpty()) {
			parent = q.poll();
			if (parent.left == null || parent.right == null) {
				return;
			}
			q.add(parent.left);
			q.add(parent.right);
		}
	}

	// TC -> O(n)
	// SC -> O(n)
	public void delete(String data) {
		if (this.root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			BinaryNode parent = q.poll();
			if (parent.data.equals(data)) {
				parent.data = this.getDeepestNode().data;
				deleteDeepestNode();
				System.out.println("Node deleted successfully");
				return;
			}
			if (parent.left != null) {
				q.add(parent.left);
			}
			if (parent.right != null) {
				q.add(parent.right);
			}
		}
		System.out.println("Node is not found");
	}

	// TC -> O(1)
	// SC -> O(1)
	public void deleteBT() {
		this.root = null;
		System.out.println("BT has been successfully deleted");
	}
}
