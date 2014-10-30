package others;

import java.util.Stack;

public class LongestValidParentheses {

	// ( ( ) ( ) : for this case... maxLen = i - stack.peek(): ANSWER: 4
	// EX: ( ( ) ( ( ( ) : for this case.... SEPARATOR is left paren, ANSWER: 2
	// ( ) ) ) ( ) : for this case.... SEPARATOR is right paren, ANSWER: 2
	
	// http://www.cnblogs.com/lichen782/p/leetcode_Longest_Valid_Parentheses.html
	// http://rleetcode.blogspot.com/2014/01/longest-valid-parentheses.html

	// NOTE: there are 2 times of checking whether stack.isEmpty().....
	// 1: we get an ')' then we check if it is empty.
	// 2: if not Empty, then after poping one left paren from the stack, check
	// the second time whether stack.isEmpty() again
	/**
	 * NOTE: (int: last) record the position before first left parenthesis
	 */
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
			
		int last = -1; /* This is the most tricky part !!! */
		int maxLen = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (stack.isEmpty()) { // ')' && stack.isEmpty()
				last = i; // record the position before first left parenthesis
			} else { // ')' but stack is not Empty()
				stack.pop(); // pop the left paren out...
				if (stack.isEmpty()) { // meaning complete parentheses !!!
					maxLen = Math.max(i - last, maxLen);
				} else { // if stack is not empty
					maxLen = Math.max(i - stack.peek(), maxLen);
				}
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = ")()()"; // length is 5 : answer is 2

		String s2 = "(()((()"; // EX:.... answer is still 2
		String s3 = "(()((()))"; // EX:.... answer should be 8

		System.out.println(longestValidParentheses(s2));
		System.out.println(longestValidParentheses(s3));

	}
}
