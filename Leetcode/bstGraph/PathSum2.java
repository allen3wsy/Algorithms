package bstGraph;

import java.util.ArrayList;

public class PathSum2 {

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        pathSumDFS(root, sum, list, result);
        return result;
    }
    
    public static void pathSumDFS(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if(root == null) 
            return;
        
        list.add(root.val);                 // <add> one int to the list
        
        // when it reaches the leave !!!
        if(root.left == null && root.right == null && sum == root.val) {    
            result.add(new ArrayList<Integer>(list));    // Don't forget to new an ArrayList<Integer>
            list.remove(list.size() - 1);   // <remove> the int from the list
            return;
        }
        
        pathSumDFS(root.left, sum - root.val, list, result);
        pathSumDFS(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);       // <remove> the int from the list
        return;
    }
}
