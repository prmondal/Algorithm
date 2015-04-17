package com.practice.hackerrank;

import java.util.Scanner;

public class GameThronesI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isPalindromeExist(sc.next()) ? "YES" : "NO");
	}

	static boolean isPalindromeExist(String str) {
		int l = str.length();
		int[] count = new int[26];
		int countOdd = 0;

		for (int i = 0; i < l; i++) {
			count[str.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(count[i] % 2 != 0) {
				countOdd++;
				
				if(countOdd > 1)
					return false;
			}
		}

		return true;
	}

}
