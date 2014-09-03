package leetcode;

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
        if(A == null || A.length == 0)  {
            return -1;
        } else{
            return binarySearchRotatedRecursive(A, 0, A.length - 1, target);
        }
    }
    
    // helper 
    public int binarySearchRotatedRecursive(int[] a, int left, int right, int x)  {
        int mid = (left + right) / 2;
		if(x == a[mid])	{
			return mid;
		}
		if(left > right)
			return -1;

		/*
		 * EITHER the left or right half must be normally sorted(AT LEAST ONE HALF OF THEM). 
		 * Find out which side is normally 
		 * ordered, and then use the normally ordered half to figure out which side to search to 
		 * find x.
		 */

		// CASE 1:
		if(a[left] < a[mid])	{		// left is normally ordered
			if(x >= a[left] && x<= a[mid])	{
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			} else {
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			}

		// CASE 2:
		} else if(a[mid] < a[left])  {     // right is normally ordered
			if(x >= a[mid] && x <= a[right])	{
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else {
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			}
		
		// CASE 3: 
		} else {        // a[left] == a[mid]:   only 2 elements left
		    if(a[right] == x)   
		        return right;
		    else
		        return -1;
		}
    }
}
