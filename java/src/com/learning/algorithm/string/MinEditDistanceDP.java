package com.learning.algorithm.string;

public class MinEditDistanceDP {

	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "cd";
		
		printMinEditDistance(str1, str2);
	}
	
	static void printMinEditDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		if(m == 0 && n == 0) {
			System.out.println(0);
			return;
		}
		
		if(m == 0) {
			System.out.println(n);
			return;
		} else if(n == 0){
			System.out.println(m);
			return;
		}
		
		int[][] T = new int[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 && j == 0)
					continue;
				
				if(i == 0) {
					T[i][j] = j;
					continue;
				}
				
				if(j == 0) {
					T[i][j] = i;
					continue;
				}
				
				T[i][j] = Math.min(Math.min(T[i - 1][j - 1] + ((s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1), T[i - 1][j] + 1), T[i][j - 1] + 1);
			}
		}
		
		System.out.println(T[m][n]);
	}

}
