package others;

import java.util.ArrayList;

public class TextJustification {

	// last word. no extra space between words.
//	String temp = result.get(result.size() - 1);
//	if (temp.length() < L) {
//		while (temp.length() < L) {
//			temp += " ";
//		}
//	} else if (temp.length() > L) {			//  Pay attention HERE !!! REMEMBER THIS CASE !!!
//		// NOT necessary ? because temp.length() can never be larger than L
//		// If I have already deleted the rightmost " "
//		// Wrong Answer !!!
//		// Input:	[""], 0
//		// Output:	[" "]
//		// Expected:	[""]
//		temp = temp.substring(0, L);
//		
//	}
//	result.set(result.size() - 1, temp);
	
	// http://blog.csdn.net/Muscler/article/details/28644143
	// http://www.cnblogs.com/lautsie/p/3254036.html
	// String[] words = {"This", "is", "an", "example", "of", "text",
	// "justification."};
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		int size = words.length;
		int currentLength = 0;
		// String tmp = "";
		StringBuilder sb = new StringBuilder();

		// result = "This is an ", "example of text ", "justification. "
		for (int i = 0; i < size; i++) {
			currentLength += words[i].length() + 1; // 5, 8, 11,
			if (currentLength > L + 1) { // if currentLength == L + 1 (Still OK)
				sb.deleteCharAt(sb.length() - 1); // delete the rightmost " "
				String temp = sb.toString();
				result.add(temp);
				sb = new StringBuilder();
				currentLength = 0;
				--i; // Don't forget this !!!
			} else { // currentLength <= L + 1
				sb.append(words[i]).append(" ");
			}
		}
		// the last word. "justificaion. "
		if (sb.length() != 0)
			result.add(sb.toString());

		// iterate through RESULT except the last one(which is the last string
		// and it should be pushed to the LEFT, no extra spaces between words)
		for (int i = 0; i <= result.size() - 2; i++) {
			// i = 1, temp = "example of text "
			String temp = result.get(i);
			String[] tmpStrArray = temp.split(" ");
			int totoalLength = 0;

			// last one of tmpStrArray is "" ??? NOT IF rightmost one is deleted
			for (int j = 0; j < tmpStrArray.length; ++j) {
				totoalLength += tmpStrArray[j].length();
			}

			// totoalLength = 13, L = 16, numOfString = 3, freeSpace = 16 - 13 =
			// 3.
			// spaceCount = {2, 1, 0}
			int[] spaceCount = getSpaceCount(L - totoalLength,
					tmpStrArray.length);
			// System.out.println("haha: " + tmpStrArray.length);

			StringBuilder sb2 = new StringBuilder();

			for (int j = 0; j < tmpStrArray.length; j++) {
				sb2.append(tmpStrArray[j]);
				for (int k = 0; k < spaceCount[j]; k++) {
					sb2.append(" ");
				}
			}
			// sb2 = "example  of text"
			result.set(i, sb2.toString());
		}

		// last word. no extra space between words.
		String temp = result.get(result.size() - 1);
		if (temp.length() < L) {
			while (temp.length() < L) {
				temp += " ";
			}
		} else  {    // temp.length() >= L, then cut the trailing zeros !!!			
			//  Pay attention HERE !!! REMEMBER THIS CASE !!!
			// NOT necessary ? because temp.length() can never be larger than L
			// If I have already deleted the rightmost " "
			//  Wrong Answer !!!
			// Input:	[""], 0
			// Output:	[" "]
			// Expected:	[""]
			temp = temp.substring(0, L);
			
		}
		result.set(result.size() - 1, temp);

		return result;
	}

	// calculate how many " " should be assigned after each substring in a
	// string
	public static int[] getSpaceCount(int freeSpace, int numOfString) {
		int size = numOfString - 1; // size == 2
		int[] result = new int[numOfString]; // numOfString == 3

		if (size == 0) {
			result[0] = freeSpace;
		} else {
			for (int i = 0; i <= result.length - 2; i++) { // result[N-1] is
															// still 0
				result[i] = freeSpace % size == 0 ? freeSpace / size
						: freeSpace / size + 1; // freeSpace == 3
				freeSpace -= result[i]; // think about 8 / 3 !!!!!! (compare 7 / 3)
				size--; 				// then 5 / 2 (4 / 2)
			} 							// then 2 / 1 (2 / 1)
		}
		return result;
	}

	// main
	public static void main(String[] args) {
		// This is an ", "example of text ", "justification. "
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		System.out.println(fullJustify(words, 16));

		// EX: if there are 2 or more spaces and we do a split " ", then there
		// are too many ""
		// String s = "a  d  c";
		// String[] sa = s.split(" ");
		// System.out.println(sa.length);
		//
		// // EX: trailing empty strings are not included in the final array
		// String ss = " a b c       ";
		// String[] ssa = s.split(" ");
		// System.out.println(ssa.length);
		String ss = "a/..";
		String[] ssa = ss.split("/");
		System.out.println(ssa.length);
	}
}
