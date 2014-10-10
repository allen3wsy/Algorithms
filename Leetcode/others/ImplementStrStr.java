package others;

public class ImplementStrStr {

	public static String strStr(String haystack, String needle) {
		int needleLen = needle.length();
		int haystackLen = haystack.length();
		if (haystack == null || needle == null) // anyone of them is null
			return null;
		if (needleLen == 0) // whether (haystackLen == 0) or not!!!
			return haystack; // (because every string has "" in it)

		for (int i = 0; i < haystackLen; i++) {
			if (haystackLen - i < needleLen) // don't do unnecessary operations
				return null; // if haystackLen < needleLen, exit immediately !!!

			int hIndex = i; // k is for: haystack (can also use: j + i instead of k)
			int nIndex = 0; // j is for: needle
			while (nIndex < needleLen && needle.charAt(nIndex) == haystack.charAt(hIndex)) {
				nIndex++;
				hIndex++;
			}
			if (nIndex == needleLen) { // if exit because nIndex == needleLen
				return haystack.substring(i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(strStr("abcde", "bc"));
		System.out.println(strStr("a", ""));
	}
}
