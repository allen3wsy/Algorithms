package interviewFLGT;

public class A_ZToNumber {

	public static String a_zToNumber(int n) {
		StringBuilder builder = new StringBuilder();
		while (n > 0) {
			char c = n % 26 == 0 ? 'z' : (char) ('a' + n % 26 - 1);
			builder.append(c);
			if (c == 'z') {
				n -= 26;
			} else {
				n -= (c - 'a') % 26 + 1;
			}
			n /= 26;
		}
		return builder.reverse().toString();
	}

	public static void main(String[] args) {

	}
}
