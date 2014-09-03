package leetcode;

import java.util.Stack;

public class SimplifyPath {

	// http://stupidcodergoodluck.wordpress.com/2013/11/16/leetcode-simplify-path/
    // http://fisherlei.blogspot.com/2013/01/leetcode-simplify-path.html
    // use 2 stacks !!!
    // remember not to do anything if "." is in the queue
    
    public String simplifyPath(String path) {  
        String[] ss = path.split("/");  
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < ss.length; i++) {
            if(!stack.isEmpty() && ss[i].equals("..")) {
                stack.pop();
            } else if(ss[i].length() != 0 && !ss[i].equals(".") && !ss[i].equals("..") )   {
                stack.push(ss[i]);
            }   // else: do nothing, skip
        }
        
        // Don't forget this: if input is "/" or "///", then the stack will be empty
        if(stack.isEmpty())
            return "/";
        
        // reverse
        Stack<String> stack2 = new Stack<String>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()) {
            sb.append("/");
            sb.append(stack2.pop());
        }
        
        return sb.toString();
    }  
}
