package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class Anagrams {

	// http://blog.csdn.net/fightforyourdream/article/details/14217985
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs.length <= 1)
			return result;

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < strs.length; ++i) {
			String newstring = sortStr(strs[i]);
			ArrayList<String> val = map.get(newstring);
			if (val != null) {
				val.add(strs[i]);
			} else {
				val = new ArrayList<String>();
				val.add(strs[i]);
				map.put(newstring, val);
			}
		}

		Set<String> keys = map.keySet();
		// put result into the string
		for (String s : keys) {
			ArrayList<String> val = map.get(s);
			if (val.size() > 1) {
				result.addAll(val);
			}
		}
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
		Anagrams a = new Anagrams();
		ArrayList<String> anagramList = a.anagrams(strs);
		for (String str : anagramList) {
			System.out.println(str);
		}
	}
}