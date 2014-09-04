package leetcode;

import java.util.Arrays;

public class ScrambleString {

	// EXPLAIN : !!!
	// http://blog.csdn.net/fightforyourdream/article/details/17707187
	// http://blog.csdn.net/fightforyourdream/article/details/17707187
	// http://rleetcode.blogspot.com/2014/01/scramble-string-java.html
	public static boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		// check if s1 and s2 has same chars (NOT necessarily using HashMap !!!)
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		Arrays.sort(s1Char);
		Arrays.sort(s2Char);

		if (!new String(s1Char).equals(new String(s2Char)))
			return false;

		// i: from [1, N - 1]: they add up to N
		// N - i：[N - 1, 1] : still add up to N
		for (int i = 1; i < s1.length(); i++) {
			String s1Left = s1.substring(0, i);
			String s1Right = s1.substring(i);

			String s2Left = s2.substring(0, i);
			String s2Right = s2.substring(i);

			// EX: if not, it's not necessarily false !!! should still try another half
			if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right))
				return true;
			
			// N - i：[N - 1, 1] : still add up to N
			s2Left = s2.substring(s2.length() - i);		// right side
			s2Right = s2.substring(0, s2.length() - i); // left side

			if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right))
				return true;
		}

		// after traversing, still not true, then false !
		return false;	
	}
	
	public static void main(String[] args) {
		
		// for 3 characters, "abc", "bac".... they are all interchangeable
		
		// In fact， for "abcd", only "bdac" and "cadb" are not true
		// 2 out of 23 are not scrambled string of "abcd"
		System.out.println(isScramble("abcd", "bdac"));
		System.out.println(isScramble("abcd", "cadb"));
		
		// rest of the strings are all true
		
	}
}
