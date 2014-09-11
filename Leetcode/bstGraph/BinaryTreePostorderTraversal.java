package bstGraph;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    // http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
    // http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
    // using 2 stacks: (reverse-preOrder to another stack)
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) 
        	return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> result = new Stack<Integer>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();    // have to pop() the stack! Because that's how preOrder works
            result.push(temp.val);  		// result is the stack storing the final elements
            if(temp.left != null) 
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }
        
        while(!result.isEmpty()) {
            list.add(result.pop());
        }
        
        return list;
    }
}
