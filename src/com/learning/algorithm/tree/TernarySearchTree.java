package com.learning.algorithm.tree;

//http://www.drdobbs.com/database/ternary-search-trees/184410528?pgno=1
public class TernarySearchTree {
	private static Node root = null;

	public static void main(String[] args) {
		String[] dict = { "as", "at", "be", "by", "he", "in", "is", "it", "of",
				"on", "or", "to" };

		root = cacheDict(dict);

		// printInOrder(root);

		System.out.println(search(root, "at", 0));
	}
	
	static Node cacheDict(String[] dict) {
		// insert all words in tree
		for (String s : dict) {
			root = insert(root, s, 0);
		}

		return root;
	}

	

	static boolean search(Node root, String word, int idx) {
		if (root == null && idx < word.length())
			return false;

		if (idx >= word.length()) {
			return true;
		}

		return (root.key == word.charAt(idx)) ? search(root.mid, word, ++idx)
				: ((root.key < word.charAt(idx)) ? search(root.right, word, idx)
						: search(root.left, word, idx));
	}

	static Node insert(Node root, String word, int idx) {
		if (idx >= word.length()) {
			return null;
		}

		if (root == null) {
			root = new Node(word.charAt(idx));

			root.mid = insert(root.mid, word, ++idx);

			return root;
		}

		if (root.key < word.charAt(idx)) {
			root.right = insert(root.right, word, idx);
		} else if (root.key > word.charAt(idx)) {
			root.left = insert(root.left, word, idx);
		} else {
			root.mid = insert(root.mid, word, ++idx);
		}

		return root;
	}
	
	static void printInOrder(Node root) {
		if (root == null)
			return;

		printInOrder(root.left);

		System.out.print(root.key + " ");

		if (root.mid != null) {
			printInOrder(root.mid);
		}

		printInOrder(root.right);
	}

	

	static class Node {
		char key;

		Node left;
		Node mid;
		Node right;

		Node(char key) {
			this.key = key;
		}
	}
}
