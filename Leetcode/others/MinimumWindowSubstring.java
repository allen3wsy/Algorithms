package others;

import java.util.HashMap;

public class MinimumWindowSubstring {

	/**
	 * simple solution: There is a template for sliding window similar to
	 * {@code FindAllAnagramsInAString}
	 * 
	 * http://blog.csdn.net/yy254117440/article/details/53025142
	 * 
	 */
	public static String minWindow(String S, String T) {
		if (S == null || T == null)
			return null;
		if (S.length() < T.length() || S.length() == 0)
			return "";

		String result = "";
		int left = 0, right = 0, count = T.length(), minLen = Integer.MAX_VALUE;

		int[] map = new int[256];
		for (char tc : T.toCharArray())
			map[tc]++;
		char[] sc = S.toCharArray();

		while (right < S.length() || count == 0) {
			if (count == 0) {
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					result = S.substring(left, right);
				}
				if (map[sc[left++]]++ >= 0)
					count++;
			} else {
				if (map[sc[right++]]-- >= 1)
					count--;
			}

		}
		return result;
	}

	/**
	 * This solution is easier to understand...
	 */
	// http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
	// http://huntfor.iteye.com/blog/2083485
	// S is the string that contains T !!!
	// S = "e b a d b a c c b", T = "abc" for example !!!
	// S = "cakbkkkkabc", T = "abc" for example !!!
	public static String minWindow_2(String S, String T) {
		if (S == null || T == null)
			return null;
		if (S.length() < T.length() || S.length() == 0)
			return "";

		HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> alreadyFound = new HashMap<Character, Integer>();

		// initializing 2 hashMaps !!!
		for (int i = 0; i < T.length(); i++) {
			alreadyFound.put(T.charAt(i), 0); // don't forget to init this map

			// needFind hashMap will never change once initialized !!!
			if (needFind.containsKey(T.charAt(i)))
				needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
			else
				needFind.put(T.charAt(i), 1);
		}
		int windowStart = -1; // p
		int windowEnd = S.length();

		int len = 0; // length of current window
		int start = 0; // start is the start point of window
		for (int i = 0; i < S.length(); i++) { // i is the current end point of
												// window
			if (alreadyFound.containsKey(S.charAt(i))) {
				alreadyFound
						.put(S.charAt(i), alreadyFound.get(S.charAt(i)) + 1);

				if (alreadyFound.get(S.charAt(i)) <= needFind.get(S.charAt(i)))
					len++; // important !!!

				// when it reaches "c", then (len == 3), then SQUEEZE THE WINDOW
				// from left hand side, but len never goes less anymore
				if (len == T.length()) {
					// this WHILE CONDITION MUST BE REMEMBERED !!!
					// (S.charAt(start) !!!)
					while (!needFind.containsKey(S.charAt(start))
							|| alreadyFound.get(S.charAt(start)) > needFind
									.get(S.charAt(start))) {
						if (needFind.containsKey(S.charAt(start))) // the latter
																	// condition
																	// meets !!!
							alreadyFound.put(S.charAt(start),
									alreadyFound.get(S.charAt(start)) - 1);
						start++;
					}
					// if the new window size is smalle than the older one, then
					// update it
					if (i - start < windowEnd - windowStart) {
						windowStart = start;
						windowEnd = i;
					}
				}
			}
		}
		if (windowStart == -1) // which means "len never reaches T.length" (not
								// found) !!!
			return "";
		return S.substring(windowStart, windowEnd + 1); // [minStart, minEnd +
														// 1)
	}

	public static void main(String[] args) {
		String S1 = "ebadbaccb";
		String T1 = "abc";
		System.out.println(minWindow(S1, T1));

		String S2 = "cakbkkkkabc";
		String T2 = "cba";
		System.out.println(minWindow(S2, T2));

		String S3 = "ADOBECODEBANC";
		String T3 = "BCA";
		System.out.println(minWindow(S3, T3)); // as the title suggested
	}
}
