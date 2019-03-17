package com.learning.algorithm.array;

import java.util.Scanner;

public class MaxSumNonContigous {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.valueOf(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] array = new int[N];

			for (int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}

			printMaxSum(array, array.length);
		}

	}

	private static void printMaxSum(int[] array, int n) {
		int[] T = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				T[i] = array[0];
			} else if (i == 2) {
				T[i] = Math.max(T[1], array[1]);
			} else {
				T[i] = Math.max(T[i - 1], T[i - 2] + array[i - 1]);
			}
		}

		System.out.println(T[n]);
	}

}
