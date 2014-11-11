package bstGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // if(root == null) return result;
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(current != null || !stack.isEmpty()) {
            while(current != null) { // keep going to left until (current == null)
                stack.push(current);
                current = current.left;
            }
            // right now current == null
            if(!stack.isEmpty()) {
                current = stack.pop();
                result.add(current.val); // visit current itself (inOrder)
                current = current.right; // current goes to right side, may be "null"
            }
        }
        return result;
    }
}
