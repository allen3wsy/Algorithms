package others;

public class MergeSortedArray {

	// this code works !!!
	public static void merge(int A[], int m, int B[], int n) {
		while (m - 1 >= 0 && n - 1 >= 0) { // m >= 1 && n >= 0
			if (A[m - 1] >= B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m--;
			} else {
				A[m + n - 1] = B[n - 1];
				n--;
			}
		}
		while (n >= 1) { // if m == 0 but n >= 1
			A[n - 1] = B[n - 1]; // A[m + n - 1] = A[n - 1]
			n--;
		}
		// if n == 0 (whether m == 0 or m > 0, we don't have to do anything)
	}

	public static void main(String[] args) {

	}
}
