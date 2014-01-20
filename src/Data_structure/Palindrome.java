package Data_structure;
public class Palindrome{
	public Palindrome(){
		
		if(isPalin("ab23532ba")){
			System.out.println("yes");
		}else
			System.out.println("no");
			
		System.out.println(longestPalindromeDP("qhegdsd1234d54321dsd"));
	}
	
	public boolean isPalin(int x){
		if(x<0) return false;
		int div=1;
		while(x/div >=10){
			div*=10;
		}
		while(x!=0){
			int l=x/div;
			int r=x%10;
			if(l!=r) return false;
			x=(x%div)/10;
			div/=100;
		}
		return true;
	}
	
	
	public boolean isPalin(String s){
		int length=s.length();
		while(length>1){
			char l=s.charAt(0);
			char r=s.charAt(length-1);
			if(l!=r) return false;
			s=s.substring(1, length-1);
			length-=2;
		}
		return true;
	}
	
	public boolean isPalinRec(String s){
		int length=s.length();
		if(length<=1) return true;
		if(s.charAt(0)!=s.charAt(length-1))
			return false;
		if(isPalinRec(s.substring(1, length-1)))
			return true;
		return false;
	}
	
	public String longestPalindromeDP(String s){
		int n=s.length();
		int longestBegin=0;
		int maxLen=1;
		boolean table[][] = new boolean[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				table[i][j]=false;
		for(int i=0; i<n; i++)
			table[i][i]=true;
		for(int i=0; i<n-1; i++)
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1]=true;
				longestBegin=i;
				maxLen=2;
			}
		
		for(int len=3; len<=n; len++){
			for(int i=0; i<n-len+1; i++){
				int j=i+len-1;
				if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]==true){
					table[i][j]=true;
					longestBegin=i;
					maxLen=len;
				}
			}
		}		
		return s.substring(longestBegin, longestBegin+maxLen);		
	}
	
	/*       a   b   c   b   a
	 *       0   1   2   3   4
	 * a  0  t   f   f   f   t
	 * b  1      t   f   t   f
	 * c  2          t   f   f
	 * b  3              t   f
	 * a  4                  t
	 */
	
	public static void main(String[] args){
		new Palindrome();
	}
}