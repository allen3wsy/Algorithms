package Algo_Midlevel;
public class LCsubstring{

	/*
	 * find longest common substring with O(n*m) space
	 */
	public String longestCommonSub(String s1, String s2){
		if(s1==null || s2==null || s1.length()==0 || s2.length()==0){
			return "";
		}
		
		int maxLength = 0;
		int end = 0;
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] table = new int[l1 + 1][l2 + 1];
		
//		for(int i = 0; i <= l2; i++){
//			table[0][i] = 0;
//		}
//		for(int i = 0; i <= l1; i++){
//			table[i][0] = 0;
//		}
		
		/* important */
		for(int i = 1; i <= l1; i++)	{
			for(int j = 1; j <= l2; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1))	{
					if(i == 1 || j == 1)	{
						//table[i][j]=1;
					} else{
						table[i][j] = table[i-1][j-1]+1;
					}
					
					/* change the maxLength inorder to chase back easily
					 * */
					if(table[i][j] > maxLength)	{
						maxLength = table[i][j];
						end = i;
					}
				}
				else	{
					/* zero means that no common here*/
					table[i][j] = 0;
				}
			}
		}
		
		int startIndexOfString = end - maxLength + 1 - 1;
		return s1.substring(startIndexOfString, end);
	}
		
		/* find longest common substring with O(n) space
		 * 
		 */
		public String LCSn(String first, String second)	{
			if(first == null || second == null || first.length() == 0 || second.length() == 0){
				return "";
			}
			
			int maxLength=0;
			int end=0;
			int record=0;
			int fl=first.length(), sl=second.length();
			int[] past=new int[sl];
			int[] curr=new int[sl];
			
			for(int i=0; i<fl; i++){
				for(int j=0; j<sl; j++){
					if(first.charAt(i)!=second.charAt(j)){
						record=0;
					}else{
						if(i==0 || j==0){
							record=1;
						}else{
							record=past[j-1]+1;
						}
					}
					curr[j]=record;
					if(record>maxLength){
						maxLength=record;
						end=i;
					}
				}
				int[] swap=past;
				past=curr;
				curr=swap;
			}
			System.out.println("maxLength: "+maxLength +"  end: "+end);
			return first.substring(end-maxLength+1, end+1);
		}
	
}