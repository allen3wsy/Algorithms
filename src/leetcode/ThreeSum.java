package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) 
            return result;
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 2; i++) {

    		if (i == 0 || num[i] > num[i - 1]) {    // THIS LINE IS EXTREMELY IMPORTANT: avoid duplicate solutions
                // APPLY 2 SUM here: 
    			int negate = -num[i];
    			int start = i + 1;
    			int end = num.length - 1;    
     
    			while (start < end) {           // start
    				//case 1
                    if(num[start] + num[end] == negate) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        result.add(temp);
                        start++;
                        end--;
                        // EX:  still have to consider: avoiding duplicate solutions in the 2 SUM problem
    					while (start < end && num[start] == num[start - 1])
    						start++;
    					while(start < end && num[end] == num[end + 1])   
    					    end--;
                    } else if(num[start] + num[end] < negate)   {
                        start++;
                    } else {
                        end--;
                    }
                    
    			}
     
    		}
        }
        return result;
        
    }
	
}
