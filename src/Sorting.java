import java.util.Arrays;
import java.util.*;

public class Sorting {
	public static void main(String[] args){
//		int[] arr = {3,2,5,6,1,52,8};
//		System.out.println(Arrays.toString(arr));
//		quickSort(arr, 0, arr.length-1);
//		System.out.println(Arrays.toString(arr));
//		int[] a = {1,3,5,7,0,0,0};
//		int[] b = {2,4,6};
//		sortAB(a,b);
//		System.out.println(Arrays.toString(a));
		
		String arr[] = {"avc" , "", "", "ball", "","ccc", ""};
		//groupAnagram(arr);
		System.out.println(findString(arr, "ccc"));
		
		
		
//		int[] arr = {14,14,19,20,25,1,3,4,5,7,10,14};
//		System.out.println(binarySearchRotated(arr, 14));
	}
	
	public static void bubble(int[] arr){
		System.out.println("bubble sort:");
		for(int i=0; i<arr.length; i++){
			boolean isSwap = false;
			for(int j=1; j<arr.length-i; j++){
				if(arr[j-1] > arr[j]){
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
					isSwap = true;
				}
			}
			if(!isSwap) break;
		}
	}
	
	public static void selection(int[] arr){
		System.out.println("selection sort");
		for(int i=0; i<arr.length; i++){
			int minIndex = i;
			for(int j=i; j<arr.length; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
	}
	
	public static void insertion(int[] arr){
		System.out.println("insertion sort:");
		for(int i=0; i<arr.length; i++){
			for(int j=i; j>0; j--){
				if(arr[j] < arr[j-1])	{
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}	else
					break;          //already sorted
			}
		}
	}
	
	public static void mergeSort(int[] arr, int[] helper, int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid+1, high);
			merge(arr, helper, low, mid, high);
		}
	}
	
	public static void merge(int[] arr, int[] helper, int low, int mid, int high){
		for(int i=low; i<=high; i++){
			helper[i] = arr[i];
		}
		
		int helperLeft = low;
		int helperRight = mid+1;
		int curr = low;
		
		while(helperLeft <= mid && helperRight <= high){
			if(helper[helperLeft] <= helper[helperRight]){
				arr[curr++] = helper[helperLeft++];
			}else{
				arr[curr++] = helper[helperRight++];
			}
		}
		
		int remain = mid - helperLeft;
		for(int i=0; i <= remain; i++){
			arr[curr+i] = helper[helperLeft+i];
		}
	}
	
	public static void mergeSort(int[] arr){
		System.out.println("merge sort:");
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int left, int right){
		int index = partition(arr, left, right);
		if(left < index-1){
			quickSort(arr, left, index-1);
		}
		if(index < right){
			quickSort(arr, index, right);
		}
	}
	
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[(left+right)/2];
		
		while(left <= right){
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			if(left <= right){
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				
				left++;
				right--;
			}
		}
		return left;
	}
	
	
	/**
	 * 11.1
	 */
	public static void sortAB(int[] aArr, int[] bArr){
		int a = aArr.length-bArr.length-1;
		int b = bArr.length-1;
		int index = aArr.length-1;
		
		while(b >= 0 && a >= 0){
			if(a>=0 && aArr[a] > bArr[b]){
				aArr[index--] = aArr[a];
				a--;
			}else{
				aArr[index--] = bArr[b];
				b--;
			}
		}
	}
	
	/**
	 * 11.2
	 */
	public static String sortChars(String s){
		char[] carr = s.toCharArray();
		Arrays.sort(carr);
		return new String(carr);
	}
	
	public static void groupAnagram(String[] sarr){
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String s : sarr){
			String key = sortChars(s);
			if(map.containsKey(key)){
				List<String> list = map.get(key);
				list.add(s);
			}else{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(key, list);
			}
		}
		
		int index = 0;
		for(String key : map.keySet()){
			for(String s : map.get(key)){
				sarr[index++] = s;
			}
		}
	}
	
	/**
	 * 11.3
	 */
	/* not recursive version */
	public static int binarySearchRotated(int[] arr, int val) {
		int left = 0; 
		int right = arr.length-1;
		int mid = 0;
		
		while(left <= right)	{
			mid = (left+right) / 2;
			if(arr[mid] == val)	{ 	// equal to mid
				return mid;
			}	else if(arr[mid] < val)	{
					if(arr[right] >= val)	{
						left = mid+1;	// search right
					} else {
						right = mid-1;	// search left
					}
				}	else	{ // arr[mid] > val
					if(arr[left] <= val)	{	// I think this is wrong
						right = mid-1;
					} else{
						left = mid+1;
					}
				}	
		}		
		return -1;
	}
	
	/**
	 * 11.5
	 */
	public static int findString(String[] sarr, String res){
		int left = 0, right = sarr.length-1;
		int mid = 0;
		
		while("".equals(sarr[left]) && left>=0){
			left++;
		}
		
		while("".equals(sarr[right]) && right<=sarr.length-1){
			right--;
		}
		
		while(left <= right)	{
			mid = (left+right)/2;
			if("".equals(sarr[mid])){
				int l = mid-1;
				int r = mid+1;
				while(true)	{
					if(l<left && r>right) 
						return -1;
					if(l >= left && !sarr[l].isEmpty()){
						mid = l;
						break;
					}
					if(r <= right && !sarr[r].isEmpty()){
						mid = r;
						break;
					}
					l--;
					r++;
				}
			}
			if(sarr[mid].equals(res)){
				return mid;
			}
			if(sarr[mid].compareTo(res) < 0){
				left = mid + 1;
				while("".equals(sarr[left]) && left>=0){
					left++;
				}
			}	else	{
				right = mid-1;
				while("".equals(sarr[right]) && right<=sarr.length-1)	{
					right--;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * 11.6
	 */
	public static boolean findElement(int[][] matrix, int val){
		int row = 0;
		int col = matrix[0].length-1;
		
		while(row < matrix.length && col>=0){
			if(matrix[row][col] == val) 
				return true;
			if(matrix[row][col] > val) 
				col--;
			else{
				row++;
			}
		}	
		return false;
	}
}

/**
 * 11.8
 * not yet!!
 */
class RankNode{
	public int left_size = 0;
	public RankNode left, right;
	int data;
	
	public RankNode(int n){
		this.data = n;
	}
	
	public void insert(int n){
		if(n <= data){
			if(left == null) left = new RankNode(n);
			else left.insert(n);
			left_size++;
		}else{
			if(right == null) right = new RankNode(n);
			else right.insert(n);
		}
	}
	
	public int getRank(int n){
		if(n == data){
			return left_size;
		}else if(n < data){
			if(left == null) return -1;
			else return left.getRank(n);
		}else{
			int right_rank = right==null? -1 : right.getRank(n);
			if(right_rank == -1)
				return -1;
			return left_size + 1 + right_rank;
		}
	}
}