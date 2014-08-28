package algo_Midlevel;
//The longest common subsequence of two string
public class LCsubsequence{
	
	public String LCS(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] C = new int[m + 1][n + 1];		// 2-D array: (m + 1) * (n + 1)
		
		String result = "";
		
		// initialization 
		for(int i = 0; i <= m; i++)
			C[i][0] = 0;
		for(int j = 0; j <= n; j++)
			C[0][j] = 0;
		
		int i=1, j=1;
		for(i=1; i<=m; i++){			//dynamic programming
			for(j=1; j<=n; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					C[i][j]=C[i-1][j-1]+1;
				}else{
					C[i][j]=Math.max(C[i-1][j], C[i][j-1]);
				}
			}
		}
		i=m;
		j=n;
		
		while(i>0&&j>0){				// traceback to print the LCS
			if(s1.charAt(i-1)==s2.charAt(j-1)){
				result=s1.charAt(i-1)+result;
				i--;
				j--;
			}
			else{
				if(C[i-1][j]>C[i][j-1])
					i--;
				else
					j--;
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args)	{
		System.out.println("d");
	}
	
	
}