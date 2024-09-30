package main;

import java.util.ArrayList;
import java.util.Arrays;

//Linear probing: It places new key into closest following cell
public class LinearProbing {
	private String[] hashTable;
	private int usedCellNumber;

	public LinearProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	private int modASCIIHashFunction(String word, int m) {
		int total = 0;
		for (char c : word.toCharArray()) {
			total += c;
		}
		return total % m;
	}

	private double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0 / hashTable.length;
		return loadFactor;
	}

	// This function is used when the loadFactor is more than 0.75 (i.e., when the
	// most of the cells are filled)
	private void rehashKeys(String word) {
		System.out.println("rehashing the hashtable as loadfactor is greater than the 0.75");
		ArrayList<String> data = new ArrayList<>();
		usedCellNumber = 0;
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);
			}
		}
		data.add(word);
		for (String s : data) {
			insert(s);
		}
	}

	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = i % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word + " successfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied trying next empty cell");
				}
			}
		}
		this.usedCellNumber++;
	}

	public void printHashTable() {
		System.out.println("Hash table: " + Arrays.toString(hashTable));
	}

	public boolean search(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println(word + " is not found in HashTable");
		return false;
	}

	public void deleteKey(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " has been deleted from hash table.");
				return;
			}
		}
		System.out.println(word + " is not found in HashTable");
	}

}
