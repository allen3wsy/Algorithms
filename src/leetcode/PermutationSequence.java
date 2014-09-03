package leetcode;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];  
        int[] factor = new int[n];  
        factor[0] = 1;  
        for(int i = 1; i < n; i++)      // [1, 1, 2]  0! == 1, 1! == 1, 2! == 2...
            factor[i] = factor[i - 1] * i;  
        StringBuilder sb = new StringBuilder();
        
        for(int i = n - 1; i >= 0; i--) {  
            int tmp = 1;  
            while(k > factor[i]){  
                tmp++;  
                k -= factor[i];  
            }  
            for(int j = 0; j < n; j++)  {  
                if(j + 1 <= tmp && visited[j])  
                    tmp++;  
            }
            sb.append(tmp);  
            visited[tmp - 1] = true;  
        }  
          
        return sb.toString(); 
    }
}
