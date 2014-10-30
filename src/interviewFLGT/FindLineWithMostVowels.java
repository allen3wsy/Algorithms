package interviewFLGT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindLineWithMostVowels {

	// vowels: a, e, i, o, u, A, E, I, O, U
	// either one with most vowels
	// duplicates strings

	// “abc” “” “ppp”
	// “abc”
	public static String findLineWithMostVowels(List<String> lines) {
		Set<Character> set = constructSet();
		int maxVowels = 0;
		String result = null; // has most vowels
		if (lines == null) // error case
			return result;

		for (String string : lines) {
			int curCount = countVowels(string, set);
			if (curCount >= maxVowels) {
				result = string;
				maxVowels = curCount;
			}
		}
		return result; // string that has max vowels
	}

	public static Set<Character> constructSet() {
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		return set;
	}

	public static int countVowels(String s, Set<Character> set) {
		int count = 0;
		// empty string? not null
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i)))
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// “abc” “” “ppp”
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("abc");
		lines.add("");
		lines.add("pppoeiuuu");
		System.out.println(findLineWithMostVowels(lines));
		
	}

}
