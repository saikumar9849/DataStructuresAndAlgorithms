package trie;

public class Trie {
	private TrieNode root;

	public Trie(TrieNode root) {
		this.root = root;
	}

	// Insert a string in Trie
	// case 1: A Trie is Blank
	// case 2: New String's prefix is common to another strings prefix
	// case 3: New String's prefix is already present as complete String
	// case 4: String to be inserted is already presented in Trie.
	// TC -> O(n)
	// SC -> O(n)
	public void insert(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
	}

	// Search a string in Trie
	// case 1: String does not exist in Trie
	// case 2: String exists in Trie
	// case 3: String is a prefix of another string, but it does not exist in a
	// Trie.
	// TC -> O(n)
	// SC -> O(1)
	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode node = current.children.get(ch);
			if (node == null) {
				System.out.println(word + " doesn't exists in the Trie");
				return false;
			}
			current = node;
		}
		if (current.endOfString) {
			System.out.println(word + " exists in Trie");
			return true;
		} else {
			System.out.println(word + " doesn't exists in the Trie but it is prefix of other string");
		}
		return current.endOfString;
	}

	// Delete a string in Trie
	// case 1: Some Other prefix of String is same as the one that we want to
	// delete. (e.g:- API(del), APPLE)
	// case 2: The String is a prefix of another string. (e.g:- API(del), APIS)
	// case 3: Other String is a prefix of this String (e.g:- APIS(del), AP)
	// case 4: Not any node depends on this String (e.g:- K(del), APIS)
	// TC -> O(n)
	// SC -> O(n)
	public void delete(String word) {
		if (search(word)) {
			delete(root, word, 0);
		}
	}

	private boolean delete(TrieNode parentNode, String word, int index) {
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		if (currentNode.children.size() > 1) {
			delete(currentNode, word, index + 1);
			return false;
		}
		if (index == word.length() - 1) {
			if (currentNode.children.size() >= 1) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		if (currentNode.endOfString == true) {
			delete(currentNode, word, index + 1);
			return false;
		}
		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if (canThisNodeBeDeleted) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}

}
