package com.practice.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountLucks {
	static int count = 0;
	static int M = 0, N = 0;
	static char[][] grid;
	static int posX = 0, posY = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			count = 0;
			t--;

			M = sc.nextInt();
			N = sc.nextInt();
			grid = new char[M][N];
			String[] list = new String[M];

			for (int i = 0; i < M; i++) {
				list[i] = sc.next();
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = list[i].charAt(j);
					if (list[i].charAt(j) == 'M') {
						posX = i;
						posY = j;
					}
				}
			}

			int K = sc.nextInt();

			BFS(grid, M, N, posX, posY);

			if (count == K) {
				System.out.println("Impressed");
			} else
				System.out.println("Oops!");
		}

	}

	static void BFS(char[][] grid, int m, int n, int x, int y) {
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			Node current = q.poll();

			int cX = current.x;
			int cY = current.y;

			if (grid[cX][cY] == '*') {
				countWaves(current.parent);
				break;
			}

			grid[cX][cY] = '-';

			if (cY + 1 < n && grid[cX][cY + 1] != 'X'
					&& grid[cX][cY + 1] != '-') {
				Node node = new Node(cX, cY + 1);
				node.parent = current;

				q.add(node);
			}

			if (cY - 1 >= 0 && grid[cX][cY - 1] != 'X'
					&& grid[cX][cY - 1] != '-') {
				Node node = new Node(cX, cY - 1);
				node.parent = current;

				q.add(node);
			}

			if (cX + 1 < m && grid[cX + 1][cY] != 'X'
					&& grid[cX + 1][cY] != '-') {
				Node node = new Node(cX + 1, cY);
				node.parent = current;

				q.add(node);
			}

			if (cX - 1 >= 0 && grid[cX - 1][cY] != 'X'
					&& grid[cX - 1][cY] != '-') {
				Node node = new Node(cX - 1, cY);
				node.parent = current;

				q.add(node);
			}
		}
	}

	private static void countWaves(Node current) {
		int numAltPaths = 0;

		while (current != null) {
			numAltPaths = 0;

			if (current.x == posX && current.y == posY) {
				if (current.x + 1 < M) {
					if (grid[current.x + 1][current.y] != 'X') {
						numAltPaths++;
					}
				}

				if (current.x - 1 >= 0) {
					if (grid[current.x - 1][current.y] != 'X') {
						numAltPaths++;
					}
				}

				if (current.y + 1 < N) {
					if (grid[current.x][current.y + 1] != 'X') {
						numAltPaths++;
					}
				}

				if (current.y - 1 >= 0) {
					if (grid[current.x][current.y - 1] != 'X') {
						numAltPaths++;
					}
				}

				if (numAltPaths > 1) {
					count++;
					current = current.parent;
					continue;
				}
			}

			// update grid location so that it is not again considered when
			// checking for alternate paths
			grid[current.x][current.y] = '+';

			// calculate waves by traversing the shortest path and check for
			// more than one option
			if (current.x + 1 < M) {
				if (grid[current.x + 1][current.y] == '-'
						|| grid[current.x + 1][current.y] == '.') {
					numAltPaths++;
				}
			}

			if (current.x - 1 >= 0) {
				if (grid[current.x - 1][current.y] == '-'
						|| grid[current.x - 1][current.y] == '.') {
					numAltPaths++;
				}
			}

			if (current.y + 1 < N) {
				if (grid[current.x][current.y + 1] == '-'
						|| grid[current.x][current.y + 1] == '.') {
					numAltPaths++;
				}
			}

			if (current.y - 1 >= 0) {
				if (grid[current.x][current.y - 1] == '-'
						|| grid[current.x][current.y - 1] == '.') {
					numAltPaths++;
				}
			}

			if (numAltPaths > 1) {
				count++;
			}

			current = current.parent;

		}
	}

	static class Node {
		int x, y;
		Node parent = null;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
