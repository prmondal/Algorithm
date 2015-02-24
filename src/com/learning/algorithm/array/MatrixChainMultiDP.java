package com.learning.algorithm.array;

public class MatrixChainMultiDP {

	public static void main(String[] args) {
		int[] a = {10, 20, 30};
		
		printMinCost(a, a.length);
	}

	private static void printMinCost(int[] a, int n) {
		int[][] table = new int[n][n];
		
		//for length one case
		for(int i = 1; i < n; i++) {
			//single matrix - cost 0
			table[i][i] = 0;
		}
		
		for(int l = 2; l <= n; l++) {
			for(int i = 1; i <= n - l; i++) {
				int j = i + l - 1;
				//set to max
				table[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; k++) {
					int cost = table[i][k] + table[k + 1][j] + a[i - 1] * a[k] * a[j];
					
					if(cost < table[i][j])
						table[i][j] = cost;
				}
			}
		}
		
		System.out.println("Minimum cost is " + table[1][n - 1]);
	}
}
