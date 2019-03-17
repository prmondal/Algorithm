package com.practice.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.valueOf(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder(sc.nextLine());

			int l = sb.length();

			if (l % 2 != 0) { // odd length
				System.out.println(-1);

				continue;
			}

			// split in two
			String str1 = sb.substring(0, l / 2);
			String str2 = sb.substring(l / 2);

			if (isAnagramEachOther(str1, str2, l / 2)) { // even length
				System.out.println(0);
			}
		}

	}

	private static boolean isAnagramEachOther(String str1, String str2, int l) {
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();

		int count = 0;

		for (int i = 0; i < l; i++) {
			char c = str1.charAt(i);
			
			if(set.get(c) != null) {
				int n = set.get(c);
				
				//update existing key
				set.put(c, n + 1);
			} else {
				//put new key
				set.put(c, 1);
			}
		}
		
		/*Set<Character> keys = set.keySet();
		for(Character key: keys){
			System.out.println("Value of "+key+" is: "+set.get(key));
		}*/

		for (int i = 0; i < l; i++) {
			char c = str2.charAt(i);
			
			if (set.containsKey(c)) {
				int n = set.get(c);
				
				//no match
				if(n == 0) {
					count++;
					
					continue;
				}
				
				//update count
				//decrement count for the match
				set.put(c, n - 1);
				
				continue;
			} else {
				count++;
			}
		}

		if (count > 0) {
			System.out.println(count);
			
			return false;
		}

		return true;
	}
}
