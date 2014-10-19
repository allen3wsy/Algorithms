package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());  // the null arrayList, right now res.size() == 1
        
        if(num == null || num.length == 0)
            return res;
        
        Arrays.sort(num);       // sort the input Array
        
        int start = 0;
        for(int i = 0; i < num.length; i++)   {
            int size = res.size();
            for(int j = start; j < size; j++) {     // start is the old size, size is the new size !!!
                ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
                newItem.add(num[i]);
                res.add(newItem);
            }
            // NOTE: only when the left part of the && passes then the right part will pass
            if(i < num.length - 1 && num[i] == num[i + 1])  
                start = size;
            else    
                start = 0;
        }
        return res;
    }
}
