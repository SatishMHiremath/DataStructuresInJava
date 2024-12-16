package com.test.nonlineardsa;

class Trie {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return current.isEndOfWord;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // Output: true
		System.out.println(trie.search("app"));   // Output: false
	}
}
