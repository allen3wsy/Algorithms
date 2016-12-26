package palindrome;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

	/**
	 * Sliding window solution: similar to minimum window substring...
	 * {@code MinimumWindowSubstring}
	 * 
	 * http://blog.csdn.net/yy254117440/article/details/53025142
	 * 
	 * use this example to walk through:
	 * example 1: s: “cbaebabacd” p: “abc”
	 * example 2: s: “kcbaebabacd” p: “abc”
	 * 
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> result = new ArrayList<>();
		if (s == null || p == null)
			return result;
		int left = 0;
		int right = 0;
		int count = p.length(); // count is the number of char in string:p the
								// window should contain.
		int[] map = new int[256];
		char[] sCharArr = s.toCharArray();
		for (char c : p.toCharArray()) {
			map[c]++;
		}

		// Have to remember: window: [left, right)
		while (right < s.length()) {

			// always:(right++), always: (map[sCharArr[right++]]--)
			// if the window contains a char that it should cover (map[...]>= 1)
			if (map[sCharArr[right++]]-- >= 1)
				count--;
			if (count == 0)
				result.add(left);
			// If (right - left == p.length) !!!
			// then: always:(left++), always:(map[sCharArr[right++]]--)
			// map[...] >= 0 means the window contains somethign valid, but
			// since 'left' pointer is moved 1 space forward, count should ++
			if (right - left == p.length() && map[sCharArr[left++]]++ >= 0)
				count++;
		}
		return result;
	}

	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";

		System.out.print(findAnagrams(s, p));
	}
}
