package com.learning.algorithm.array;

public class LongestIncreasingSubSeqDP {

	public static void main(String[] args) {
		int[] s = {10,20,12,22,25};//{10, 22, 9, 33, 21, 50, 41, 60, 80, 1, 2, 3, 4 ,5 ,6 ,7 , 8};
		
		int maxLength = maxLen(s, s.length);
		
		System.out.println();
		System.out.println(maxLength);
	}

	private static int maxLen(int[] seq, int length) {
		int[] table = new int[length + 1];
		
		for(int i = 1; i <= length; i++) {
			int max = 0;
			
			for(int j = 0; j < i - 1; j++) {
				if(seq[j] <= seq[i - 1]) {
					if(max < table[j + 1]) {
						max = table[j + 1];
					}
				}
			}
			
			table[i] = max + 1;
			
			System.out.println("i: " + i + ", " + table[i]);
		}
		
		int result = 0;
		
		for(int i = 0; i <= length; i++) {
			if(table[i] > result) {
				result = table[i];
			}
		}
		
		return result;
	}
}
