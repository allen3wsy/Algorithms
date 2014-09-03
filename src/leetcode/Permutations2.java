package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {

public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int n = num.length;
        boolean[] visited = new boolean[n];
        
        Arrays.sort(num);    // diff: this one should be different from Permutation I
        permuteHelper(result, temp, num, visited);
        return result;
        
    }
    
    public void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] num, boolean[] visited)    {
        if(temp.size() == num.length)   {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(num[i]);
                
                permuteHelper(result, temp, num, visited);
                
                visited[i] = false;
                temp.remove(temp.size() - 1);       
                
                // skip the duplicates:  AFTER REMOVE !!! so that 
                // these 2 lines are for removing duplicates !!!
                while(i + 1 < num.length && num[i + 1] == num[i])  { // diff: this one should be different from Permutation I
                    i++;   // diff: this one should be different from Permutation I
                }
            }
        }
    }
}
