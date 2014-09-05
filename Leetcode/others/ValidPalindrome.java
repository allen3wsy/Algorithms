package others;

public class ValidPalindrome {

	// http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
	// solution is great: But I deleted 2 lines(redundant code)
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return true;

		int len = s.length();
		int i = 0;
		int j = len - 1;

		while (i < j) {
			char left = s.charAt(i);
			char right = s.charAt(j);

			while (i < len - 1 && !isAlpha(left) && !isNum(left)) { // move
																	// right
				i++;
				left = s.charAt(i);
			}

			while (j > 0 && !isAlpha(right) && !isNum(right)) { // move left
				j--;
				right = s.charAt(j);
			}

			if (i >= j) // Don't forget this IF: this makes it really important
				break;

			if (!isSame(left, right))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isAlpha(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;
		else
			return false;
	}

	public boolean isNum(char c) {
		if (c >= '0' && c <= '9')
			return true;
		else
			return false;
	}

	// e.g. to decide if 'a' == 'A'
	public boolean isSame(char a, char b) {
		if (isNum(a) && isNum(b)) {
			return a == b;
		} else if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
			return true;
		} else {
			return false;
		}
	}
}
