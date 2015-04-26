package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class CutTree {
	static int sum = 0;
	static boolean[] visited;
	static int[] w;
	static int[] s;
	static int min = Integer.MAX_VALUE;
	static int totalSum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		w = new int[N];
		s = new int[N];

		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			totalSum += w[i];
		}

		visited = new boolean[N];
		ArrayList<Integer[]> listE = new ArrayList<Integer[]>();

		Graph g = new Graph(N);

		for (int i = 0; i < N - 1; i++) {
			int e1 = sc.nextInt() - 1, e2 = sc.nextInt() - 1;
			g.addEdge(e1, e2);
			listE.add(new Integer[] { e1, e2 });
		}

		DFS(g, 1);

		System.out.println(min);
	}

	static int DFS(Graph g, int i) {
		visited[i] = true;

		for (int adj : g.list[i]) {
			if (!visited[adj]) {
				int sum = DFS(g, adj);
				int rest = totalSum - sum;

				if (min > Math.abs(rest - sum))
					min = Math.abs(rest - sum);

				s[i] += sum;
			}
		}

		s[i] += w[i];
		return s[i];
	}

	static class Graph {
		int V;
		ArrayList<Integer>[] list;

		Graph(int v) {
			this.V = v;
			list = (ArrayList<Integer>[]) new ArrayList[V];

			for (int i = 0; i < V; i++) {
				list[i] = new ArrayList<Integer>();
			}
		}

		void addEdge(int i, int j) {
			list[i].add(j);
			list[j].add(i);
		}

		void removeEdge(int i, int j) {
			list[i].remove((Integer) j);
			list[j].remove((Integer) i);
		}
	}

}
