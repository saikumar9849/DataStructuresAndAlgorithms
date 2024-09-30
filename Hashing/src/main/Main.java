package main;

public class Main {
	public static void main(String[] args) {
		System.out.println("Direct Chaining Hashing:");
		DirectChaining hash1 = new DirectChaining(15);
		hash1.insert("apple");
		hash1.insert("animal");
		hash1.insert("balance");
		hash1.insert("budget");
		hash1.insert("frontend");
		hash1.printHashTable();
		hash1.search("animal");
		hash1.search("value");
		hash1.deleteKey("budget");
		hash1.printHashTable();

		System.out.println("\n\nLinear Probing Hashing:");
		LinearProbing hash2 = new LinearProbing(15);
		hash2.insert("apple");
		hash2.insert("animal");
		hash2.insert("balance");
		hash2.insert("budget");
		hash2.insert("frontend");
		hash2.printHashTable();
		hash2.search("animal");
		hash2.search("value");
		hash2.deleteKey("budget");
		hash2.printHashTable();

		System.out.println("\n\nQuadratic Probing Hashing:");
		QuadraticProbing hash3 = new QuadraticProbing(15);
		hash3.insert("apple");
		hash3.insert("animal");
		hash3.insert("balance");
		hash3.insert("budget");
		hash3.insert("frontend");
		hash3.printHashTable();
		hash3.search("animal");
		hash3.search("value");
		hash3.deleteKey("budget");
		hash3.printHashTable();

		System.out.println("\n\nDouble Hashing:");
		DoubleHashing hash4 = new DoubleHashing(15);
		hash4.insert("apple");
		hash4.insert("animal");
		hash4.insert("balance");
		hash4.insert("budget");
		hash4.insert("frontend");
		hash4.printHashTable();
		hash4.search("animal");
		hash4.search("value");
		hash4.deleteKey("budget");
		hash4.printHashTable();
	}
}
