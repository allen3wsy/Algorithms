package others;

public class ReverseWordsInAString {

	public static String reverseWords(String s) {

		if (s == null || s.length() == 0)
			return s;

		String[] arr = s.split(" ");

		StringBuilder sb = new StringBuilder();

		for (String str : arr) {
			if (!str.equals("")) {
				sb.insert(0, str);
				sb.insert(0, " ");
			}
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("  a  b c   d "));
	}
}
