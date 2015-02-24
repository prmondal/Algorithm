package com.learning.algorithm.array;

import java.util.Scanner;

public class LongestPalindromString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// StringBuilder str = new StringBuilder(sc.nextLine());

		// StringBuilder rev = new StringBuilder(str).reverse();

		// printLCS(str, rev);

		printLCP(sc.nextLine());
	}

	// LCS based approach
	private static void printLCS(StringBuilder str1, StringBuilder str2) {
		int m = str1.length();
		int n = str2.length();

		// longest suff length for all pair of substrings
		int[][] LCS = new int[m + 1][n + 1];
		int maxLength = Integer.MIN_VALUE;
		String result = "";

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
					continue;
				}

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = 0;
				}

				// store max suffix length
				if (maxLength < LCS[i][j]) {
					maxLength = LCS[i][j];
					result = str1.substring(i - maxLength, i);
				}
			}
		}

		System.out.println(result);
	}

	private static void printLCP(String str) {
		if (str.length() == 0) {
			return;
		}

		int L = str.length();
		boolean[][] T = new boolean[L][L];

		int startIdx = -1;
		int maxPLength = 0;

		// length 1 case
		for (int i = 0; i <= L - 1; i++) {
			T[i][i] = true;

			startIdx = i;

			maxPLength = 1;
		}

		// length 2 case
		for (int i = 0; i <= L - 2; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				T[i][i + 1] = true;

				startIdx = i;

				maxPLength = 2;
			}
		}

		// length more than 2 case
		for (int l = 3; l <= L; l++) {
			for (int i = 0; i <= L - l; i++) {
				int j = i + l - 1;

				if (str.charAt(i) == str.charAt(j) && T[i + 1][j - 1]) {
					T[i][j] = true;

					startIdx = i;

					maxPLength = l;
				}
			}
		}

		// System.out.println(str.substring(startIdx, maxPLength - 1));
		System.out.println(str.substring(startIdx, startIdx + maxPLength));
	}
}
