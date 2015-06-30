package com.learning.algorithm.numerical;

public class BinomialCoeff {
	
	public static void main(String[] args) {
		System.out.println(bin(5,2));

	}
	
	static long bin(int N, int K) {
		if(N < K) return -1;
		long[][] table = new long[N + 1][N + 1];
		
		for(int n = 0; n <= N; n++) {
			table[n][0] = 1; 
		}
		
		for(int n = 0; n <= N; n++) {
			table[n][n] = 1; 
		}
		
		for(int n = 1; n <= N; n++) {
			for(int k = 1; k <= Math.min(n,  K); k++) {
				table[n][k] = table[n - 1][k - 1] + table[n - 1][k];
			}
		}
		
		return table[N][K];
	}

}
