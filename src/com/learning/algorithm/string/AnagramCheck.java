package com.learning.algorithm.string;

import java.util.HashMap;

public class AnagramCheck {

	public static void main(String[] args) {
		String[] list = {"geeksquiz", "geeksforgeeks", "abcd", "forgeeksgeeks", "zuiqkeegs", "abdc"};
		
		/*Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		if(checkAnagram(str1, str2, str1.length(), str2.length())) {
			System.out.println("Anagram each other.");
		} else {
			System.out.println("Not anagram each other.");
		}*/
		
		//printPairs(list);
		
		System.out.println(checkAnagram("aabbcc", "abbbcc", 6, 6));
	}
	
	private static void printPairs(String[] list) {
		HashMap<Long, String> map = new HashMap<Long, String>();
		
		for(String str : list) {
			long hash = getHash(str);
			
			if(map.containsKey(hash)) {
				String other = map.get(hash);
				if(checkAnagram(str, other, str.length(), other.length())) {
					System.out.println(str + " | " + other);
				}
			} else {
				map.put(hash, str);
			}
		}
	}
	
	private static long getHash(String str) {
		long result = 0;
		int l = str.length();
		
		for(int i = l - 1; i >= 0; i--) {
			result += str.charAt(i);
			//result = 31 * result + str.charAt(i);
		}
		
		return result;
	}

	private static boolean checkAnagram(String str1, String str2, int m, int n) {
		if(m != n) {
			return false;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//put all characters in map and increment the count
		for(int i = 0; i < m; i++) {
			char c = str1.charAt(i);
			
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		//loop through each characters in second string and decrement the counter in hashmap if it contains the character
		for(int i = 0; i < n; i++) {
			char c = str2.charAt(i);
			
			if(map.containsKey(c)) {
				int v = map.get(c) - 1;
				
				//if the value becomes negative they are not anagram and return
				if(v < 0) {
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
