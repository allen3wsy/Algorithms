package Data_structure_basic;

public class Random {

	// Math.random(): [0.0, 1.0) return double
	// [0.0, 1.0) * 101 => [0.0, 101.0) then cast it to int

	// result is: [0, 100] but there are 101 number split evenly
	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	/*
	 * pick M elements from original array. Clone original array so that we
	 * don't destroy the input.
	 */
	public static int[] pickMRandomly(int[] original) {
		for (int i = 0; i < original.length; i++) { // length is 10
			int k = rand(0, i); 					// i: [0, 9], k:[0, i] 
			int temp = original[k];
			original[k] = original[i];
			original[i] = temp;
		}
		return original;
	}

	public static void printRepeating(int arr[]) {
	  int i;
	  int size = arr.length;
	  for (i = 0; i < size; i++) {
	    if (arr[Math.abs(arr[i])] >= 0)
	      arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
	    else
	      System.out.printf(" %d ", Math.abs(arr[i]));
	  }
	}
	
	public static void main(String[] args) {
		int[] cards = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] set = pickMRandomly(cards);

		for (int i : set) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println(rand(0, 10)); // [0, 10]

		// following 2 lines are the same
		System.out.println(rand(0, 1)); // [0, 1]
		System.out.println((int) (Math.random() * 2)); // [0, 1]
		
		
		System.out.println("print repeat: ");
		int[] arr = {4, 1, 1, 4, 4};
		printRepeating(arr);
	}

}
