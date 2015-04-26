package com.practice.hackerrank;

import java.util.Scanner;

public class MakeAnagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next(), s2 = sc.next();

		int[] table = new int[26];
		int c = 0;

		for (int i = 0; i < s1.length(); i++)
			table[s1.charAt(i) - 'a']++;
		
		for (int j = 0; j < s2.length(); j++) {
			if (table[s2.charAt(j) - 'a'] == 0)
				c++;
			else
				table[s2.charAt(j) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			c += Math.abs(table[i]);
		}

		System.out.println(c);
	}
}
