package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RustMurdererGraph {
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			t--;

			int N = sc.nextInt(), E = sc.nextInt();

			dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);

			visited = new boolean[N];

			//byte[][] graph = new byte[N][N];
			HashSet<String> set = new HashSet<String>();
			
			for (int i = 0; i < E; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;

				//graph[x][y] = 1;
				//graph[y][x] = 1;
				
				set.add(x+""+y);
				set.add(y+""+x);
			}
			
			int s = sc.nextInt() - 1;

			BFS(set, s, N);

			StringBuilder result = new StringBuilder();
			
			for (int i = 0; i < dist.length; i++) {
				if (i == s)
					continue;
				
				result.append(dist[i]);
			}
			
			String str = result.toString().replace("", " ");
			
			System.out.println(str.trim());
		}
	}

	/*static void BFS(byte[][] graph, int s) {
		Queue<Integer> Q = new LinkedList<Integer>();

		Q.add(s);
		dist[s] = 0;

		while (!Q.isEmpty()) {
			int curr = Q.poll();
			visited[curr] = true;

			for (int j = 0; j < graph[0].length; j++) {
				if (graph[curr][j] == 0 && !visited[j] && j != curr) {
					if (dist[j] > dist[curr] + 1) {
						dist[j] = dist[curr] + 1;
						Q.add(j);
					}
				}
			}
		}
	}*/
	
	static void BFS(HashSet<String> set, int s, int N) {
		Queue<Integer> Q = new LinkedList<Integer>();

		Q.add(s);
		dist[s] = 0;

		while (!Q.isEmpty()) {
			int curr = Q.poll();
			visited[curr] = true;

			for(int i = 0; i < N; i++) {
				if(curr == i)
					continue;
				
				if(!visited[i]){
					if(set.contains(curr + "" + i))
						continue;
					
					if (dist[i] > dist[curr] + 1) {
						dist[i] = dist[curr] + 1;
						Q.add(i);
					}
				}
			}
		}
	}
}
