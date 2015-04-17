package com.practice.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			t--;

			String str = sc.next();
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			int l = str.length();

			for (int i = 0; i < l; i++) {
				for (int j = i; j < l; j++) {
					String substr = str.substring(i, j + 1);
					
					char[] ca = substr.toCharArray();
					Arrays.sort(ca);
					String sortedStr = new String(ca);

					if (map.containsKey(sortedStr))
						map.put(sortedStr, map.get(sortedStr) + 1);
					else
						map.put(sortedStr, 1);
				}
			}

			int count = 0;
			
			for (Integer i : map.values()) {
				if (i > 1) {
					count += i * (i - 1) / 2;
				}
			}

			System.out.println(count);
		}
	}

	static boolean isAnagram(String str1, String str2) {
		if (str1.hashCode() != str2.hashCode())
			return false;

		int m = str1.length(), n = str2.length();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// put all characters in map and increment the count
		for (int i = 0; i < m; i++) {
			char c = str1.charAt(i);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		// loop through each characters in second string and decrement the
		// counter in hashmap if it contains the character
		for (int i = 0; i < n; i++) {
			char c = str2.charAt(i);

			if (map.containsKey(c)) {
				int v = map.get(c) - 1;

				// if the value becomes negative they are not anagram and return
				if (v < 0) {
					return false;
				} else {
					map.put(c, v);
				}
			} else {
				return false;
			}
		}

		return true;
	}
}
