package binarySearch;

public class FindMinimumInRotatedSortedArray {

    // no duplicates
    public static int findMin(int[] num) {
        
        int start = 0;
        int end = num.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            // the whole array is sorted in order: (whether length == 1 or 2)
            if(num[start] < num[end])  // edge case !!!
                return num[start];
             
            if(num[start] <= num[mid]) { // left part is ordered
                start = mid + 1;// then search right part
            } else { // right part must be sorted
                end = mid; // then search left part(including mid)
            }
        }
        return num[start]; // when start == end
    }
	
	public static void main(String[] args) {
		int[] A = { 10, -1, 0, 1, 4, 6, 8 };
		System.out.println(findMin(A));
	}
}
