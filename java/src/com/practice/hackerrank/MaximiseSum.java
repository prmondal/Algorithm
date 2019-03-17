package com.practice.hackerrank;

import java.util.Scanner;

public class MaximiseSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long M = sc.nextLong();

			long[] a = new long[N];

			for (int i = 0; i < N; i++)
				a[i] = sc.nextLong();

			printMaxModSumSubArray(a, N, M);
		}
	}

	static void printMaxModSumSubArray(long[] a, int N, long M) {
		long maxSum = 0;

		for (int l = 1; l <= N; l++) {
			for (int i = 0; i <= N - l; i++) {
				long currSum = 0;
				
				for (int j = i; j < i + l; j++) {
					currSum += a[j];
				}
				
				currSum %= M;

				if (maxSum < currSum)
					maxSum = currSum;
			}
		}

		System.out.println(maxSum);
	}

	/*static void printMaxModSumSubArray(long[] a, long M, int subsetSize) {
		long maxSum = 0;

		for (int i = 1; i < subsetSize; i++) {
			int l = 0;

			long currSum = 0;

			while (l < a.length) {
				if ((i & (1 << l)) != 0) {
					currSum += a[l];
				}

				l++;
			}

			currSum %= M;

			if (maxSum < currSum)
				maxSum = currSum;
		}

		System.out.println(maxSum);
	}*/
}
