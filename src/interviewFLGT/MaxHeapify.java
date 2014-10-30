package interviewFLGT;

public class MaxHeapify {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 2, 3, 0, 0, 1 };
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		buildMaxHeap(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void buildMaxHeap(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--)
			maxHeapify(arr, i);
	}

	public static void maxHeapify(int[] arr, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largestIndex = i;

		if (left < arr.length && arr[left] > arr[largestIndex])
			largestIndex = left;
		if (right < arr.length && arr[right] > arr[largestIndex])
			largestIndex = right;
		if (largestIndex != i) {
			swap(arr, i, largestIndex);
			maxHeapify(arr, largestIndex); // recurse down
		}
	}
}
