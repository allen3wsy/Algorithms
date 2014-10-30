package binarySearch;

public class FindMinimumInRotatedSortedArray2 {

	// has duplicates !!!
	public static int findMin(int[] num) {

		int start = 0;
		int end = num.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (num[start] < num[end]) // the whole array is sorted in order
				return num[start];

			if (num[start] < num[mid]) { // left part is ordered
				start = mid + 1;// then search right part
			} else if (num[start] > num[mid]) { // right part must be sorted
				end = mid; // then search left part(including mid)
			} else { // num[start] == num[mid]
				start++;
			}
		}
		return num[start];
	}

	public static void main(String[] args) {
		int[] A = { 2, 2, 2, 2, 4, 6, 8 };
		System.out.println(findMin(A));
	}
}
