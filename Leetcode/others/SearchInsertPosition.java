package others;

public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
        int left = 0;
		int right = A.length - 1;
		// mid = 0  should be more clear
		int mid = (left + right) / 2;  
		
		// important: must be left <= right !!!!!!!
		// when left == right, we still have to check whether whether
		// this mid is equal to val, if not: return -1
		while(left <= right)	{
			mid = (left + right) / 2;
			
			if(target < A[mid])	{
				right = mid - 1;
			} else if(A[mid] < target)	{
				left = mid + 1;
			} else	{	// equal
				return mid;
			}			
		}		
		return left; 
    }
}
