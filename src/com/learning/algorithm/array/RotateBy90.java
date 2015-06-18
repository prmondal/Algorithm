package com.learning.algorithm.array;

import java.util.Scanner;

public class RotateBy90 {

	public static void main(String[] args) {
		char[][] grid = {
				{'a', 'a', 'a', 'a'},
				{'b', 'b', 'b', 'b'},
				{'c', 'c', 'c', 'c'},
				{'d', 'd', 'd', 'd'}
		};
		
		Scanner sc = new Scanner(System.in);
		print(grid);
		
		while(true) {
			String key = sc.next();
			
			if(key.equals("l")) {
				rotateAntiClockwiseBy90(grid);
				print(grid);
			} else if(key.equals("r")) {
				rotateClockwiseBy90(grid);
				print(grid);
			} else if(key.equals("e")) {
				return;
			}		
		}
	}

	static void rotateClockwiseBy90(char[][] grid) {
		int N = grid.length;
		
		//mirror about diagonal in place
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i; j++) {
				char t = grid[i][j];
				grid[i][j] = grid[N - 1 - j][N - 1 - i];
				grid[N - 1 - j][N - 1 - i] = t;
			}
		}
		
		//swap all rows
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < N; j++) {
				char t = grid[i][j];
				grid[i][j] = grid[N - 1 - i][j];
				grid[N - 1 - i][j] = t;
			}
		}
	}
	
	static void rotateAntiClockwiseBy90(char[][] grid) {
		int N = grid.length;
		
		//mirror about diagonal in place
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				char t = grid[i][j];
				grid[i][j] = grid[j][i];
				grid[j][i] = t;
			}
		}
		
		//swap all rows
		for(int i = N - 1; i >= N / 2; i--) {
			for(int j = 0; j < N; j++) {
				char t = grid[i][j];
				grid[i][j] = grid[N - 1 - i][j];
				grid[N - 1 - i][j] = t;
			}
		}
	}

	static void print(char[][] grid) {
		int N = grid.length;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
