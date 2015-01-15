package com.learning.algorithm.tree;

public class BST<T extends Comparable<T>> {
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		
		//root node
		Node<Integer> root = new Node<Integer>(60);
		
		//insert nodes
		tree.insertNode(root, 20);
		tree.insertNode(root, 10);
		tree.insertNode(root, 30);
		tree.insertNode(root, 100);
		tree.insertNode(root, 70);
		tree.insertNode(root, 120);
		
		//traversal
		tree.printInOrder(root);
		System.out.println();
		
		tree.printPreOrder(root);
		System.out.println();
		
		tree.printPostOrder(root);
		System.out.println();
		
		//print min/max
		System.out.println("Min : " + tree.getMin(root) + " , Max : " + tree.getMax(root));
		
		//wrong BST
		Node<Integer> root1 = new Node<Integer>(30);
		root1.left = new Node<Integer>(100);
		root1.right = new Node<Integer>(120);
		root1.left.left = new Node<Integer>(200);
		
		//check isBST
		System.out.println("isBST: " + tree.isBST(root1, new Node<Integer>()));
	}
	
	void insertNode(Node<T> root, T key) {
		if(root == null)
			return;
		
		Node<T> _new = createNode(key);
		
		if(key.compareTo(root.key) < 0) {
			if(root.left == null) {
				root.left = _new;
			} else {
				insertNode(root.left, key);
			}
		} else {
			if(root.right == null) {
				root.right = _new;
			} else {
				insertNode(root.right, key);
			}
		}	
	}
	
	Node<T> createNode(T key) {
		return new Node<T>(key);
	}
	
	void printInOrder(Node<T> root) {
		if(root == null) 
			return;
		
		if(root.left != null)
			printInOrder(root.left);
		
		System.out.print(root.key + " ");
		
		if(root.right != null)
			printInOrder(root.right);
	}
	
	void printPreOrder(Node<T> root) {
		if(root == null) 
			return;
		
		System.out.print(root.key + " ");
		
		if(root.left != null)
			printPreOrder(root.left);
		
		if(root.right != null)
			printPreOrder(root.right);
	}

	void printPostOrder(Node<T> root) {
		if(root == null) 
			return;
		
		if(root.left != null)
			printPostOrder(root.left);
		
		if(root.right != null)
			printPostOrder(root.right);
		
		System.out.print(root.key + " ");
	}
	
	boolean isBST(Node<T> root, Node<T> prev) {
		if(root == null)
			return true;
		
		if(!isBST(root.left, prev))
			return false;
		
		if(prev != null && prev.key != null && prev.key.compareTo(root.key) >= 0) {
			return false;
		}
		
		prev.key = root.key;
		
		return isBST(root.right, prev);
	}
	
	T getMin(Node<T> root) {
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root.key;
		
		return getMin(root.left);
	}
	
	T getMax(Node<T> root) {
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root.key;
		
		return getMax(root.right);
	}
}

class Node<T extends Comparable<T>> {
	T key;
	
	Node<T> left;
	Node<T> right;
	
	Node() {
		
	}
	
	Node(T key) {
		this.key = key;
		
		this.left = null;
		this.right = null;
	}
}
