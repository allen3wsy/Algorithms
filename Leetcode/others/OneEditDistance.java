package others;

/**
 * http://www.cnblogs.com/higerzhang/p/4185887.html
 */
public class OneEditDistance {

	// s is shorter than t
	public static boolean isOneDifL(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i))
				continue;
			return s.substring(i).equals(t.substring(i + 1));
		}
		return true; // meaning only the last char is different...
	}

	public static boolean isSameLen(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				count++;
		}
		return count == 1;
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		if (s.length() == t.length())
			return isSameLen(s, t);
		else if (s.length() < t.length())
			return isOneDifL(s, t);
		else
			return isOneDifL(t, s);
	}

	public static void main(String[] args) {
		String s1 = "abcm";
		String s2 = "abcmq";
		System.out.println(isOneEditDistance(s1, s2));
	}
}