package com.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		HashSet<Character> set = new HashSet<Character>();

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		
		str = str.toLowerCase();

		int l = str.length();

		for (int i = 0; i < l; i++) {
			char c = str.charAt(i);
			
			if(c == ' ') {
				continue;
			}
			
			set.add(c);
		}

		for (int i = 97; i <= 122; i++) {
			if (!set.contains((char) i)) {
				System.out.println("not pangram");

				return;
			}
		}

		System.out.println("pangram");
	}
}
