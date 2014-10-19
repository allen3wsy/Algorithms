package interviewFLGT;

public class SelectTopK {

	// K is from [0, num.length - 1]
	public static int selectK(int[] num, int k) {
		// error check
		if (num == null || k >= num.length)
			return 0;
		return selectHelper(num, k, 0, num.length - 1);
	}

	// select kth from subarray[l...r]
	private static int selectHelper(int[] num, int k, int l, int r) {
		if (l > r)		// exit
			return -1;
		/**
		 * if (l <= r), randomize
		 */
//		int swapIdx = new Random().nextInt(r - l + 1) + l;
//		swap(num, swapIdx, l);
		
		// get pivot idx
		int pIndex = partition(num, l, r);
		if (pIndex == k)
			return num[k];
		else if (pIndex < k)
			return selectHelper(num, k, pIndex + 1, r);
		else
			return selectHelper(num, k, l, pIndex - 1);

	}

	// partition around num[l], return pivot index
	private static int partition(int[] num, int l, int r) {
		
		//int i = low, j = high;
		//int pivot = arr[low + (high - low) / 2];
		
		int pivot = num[l];
		int i = l + 1;
		int j = r;
		while (i < j && i < r && j > l) {
			while (num[i] <= pivot && i < r)
				i++;
			while (num[j] >= pivot && j > l)
				j--;
			if (i < j && i < r && j > l)
				swap(num, i, j);
		}
		swap(num, l, j);
		return j;
	}

	private static void swap(int[] num, int l, int r) {
		int tmp = num[l];
		num[l] = num[r];
		num[r] = tmp;
	}

	public static void main(String[] args) {
		int[] A = { 3, 1, 5, 2, 4, 100};
		
		System.out.println("the index of top K: ");
		System.out.println(selectK(A, 0));
	}
}
