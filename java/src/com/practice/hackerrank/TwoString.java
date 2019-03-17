package com.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class TwoString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			t--;

			System.out.println(containsSubStr(sc.next(), sc.next()) ? "YES"
					: "NO");
		}
	}

	static boolean containsSubStr(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		HashSet<Character> set = new HashSet<Character>();

		for (int i = 0; i < m; i++) {
			set.add(s1.charAt(i));
		}

		for (int i = 0; i < n; i++) {
			if (set.contains(s2.charAt(i))) {
				return true;
			}
		}

		return false;
	}
}
