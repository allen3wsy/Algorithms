package bstGraph;


public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  
            return true;
            
        // only one of them is null
        if(p == null || q == null || p.val != q.val)
            return false;
            
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
