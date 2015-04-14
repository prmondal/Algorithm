package com.learning.algorithm.array;

import java.util.Arrays;

public class MaxProfitWineSell {
	static int[][] mem;

	public static void main(String[] args) {
		int[] P = { 2, 3, 5, 1, 4 };
		mem = new int[P.length][P.length];

		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}

		// System.out.println(maxProfit(P, 0, P.length - 1));
		maxProfitDP(P);
	}

	// memoization
	static int maxProfit(int[] P, int l, int h) {
		if (l > h)
			return 0;

		if (mem[l][h] != -1)
			return mem[l][h];

		int year = P.length - (h - l + 1) + 1;

		return mem[l][h] = Math.max(maxProfit(P, l + 1, h) + year * P[l],
				maxProfit(P, l, h - 1) + year * P[h]);
	}

	// DP
	static void maxProfitDP(int[] P) {
		int L = P.length;
		int[][] T = new int[L + 1][L + 1];

		// y is year
		for (int y = 1; y <= L; y++) {
			for (int x = 1; x <= L - y + 1; x++) {
				if (y == 1) {
					T[x][x] = L * P[x - 1];
					continue;
				}

				int s = x;
				int e = x + y - 1;

				// current year
				int year = L - e + s;

				if (s + 1 <= L)
					T[s][e] = Math.max(year * P[s - 1] + T[s + 1][e], year
							* P[e - 1] + T[s][e - 1]);
			}
		}

		System.out.println(T[1][L]);
	}
}
