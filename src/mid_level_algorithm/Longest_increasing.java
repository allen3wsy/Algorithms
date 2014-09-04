package mid_level_algorithm;
import java.util.ArrayList;

// not yet !!

public class Longest_increasing {

	/*
	 * longest increasing substring: just done !!!!!
	 * O(N squared)  but there is a O(N lg N) solution, which can't print out the LISubsequence (just the length)
	 * */
	public static void LIS(int[] D){
		
		// all the lists (we just need the longest one)
		ArrayList<ArrayList<Integer>> L = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < D.length; i++)
			L.add(new ArrayList<Integer>());
		
		L.get(0).add(D[0]);
		
		for(int i = 1; i < D.length; i++)	{
			for(int j = 0; j < i; j++)	{
				
				// D[j] <= D[i]  here means monotonically
				if(D[j] <= D[i] && (L.get(j).size() >= L.get(i).size() ) )	{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(L.get(j));	// instead assigning L.get(j) to list, we use addAll to avoid referencing the same list
					L.set(i, list);			// cover the previous list
				}
			}
			
			// this element should always be added, this cannot be avoided
			L.get(i).add(D[i]); 	 
		}
		
		// we can make a little modification to print the longest list
		for(ArrayList<Integer> list : L)	{
			for(Integer i : list)	{
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	// dan diao zeng
	public static void main(String[] args)	{
		int[] array = {1,2,3,4,4,7,6,8};
		LIS(array);
		System.out.println(1<<2);
	}
}

