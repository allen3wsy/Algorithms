import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cracking_11 implements Comparator<String> {

	/**
	 * 11.1
	 */
	public static void sortAB(int[] aArr, int[] bArr)	{
		int a = aArr.length - 1;	// 0,1,2	2
		int b = bArr.length - 1;	//0,1,2,3	3
		int merge = a + b + 1;		//			6

		while(b >= 0){
			if(a>=0 && aArr[a] > bArr[b]){
				aArr[merge] = aArr[a];
				a--;
				merge--;
			}else{
				aArr[merge] = bArr[b];
				b--;
				merge--;
			}
		}
	}


	/**
	 * 11.2
	 */

	/*
	 * solution 1: create a new class using comparator
	 */
	/*
	 * ALREADY defined !!
	 */

	//	public String sortChars(String s) 	{
	//		char[] content = s.toCharArray();
	//		Arrays.sort(content);
	//		return new String(content);
	//	}

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return sortChars(s1).compareTo(sortChars(s2));
	}


	/*
	 * solution 2*/
	public static String sortChars(String s)	{
		char[] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);

	}

	public static void groupAnagram(String[] sArr)	{
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String s : sArr)	{
			String key = sortChars(s);
			if(!map.containsKey(key))	{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(key, list);			
			}	else	{
				ArrayList<String> list = map.get(key);
				list.add(s);
			}
		}

		int index = 0;
		for(Entry<String, ArrayList<String>> entry : map.entrySet())	{
			ArrayList<String> a = entry.getValue();
			for(String s : a)	{
				sArr[index] = s;
				index++;
			}	
		}	
		//		int index = 0;
		//		for(String key : map.keySet()){
		//			for(String s : map.get(key)){
		//				sarr[index++] = s;
		//			}
		//		}

	}

	/**
	 * 11.3
	 */

	// # 1: iterative approach	(KE's solution)
	// Does it take duplicates into account ???

	public static int binarySearchRotated(int[] arr, int val){
		int left = 0; 
		int right = arr.length-1;
		int mid;
		
		while(left <= right){
			mid = (left + right) / 2;
			if(arr[mid] == val)	{ 
				return mid;
			}	else{				// arr[mid] != val
				
				if(arr[mid] < val){
					if(arr[right] >= val){
						left = mid+1;
					}else{
						right = mid-1;
					}
				}else	{ // arr[mid] > val
					if(arr[left] <= val){
						right = mid-1;
					}else{
						left = mid+1;
					}
				}
			}
		}

		return -1;
	}
	
	
	// #2: recursive approach: No duplicates...
    // Leetcode tested !!!
    public int bsRotatedRecursive(int[] a, int left, int right, int x)  {
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
		if(a[left] < a[mid])	{					// left is normally ordered
			if(x >= a[left] && x<= a[mid])	{   	// to see if it is within left side
				return bsRotatedRecursive(a, left, mid - 1, x);
			} else {
				return bsRotatedRecursive(a, mid + 1, right, x);
			}

		// CASE 2:
		} else if(a[mid] < a[left])  {     			 // right is normally ordered
			if(x >= a[mid] && x <= a[right])	{	 // to see if it is within right side
				return bsRotatedRecursive(a, mid + 1, right, x);
			} else {
				return bsRotatedRecursive(a, left, mid - 1, x);
			}
		
		// CASE 3:   
		} else {        // a[left] == a[mid]:   only 2 elements left
		    if(a[right] == x)   
		        return right;
		    else
		        return -1;
		}
    }

	// # 3: recursive approach
    // consider duplicates !!!! 
    // Leetcode tested !!!
    // // consider tricky case !!!             [2, 2, 2, 3, 4, 2]......  time: O(N)
	public static int binarySearchRotatedRecursive(int[] a, int left, int right, int x)	{
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
		if(a[left] < a[mid])	{					 // left is normally ordered
			if(x >= a[left] && x<= a[mid])	{		 // to see if it is within left side
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			} else {
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			}
			
		// CASE 2:
		} else if (a[mid] < a[left]) { 					// right is normally ordered
			if(x >= a[mid] && x <= a[right])	{		 // to see if it is within right side
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else {
				return binarySearchRotatedRecursive(a, left, mid - 1, x);
			}

			// CASE 3:
		} else if (a[left] == a[mid]) {		// left half is all repeats  !!!!!!
			if(a[mid] != a[right])	{ 		// if right is diff from mid, search the right half
				return binarySearchRotatedRecursive(a, mid + 1, right, x);
			} else {		// ELSE: we have to search BOTH HALVES
				int result = binarySearchRotatedRecursive(a, left, mid - 1, x); // search left
				if(result == -1)	{										// Must be on the right side
					return binarySearchRotatedRecursive(a, mid + 1, right, x);	// search right
				} else {
					return result;
				}
			}
		}
		return -1;
	}


	/**
	 * 11.4
	 * 
	 * External sort.. Done.
	 * file chunks: External Sort
	 * inside the memory: maintain a min Heap: (the size being the size of each file chunk)
	 * 
	 * EX: 100 chunks, take the smallest out from each chunk and mark down where 
	 * they are from:
	 * whenever you take one smallest(Let's say A) out from the min Heap, push one smallest in the heap which comes
	 * from the same file chunk where A comes from  
	 * 
	 */


	/**
	 * 11.5
	 * @return 
	 * @return
	 */

	/*
	 * Interative version 
	 * */
	public static int searchI(String[] strings, String str)	{
		int left = 0;
		int right = strings.length - 1;
		int mid;

		while(left <= right)	{
			mid = (left + right) / 2;

			/* If mid is empty, find closest non-empty string */
			if (strings[mid].isEmpty()) { 
				int l = mid - 1;
				int r = mid + 1;

				/* Or I can use WHILE TRUE */
				while(left <= l || r <= right)	{
					if(left <= l && !strings[l].isEmpty())	{
						mid = l;
						break;
					}
					else if(r <= right && !strings[r].isEmpty())	{
						mid = r;
						break;
					} else {
						l--;
						r++;
					}
				}
				// one side out-of-bound is OK
				if(left > l && r > right)	
					return -1;
			}
			// perform the Binary Search			
			if(strings[mid].equals(str))	{
				return mid;			// found it!!!
			} else if(strings[mid].compareTo(str) < 0){
				left = mid + 1;		 // search right		
			} else {
				right = mid - 1;
			}

		}
		return -1;
	}


	/**
	 * 
	 * recursive version
	 */
	public static int searchR(String[] strings, String str, int left, int right)	{
		if(left > right)
			return -1;
		int mid = (left + right) / 2;


		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) { 
			int l = mid - 1;
			int r = mid + 1;

			while(true)	{
				if(l < left && r > right)	
					return -1;
				else	{
					if(!strings[l].isEmpty() && left <= l)	{
						mid = l;
						break; // dont' forget this
					}	else if(!strings[r].isEmpty() && r <= right) {
						mid = r;
						break; // dont' forget this
					} else	{
						l--;
						r++;
					}
				}			
			}
		}
		if(strings[mid].compareTo(str) < 0)	{			// .compareTo(str) function !!!
			return searchR(strings, str, mid + 1, right); // search right
		} else if(strings[mid].compareTo(str) > 0)	{
			return searchR(strings, str, left, mid - 1);
		} else {		// FOUND !!!
			return mid;
		}		
	}

	// for recursive solution:
	public static int search(String[] strings, String str)	{
		if(str == null || strings == null || str == "")
			return -1;
		else
			return searchR(strings, str, 0, strings.length - 1);
	}


	/**
	 * 11.6
	 * 
	 */
	public static boolean findElement(int[][] matrix, int val)	{
		int row = 0;							// start from the upper right corner
		int col = matrix[0].length - 1;			// start from the upper right corner

		while(row < matrix.length && col >= 0){		// either go left or go down....
			if(matrix[row][col] == val) 
				return true;
			if(matrix[row][col] > val)	
				col--;
			else	
				row++;
		}
		return false;
	}


	/**
	 * 11.7
	 * 
	 * Hard: not done yet...
	 */


	/**
	 * 11.8 
	 * public void track(int number)
	 * public static int getRankOfNumber(int number)
	 * 
	 */
	private static RankNode root = null;

	/**
	 * Track
	 * @param number
	 */
	public static void track(int number)    {
		if(root == null)    {
			root = new RankNode(number);
		}   else {
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number)    {   
		return root.getRank(number);
	}

	public static void main(String[] args)	{
		String[] array = {"zdb", "agb", "fca"};
		String s = "dd";
		String l = "mm";


		// 11.3


		// 11.5
		System.out.println("the position is: ");
		String[] strings = {"abc", "bcd", "", "", "cde", "", "qqq"};
		int position = search(strings, "");
		//		int position = searchI(strings, "");		// this iterative version also works
		System.out.println(position);

		// String s has the compareTo function already !!!!
		if(s.compareTo(l) > 0)	{
			System.out.println("Awesome");
		}
		Arrays.sort(array, new cracking_11());
		for(String str : array)	
			System.out.print(str + ", ");

		// 11.8
		track(3);
		track(1);
		track(2);
		track(10);
		int result = getRankOfNumber(10);
		System.out.println(result);

	}
}


class RankNode   {
	public int left_size = 0;
	public int data = 0;
	public RankNode left, right;

	public RankNode(int n){
		this.data = n;
	}

	// inserting node
	public void insert(int n)   {
		if(n <= data)   {
			if(left == null) 
				left = new RankNode(n);
			else 
				left.insert(n);
			left_size++;                // don't forget this left_size++:  Different from the right hand side
		}else   {
			if(right == null) 
				right = new RankNode(n);
			else 
				right.insert(n);         // No left_size++:  Different from the right hand side
		}
	}

	// get the integer after inputing int n

	/**
	 * This class in the most important
	 * @param n
	 * @return
	 */
	public int getRank(int n)   {
		if(n == data)   {
			return left_size;
		}   else if(n < data)  {            // n > data
			if(left == null) 
				return -1;
			else 
				return left.getRank(n);	
		}   else   {                        // n > data 
			int right_rank;
			if (right == null) 
				right_rank = -1;            // if (right == null), then we set right_rank = -1
			else 
				right_rank = right.getRank(n);

			if(right_rank == -1)            // which means not found (right == null)
				return -1;
			return left_size + 1 + right_rank;
		}
	}
}
