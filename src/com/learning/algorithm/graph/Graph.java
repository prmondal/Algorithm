package com.learning.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final int V;
	private List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	Graph(int V) {
		this.V = V;

		adj = (ArrayList<Integer>[]) new ArrayList[V];

		for (int n = 0; n < V; n++) {
			adj[n] = new ArrayList<Integer>();
		}
	}

	void addEdge(int u, int v) {
		adj[u].add(v);
	}

	void printGraph() {
		for (int i = 0; i < V; i++) {
			for (int v : adj[i]) {
				System.out.println(i + "-" + v);
			}
		}
	}

	int getV() {
		return V;
	}

	List<Integer>[] getAdj() {
		return adj;
	}

	List<Integer> getAdjNodes(int i) {
		return adj[i];
	}

	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int v = sc.nextInt();
		 * 
		 * Graph g = new Graph(v);
		 * 
		 * // get edges for (int n = 0; n < v; n++) { g.addEdge(sc.nextInt(),
		 * sc.nextInt()); }
		 */

		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 5);
		g.addEdge(0, 2);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(2, 5);

		g.printGraph();

		int v = g.getV();

		boolean[] visited = new boolean[v];
		boolean[] inStack = new boolean[v];

		if (isCyclicUtil(g, visited, inStack)) {
			System.out.println("Graph has cycle.");
		} else {
			System.out.println("Graph does not have cycle.");
		}

		visited = new boolean[v];

		// print all path to destination from source
		g.printAllPaths(g, 0, v - 1, new ArrayList<Integer>(), visited);
	}

	private static boolean isCyclicUtil(Graph g, boolean[] visited,
			boolean[] inStack) {
		int V = g.getV();

		for (int i = 0; i < V; i++) {
			if (isCyclic(g, i, visited, inStack)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isCyclic(Graph g, int i, boolean[] visited,
			boolean[] inStack) {
		// node is visited
		visited[i] = true;
		inStack[i] = true;

		// recur for all adjacent nodes
		List<Integer> adjNodes = g.getAdjNodes(i);

		for (int n : adjNodes) {
			if (!visited[n] && isCyclic(g, n, visited, inStack))
				return true;
			else if (inStack[n])
				return true;
		}

		// no adjacent nodes
		// remove from stack
		inStack[i] = false;

		return false;
	}

	void printAllPaths(Graph g, int s, int d, ArrayList<Integer> path,
			boolean[] visited) {
		if (g.getV() == 0)
			return;

		// add to path
		path.add(s);

		// if the node is destination print the path and return
		if (s == d) {
			printPath(path);

			visited[s] = false;

			return;
		}

		// visited
		visited[s] = true;

		// recur to all adjacent nodes
		for (int i : g.getAdjNodes(s)) {
			if (!visited[i]) {
				visited[i] = true;

				printAllPaths(g, i, d, path, visited);

				path.remove(path.size() - 1);
			}
		}
	}

	private void printPath(ArrayList<Integer> path) {
		System.out.println();

		for (int i : path) {
			System.out.print(i + " ");
		}
	}

}
