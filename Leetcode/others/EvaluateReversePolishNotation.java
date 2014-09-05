package others;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		
		for(String str : tokens) {
		    if(str.equals("+")) {
		        int temp = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
		        stack.push(Integer.toString(temp));
		    } else if(str.equals("-")) {
		        int right = Integer.parseInt(stack.pop());
		        int left = Integer.parseInt(stack.pop());
		        int temp = left - right;
		        stack.push(Integer.toString(temp));
		    } else if(str.equals("*"))  {
		        int temp = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
		        stack.push(String.valueOf(temp));
		    } else if(str.equals("/"))  {
		        int right = Integer.parseInt(stack.pop());
		        int left = Integer.parseInt(stack.pop());
		        int temp = left / right;
		        stack.push(Integer.toString(temp));
		    } else {
		        stack.push(str);
		    }
		}
		
		return Integer.parseInt(stack.pop());
    }
    
    public static void main(String[] args)	{
		String[] tokens = {"4", "13", "5", "/", "+"};
		
		System.out.print(evalRPN(tokens));
    }
}
