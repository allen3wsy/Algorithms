package ctci_classic;

public class CompressString {

	public static String compressStr(String s) {

		char prev = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append(prev);
		int count = 1;

		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i) == prev) {
				count++;
			} else {
				prev = s.charAt(i);
				sb.append(count);
				sb.append(prev);
				count = 1;
			}
		}
		sb.append(count);

		if (sb.toString().length() > s.length())
			return s;
		else
			return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(compressStr("asdffffff"));
	}
}
