package sort;

// can also look at program creek !!!
// http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
// Allen's version
public class Quicksort {

	// easier to remember !!!
	public static void quickSort(int arr[], int low, int high) {
		// I: partition part
		int i = low, j = high;
		int pivot = arr[low + (high - low) / 2];

		while (i <= j) {
			// until the element >= pivot
			while (arr[i] < pivot)
				i++;
			// until the element <= pivot
			while (arr[j] > pivot)
				j--;
			if (i <= j) { // still the same condition(i <= j)
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		// II: Recursion part !!!
		if (low < j)
			quickSort(arr, low, j);
		if (i < high)
			quickSort(arr, i, high);
	}

	/**
	 * this function and the following partition function together
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void quickSortSeparate(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) { // Sort left half
			quickSortSeparate(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSortSeparate(arr, index, right);
		}
	}

	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2]; // Pick a pivot in the middle

		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (arr[left] < pivot) {
				left++;
			}
			// Find element on right that should be on left
			while (arr[right] > pivot) {
				right--;
			}
			// Swap elements, and move left and right indices
			if (left <= right) { // same as outer while loop
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		int[] array = { 3, 4, 7, 7, 1, 9, 2, 10, 8, 5, 6 };

		// quickSortSeparate(array, 0, array.length - 1);
		quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
