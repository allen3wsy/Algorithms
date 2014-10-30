package test;

public class LongestPrefixMatching {

	public static void main(String[] args) {
		Trie dictionaryTrie = new Trie();
		dictionaryTrie.insertWord("are");
		dictionaryTrie.insertWord("area");
		dictionaryTrie.insertWord("base");
		dictionaryTrie.insertWord("basement");
		dictionaryTrie.insertWord("cat");
		dictionaryTrie.insertWord("cater");

		String input = "caterer";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));

		input = "basement";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));

		input = "are";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));

		input = "arex";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));

		input = "basemexz";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));

		input = "xyz";
		System.out.print(input + ":   ");
		System.out.println(dictionaryTrie.getMatchingPrefix(input));
	}
}
