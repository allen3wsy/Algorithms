package dfs;

import java.util.ArrayList;

public class Permutations {

	// DFS 
    public ArrayList<ArrayList<Integer>> permute(int[] num) {  
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> tmp = new ArrayList<Integer>();      // temp is a null arrayList
        int n = num.length;  
        boolean[] visited = new boolean[n];  
          
        permuteHelper(result, tmp, num, visited);  
        return result;  
    } 
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, int[] num, boolean[] visited) {  
        if(tmp.size() == num.length)    {               // otherwise the length is incorrect
            result.add(new ArrayList<Integer>(tmp));    // copy a new one and add it into the result set
            return;  
        }  
        // every time we recurse, we have to go through the loop,
        // For example: [1, 2, 3]:  look at the notes for the recursion tree and the for loop graph
        for(int i = 0; i < num.length; i++) {  
            if(!visited[i]) {                               // if num[i] has not been visited !
                tmp.add(num[i]);  
                visited[i] = true;  
                permuteHelper(result, tmp, num, visited);      // recursive solve: DFS
                visited[i] = false;  
                tmp.remove(tmp.size() - 1);                 // remove the last one in the temp arrayList
            }  
        }  
    }
}
