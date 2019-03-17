package com.learning.algorithm.array;

import java.util.Scanner;

public class BreakWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String test = sc.nextLine();

		if (!isBreakable(test)) {
			System.out.println("\nNot breakable!");
		} else {
			System.out.println("\nIt is breakable.");
		}
	}

	private static boolean contains(String word) {
		String[] words = { "i", "like", "some", "tea" };

		for (String s : words) {
			if (word.equals(s))
				return true;
		}

		return false;
	}

	private static boolean isBreakable(String test) {
		//recursion based
		/*int L = test.length();
		
		if(L == 0)
			return true;
		
		if(L == 1) {
			if(contains(test)) {
				return true;
			}
		}
		
		//recursion based solution
		for(int i = 0; i < L; i++) {
			String s = test.substring(0, i + 1);
			
			if(contains(s) && isBreakable(test.substring(i + 1))) {
				return true;
			}
		}*/
		
		int L = test.length();
		
		//DP table
		boolean[] table = new boolean[L + 1];
		
		table[0] = true;
		
		for(int i = 1; i <= L; i++) {
			if(!table[i]) {
				String s = test.substring(0, i);
				
				if(contains(s)) {
					table[i] = true;
					System.out.print(s + " ");
				} else 
					continue;
			}
				
			if(i == L) {
				return true;
			}
			
			for(int j = i + 1; j <= L; j++) {
				if(!table[j]) {
					String s = test.substring(i, j);
					
					if(contains(s)) {
						table[j] = true;
						System.out.print(s + " ");
					}
				}
				
				if(j == L) {
					return true;
				}
			}
		}
			
		return false;
	}
}
