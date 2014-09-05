package others;

import java.util.Stack;

public class LongestValidParentheses {

	// http://www.cnblogs.com/lichen782/p/leetcode_Longest_Valid_Parentheses.html
    // http://rleetcode.blogspot.com/2014/01/longest-valid-parentheses.html
    
    // NOTE: there are 2 times of checking whether stack.isEmpty().....
    // the first time is if it is empty,
    // after poping one left paren from the stack, check the second time whether stack.isEmpty() again
    
    // NOTE: (int: last) record the position before first left parenthesis
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)   {
            return 0;
        }
        int last = -1;      // last the the 
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++)    {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }   else    {           // s.charAt(i) == ')'
                if (stack.isEmpty())    {   
                    last = i;       // record the position before first left parenthesis
                }   else    {   // stack is not empty...  
                    stack.pop();     // pop the left paren out...
                    // if stack is empty mean the positon before the valid left parenthesis is "last"
                    if (stack.isEmpty()) {  
                        maxLen = Math.max(i - last, maxLen);
                    }   else    {
                      // if stack is not empty, then for current i the longest valid parenthesis length is 
                      // i - stack.peek()
                       maxLen = Math.max(i - stack.peek(), maxLen);  
                    }
                }
            }
        }       //        ( ( ) ( )      : for this case...   maxLen = i - stack.peek()
                //  EX:   ( ( ) ( ( ( )  : for this case....  SEPARATOR is left paren: ANSWER is still 2
                //        ( ) ) ) ( )    : for this case....  SEPARATOR is right paren  
        return maxLen;
    }
    
    
    public static void main(String[] args)	{
    	String s = ")()()";  // length is 5  : answer is 2
    	
    	String s2 = "(()((()";  // EX:.... answer is still 2
    	
    	int num = longestValidParentheses(s2);
    	System.out.println(num);  
    	
    }
}
