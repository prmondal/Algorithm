package com.practice.hackerrank;

import java.util.Scanner;

public class SwapNodesTree {
	static Node[] nodes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		nodes = new Node[N];
		
		for(int i = 0; i < N; i++)
			nodes[i] = new Node(i + 1);
		
		for(int i = 1; i <= N; i++) {
			int v1 = sc.nextInt(), v2 = sc.nextInt();
			
			if(v1 != -1) nodes[i - 1].left = nodes[v1 - 1];
			if(v2 != -1) nodes[i - 1].right = nodes[v2 - 1];
		}
		
		int t = sc.nextInt();
		
		while(t > 0) {
			t--;
			swapNodesUtil(nodes[0], sc.nextInt());
		}
	}
	
	static void swapNodesUtil(Node root, int K) {
		if(root == null || K <= 0)
			return;
		
		int h = height(root) + 1;
		
		for(int i = K; i <= h; i = 2 * K++) {
			swapNodes(root, i, 1);
		}
		
		printinOrderUtil();
	}
	
	static void swapNodes(Node root, int l, int currLevel) {
		if(root == null)
			return;
		
		if(currLevel == l) {
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			return;
		}
		
		swapNodes(root.left, l, currLevel + 1);
		swapNodes(root.right, l, currLevel + 1);
	}
	
	static int height(Node root) {
		if(root == null)
			return -1;
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	static void printinOrderUtil() {
		StringBuilder result = new StringBuilder();
		printinOrder(nodes[0], result);
		System.out.println(result.toString().trim());
	}
	
	static void printinOrder(Node root, StringBuilder result) {
		if(root == null)
			return;
		
		printinOrder(root.left, result);
		result.append(root.id + " ");
		printinOrder(root.right, result);
	}
	
	static Node create(int i) {
		return new Node(i);
	}
	
	static class Node {
		int id = 0;
		Node left = null;
		Node right = null;
		
		Node(int id) {
			this.id = id;
		}
	}

}
