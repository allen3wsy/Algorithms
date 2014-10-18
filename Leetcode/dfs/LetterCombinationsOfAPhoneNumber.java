package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String input) {

		List<String> result = new ArrayList<String>();
		StringBuilder current = new StringBuilder();

		HashMap<Integer, String> letterMap = createMap();
		letterCombinations(input, 0, letterMap, current, result);
		return result;
	}

	// index is the index of the input String:
	private static void letterCombinations(String input, int index,
			HashMap<Integer, String> letterMap, StringBuilder current,
			List<String> result) {
		if (input.length() == index) { // just out of bounds !
			result.add(current.toString());
			return;
		}

		String letter = letterMap.get(input.charAt(index) - '0');
		for (int i = 0; i < letter.length(); i++) {
			current.append(letter.charAt(i));
			letterCombinations(input, index + 1, letterMap, current, result);
			current.deleteCharAt(current.length() - 1);
		}
	}

	private static HashMap<Integer, String> createMap() {
		HashMap<Integer, String> letterMap = new HashMap<Integer, String>();
		letterMap.put(0, "");
		letterMap.put(1, "");
		letterMap.put(2, "abc");
		letterMap.put(3, "def");
		letterMap.put(4, "ghi");
		letterMap.put(5, "jkl");
		letterMap.put(6, "mno");
		letterMap.put(7, "pqrs");
		letterMap.put(8, "tuv");
		letterMap.put(9, "wxyz");
		return letterMap;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("22"));
	}
}
