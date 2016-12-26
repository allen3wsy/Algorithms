package others;

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				swap(nums, lastNonZeroFoundAt, cur);
				lastNonZeroFoundAt++;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 3, 0, 5};
		moveZeroes(arr);
		printArray(arr);
	}
}
