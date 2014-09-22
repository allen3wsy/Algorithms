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

		// if any of the condition meets, we go on
		while (lastA >= 0 || lastB >= 0 || carry > 0) {
			int num1 = 0;
			if (lastA >= 0) {
				num1 = a.charAt(lastA) - '0'; // char - char == int:
				lastA--;
			}
			int num2 = 0;
			if (lastB >= 0) {
				num2 = b.charAt(lastB) - '0'; // char - char == int
				lastB--;
			}
			// EX: first digit then carry, otherwise will cause mistake...
			int digit = (num1 + num2 + carry) % 2;
			carry = (num1 + num2 + carry) / 2;

			sb.insert(0, digit); // sb.insert(0, x) function
		}
		return sb.toString();
	}
}
