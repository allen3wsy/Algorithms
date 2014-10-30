package test;

/**
 * Date: 2014-10-07
 * Problem -- Longest Common Prefix
 * Link: https://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * Summary: Note the comparison between Trie-based solution and Scanning-based
 * 	solution.
 */
import java.util.HashMap;

/**
 * Solution class for Leetcode
 * 
 * @author AllenNg
 */
public class LongestCommonPrefix_Trie {
	public String longestCommonPrefix(String[] strs) {
		Trie trie = new Trie();
		for (String word : strs)
			trie.insertWord(word);

		return trie.findLongestCommonPrefix();
	}
}

/**
 * Actually don't have to have "char value"
 * 
 * @author AllenNg
 */
class TrieNode {
	HashMap<Character, TrieNode> childrenMap;
	boolean isEnd;

	public TrieNode() {
		childrenMap = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}

/**
 * @author AllenNg
 */
class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insertWord(String word) {
		TrieNode crawl = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			HashMap<Character, TrieNode> children = crawl.childrenMap;

			if (children.containsKey(ch))
				crawl = children.get(ch);
			else {
				TrieNode child = new TrieNode();
				children.put(ch, child);
				crawl = child;
			}
		}
		crawl.isEnd = true;
	}

	/**
	 * this method is for findLongestCommonPrefix
	 */
	public String findLongestCommonPrefix() {
		StringBuilder result = new StringBuilder();
		TrieNode crawl = root;

		while (!crawl.isEnd && crawl.childrenMap.size() == 1) {
			for (Character ch : crawl.childrenMap.keySet()) {
				result.append(ch);
				crawl = crawl.childrenMap.get(ch);
			}
		}
		return result.toString();
	}

	/**
	 * this method is for matching Longest Prefix
	 */
	public String getMatchingPrefix(String input) {
		StringBuilder result = new StringBuilder(); // Initialization
		int length = input.length(); // Find length of the input string
		TrieNode currNode = root; // Initialize runner to traverse down

		// Iterate all characters of input "str" and traverse down the Trie
		int prevMatch = 0;
		for (int level = 0; level < length; level++) {
			char ch = input.charAt(level); // current char
			HashMap<Character, TrieNode> cMap = currNode.childrenMap;

			if (cMap.containsKey(ch)) {
				result.append(ch); // Update result
				currNode = cMap.get(ch); // Update currNode: move down in Trie

				if (currNode.isEnd) { // If it's end of a word, update prevMatch
					prevMatch = level + 1; // level + 1 !!! (EX)
				}
			} else { // map doesn't containsKey
				break;
			}
		}
		// If last processed char did not match end of word, return prevMatch
		if (!currNode.isEnd)
			return result.substring(0, prevMatch);
		else
			return result.toString();
	}
}