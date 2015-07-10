package com.learning.algorithm.graph;

import java.awt.PrintGraphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private final int V;
	private List<Integer>[] adj;
	private boolean isDirected;

	@SuppressWarnings("unchecked")
	Graph(int V, boolean isDirected) {
		this.V = V;
		this.isDirected = isDirected;

		adj = (ArrayList<Integer>[]) new ArrayList[V];

		for (int n = 0; n < V; n++) {
			adj[n] = new ArrayList<Integer>();
		}
	}

	void addEdge(int u, int v) {
		adj[u].add(v);

		if (!isDirected)
			adj[v].add(u);
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

	private static void printStack(Stack<Integer> stack) {
		ListIterator<Integer> it = stack.listIterator(stack.size());

		while (it.hasPrevious()) {
			System.out.print(it.previous() + " -> ");
		}
	}

	// considering graph is acyclic
	private static void doTopologicalOrdering(Graph g) {
		int V = g.getV();

		if (V == 0)
			return;

		Stack<Integer> stack = new Stack<Integer>();

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(g, i, visited, stack);
			}
		}

		// print topological ordering
		System.out.println("\n === Topological order of nodes ===");
		printStack(stack);
	}

	private static void dfs(Graph g, int i, boolean[] visited,
			Stack<Integer> stack) {
		// node is visited
		visited[i] = true;

		for (int adj : g.getAdjNodes(i)) {
			if (!visited[adj]) {
				dfs(g, adj, visited, stack);
			}
		}

		// push node to the stack if adjacent node is already visited or current
		// node is a leaf node (no outgoing edges)
		stack.add(i);
	}

	// detect cycle in undirected graph
	private static boolean isCyclicUtilUndirected(Graph g) {
		int V = g.getV();

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCyclicUndirected(g, i, visited, -1))
					return true;
			}
		}

		return false;
	}

	private static boolean isCyclicUndirected(Graph g, int n,
			boolean[] visited, int parent) {
		// mark current node is visited
		visited[n] = true;

		for (int i : g.getAdjNodes(n)) {
			// System.out.println("Adjacent node: " + i + "| Parent: " + n);
			// if the node not visited recur from this node to detect cycle
			if (!visited[i]) {
				// System.out.println("Adjacent node " + i + " is not visted.");
				if (isCyclicUndirected(g, i, visited, n))
					return true;
			} else {

				// System.out.println("Adjacent node " + i
				// + " is visted. Parent is " + parent);

				// the node is visited and is not the parent cycle is detected
				if (i != parent) {
					// System.out.println("Adjacent node " + i + "| Parent: "
					// + parent + " == Mismatch.");
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isCyclicUtilDirected(Graph g) {
		int V = g.getV();

		boolean[] visited = new boolean[V];
		boolean[] inStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i] && isCyclicDirected(g, i, visited, inStack)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isCyclicDirected(Graph g, int i, boolean[] visited,
			boolean[] inStack) {
		// node is visited
		visited[i] = true;
		inStack[i] = true;

		// recur for all adjacent nodes
		List<Integer> adjNodes = g.getAdjNodes(i);

		for (int n : adjNodes) {
			if (!visited[n] && isCyclicDirected(g, n, visited, inStack))
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
	
	//bfs and 2-color algo
	static boolean isBipartite(Graph g) {
		//-1 : no color, 0 : color-1, 1 : color-2
		int[] color = new int[g.getV()];
		Arrays.fill(color, -1); 
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(0);
		color[0] = 0;
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			//try coloring all adjacent vertices with alternate color
			for(int v : g.getAdjNodes(u)) {
				//if adjacent vertex color is same as current node return false
				if(color[v] != -1 && color[v] == color[u]) {
					return false;
				}
				
				//adjacent is not colored yet
				if(color[v] == -1) {
					color[v] = 1 - color[u];
					queue.add(v);
				}
			}		
		}
		
		//can be colored using 2 color
		return true;
	}
	
	static void printSCCs(Graph g) {
		System.out.println("\n ======= SCC ========");
		
		int V = g.getV();
		
		//DFS in forward graph to calculate finish times of all the nodes and insert the nodes in stack if there are no unvisited neighbors or no child
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				dfs(g, i, visited, stack);
			}
		}
		
		//reverse the graph and pop nodes from stack and dfs for each removed nodes to find the SCCs
		/*for(int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}*/
		
		Graph revG = new Graph(V, true);
		
		for(int i = 0; i < V; i++) {
			for(int j : g.getAdjNodes(i)) {
				revG.addEdge(j, i);
			}
		}
		
		visited = new boolean[V];
		
		while(!stack.isEmpty()) {
			int i = stack.pop();
			
			if(!visited[i]) {
				printSCC(revG, i, visited);
				System.out.println();
			}
		}
	}
	
	private static void printSCC(Graph g, int i, boolean[] visited) {
		visited[i] = true;

		for (int adj : g.getAdjNodes(i)) {
			if (!visited[adj]) {
				printSCC(g, adj, visited);
			}
		}
		
		System.out.print(i + " ");
	}
	
	static void print(Graph g) {
		int V = g.getV();
		
		for(int i = 0; i < V; i++) {
			for(int j : g.getAdjNodes(i)) {
				System.out.println(i + " --> " + j);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("\n === Directed graph edges === ");
		Graph g = new Graph(7, true);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.printGraph();

		System.out.println("\n === Cycle detection check ===");

		if (isCyclicUtilDirected(g)) {
			System.out.println("Graph has cycle.");
		} else {
			System.out.println("Graph does not have cycle.");
		}

		int v = g.getV();
		boolean[] visited = new boolean[v];

		// print all path to destination from source
		System.out.println("\n === Print all paths === ");
		g.printAllPaths(g, 0, v - 1, new ArrayList<Integer>(), visited);

		// topological sort
		doTopologicalOrdering(g);

		System.out.println("\n\n === Undirected graph edges === ");

		Graph g1 = new Graph(3, false);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		
		System.out.println("\n === Cycle detection check ===");
		
		if (isCyclicUtilUndirected(g1)) {
			System.out.println("Graph has cycle.");
		} else {
			System.out.println("Graph does not have cycle.");
		}
		
		System.out.println("\n===== Bipartiteness check ======");
		g = new Graph(10, false);
		g.addEdge(0, 5);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		
		System.out.println(isBipartite(g));
		
		g = new Graph(5, true);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(3, 4);
		
		printSCCs(g);
		
		g = new Graph(9, true);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(2, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 2);
		g.addEdge(1, 5);
		g.addEdge(5, 5);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 6);
		
		printSCCs(g);
		
		g = new Graph(4, true);
		g.addEdge(0, 1);g.addEdge(1, 2);g.addEdge(2, 3);
		printSCCs(g);
		
	}
}
