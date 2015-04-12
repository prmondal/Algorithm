package com.practice.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class BrickGameDP {
	static HashMap<Integer[], Long> map = new HashMap<Integer[], Long>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			int N = sc.nextInt();
			int[] points = new int[N];

			for (int i = 0; i < N; i++)
				points[i] = sc.nextInt();

			long playerScores = getMaxScore(points);

			System.out.println(playerScores);
		}
	}

	// recursive
	static long getMaxScore(int[] points, int low, int high, boolean isPlayer) {
		if (high - low < 3) {
			if (isPlayer) {
				Integer[] key = { low, -1 };

				if (map.containsKey(key)) {
					return map.get(key);
				}

				long score = 0;

				for (int i = low; i <= high; i++)
					score += points[i];

				map.put(key, score);

				return score;
			} else
				return 0;
		}

		if (isPlayer) {
			long a = getMaxScore(points, low + 1, high, false);
			long b = getMaxScore(points, low + 2, high, false);
			long c = getMaxScore(points, low + 3, high, false);

			long score = Math.max(Math.max(points[low] + a, points[low]
					+ points[low + 1] + b), points[low] + points[low + 1]
					+ points[low + 2] + c);

			Integer[] key = { low, -1 };
			map.put(key, score);
			return score;
		} else {
			long a = getMaxScore(points, low + 1, high, true);
			long b = getMaxScore(points, low + 2, high, true);
			long c = getMaxScore(points, low + 3, high, true);

			return Math.min(Math.min(a, b), c);
		}
	}

	// DP based
	static long getMaxScore(int[] points) {
		int L = points.length;

		if (L == 0)
			return 0;

		long[] P = new long[L + 1];
		long[] E = new long[L + 1];

		for (int i = L; i >= 1; i--) {
			if (L - i < 3) {
				P[i] = sum(points, i - 1, L - 1);
				E[i] = 0;
				continue;
			}

			long a = points[i - 1] + E[i + 1];
			long b = points[i - 1] + points[i] + E[i + 2];
			long c = points[i - 1] + points[i] + points[i + 1] + E[i + 3];

			P[i] = Math.max(Math.max(a, b), c);
			E[i] = Math.min(Math.min(P[i + 1], P[i + 2]), P[i + 3]);
		}

		return P[1];
	}

	private static long sum(int[] points, int r1, int r2) {
		long sum = 0;

		for (int i = r1; i <= r2; i++)
			sum += points[i];

		return sum;
	}
}
