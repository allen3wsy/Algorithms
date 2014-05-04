package leetcode;

import java.util.*;

import javax.swing.tree.TreeNode;

/**
 * Preorder using iterative solution
 * @author Allen
 *
 */

public class IterativeTraversal {
	
	/*
	 * definition of the TreeNode 
	 * */
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 

	/* everytime I push the top of the stack, I push top.right then I push top.left */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	if(root != null)
    		s.push(root);
    	
    	while(!s.isEmpty())	{
    		TreeNode temp = s.pop();
    		arr.add(temp.val);
    		
    		if(temp.right != null)
    			s.push(temp.right);
    		if(temp.left != null)
    			s.push(temp.left);
    	}
    	
    	return arr;
    }
    
    /*
     * This is a little bit tricky and please 
     * compare it to the problem above */
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
      	ArrayList<Integer> arr = new ArrayList<Integer>();
    	Stack<TreeNode> save = new Stack<TreeNode>();
      	// t is for traversal
    	Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode current = root;  
        while (current != null || !s.isEmpty()) {
        	/* keep going to the left and at the time push the node into the stack 
        	 * So at this time all the left nodes will be kept in the stack */
        	while(current != null)	{
        		s.push(current);
        		current = current.left;  		
        	}
        	
        	/* whenever we pop out a node we check that whether there is a right node 
        	 * But if right is null, then the current pointer can never go down left side
        	 * thus, we will keep poping the stack */
        	if(!s.isEmpty())	{
        		current = s.pop();
        		arr.add(current.val);
        		current = current.right;
        	}
        	
        }
		return arr;
    }
    
    
    /* I doubt this is not iterative  !!!
     * */
    // post Order Traversal
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if  (root == null) 
        	return new ArrayList<Integer>();
        if (root.left == null && root.right == null)	{ // leaf
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(root.val);
            return result;
        }
        else	{
            ArrayList<Integer> result = new ArrayList<Integer>();
            ArrayList<Integer> leftResult = postorderTraversal(root.left);
            ArrayList<Integer> rightResult = postorderTraversal(root.right);
            // add to result
            for (Integer val: leftResult){
                result.add(val);
            }
            for (Integer val: rightResult){
                result.add(val);
            }
            int currentVal = root.val;
            result.add(currentVal);
            return result;
        }
    }
    
    	
}
