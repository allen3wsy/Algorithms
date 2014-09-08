package BSTGraph;


public class BinaryTreeMaximumPathSum {

	// http://leetcodenotes.wordpress.com/2013/11/04/leetcode-binary-tree-maximum-path-sum-%E6%A0%91%E4%B8%AD%E4%BB%BB%E6%84%8F%E4%B8%A4%E7%82%B9%E9%97%B4%E6%9C%80%E5%A4%A7path-sum/
	// most clear solution !!!
	public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        
        maxPath(root, result);  // return the oneSide value: don't assign it !
        return result[0];       // return the final result
    }
    
    public int maxPath(TreeNode root, int[] result) {
        if(root == null)
            return 0;
        
        int left = maxPath(root.left, result);      // leftSide: itself not included 
        int right = maxPath(root.right, result);    // rightSide: itself not included 
        int oneSide = Math.max(root.val, root.val + Math.max(left, right)); // oneSide value(including itself)
        
        int arc = root.val + left + right;
        result[0] = Math.max(result[0], Math.max(oneSide, arc));
        
        return oneSide;         // pass the oneSide value up recursively (don't pass the final result)
    }
}
