package com.practice.hackerrank;

import java.util.Scanner;

public class StringMatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.valueOf(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			calculateSimilarity(sc.nextLine().toCharArray());
		}
	}

	private static void calculateSimilarity(char[] str) {
		if(str.length == 0) {
			return;
		}
		
		int totalCount = 0;
		
		//int l = str.length;
		
		//loop through each suffix and calculate prefix match with the original string
		/*for(int i = 0; i < l; i++) {
			String suffix = str.substring(i);
			
			totalCount += getSimilarity(str, suffix);
		}*/
		
		for (int i = 0; i < str.length; i++) {
	       // int count = 0;
	        
	        for (int j = i; j < str.length; j++) {
	            if (str[j - i] != str[j]) {
	                break;
	            }
	            
	            totalCount++;
	        }
	        
	        //totalCount += count;
	    }
		
		System.out.println(totalCount);
	}

	private static int getSimilarity(StringBuilder str, String suffix) {
		if(str.equals(suffix)) {
			return str.length();
		}
		
		int i = 0;
		int j = 0;
		
		int similarity = 0;
		
		int m = str.length();
		int n = suffix.length();
		
		while(i < m && j < n) {
			if(str.charAt(i) == suffix.charAt(j)) {
				similarity++;
				
				i++;
				j++;
			} else {
				break;
			}
		}
		
		return similarity;
	}
}
