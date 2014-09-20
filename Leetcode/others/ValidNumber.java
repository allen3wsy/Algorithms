package others;

/*
 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous.
 You should gather all requirements up front before implementing one.
 */
public class ValidNumber {

	// http://rleetcode.blogspot.com/2014/01/valid-number-java.html
	// 'e' is the MOST DIFFICULT PART !!!
	public static boolean isNumber(String s) {

		if (s == null)
			return false;

		// trim off head and tail zeros which not affect result
		s = s.trim();
		if (s.length() == 0)
			return false;

		boolean canSign = true;
		boolean canDot = true;
		boolean hasNum = false;
		
		boolean canE = false;
		boolean hasE = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '+' || c == '-') {
				if (!canSign)
					return false; // can only have one-time sign !!!
				canSign = false;
				continue; // continue
			}

			if (c == '.') {
				if (!canDot)
					return false; // can only have one-time dot !!!
				canDot = false;
				canSign = false; // no sign after '.'
				continue; // continue
			}

			if (c == 'e') { // 'e' is the MOST DIFFICULT PART
				if (!canE || hasE) // canE and hasE together ...
					return false;

				canE = false; // can only have 1 'e'
				hasE = true;
				hasNum = false; // if this char is 'e', then it is temporarily
								// not number until next digit
				canDot = false; // no dot after 'e'. Actually it DEPENDS: .....
				canSign = true; // can have another sign after 'e'

				continue;
			}

			if (c >= '0' && c <= '9') { // FINALLY '0' -> '9'
				hasNum = true; // this should be true once there is a num
								// ending with a digit is ALWAYS true !!!!!!
				if (!canE && !hasE) {
					canE = true; // can have 'e' only after digit
				}
				canSign = false; // can't have a sign after a digit

			} else { // other than '0' -> '9', 'e', '.', '+', '-'
				return false; // maybe it is ' ' (space) or any stuff...
			}
		}
		return hasNum;
	}

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		// for (int i = 0; i < 3; i++) {
		// String s = scanner.nextLine();
		// System.out.println(s);
		// }
		System.out.println(isNumber("1."));
		System.out.println(isNumber("1.+"));
		System.out.println(isNumber("-2e2"));
		System.out.println(isNumber(".5e2"));
		System.out.println(isNumber("2e"));
		System.out.println(isNumber("5.e2")); // 5.0: power 2
		System.out.println(isNumber("e1")); // 'e' can't be the first
		System.out.println(isNumber(".5e2.5")); // it depends: sometimes can
												// have 1e0.5
	}
}