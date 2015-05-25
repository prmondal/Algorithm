package com.learning.algorithm.string;

import java.util.HashMap;
import java.util.Map.Entry;

public class PalindroimicPair {

	public static void main(String[] args) {
		String[] words = { "wxyz", "tab", "abc", "eh", "hel", "bat", "lleh",
				"cba", "yxw" };
		Node root = new Node();
		findPairs(words, root);
	}

	static void findPairs(String[] words, Node root) {
		if (root == null)
			return;

		for (int i = 0, l = words.length; i < l; i++) {
			String str = words[i], s = reverse(str);

			Node curr = root;

			for (int j = 0, len = str.length(); j < len; j++) {
				if (!curr.child.containsKey(s.charAt(j))) {
					// insert word if the first char is not matched or there are
					// characters remaining in both strings
					if (j == 0 || (j < len && !curr.isTerminal)) {
						insert(root, str, i);
						break;
					}

					// chrs remaining in the word
					if (curr.isTerminal && j < len) {
						if (isPalindrome(s.substring(j))) {
							// pair found
							System.out.println(words[curr.index] + ", " + str);
						}

						insert(root, str, i);
						break;
					}
				} else {
					curr = curr.child.get(s.charAt(j));

					// both strings exactly matched
					if (curr.isTerminal) {
						if (j == len - 1) {
							System.out.println(words[curr.index] + ", " + str);
						}
					}
				}
			}

			// chrs remaining in word in Trie
			if (!curr.isTerminal) {
				// continue to check rest is palindrome or not
				StringBuilder rest = new StringBuilder("");

				while (!curr.isTerminal) {
					for (Entry<Character, Node> e : curr.child.entrySet()) {
						rest.append(e.getKey());
						curr = e.getValue();
					}
				}

				if (isPalindrome(rest.toString())) {
					System.out.println(words[curr.index] + ", " + str);
				}
			}
		}
	}

	static String reverse(String s) {
		StringBuilder str = new StringBuilder(s);
		int l = s.length();

		for (int i = 0; i < l / 2; i++) {
			char c = str.charAt(i);
			int j = l - i - 1;
			str.setCharAt(i, str.charAt(j));
			str.setCharAt(j, c);
		}

		return str.toString();
	}

	static boolean isPalindrome(String s) {
		int l = s.length();

		if (l == 1 || l == 0)
			return true;

		for (int i = 0; i < l / 2; i++) {
			if (s.charAt(i) != s.charAt(l - i - 1))
				return false;
		}

		return true;
	}

	static boolean find(Node root, String key) {
		if (root == null)
			return false;

		Node curr = root;

		int l = key.length();

		for (int i = 0; i < l; i++) {
			if (!curr.child.containsKey(key.charAt(i)))
				return false;
			else {
				curr = curr.child.get(key.charAt(i));
			}
		}

		return curr.isTerminal == true;
	}

	static void insert(Node root, String key, int index) {
		if (root == null)
			return;

		Node curr = root;

		int l = key.length();

		for (int i = 0; i < l; i++) {
			if (curr.child.containsKey(key.charAt(i))) {
				curr = curr.child.get(key.charAt(i));
			} else {
				Node _new = new Node();
				curr.child.put(key.charAt(i), _new);
				curr = _new;
			}
		}

		curr.isTerminal = true;
		curr.index = index;
	}

	static class Node {
		HashMap<Character, Node> child;
		boolean isTerminal;
		int index = -1;

		Node() {
			child = new HashMap<Character, Node>();
		}
	}

}
