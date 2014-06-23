package Amazon;

public class Solution_1 {

	    public static int solution(int[] A) {
	        // write your code in Java SE 6
	        boolean[] record = new boolean[A.length];
	        int count = 0;
	        int curr = 0;
	     
	        
	        while(true)    {
	            
	            if(record[curr] == true)    {
	                return -1;
	            }
	            int value = A[curr];
	            record[curr] = true;
	            curr += value;
	            
	            if(curr < 0 || curr > A.length - 1)    {
	                 break;
	            }             
	            count++;            
	        }
	        
	        return count;      
	    }
	    
	    public static int uniquePaths(int m, int n) {
	        int[] array = new int[n];
	    
	        array[0] = 1;

	        for(int i = 0; i < m; i++)  {
	            for(int j = 1; i < n; j++)  {
	                array[j] = array[j - 1] + array[j];
	            }
	        }
	        
	        return array[n - 1];
	    }
	    
	    public static void main(String[] args)	{
	    	int[] arr = {2, 3, -1, 1, 3};
	    	System.out.println(solution(arr));
	    	
	    	System.out.print(uniquePaths(1, 2));
	    	
	    }

}
