package interviewFLGT;

public class FindMaxMin {

	// int[] a = {1, 3, 5, 7, 9, 11, 10, 8, 2, 0}; // increase, then decrease
	// int[] b = {1, 3, 5, 7, 9, 11}; // edge case, no decreasing part
	// int[] c = {11, 10, 8, 2, 0}; // edge case, no increasing part

	// for b return 1, for a, c return 0
	public static int findMin(int[] a) {
		// error case
		if (a == null || a.length == 0)
			return Integer.MIN_VALUE;
		return a[0] > a[a.length - 1] ? a[a.length - 1] : a[0];
	}

	 // for a, b, c, return 11
	public static int findMax(int[] a) {
		// error
		if (a == null || a.length == 0)
			return Integer.MIN_VALUE;
		return findMax(a, 0, a.length - 1);
	}

	public static int findMax(int[] a, int left, int right) {
		while (left < right) {
			int mid = left + (right - left) / 2;
			// base case:
			// if(left == right) // length == 1
			// return a[mid];
			if (left + 1 == right) // length == 2
				return a[left] > a[right] ? a[left] : a[right];

			// compare a[mid] around: length >= 3
			if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1])
				left = mid + 1;
			else if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1])
				return a[mid];
			else
				right = mid - 1; // a[mid - 1] > a[mid] && a[mid] > a[mid + 1]
		}
		return a[left]; // length == 1
	}

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9, 11, 10, 8, 2, 0}; 
		int[] b = {1, 3, 5, 7, 9, 11}; 
		int[] c = {11, 10, 8, 2, 0}; 
		
		System.out.println(findMin(a));
		System.out.println(findMin(b));
		System.out.println(findMin(c));
		
		System.out.println(findMax(a));
		System.out.println(findMax(b));
		System.out.println(findMax(c));
	}
}
