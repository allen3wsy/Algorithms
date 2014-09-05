package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	// explain:
	// http://blog.csdn.net/linhuanmars/article/details/20342851
	// solution:
	// http://gongxuns.blogspot.com/2012/12/leetcode-substring-with-concatenation.html
	// pretty much like 
	public static ArrayList<Integer> findSubstring(String S, String[] L) {

		if (L == null || L.length == 0)
			return null;
		
		int stringLength = S.length();
		int arrayLength = L.length;
		int singleLength = L[0].length(); // cuz for L that are all of the same length !!!
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		// Initialize the map: <String, Integer> !!!
		// however in Minimum Window String: we used <Character, Integer>
		Map<String, Integer> covered = new HashMap<String, Integer>();
		for (int j = 0; j < arrayLength; j++) {
			if (covered.containsKey(L[j])) {
				covered.put(L[j], covered.get(L[j]) + 1);
			} else {
				covered.put(L[j], 1);
			}
		}
		
		int i = 0;
		
		// REMEMBER this while CONDITION
		while (stringLength - i >= arrayLength * singleLength) {
			Map<String, Integer> temp = new HashMap<String, Integer>(covered);
			
			// when i == 0: "bar", "foo", when i == 1: "arf"(not in the temp hashMap), "oot"
			for (int j = 0; j < arrayLength; j++) {
				String testStr = S.substring(i + j * singleLength, i + (j + 1) * singleLength);
				
				if (temp.containsKey(testStr)) {
					if (temp.get(testStr) == 1)		// there is only 1 testStr in hashMap, then remove it
						temp.remove(testStr); 		
					else
						temp.put(testStr, temp.get(testStr) - 1);
				} else {		// temp doesn't containsKey(testStr)
					break;
				}
			}
			if (temp.size() == 0)	// which means everything in HashMap already added
				result.add(i);		// "i" is the starting position !!!
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		// String S = "barfoothefoobarmanfoobar";
		String[] L = { "foo", "bar" };
		
		
		// print out the result
		ArrayList<Integer> arrayList = findSubstring(S, L);
		System.out.println(arrayList);
	}
}
