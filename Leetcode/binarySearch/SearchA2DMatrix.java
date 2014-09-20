package binarySearch;

// emulate the binary search
public class SearchA2DMatrix {

	// Use two binary searches: one finds the row and the other finds the
	// target. The total running time is O(logm + logn).
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		// THIS IS EXTREMELY EAST TO FORGET !!! Cuz we can't start at any row
		if (target < matrix[0][0])
			return false;

		// binary search to find the row
		int start = 0;
		int end = matrix.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid][0] == target)
				return true;
			else if (matrix[mid][0] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		// binary search to find the target
		int targetRow = end; // right now end is smaller than start !!!
		start = 0;
		end = matrix[targetRow].length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[targetRow][mid] == target)
				return true;
			else if (matrix[targetRow][mid] < target)
				start = mid + 1;
			else
				// matrix[targetRow][mid] > target
				end = mid - 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(a[0][0]);

		// 0 is smaller than matrix[0][0]
		System.out.println(searchMatrix(a, 0));
		System.out.println(searchMatrix(a, 9));

	}
}
