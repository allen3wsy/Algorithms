package interviewFLGT;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Last_not_repeated {

	public static char findLast(String s) {

		// last is the Last_not_repeated one
		char last = 0;
		Map m = new HashMap<Character, Integer>();
		int length = s.length();
		int count = 0;

		// set up the hashmap
		char temp;
		char change = 0;
		for (int i = 0; i < length; i++) {
			temp = s.charAt(i);
			// if not: add
			if (!m.containsKey(temp))
				m.put(temp, i);
			else {
				m.put(temp, -1);
			}
		}

		Set<Map.Entry<Character, Integer>> allSet = null;
		allSet = m.entrySet();
		Iterator<Map.Entry<Character, Integer>> iter = null;
		iter = allSet.iterator();

		// max means the last but not repeated one
		int max = 0;
		while (iter.hasNext()) {
			Map.Entry<Character, Integer> me = iter.next();
			System.out.println(me.getKey() + ", " + me.getValue());

			if (me.getValue() > max) {
				max = me.getValue();
				last = me.getKey();
			}
		}
		return last;
	}

	// right: but we don't have to use -1
	// A better version would be: find the first char with 1
	public static char first_not_repeated(String input) {
		if (input == null || input.length() == 0)
			return ' ';

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, -1);
			} else {
				map.put(ch, i);
			}
		}
		// we'd better use this value
		int min = Integer.MAX_VALUE;
		char result = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			if (value != -1) {
				if (value < min) {
					min = value;
					result = entry.getKey();
				}
			}
		}
		return result;
	}

	/*
	 * A better version for first_not_repeated Simpler version of that
	 */
	public static Character firstNotRepeat(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			if (map.get(key) == 1) {
				return key;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String s = "abbcdeeff";
		System.out.println(findLast(s));
		System.out.println(first_not_repeated(s)); // right
		System.out.println(firstNotRepeat(s)); // also right
	}

}
