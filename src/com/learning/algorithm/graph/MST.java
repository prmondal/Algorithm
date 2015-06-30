package com.learning.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST {
	// the array contains the representative of each disjoint sets/graph
	static int[] rep;

	// the array contains rank (height of subtree rooted at the node)
	static int[] rank;

	public static void main(String[] args) {
		
		 int N = 5; Graph g = new Graph(N, false); g.addEdge(0, 1, 2);
		 g.addEdge(0, 3, 6); g.addEdge(1, 3, 8); g.addEdge(1, 2, 3);
		 g.addEdge(1, 4, 5); g.addEdge(2, 4, 7); g.addEdge(3, 4, 9);
		 

		
		 /*int N = 4; Graph g = new Graph(N, false); g.addEdge(0, 1, 2);
		 g.addEdge(0, 3, 8); g.addEdge(0, 2, 3); g.addEdge(1, 2, 7);
		 g.addEdge(2, 3, 9);
		 */

		/*int N = 6;
		Graph g = new Graph(N, false);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 3, 8);
		g.addEdge(1, 3, 11);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 4, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, 7);
		g.addEdge(4, 5, 6);*/

		int minW = prime(g);
		System.out.println("MST weight using Prime's Algorithm: " + minW);

		// populate rep array
		// initially there are N disjoint sets
		rep = new int[N];
		rank = new int[N];

		makeSet(rep);

		int minWK = kruskal(g);
		System.out.println("MST weight using Kruskal's Algorithm: " + minWK);
	}

	static int prime(Graph g) {
		// max edges
		int E = g.V * (g.V - 1) / 2, minW = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(E,
				new Comparator<Edge>() {
					@Override
					public int compare(Edge o1, Edge o2) {
						return o1.w - o2.w;
					}
				});

		Node s = g.getNode(0);
		s.visited = true;

		for (Edge e : s.childs)
			pq.add(e);

		// total edges for N node is N - 1
		for (int i = 1; i <= g.V - 1; i++) {
			Edge min = pq.poll();

			// remove all the min weight edges which forms loop
			while (g.getNode(min.b).visited && g.getNode(min.e).visited) {
				min = pq.poll();
			}

			g.getNode(min.e).visited = true;

			// add all adjacent nodes
			for (Edge n : g.getNode(min.e).childs) {
				if (!g.getNode(n.e).visited)
					pq.add(n);
			}

			minW += min.w;
			System.out.println(min.b + " - " + min.e + " : " + min.w);
		}

		return minW;
	}

	static void makeSet(int[] p) {
		for (int i = 0, l = p.length; i < l; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		while (x != rep[x]) {
			x = rep[x];
		}

		return x;
	}

	static void unionSet(int x, int y) {
		linkSet(rep[x], rep[y]);
	}

	static void linkSet(int x, int y) {
		if (rank[x] > rank[y]) {
			rep[y] = x;
		} else if (rank[x] < rank[y]) {
			rep[x] = y;
		} else {
			rep[x] = y;
			rank[y]++;
		}
	}

	static int kruskal(Graph g) {
		// sort all the edges by weight
		Collections.sort(g.edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});

		int numVerticesConnected = 1, minW = 0;

		for (Edge edge : g.edges) {
			// update representative element
			if (findSet(edge.b) != findSet(edge.e)) {
				unionSet(edge.b, edge.e);
				minW += edge.w;
				numVerticesConnected++;
				System.out.println(edge.b + " - " + edge.e + " : " + edge.w);
			}

			// all nodes are connected
			if (numVerticesConnected >= g.V)
				break;
		}

		return minW;
	}

	static class Graph {
		private final int V;
		private Node[] nodes;
		private boolean isDirected;
		private ArrayList<Edge> edges;

		Graph(int V, boolean isDirected) {
			this.V = V;
			this.isDirected = isDirected;
			nodes = new Node[V];
			edges = new ArrayList<Edge>();

			for (int i = 0; i < V; i++)
				nodes[i] = new Node(i, 0);
		}

		Node getNode(int i) {
			return nodes[i];
		}

		void addEdge(int u, int v, int w) {
			// add new edge to edge list
			edges.add(new Edge(u, v, w));

			Node a = nodes[u];
			Node b = nodes[v];

			a.childs.add(new Edge(a.id, b.id, w));

			if (!isDirected) {
				b.childs.add(new Edge(b.id, a.id, w));
			}
		}

		void printGraph() {
			for (int i = 0; i < V; i++) {
				for (Edge e : nodes[i].childs) {
					System.out.println(i + "-" + e.e + " : " + e.w);
				}
			}
		}
	}

	static class Node {
		int id;
		int cost;
		boolean visited;
		Node parent = null;
		ArrayList<Edge> childs;

		Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
			childs = new ArrayList<Edge>();
		}

		void setParent(Node p) {
			this.parent = p;
		}

		void addAdj(Node b, int w) {
			this.childs.add(new Edge(this.id, b.id, w));
		}
	}

	static class Edge {
		int b, e, w;

		Edge(int b, int e, int w) {
			this.b = b;
			this.e = e;
			this.w = w;
		}
	}
}
