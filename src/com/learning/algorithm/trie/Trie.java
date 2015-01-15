package com.learning.algorithm.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {
	public static void main(String[] args) {
		// create head node
		Node head = new Node();

		insert(head, "tea");
		insert(head, "tad");
		insert(head, "ten");
		insert(head, "toy");
		insert(head, "tool");
		insert(head, "a");
		insert(head, "i");
		insert(head, "in");

		System.out.println(find(head, "inn"));

		System.out.println(countStartWithPrefix(head, "tt"));

		startWithPrefix(head, "to");
	}

	private static void insert(Node root, String key) {
		Node current = root;

		int length = key.length();

		// insert each characters in the trie
		for (int i = 0; i < length; i++) {
			String ch = String.valueOf(key.charAt(i));

			Node childNode = current.child.get(ch);

			if (childNode == null) {
				// create child node
				childNode = new Node();

				// put new node with the key
				current.child.put(ch, childNode);
			}

			// assign pointer to newly found node
			current = childNode;

			// update prefix count of the current node
			current.countPrefixMatch++;
		}

		// insertion completed
		// mark current node as terminal node
		current.isTerminal = true;
	}

	private static boolean find(Node root, String key) {
		if (root == null)
			return false;

		Node current = root;

		int length = key.length();

		// check each characters in the trie
		for (int i = 0; i < length; i++) {
			String ch = String.valueOf(key.charAt(i));

			if (current.child.get(ch) == null) {
				return false;
			}

			current = current.child.get(ch);
		}

		return current.isTerminal;
	}

	private static void startWithPrefix(Node root, String prefix) {
		if (root == null)
			return;

		Node current = root;

		int length = prefix.length();

		// check each characters in the trie
		for (int i = 0; i < length; i++) {
			String ch = String.valueOf(prefix.charAt(i));

			if (current.child.get(ch) == null) {
				return;
			}

			current = current.child.get(ch);
		}

		//System.out.print(prefix);

		// do DFS at the current node
		DFS(current, prefix);
	}

	private static void DFS(Node root, String prefix) {
		if (root == null)
			return;

		// stack holds visited nodes
		Stack<Node> stack = new Stack<Node>();

		stack.push(root);

		while (!stack.isEmpty()) {
			/*if(stack.peek() == root && getUnvisitedNode(root) != null) {
				System.out.println();
				System.out.print(prefix);
			}*/
			
			Node unVisitedNode = getUnvisitedNode(stack.peek());
			
			if (unVisitedNode == null) {
				stack.pop();
			} else {
				unVisitedNode.isVisited = true;

				stack.push(unVisitedNode);
			}
		}
	}

	private static Node getUnvisitedNode(Node n) {
		for (Map.Entry<String, Node> entry : n.child.entrySet()) {
			if (!entry.getValue().isVisited) {
				System.out.print(entry.getKey());

				return entry.getValue();
			}
		}

		return null;
	}

	private static int countStartWithPrefix(Node root, String prefix) {
		if (root == null)
			return 0;

		Node current = root;

		int length = prefix.length();

		// check each characters in the trie
		for (int i = 0; i < length; i++) {
			String ch = String.valueOf(prefix.charAt(i));

			if (current.child.get(ch) == null) {
				return 0;
			}

			current = current.child.get(ch);
		}

		return current.countPrefixMatch;
	}

	static class Node {
		private int countPrefixMatch;
		private HashMap<String, Node> child;
		private boolean isTerminal;
		private boolean isVisited;

		public Node() {
			countPrefixMatch = 0;
			isTerminal = false;
			isVisited = false;

			child = new HashMap<String, Node>();
		}
	}

}
