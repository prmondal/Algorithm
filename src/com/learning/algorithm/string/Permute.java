package com.learning.algorithm.string;

import java.util.Scanner;

public class Permute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		permute(str, 0, str.length() - 1);

	}

	private static void permute(String str, int i, int n) {
		if(i == n) {
			System.out.println(str);
		} else {
			for(int j = i; j <= n; j++) {
				String s = swap(str, i, j);
				permute(s, i + 1, n);
			}
		}
		
	}

	private static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		
		char c1 = str.charAt(i);
		char c2 = str.charAt(j);
		
		sb.setCharAt(i, c2);
		sb.setCharAt(j, c1);
		
		return sb.toString();
	}

}
