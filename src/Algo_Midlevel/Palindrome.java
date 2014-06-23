package Algo_Midlevel;
public class Palindrome{
	public Palindrome(){
		
		if(isPalindrome("ab23532ba")){
			System.out.println("yes");
		}else
			System.out.println("no");
		
	}
	
	// int is Palindrome or not ?
	public boolean isPalin(int x){
		if(x < 0) 
			return false;
		int div = 1;
		while(x / div >= 10){
			div *= 10;
		}
		while(x != 0)	{
			int l = x / div;
			int r = x % 10;
			if(l != r) 
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	// String
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;
        
        while(l < r)    {
            if(s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }
        return true;
    }
	
	// recursion for String
	public boolean isPalinRec(String s){
		int length = s.length();
		if(length <= 1)				// exit !!! 
			return true;
		
		if(s.charAt(0) != s.charAt(length - 1))
			return false;
		
		if(isPalinRec(s.substring(1, length - 1)))
			return true;
		
		return false;
	}
	
	
	public static void main(String[] args){
		new Palindrome();
	}
}