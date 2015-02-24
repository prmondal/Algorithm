package com.learning.algorithm.array;

public class FindIsland {

	public static void main(String[] args) {
		int[][] M = new int[][] { 
				/*{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 }*/
				{1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		};

		System.out.println(countNumberIslands(M));
	}

	private static int countNumberIslands(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;

		int count = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					count++;

					matrix[i][j] = 0;

					toggleBits(matrix, i - 1, j);
					toggleBits(matrix, i + 1, j);
					toggleBits(matrix, i, j + 1);
					toggleBits(matrix, i, j - 1);
					
					toggleBits(matrix, i - 1, j - 1);
					toggleBits(matrix, i - 1, j + 1);
					toggleBits(matrix, i + 1, j - 1);
					toggleBits(matrix, i + 1, j + 1);
				}
			}
		}
		
		return count;
	}

	private static void toggleBits(int[][] matrix, int i, int j) {
		if(i < matrix.length && i >= 0 && j >= 0 && j < matrix[0].length && matrix[i][j] == 1) {
			matrix[i][j] = 0;
					
			toggleBits(matrix, i - 1, j);
			toggleBits(matrix, i + 1, j);
			toggleBits(matrix, i, j + 1);
			toggleBits(matrix, i, j - 1);
			
			toggleBits(matrix, i - 1, j - 1);
			toggleBits(matrix, i - 1, j + 1);
			toggleBits(matrix, i + 1, j - 1);
			toggleBits(matrix, i + 1, j + 1);
		}

		return;
	}
}
