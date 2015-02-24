package com.learning.algorithm.array;

public class MaxApple {

	public static void main(String[] args) {
		int[][] grid = {
				{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
		};
		
		printMaxAppleCollected(grid);
	}

	private static void printMaxAppleCollected(int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		
		int[][] table = new int[N + 1][M + 1];
		
		table[0][0] = grid[0][0];
		
		//boundary
		for(int c = 1; c < M; c++) {
			table[0][c] = table[0][c - 1] + grid[0][c];
		}
		
		for(int r = 1; r < N; r++) {
			table[r][0] = table[r - 1][0] + grid[r][0];
		}
		
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < M; c++) {
				if(r - 1 >= 0 && c - 1 >= 0) {
					table[r][c] = Math.max(table[r - 1][c], table[r][c - 1]) + grid[r][c];
				}
			}
		}
		
		System.out.println("Maximum apple collected: " + table[N - 1][M - 1]);
	}

}
