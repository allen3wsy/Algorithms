import java.util.Scanner;

// System.out.printf("%-2d ", m[i][j]);
// System.out.println(sb.contains(sb)); // true !!!

public class cracking_1 {

	public static void initArr(int arr[][]) {
		int len = arr.length;
		int count = 1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j] = count++;
			}
		}
	}

	public static void printArr2(int[][] arr, int m, int n) {
		System.out.println("Print the arr2");
		String sum = "?";
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("the numbers are %-4d", arr[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.println(sum);
	}

	// 1.1
	public static boolean isUniqueChar(String s) {
		int len = s.length();
		if (len > 256)
			return false;
		int[] check = new int[256];

		for (int i = 0; i < len; i++) {
			if (check[(int) s.charAt(i)] == 1)
				return false;
			check[(int) s.charAt(i)] = 1;
		}

		return true;
	}

	/**
	 * 
	 * 1.2
	 */
	// Allen
	public static void reverseStr(char[] cArr) {
		if (cArr.length == 0 || cArr.length == 1)
			return;
		int first = 0;
		int last = cArr.length - 1;
		while (first < last) {
			char temp = cArr[first];
			cArr[first++] = cArr[last];
			cArr[last--] = temp;
			// first++;
			// last--;
		}
	}

	/**
	 * 1.3
	 */
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] rec1 = new int[256];

		// because the default array is 0
		for (int i = 0; i < s1.length(); i++) {
			rec1[(int) s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			if (--rec1[(int) s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	/**
	 * 1.4
	 */
	public static String replaceSpace(String str, int trueLength) {
		// this is a longer char[]
		char[] cArr = str.toCharArray();

		int index = str.length() - 1;

		for (int i = trueLength - 1; i >= 0; i--) {
			if (cArr[i] != ' ') {
				cArr[index--] = cArr[i];
			} else {
				// order should be %20
				cArr[index--] = '0';
				cArr[index--] = '2';
				cArr[index--] = '%';
			}
		}
		String s = new String(cArr);
		return s;
	}

	/**
	 * 1.5
	 * 
	 * @param args
	 */
	// Allen's version
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

	// CTCI's answer
	public static String compressBetter(String str) {
		if (str == null)
			return null;
		if (str.length() <= 2)
			return str;

		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);

		if (mystr.length() < str.length())
			return mystr.toString();
		else
			return str;
	}

	/**
	 * 1.7
	 * 
	 * @param arr
	 */
	public void setZeroes(int[][] matrix) {
		int m = matrix.length; // row
		int n = matrix[0].length; // column

		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n]; // 2N space

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true; // true means this row or column is equal to
									// zero
				}

			}
		}

		// set rows to zero
		for (int i = 0; i < m; i++) {
			if (row[i] == true) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// set columns to zero
		for (int j = 0; j < n; j++) {
			if (col[j] == true) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	/**
	 * 1.8
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}

		return false;
	}

	// main
	public static void main(String args[]) {
		boolean[] b = new boolean[5];
		if (isRotation("whatthefuck", "thefuckwhat")) {
			String s = "abe1dc";
			char[] sArr = s.toCharArray();
			reverseStr(sArr);
			System.out.println(sArr);
			// int[] a=new int[4];
			String str = "aabbccc"; // tested: correct
			int[][] arr = new int[5][5];
			initArr(arr);
			arr[2][3] = 0;
			arr[0][0] = 0;
			printArr2(arr, 5, 5);

			// setRC0(arr);
			printArr2(arr, 5, 5);
			System.out.println(compressStr(str));

			String[] test = new String[1000];
			Scanner in = new Scanner(System.in);
			int[] a = { 1, 2, 3, 4, 5 };
			//
			// System.out.println("please input the string:");
			// String sss = in.next();
			// if(isUniqueChar(sss)) {
			// System.out.println("it is unique!!!");
			// }
			//
			// System.out.println("finished");

			// String s = "abc/";
			// int value = s.charAt(3);
			// System.out.println("the value: " + value);

			char c = 31;
			System.out.println(c);
		}

		char[] c = { 'd', 'a', ' ' };

		System.out.println(c);
		java.util.Arrays.sort(c);
		System.out.println(c);
	}
}
