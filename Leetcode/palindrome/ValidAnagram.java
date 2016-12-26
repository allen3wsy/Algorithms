package palindrome;

import java.util.HashMap;

/**
 * http://www.programcreek.com/2014/05/leetcode-valid-anagram-java/
 */
public class ValidAnagram {

	/**
	 * first part
	 */
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;

		int[] arr = new int[26];

		// put 2 traversal in one for loop and make it easier...
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}
		for (int i : arr) { // every digit has to be 0.
			if (i != 0)
				return false;
		}
		return true;
	}

	/**
	 * follow up question.
	 */
	public boolean isAnagram_2(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) + 1);
			} else {
				map.put(c1, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c2 = t.charAt(i);
			if (map.containsKey(c2)) {
				if (map.get(c2) == 1) {
					map.remove(c2);
				} else {
					map.put(c2, map.get(c2) - 1);
				}
			} else {
				return false;
			}
		}

		if (map.size() > 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		String str1 = "cat";
		String str2 = "cta";
		ValidAnagram a = new ValidAnagram();

		boolean b = a.isAnagram_2(str1, str2);

		System.out.println(b);
	}
}
