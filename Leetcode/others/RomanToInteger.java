package others;

import java.util.HashMap;

// assume the input is valid
public class RomanToInteger {

	public static int romanToInt(String s) {

		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('M', 1000);
		m.put('D', 500);
		m.put('C', 100);
		m.put('L', 50);
		m.put('X', 10);
		m.put('V', 5);
		m.put('I', 1);

		char[] charArray = s.toCharArray();
		int res = 0;
		for (int i = 0; i < charArray.length - 1; i++) { // except the last one
			int sign;
			if (m.get(charArray[i]) < m.get(charArray[i + 1]))
				sign = -1;
			else
				sign = 1;
			res += m.get(charArray[i]) * sign;
		}
		res += m.get(charArray[s.length() - 1]); // the rightmost digit
		return res;
	}

	public static void main(String[] args) {
		String s = "CCXIV";
		System.out.println(romanToInt(s));

	}

}