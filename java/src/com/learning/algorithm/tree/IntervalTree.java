package com.learning.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class IntervalTree {

	public static void main(String[] args) {
		// Build interval tree
		IntervalTree itree = new IntervalTree();

		// create root
		/*
		 * Node root = new Node(new Interval(20, 36));
		 * 
		 * // insert nodes itree.insert(root, new Interval(3, 41));
		 * itree.insert(root, new Interval(0, 1)); itree.insert(root, new
		 * Interval(29, 99)); itree.insert(root, new Interval(10, 15));
		 */

		// create root
		Node root = new Node(new Interval(15, 20));

		// insert nodes
		itree.insert(root, new Interval(10, 30));
		itree.insert(root, new Interval(5, 20));
		itree.insert(root, new Interval(12, 15));
		itree.insert(root, new Interval(17, 19));
		itree.insert(root, new Interval(30, 40));

		// print inorder
		itree.printInOrder(root);
		
		//print all over lapping intervals
		List<Interval> result = new ArrayList<Interval>();
		
		itree.getOverlappingIntervals(root, new Interval(15,  18), result);
		
		//print all the intervals
		if(result.size() == 0)
			System.out.println("\nNo overlapped intervals found.");
		else
			for(Interval i : result) {
				System.out.print("\n[" + i.low + "-" + i.high + "]");
			}
	}

	private void printInOrder(Node root) {
		if (root == null)
			return;

		printInOrder(root.left);

		System.out.print("Interval: ");
		printInterval(root.i);
		System.out.print(" , max = " + root.getMax());
		System.out.println();

		printInOrder(root.right);
	}

	private void printInterval(Interval i) {
		System.out.print("[" + i.low + "-" + i.high + "]");
	}

	// insert nodes in tree
	void insert(Node root, Interval i) {
		if (root == null)
			return;

		if (i.low < root.getLeft()) {
			if (root.left != null) {
				insert(root.left, i);
			} else {
				Node _new = new Node(i);
				root.left = _new;
			}
		} else {
			if (root.right != null) {
				insert(root.right, i);
			} else {
				Node _new = new Node(i);
				root.right = _new;
			}
		}

		if (root.getMax() < i.high) {
			root.setMax(i.high);
		}
	}
	
	//search for overlapping intervals
	void getOverlappingIntervals(Node root, Interval t, List<Interval> result) {
		if(root == null)
			return;
		
		//if max of current node is less than t.low
		//no overlapping intervals found
		if(root.getMax() < t.low)
			return;
		
		if(isOverlapped(root.i, t)) {
			result.add(root.i);
		}
		
		getOverlappingIntervals(root.left, t, result);
		getOverlappingIntervals(root.right, t, result);
		
		return;
	}
	
	private boolean isOverlapped(Interval a, Interval b) {
		return (b.high >= a.low) && (b.low <= a.high);
	}

	static class Interval {
		int low;
		int high;

		Interval(int l, int h) {
			this.low = l;
			this.high = h;
		}
	}

	static class Node {
		int max = Integer.MIN_VALUE;
		Interval i = null;

		Node left = null;
		Node right = null;

		Node(Interval i) {
			this.i = i;
			this.max = i.high;
		}

		void setMax(int max) {
			this.max = max;
		}

		int getMax() {
			return max;
		}

		int getLeft() {
			return i.low;
		}

		int getRight() {
			return i.high;
		}
	}
}
