package com.learning.algorithm.string;

import java.util.Scanner;

public class Permute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		permute(str, 0, str.length() - 1);

	}

	private static void permute(String str, int low, int high) {
		if(low == high) {
			System.out.println(str);
		} else {
			for(int j = low; j <= high; j++) {
				String s = swap(str, low, j);
				permute(s, low + 1, high);
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
