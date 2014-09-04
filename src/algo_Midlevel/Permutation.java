package algo_Midlevel;

// StringBuilder is used for permutation
// binarySearch

public class Permutation {
	public static void main(String[] args) {
		permutation("abcd");
	}

	/*
	 * permutation
	 */
	public static void permutation(String in) {
		StringBuilder out = new StringBuilder();
		boolean[] used = new boolean[in.length()];
		permute(in, used, out);
	}

	private static void permute(String in, boolean[] used, StringBuilder out) {
		if (out.length() == in.length()) {
			System.out.print(out.toString() + " ");
			return;
		}

		for (int i = 0; i < in.length(); i++) {
			// here we used continue
			if (used[i] == true)
				continue;

			out.append(in.charAt(i));
			used[i] = true;

			permute(in, used, out);

			used[i] = false;
			out.setLength(out.length() - 1);
		}

	}
}
