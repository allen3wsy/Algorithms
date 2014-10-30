package others;

import java.util.ArrayList;

/**
 * Date: 2014-08-09 Problem -- Wildcard Matching {Others} Implement wildcard
 * pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") -> false isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false isMatch("aa", "*") -> true isMatch("aa", "a*")
 * -> true isMatch("ab", "?*") -> true isMatch("aab", "c*a*b") -> false
 */

public class WildcardMatching {

	// http://blog.csdn.net/muscler/article/details/29198653
	// easier than regular expression matching !!!

	// "*" is ".*" now
	// "?" is "." now
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		int sLength = s.length();
		int pLength = p.length();
		int i = 0; // index of s
		int j = 0; // index of p
		int starIndex = -1; // the index of star in P
		int afterStar = -1; // index of S that matches (right after '*' in P)

		// if (i matches j || p.charAt(j) == '?'), i++ & j++. afterStar,
		// starIndex, record the positon of '*' in s and p, j++ and go on.
		// if not match, go back to star, ++afterStar
		while (i < sLength) {
			if (j < pLength
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) { // match
				i++;
				j++;
			} else if (j < pLength && p.charAt(j) == '*') { // p.charAt(j) ==
															// '*'
				starIndex = j;
				afterStar = i;
				j++; // j will never stay at the '*' position

			} else if (starIndex != -1) { // (i) and (j) don't match but there
											// is a former '*'
				afterStar++; // means one more char will be consumed by '*'
				i = afterStar;
				j = starIndex + 1; // j will always stay at the next right of
									// '*' until MATCHES !!!
			} else { // (i) and (j) don't match && posStar == -1(no '*' so far)
				return false;
			}
		}

		while (j < pLength && p.charAt(j) == '*') { // trailing '*' in p
			j++; // until p.charAt(j) != '*' || j == pLength
		}

		// Of course: (i == sLength)
		return j == pLength; // both i & j exceed the range
	}

	public static void main(String[] args) {

		String s = "cabcaabcb";
		String p = "c*a*b";
		System.out.println(isMatch(s, p));

	}
}
