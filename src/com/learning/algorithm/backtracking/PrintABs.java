package com.learning.algorithm.backtracking;

import java.util.Scanner;

public class PrintABs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		char[] a = new char[N + M];

		int[] counter = { 0 };

		printABs(N, M, a, N + M, counter);

		System.out.println("Count: " + counter[0]);
	}

	private static void printArray(char[] a, int N) {
		for (int i = 0; i < N; i++) {
			System.out.print(a[i]);
		}

		System.out.println();
	}

	private static void printABs(int n, int m, char[] a, int L, int[] counter) {
		if (n == 0 && m == 0) {
			return;
		}

		// no A left
		// place Bs
		if (n == 0) {
			putLetter('B', m, a, L);
			printArray(a, L);

			counter[0]++;
			return;
		}

		// no B left
		// place As
		if (m == 0) {
			putLetter('A', n, a, L);
			printArray(a, L);

			counter[0]++;
			return;
		}

		// first character is A
		a[L - (n + m)] = 'A';
		printABs(n - 1, m, a, L, counter);

		// first character is B
		a[L - (n + m)] = 'B';
		printABs(n, m - 1, a, L, counter);
	}

	static void putLetter(char l, int m, char[] a, int L) {
		while (m > 0) {
			// System.out.print(l);
			a[L - m] = l;
			m--;
		}
	}
}
