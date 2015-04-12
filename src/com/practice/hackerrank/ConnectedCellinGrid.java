package com.practice.hackerrank;

import java.util.Scanner;

public class ConnectedCellinGrid {
	static class Cell {
		static int totalCells = 0;
		static int maxCells = 0;
	};

	public static void main(String[] args) {
		/*int[][] grid = {
				{1, 1, 1, 0},
				{1, 0, 1, 0},
				{1, 0, 1, 1},
				{1, 0, 0, 0}
		};
		*/
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] grid = new int[m][n];
		
		for (int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		countMax(grid);
	}

	static void countMax(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					Cell.totalCells = 0;

					floodFill(grid, m, n, i, j, new Cell());

					if (Cell.totalCells > Cell.maxCells)
						Cell.maxCells = Cell.totalCells;
				}
			}
		}
		
		System.out.println(Cell.maxCells);
	}

	private static void floodFill(int[][] grid, int m, int n, int i, int j,
			Cell c) {
		if (i < m && i >= 0 && j < n && j >= 0 && grid[i][j] == 1) {
			grid[i][j] = 0;

			c.totalCells++;

			floodFill(grid, m, n, i, j + 1, c);
			floodFill(grid, m, n, i, j - 1, c);
			floodFill(grid, m, n, i + 1, j, c);
			floodFill(grid, m, n, i - 1, j, c);
			floodFill(grid, m, n, i - 1, j + 1, c);
			floodFill(grid, m, n, i - 1, j - 1, c);
			floodFill(grid, m, n, i + 1, j + 1, c);
			floodFill(grid, m, n, i + 1, j - 1, c);
		}
	}
}
