package com.practice.hackerrank;

import java.util.Scanner;

public class GridPatternSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			t--;

			int m = sc.nextInt(), n = sc.nextInt();

			char[][] grid = new char[m][n];

			for (int i = 0; i < m; i++) {
				grid[i] = sc.next().toCharArray();
			}

			int r = sc.nextInt(), c = sc.nextInt();

			char[][] pattern = new char[r][c];

			for (int i = 0; i < r; i++) {
				pattern[i] = sc.next().toCharArray();
			}

			System.out.println((gridContains(grid, pattern)) ? "YES" : "NO");
		}
	}

	static boolean gridContains(char[][] grid, char[][] pattern) {
		int m = grid.length, n = grid[0].length, r = pattern.length, c = pattern[0].length;

		for (int i = 0; i <= m - r; i++) {
			for (int j = 0; j <= n - c; j++) {
				// compare two pattern
				if (isSame(grid, i, j, m, n, pattern, r, c)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isSame(char[][] grid, int x, int y, int m, int n,
			char[][] pattern, int r, int c) {
		for (int i = x; i < r + x; i++) {
			for (int j = y; j < c + y; j++) {
				// System.out.println("x: " + x + " ,y: " + y + " ,i: " + i +
				// " ,j: " + j);
				if (grid[i][j] != pattern[i - x][j - y]) {
					return false;
				}
			}
		}

		return true;
	}

	static long getHash(char[][] pattern) {
		long hash = 0, m = pattern.length, n = pattern[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				hash = 31 * hash + pattern[i][j] - '0';
			}
		}

		return hash;
	}
}
