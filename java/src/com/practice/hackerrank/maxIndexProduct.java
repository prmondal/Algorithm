package com.practice.hackerrank;

import java.util.Scanner;

public class maxIndexProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();

		printMaxIndexProduct(A);
	}

	static void printMaxIndexProduct(int[] A) {
		int l = A.length;
		long maxResult = 0;

		for (int i = 1; i < l - 1; i++) {
			long leftIdx = 0;
			long rightIdx = 0;

			for (int j = i - 1; j >= 0; j--) {
				if (A[j] > A[i]) {
					leftIdx = j + 1;
					break;
				}
			}

			if (leftIdx == 0)
				continue;

			for (int k = i + 1; k < l; k++) {
				if (A[k] > A[i]) {
					rightIdx = k + 1;
					break;
				}
			}

			if (rightIdx == 0)
				continue;

			if (leftIdx * rightIdx > maxResult)
				maxResult = leftIdx * rightIdx;
		}

		System.out.println(maxResult);
	}
}
