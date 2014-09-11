package bstGraph;


public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    int dfs(TreeNode root, int sum) {
        if(root == null) 
            return 0;           // EX: easy to make mistakes
            
        sum = sum * 10 + root.val;  
        
        // EX: if only one side is null, then dfs(left) + dfs(right) because only one of them is 0
        // if both are null, you must return sum right now, other wise the result would be 0.
        if(root.left == null && root.right == null)         
            return sum;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
