package com.learning.algorithm.backtracking;

public class MazeSolver {

	public static void main(String[] args) {
		// maze size
		int N = 5;

		char[][] path = new char[N][N];
		
		//populate solution grid
		for(int i = 0; i < path.length; i++) {
			for(int j = 0; j < path[i].length; j++) {
				path[i][j] = '-';
			}
		}
		
		// maze grid
		int[][] grid = { 	{ 1, 1, 1, 1, 0 }, 
							{ 0, 0, 1, 1, 0 }, 
							{ 0, 0, 1, 0, 0 },
							{ 0, 0, 1, 0, 0 },
							{ 0, 0, 1, 1, 1 }
						};
		
		if (solveMaze(grid, path, 0, 0)) {
			System.out.println("Bunny escaped!");
			
			// print the path
			printArray(path);
		} else {
			System.out.println("Bunny trapped!");
		}
	}

	private static void printArray(char[][] path) {
		for(int i = 0; i < path.length; i++) {
			for(int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}

	private static boolean solveMaze(int[][] grid, char[][] path, int i, int j) {
		//base case
		if(i == grid.length - 1 && j == grid[0].length - 1) {
			path[i][j] = '*';
			
			return true;
		}
		
		if(path[i][j] == '*') {
			return false;
		}
		
		if (isSafe(grid, i, j)) {
			path[i][j] = '*';
			
			if(solveMaze(grid, path, i, j + 1)) {
				return true;
			}
			
			if(solveMaze(grid, path, i + 1, j)) {
				return true;
			}
			
			if(solveMaze(grid, path, i, j - 1)) {
				return true;
			}
			
			if(solveMaze(grid, path, i - 1, j)) {
				return true;
			}
			
			path[i][j] = '-';
		}
		
		return false;
	}

	private static boolean isSafe(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >=0 && j < grid[0].length && (grid[i][j] == 1);
	}
}
