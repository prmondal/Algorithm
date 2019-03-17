package com.practice.hackerrank;

import java.util.Scanner;

public class RedJohnBack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			countUniqueBrickPlacements(sc.nextInt());
		}
	}

	private static void countUniqueBrickPlacements(int N) {
		int[] T = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i < 4) {
				T[i] = 1;
			} else if (i == 4) {
				T[4] = 2;
			} else {
				//calculate count if 1 x 4 tile is placed remaining width (N - 4)
				//calculate count if 4 x 1 tile is placed remaining width (N - 1)
				T[i] = T[i - 4] + T[i - 1];
			}
		}

		countPrimes(T[N]);
	}

	// count primes till n
	private static void countPrimes(int n) {
		// added extra element for simplicity
		int L = n + 1;
		int[] flag = new int[L];

		for (int i = 2; i * i <= (L - 1); i++) {
			if (flag[i] == -1)
				continue;

			int j = i << 1;

			while (j <= L - 1) {
				if (flag[i] != -1) {
					flag[j] = -1;
				}

				j += i;
			}
		}

		int count = 0;

		for (int i = 2; i < L; i++) {
			if (flag[i] == 0) {
				count++;
			}
		}

		System.out.println(count);
	}
}
