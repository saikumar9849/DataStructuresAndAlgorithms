package main;

import java.util.LinkedList;

//Implements the buckets as linked list
//colliding elements are sorted in this lists
public class DirectChaining {
	private LinkedList<String>[] hashTable;

	public DirectChaining(int size) {
		this.hashTable = new LinkedList[size];
	}

	private int modASCIIHashFunction(String word, int m) {
		char[] ch = word.toCharArray();
		int total = 0;
		for (char c : ch) {
			total += c;
		}
		return total % m;
	}

	public void insert(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		if (hashTable[newIndex] == null) {
			hashTable[newIndex] = new LinkedList<>();
		}
		hashTable[newIndex].add(word);
	}

	public void printHashTable() {
		System.out.println("...Hash Table...");
		for (int i = 0; i < hashTable.length; i++) {
			System.out.println("Index " + i + " Key: " + hashTable[i]);
		}
	}

	public boolean search(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
			System.out.println(word + " found in HashTable at location: " + newIndex);
			return true;
		}
		System.out.println(word + " is not found in HashTable");
		return false;
	}

	public void deleteKey(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		boolean result = search(word);
		if (result == true) {
			hashTable[newIndex].remove(word);
			System.out.println(word + " has been deleted form Hash Table");
		}
	}
}
