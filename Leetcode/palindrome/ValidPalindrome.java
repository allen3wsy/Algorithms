package palindrome;

public class ValidPalindrome {

	// http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
	// solution is great: But I deleted 2 lines(redundant code)
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return true;

		int len = s.length();
		s = s.toLowerCase();
		int i = 0;
		int j = len - 1;

		while (i < j) {
			char left = s.charAt(i);
			char right = s.charAt(j);

			while (i < len - 1 && !isAlphaNumeric(left)) { // move right
				i++;
				left = s.charAt(i);
			}

			while (j > 0 && !isAlphaNumeric(right)) { // move left
				j--;
				right = s.charAt(j);
			}

			if (i >= j) // Don't forget this IF: this makes it really important
				break;

			if (left != right)
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}
	
	public static void main(String[] args) {
		
	}
}
