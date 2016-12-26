package palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Title: Anagrams
 *
 * Description:
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 *
 * Solution:
 * Anagram is the kind of words that every character appears for the same times.
 * So we can construct a countMap char->count to identify a group
 *
 * Also, we can consider sort the string first
 */
public class GroupAnagrams {

	/**
	 * http://www.programcreek.com/2014/04/leetcode-anagrams-java/
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String str : strs) {
			String newstring = sortStr(str);

			if (map.containsKey(newstring)) {
				map.get(newstring).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(newstring, al);
			}
		}

		result.addAll(map.values());
		return result;
	}

	// sort the string to get the key for the hashMap
	public String sortStr(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static void main(String[] args) {
		String[] strs = { "cat", "rye", "aye", "dog", "god", "cud", "cat",
				"old", "fop", "bra" };
		GroupAnagrams a = new GroupAnagrams();
		List<List<String>> anagramList = a.groupAnagrams(strs);
		for (List<String> str : anagramList) {
			System.out.println(str);
		}
	}
}