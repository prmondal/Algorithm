package com.practice.hackerrank;

import java.util.Scanner;

public class BiggerIsBetter {
	public static void main(String[] args) {
		/*StringBuilder str1 = new StringBuilder("abcd");
		reverse(4, str1, str1.length());
		System.out.println(str1.toString());*/
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t > 0) {
			t--;
			
			StringBuilder str = new StringBuilder(sc.next());
			int L = str.length();
			int idx1 = -1;
			
			
			//get largest index such that str[i] < str[i+1]
			for(int i = 0; i < L - 1; i++) {
				if(str.charAt(i) < str.charAt(i + 1)) {
					idx1 = i;
				}
			}
			
			if(idx1 == -1) {
				System.out.println("no answer");
				continue;
			}
			
			if(idx1 == L - 2) {
				reverse(L - 2, str, L);
				System.out.println(str.toString());
				continue;
			}
			
			int idx2 = -1;
			
			//find largest index j > idx1 such that str[idx1] < str[j]
			for(int j = idx1 + 1; j < L; j++) {
				if(str.charAt(j) > str.charAt(idx1)) {
					idx2 = j;
				}
			}
			
			//swap
			swap(idx1, idx2, str);
			
			//reverse string after idx
			reverse(idx1 + 1, str, L);
			
			System.out.println(str.toString());
		}
	}
	
	private static void reverse(int i, StringBuilder str, int L) {
		for(int j = i; j < (L - i) / 2 + i; j++) {
			char t = str.charAt(j);
			char e = str.charAt(L + i - j - 1);

			str.setCharAt(j, e);
			str.setCharAt(L + i - j - 1, t);
		}
	}

	static void swap(int i, int j, StringBuilder str) {
		char t = str.charAt(i);
		char cj = str.charAt(j);

		str.setCharAt(i, cj);
		str.setCharAt(j, t);
	}
}
