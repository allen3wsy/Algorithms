package test;

import java.util.Stack;

public class LargestRectangleInHistogram {

	// http://www.tuicool.com/articles/7zUvmy
	// concept : 把資料分成一組一組的連續增加數組（波峰）然後去計算最大面
	// 複雜度O(n)原因是因為所有數字只會被掃一次，並且最多進入stack一次
	// example: {1, 3, 2, 4}: the most complicated example
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();

		int len = height.length;
		for (int i = 0; i <= len; i++) { // note: i is from [0, len]
			int curHeight;
			if (i == len) {
				curHeight = 0;// the last one should be 0
			} else {
				curHeight = height[i];
			}
			if (stack.isEmpty() || curHeight >= height[stack.peek()])
				stack.push(i);
			else { // pop out current sequence(波峰) and calculate the max area
				int curIndex = stack.pop();
				int area;
				if (stack.isEmpty()) {
					area = height[curIndex] * i;
				} else { // calculate "area" not including height[stack.peek()]
					area = height[curIndex] * (i - (stack.peek() + 1));
				}
				max = Math.max(max, area);
				i--; // so that the for-loop will i++ again
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 2, 4 }; // the most complicated example
		System.out.println(largestRectangleArea(A));
	}
}
