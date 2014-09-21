package basic_data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * not yet !!!
 * 
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	// create a null BST
	private BinaryNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	// node structure
	static class BinaryNode<T> {

		T data;
		BinaryNode<T> left;
		BinaryNode<T> right;

		public BinaryNode(T data) {
			this(data, null, null);
		}

		public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	// clear a tree
	public void clear() {
		root = null;
	}

	// determine if empty
	public boolean isEmpty() {
		return root == null;
	}

	// insert value
	public void insert(T t) {
		root = insert(t, root);
	}

	// delete
	public void remove(T t) {
		root = remove(t, root);
	}

	// search from tree root
	public boolean contains(T t) {
		return contains(t, root);
	}

	// contains
	public boolean contains(T t, BinaryNode<T> node) {
		if (node == null)
			return false;
		int result = t.compareTo(node.data);
		if (result > 0)
			return contains(t, node.right);
		else if (result < 0)
			return contains(t, node.left);
		else
			return true;
	}

	// find the min value of the tree !!!!!!!!!! only one function
	public T findMin(BinaryNode<T> node) {

		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}

	// find the min node (we have to use recursion in this case)
	public BinaryNode<T> findMinRecursion(BinaryNode<T> node) {
		if (node == null)
			return null;
		else if (node.left == null)
			return node;
		return findMinRecursion(node.left); // recursively search
	}

	// find the max value
	public T findMax() {
		if (isEmpty()) {
			System.out.println("the BST is null");
			return null;
		} else
			return findMax(root).data;
	}

	// find the max node
	public BinaryNode<T> findMax(BinaryNode<T> node) {
		if (node != null) {
			while (node.right != null)
				node = node.right;
		}
		return node;
	}

	// insert from somewhere
	// recursion
	public BinaryNode<T> insert(T t, BinaryNode<T> node) {
		if (node == null) // create a new Node
			return new BinaryNode<T>(t, null, null);

		int result = t.compareTo(node.data);
		if (result < 0)
			node.left = insert(t, node.left);
		else if (result > 0)
			node.right = insert(t, node.right);
		// else:(result == 0): do Nothing
		return node;
	}

	/**
	 * decide whether we should delete from somewhere
	 * 
	 * @param t
	 * @param node
	 * @return
	 */
	public BinaryNode<T> remove(T t, BinaryNode<T> node) {
		if (node == null)
			return node; // not found!!! doNothing
		int result = t.compareTo(node.data);
		if (result > 0)
			node.right = remove(t, node.right);
		else if (result < 0)
			node.left = remove(t, node.left);
		else if (node.left != null && node.right != null) { // result == 0
			/*
			 * this is really easy to make mistake!!! we should find the min of
			 * the right node... or we can also find the max of the left node...
			 */
			node.data = findMin(node.right);
			node.right = remove(node.data, node.right);
		} else
			// result == 0, but one of node's child is null
			node = (node.left != null) ? node.left : node.right;
		return node;
	}

	// preOrder
	public void preOrder(BinaryNode<T> node) {
		if (node != null) {
			System.out.print(node.data + "->");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	// levelOrder
	public void levelOrder(BinaryNode<T> root) {
		Queue<BinaryNode<T>> level = new LinkedList<BinaryNode<T>>();
		level.add(root);
		while (!level.isEmpty()) {
			BinaryNode<T> node = level.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				level.add(node.left);
			if (node.right != null)
				level.add(node.right);
		}
	}

	// test
	public static void main(String[] args) {
		BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();

		int arr[] = { 33, 2, 15, 2, 5, 22, 7 };
		for (int i = 0; i < arr.length; i++) {
			searchTree.insert(arr[i]);
		}

		searchTree.levelOrder(searchTree.root);
		System.out.println();

		searchTree.preOrder(searchTree.root);
		System.out.println();

		// MOST IMPORTANT !!!
		searchTree.remove(2);
		searchTree.preOrder(searchTree.root);
		System.out.println();

		int a = searchTree.findMax();
		System.out.println("the max value is " + a);
		Integer b = searchTree.findMin(searchTree.root);
		System.out.println("the min value is " + b);
	}

}