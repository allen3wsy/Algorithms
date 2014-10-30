package others;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Author: Prince Cheung a better solution: O(N) time always
	 */
	// use the case: abcbam: the second a is not counted as duplicate
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int N = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int startIndex = 0;
		int maxLength = 0;

		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int prevPosition = map.get(c);
				if (startIndex <= prevPosition && prevPosition < i) { // repeat!
					maxLength = Math.max(maxLength, i - startIndex);
					startIndex = prevPosition + 1;
				}
			}
			map.put(c, i); // always put it to map
		}
		maxLength = Math.max(maxLength, N - startIndex); // last update
		return maxLength;
	}

	public static void main(String[] args) {
		int len = lengthOfLongestSubstring("abcqwer");
		int len2 = lengthOfLongestSubstring("abcc");
		System.out.println(len);
		System.out.println(len2);
	}

	/**
	 * Analysis: REMEMBER THE PICTURE !!!
	 * http://blog.csdn.net/likecool21/article/details/10858799
	 * using HashMap: O(N squared):
	 */
	// http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/

	// public static int lengthOfLongestSubstring(String s) {
	//
	// char[] array = s.toCharArray();
	// int curMax = 0;
	// HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	//
	// for (int i = 0; i < array.length; i++) {
	// if (!map.containsKey(array[i])) {
	// map.put(array[i], i);
	// } else { // we find a duplicate in the map
	// curMax = Math.max(curMax, map.size());
	// i = map.get(array[i]); // then i will ++ later
	// map.clear(); // clean it ! and scan again from this position + 1
	// }
	// }
	// // maybe we reach the end and still don't have 1 repeated
	// curMax = Math.max(curMax, map.size());
	// return curMax;
	// }
}
