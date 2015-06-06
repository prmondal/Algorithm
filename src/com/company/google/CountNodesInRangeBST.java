package com.company.google;

import java.util.Stack;

public class CountNodesInRangeBST {

	public static void main(String[] args) {
		Node root = new Node(8);
		insert(root, 4);
		insert(root, 10);
		insert(root, 2);
		insert(root, 6);
		insert(root, 1);
		insert(root, 3);
		insert(root, 7);
		insert(root, 9);
		insert(root, 12);

		printInorderIt(root);
		
		
	}

	static int countNodes(Node root, int l, int r) throws OutOfRangeException {
		if (root == null)
			return 0;

		if (r < l) {
			throw new OutOfRangeException("r < l Error.");
		}

		if (root.key <= r && root.key >= l) {
			return 1 + countNodes(root.left, l, r)
					+ countNodes(root.right, l, r);
		}

		if (root.key > r) {
			return countNodes(root.left, l, r);
		}

		if (root.key < l) {
			return countNodes(root.right, l, r);
		}

		return 0;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.key + " ");
		printInorder(root.right);
	}
	
	static void printInorderIt(Node root) {
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		
		Node curr = root;
		
		boolean done = false;
		
		while(!done) {
			if(curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				if (!s.isEmpty()) {
					Node top = s.pop();
					System.out.print(top.key + " ");
					
					curr = top.right;
				} else {
					done = true;
				}
			}
		}
	}

	static void insert(Node root, int d) {
		if (root == null) {
			return;
		}

		if (root.key > d) {
			if (root.left == null) {
				root.left = new Node(d);
				return;
			}

			insert(root.left, d);
		} else {
			if (root.right == null) {
				root.right = new Node(d);
				return;
			}

			insert(root.right, d);
		}
	}

	static class Node {
		int key;
		Node left = null;
		Node right = null;

		Node(int key) {
			this.key = key;
		}
	}

	static class OutOfRangeException extends Exception {
		OutOfRangeException(String msg) {
			super(msg);
		}
	}

}
