package Data_structure;

/**
 * 
 * @author Allen: KL's recursion
 *
 *
 */
public class ArrayRotation {

	public static void main(String[] args){
		int[] arr = {2,3,4,5,6,7,1};
		System.out.println(minRecusive(arr, 0, arr.length-1));
		
	}
	
	/* If the array is rotated, find the smallest element which
	 * is the reset value of the increasing array */
	public static int minOfRotatedArray(int[] arr){
		int left = 0;
		int right = arr.length-1;
		int mid = 0;
		while(left < right){
			mid = (left + right)/2;
			if(arr[mid] > arr[right]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return left;
	}
	
	// recursion version
	public static int minRecusive(int[] arr, int left, int right){
		if(left >= right)
			return left;
		int mid = (left + right)/2;
		
		if(arr[mid] > arr[right]){
			return minRecusive(arr, mid+1, right);
		}else{
			return minRecusive(arr, left, mid);
		}
	}
}
