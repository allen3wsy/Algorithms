package BSTGraph;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
    // Inorder sequence: D B E A F C
    // Preorder sequence: A B D E C F
    
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        
        return build(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
    
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)    // exit condition
            return null;                    // if (preStart == preEnd && inStart == inEnd): it is the case where there is only a                                                   // element inside the array
        
        TreeNode root = new TreeNode(preorder[preStart]);   // preorder[preStart] must be the root of this subtree
        
        int k = 0;
        for(int i = inStart; i <= inEnd; i++)   { // index k is the index where inOrder[] has the 
            if(inorder[i] == preorder[preStart])  { // preorder[preStart] value, so "index k" is the divide
                k = i; // for which left side of k (inOrder array) should be of left subtree
                break; // this command can also be removed        // right side of k should be of right subtree
            }
        }
        int len = k - inStart;      // len is the number of nodes of the left subtree
        
        root.left = build(preorder, preStart + 1, preStart + len, inorder, inStart, k - 1);
        root.right = build(preorder, preStart + len + 1, preEnd, inorder, k + 1, inEnd);
        
        return root;
    }
}

