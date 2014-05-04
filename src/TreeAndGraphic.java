import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAndGraphic {
	public static void main(String[] args)	{
		int[] arr = {1,2,3,4,5,6};
		BinaryNode<Integer> head = newTree(arr);
		//head.right.left.right = new BinaryNode<Integer>(8);
		BFS(head);
		System.out.println("depth: " + depthOfTree(head));
		System.out.println("is BST? " + isBST(head));
		
		//System.out.println("4.4: " + createListEachDepth(head).get(3).size());
		
		int[] arr2 = {1,2,3,4,5,6,7,8};
		BinaryNode<Integer> root = minimalBST(arr2, 0, arr2.length-1);
		//root.left.data = 0;
		BFS(root);
		System.out.println("is BST? " + isBST(root));
		findSum(root, 9);
		
		
	}
	
	public static BinaryNode<Integer> newTree(int[] arr)	{
		BinaryNode<Integer> head = new BinaryNode<Integer>(arr[0]);
		for(int i=1; i<arr.length; i++){
			insertNode(head, arr[i]);
		}
		return head;
	}
	
	
	private static void insertNode(BinaryNode<Integer> head, int val)	{
		if(head == null)
			return;
		
		Queue<BinaryNode<Integer>> queue = new LinkedList<BinaryNode<Integer>>();
		queue.add(head);
		
		while(!queue.isEmpty())	{
			BinaryNode<Integer> node = queue.poll();
			if(node.left == null)	{
				node.left = new BinaryNode<Integer>(val);
				return;
			}
			queue.add(node.left);
			if(node.right == null)	{
				node.right = new BinaryNode<Integer>(val);
				return;
			}
			
			queue.add(node.right);
		}
	}
	
	public static void DFSinorder(BinaryNode<Integer> head){
		if(head == null)
			return;
		DFSinorder(head.left);
		System.out.print(head.data + " ");
		DFSinorder(head.right);
	}
	
	public static void BFS(BinaryNode<Integer> head){
		if(head == null)
			return;
		
		Queue<BinaryNode<Integer>> queue = new LinkedList<BinaryNode<Integer>>();
		queue.add(head);
		
		while(!queue.isEmpty()){
			int count = queue.size();
			while(count-- > 0)	{
				BinaryNode<Integer> node = queue.poll();
				System.out.print(node.data + " ");
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			System.out.println();
		}
	}
	
	public static int depthOfTree(BinaryNode<Integer> head)	{
		if(head == null)
			return 0;
		return Math.max(depthOfTree(head.left), depthOfTree(head.right))+1;
	}
	
	/**
	 * 4.1
	 */
	public static boolean isBalanced(BinaryNode<Integer> root){
		if( depth(root) == -1)
			return false;
		return true;
	}
	
	
	public static int depth(BinaryNode<Integer> root){
		if(root == null)
			return 0;
		int leftDepth = depth(root.left);
		if(leftDepth == -1)
			return -1;
		int rightDepth = depth(root.right);
		if(rightDepth == -1)
			return -1;
		if(Math.abs(leftDepth - rightDepth) > 1)	{
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public static BinaryNode<Integer> insertBST(BinaryNode<Integer> root, int val){
		if(root == null)
			return new BinaryNode<Integer>(val);
		if(val < root.data){
			root.left = insertBST(root.left, val);
		}else{
			root.right = insertBST(root.right, val);
		}
		return root;
	}
	
	/**
	 * 4.3
	 */
	public static BinaryNode<Integer> minimalBST(int[] arr, int left, int right){
		if(left > right)
			return null;
		int mid = (left+right)/2;
		BinaryNode<Integer> n = new BinaryNode<Integer>(arr[mid]);
		
		n.left = minimalBST(arr, left, mid-1);
		
		n.right = minimalBST(arr, mid+1, right);
		
		return n;
	}
	
	/**
	 * 4.4
	 */
	public static List<LinkedList<BinaryNode<Integer>>> createListEachDepth(BinaryNode<Integer> root){
		List<LinkedList<BinaryNode<Integer>>> lists = new ArrayList<LinkedList<BinaryNode<Integer>>>();
		Queue<BinaryNode<Integer>> q = new LinkedList<BinaryNode<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()){
			int count = q.size();
			LinkedList<BinaryNode<Integer>> list = new LinkedList<BinaryNode<Integer>>();
			while(count-- > 0){
				BinaryNode<Integer> n = q.poll();
				list.add(n);
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
			lists.add(list);
		}
		
		return lists;
	}
	
	/**
	 * 4.5
	 */
	public static boolean isBST(BinaryNode<Integer> root){
		if(root == null)
			return true;
		//boolean is_left_BST = true, is_right_BST = true, is_my_BST = true;
		if(root.left != null){
			if(!isBST(root.left)) 
				return false;
			if(root.left.data >= root.data)
				return false;
		}
		if(root.right != null){
			if(!isBST(root.right)) 
				return false;
			if(root.right.data <= root.data)
				return false;
		}

		return true;
			
	}
	
	/**
	 * 4.6
	 */
	public static Integer findNextInOrder(BinaryNode<Integer> node){
		if(node.right != null){
			BinaryNode<Integer> child = node.right;
			while(child.left != null){
				child = child.left;
			}
			return child.data;
		}
		else{
			BinaryNode<Integer> parent = node.parent;

			while(parent!=null && parent.left != node){
				node = parent;
				parent = parent.parent;
			}
			if(parent != null)
				return parent.data; 
			else 
				return null;
		}
		
	}
	
	/**
	 * 4.7
	 */
	public static boolean covers(BinaryNode<Integer> root, BinaryNode<Integer> q){
		if(root == null)
			return false;
		if(root == q)
			return true;
		return covers(root.left, q) || covers(root.right, q);
	}
	
	public static BinaryNode<Integer> findCommonAncesterHelper(BinaryNode<Integer> root, BinaryNode<Integer> n1, BinaryNode<Integer> n2){
		if(root == null)
			return null;
		if(root == n1)
			return n1;
		if(root == n2)
			return n2;
		
		boolean is_n1_left = covers(root.left, n1);
		boolean is_n2_left = covers(root.left, n2);
		
		if(is_n1_left != is_n2_left)
			return root;
		
		BinaryNode<Integer> child_side = (is_n1_left)? root.left:root.right;
		return findCommonAncesterHelper(child_side, n1, n2);
	}
	
	public static BinaryNode<Integer> findCommonAncester(BinaryNode<Integer> root, BinaryNode<Integer> n1, BinaryNode<Integer> n2){
		if(!covers(root, n1) || !covers(root, n2))
			return null; //error
		return findCommonAncesterHelper(root, n1, n2);
	}
	
	/**
	 * 4.8
	 */
	public static boolean isTheSameTree(BinaryNode<Integer> t1, BinaryNode<Integer> t2){
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 == null || t2 == null)
			return false;
		if(t1 != t2)
			return false;
		return isTheSameTree(t1.left, t2.left) && isTheSameTree(t1.right, t2.right);
	}
	
	public static boolean isSubTree(BinaryNode<Integer> t1, BinaryNode<Integer> t2){
		if(t1 == null)
			return false;
		
		if(t1 == t2){
			boolean isSub = isTheSameTree(t1, t2);
			if(isSub) return true;
		}
		
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}
	
	/**
	 * 4.9
	 */
	public static void printPath(int[] path, int start, int end){
		for(int i=start; i<=end; i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
	public static void findSum(BinaryNode<Integer> root, int[] path, int sum, int level){
		if(root == null)
			return;
		
		path[level] = root.data;
		
		int t = 0;
		for(int i=level; i>=0; i--){
			t+=path[i];
			if(t == sum){
				printPath(path, i, level);
			}
		}
		
		findSum(root.left, path, sum, level+1);
		findSum(root.right, path, sum, level+1);
	}
	
	public static void findSum(BinaryNode<Integer> root, int sum){
		if(root == null) return;
		int[] path = new int[depthOfTree(root)];
		findSum(root, path, sum, 0);
	}
}

class BinaryNode<T>{
	T data;
	BinaryNode<T> left;
	BinaryNode<T> right;
	
	BinaryNode<T> parent;
	
	public BinaryNode(T data){
		this.data = data;
	}
	
	public BinaryNode(T data, BinaryNode<T> left){
		this.data = data;
		this.left = left;
	}
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
