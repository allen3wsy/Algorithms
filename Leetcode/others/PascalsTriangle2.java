package others;

import java.util.ArrayList;

public class PascalsTriangle2 {

	// http://blog.csdn.net/abcbc/article/details/8982651
	// THE SECOND SOLUTION: this solution is quite easier !!!
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[rowIndex + 1];
		res[0] = 1;
		if (rowIndex == 0)
			return getList(res);

		// this part is most important (most math!!! finding regularity!!! )
		for (int j = 1; j < rowIndex + 1; j++) {
			for (int i = j - 1; i > 0; i--) {
				res[i] = res[i] + res[i - 1]; // still, I don't know why it is
												// like this !!!
			}
			res[j] = 1; // and this is also hard to understand....
		}
		return getList(res);
	}

	// helper
	public ArrayList<Integer> getList(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			res.add(nums[i]);
		}
		return res;
	}
}
