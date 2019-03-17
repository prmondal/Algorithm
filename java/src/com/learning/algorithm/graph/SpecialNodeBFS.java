package com.learning.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecialNodeBFS {
	static int[][] edge;
	static Node[] nodes;

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int N = r.nextInt(), M = r.nextInt();

		edge = new int[N][N];
		nodes = new Node[N];
		
		for(int i = 0; i < N; i++) 
			nodes[i] = new Node(i);

		for(int i = 0; i < N; i++)
			Arrays.fill(edge[i], -1);

		for (int i = 1; i <= M; i++) {
			int u = r.nextInt() - 1, v = r.nextInt() - 1, w = r.nextInt();
			edge[u][v] = w;
			edge[v][u] = w;
		}

		int S = r.nextInt();

		for (int i = 0; i < S; i++) {
			int sNode = r.nextInt() - 1;
			
			nodes[sNode].special = true;
			nodes[sNode].dist = 0;			
		}
		
		for(int i = 0; i < N; i++) {
			if(nodes[i].special) {
				dijsktra(nodes[i], N);
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(nodes[i].dist);
		}
	}

	static void dijsktra(Node n, int N) {
		for(int i = 0; i < N; i++)
			nodes[i].visited = false;
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(N, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.dist - o2.dist);
			}
			
		});

		q.add(n);

		while (!q.isEmpty()) {
			Node top = q.poll();
			top.visited = true;
			
			for (int j = 0; j < N; j++) {
				Node adj = nodes[j];
				
				if (top.id == adj.id)
					continue;
				
				int edgeCost = edge[top.id][adj.id];
				
				if (edgeCost != -1) {
					if (!adj.special && !adj.visited) {
						if(adj.dist > top.dist + edgeCost) {
							adj.dist = top.dist + edgeCost;
							
							if(!q.contains(adj)) {
								q.add(adj);
							}
						}
					}
				}
			}
		}
	}
	
	static class Node {
		long dist = Integer.MAX_VALUE;
		int id;
		boolean special = false;
		boolean visited = false;
		
		Node(int i) {
			this.id = i;
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
