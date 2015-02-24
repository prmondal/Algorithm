package com.learning.algorithm.array;

import java.util.Scanner;

public class LCSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder str1 = new StringBuilder(sc.nextLine());
		StringBuilder str2 = new StringBuilder(sc.nextLine());

		printLCS(str1, str2);
	}

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

		System.out.println("LCS length : " + maxLength + " , Longest match: "
				+ result);
	}
}
