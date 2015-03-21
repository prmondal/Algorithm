package com.learning.algorithm.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SnakeLadder {
	private static final int d = 99;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// create root node
		Node root = new Node(0);
					
		for (int i = 1; i <= T; i++) {
			// array stores snake and ladder position
			int[] moves = new int[d + 1];

			Arrays.fill(moves, -1);
			
			String[] str = sc.next().split(",");

			int S = Integer.valueOf(str[0]);
			int L = Integer.valueOf(str[1]);

			for (int s = 1; s <= S; s++) {
				str = sc.next().split(",");
				moves[Integer.valueOf(str[0]) - 1] = Integer.valueOf(str[1]) - 1;
			}

			for (int l = 1; l <= L; l++) {
				str = sc.next().split(",");
				moves[Integer.valueOf(str[0]) - 1] = Integer.valueOf(str[1]) - 1;
			}			

			// print minimum dice throw
			System.out.println(getMinimumThrow(root, moves));
		}
	}

	private static int getMinimumThrow(Node root, int[] moves) {
		if (root == null)
			return Integer.MAX_VALUE;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		boolean[] visited = new boolean[d + 1];

		Node top = null;

		pq.add(root);
		visited[0] = true;

		while (!pq.isEmpty()) {
			// destination is found return
			top = pq.poll();

			int v = top.getValue();

			if (v == d) {
				break;
			}

			// find and add child nodes to the queue
			int i = 1;

			while (i <= 6 && v + i <= d) {
				int curr = v + i;

				if (!visited[curr]) {
					visited[curr] = true;

					Node c = null;

					// update with snake and ladder position
					if (moves[curr] != -1) {
						c = new Node(moves[curr]);
					} else {
						c = new Node(curr);
					}

					// update cost from source
					c.updateCost(top.cost + 1);

					// add to child list
					pq.add(c);
				}

				i++;
			}
		}

		return top.cost;
	}

	static class Node implements Comparable<Node> {
		int value;
		int cost;

		Node(int v) {
			this.value = v;
			this.cost = 0;
		}

		void updateCost(int c) {
			this.cost = c;
		}

		int getValue() {
			return this.value;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
