package palindrome;

public class PalindromeNumber {

	// http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
	public static boolean isPalindrome(int x) {
		// negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10; // div will be: 1, 10, 100, 1000...
		}

		// use the case: x = 565, now div = 100
		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10; // get rid of the leftmost and rightmost number
			// x: from 565 to 6
			div /= 100; // delete 2 0's
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(565));
	}
}
