package interviewFLGT;

public class StringDistance {

	public static boolean varyByOne(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int lenDiff = Math.abs(len1 - len2);
		if (lenDiff > 1)
			return false;

		boolean varyOne = false;
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < Math.min(len1, len2); i++, p1++, p2++) {
			// boolean isSame = (s1.charAt(p1) ^ s2.charAt(p2)) == 0;
			boolean isSame = s1.charAt(p1) == s2.charAt(p2);
			if (!isSame) {
				if (varyOne) // if this is the second diff
					return false;
				varyOne = true; // means there is already a diff

				if (lenDiff == 1) {
					if (len1 < len2)
						p1--; // means: the shorter pointer keeps still
					else
						p2--; // means: the shorter pointer keeps still
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "abkm";
		String s2 = "abcmq";
		System.out.println(varyByOne(s1, s2));
	}
}