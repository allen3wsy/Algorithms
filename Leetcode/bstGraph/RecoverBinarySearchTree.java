package bstGraph;

import java.util.ArrayList;

public class RecoverBinarySearchTree {

	// http://blog.csdn.net/linhuanmars/article/details/24566995
    // http://blog.csdn.net/fightforyourdream/article/details/16875941
    
    // void inOrder (Node root)    {
    //     if(root == null) return;
    //     inOrder( root.leftNode() );
    //     root.printNodeValue();
    //     inOrder( root.rightNode() ); 
    // }
    
    public void recoverTree(TreeNode root) {
        if(root == null)  
            return;  
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();  
        pre.add(null);      // pre is null for the beginning !!! 
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();// res: storing the 2 swapped TreeNodes 
        
        inorder(root, pre, res);  
        
        // swapping process !!!
        int temp = res.get(0).val;  
        res.get(0).val = res.get(1).val;  
        res.get(1).val = temp;  
    }
    
    public void inorder(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res) {
        // 1: process null
        if(root == null)
            return;
        // 2: process left
        inorder(root.left, pre, res);
        
        // 3: process itself
        if(pre.get(0) != null && pre.get(0).val > root.val) {
            if(res.size() == 0) {
                res.add(pre.get(0));
                res.add(root);
            } else {        // the res already contains 2 TreeNodes, then replace the second one
                res.set(1, root);
            }
        }
        pre.set(0, root);   // after processing itself, itself(root) should be the pre !!!
        
        // 4: process right
        inorder(root.right, pre, res);
    }
}
