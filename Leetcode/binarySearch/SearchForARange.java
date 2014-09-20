package binarySearch;

public class SearchForARange {

	// http://gongxuns.blogspot.com/2012/12/leetcode-search-for-range.html
    // searchRange two times: for 8     Two Log(n) calls
    //  6 8 8 8 8 8 10 11 12
    // first time search 6
    // second time search rightmost 8
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0)
            return null;
        int[] res = new int[2];
        res[0] = searchMaxLessThan(A, target, 0, A.length - 1);
        res[1] = searchMaxLessThan(A, target + 1, 0, A.length - 1);
        
        if(res[0] == res[1]) {  // case: [2, 2], 9  then the result is [1,1]: 
            res[0] = -1;    // then should both be changed to [-1, -1]
            res[1] = -1;
        }else   {
            res[0]++;
        }
        return res;
    }
    
    public int searchMaxLessThan(int[] A, int target, int start, int end)   {
        
        if(start == end)            // only one number
            return A[start] < target ? start : start - 1;
        if(start == end - 1)  {             // only 2 numbers 
            if(A[end] < target)   {
                return end;
            } else if(A[start] < target)    {
                return start;
            } else  {       // A[end] >= target && A[start] >= target
                return start - 1;
            }
        }
        
        int mid = (start + end) / 2;
        if(A[mid] >= target) // when A[mid] == target, it is the same as A[mid] > target
            return searchMaxLessThan(A, target, start, mid - 1);
        else   // A[mid] < target
            return searchMaxLessThan(A, target, mid, end);
    }
}
