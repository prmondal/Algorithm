package com.learning.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadedBTree {

	public static void main(String[] args) {
		Node root = new Node(1);

		/*
		 * 1 / \ 2 3 / \ / \ 4 5 6 7
		 */

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Queue<Node> q = new LinkedList<Node>();

		inOrderBTree(root, q);

		genThreadedBTree(root, q);

		inorderThreadedTree(root);
	}

	static void genThreadedBTree(Node root, Queue<Node> q) {
		if (root == null || q.isEmpty())
			return;

		genThreadedBTree(root.left, q);

		q.poll();

		if (root.right == null) {
			root.right = q.peek();

			root.isThreaded = true;

			return;
		}

		genThreadedBTree(root.right, q);
	}

	// do inorder traversal and populate queue
	static void inOrderBTree(Node root, Queue<Node> q) {
		if (root == null)
			return;

		if (root.left != null) {
			inOrderBTree(root.left, q);
		}

		q.add(root);

		if (root.right != null) {
			inOrderBTree(root.right, q);
		}
	}

	static Node leftMost(Node root) {
		if (root == null)
			return root;

		Node curr = root;

		while (curr.left != null) {
			curr = curr.left;
		}

		return curr;
	}

	static void inorderThreadedTree(Node root) {
		if (root == null)
			return;

		Node leftestNode = leftMost(root);

		Node curr = leftestNode;

		while (curr != null) {
			System.out.print(curr.key + " ");

			if (curr.isThreaded) {
				curr = curr.right;

				continue;
			}

			curr = leftMost(curr.right);
		}
	}

	static class Node {
		int key;

		Node left;
		Node right;

		boolean isThreaded = false;

		Node(int key) {
			this.key = key;
		}
	}

}
