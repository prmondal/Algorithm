package com.practice.hackerrank;

import java.util.*;

public class BoxCutGreedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			t--;

			int M = sc.nextInt() - 1, N = sc.nextInt() - 1;
			int[] Y = new int[M];
			int[] X = new int[N];

			for (int i = 0; i < M; i++)
				Y[i] = sc.nextInt();

			for (int i = 0; i < N; i++)
				X[i] = sc.nextInt();

			Arrays.sort(Y);
			Arrays.sort(X);

			printMinCost(Y, M, X, N);
		}

	}

	static void printMinCost(int[] y, int M, int[] x, int N) {
		int i = M - 1, j = N - 1;
		long v = 0, h = 0, c = 0;

		while (i >= 0 && j >= 0) {
			if (y[i] >= x[j]) {
				h++;
				c += y[i] * (v + 1);
				i--;

			} else {
				v++;
				c += x[j] * (h + 1);
				j--;

			}
		}

		while (i >= 0) {
			c += y[i] * (v + 1);
			i--;
		}

		while (j >= 0) {
			c += x[j] * (h + 1);
			j--;
		}

		System.out.println(c % 1000000007);
	}
}