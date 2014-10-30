package interviewFLGT;

/**
 * https://en.wikipedia.org/wiki/Quicksort
 * 
 * @author AllenNg
 */
public class Quicksort {

	private static void swap(int[] num, int left, int right) {
		int temp = num[left];
		num[left] = num[right];
		num[right] = temp;
	}

	// return the pivot index from[l, r]
	private static int partition(int[] num, int left, int right) {
		/**
		 * if we pick a pivot in the middle, we can swap it to num[right]
		 */
		int pValue = num[right];// choose the rightmost element as pivot
		int storeIndex = left;// start from left of the subarray.

		// for-loop swap all the elements that are smaller than the pivot.
		for (int i = left; i <= right - 1; i++) {
			if (num[i] <= pValue) {
				swap(num, i, storeIndex);
				storeIndex++;
			}
		}
		// storeIndex should be the correct index for pivot
		num[right] = num[storeIndex];
		num[storeIndex] = pValue; // pValue to the pivot
		return storeIndex; // which is the pivot index to return
	}

	public static void quicksort(int[] num, int i, int j) {
		if (i < j) {
			// pIndex is always within [i,j]
			int pIndex = partition(num, i, j);
			quicksort(num, i, pIndex - 1);
			quicksort(num, pIndex + 1, j);
		}
	}

	public static void main(String[] args) {
		int[] num = { 56, 2, 2, 0, 1, 1, 4, 5, 5, 7, 3 };
		int[] num2 = { 5, 7, 6, 3 };

		quicksort(num, 0, num.length - 1);
		quicksort(num2, 0, num2.length - 1);

		for (int i = 0; i < num.length; ++i) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < num2.length; ++i) {
			System.out.print(num2[i] + " ");
		}
		
	}
}
