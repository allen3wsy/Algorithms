package others;

/**
 * Date: 2014-08-08
 * Problem -- Regular Expression Matching
 * 	Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") -> false
	isMatch("aa","aa") -> true
	isMatch("aaa","aa") -> false
	isMatch("aa", "a*") -> true
	isMatch("aa", ".*") -> true
	isMatch("ab", ".*") -> true
	isMatch("aab", "c*a*b") -> true
	
 * Summary: Backtracing within recursion
 * Link: https://oj.leetcode.com/problems/regular-expression-matching/
 * Analysis: http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 * Analysis: http://leetcode.com/2011/09/regular-expression-matching.html
 */

public class RegularExpressionMatching {
    
	public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        // p's length 1 is special case
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() == 0 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        } else { // p.length() >= 2 && p.charAt(1) == '*' (there is 'star')
            int len = s.length();
            int i = -1;
            
            while (i < len && (i < 0 || p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                if (isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
}