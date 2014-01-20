import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class cracking_4 {
	
	public static void main(String[] args)	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		TreeNode<Integer> head = newTree(arr);
		head.right.right = new TreeNode<Integer>(7);
		DFSinorder(head);
		System.out.println("\ndepth: " + getHeight(head));
		BFS(head);
		
		// 4.1
		System.out.println("is Balance?: " + isBalanced(head));
		
		
		// 4.3
//		System.out.println("is BST? " + isBST(head));
		
		System.out.println("four.four : " + createLevelLinkedList2(head).get(2).size());
		
		String s = "abc";
		
		// 4.6

	}
	

	/*
	 * create a new tree based on an array
	 */
	public static TreeNode<Integer> newTree(int[] arr)	{
		TreeNode<Integer> head = new TreeNode<Integer>(arr[0]);
		for(int i = 1; i < arr.length; i++)	{
			head = insertNode(head,arr[i]);
		}
		return head;
	}
	
	
	/*	Allen's version
	 * insert the value into the tree: LevelOrder insertion
	 */
	public static TreeNode<Integer> insertNode(TreeNode<Integer> head, int val)	{
		if(head == null)	{
			head = new TreeNode<Integer>(val);
			return head;
		}
	
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(head);
		
		while(true)	{
			TreeNode<Integer> temp = queue.poll();
			if(temp.left == null)	{
				temp.left = new TreeNode<Integer>(val);
				return head;
			}
			queue.add(temp.left);
			
			if(temp.right == null)	{
				temp.right = new TreeNode<Integer>(val);
				return head;
			}
			queue.add(temp.right);
		}

	}
	
	/*
	 * inorder traversal
	 */
	public static void DFSinorder(TreeNode<Integer> head){
		if(head == null)
			return;
		DFSinorder(head.left);
		System.out.print(head.data + " ");
		DFSinorder(head.right);
	}
	
	public static void BFS(TreeNode<Integer> head)	{
		if(head == null)
			return;
		
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(head);
		
		while(!queue.isEmpty())	{
			int size = queue.size();
			
			/* This cycle is used to println whenever there is a level */
			for(int i = 0; i < size; i++)	{
			TreeNode<Integer> temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);			
			}
			System.out.println();
		}
	}
	
	
	/**
	 * 4.1
	 */
	
	/*
	 * not the best solution
	 */
	public static int getHeight(TreeNode<Integer> head)	{

		if(head == null)
			return 0;
		return Math.max(getHeight(head.left), getHeight(head.right)) + 1;
		
	}
	
	public static boolean isBalanced2(TreeNode<Integer> root)	{
		if(root == null)	// base case
			return true;
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1)
			return false;
		else 				// recurse
			return isBalanced2(root.left) && isBalanced2(root.right);
	}
	
	/*
	 * the better solution to this problem
	 */
	public static int checkHeight(TreeNode<Integer> root)	{
		if(root == null)
			return 0;
		
		/* check if left is balanced */
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1)
			return -1;
		
		/* check if right is balanced */
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1)
			return -1;		
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)	
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean isBalanced(TreeNode<Integer> root){
		if( checkHeight(root) == -1)
			return false;
		return true;
	}
	
	
	/**
	 * 4.3
	 *
	 */
	
	public static TreeNode<Integer> createMinimalBST(int[] arr, int left, int right)	{
		/* The same as binary search */
		if(left > right)
			return null;
		
		int mid = (left + right) / 2;
		
		TreeNode<Integer> n = new TreeNode<Integer>(arr[mid]);
		n.left = createMinimalBST(arr, left, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, right);
		
		return n;
	}
	
	/**
	 * 4.4
	 */
	 	
	/* Allen's solution: 
	 * Space complexity is O(N): I used another queue to store the 
	 * current elements that have not been processed */
	public static ArrayList<LinkedList<TreeNode<Integer>>> createLevelLinkedList(TreeNode<Integer> root)	{
		ArrayList<LinkedList<TreeNode<Integer>>> result = new ArrayList<LinkedList<TreeNode<Integer>>>();
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		
		if(root == null)
			return null;
		queue.add(root);
		
		/* when is queue is not empty, we continue doing this levelOrder traversal */
		while(!queue.isEmpty())	{
			int size = queue.size();
			LinkedList<TreeNode<Integer>> list = new LinkedList<TreeNode<Integer>>();
			/* the size of the queue */
			for(int i = 0; i < size; i++)	{
				TreeNode<Integer> temp = queue.poll();
				list.add(temp);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			result.add(list);
		}

		return result;
	}
	
	/*
	 * CTCI's solution:
	 */
	public static ArrayList<LinkedList<TreeNode<Integer>>> createLevelLinkedList2(TreeNode<Integer> root)	{
		ArrayList<LinkedList<TreeNode<Integer>>> result = new ArrayList<LinkedList<TreeNode<Integer>>>();
		
		LinkedList<TreeNode<Integer>> current = new LinkedList<TreeNode<Integer>>();
		if(root != null)
			current.add(root);

		while(current.size() > 0)	{
			result.add(current);
			LinkedList<TreeNode<Integer>> parents = current; // go to next level
			current = new LinkedList<TreeNode<Integer>>();
			for(TreeNode<Integer> parent : parents)	{
				if(parent.left != null)	{
					current.add(parent.left);
				}
				if(parent.right != null)	{
					current.add(parent.right);
				}
				
			}
		}

		return result;
	}
	
	
	/**
	 * 
	 * 4.5
	 */
	 // Allen's recursive version
	 private static boolean checkBST(TreeNode<Integer> root, int min,int max)	{
		 if(root == null)	
			 return true;
		 
		 if(root.data <= min || root.data >= max)
			 return false;
		 
		 return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	 
	 }
	 
	 /**
	  * 
	  * 4.6: It can be tricky to code perfectly:
	  * So we need to sketch out the psuedocode to outline the different cases
	  */
	 
	 public static TreeNode<Integer> inorderSucc(TreeNode<Integer> n)	{		
		 if(n == null)
			 return null;
		
		// if n has right subtree, return the leftmost
		if(n.right != null)	{
			TreeNode<Integer> leftmost = n.right;
			while(leftmost.left != null)	{
				leftmost = leftmost.left;
			}	
			return leftmost;
		} else {
		/* go all the way up until . 
		 * NOTE:  n == n.parent.right  Because we have to make sure that
		 * n.parent is not null, otherwise n.parent.right would be an error
		 * */ 			
			while(n.parent != null && n == n.parent.right)	{
				n = n.parent;
			}
			return n.parent;
		}
	 } 
		
	 /**
	  * 4.7
	  * 
	  * */
	 
	 public static boolean covers(TreeNode<Integer> root, TreeNode<Integer> p)	{
		 if(root == null)
			 return false;
		 if(root == p)
			 return true;
		 return (covers(root.left, p) || covers(root.right, p));
	 }
	 
	 public static TreeNode<Integer> commonAncestorHelper(TreeNode<Integer> root, 
			 TreeNode<Integer> n1, TreeNode<Integer> n2)	{

		if(root == null)
			return null;
		if(root == n1)
			return n1;
		if(root == n2)
			return n2;
		
		boolean is_n1_left = covers(root.left,n1);
		boolean is_n2_left = covers(root.left,n2);
		
		if(is_n1_left != is_n2_left)
			return root;
		if(is_n1_left == true)
			return commonAncestorHelper(root.left, n1, n2);
		else 
			return commonAncestorHelper(root.right, n1, n2);
		 
	 }
	 
	 public static TreeNode<Integer> commonAncestor(TreeNode<Integer> root, 
			 TreeNode<Integer> n1, TreeNode<Integer> n2)	{
		 if(!covers(root,n1) || !covers(root,n2))	
			 return null;
		 else 
			 return commonAncestorHelper(root, n1, n2);
	 }
	 
	 
	 /**
	  * 4.8
	  */
		
	 public static boolean subTree(TreeNode<Integer> t1, TreeNode<Integer> t2){
//		 if(t2 == null)	
//			 return true;		/* why not */
		 if(t1 == null)
			 return false;
		 if(t1.data == t2.data)	
			 return matchTree(t1, t2);
		 return subTree(t1.left, t2) || subTree(t1.right, t2);
	 }
	 
	 public static boolean matchTree(TreeNode<Integer> t1, TreeNode<Integer> t2)	{
		 if(t1 == null && t2 == null)
			 return true;
		 if(t1 == null || t2 == null)		// one empty but the other one is not
			 return false;
		 if(t1.data != t2.data)
			 return false;
		 return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
	 }
	 
	 
	 /**
	  * 4.9
	  */
	 
	 public static void print(int[] path, int start, int end)	{
		 for(int i = start; i <= end; i++)	{
			 System.out.println(path[i] + " ");
		 }
		 System.out.println();
	 }
	 
	 public static int depth(TreeNode<Integer> node)	{
		 if(node == null)
			 return 0;
		 else 
			 return 1 + Math.max(depth(node.left), depth(node.right));
	 }
	 
	 
	 public static void findSum(TreeNode<Integer> root, int sum){
		
		 if(root == null)		
			 return;		
		 int[] path = new int[depth(root)];		
		 findSum(root, path, sum, 0);
	 }
	 
	 /* find the Sum */
	 public static void findSum(TreeNode<Integer> root, int[] path, int sum, int level)	{
		 if(root == null)
			 return;
		 path[level] = root.data;
		 
		 /* \*/
		 int temp = 0;
		 for(int i = level; i >= 0; i--)	{
			 temp += path[i];
			 if(temp == sum)	{
				 print(path, i, level);
			 }
		 }
		 findSum(root.left, path, sum, level + 1);
		 findSum(root.right, path, sum, level + 1);
	 }
	 
	 /**
	  * 4.10
	  * 
	  * Decide whether a tree is symmetric using Recursion
	  *
	  */
	 
	 public static boolean mirror(TreeNode<Integer> t1, TreeNode<Integer> t2)	{
		 /* we should always check null first */
		 if(t1 == null && t2 == null)
			 return true;
		 if( (t1 != null && t2 == null) ||  (t2 != null && t1 == null) )
			 return false;
		 
		 /* first check the data, then recurse down */
		 return ( (t1.data == t2.data) && mirror(t1.left, t2.right) && mirror(t1.right, t2.left) );
		 
	 }
	 /* special case to check whether root is null */
	 public static boolean isSymmetric(TreeNode<Integer> root)	{
		 if(root == null)
			 return true;
		 return mirror(root.left, root.right);
	 }
	 
    
	 
	 /* TreeNode stucture */
	 public static class TreeNode<T>	{
		 T data;
		 TreeNode<T> left;
		 TreeNode<T> right;
		
		 TreeNode<T> parent;
		
		 public TreeNode(T data)	{
			 this.data = data;
		 }
		
		 public TreeNode(T data, TreeNode<T> left)	{
			 this.data = data;
			 this.left = left;
		 }
		
		 public TreeNode(T data, TreeNode<T> left, TreeNode<T> right)	{
			 this.data = data;
			 this.left = left;
			 this.right = right;
		 }
		
	 }
		
}


