package com.learning.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonMaxFlow {
	static int N = 6;
	static int s = 0;
	static int t = 5;
	static boolean[] visited;
	
	static int[][] graph = { 
		{0, 16, 13, 0, 0, 0},
        {0, 0, 10, 12, 0, 0},
        {0, 4, 0, 0, 14, 0},
        {0, 0, 9, 0, 0, 20},
        {0, 0, 0, 7, 0, 4},
        {0, 0, 0, 0, 0, 0}
      };
	
	public static void main(String[] args) {
		findMaxFlow(graph);
	}
	
	static boolean existAugPath(int[][] resGraph, int[] parent) {
		Queue<Integer> q = new LinkedList <Integer>();
		visited = new boolean[N];
		
		q.add(s);
		visited[s] = true;
		parent[s] = -1;
		
		while(!q.isEmpty()) {
			int u = q.poll();
			
			for(int v = 0; v < N; v++) {
				if(!visited[v]) {
					if(resGraph[u][v] > 0) {
						q.add(v);
						parent[v] = u;
						visited[v] = true;
					}
				}
			}
		}
		
		return visited[t] == true;
	}
	
	static void findMaxFlow(int[][] graph) {
		int[][] resGraph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				resGraph[i][j] = graph[i][j];
			}
		}
		
		int[] parent = new int[N];
		
		int maxFlow = 0;
		
		while(existAugPath(resGraph, parent)) {
			//calculate minimum flow along the path
			int v = t;
			int u = parent[v];
			int pathFlow = Integer.MAX_VALUE;
			
			while(v != s) {
				if(pathFlow > resGraph[u][v]) {
					pathFlow = resGraph[u][v];
				}
				
				v = u;
				u = parent[u];
			}
			
			v = t;
			u = parent[v];
			
			while(v != s) {
				resGraph[u][v] -= pathFlow;
				resGraph[v][u] += pathFlow;
				
				v = u;
				u = parent[u];
			}
			
			maxFlow += pathFlow;
		}
		
		System.out.println("Max flow is " + maxFlow);
	}

}
