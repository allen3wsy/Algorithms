package others;

public class AddBinary {

	public String addBinary(String a, String b) {
		if (a.length() == 0 || a == null)
			return b;
		if (b.length() == 0 || b == null)
			return a;

		StringBuilder sb = new StringBuilder();

		int lastA = a.length() - 1;
		int lastB = b.length() - 1;
		int carry = 0;

		while (lastA >= 0 || lastB >= 0 || carry > 0) {

			int num1;
			if (lastA >= 0) {
				num1 = a.charAt(lastA--) - '0'; // char - char == int:
			} else {
				num1 = 0;
			}

			int num2;
			if (lastB >= 0) {
				num2 = b.charAt(lastB--) - '0'; // char - char == int
			} else {
				num2 = 0;
			}

			int digit = (num1 + num2 + carry) % 2; // EX: first digit then carry
			carry = (num1 + num2 + carry) / 2; // otherwise will cause
												// mistake...

			sb.insert(0, digit); // sb.insert(0, x) function
		}

		return sb.toString();

	}
}
