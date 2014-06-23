package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        
        int size = (int) Math.pow(2, n);
        for(int i = 0; i < size; i++)  {
            result.add(i);
        }
        
        for(int i = 0; i < result.size(); i++) {
        	int num = result.get(i);
        	int newValue = (num >> 1) ^ num;
        	result.set(i, newValue);
        }
        
		return result;
    }
        
    
    public static void main(String[] args)	{
    	List<Integer> result = new ArrayList<Integer>();
    	result = grayCode(3);
    	
    	System.out.println(result);
    	
    }
}
