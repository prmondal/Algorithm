package com.learning.algorithm.array;

import java.util.Scanner;

public class LongestPalindromString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		printLCP(sc.nextLine());
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
