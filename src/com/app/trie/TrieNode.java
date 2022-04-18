package com.app.trie;

import java.util.HashMap;

public class TrieNode {

	public char data;
	public HashMap<Character, TrieNode> children = new HashMap<>();
	public boolean isEnd = false;

	// Constructor of TrieNode.
	TrieNode(char c) {
		this.data = c;
	}

}
