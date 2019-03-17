package com.learning.algorithm.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {
	static int N = 5;
	static final int s = 1, d = 4;
	static int[][] edgeCost = new int[N][N];
	static Node[] vert = new Node[N];
	
	static {
		// create vertex nodes
		createVertices();
	}
	
	public static void main(String[] args) {
		addEdge(0, 1, 10);
		addEdge(0, 3, 30);
		addEdge(0, 4, 100);
		addEdge(1, 2, 50);
		addEdge(2, 4, 10);
		addEdge(3, 2, 20);
		addEdge(3, 4, 60);

		dijkstra();

		System.out.println("Source : " + s + " , destination : " + d);
		System.out.println(" === Distance from source === ");
		for (int i = 0; i < N; i++)
			System.out.println(i + " : " + vert[i].dist);

		System.out.println(" === Shortest path to destination === ");

		Node node = vert[d];
		Stack<Node> stack = new Stack<Node>();
		while (node.parent != null) {
			node = node.parent;
			stack.add(node);
		}

		printStack(stack);
		System.out.print(d);
	}

	static void createVertices() {
		for (int i = 0; i < N; i++)
			vert[i] = new Node(i);

		vert[s].dist = 0;
	}

	static void printStack(Stack<Node> stack) {
		ListIterator<Node> it = stack.listIterator(stack.size());

		while (it.hasPrevious()) {
			System.out.print(it.previous().key + " --> ");
		}
	}

	static void addEdge(int u, int v, int w) {
		vert[u].childs.add(vert[v]);

		// assign weight to edge cost matrix
		edgeCost[u][v] = w;
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(N,
				new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						return o1.dist - o2.dist;
					}
				});

		pq.add(vert[s]);

		while (!pq.isEmpty()) {
			Node min = pq.poll();
			min.visited = true;

			// update dist for all the adjacent nodes
			for (Node n : min.childs) {
				if (!n.visited) {
					// relax the node
					if (n.dist > min.dist + edgeCost[min.key][n.key]) {
						n.dist = min.dist + edgeCost[min.key][n.key];
						n.parent = min;

						// add the node if it is not already present in the
						// queue
						if (!pq.contains(n))
							pq.add(n);
					}
				}
			}
		}
	}

	static class Node {
		int key;
		int dist;
		Node parent;
		boolean visited;
		ArrayList<Node> childs;

		Node(int key) {
			this.key = key;
			this.dist = Integer.MAX_VALUE;
			this.parent = null;
			childs = new ArrayList<Node>();
		}

		void setParent(Node p) {
			this.parent = p;
		}
	}

}
