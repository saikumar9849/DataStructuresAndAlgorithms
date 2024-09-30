package avl_tree;

import java.util.LinkedList;
import java.util.Queue;

import main.BinaryNodeInt;

public class AVLTree {

	public BinaryNodeInt root;

	// TC -> O(1)
	// SC -> O(1)
	public AVLTree() {
		this.root = null;
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

	public int getHeight(BinaryNodeInt node) {
		return node == null ? 0 : node.height;
	}

	private BinaryNodeInt rotateRight(BinaryNodeInt disbalncedNode) {
		BinaryNodeInt newRoot = disbalncedNode.left;
		disbalncedNode.left = newRoot.right;
		newRoot.right = disbalncedNode;
		disbalncedNode.height = 1 + Math.max(getHeight(disbalncedNode.left), getHeight(disbalncedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}

	private BinaryNodeInt rotateLeft(BinaryNodeInt disbalncedNode) {
		BinaryNodeInt newRoot = disbalncedNode.right;
		disbalncedNode.right = newRoot.left;
		newRoot.left = disbalncedNode;
		disbalncedNode.height = 1 + Math.max(getHeight(disbalncedNode.left), getHeight(disbalncedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}

	public int getBalance(BinaryNodeInt node) {
		return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
	}

	public void insert(int value) {
		root = insertNode(root, value);
	}

	public BinaryNodeInt insertNode(BinaryNodeInt node, int value) {
		if (node == null) {
			BinaryNodeInt newNode = new BinaryNodeInt();
			newNode.value = value;
			newNode.height = 1;
			return newNode;
		} else if (value < node.value) {
			node.left = insertNode(node.left, value);
		} else {
			node.right = insertNode(node.right, value);
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getBalance(node);
		if (balance > 1 && value < node.left.value) {
			return rotateRight(node);
		}
		if (balance > 1 && value > node.left.value) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (balance < -1 && value > node.right.value) {
			return rotateLeft(node);
		}
		if (balance < -1 && value < node.right.value) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	private BinaryNodeInt getMinNode(BinaryNodeInt node) {
		if (node.left == null) {
			return node;
		}
		return getMinNode(node.left);
	}

	public void deleteNode(int value) {
		this.root = delete(root, value);
	}

	private BinaryNodeInt delete(BinaryNodeInt node, int value) {
		if (node == null) {
			System.out.println(value + " not found in AVL");
			return node;
		}
		if (value < node.value) {
			node.left = delete(node.left, value);
		} else if (value > node.value) {
			node.right = delete(node.right, value);
		} else {
			if (node.left != null && node.right != null) {
				BinaryNodeInt tmp = node;
				BinaryNodeInt minNodeForRight = getMinNode(tmp.right);
				node.value = minNodeForRight.value;
				node.right = delete(node.right, minNodeForRight.value);
			} else if (node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = node.right;
			} else {
				node = null;
			}
		}
		int balance = getBalance(node);
		if (balance > 1 && getBalance(node.left) >= 0) {
			return rotateRight(node);
		}
		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (balance < -1 && getBalance(node.right) <= 0) {
			return rotateLeft(node);
		}
		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

}
