package com.practice.hackerrank;

import java.util.Scanner;

public class SherlockAndArray {
	static void findIndex(int[] A, int N, int totalSum) {
		if(N == 1) {
			System.out.println("YES");
			return;
		}
		
		int currentSum = A[0];

		for (int j = 1; j < N - 1; j++) {
			if (totalSum - A[j] == 2 * currentSum) {
				System.out.println("YES");
				return;
			}

			currentSum += A[j];
		}

		System.out.println("NO");
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			t--;

			int N = sc.nextInt();

			int[] A = new int[N];

			int totalSum = 0;

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				totalSum += A[i];
			}

			findIndex(A, N, totalSum);
		}

	}

}
