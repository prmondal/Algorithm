package com.learning.algorithm.array;

import java.util.Scanner;

public class LCSubseq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String first = "";
		String second = "";
		
		for(int i = 0; i < n; i++) {
			first += sc.next();
		}
		
		for(int i = 0; i < m; i++) {
			second += sc.next();
		}
		
		String str = printLCS(first, second, n, m).toString();
		
		System.out.println(str.replaceAll("", " ").trim());
	}

	private static StringBuilder printLCS(String first, String second, int n, int m) {
		if (n == 0 || m == 0) {
			return new StringBuilder("");
		}

		if (first.charAt(n - 1) == second.charAt(m - 1)) {
			return printLCS(first, second, n - 1, m - 1).append(first.charAt(n - 1));
		}

		StringBuilder str1 = printLCS(first, second, n, m - 1);
		StringBuilder str2 = printLCS(first, second, n - 1, m);

		if (str1.length() > str2.length()) {
			return str1;
		} else {
			return str2;
		}
	}

}
