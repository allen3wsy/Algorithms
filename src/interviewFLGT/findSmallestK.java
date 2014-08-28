package interviewFLGT;

import java.util.ArrayList;

public class findSmallestK {

	public findSmallestK(){
		int[] arr = {5, 1, 4, 8, 3, 2};
		int k = 3;
		findSmallestK(k, arr);
	}
	// the total running time is N * O(K)
	// becasue finding
	
	// we can further reduce the running time to O(N lg K) using max heap
	// because heap operation requires log K time
	
	public void findSmallestK(int k, int[] arr)	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++)	{
			if(result.size() < k)	{
				result.add(arr[i]);
			} else {
				// every time we find out the biggest of the K elements
				// in O(K) time result.get()
				int index = 0;
				for(int j = 0; j < k; j++)	{
					if(result.get(index) < result.get(j))
						index = j;
				}			
				// if the current value arr[i] is smaller than the biggest 
				// among k elements, replace it
				if(arr[i] < result.get(index))
					result.set(index, arr[i]);
			}
		}
		
		// print out all the K elements
		for(int i = 0; i < result.size(); i++)	{
			System.out.print(result.get(i) + "  ");
		}
	}
	
	public static void main(String[] args)	{
		new findSmallestK();
	}
}
