package main;

import java.util.ArrayList;
import java.util.Arrays;

//Double Hashing: Interval between probes is computed by another hash function (combination of two Hash functions)
public class DoubleHashing {
	private String[] hashTable;
	private int noOfCellsUsedInHashTable;

	public DoubleHashing(int size) {
		hashTable = new String[size];
		noOfCellsUsedInHashTable = 0;
	}

	// First Hash Function
	private int modASCIIHashFunction(String word, int m) {
		int total = 0;
		for (char c : word.toCharArray()) {
			total += c;
		}
		return total % m;
	}

	// Helper method for second Hash Function method
	private int addAllDigitsTogether(int sum) {
		int value = 0;
		while (sum > 0) {
			value = sum % 10;
			sum = sum / 10;
		}
		return value;
	}

	// Second Hash Function
	private int secondHashFunction(String s, int m) {
		int i, sum;
		char[] ch = s.toCharArray();
		for (sum = 0, i = 0; i < s.length(); i++) {
			sum += ch[i];
		}
		while (sum > hashTable.length) {
			sum = addAllDigitsTogether(sum);
		}
		return sum % m;
	}

	private double getLoadFactor() {
		double loadFactor = noOfCellsUsedInHashTable * 1.0 / hashTable.length;
		return loadFactor;
	}

	// This function is used when the loadFactor is more than 0.75 (i.e., when the
	// most of the cells are filled)
	private void rehashKeys(String word) {
		System.out.println("rehashing the hashtable as loadfactor is greater than the 0.75");
		ArrayList<String> data = new ArrayList<>();
		noOfCellsUsedInHashTable = 0;
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
			int x = modASCIIHashFunction(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for (int i = 0; i < hashTable.length; i++) {
				int newIndex = (x + i * y) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word + " successfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied trying next empty cell");
				}
			}
		}
		this.noOfCellsUsedInHashTable++;
	}

	public void printHashTable() {
		System.out.println("Hash table: " + Arrays.toString(hashTable));
	}

	public boolean search(String word) {
		int x = modASCIIHashFunction(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		for (int i = 0; i < hashTable.length; i++) {
			int newIndex = (x + i * y) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println(word + " is not found in HashTable");
		return false;
	}

	public void deleteKey(String word) {
		int x = modASCIIHashFunction(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		for (int i = 0; i < hashTable.length; i++) {
			int newIndex = (x + i * y) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " has been deleted from hash table.");
				return;
			}
		}
		System.out.println(word + " is not found in HashTable");
	}

}
