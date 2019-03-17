package com.learning.algorithm.array;

public class PartitionArrayEqualSum {

	public static void main(String[] args) {
		//support positive integers
		int[] a = {2,3};//{3,2,1,1,1,2};
		System.out.println(partition(a));
	}
	
	//check whether the equal weight partition can be made
	static boolean partition(int[] a) {
		int L = a.length;
		
		int sum = 0;
		
		for(int i = 0; i < L; i++) {
			sum += a[i];
		}
		
		boolean[][] T = new boolean[sum / 2 + 1][L + 1];
		
		for(int i = 0; i < L + 1; i++) {
			T[0][i] = true;
		}
		
		for(int s = 1; s <= sum / 2; s++) {
			for(int n = 1; n <= L; n++) {
				if(a[n - 1] <= s) {
					T[s][n] = T[s][n - 1] || T[s - a[n - 1]][n - 1];
				} else 
					T[s][n] = T[s][n - 1];
			}
		}
		
		return T[sum / 2][L];
	}
}
