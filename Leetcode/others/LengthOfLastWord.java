package others;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}

		int count = 0;
		int cur = s.length() - 1;

		while (cur >= 0 && s.charAt(cur) == ' ') {
			cur--;
		}

		// EX: cur >= 0 should be put ahead............ because s.charAt(-1) may
		// cause error....
		while (cur >= 0 && s.charAt(cur) != ' ') {
			count++;
			cur--;
		}
		return count;
	}
}
