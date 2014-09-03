package leetcode;

import java.util.Stack;

public class MaximalRectangle {

	// http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
	// http://rleetcode.blogspot.com/2014/01/maximal-rectangle-java.html
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int[][] height = new int[m][n + 1];

		// actually we know that height can just be a int[n+1],
		// however, in that case, we have to write the 2 parts together in row
		// traverse, which leetcode just doesn't make you pass big set
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					if (i == 0)
						height[i][j] = 1;
					else
						height[i][j] = height[i - 1][j] + 1;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			int area = maxAreaInHist(height[i]);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	private static int maxAreaInHist(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, height[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// 1, 1, 1, 0
		// 1, 0, 0, 1
		// 1, 0, 0, 0
		// 1, 0, 0, 0 result should be 4
		char[][] matrix = { { '1', '1', '1', '0' }, { '1', '0', '0', '1' },
				{ '1', '0', '0', '0' }, { '1', '0', '0', '0' } };
		int result = maximalRectangle(matrix);
		System.out.println(result);

	}
}
