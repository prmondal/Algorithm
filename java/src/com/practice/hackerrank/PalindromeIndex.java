package com.practice.hackerrank;

import java.util.Scanner;

public class PalindromeIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.valueOf(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			boolean found = false;

			StringBuilder sb = new StringBuilder(sc.nextLine());

			int l = sb.length();

			for (int i = 0; i < l / 2 && !found; i++) {
				char c = sb.charAt(i);
				char e = sb.charAt(l - 1 - i);

				if (c == e) {
					if (i == l / 2 - 1) {
						System.out.println(-1);
					}
				} else {
					if (i == l / 2 - 1) {
						if (sb.charAt(l / 2) == sb.charAt(i)) {
							System.out.println(l / 2 + 1);
						} else
							System.out.println(i);
					} else {
						StringBuilder testStr = new StringBuilder(sb.substring(
								i + 1, l - i));

						if (isPalindrom(testStr, testStr.length())) {
							System.out.println(i);
							found = true;
						} else {
							System.out.println(l - 1 - i);
							found = true;
						}
					}
				}
			}
		}
	}

	private static boolean isPalindrom(StringBuilder str, int length) {
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) == str.charAt(length - 1 - i)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}
}
