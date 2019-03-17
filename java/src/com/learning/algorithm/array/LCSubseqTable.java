package com.learning.algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class LCSubseqTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.valueOf(sc.next());
		}

		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.valueOf(sc.next());
		}

		printLCS(arr1, arr2, n, m);
	}

	private static void printLCS(int[] arr1, int[] arr2, int n, int m) {
		int[][] LCS = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
				} else if (arr1[i - 1] == arr2[j - 1]) {
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
				} else if (LCS[i][j - 1] > LCS[i - 1][j]) {
					LCS[i][j] = LCS[i][j - 1];
				} else {
					LCS[i][j] = LCS[i - 1][j];
				}
			}
		}

		int i = n;
		int j = m;

		ArrayList<Integer> elem = new ArrayList<Integer>();

		while (i > 0 && j > 0) {
			if (arr1[i - 1] == arr2[j - 1]) {
				// index.add(i - 1);
				elem.add(arr1[i - 1]);

				i--;
				j--;

			} else if (LCS[i][j - 1] > LCS[i - 1][j]) {
				j--;
			} else {
				i--;
			}
		}

		for (int k = elem.size() - 1; k >= 0; k--) {
			System.out.print(elem.get(k) + " ");
		}
	}
}
