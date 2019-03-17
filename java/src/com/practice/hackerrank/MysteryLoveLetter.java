package com.practice.hackerrank;

import java.util.Scanner;

public class MysteryLoveLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			System.out.println(convertToPalindrome(sc.next()));
		}
	}

	private static int convertToPalindrome(String str) {
		int count = 0;
		int l = str.length();

		for (int i = 0; i < l / 2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(l - 1 - i);

			if (c1 != c2) {
				count += Math.abs(c1 - c2);
			}
		}

		return count;
	}
}
