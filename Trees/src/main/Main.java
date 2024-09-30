package main;

import avl_tree.AVLTree;
import basictree.TreeNode;
import binary_heap.BinaryHeap;
import binarysearchtree.BinarySearchTree;
import binarytree.BinaryTreeArray;
import binarytree.BinaryTreeLL;
import trie.Trie;
import trie.TrieNode;

class Main {

	public static void main(String[] args) {

		System.out.println("<!-- Basic Tree -->");
		TreeNode drinks = new TreeNode("Drinks");
		TreeNode hot = new TreeNode("Hot");
		TreeNode cold = new TreeNode("Cold");
		TreeNode tea = new TreeNode("Tea");
		TreeNode coffee = new TreeNode("Coffee");
		TreeNode wine = new TreeNode("Wine");
		TreeNode beer = new TreeNode("Beer");
		drinks.add(hot);
		drinks.add(cold);
		hot.add(tea);
		hot.add(coffee);
		cold.add(wine);
		cold.add(beer);
		drinks.print(0);

		System.out.println("\n\n<!-- Binary Tree -->");
		binaryTree();

		System.out.println("\n\n<!-- Binary Search Tree -->");
		binarySearchTree();

		System.out.println("\n\n<!-- Binary Heap -->");
		binaryHeap();

		System.out.println("\n\n<!-- Trie -->");
		trie();

		System.out.println("\n\n<!-- AVL Tree -->");
		avlTree();
	}

	private static void binaryTree() {
		System.out.println("BinaryTree using LinkedList: ");
		BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
		binaryTreeLL.insert("App");
		binaryTreeLL.insert("BackEnd");
		binaryTreeLL.insert("FrontEnd");
		binaryTreeLL.insert("API");
		binaryTreeLL.insert("Java");
		binaryTreeLL.insert("Angular");
		binaryTreeLL.insert("JavaScript");
		binaryTreeLL.inOrderTraversal(binaryTreeLL.root);
		System.out.println();
		binaryTreeLL.preOrderTraversal(binaryTreeLL.root);
		System.out.println();
		binaryTreeLL.postOrderTraversal(binaryTreeLL.root);
		System.out.println();
		binaryTreeLL.levelOrderTraversal();
		System.out.println();
		binaryTreeLL.search("API");
		binaryTreeLL.search("React");
		binaryTreeLL.delete("BackEnd");
		binaryTreeLL.levelOrderTraversal();
		System.out.println();
		binaryTreeLL.deleteBT();

		System.out.println("\nBinaryTree using Array: ");
		BinaryTreeArray binaryTreeArr = new BinaryTreeArray(10);
		binaryTreeArr.insert("App");
		binaryTreeArr.insert("BackEnd");
		binaryTreeArr.insert("FrontEnd");
		binaryTreeArr.insert("API");
		binaryTreeArr.insert("Java");
		binaryTreeArr.insert("Angular");
		binaryTreeArr.insert("JavaScript");
		binaryTreeArr.inOrderTraversal(0);
		System.out.println();
		binaryTreeArr.preOrderTraversal(0);
		System.out.println();
		binaryTreeArr.postOrderTraversal(0);
		System.out.println();
		binaryTreeArr.levelOrderTraversal();
		System.out.println();
		binaryTreeArr.search("API");
		binaryTreeArr.search("React");
		binaryTreeArr.delete("BackEnd");
		binaryTreeArr.levelOrderTraversal();
		System.out.println();
		binaryTreeArr.deleteBT();
	}

	private static void binarySearchTree() {
		System.out.println("Binary Search Tree using LinkedList:");
		BinarySearchTree bstLL = new BinarySearchTree();
		bstLL.insert(100);
		bstLL.insert(125);
		bstLL.insert(135);
		bstLL.insert(120);
		bstLL.insert(60);
		bstLL.insert(55);
		bstLL.insert(80);
		bstLL.insert(85);
		bstLL.insert(70);
		bstLL.insert(65);
		bstLL.insert(75);
		bstLL.insert(68);
		bstLL.inOrder(bstLL.root);
		System.out.println();
		bstLL.preOrder(bstLL.root);
		System.out.println();
		bstLL.postOrder(bstLL.root);
		System.out.println();
		bstLL.levelOrder();
		System.out.println();
		bstLL.search(bstLL.root, 125);
		bstLL.search(bstLL.root, 400);
		bstLL.deleteNode(135);
		bstLL.deleteNode(125);
		bstLL.deleteNode(60);
		bstLL.levelOrder();
		System.out.println();
		bstLL.deleteNode(100);
		bstLL.levelOrder();
		System.out.println();
		bstLL.inOrder(bstLL.root);
		System.out.println();
		bstLL.preOrder(bstLL.root);
		System.out.println();
		bstLL.deleteBST();
	}

	private static void binaryHeap() {
		System.out.println("Min Heap: ");
		BinaryHeap minHeap = new BinaryHeap(9, "min");
		minHeap.insert(5);
		minHeap.insert(10);
		minHeap.insert(30);
		minHeap.insert(40);
		minHeap.insert(50);
		minHeap.insert(60);
		minHeap.insert(70);
		minHeap.insert(80);
		minHeap.insert(20);
		minHeap.levelOrder();
		minHeap.extractHeadOfBH();
		minHeap.extractHeadOfBH();
		minHeap.levelOrder();

		System.out.println("Max Heap: ");
		BinaryHeap maxHeap = new BinaryHeap(9, "max");
		maxHeap.insert(5);
		maxHeap.insert(10);
		maxHeap.insert(30);
		maxHeap.insert(40);
		maxHeap.insert(50);
		maxHeap.insert(60);
		maxHeap.insert(70);
		maxHeap.insert(80);
		maxHeap.insert(20);
		maxHeap.levelOrder();
		maxHeap.extractHeadOfBH();
		maxHeap.extractHeadOfBH();
		maxHeap.levelOrder();
	}

	private static void trie() {
		Trie trie = new Trie(new TrieNode());
		trie.insert("APIS");
		trie.insert("API");
		trie.insert("WATER");
		trie.insert("APPLE");
		trie.search("WATER");
		trie.delete("APIS");
		trie.search("APIS");
	}

	private static void avlTree() {
		AVLTree avl = new AVLTree();
		avl.insert(50);
		avl.insert(40);
		avl.insert(60);
		avl.insert(70);
		avl.insert(65);
		avl.levelOrder();
		System.out.println();
		avl.deleteNode(70);
		avl.deleteNode(40);
		avl.levelOrder();
	}

}
