package data_structure_basic;
import java.util.LinkedList;
import java.util.Queue;

// the time complexity is O(N) because it searches every node...
// http://blog.csdn.net/sgbfblog/article/details/7771096 
// solution 2

public class CheckForBST
{
	 	
	static class Node	{	
		public Node left;
		public Node right;
		public int value;
	  
		public Node(int value)	{
			this.value=value;
		}
	}
		
	public static void main(String[] args)	{
		
		Node a=new Node(12);
		Node b=new Node(3);
		Node c=new Node(15);
		Node d=new Node(10);
		Node e=new Node(14);
		Node f=new Node(17);
		Node g=new Node(4);
		Node h=new Node(11);
		Node i=new Node(5);
		
		a.left=b;
		a.right=c;
		b.right=d;
		c.left=e;
		c.right=f;
		d.left=g;
		d.right=h;
		g.right=i;
		System.out.println(isBST(a));

	}
	
	// outer interface
	 public static boolean isBST(Node root)	{  
		 return checkBooleanAndReturn(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	 }
	 
	 // Allen's recursive version
	 public static boolean checkBooleanAndReturn(Node root, int min,int max)	{
		 
		 // note : these two sentenses can't swap!!!!
		 // THIS IS THE EXIT: remember we always write the exit first!!!
		 
		 if(root == null)	
			 return true;
		 // #2
		 if(root.value >= max || root.value <= min)	
			 return false;
		 
		 return checkBooleanAndReturn(root.left, min, root.value) &&
				 checkBooleanAndReturn(root.right, root.value, max);
		 
	 }
		 
	 /**
	  * KL's solution
	  */
//	 private static boolean checkBooleanAndReturn(Node root, int max,int min)	{
//		 
//	 if(root==null)
//		  return true;
//	 
//	  boolean leftOk = true;
//	  boolean rightOk = true;
//	  boolean centerOk = true;
//	  
//	  if(root.left!=null)
//		  leftOk = checkBooleanAndReturn(root.left,root.value,min);
//	  
	  /**
	   * Note : at this point we can't return true cause we still have to make sure
	   * all the subtrees are BST. So we put centerOk = true; (instead of return true) 
	   */
//	  if(root.value >= min && root.value <= max)
//		  centerOk = true;
//	  else
//		  centerOk = false;
//	  
//	  if(root.right != null)
//		  rightOk = checkBooleanAndReturn(root.right,max,root.value);
//	  
//	  return leftOk && centerOk && rightOk;
//	 }
	   
}