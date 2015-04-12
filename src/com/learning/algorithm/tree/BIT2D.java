package com.learning.algorithm.tree;

public class BIT2D {

	static int[][] BIT;

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int m = A.length;
		int n = A[0].length;

		// init BIT array
		BIT = new int[m + 1][n + 1];

		// initialize BIT for the given array
		init(A, m, n);

		// range query
		System.out.println(rangeSum(A, m, n, 2, 2, 3, 2));
	}

	static int rangeSum(int[][] A, int m, int n, int x1, int y1, int x2, int y2) {
		if (x1 > x2 || y1 > y2 || x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0
				|| x1 > m || x2 > m || y1 > n || y2 > n)
			return Integer.MAX_VALUE;

		return query(A, m, n, x2, y2) - query(A, m, n, x1 - 1, y2)
				- query(A, m, n, x2, y1 - 1) + query(A, m, n, x1 - 1, y1 - 1);
	}

	// increase by value
	static void update(int[][] A, int m, int n, int x, int y, int v) {
		int y1;

		while (x <= m) {
			y1 = y;

			while (y1 <= n) {
				BIT[x][y1] += v;
				y1 += y1 & -y1;
			}

			x += x & -x;
		}
	}

	static int query(int[][] A, int m, int n, int x, int y) {
		int result = 0;
		int y1;

		while (x > 0) {
			y1 = y;

			while (y1 > 0) {
				result += BIT[x][y1];
				y1 -= y1 & -y1;
			}

			x -= x & -x;
		}

		return result;
	}

	static void init(int[][] A, int m, int n) {
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				update(A, m, n, i, j, A[i - 1][j - 1]);
			}
		}
	}

}
