package others;

import java.util.ArrayList;

public class GenerateParentheses {

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();	    // a null result
	    generate(n, "", 0, 0, result);			               	// at first left == right == 0
        
        return result;		// pass result into the function so that result will change !!!
    }
    
    // it's like a tree structure: either you go left or right:
    // For example: if n is 3: then you can build a special tree (5 total results)
    public static void generate(int n, String s, int l, int r, ArrayList<String> result)   {
            if(l == n)	{       // the only possibility is to append ")"
            	StringBuilder sb = new StringBuilder(s);
            	
            	for(int i = 1; i <= (l - r); i++ )	{
            		sb.append(')');
            	}
            	String str = sb.toString();
            	result.add(str);
            	return;
            }
            
            generate(n, s + "(", l + 1, r, result);      // go to left (add a left paren)
    
            if(l > r)
           	    generate(n, s + ")", l, r + 1, result);  // go to right (add a right paren)
    	
    	// else (l <= r): do nothing! because r should not be greater than l (at most equal)
    }
    
    public static void main(String[] args)	{
    	ArrayList<String> result = new ArrayList<String>();
    	result = generateParenthesis(4);
    	System.out.println(result);
    }
}

