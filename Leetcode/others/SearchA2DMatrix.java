package others;

// emulate the binary search
public class SearchA2DMatrix {

	// Use two binary searches: one finds the row and the other finds the
	// target. The total running time is O(logm + logn).
	public static boolean search2DMatrix(int[][] matrix, int target) {
		// binary search to find the row
		int low = 0, high = matrix.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (target == matrix[mid][0])
				return true;
			else if (target < matrix[mid][0])
				high = mid - 1;
			else if (target < matrix[mid + 1][0]) {
				low = mid;
				break;
			} else
				low = mid + 1;
		}
		// binary search to find the target
		int row = low;
		low = 0;
		high = matrix[row].length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == matrix[row][mid])
				return true;
			else if (target < matrix[row][mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(a[0][0]);
		System.out.println(search2DMatrix(a, 9));

	}
}
