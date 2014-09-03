package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (Character c : charArray) {
			if (map.keySet().contains(c)) {
				stack.push(c);
			} else { // if (map.values().contains(c))
				if (!stack.isEmpty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty(); // be careful here because maybe the input is like: "("
								// maybe the size() is odd number
	}
}
