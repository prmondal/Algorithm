package com.practice.hackerrank;

import java.util.Scanner;

public class KnapSackDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			int N = sc.nextInt();
			int S = sc.nextInt();

			int[] a = new int[N];

			for (int i = 0; i < N; i++)
				a[i] = sc.nextInt();

			printNearestSum(a, S);
		}
	}

	private static void printNearestSum(int[] a, int S) {
		int L = a.length;

		if (L == 0)
			return;

		if (S == 0) {
			System.out.println(0);
			return;
		}

		int[] T = new int[S + 1];

		for (int i = 1; i <= S; i++)
			T[i] = Integer.MAX_VALUE - 1;

		int nearestSum = 0;

		for (int s = 1; s <= S; s++) {
			for (int i = 0; i < L; i++) {
				if (a[i] <= s) {
					int v = T[s - a[i]] + 1;

					if (v < T[s]) {
						T[s] = v;

						if (T[s] != Integer.MAX_VALUE - 1) {
							nearestSum = s;

						}
					}
				}
			}
		}

		System.out.println(nearestSum);
	}
}
