package com.practice.hackerrank;

import java.util.Scanner;

public class GameThronesILockBruteForce {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());

		System.out.println(isPalindromeExist(sb, 0, sb.length() - 1) ? "YES"
				: "NO");
	}

	static boolean isPalindromeExist(StringBuilder sb, int l, int h) {
		if (l >= h) {
			if (isPalindrome(sb.toString())) {
				return true;
			}

			return false;
		}

		for (int i = l; i <= h; i++) {
			swap(sb, l, i);
			if (isPalindromeExist(sb, l + 1, h)) {
				return true;
			}

			swap(sb, l, i);
		}

		return false;
	}

	private static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	static void swap(StringBuilder str, int i, int j) {
		char t = str.charAt(j);
		str.setCharAt(j, str.charAt(i));
		str.setCharAt(i, t);
	}
}
